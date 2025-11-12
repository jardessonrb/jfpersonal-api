package labjb.jfpersonalapi.service.personal.impl;

import jakarta.persistence.EntityNotFoundException;
import labjb.jfpersonalapi.domain.entity.Personal;
import labjb.jfpersonalapi.repositoy.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PersonalServiceUtil {

    private final PersonalRepository personalRepository;

    public Personal buscaPersonalPorUuid(UUID personalId){
        return personalRepository.findByUuid(personalId).orElseThrow(
                () -> new EntityNotFoundException("Nenhum personal enconntrado para o id informado")
        );
    }
}
