package ru.sealoftime.weblab4.model.dto.auth;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true)
public class UserLoginDTO {
    String username;
    String password;
}
