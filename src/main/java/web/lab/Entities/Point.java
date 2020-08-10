package web.lab.Entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "points")
@Entity
@Data
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Double x;
    private Double y;
    private Double r;
    private String result;

    public Point() {
    }

    public Point(String nickname, Double x,  Double y, Double r, String result) {
        this.nickname = nickname;
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public Point(long id, String nickname,  Double x, Double y, Double r, String result) {
        this.nickname = nickname;
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }


    @Override
    public String toString() {
        return "{ x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result='" + result + '\'' +
                '}';
    }
}
