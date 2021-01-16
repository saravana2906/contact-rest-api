package com.contact.api.service;

import com.contact.api.entity.Contact;
import com.contact.api.entity.ContactPhone;
import com.contact.api.forms.CreateContactForm;
import com.contact.api.repository.ContactPhoneRepository;
import com.contact.api.repository.ContactRepository;
import com.contact.api.repository.UserRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactPhoneRepository contactPhoneRepository;

    public Contact getContact(Long contactId){

        return contactRepository.findById(contactId).orElseThrow(()-> new NoSuchElementException(contactId+" contact id doesn't exist"));
    }
    public Page<Contact> getAllContacts(Pageable pageable, Long userId){

        return contactRepository.findByUserUserId(userId,pageable);
    }
    public Contact updateContact(Contact contact){
        Contact dbCopy = contactRepository.findById(contact.getContactId()).get();
        dbCopy.setName(contact.getName());
        dbCopy.setEmailId(contact.getEmailId());
        dbCopy.setPhones(contact.getPhones());
        return contactRepository.save(contact);

    }
    public void deleteContact(Long contactId){
        contactRepository.deleteById(contactId);
    }

    public  Contact createContact(CreateContactForm createContactForm, String email) {
        Contact contact = new Contact();
        contact.setName(createContactForm.getName());
        contact.setEmailId(createContactForm.getEmailId());
        contact.setUser(userRepository.findById(createContactForm.getUserId()).get());
        contact =  contactRepository.save(contact);
        final Contact tmpContact = contact; // creating final just to work inside streams lambda
        List<ContactPhone> contactPhoneList = createContactForm.getPhoneNumber()
                .stream()
                .map(s -> {
                    ContactPhone cp = new ContactPhone();
                    cp.setPhoneNo(s);
                    cp.setContact(tmpContact);
                    return cp;
                })
                .collect(Collectors.toList());
        Iterable<ContactPhone> contactPhones = contactPhoneRepository.saveAll(contactPhoneList);
        List<ContactPhone> phoneList = IteratorUtils.toList(contactPhones.iterator());
        contact.setPhones(phoneList);
        return contact;

    }
}
