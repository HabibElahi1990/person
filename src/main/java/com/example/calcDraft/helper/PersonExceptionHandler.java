package com.example.calcDraft.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.Date;


@ControllerAdvice
public class PersonExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> exceptionHandler(IllegalArgumentException e) {
        Message message = new Message("dadach requestted eshkal dare", new Date());
        return new ResponseEntity<>(message.toString(), HttpStatus.NOT_EXTENDED);
    }
}

class Message {
    private String error;
    private Date errorDate;

    Message(String error, Date errorDate) {
        this.error = error;
        this.errorDate = errorDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "\n\terror='" + error + ',' +
                "\n\terrorDate='" + errorDate +
                "\n" + '}';
    }
}
