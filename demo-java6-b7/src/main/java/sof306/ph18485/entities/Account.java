package sof306.ph18485.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "full_name")
	private String fullname;
	@Column(name = "email")
	private String email;
	@Column(name = "photo")
	private String photo;
}
