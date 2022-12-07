package sof306.ph18485.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RegisterDTO {
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String fullname;
	@NotEmpty
	@Email
	private String email;

}
