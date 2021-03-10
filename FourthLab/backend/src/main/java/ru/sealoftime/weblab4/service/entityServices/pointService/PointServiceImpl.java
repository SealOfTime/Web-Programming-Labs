package ru.sealoftime.weblab4.service.entityServices.pointService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sealoftime.weblab4.model.dto.PointSubmitDTO;
import ru.sealoftime.weblab4.model.entity.Point;
import ru.sealoftime.weblab4.model.repository.PointRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
@Log4j2
public class PointServiceImpl implements PointService {
    @Autowired
    private PointRepository pointRepository;

    @Override
    public List<Point> getAllPoints() {
        var result = new LinkedList<Point>();
        var data = pointRepository.findAll();
        data.forEach(result::add);
        return result;
    }

    @Override
    public List<Point> getAllPoints(String username) {
        var result = new LinkedList<Point>();
        var data = pointRepository.findAllByUser_Username(username);
        data.forEach(result::add);
        return result;
    }

    @Override
    public Point addNewPoint(Point entity) {
        return pointRepository.save(entity);
    }

    @Override
    public Boolean deletePoint(Integer pointId) {
        return null;
    }
}
