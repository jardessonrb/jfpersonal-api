package labjb.jfpersonalapi.domain.dto.in;

import java.time.LocalDate;

public record AlunoForm(
        String nomeCompleto,
        LocalDate dataNascimento,
        String cpf,
        MatriculaForm matricula,
        String email,
        String telefone
) {}
