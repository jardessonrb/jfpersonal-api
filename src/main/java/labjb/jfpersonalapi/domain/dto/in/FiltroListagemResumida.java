package labjb.jfpersonalapi.domain.dto.in;

import labjb.jfpersonalapi.domain.enums.SituacaoMatriculaEnum;
import lombok.Builder;

@Builder
public record FiltroListagemResumida(
        String filtro,
        Integer quantidadeDiasSemana,
        SituacaoMatriculaEnum situacaoMatricula
) {}
