package org.example.repository;

import java.util.Optional;
import java.util.UUID;

public interface UserQuerydslRepository {

    Optional<String> findNicknameById(final UUID id);

}
