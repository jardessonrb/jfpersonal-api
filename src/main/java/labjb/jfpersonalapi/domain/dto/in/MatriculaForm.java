package labjb.jfpersonalapi.domain.dto.in;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record MatriculaForm(
        Double valorMensalidade,
        Integer diaPagamento,
        LocalDate inicioAulas,
        Integer quantidadeAulasSemana,
        String anamnese
) {}
