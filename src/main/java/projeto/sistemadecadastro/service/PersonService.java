package projeto.sistemadecadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.sistemadecadastro.exception.PersonNotFoundException;
import projeto.sistemadecadastro.repository.PersonRepository;
import projeto.sistemadecadastro.dto.requests.PersonDTO;
import projeto.sistemadecadastro.dto.response.MessageResponseDTO;
import projeto.sistemadecadastro.entity.Person;
import projeto.sistemadecadastro.dto.mapper.PersonMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPersona(PersonDTO personDTO){
       Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .Message("Saved person successfuly inserted to the database "+"Id: "+ savedPerson.getId() +" "+ savedPerson.getFirst_name() +" "+ savedPerson.getLast_name())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        return personMapper.toDTO(optionalPerson.get());
    }


}
