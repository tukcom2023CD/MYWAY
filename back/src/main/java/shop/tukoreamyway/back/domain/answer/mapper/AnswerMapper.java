package shop.tukoreamyway.back.domain.answer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {

    @Mapping(target = "content", source = "dto.content")
    @Mapping(target = "question", source = "question")
    Answer toEntity(AnswerRequest dto, Question question, Staff staff);
}
