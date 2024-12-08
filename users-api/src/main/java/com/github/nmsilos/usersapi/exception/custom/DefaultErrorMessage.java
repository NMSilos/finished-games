package com.github.nmsilos.usersapi.exception.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
@ToString
public class DefaultErrorMessage {

    private String path;
    private String method;
    private int status;
    private String statusMessage;
    private String message;

    public DefaultErrorMessage(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.status = status.value();
        this.statusMessage = status.getReasonPhrase();
        this.message = message;
    }

}