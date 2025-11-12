package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;
import labjb.jfpersonalapi.domain.enums.TipoPessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends BaseEntity {

    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private TipoPessoaEnum tipoPessoa;
}
