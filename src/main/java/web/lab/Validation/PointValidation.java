package web.lab.Validation;

import org.springframework.stereotype.Service;

@Service
public class PointValidation {

    public String validate(String x, String y, String r){
        try{

            Double X = Double.parseDouble(x);
            if (X != -4 && X != -3 && X != -2 && X != -1 && X != 0 && X != 1 && X != 2 && X != 3 && X != 4){
                return "Неверное значение для X. Значение X должно равняться одному из значений" +
                        "{-4, -3, -2, -1, 0, 1, 2, 3, 4}";
            }

            Double Y = Double.parseDouble(y);
            if ( Y < -3.0 || Y > 5.0)
                return "Неверное значение для Y. -3 <= Y <= 5 - верный диапозон";

            Double R = Double.parseDouble(r);
            if (R != 1 && R != 2 && R != 3 && R != 4)
                return "Неверное значение для R. Значение R должно равняться одному из значений" +
                        "{1, 2, 3, 4}";
            return "OK";
        }catch (NumberFormatException e){
            return "Одно или несколько значение не являются числами.";
        }catch (NullPointerException ex){
            return "Одно или несколько значений не введены.";
        }

    }
}
