package ru.sealoftime.web.thirdlab;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Data
@SessionScoped
@ManagedBean(name= "indexController", eager = true)
public class IndexController implements Serializable {

    public String goToMainPage(){
        return "area";
    }
}
