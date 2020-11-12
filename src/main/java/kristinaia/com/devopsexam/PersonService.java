package kristinaia.com.devopsexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public List<Person> getAllPersons(){
        List<Person> persons = new ArrayList<Person>();
        personRepo.findAll().forEach(person -> persons.add(person));
        return persons;
    }

    public Person getPersonById(int id){
        return personRepo.findById(id).get();
    }

    public void saveOrUpdate(Person person){
        personRepo.save(person);
    }

    public void delete(int id){
        personRepo.deleteById(id);
    }

}
