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
        return CreateMethodResponse(savedPerson, "Person saved successfuly Id: ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Verifica a Existencia do id
    public Person VerifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(()->new PersonNotFoundException(id));
    }

    //Encontra a instância do ID
    public PersonDTO findById(Long id) throws PersonNotFoundException {
         Person person = VerifyIfExists(id);
        return personMapper.toDTO(person);
    }
    //Deleta a instância do ID
    public void deleteById(Long id) throws PersonNotFoundException {
        VerifyIfExists(id);
        personRepository.deleteById(id);
    }


    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        VerifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatePerson = personRepository.save(personToUpdate);
        return CreateMethodResponse(updatePerson, "person updated successfuly Id:" );
    }


    private MessageResponseDTO CreateMethodResponse(Person savedPerson,String s) {
        return MessageResponseDTO
                .builder()
                .Message(s + savedPerson.getId() + " "+ savedPerson.getFirst_name() + " "+ savedPerson.getLast_name())
                .build();
    }
}
