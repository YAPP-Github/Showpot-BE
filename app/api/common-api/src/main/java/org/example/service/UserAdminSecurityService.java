package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.property.UserAdminProperty;
import org.example.usecase.UserAdminUseCase;
import org.example.vo.UserRoleApiType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdminSecurityService implements UserDetailsService {

    private final UserAdminUseCase userAdminUseCase;
    private final UserAdminProperty userAdminProperty;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User admin = userAdminUseCase.findByUsername(username);
        admin.validateUserRole();

        return new org.springframework.security.core.userdetails.User(
            admin.getNickname(),
            passwordEncoder.encode(userAdminProperty.password()),
            UserRoleApiType.ADMIN.getAdminAuthority()
        );
    }
}
