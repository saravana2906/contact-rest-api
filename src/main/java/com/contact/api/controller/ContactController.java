package com.contact.api.controller;


import com.contact.api.dto.Pageutil;
import com.contact.api.entity.Contact;
import com.contact.api.forms.CreateContactForm;
import com.contact.api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public Contact createContact(@RequestBody  @Validated CreateContactForm createContactForm,@AuthenticationPrincipal Jwt jwt){
        return contactService.createContact(createContactForm, (String)jwt.getClaim("email"));
    }

    @DeleteMapping("/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long contactId){
        contactService.deleteContact(contactId);
    }


    @PostMapping("/user/{userId}")
    public Page<Contact> getAllContacts(@RequestBody Pageutil pageutil, @PathVariable Long userId, @AuthenticationPrincipal Jwt jwt){

        return contactService.getAllContacts(pageutil,userId);
    }

    @PutMapping("/user/{userId}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable Long userId){
        return contactService.updateContact(contact,userId);
    }

    @GetMapping("/{contactId}")
    public Contact getContact(@PathVariable Long contactId){
        return contactService.getContact(contactId);
    }


}
