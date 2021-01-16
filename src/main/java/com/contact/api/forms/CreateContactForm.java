package com.contact.api.forms;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class CreateContactForm {

    @NotNull
    @Min(value = 1)
    private Long userId;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String emailId;

    @NotEmpty
    private List<@NotNull @NotBlank String> phoneNumber;

}
