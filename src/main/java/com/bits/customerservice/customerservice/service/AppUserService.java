package com.bits.customerservice.customerservice.service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.bits.customerservice.customerservice.db.AppUserRepository;
import com.bits.customerservice.customerservice.model.AppUser;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public Optional<AppUser> getUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public Optional<AppUser> getUserByContactNumber(String contactNumber) {
        return appUserRepository.findByContactNumber(contactNumber);
    }

//    public Page<AppUser> getAllUsers(Pageable pageable) {
//        return appUserRepository.findAllByStatusTrue(pageable);
//    }

    public void softDeleteUser(Long id) {
        appUserRepository.findById(id).ifPresent(user -> {
            user.setStatus(false);
            appUserRepository.save(user);
        });
    }
}
