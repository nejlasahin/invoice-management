package com.nejlasahin.invoicemanagement.security;

import com.nejlasahin.invoicemanagement.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<User> users = new ArrayList<>();

    public InMemoryUserDetailsService() {
        users.add(new User("Nejla", "Sahin", "nejlasahin@invoice.com", "{noop}123456"));
        users.add(new User("John", "Doe", "johndoe@invoice.com", "{noop}456789"));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return users.stream().filter(user -> user.getEmail().equals(email)).findAny().map(this::getUser)
                .orElseThrow(() -> new RuntimeException(String.format("email = %s not present ", email)));
    }

    private UserDetails getUser(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
