package web.lab.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import web.lab.Entities.Point;
import web.lab.Math.Math;
import web.lab.Requests.RequestShooting;
import web.lab.Responses.ResponseShooting;
import web.lab.Services.PointService;
import web.lab.Validation.PointValidation;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.List;

@RestController
public class MainController {

    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

    web.lab.MBeans.Point point = new web.lab.MBeans.Point();

    ObjectName name;

    {
        try {
            name = new ObjectName("web.lab.MBeans:type=Point");
        }catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }


    Math math;


    PointValidation pointValidation;


    PointService pointService;

    public MainController(Math math, PointValidation pointValidation, PointService pointService) {
        this.math = math;
        this.pointValidation = pointValidation;
        this.pointService = pointService;
        try {
            mbs.registerMBean(point, name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/points")
    public @ResponseBody  ResponseShooting addPoint( @RequestBody  RequestShooting request) {



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
            point.addPoint(result);
            point.check(point.getNumberHits(), point.getNumberPoints());
            Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
            String nickname = authentication.getName();
            Point point = new Point(nickname, X, Y, R, result);
            pointService.addPoint(point);
            return new ResponseShooting(result, "NO");
        }else{
            return new ResponseShooting(validationResult, "YES");
        }

    }

    @GetMapping("/points")
    public List<Point> getPoints(){
        //Нужно сделать авторизацию, чтобы получать имя пользователя
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        List<Point> points = pointService.findAllByNickname(authentication.getName());
        return points;
    }
}
