package com.contact.api.repository;

import com.contact.api.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact,Long> {

    Page<Contact> findByUserUserId(Long userId, Pageable pageable);
}
