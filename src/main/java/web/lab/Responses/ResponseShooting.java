package web.lab.Responses;


import lombok.Data;

@Data
public class ResponseShooting {

    private String result;

    public ResponseShooting(String result){
        this.result = result;
    }
}
