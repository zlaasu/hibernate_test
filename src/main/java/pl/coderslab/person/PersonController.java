package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/add")
    public String add() {
        return "person/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam String login,
                      @RequestParam String password,
                      @RequestParam String email) {
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);

        personService.save(person);

        return "Person added, ID = " + person.getId();
    }
}
