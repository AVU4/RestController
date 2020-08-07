package web.lab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.lab.Entities.Point;
import web.lab.Math.Math;
import web.lab.Requests.RequestShooting;
import web.lab.Responses.ResponsePoints;
import web.lab.Responses.ResponseShooting;
import web.lab.Services.PointService;

@RestController
public class MainController {

    @Autowired
    Math math;

    @Autowired
    PointService pointService;

    @PostMapping("/points")
    public @ResponseBody  ResponseShooting addPoint( @RequestBody  RequestShooting request){

        //Валидация
        String result = math.checkPoint(Double.parseDouble(request.getX()), Double.parseDouble(request.getY()), Double.parseDouble(request.getR()));
        Point point = new Point(Double.parseDouble(request.getX()), Double.parseDouble(request.getY()), Double.parseDouble(request.getR()), result);
        pointService.addPoint(point);
        return new ResponseShooting(result);
    }

    @GetMapping("points")
    public ResponsePoints getPoints(){
        return new ResponsePoints();
    }
}
