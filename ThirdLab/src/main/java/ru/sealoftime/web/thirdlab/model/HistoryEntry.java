package ru.sealoftime.web.thirdlab.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryEntry {
    double x;
    double y;
    double r;
    boolean isInside;
}
