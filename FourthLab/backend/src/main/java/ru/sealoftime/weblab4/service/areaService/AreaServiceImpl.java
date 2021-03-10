package ru.sealoftime.weblab4.service.areaService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.sealoftime.weblab4.model.dto.PointSubmitDTO;
import ru.sealoftime.weblab4.model.entity.Point;

import java.util.Random;

@Component
public class AreaServiceImpl implements AreaService{

    @Override
    public Point checkPoint(PointSubmitDTO dto) {
        var x = dto.getX();
        var y = dto.getY();
        var r = dto.getR();
        boolean inside = false;
        if(x >= 0){
            if(y >= 0){
                if(x <= r && y <= r/2)
                    inside = true;
            }
        }else{
            if(y >= 0){
                inside = isPointInTriangle(dto);
            } else{
                inside = x*x + y*y <= r*r;
            }
        }
        if(r < 0)
            inside = !inside;
        var result = new Point();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setInside(inside);
        result.setColor(generateColor());
        return result;
    }
    private String generateColor(){
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        return colorCode;
    }
    private boolean isPointInTriangle(PointSubmitDTO point) {
        Double r = point.getR();
        double area1 = sign(point.getX(), point.getY(), 0d, 0d, 0d, Math.abs(r/2));
        double area2 = sign(point.getX(), point.getY(), 0d, Math.abs(r/2), -Math.abs(r/2), Math.abs(r/2));
        double area3 = sign(point.getX(), point.getY(), -Math.abs(r/2), Math.abs(r/2), 0d,0d);
        boolean hasNeg = (area1 < 0) || (area2 < 0) || (area3 < 0);
        boolean hasPos = (area1 > 0) || (area2 > 0) || (area3 > 0);

        return !(hasNeg && hasPos);
    }

    private double sign (Double x1, Double y1, Double x2, Double y2, Double x3, Double y3)
    {
        return (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
    }
}
