package com.example.directors_api.exceptions;

public class MovieException extends RuntimeException{


    public MovieException(String msg, Throwable cause){
        super(msg,cause);
    }
    public MovieException(String msg){
        super(msg);
    }


}
