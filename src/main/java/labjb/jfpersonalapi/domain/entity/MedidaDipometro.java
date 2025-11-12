package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_medida_dipometro")
public class MedidaDipometro extends BaseEntity {

    private Double triceptal;
    private Double peitoral;

    @Column(name = "sub_axilar")
    private Double subAxilar;

    @Column(name = "sub_escapular")
    private Double subEscapular;

    private Double abdominal;

    @Column(name = "supra_iliaca")
    private Double supraIliaca;

    @Column(name = "coxa_medial")
    private Double coxaMedial;

    @ManyToOne
    @JoinColumn(name = "id_avaliacao_fisica", nullable = false)
    private AvaliacaoFisica avaliacaoFisica;
}
