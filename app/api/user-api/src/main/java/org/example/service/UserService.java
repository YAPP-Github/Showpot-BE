package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(final User user) {
        userRepository.save(user);
    }

    public User findUserByUserId(final String userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
