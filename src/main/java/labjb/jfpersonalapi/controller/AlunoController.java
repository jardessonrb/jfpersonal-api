package labjb.jfpersonalapi.controller;

import jakarta.validation.Valid;
import labjb.jfpersonalapi.domain.dto.in.AlunoForm;
import labjb.jfpersonalapi.domain.dto.in.FiltroListagemResumida;
import labjb.jfpersonalapi.domain.dto.out.AlunoDto;
import labjb.jfpersonalapi.domain.dto.out.AlunoListagemResumidaDto;
import labjb.jfpersonalapi.domain.enums.SituacaoMatriculaEnum;
import labjb.jfpersonalapi.service.aluno.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder uriComponentsBuilder){
        AlunoDto alunoDto = alunoService.criarAluno(alunoForm);
        URI uri = uriComponentsBuilder.path("/aluno/{id}").buildAndExpand(alunoDto.id()).toUri();
        return ResponseEntity.created(uri).body(alunoDto);
    }

    @GetMapping("/personal/{personalId}")
    public ResponseEntity<Page<AlunoListagemResumidaDto>> buscaAlunosPorPersonal(@PathVariable("personalId") UUID personalId,
                                                                                 @RequestParam(name = "filtro", required = false) String filtro,
                                                                                 @RequestParam(name = "situacaoMatricula", required = false) SituacaoMatriculaEnum situacaoMatricula,
                                                                                 @RequestParam(name = "quantidadeDiasSemana", required = false) Integer quantidadeDiasSemana,
                                                                                 @PageableDefault(size = 10, page = 0) Pageable paginacao){

        System.out.println(filtro);
        FiltroListagemResumida filtroListagemResumida = FiltroListagemResumida
                .builder()
                .filtro(filtro)
                .quantidadeDiasSemana(quantidadeDiasSemana)
                .situacaoMatricula(situacaoMatricula)
                .build();

        return ResponseEntity.ok(alunoService.buscarAlunosListagem(personalId, filtroListagemResumida, paginacao));
    }
}
