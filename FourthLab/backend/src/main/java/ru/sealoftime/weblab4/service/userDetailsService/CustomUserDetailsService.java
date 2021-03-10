package ru.sealoftime.weblab4.service.userDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.sealoftime.weblab4.model.CustomUserDetails;
import ru.sealoftime.weblab4.service.entityServices.userService.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userData = userService.findByUsername(username);
        return new CustomUserDetails(
                userData.getUsername(),
                userData.getPassword()
        );
    }
}
