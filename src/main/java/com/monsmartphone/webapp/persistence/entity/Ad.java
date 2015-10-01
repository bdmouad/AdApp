package com.monsmartphone.webapp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "ad")
public class Ad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "title", length = 100, nullable = false)
	private String title;

	@Column(name = "login", length = 100, nullable = false)
	private String login;

	@Column(name = "photo1", length = 100, nullable = false)
	private String photo1;

	@Column(name = "photo2", length = 100, nullable = false)
	private String photo2;

	@Column(name = "photo3", length = 100, nullable = false)
	private String photo3;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "zip", length = 5, nullable = false)
	private String zip;

	/*@Lob
	@Column(name = "desc", nullable = false)
	private Character[] desc;
	
	@Column(name="DESC", columnDefinition="CLOB NOT NULL", table="EMP_DETAIL") 
	@Lob 
	public String getDescription() { return description; }

	@Column(name = "price", nullable = false)
	private Long price;*/
	
	@Column(name = "description", length = 100, nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	private User user;

}
