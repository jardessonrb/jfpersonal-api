package labjb.jfpersonalapi.service.matricula.impl;

import labjb.jfpersonalapi.domain.dto.in.MatriculaForm;
import labjb.jfpersonalapi.domain.dto.out.MatriculaDto;
import labjb.jfpersonalapi.repositoy.AlunoRepository;
import labjb.jfpersonalapi.repositoy.MatriculaRepository;
import labjb.jfpersonalapi.service.matricula.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final AlunoRepository alunoRepository;
    private final MatriculaRepository matriculaRepository;

    @Override
    public MatriculaDto criarMatricula(UUID alunoId, MatriculaForm matriculaForm) {
        return null;
    }
}
