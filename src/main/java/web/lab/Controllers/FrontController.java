package web.lab.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController implements ErrorController {

    @GetMapping("/")
    public String start(){
        return "/index.html";
    }

    @GetMapping("/login")
    public String signIn(){
        return "/index.html";
    }

    @GetMapping("/registration")
    public String signUp(){
        return "/index.html";
    }

    @GetMapping("/main")
    public String main(){
        return "/index.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
