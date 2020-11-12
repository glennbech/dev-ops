package kristinaia.com.devopsexam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping(path="/student")
    public String student(){
        return "Hei nå er vi igang igjen.";
    }


}
