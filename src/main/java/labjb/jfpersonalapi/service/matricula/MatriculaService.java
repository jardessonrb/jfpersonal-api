package labjb.jfpersonalapi.service.matricula;

import labjb.jfpersonalapi.domain.dto.in.MatriculaForm;
import labjb.jfpersonalapi.domain.dto.out.MatriculaDto;

import java.util.UUID;

public interface MatriculaService {

    MatriculaDto criarMatricula(UUID alunoId, MatriculaForm matriculaForm);
}
