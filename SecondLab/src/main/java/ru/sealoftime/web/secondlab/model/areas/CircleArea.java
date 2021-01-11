package ru.sealoftime.web.secondlab.model.areas;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.sealoftime.web.secondlab.model.Point;


@Data
@AllArgsConstructor
public class CircleArea implements Area {
    private double radius;

    @Override
    public void scale(double scale) {
        this.radius = radius*scale;
    }

    @Override
    public boolean checkIfIn(Point p) {
        return ( p.getX()*p.getX() + p.getY()*p.getY() )<= this.radius*this.radius;
    }
}
