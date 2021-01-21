package ru.sealoftime.web.thirdlab.services;

import ru.sealoftime.web.thirdlab.model.Point;
import ru.sealoftime.web.thirdlab.model.areas.*;

import javax.ejb.Stateless;

@Stateless
public class AreaService {
    public Area constructArea(double scale){
        var area = new CombinedArea(
                new IntersectedArea(
                        new CircleArea(0.5),
                        new RectangleArea(
                                new Point(0, 0),
                                new Point(0.5, -0.5))),
                new TriangleArea(
                        new Point(0, 0.5),
                        new Point(0,0),
                        new Point(-1, 0)),
                new RectangleArea(
                        new Point(-1, 0),
                        new Point(0, -1)));
        area.scale(scale);
        return area;
    }

}
