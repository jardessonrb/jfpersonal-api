package labjb.jfpersonalapi.domain.dto.out;

import java.sql.Date;
import java.util.UUID;

public record AlunoListagemResumidaDto(
        UUID id,
        String nomeCompleto,
        Date dataNascimento,
        Date inicioAulas,
        String situacaoMatricula,
        Integer quantidadeAulasSemana
) {}
