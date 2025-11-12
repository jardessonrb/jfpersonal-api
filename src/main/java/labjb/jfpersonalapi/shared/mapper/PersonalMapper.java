package labjb.jfpersonalapi.shared.mapper;

import labjb.jfpersonalapi.domain.dto.in.PersonalForm;
import labjb.jfpersonalapi.domain.dto.out.PersonalDto;
import labjb.jfpersonalapi.domain.entity.Personal;
import labjb.jfpersonalapi.domain.enums.TipoPessoaEnum;
import labjb.jfpersonalapi.shared.utils.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {StringUtils.class})
public interface PersonalMapper extends BaseMaps<PersonalDto, Personal, PersonalForm> {

    @Mappings({
            @Mapping(target = "cpf", source = "cpf", qualifiedByName = "removePontuacao"),
            @Mapping(target = "telefone", source = "telefone", qualifiedByName = "removePontuacao"),
            @Mapping(target = "tipoPessoa", constant = "PERSONAL")
    })
    Personal toEntity(PersonalForm form);

    @Mappings({
            @Mapping(target = "id", source = "uuid")
    })
    PersonalDto toDto(Personal entity);
}
