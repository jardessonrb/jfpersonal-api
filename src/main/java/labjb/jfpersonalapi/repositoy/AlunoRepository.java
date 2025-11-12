package labjb.jfpersonalapi.repositoy;

import labjb.jfpersonalapi.domain.dto.out.AlunoListagemResumidaDto;
import labjb.jfpersonalapi.domain.entity.Aluno;
import labjb.jfpersonalapi.domain.enums.SituacaoMatriculaEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByCpf(String cpf);

    @Query(
        value = """
            select tp.uuid, tp.nome_completo, tp.data_nascimento, tm.data_inicio, tm.situacao_matricula,
            tm.quantidade_aulas_semana from tb_aluno ta
            join tb_pessoa tp on ta.id = tp.id
            join tb_matricula tm on tm.aluno_id = ta.id
            join tb_personal tpe on tm.personal_id = tpe.id
            where
            1=1
            and tpe.id = :personalId
            and (:filtro IS NULL or (tp.nome_completo ilike concat('%', :filtro, '%') or tp.cpf ilike concat('%', :filtro, '%')))
            and (:situacaoMatricula IS NULL or tm.situacao_matricula = :situacaoMatricula)
            and (:quantidadeAulasSemana IS NULL or tm.quantidade_aulas_semana = :quantidadeAulasSemana)
        """,
        countQuery = """
            select count(distinct ta.id)  from tb_aluno ta
            join tb_pessoa tp on ta.id = tp.id
            join tb_matricula tm on tm.aluno_id = ta.id
            join tb_personal tpe on tm.personal_id = tpe.id
            where
            1=1
            and tpe.id = :personalId
            and (:filtro IS NULL or (tp.nome_completo ilike concat('%', :filtro, '%') or tp.cpf ilike concat('%', :filtro, '%')))
            and (:situacaoMatricula IS NULL or tm.situacao_matricula = :situacaoMatricula)
            and (:quantidadeAulasSemana IS NULL or tm.quantidade_aulas_semana = :quantidadeAulasSemana)
        """,
        nativeQuery = true)
    Page<AlunoListagemResumidaDto> buscaAlunosListagemResumida(
            @Param("personalId") Long personalId,
            @Param("filtro") String filtro,
            @Param("situacaoMatricula") String situacaoMatricula,
            @Param("quantidadeAulasSemana") Integer quantidadeAulasSemana,
            Pageable paginacao
    );
}
