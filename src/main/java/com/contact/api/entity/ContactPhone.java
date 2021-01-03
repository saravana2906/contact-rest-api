package com.contact.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ContactPhone {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phoneId;
	private String phoneNo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contactId", nullable = false)
	private Contact contact;

}
