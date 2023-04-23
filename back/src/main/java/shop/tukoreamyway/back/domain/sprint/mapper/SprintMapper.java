package shop.tukoreamyway.back.domain.sprint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import shop.tukoreamyway.back.domain.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SprintMapper {
    SprintResponse toResponse(Sprint entity);
}
