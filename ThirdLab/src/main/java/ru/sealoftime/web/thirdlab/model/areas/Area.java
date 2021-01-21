package ru.sealoftime.web.thirdlab.model.areas;

import ru.sealoftime.web.thirdlab.model.Point;

public interface Area {
    boolean checkIfContains(Point p);

    void scale(double scale);
}
