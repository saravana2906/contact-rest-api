package com.contact.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContactPhone {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phoneId;
	private String phoneNo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contactId", nullable = false)
	@JsonIgnore
	private Contact contact;

}
