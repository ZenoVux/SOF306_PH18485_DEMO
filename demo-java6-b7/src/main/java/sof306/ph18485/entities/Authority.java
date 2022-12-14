package sof306.ph18485.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"username", "role_id"})
})
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
