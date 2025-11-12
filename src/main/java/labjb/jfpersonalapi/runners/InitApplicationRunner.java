package labjb.jfpersonalapi.runners;

import labjb.jfpersonalapi.domain.dto.in.AlunoForm;
import labjb.jfpersonalapi.domain.dto.in.MatriculaForm;
import labjb.jfpersonalapi.service.aluno.AlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
//@Component
public class InitApplicationRunner implements CommandLineRunner {

    private final AlunoService alunoService;

    @Override
    public void run(String... args) throws Exception {
        log.info(":: iniciando ::");
        MatriculaForm matriculaForm = MatriculaForm
                .builder()
                .inicioAulas(LocalDate.now().plusDays(3))
                .quantidadeAulasSemana(3)
                .valorMensalidade(250.00)
                .diaPagamento(10)
                .anamnese("Emagrecimento")
                .build();
        AlunoForm alunoForm = new AlunoForm("Joao", LocalDate.now().minusYears(20),"29.896.689-00",  matriculaForm, null, null);
        System.out.println(alunoService.criarAluno(alunoForm));
        log.info(":: finalizando ::");
    }
}
