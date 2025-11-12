package labjb.jfpersonalapi.domain.dto.out;

import java.time.LocalDate;
import java.util.UUID;

public record PersonalDto(
        UUID id,
        String nomeCompleto,
        LocalDate dataNascimento,
        String cpf,
        String descricao,
        String email,
        String telefone
) {}
