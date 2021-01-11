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
    public boolean checkIfIn(Point p) {
        return isPointInTriangle(p, p1, p2, p3);
    }

    @Override
    public void scale(double scale) {
        this.p1.mul(scale);
        this.p2.mul(scale);
        this.p3.mul(scale);
    }

    private double calcTriArea(Point v1, Point v2, Point v3) {
        double det = ((v1.getX() - v3.getX()) * (v2.getY() - v3.getY())) - ((v2.getX() - v3.getX()) * (v1.getY() - v3.getY()));
        return (det / 2.0d);
    }

    //Честно украдено со StackOverflow
    private boolean isPointInTriangle(Point point, Point v1, Point v2, Point v3) {
        double totalArea = calcTriArea(v1, v2, v3);
        double area1 = calcTriArea(point, v2, v3);
        double area2 = calcTriArea(point, v1, v3);
        double area3 = calcTriArea(point, v1, v2);

        return !((area1 + area2 + area3) > totalArea);
    }
}
