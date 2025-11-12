package labjb.jfpersonalapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoPessoaEnum {

    ALUNO("Aluno"),
    PERSONAL("Personal");

    private String descricao;
}
