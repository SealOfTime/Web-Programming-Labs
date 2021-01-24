package ru.sealoftime.web.secondlab.services;

import ru.sealoftime.web.secondlab.model.HistoryEntry;
import ru.sealoftime.web.secondlab.model.Point;
import ru.sealoftime.web.secondlab.model.areas.Area;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Random;

@Stateless
public class PointsService {
    private @EJB
    AreaService areaService;

    public HistoryEntry checkIfPointInAreaOfRadius(Point point, Double radius){
        var area = areaService.constructArea(radius);
        return new HistoryEntry(
                point.getX(), point.getY(), radius,
                generateColor(), area.checkIfContains(point));
    }

    private String generateColor(){
        Random r = new Random();
        int randColor = r.nextInt(0xffffff + 1);
        return String.format("#%06x", randColor);
    }
}
