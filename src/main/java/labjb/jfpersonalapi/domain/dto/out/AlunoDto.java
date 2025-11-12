package labjb.jfpersonalapi.domain.dto.out;

import java.time.LocalDate;
import java.util.UUID;

public record AlunoDto(
        UUID id,
        String nomeCompleto,
        LocalDate dataNascimento,
        String cpf
) {}
