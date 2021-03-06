package com.contact.api.repository;

import com.contact.api.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

     User findByEmailId(String emailId);
}
