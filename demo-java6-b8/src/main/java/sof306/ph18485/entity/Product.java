package sof306.ph18485.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "photo", length = 50)
	private String photo;
	@Column(name = "description", length = 100)
	private String description;
	@Column(name = "price")
	private Double price;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "create_date")
	private Date createDate;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@Column(name = "available")
	private Boolean available;
}
