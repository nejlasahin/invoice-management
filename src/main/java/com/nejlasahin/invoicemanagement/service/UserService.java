package com.nejlasahin.invoicemanagement.service;

import com.nejlasahin.invoicemanagement.dto.request.UserRequestDto;
import com.nejlasahin.invoicemanagement.entity.User;
import com.nejlasahin.invoicemanagement.enumeration.UserMessage;
import com.nejlasahin.invoicemanagement.exceptions.UserInvalidPasswordException;
import com.nejlasahin.invoicemanagement.exceptions.UserNotFoundException;
import com.nejlasahin.invoicemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String TOKEN_TYPE = "Bearer ";
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final UserRepository userRepository;

    public String login(UserRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException(UserMessage.USER_NOT_FOUND));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new UserInvalidPasswordException(UserMessage.INVALID_PASSWORD);
        }
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return TOKEN_TYPE + getToken((UserDetails) authenticate.getPrincipal());
    }

    public String getToken(UserDetails userDetails) {
        String email = userDetails.getUsername();
        return jwtTokenService.generateJwtToken(email);
    }
}
