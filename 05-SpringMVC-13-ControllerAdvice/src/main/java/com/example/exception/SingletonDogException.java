package com.example.exception;

public class SingletonDogException extends Exception{
    public SingletonDogException() {
        super();
    }

    public SingletonDogException(String message) {
        super(message);
    }
}
