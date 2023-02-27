package shop.tukoreamyway.back.domain.task.query.infra;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.query.application.TaskQueryRepositoryCustom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static shop.tukoreamyway.back.domain.task.entity.QTask.task;

@Repository
@RequiredArgsConstructor
public class TaskQueryRepositoryImpl implements TaskQueryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Task> findAllByCondition(final TaskSearchCondition condition) {
        return jpaQueryFactory.selectFrom(task).where(generateWhereQuery(condition)).fetch();
    }

    private Predicate[] generateWhereQuery(final TaskSearchCondition condition) {
        final List<Predicate> predicates = new ArrayList<>();
        Optional.ofNullable(condition.getStatus())
                .ifPresent(status -> predicates.add(task.status.eq(status)));
        Optional.ofNullable(condition.getCategory())
                .ifPresent(category -> predicates.add(task.category.eq(category)));
        Optional.ofNullable(condition.getSprintId())
                .ifPresent(sprint -> predicates.add(task.sprint.id.eq(sprint)));
        Optional.ofNullable(condition.getPlayerId())
                .ifPresent(player -> predicates.add(task.player.id.eq(player)));

        return predicates.toArray(new Predicate[0]);
    }
}
