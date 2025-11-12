package labjb.jfpersonalapi.controller;

import jakarta.validation.Valid;
import labjb.jfpersonalapi.domain.dto.in.PersonalForm;
import labjb.jfpersonalapi.domain.dto.out.PersonalDto;
import labjb.jfpersonalapi.service.personal.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/personal")
public class PersonalController {

    private final PersonalService personalService;

    @PostMapping
    public ResponseEntity<PersonalDto> criarPersonal(@RequestBody @Valid PersonalForm personalForm, UriComponentsBuilder uriComponentsBuilder){
        PersonalDto personalDto = personalService.criaPersonal(personalForm);
        URI uri = uriComponentsBuilder.path("/personal/{id}").buildAndExpand(personalDto.id()).toUri();
        return ResponseEntity.created(uri).body(personalDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalDto> criarPersonal(@PathVariable(name = "id") UUID personalId){
        return ResponseEntity.ok(personalService.buscaPorId(personalId));
    }
}
