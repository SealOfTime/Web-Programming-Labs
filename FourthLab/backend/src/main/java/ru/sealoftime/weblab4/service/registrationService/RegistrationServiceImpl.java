package ru.sealoftime.weblab4.service.registrationService;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import ru.sealoftime.weblab4.model.dto.auth.UserRegisterDTO;
import ru.sealoftime.weblab4.model.entity.UserData;
import ru.sealoftime.weblab4.service.entityServices.userService.UserService;


@Component
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private UserService userService;

    @Override
    public UserData register(UserRegisterDTO dto) throws UserAlreadyExistsException {
        var newUser = new UserData();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(dto.getPassword());
        try {
            return userService.saveUser(newUser);
        }catch(ConstraintViolationException | DataIntegrityViolationException e){
            throw new UserAlreadyExistsException();
        }
    }
}
