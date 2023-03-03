package shop.tukoreamyway.back.global.service;

public interface EntityLoader<T, ID> {
    T getEntity(ID id);
}
