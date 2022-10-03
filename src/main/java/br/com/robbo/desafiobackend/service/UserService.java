package br.com.robbo.desafiobackend.service;

import br.com.robbo.desafiobackend.entity.User;

public interface UserService {
    User createUser(User user);

    User findByCPF(String cpf);
}
