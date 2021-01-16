package com.contact.api.forms;

import lombok.Data;

@Data
public class CreateContactPhoneForm {

    String phoneNumber;

    Long contactId;
}
