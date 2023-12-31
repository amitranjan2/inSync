package com.codingstreams.jwtauth.GlobalExceptionHandler;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
public ResponseEntity<String> handleException(Exception ex) {
    HttpStatus status = determineHttpStatus(ex);
    return ResponseEntity.status(status).body(ex.getMessage());
}

    private HttpStatus determineHttpStatus(Exception ex) {
        if (ex.getMessage() != null && ex.getMessage().contains("404")) {
            return HttpStatus.NOT_FOUND;
        } else if (ex.getMessage() != null && ex.getMessage().contains("400")) {
            return HttpStatus.BAD_REQUEST;
        }
        // Add more conditions as needed

        // Default to Internal server error
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
