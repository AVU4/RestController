package web.lab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.lab.Requests.RequestShooting;
import web.lab.Responses.ResponsePoints;
import web.lab.Responses.ResponseShooting;

@Controller
public class MainController {

    @PostMapping("points")
    public ResponseShooting addPoint(RequestShooting request){
        System.out.println(request.getXCoordinate());
        System.out.println(request.getYCoordinate());
        System.out.println(request.getRParameter());
        return new ResponseShooting();
    }

    @GetMapping("points")
    public ResponsePoints getPoints(){
        return new ResponsePoints();
    }
}
