package com.luigisback.kaizen_api.exception;

public class HabitLogAlreadyExistsException extends RuntimeException{

    public HabitLogAlreadyExistsException (String message){
        super(message);
    }
}
