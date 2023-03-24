package br.com.erudio.restwithspringbootudemy.controllers;

import br.com.erudio.restwithspringbootudemy.models.UserModel;
import br.com.erudio.restwithspringbootudemy.repositories.UserRepository;
import br.com.erudio.restwithspringbootudemy.security.AccountCredentialsVO;
import br.com.erudio.restwithspringbootudemy.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository repository;

    @ApiOperation(value = "Authenticate a user by credentials")
    @PostMapping(value = "/signin", produces = {"application/json", "application/xml", "application/x-yml"},
                consumes = {"application/json", "application/xml", "application/x-yml"})
    public ResponseEntity<?> signin(@RequestBody AccountCredentialsVO accountCredentialsVO) {
        try {
            String userName = accountCredentialsVO.getUserName();
            String password = accountCredentialsVO.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            UserModel userModel = repository.findByUserName(userName);
            String token = "";

            if (userModel != null) {
                token = jwtTokenProvider.createToken(userName, userModel.getRoles());
            } else {
                throw new UsernameNotFoundException("Username" + userName + "not found");
            }

            Map<Object, Object> model = new HashMap<>();
            model.put("username", userName);
            model.put("token", token);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException ae) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }
}
