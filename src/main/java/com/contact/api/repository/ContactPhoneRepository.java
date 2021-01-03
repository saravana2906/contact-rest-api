package com.contact.api.repository;

import com.contact.api.entity.ContactPhone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactPhoneRepository extends PagingAndSortingRepository<ContactPhone,Long> {
}
