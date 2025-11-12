package labjb.jfpersonalapi.service.personal.impl;

import jakarta.persistence.EntityNotFoundException;
import labjb.jfpersonalapi.domain.dto.in.PersonalForm;
import labjb.jfpersonalapi.domain.dto.out.PersonalDto;
import labjb.jfpersonalapi.domain.entity.Personal;
import labjb.jfpersonalapi.domain.enums.TipoPessoaEnum;
import labjb.jfpersonalapi.shared.errors.exception.EntityAlreadyException;
import labjb.jfpersonalapi.repositoy.PersonalRepository;
import labjb.jfpersonalapi.service.personal.PersonalService;
import labjb.jfpersonalapi.shared.mapper.PersonalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;
    private final PersonalMapper personalMapper;

    @Override
    public PersonalDto criaPersonal(PersonalForm form) {
        Personal personal = personalMapper.toEntity(form);
        if(personalRepository.existsByCpfOrEmail(personal.getCpf(), personal.getEmail())){
            throw new EntityAlreadyException("Já existe um personal com o cpf ou email informado.");
        }

        return personalMapper.toDto(personalRepository.save(personal));
    }

    @Override
    public PersonalDto buscaPorId(UUID personalId) {
        Personal personal = personalRepository.findByUuid(personalId)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum personal encontrado para o id informado"));
        return personalMapper.toDto(personal);
    }
}
