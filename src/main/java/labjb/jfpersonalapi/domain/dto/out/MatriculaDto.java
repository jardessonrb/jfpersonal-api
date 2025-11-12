package labjb.jfpersonalapi.domain.dto.out;

import java.time.LocalDate;
import java.util.UUID;

public record MatriculaDto(
        UUID id,
        String codigo,
        Double valorMensalidade,
        Integer diaPagamento,
        LocalDate inicioAulas,
        Integer quantidadeAulasSemana,
        String anamnese
) { }
