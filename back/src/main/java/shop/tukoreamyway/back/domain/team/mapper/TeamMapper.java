package shop.tukoreamyway.back.domain.team.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.team.dto.TeamRequest;
import shop.tukoreamyway.back.domain.team.entity.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    Team toEntity(TeamRequest dto);
}
