package com.contact.api.exception;

public class ClientRequestException extends  Exception{

    public ClientRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientRequestException(String message) {
        super(message);
    }

    public ClientRequestException(){
        super();
    }
}
