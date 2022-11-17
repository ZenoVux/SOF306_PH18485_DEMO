package sof306.ph18485.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	private String fullname;
	private Boolean gender = false;
	private Double marks = 0.0;
	private String email;
	private String country;
	
}
