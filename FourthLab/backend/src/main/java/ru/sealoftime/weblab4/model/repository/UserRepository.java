package ru.sealoftime.weblab4.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import ru.sealoftime.weblab4.model.entity.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    UserData findByUsername(String username);
}
