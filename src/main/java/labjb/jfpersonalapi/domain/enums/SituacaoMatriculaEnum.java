package labjb.jfpersonalapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SituacaoMatriculaEnum {

    ATIVA("Ativa"),
    ENCERRADA("Encerrada");

    private String descricao;
}
