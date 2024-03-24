package com.factorydigital.flixflex.shared;

public interface ObjectMapper<E,D> {

    public E toEntity(D dto);
    public D toDto(E entity);
}
