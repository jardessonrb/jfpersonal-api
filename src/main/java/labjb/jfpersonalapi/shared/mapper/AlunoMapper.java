package labjb.jfpersonalapi.shared.mapper;

import labjb.jfpersonalapi.domain.dto.in.AlunoForm;
import labjb.jfpersonalapi.domain.dto.out.AlunoDto;
import labjb.jfpersonalapi.domain.entity.Aluno;
import labjb.jfpersonalapi.shared.utils.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {StringUtils.class})
public interface AlunoMapper extends BaseMaps<AlunoDto, Aluno, AlunoForm> {

    @Mappings({
            @Mapping(target = "cpf", source = "cpf", qualifiedByName = "removePontuacao"),
            @Mapping(target = "telefone", source = "telefone", qualifiedByName = "removePontuacao"),
            @Mapping(target = "tipoPessoa", constant = "ALUNO")
    })
    Aluno toEntity(AlunoForm form);

    @Mappings({
            @Mapping(target = "id", source = "uuid")
    })
    AlunoDto toDto(Aluno entity);
}
