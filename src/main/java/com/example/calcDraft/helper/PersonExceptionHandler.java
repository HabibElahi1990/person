package com.example.calcDraft.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> exceptionHandler(Exception e) {
        Message message = new Message(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(message.toString(), HttpStatus.BAD_REQUEST);
    }
}

class Message {
    private String error;
    private HttpStatus errorCode;

    Message(String error, HttpStatus errorCode) {
        this.error = error;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "Message{" +
                "\n\terror='" + error + ',' +
                "\n\terrorCode='" + errorCode +
                "\n" + '}';
    }
}
