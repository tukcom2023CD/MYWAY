package shop.tukoreamyway.back.domain.answercomment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerCommentMapper {

    @Mapping(target = "content", source = "dto.content")
    @Mapping(target = "answer", source = "answer")
    AnswerComment toEntity(AnswerCommentRequest dto, Answer answer, Staff writer);
}
