package one.digitalinnovation.personapi.controller;


import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController{

private PersonRepository personRepository;

public  PersonController(PersonRepository personRepository){
    this.personRepository = personRepository;
}


    @PostMapping
    public MessageResponseDTO createPerson( @RequestBody Person person){
       Person savedPerson = personRepository.save(person);
       return MessageResponseDTO
               .builder()
               .message("Create Perrson whit ID" + savedPerson.getId())
               .build();
    }
}
