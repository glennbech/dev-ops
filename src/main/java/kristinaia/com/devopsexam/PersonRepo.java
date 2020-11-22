package kristinaia.com.devopsexam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer> {

    public List<Person> findByName(String name);

}
