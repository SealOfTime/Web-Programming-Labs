package ru.sealoftime.web.thirdlab;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@Data
@RequestScoped
@ManagedBean(name= "areaController", eager = true)
public class AreaController implements Serializable {

    public String goToWelcomePage(){
        return "index";
    }

}
