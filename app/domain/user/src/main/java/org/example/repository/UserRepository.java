package org.example.repository;

import java.util.Optional;
import org.example.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String> {

    void save(User user);

    Optional<User> findById(String userId);
}
