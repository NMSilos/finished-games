package com.github.nmsilos.gamesapi.exception.handler;

import com.github.nmsilos.gamesapi.exception.DefaultErrorMessage;
import com.github.nmsilos.gamesapi.exception.EntityNotFoundException;
import com.github.nmsilos.gamesapi.exception.NullElementException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(NullElementException.class)
    public ResponseEntity<DefaultErrorMessage> handleNullElementException(NullElementException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DefaultErrorMessage> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DefaultErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

}
