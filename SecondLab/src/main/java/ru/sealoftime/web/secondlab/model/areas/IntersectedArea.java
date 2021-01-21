package ru.sealoftime.web.secondlab.model.areas;

import ru.sealoftime.web.secondlab.model.Point;

import java.util.Set;

public class IntersectedArea implements Area {
    private final Set<Area> areas;

    public IntersectedArea(Area... areas){
        this.areas = Set.of(areas);
    }

    @Override
    public boolean checkIfContains(Point p) {
        return this.areas.stream().allMatch(area -> area.checkIfContains(p));
    }

    @Override
    public void scale(double scale) {
        this.areas.forEach(a -> a.scale(scale));
    }

}
