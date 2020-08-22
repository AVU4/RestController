package web.lab.MBeans;

public interface PointMBean {

    int getNumberPoints();
    void addPoint(String result);
    double getPercentageOfHit();
    int getNumberHits();
    void check(int numberHits, int numberPoints);
}
