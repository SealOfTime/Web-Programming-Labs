package ru.sealoftime.web.secondlab.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryEntry {
    double x;
    double y;
    double r;
    String color;
    boolean isInside;
}
