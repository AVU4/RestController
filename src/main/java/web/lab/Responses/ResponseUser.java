package web.lab.Responses;

import lombok.Data;

@Data
public class ResponseUser {

    private String message;
    private String error;

    public ResponseUser(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
