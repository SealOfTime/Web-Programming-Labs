package ru.sealoftime.web.thirdlab;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@Data
@RequestScoped
@ManagedBean(name= "areaController", eager = true)
public class AreaController implements Serializable {
    private final List<Double> xValues = List.of(-2d, -1.5d, -1d, -0.5d, 0d, 0.5d, 1d, 1.5d, 2d);
    private Double x;

    private final Double yMin = -5d;
    private final Double yMax = 3d;
    private Double y;

    //private final List<Double> rValues = List.of(1d, 2d, 3d, 4d, 5d);
    private final Double rMin = 2d;
    private final Double rMax = 5d;
    private int r;

    public void test(){
        System.out.println("x: " + x + "\n" + "y: " + y + "\n" + "r: " + r);
    }
    public String goToWelcomePage(){
        return "index";
    }

}
