package com.contact.api.entity;

import com.contact.api.forms.SignupForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
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
	//private String password;
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
