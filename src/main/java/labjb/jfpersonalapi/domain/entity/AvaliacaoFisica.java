package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_avaliacao_fisica")
public class AvaliacaoFisica extends BaseEntity {

    private Double peso;
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @OneToMany(mappedBy = "avaliacaoFisica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedidaPerimetrica> medidasPerimetricas;

    @OneToMany(mappedBy = "avaliacaoFisica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedidaDipometro> medidasDipometro;

    @OneToMany(mappedBy = "avaliacaoFisica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Arquivo> arquivos;
}
