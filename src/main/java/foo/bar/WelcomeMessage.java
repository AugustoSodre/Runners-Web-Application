package foo.bar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class WelcomeMessage {

    public void printWelcomeMessage(String message){
        System.out.println(message);
    }
}
