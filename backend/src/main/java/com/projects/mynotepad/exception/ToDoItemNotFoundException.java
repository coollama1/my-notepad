package com.projects.mynotepad.exception;

public class ToDoItemNotFoundException extends RuntimeException{

    public ToDoItemNotFoundException() {
        super();
    }

    public ToDoItemNotFoundException(String message) {
        super(message);
    }

    public ToDoItemNotFoundException(Throwable cause) {
        super(cause);
    }

}
