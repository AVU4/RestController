package web.lab.Responses;


import lombok.Data;

@Data
public class ResponseShooting {

    private String result;
    private String error;

    public ResponseShooting(String result, String error){
        this.error = error;
        this.result = result;
    }
}
