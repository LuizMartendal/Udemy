package br.com.erudio.restwithspringbootudemy.services;

import br.com.erudio.restwithspringbootudemy.models.UserModel;
import br.com.erudio.restwithspringbootudemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel user = repository.findByUserName(userName);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username " + userName + " not found!");
        }
    }
}
