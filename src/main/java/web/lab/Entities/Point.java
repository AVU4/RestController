package web.lab.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "points")
@Entity
@Data
public class Point {

    @Id
    @GeneratedValue
    private long id;
    private Double x;
    private Double y;
    private Double r;
    private String result;

    public Point() {
    }

    public Point(Double x, Double y, Double r, String result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public Point(long id, Double x, Double y, Double r, String result) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }




}
