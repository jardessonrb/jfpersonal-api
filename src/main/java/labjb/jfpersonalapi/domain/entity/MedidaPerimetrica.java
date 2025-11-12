package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_medida_perimetrica")
public class MedidaPerimetrica extends BaseEntity {

    @Column(name = "braco_direito")
    private Double bracoDireito;

    @Column(name = "braco_esquerdo")
    private Double bracoEsquerdo;

    @Column(name = "coxa_direita")
    private Double coxaDireita;

    @Column(name = "coxa_esquerda")
    private Double coxaEsquerda;

    @Column(name = "panturrilha_esquerda")
    private Double panturrilhaEsquerda;

    @Column(name = "panturrilha_direita")
    private Double panturrilhaDireita;

    private Double peitoral;
    private Double cintura;
    private Double gluteos;

    @ManyToOne
    @JoinColumn(name = "id_avaliacao_fisica", nullable = false)
    private AvaliacaoFisica avaliacaoFisica;
}
