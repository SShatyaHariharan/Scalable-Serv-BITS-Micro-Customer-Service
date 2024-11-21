package com.bits.customerservice.customerservice.db;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.customerservice.customerservice.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByContactNumber(String contactNumber);
    
    AppUser getAppUserById(Long id);

//    Page<AppUser> findAllByStatusTrue(Pageable pageable); // For active customers only
}