package com.contact.api.config;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {

    String message;

    Date timestamp;

}
