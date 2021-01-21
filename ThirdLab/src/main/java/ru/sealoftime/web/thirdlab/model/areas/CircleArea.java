package ru.sealoftime.web.thirdlab.model.areas;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sealoftime.web.thirdlab.model.Point;


@Data
@AllArgsConstructor
public class CircleArea implements Area {
    private double radius;

    @Override
    public void scale(double scale) {
        this.radius = radius*scale;
    }

    @Override
    public boolean checkIfContains(Point p) {
        return ( p.getX()*p.getX() + p.getY()*p.getY() )<= this.radius*this.radius;
    }
}
