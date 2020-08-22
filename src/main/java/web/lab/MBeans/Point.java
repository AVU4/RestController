package web.lab.MBeans;



public class Point
    implements PointMBean {

    private int numberPoints;
    private int numberHits;
    private double percentage;

    @Override
    public int getNumberPoints() {
        return numberPoints;
    }

    @Override
    public int getNumberHits() {
        return numberHits;
    }

    @Override
    public void addPoint(String result) {
        numberPoints ++;
        if (result.equals("Попадение")) numberHits ++;
    }

    @Override
    public void check(int numberHits, int numberPoints){
        percentage = (double) numberHits / numberPoints;
    }



    @Override
    public double getPercentageOfHit() {
        return percentage;
    }
}
