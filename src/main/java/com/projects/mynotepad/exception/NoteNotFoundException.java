package com.projects.mynotepad.exception;

public class NoteNotFoundException extends RuntimeException{

    public NoteNotFoundException() {
        super();
    }

    public NoteNotFoundException(String message) {
        super(message);
    }

    public NoteNotFoundException(Throwable cause) {
        super(cause);
    }

}
