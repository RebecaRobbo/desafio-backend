package br.com.robbo.desafiobackend.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "num_account", unique = true)
    private Integer numberAccount;

    @NotNull
    @Column(name = "agency")
    private Integer agency;

    @NotNull
    @Min(value = 0)
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
