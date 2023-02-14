package shop.tukoreamyway.back.domain.team.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.team.dto.TeamRequest;
import shop.tukoreamyway.back.domain.team.entity.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    @Mapping(target = "name", source = "dto.name")
    Team toEntity(TeamRequest dto, Member leader);
}
