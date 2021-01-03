package com.contact.api.repository;

import com.contact.api.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact,Long> {
}
