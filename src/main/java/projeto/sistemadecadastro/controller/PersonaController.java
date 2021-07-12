package projeto.sistemadecadastro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projeto.sistemadecadastro.dto.MessageResponseDTO;
import projeto.sistemadecadastro.entity.Person;
import projeto.sistemadecadastro.service.PersonService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private PersonService personService;

    @Autowired
    public PersonaController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPersona(@RequestBody Person person) {
        return personService.createPersona(person);
    }
}
