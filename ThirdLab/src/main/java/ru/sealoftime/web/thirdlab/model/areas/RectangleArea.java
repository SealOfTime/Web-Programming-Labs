package ru.sealoftime.web.thirdlab.model.areas;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sealoftime.web.thirdlab.model.Point;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RectangleArea implements Area{
    Point p1;
    Point p2;

    @Override
    public boolean checkIfContains(Point p) {
        return  p1.getX() <= p.getX() &&
                p2.getX() >= p.getX() &&
                p1.getY() >= p.getY() &&
                p2.getY() <= p.getY();
    }

    @Override
    public void scale(double scale) {
        this.p1.mul(scale);
        this.p2.mul(scale);
    }

}
