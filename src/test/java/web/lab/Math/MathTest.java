package web.lab.Math;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.event.TransactionalEventListener;


public class MathTest {

    private Math math = new Math();


    // x^2 + y^2 <= r^2 | x >= 0, y >= 0
    @Test
    public void testFirstQuarterHit(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.0, 1.0, 3.0));
    }

    @Test
    public void testFirstQuarterMiss(){
        Assertions.assertEquals("Промах", math.checkPoint(2.0, 2.0, 3.0));
    }

    @Test
    public void testFirstQuarterAboveCircle(){
        Assertions.assertEquals("Промах", math.checkPoint(1.02, 1.1000001, 3.0));
    }

    @Test
    public void testFirstQuarterUnderCircle(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.02, 1.08, 3.0));
    }

    @Test
    public void testFirstQuarterOnCircle(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.02, 1.09, 3.0));
    }

    @Test
    public void testFirstQuarterTheBiggestX(){
        Assertions.assertEquals("Попадение", math.checkPoint(1.5, 0.0, 3.0));
    }

    @Test
    public void testFirstQuarterTheBiggestY(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, 1.5, 3.0));
    }

    @Test
    public void testFirstQuarterLeftSideOfY(){
        Assertions.assertEquals("Попадение",math.checkPoint(-0.000001, 1.0, 3.0));
    }

    @Test
    public void testFirstQuarterRightSideOfY(){
        Assertions.assertEquals("Попадение",math.checkPoint(0.000001, 1.0, 3.0));
    }

    @Test
    public void testFirstQuarterY(){
        Assertions.assertEquals("Попадение",math.checkPoint(0.0, 1.0, 3.0));
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
    public void testSecondQuarterLeftSquare(){
        Assertions.assertEquals("Промах", math.checkPoint(-1.5000000001, 1.5, 3.0));
    }

    @Test
    public void testSecondQuarterRightSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.499999, 1.5, 3.0));
    }

    @Test
    public void testSecondQuarterAboveSquare(){
        Assertions.assertEquals("Промах", math.checkPoint(-1.0, 3.0000001, 3.0));
    }
    @Test
    public void testSecondQuarterUnderSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.0, 2.999999, 3.0));
    }

    @Test
    public void testSecondQuarterOnSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.5, 3.0, 3.0));
    }

    @Test
    public void testSecondQuarterOnLeftSideOfSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.5, 1.0, 3.0));
    }

    @Test
    public void testSecondQuarterOnUpSideOfSquare(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.0, 3.0, 3.0));
    }

    @Test
    public void testSecondQuarterTheLowestX(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.5, 0.0, 3.0));
    }

    @Test
    public void testSecondQuarterTheBiggestY(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, 3.0, 3.0));
    }

    @Test
    public void testSecondQuarterDownSideOfX(){
        Assertions.assertEquals("Промах", math.checkPoint(-1.0, -0.000001, 3.0));
    }

    @Test
    public void testSecondQuarterUpSideOfX(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.0, 0.000001, 3.0));
    }

    @Test
    public void testSecondQuarterX(){
        Assertions.assertEquals("Попадение", math.checkPoint(-1.0, 0.0, 3.0));
    }

    @Test
    public void testSecondQuarterLeftSideOfY(){
        Assertions.assertEquals("Попадение", math.checkPoint(-0.000001, 2.0, 3.0));
    }

    @Test
    public void testSecondQuarterRightSideOfY(){
        Assertions.assertEquals("Промах", math.checkPoint(0.000001, 2.0, 3.0));
    }
    @Test
    public void testSecondQuarterY(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, 2.0, 3.0));
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
        Assertions.assertEquals("Промах", math.checkPoint(0.8, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterOnTriangle(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.7, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterTheLowestY(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, -3.0, 3.0));
    }

    @Test
    public void testFourthQuarterLeftSideOfY(){
        Assertions.assertEquals("Промах", math.checkPoint(-0.00001, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterRightSideOfY(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.000001, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterY(){
        Assertions.assertEquals("Попадение",math.checkPoint(0.0, -1.5, 3.0));
    }

    @Test
    public void testFourthQuarterUpSideOfX(){
        Assertions.assertEquals("Попадение",math.checkPoint(1.0, 0.000001, 3.0));
    }

    @Test
    public void testFourthQuarterDownSideOfX(){
        Assertions.assertEquals("Попадение",math.checkPoint(1.0, -0.000001, 3.0));
    }

    @Test
    public void testFourthQuarterX(){
        Assertions.assertEquals("Попадение",math.checkPoint(1.0, 0.0, 3.0));
    }
    //
    @Test
    public void testCentre(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.0, 0.0, 3.0));
    }

    @Test
    public void testCentreFirstQuarter(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.00001, 0.00001, 3.0));
    }

    @Test
    public void testCentreSecondQuarter(){
        Assertions.assertEquals("Попадение", math.checkPoint(-0.00001, 0.00001, 3.0));
    }

    @Test
    public void testCentreThirdQuarter(){
        Assertions.assertEquals("Промах", math.checkPoint(-0.00001, -0.00001, 3.0));
    }

    @Test
    public void testCentreFourthQuarter(){
        Assertions.assertEquals("Попадение", math.checkPoint(0.00001, -0.00001, 3.0));
    }
}
