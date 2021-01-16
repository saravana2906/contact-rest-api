package com.contact.api.controller;

import com.contact.api.entity.ContactPhone;
import com.contact.api.forms.CreateContactPhoneForm;
import com.contact.api.service.ContactPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ContactPhones")
public class ContactPhoneController {

    @Autowired
    ContactPhoneService contactPhoneService;

    @GetMapping("/{contactPhoneId}")
    public ContactPhone getContactPhone(@PathVariable Long contactPhoneId){
        return contactPhoneService.getContactPhoneForContact(contactPhoneId);
    }

    @DeleteMapping("/{contactPhoneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteContactPhoneNumber(@PathVariable Long contactPhoneId){
        contactPhoneService.deleteContactPhone(contactPhoneId);
    }

    @PutMapping
    public ContactPhone updateContactPhone(@RequestBody ContactPhone contactPhone, @AuthenticationPrincipal Jwt jwt){
        return contactPhoneService.updateContactPhone(contactPhone);
    }
    @PostMapping
    public ContactPhone createContactPhone(@RequestBody CreateContactPhoneForm createContactPhoneForm){
        return  contactPhoneService.createContactPhone(createContactPhoneForm);
    }


}
