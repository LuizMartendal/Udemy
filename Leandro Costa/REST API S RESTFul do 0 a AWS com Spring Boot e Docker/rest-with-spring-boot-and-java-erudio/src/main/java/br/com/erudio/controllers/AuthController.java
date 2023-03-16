package br.com.erudio.controllers;

import br.com.erudio.dtos.security.AccountCredentialsDTO;
import br.com.erudio.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Operation(summary = "Authenticates a user and returns a token")
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody AccountCredentialsDTO data) {
        if (data == null || data.getUserName() == null || data.getUserName().isBlank()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        var token = authService.signin(data);
        if (token == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        return token;
    }

    @Operation(summary = "Refresh token for authenticated  user and returns a token")
    @PostMapping("/refresh/{username}")
    public ResponseEntity<?> refreshToken(@PathVariable String username, @RequestHeader("Authorization") String refreshToken) {
        if (username == null || username.isBlank() || refreshToken == null || refreshToken.isBlank()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        var token = authService.refreshToken(username, refreshToken);
        if (token == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        return token;
    }
}
