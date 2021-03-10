package ru.sealoftime.weblab4.service.registrationService;

import ru.sealoftime.weblab4.model.dto.auth.UserRegisterDTO;
import ru.sealoftime.weblab4.model.entity.UserData;

public interface RegistrationService {

    UserData register(UserRegisterDTO dto) throws UserAlreadyExistsException;
}
