package labjb.jfpersonalapi.shared.mapper;

import labjb.jfpersonalapi.domain.dto.in.MatriculaForm;
import labjb.jfpersonalapi.domain.dto.out.MatriculaDto;
import labjb.jfpersonalapi.domain.entity.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MatriculaMapper extends BaseMaps<MatriculaDto, Matricula, MatriculaForm>{

    @Mappings({
            @Mapping(target = "id", source = "uuid")
    })
    MatriculaDto toDto(Matricula matricula);
}
