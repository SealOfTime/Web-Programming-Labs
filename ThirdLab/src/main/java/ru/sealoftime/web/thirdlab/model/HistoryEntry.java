package ru.sealoftime.web.thirdlab.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryEntry {
    int id;
    double x;
    double y;
    double r;
    String color;
    boolean inside;
}
