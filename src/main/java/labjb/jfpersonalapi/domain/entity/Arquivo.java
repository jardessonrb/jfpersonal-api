package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_arquivo")
public class Arquivo extends BaseEntity {

    @Column(name = "nome_original")
    private String nomeOriginal;

    private String tipo;
    private String extensao;

    @Column(name = "tamanho_em_mb")
    private Double tamanhoEmMB;

    private String path;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_avaliacao_fisica")
    private AvaliacaoFisica avaliacaoFisica;
}
