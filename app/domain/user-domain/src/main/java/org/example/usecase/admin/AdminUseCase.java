package org.example.usecase.admin;

import lombok.RequiredArgsConstructor;
import org.example.entity.Admin;
import org.example.error.AdminError;
import org.example.exception.BusinessException;
import org.example.repository.admin.AdminRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AdminUseCase {

    private final AdminRepository adminRepository;

    @Transactional
    public void save(Admin admin) {
        try {
            adminRepository.saveAndFlush(admin);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(AdminError.EMAIL_DUPLICATED_ERROR);
        }
    }
}
