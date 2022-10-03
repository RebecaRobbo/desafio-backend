package br.com.robbo.desafiobackend.repository;

import br.com.robbo.desafiobackend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByNumberAccount(Integer accountNumber);
}
