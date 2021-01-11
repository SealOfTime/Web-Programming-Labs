package ru.sealoftime.web.secondlab.model.areas;

import lombok.Data;
import ru.sealoftime.web.secondlab.model.Point;

import java.util.Set;

public class IntersectedArea implements Area {
    private final Set<Area> areas;

    public IntersectedArea(Area... areas){
        this.areas = Set.of(areas);
    }

    @Override
    public boolean checkIfIn(Point p) {
        return this.areas.stream().anyMatch(area -> !area.checkIfIn(p));
    }

    @Override
    public void scale(double scale) {
        this.areas.forEach(a -> a.scale(scale));
    }

}
