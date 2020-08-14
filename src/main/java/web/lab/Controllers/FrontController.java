package web.lab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/")
    public String start(){
        return "/index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "/index.html";
    }


}
