package com.contact.api.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdate {

    @NotNull
    Long userId;
    @NotNull
    @NotBlank
    String userName;
    @NotBlank
    @NotNull
    String emailId;
    @NotNull
    @NotBlank
    String phone;


}
