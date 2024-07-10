package org.example.repository.admin;

import java.util.UUID;
import org.example.entity.Admin;
import org.example.repository.user.UserQuerydslRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, UUID>, UserQuerydslRepository {

}
