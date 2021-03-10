package ru.sealoftime.weblab4.service.entityServices.pointService;

import ru.sealoftime.weblab4.model.entity.Point;

import java.util.List;

public interface PointService {

    List<Point> getAllPoints();
    List<Point> getAllPoints(String username);

    Point addNewPoint(Point entity);

    Boolean deletePoint(Integer pointId);

}
