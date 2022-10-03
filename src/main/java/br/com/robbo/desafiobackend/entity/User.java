package br.com.robbo.desafiobackend.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String nome;

    @NotNull
    @Size(min = 11, max = 11, message = "CPF inválido")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @OneToOne(mappedBy = "account")
    private Account account;
}
