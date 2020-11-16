package kristinaia.com.devopsexam;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//import java.util.logging.Logger;


@RestController
public class Controller {


    private MeterRegistry meterRegistry;

   private static final Logger LOG = LoggerFactory.getLogger(Controller.class.getName());


    @Autowired
    PersonService personService;

    @GetMapping(path = "/")
    public String home() {
        LOG.info("Testing logger");
        return "WELCOME TO THE HOMEPAGE";
    }

    @GetMapping(path = "/home")
    public String homepage() {
       LOG.info("This is the homepage not the other one");
        return "Welcome again to the official homepage";
    }

    @GetMapping(path = "/second")
    public String next() {
        return "Here you have nothing.......";
    }

    @GetMapping(path = "/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
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

  /*  @PostMapping(path = "/prs", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody Person prs) {
        meterRegistry.counter("prscount2", "name", prs.getName()).increment();
        meterRegistry.counter("prscount3", "email", prs.getEmail()).increment();
        meterRegistry.gauge("prscount4", 3);
    } */
}

