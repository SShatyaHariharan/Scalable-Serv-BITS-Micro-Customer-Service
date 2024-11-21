package com.bits.customerservice.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bits.customerservice.customerservice.db.AppUserRepository;
import com.bits.customerservice.customerservice.model.AppUser;
import com.bits.customerservice.customerservice.service.AppUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppUserController {
	@Autowired
	private AppUserRepository appUserRepository;
    @Autowired
    private AppUserService appUserService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AppUser getActivityTypeById(@PathVariable(name = "id") Long id) {
		return appUserRepository.getAppUserById(id);
	}

//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public AppUser save(@RequestBody(required = false) AppUser body) {
//		return appUserRepository.save(body);
//	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<AppUser> list() {
		return appUserRepository.findAll();
	}
	
	
	// Create a new customer
    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return appUserService.createUser(user);
    }

    // Search customer by email
    @GetMapping("/search/email")
    public Optional<AppUser> getUserByEmail(@RequestParam String email) {
        return appUserService.getUserByEmail(email);
    }

    // Search customer by contact number
    @GetMapping("/search/contact")
    public Optional<AppUser> getUserByContactNumber(@RequestParam String contactNumber) {
        return appUserService.getUserByContactNumber(contactNumber);
    }

    // Get all customers with pagination and sorting
//    @GetMapping
//    public Page<AppUser> getAllUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "name") String sortBy,
//            @RequestParam(defaultValue = "asc") String sortDir) {
//
//        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        return appUserService.getAllUsers(pageable);
//    }

    // Soft delete a customer
    @DeleteMapping("/{id}")
    public void softDeleteUser(@PathVariable Long id) {
        appUserService.softDeleteUser(id);
    }
	
	
	
	
	
}