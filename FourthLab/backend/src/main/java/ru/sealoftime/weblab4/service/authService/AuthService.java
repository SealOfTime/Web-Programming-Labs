package ru.sealoftime.weblab4.service.authService;

import ru.sealoftime.weblab4.model.dto.auth.UserLoginDTO;
import ru.sealoftime.weblab4.model.response.AuthResponse;

public interface AuthService {

    AuthResponse auth(UserLoginDTO dto);
}
