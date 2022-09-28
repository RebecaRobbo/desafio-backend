package br.com.robbo.desafiobackend.service.impl;

import br.com.robbo.desafiobackend.entity.User;
import br.com.robbo.desafiobackend.repository.UserRepository;
import br.com.robbo.desafiobackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
