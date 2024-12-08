package com.github.nmsilos.gamesapi.exception.custom;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
