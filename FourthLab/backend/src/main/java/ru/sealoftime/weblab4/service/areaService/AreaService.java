package ru.sealoftime.weblab4.service.areaService;

import ru.sealoftime.weblab4.model.dto.PointSubmitDTO;
import ru.sealoftime.weblab4.model.entity.Point;

public interface AreaService {
    Point checkPoint(PointSubmitDTO dto);
}
