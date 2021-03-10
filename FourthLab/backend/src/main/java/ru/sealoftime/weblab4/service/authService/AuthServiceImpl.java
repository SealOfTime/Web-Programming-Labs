package ru.sealoftime.weblab4.service.authService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import ru.sealoftime.weblab4.model.dto.auth.UserLoginDTO;
import ru.sealoftime.weblab4.model.response.AuthResponse;
import ru.sealoftime.weblab4.service.entityServices.userService.UserService;
import ru.sealoftime.weblab4.service.jwtProviderService.JwtProvider;

@Component
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public AuthResponse auth(UserLoginDTO dto) {
        var user = userService.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(user == null)
            return null;
        String token = jwtProvider.generateToken(user.getUsername());
        return new AuthResponse(token, jwtProvider.getExpiresInFromToken(token));
    }
}
