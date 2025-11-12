package labjb.jfpersonalapi.domain.dto.in;

import java.time.LocalDate;

public record PersonalForm(
        String nomeCompleto,
        LocalDate dataNascimento,
        String cpf,
        String descricao,
        String email,
        String telefone
) {}
