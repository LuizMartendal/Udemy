package br.com.erudio.services;

import br.com.erudio.dtos.security.AccountCredentialsDTO;
import br.com.erudio.dtos.security.TokenDTO;
import br.com.erudio.repositories.UserRepository;
import br.com.erudio.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> signin(AccountCredentialsDTO data) {
        try {
            var username = data.getUserName();
            var password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var user = userRepository.findByUsername(username);
            var tokenResponse = new TokenDTO();

            if (user != null) {
                tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("User not found!");
            }

            return ResponseEntity.ok().body(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity<?> refreshToken(String username, String refreshToken) {
        var user = userRepository.findByUsername(username);

        var tokenResponse = new TokenDTO();
        if (user != null) {
            tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
        } else {
            throw new UsernameNotFoundException("Username not found!");
        }
        return ResponseEntity.ok(tokenResponse);
    }
}
