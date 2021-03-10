package ru.sealoftime.weblab4.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PointResponse {
    Double x;
    Double y;
    Double r;
    Boolean inside;
    String color;
    String owner;

    
}
