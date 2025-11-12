package labjb.jfpersonalapi.service.aluno;

import labjb.jfpersonalapi.domain.dto.in.AlunoForm;
import labjb.jfpersonalapi.domain.dto.in.FiltroListagemResumida;
import labjb.jfpersonalapi.domain.dto.out.AlunoDto;
import labjb.jfpersonalapi.domain.dto.out.AlunoListagemResumidaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AlunoService {
    AlunoDto criarAluno(AlunoForm alunoForm);
    Page<AlunoListagemResumidaDto> buscarAlunosListagem(UUID personalId, FiltroListagemResumida filtros, Pageable paginacao);
}
