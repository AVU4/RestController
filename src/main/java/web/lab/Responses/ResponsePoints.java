package web.lab.Responses;

import lombok.Data;

@Data
public class ResponsePoints {

    private String result;

    public ResponsePoints(String result){
        this.result = result;
    }
}
