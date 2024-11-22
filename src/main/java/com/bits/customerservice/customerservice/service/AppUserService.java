package com.bits.customerservice.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bits.customerservice.customerservice.db.AppUserRepository;
import com.bits.customerservice.customerservice.model.AppUser;
import com.bits.customerservice.customerservice.model.CustomerWithOrdersResponse;
import com.bits.customerservice.customerservice.model.OrderResponse;

@Service
public class AppUserService {
	
	@Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AppUserRepository appUserRepository;
    
    @Value("${order.service.url}")
    private String orderServiceUrl; 

    public AppUser createUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public Optional<AppUser> getUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public Optional<AppUser> getUserByContactNumber(String contactNumber) {
        return appUserRepository.findByContactNumber(contactNumber);
    }

    public void softDeleteUser(Long id) {
        appUserRepository.findById(id).ifPresent(user -> {
            user.setStatus(false);
            appUserRepository.save(user);
        });
    }
    
    public CustomerWithOrdersResponse getCustomerDetailsWithOrders(Long customerId) {
        // Fetch customer details
        AppUser appUser = appUserRepository.findById(customerId)
                .orElseThrow();
        
        System.out.println("Fetched Customer: " + appUser.toString());

        // Fetch orders from Order Service
        String url = orderServiceUrl + customerId;
        System.out.println(url + " urL");
        List<OrderResponse> orders;
        try {
            ResponseEntity<List<OrderResponse>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<OrderResponse>>() {}
            );
            orders = response.getBody();
            System.out.println("Fetched Orders: " + orders.toString());
        } catch (Exception ex) {
            // Handle the exception (log or rethrow)
            throw new RuntimeException("Failed to fetch orders from Order Service", ex);
        }

        // Construct the response
        CustomerWithOrdersResponse response = new CustomerWithOrdersResponse();
        response.setCustomerId(appUser.getId());
        response.setName(appUser.getName());
        response.setEmail(appUser.getEmail());
        response.setAddress(appUser.getAddress());
        response.setContactNumber(appUser.getContactNumber());
        response.setOrders(orders);
        return response;
    }

}
