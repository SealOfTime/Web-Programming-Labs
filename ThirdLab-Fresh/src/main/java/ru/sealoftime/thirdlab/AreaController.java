package ru.sealoftime.thirdlab;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import ru.sealoftime.thirdlab.constraints.DoubleMinMax;

import java.util.List;

public class AreaController {
    private History history;

    private final List<Double> xValues = List.of(-2d, -1.5d, -1d, -0.5d, 0d, 0.5d, 1d, 1.5d, 2d);
    public List<Double> getXValues(){ return xValues; }

    @DoubleMinMax(min=-2d, max=2d)
    private Double x;
    public Double getX() { return x; }
    public void setX(Double x) { this.x = x; }

    @DoubleMinMax(min=-5d, max=3d)
    private Double y;
    public Double getY() { return y; }
    public void setY(Double y) { this.y = y; }

    @DoubleMinMax(min=2d, max=5d)
    private Double r;
    public Double getR(){ return this.r; }
    public void setR(Double r){ this.r = r; }

    public void test(){
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        point.setR(r);
        boolean inside = false;
        if(x >= 0){
            if(y>=0)
                if ((x * x + y * y) <= (r * r / 4d))
                    inside = true;
        }else{
            if(y<0) {
                if (x >= -r / 2d && y > -r)
                    inside = true;
            }else
                inside = isPointInTriangle(point, new Point(0d, 0d), new Point(-r/2d, 0d), new Point(0d, r/2d));
        }
        point.setInside(inside);
        history.push(point);
    }

    public void setHistory(History history) {
        this.history=history;
    }

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
