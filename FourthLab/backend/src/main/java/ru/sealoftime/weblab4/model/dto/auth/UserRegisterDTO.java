package ru.sealoftime.weblab4.model.dto.auth;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegisterDTO {
    String username;
    String password;
}
