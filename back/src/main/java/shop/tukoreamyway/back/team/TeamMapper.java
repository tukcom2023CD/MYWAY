package shop.tukoreamyway.back.team;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.team.dto.TeamRequest;
import shop.tukoreamyway.back.team.dto.TeamResponse;
import shop.tukoreamyway.back.team.dto.TeamSummary;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    @Mapping(target = "name", source = "dto.name")
    Team toEntity(TeamRequest dto, Member leader);
    TeamResponse toResponse(Team entity);
    TeamSummary toSummary(Team entity);
}
