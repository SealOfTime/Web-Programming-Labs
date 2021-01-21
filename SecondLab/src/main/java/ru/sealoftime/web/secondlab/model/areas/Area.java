package ru.sealoftime.web.secondlab.model.areas;

import ru.sealoftime.web.secondlab.model.Point;

public interface Area {
    boolean checkIfContains(Point p);

    void scale(double scale);
}
