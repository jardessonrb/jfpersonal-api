package labjb.jfpersonalapi.repositoy;

import labjb.jfpersonalapi.domain.entity.Aluno;
import labjb.jfpersonalapi.domain.entity.Matricula;
import labjb.jfpersonalapi.domain.entity.Personal;
import labjb.jfpersonalapi.domain.enums.SituacaoMatriculaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    boolean existsByAlunoAndPersonalAndSituacaoMatricula(Aluno aluno, Personal personal, SituacaoMatriculaEnum situacaoMatricula);
}
