package labjb.jfpersonalapi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "tb_lembrete")
public class Lembrete extends BaseEntity {

    private String titulo;
    private String descricao;
    private String status;
    private LocalDate data;
    private Time horario;
}
