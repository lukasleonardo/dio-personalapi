package projeto.sistemadecadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projeto.sistemadecadastro.Repository.PersonRepository;
import projeto.sistemadecadastro.dto.MessageResponseDTO;
import projeto.sistemadecadastro.entity.Person;

@Service
public class PersonService {
    PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPersona(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .Message("Saved person successfuly inserted to the database "+"Id: "+ savedPerson.getId() +" "+ savedPerson.getFirst_name() +" "+ savedPerson.getLast_name())
                .build();
    }
}
