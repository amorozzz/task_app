package dev.amorozzz.app.utils.mapper;

import dev.amorozzz.app.model.dto.DivisionDto;
import dev.amorozzz.app.model.entity.Division;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DivisionMapper {
    Division toModel(DivisionDto divisionDto);
    DivisionDto toDto(Division division);
}
