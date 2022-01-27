package com.projects.mynotepad.exception;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException() {
        super();
    }

    public EventNotFoundException(String message) {
        super(message);
    }

    public EventNotFoundException(Throwable cause) {
        super(cause);
    }

}
