package web.lab.Math;

import org.springframework.stereotype.Service;

@Service
public class Math {

    public String checkPoint(Double x, Double y, Double r){
        if ((x >= -r/2 && x <= 0 && y >= 0 && y <= r) || (x*x + y*y <= r*r/4 && x >= 0 && y >= 0) || (y <= 2 * x - r && x >= 0 && y <= 0)){
            return "Попадение";
        }else
            return "Промах";
    }
}
