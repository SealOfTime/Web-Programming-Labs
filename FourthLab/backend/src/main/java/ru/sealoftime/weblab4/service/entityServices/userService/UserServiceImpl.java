package ru.sealoftime.weblab4.service.entityServices.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sealoftime.weblab4.model.dto.auth.UserRegisterDTO;
import ru.sealoftime.weblab4.model.entity.UserData;
import ru.sealoftime.weblab4.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserData saveUser(UserData userData) {
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        return userRepository.save(userData);
    }

    @Override
    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserData findByUsernameAndPassword(String username, String password) {
        UserData data = findByUsername(username);
        if (data != null) {
            if (passwordEncoder.matches(password, data.getPassword())) {
                return data;
            }
        }
        return null;
    }
}
