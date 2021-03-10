package ru.sealoftime.weblab4.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
public class AuthResponse {
    private final String token;
    private final Date expiresIn;
}
