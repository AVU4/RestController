package web.lab.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private String nickname;

    private String password;

    public User(){
    }

    public User(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
    }
}
