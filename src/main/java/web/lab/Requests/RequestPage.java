package web.lab.Requests;

import lombok.Data;

@Data
public class RequestPage {

    private int page;


    public RequestPage(int page){
        this.page = page;
    }
}
