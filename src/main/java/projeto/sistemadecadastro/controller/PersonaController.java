package projeto.sistemadecadastro.controller;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projeto.sistemadecadastro.dto.requests.PersonDTO;
import projeto.sistemadecadastro.dto.response.MessageResponseDTO;
import projeto.sistemadecadastro.entity.Person;
import projeto.sistemadecadastro.exception.PersonNotFoundException;
import projeto.sistemadecadastro.service.PersonService;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPersona(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPersona(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id,personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id)throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id)throws PersonNotFoundException {
        personService.deleteById(id);
    }




}
