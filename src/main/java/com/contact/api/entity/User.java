package com.contact.api.entity;

import com.contact.api.forms.SignupForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;
	@Column(unique = true,nullable = false)
	private String emailId;
	@Column(unique = true,nullable = false)
	private String phoneNo;
	//private String password; Not need as application using OAuth keycloak
	@JsonIgnore // In order to avoid circular reference of user from contact
	@OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	List<Contact> contact;

	public User(String name, String emailId, String phoneNumber) {
		this.userName=name;
		this.emailId=emailId;
		this.phoneNo=phoneNumber;
	}

	public static User getUserForSignUp(SignupForm signupForm) {
		return new User(signupForm.getName(),signupForm.getEmailId(),signupForm.getPhoneNumber());
	}
}
