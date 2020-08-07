package web.lab.Requests;

import lombok.Data;

@Data
public class RequestUser {

    private String nickname;

    private String password;

    public RequestUser(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }
}
