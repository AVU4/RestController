package web.lab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.lab.Math.Math;
import web.lab.Requests.RequestShooting;
import web.lab.Responses.ResponsePoints;
import web.lab.Responses.ResponseShooting;

@RestController
public class MainController {

    @Autowired
    Math math;

    @PostMapping("/points")
    public @ResponseBody  ResponseShooting addPoint( @RequestBody  RequestShooting request){
        return new ResponseShooting(math.checkPoint(Double.parseDouble(request.getX()), Double.parseDouble(request.getY()), Double.parseDouble(request.getR())));
    }

    @GetMapping("points")
    public ResponsePoints getPoints(){
        return new ResponsePoints();
    }
}
