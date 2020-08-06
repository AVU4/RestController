package web.lab.Requests;

import lombok.Data;

@Data
public class RequestShooting {

    private String x;
    private String y;
    private String r;

    public RequestShooting(String x, String y, String r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
