package shop.tukoreamyway.back.global.service;

public interface EntityQueryService<T, ID> {
    T getEntity(ID id);
}
