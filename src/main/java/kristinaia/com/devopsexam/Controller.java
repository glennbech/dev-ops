package kristinaia.com.devopsexam;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;



@RestController
public class Controller {


    private MeterRegistry meterRegistry;

    @Autowired
    private PersonRepo personRepo;

   private static final Logger LOG = LoggerFactory.getLogger(Controller.class.getName());


    @Autowired
    PersonService personService;

    @GetMapping(path = "/")
    public String home() {
        return "not the HOMEPAGE";
    }



    @GetMapping(path = "/home")
    public String homepage() {
       LOG.info("This is the homepage not the other one");
        return "HOMEPAGE";
    }

    @GetMapping(path = "/person")
    public Person getOnePerson() {
        LOG.info("Testing logger");
        return new Person("Hans", 55, "Hans@hotmail.com" );
    }


    @GetMapping(path = "/persons")
    public List<Person> getPersons() {

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Tor", 78, "tor@gmail.com"));
        persons.add(new Person("Abdui", 88, "abdui@gmail.com"));
        persons.add(new Person("Silka", 8, "silka@gmail.com"));
        persons.add(new Person("TorArne", 58, "torarne@gmail.com"));

        return persons;
    }

    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @PostMapping("/persons")
    private int savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return person.getId();
    }


}

