package ru.sealoftime.web.secondlab.model.areas;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sealoftime.web.secondlab.model.Point;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TriangleArea implements Area{
    Point p1;
    Point p2;
    Point p3;

    @Override
    public boolean checkIfContains(Point p) {
        return isPointInTriangle(p, p1, p2, p3);
    }

    @Override
    public void scale(double scale) {
        this.p1.mul(scale);
        this.p2.mul(scale);
        this.p3.mul(scale);
    }


    //Честно украдено со StackOverflow
    private boolean isPointInTriangle(Point point, Point v1, Point v2, Point v3) {
        double area1 = sign(point, v1, v2);
        double area2 = sign(point, v2, v3);
        double area3 = sign(point, v3, v1);
        boolean hasNeg = (area1 < 0) || (area2 < 0) || (area3 < 0);
        boolean hasPos = (area1 > 0) || (area2 > 0) || (area3 > 0);

        return !(hasNeg && hasPos);
    }

    private double sign (Point p1, Point p2, Point p3)
    {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }
}
