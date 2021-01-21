package ru.sealoftime.web.thirdlab.model.areas;

import ru.sealoftime.web.thirdlab.model.Point;

import java.util.Set;

public class CombinedArea implements Area{
    private final Set<Area> areas;

    public CombinedArea(Area... areas){
        this.areas = Set.of(areas);
    }

    @Override
    public void scale(double scale) {
        this.areas.forEach(a->a.scale(scale));
    }

    @Override
    public boolean checkIfContains(Point p) {
        return this.areas.stream().anyMatch(area -> area.checkIfContains(p));
    }
}
