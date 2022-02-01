package com.projects.mynotepad.exception;

public class ToDoListNotFoundException extends RuntimeException{

    public ToDoListNotFoundException() {
        super();
    }

    public ToDoListNotFoundException(String message) {
        super(message);
    }

    public ToDoListNotFoundException(Throwable cause) {
        super(cause);
    }

}
