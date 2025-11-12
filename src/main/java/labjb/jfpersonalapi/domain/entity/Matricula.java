package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;
import labjb.jfpersonalapi.domain.enums.SituacaoMatriculaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_matricula")
public class Matricula extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_id")
    private Personal personal;

    private LocalDate dataEncerramento;

    private LocalDate dataInicio;

    private Integer diaPagamento;

    private Integer quantidadeAulasSemana;

    @Enumerated(EnumType.STRING)
    private SituacaoMatriculaEnum situacaoMatricula;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_id")
    private Set<AvaliacaoFisica> avaliacoesFisicas = new HashSet<>();

    private String anamnese;
}
