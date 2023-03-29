package shop.tukoreamyway.back.domain.question.command.application;

import shop.tukoreamyway.back.domain.question.entity.Tag;

import java.util.Optional;

public interface TagRepository {
    Tag save(Tag tag);

    Optional<Tag> findByName(String name);
}
