package ru.sealoftime.web.secondlab.model.areas;

import ru.sealoftime.web.secondlab.model.Point;

public interface Area {
    boolean checkIfIn(Point p);

    void scale(double scale);
}
