package com.contact.api.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class SignupForm {
    @NotNull
    @NotBlank
    private String name;
    @Email
    @NotNull
    @NotBlank
    private String emailId;
    @NotNull
    @NotBlank
    @Length(min=10, max=13)
    private String phoneNumber;
}
