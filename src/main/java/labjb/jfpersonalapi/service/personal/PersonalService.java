package labjb.jfpersonalapi.service.personal;

import labjb.jfpersonalapi.domain.dto.in.PersonalForm;
import labjb.jfpersonalapi.domain.dto.out.PersonalDto;

import java.util.UUID;

public interface PersonalService {

    PersonalDto criaPersonal(PersonalForm form);
    PersonalDto buscaPorId(UUID personalId);
}
