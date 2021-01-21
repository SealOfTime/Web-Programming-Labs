package ru.sealoftime.web.secondlab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sealoftime.web.secondlab.constraints.DoubleInList;
import ru.sealoftime.web.secondlab.constraints.DoubleMinMax;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Point implements Serializable {
    private static final long serialVersionUID = 0;

    public void mul(double scale){
        this.x = this.x*scale;
        this.y = this.y*scale;
    }

    @DoubleMinMax(min=-2, max= 2)
    double x;

    @DoubleMinMax(min=-3, max=3)
    double y;

}
