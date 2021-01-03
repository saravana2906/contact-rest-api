package com.contact.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Contact {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	private String name;
	private String emailId;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
	private User user;
	@OneToMany(mappedBy = "contact",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	List<ContactPhone> phones;
}
