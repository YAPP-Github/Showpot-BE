package org.example.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
    Optional<User> findById(UUID userId);
}
