package labjb.jfpersonalapi.service.aluno.impl;

import labjb.jfpersonalapi.domain.dto.in.AlunoForm;
import labjb.jfpersonalapi.domain.dto.in.FiltroListagemResumida;
import labjb.jfpersonalapi.domain.dto.out.AlunoDto;
import labjb.jfpersonalapi.domain.dto.out.AlunoListagemResumidaDto;
import labjb.jfpersonalapi.domain.entity.Aluno;
import labjb.jfpersonalapi.domain.entity.Matricula;
import labjb.jfpersonalapi.domain.entity.Personal;
import labjb.jfpersonalapi.repositoy.AlunoRepository;
import labjb.jfpersonalapi.service.aluno.AlunoService;
import labjb.jfpersonalapi.service.personal.impl.PersonalServiceUtil;
import labjb.jfpersonalapi.shared.mapper.AlunoMapper;
import labjb.jfpersonalapi.shared.mapper.MatriculaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoMapper alunoMapper;
    private final MatriculaMapper matriculaMapper;
    private final AlunoRepository alunoRepository;
    private final PersonalServiceUtil personalServiceUtil;

    @Override
    public AlunoDto criarAluno(AlunoForm alunoForm) {
        Aluno aluno = alunoMapper.toEntity(alunoForm);
        Matricula matricula = matriculaMapper.toEntity(alunoForm.matricula());
        matricula.setAluno(aluno);
        aluno.getMatriculas().add(matricula);
        return alunoMapper.toDto(alunoRepository.save(aluno));
    }

    @Override
    public Page<AlunoListagemResumidaDto> buscarAlunosListagem(UUID personalId, FiltroListagemResumida filtros, Pageable paginacao) {
        Personal personal = personalServiceUtil.buscaPersonalPorUuid(personalId);

        return alunoRepository.buscaAlunosListagemResumida(
                personal.getId(),
                filtros.filtro(),
                Objects.nonNull(filtros.situacaoMatricula()) ? filtros.situacaoMatricula().name() : null,
                filtros.quantidadeDiasSemana(),
                paginacao
        );
    }
}
