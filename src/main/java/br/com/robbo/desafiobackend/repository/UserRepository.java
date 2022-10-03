package br.com.robbo.desafiobackend.repository;

import br.com.robbo.desafiobackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByCpf(String cpf);
}
