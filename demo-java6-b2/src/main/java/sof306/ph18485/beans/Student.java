package sof306.ph18485.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	private String name;
	private Boolean gender = false;
	private Double marks = 0.0;
	private Contact contact;
	private List<String> subject;
	
}
