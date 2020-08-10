package web.lab.Math;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MathTest {

    private Math math = new Math();


    // x^2 + y^2 <= r^2 | x >= 0, y >= 0
    @Test
    public void testFirstQuarterHit(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.0, 1.0, 3.0));
    }

    @Test
    public void testFirstQuarterMiss(){
        Assertions.assertEquals("Промах", math.checkPoint(1.0, 3.0, 3.0));
    }

    @Test
    public void testFirstQuarterAboveCircle(){
        Assertions.assertEquals("Промах", math.checkPoint(0.00001, 1.5, 3.0));
    }

    @Test
    public void testFirstQuarterUnderCircle(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, 1.49999, 3.0));
    }

    @Test
    public void testFirstQuarterOnCircle(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.0, 1.118, 3.0));
    }

    // -1.5 <= x <= 0, 0 <= y <= 3

    @Test
    public void testSecondQuarterHit(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.0, 1.5, 3.0));
    }

    @Test
    public void testSecondQuarterMiss(){
        Assertions.assertEquals("Промах", math.checkPoint(-3.0, 3.0, 3.0));
    }

    @Test
    public void testSecondQuarterAboveSquare(){
        Assertions.assertEquals("Промах", math.checkPoint(-1.5000000001, 1.5, 3.0));
    }

    @Test
    public void testSecondQuarterUnderSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.0, 2.999999, 3.0));
    }

    @Test
    public void testSecondQuarterOnSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.5, 3.0, 3.0));
    }

    // y >= 2x - R | x >= 0 y<= 0

    @Test
    public void testFourthQuarterHit(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.5, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterMiss(){
        Assertions.assertEquals("Промах", math.checkPoint(2.0, -2.0, 3.0));
    }

    @Test
    public void testFourthQuarterAboveTriangle(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.63, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterUnderTriangle(){
        Assertions.assertEquals("Промах", math.checkPoint(1.38, -0.5, 3.0));
    }

    @Test
    public void testFourthQuarterOnTriangle(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.0, -1.0, 3.0));
    }

    @Test
    public void testCentre(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, 0.0, 3.0));
    }


}
