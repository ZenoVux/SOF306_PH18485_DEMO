package sof306.ph18485.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	private String id;
	@Column(name = "name")
	private String name;
	
}
