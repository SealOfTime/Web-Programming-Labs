package ru.sealoftime.weblab4.service.entityServices.userService;

import ru.sealoftime.weblab4.model.dto.auth.UserRegisterDTO;
import ru.sealoftime.weblab4.model.entity.UserData;

public interface UserService {

    UserData saveUser(UserData dto);

    UserData findByUsername(String username);

    UserData findByUsernameAndPassword(String username, String password);

}
