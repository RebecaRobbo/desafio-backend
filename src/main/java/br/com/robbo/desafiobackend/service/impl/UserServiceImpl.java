package br.com.robbo.desafiobackend.service.impl;

import br.com.robbo.desafiobackend.entity.User;
import br.com.robbo.desafiobackend.repository.UserRepository;
import br.com.robbo.desafiobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        try {
            User userResult = userRepository.findUserByCpf(user.getCpf());
            if (userResult == null) {
                return userRepository.save(user);
            } else {
                throw new Exception("Usuário já possui conta");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByCPF(String cpf) {
        User user = userRepository.findUserByCpf(cpf);
        return user;
    }


}
