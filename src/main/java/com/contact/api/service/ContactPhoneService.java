package com.contact.api.service;

import com.contact.api.entity.Contact;
import com.contact.api.entity.ContactPhone;
import com.contact.api.forms.CreateContactPhoneForm;
import com.contact.api.repository.ContactPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactPhoneService {

    @Autowired
    ContactPhoneRepository contactPhoneRepository;



    public ContactPhone updateContactPhone(ContactPhone contactphone){
        ContactPhone cphone=contactPhoneRepository.findById(contactphone.getPhoneId()).get();
        cphone.setPhoneNo(contactphone.getPhoneNo());
        return contactPhoneRepository.save(cphone);
    }
    public ContactPhone getContactPhoneForContact(Long contactPhoneId){
        return contactPhoneRepository.findById(contactPhoneId).get();
    }
    public void deleteContactPhone(Long contactPhoneId){

        contactPhoneRepository.deleteById(contactPhoneId);
    }

    public ContactPhone createContactPhone(CreateContactPhoneForm createContactPhoneForm) {

        ContactPhone cp = new ContactPhone();
        Contact c = new Contact();
        cp.setPhoneNo(createContactPhoneForm.getPhoneNumber());
        c.setContactId(createContactPhoneForm.getContactId());
        cp.setContact(c);

        return contactPhoneRepository.save(cp);
    }
}
