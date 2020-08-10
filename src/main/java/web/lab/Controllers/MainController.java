package web.lab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.lab.Entities.Point;
import web.lab.Math.Math;
import web.lab.Requests.RequestShooting;
import web.lab.Responses.ResponsePoints;
import web.lab.Responses.ResponseShooting;
import web.lab.Services.PointService;
import web.lab.Validation.PointValidation;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    Math math;

    @Autowired
    PointValidation pointValidation;

    @Autowired
    PointService pointService;

    @PostMapping("/points")
    public @ResponseBody  ResponseShooting addPoint( @RequestBody  RequestShooting request){

        //Нужна авторизация, чтобы добавить имя пользователя к точке
        String x = request.getX();
        String y = request.getY();
        String r = request.getR();
        String validationResult = pointValidation.validate(x, y, r);
        if (validationResult.equals("OK")){
            Double X = Double.parseDouble(x);
            Double Y = Double.parseDouble(y);
            Double R = Double.parseDouble(r);
            String result = math.checkPoint(X, Y, R);
            Point point = new Point(X, Y, R, result);
            pointService.addPoint(point);
            return new ResponseShooting(result, "NO");
        }else{
            return new ResponseShooting(validationResult, "YES");
        }

    }

    @GetMapping("/points")
    public ResponsePoints getPoints(){
        //Нужно сделать авторизацию, чтобы получать имя пользователя
        List<Point> points = pointService.findAllByNickname();
        return new ResponsePoints(Arrays.toString(points.toArray()));
    }
}
