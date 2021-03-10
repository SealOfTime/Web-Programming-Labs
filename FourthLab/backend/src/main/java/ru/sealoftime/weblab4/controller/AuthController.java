package ru.sealoftime.weblab4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import ru.sealoftime.weblab4.model.dto.auth.UserLoginDTO;
import ru.sealoftime.weblab4.model.dto.auth.UserRegisterDTO;
import ru.sealoftime.weblab4.model.response.AuthResponse;
import ru.sealoftime.weblab4.service.authService.AuthService;
import ru.sealoftime.weblab4.service.entityServices.userService.UserService;
import ru.sealoftime.weblab4.service.registrationService.RegistrationService;
import ru.sealoftime.weblab4.service.registrationService.UserAlreadyExistsException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log
public class AuthController {
    private final RegistrationService registrationService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody @Valid UserRegisterDTO req){
        try {
            log.warning(req.toString());
            registrationService.register(req);
        }catch(UserAlreadyExistsException e){
            return ResponseEntity.status(409).build();
        }

        var resp = authService.auth(new UserLoginDTO(req.getUsername(), req.getPassword()));

        if(resp == null)
            return ResponseEntity.status(444).build();

        log.info(resp.toString());

        return ResponseEntity.of(Optional.of(resp));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody @Valid UserLoginDTO req){
        var resp = authService.auth(req);
        System.out.println(resp);
        if(resp == null) {
            return ResponseEntity.status(444).build();
        }

        return ResponseEntity.of(Optional.of(resp));
    }
}
