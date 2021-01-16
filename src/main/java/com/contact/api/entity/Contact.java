package com.contact.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contact {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	private String name;
	private String emailId;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
	@JsonIgnore
	private User user;
	@OneToMany(mappedBy = "contact",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	List<ContactPhone> phones;
}
