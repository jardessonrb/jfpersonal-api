package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;
import labjb.jfpersonalapi.domain.enums.SituacaoMatricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private LocalDateTime dataEncerramento;

    @Enumerated(EnumType.STRING)
    private SituacaoMatricula situacaoMatricula;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_id")
    private Set<AvaliacaoFisica> avaliacoesFisicas = new HashSet<>();
}
