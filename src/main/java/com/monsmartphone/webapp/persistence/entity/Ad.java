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

	@Column(name = "username", length = 100, nullable = false)
	private String username;

	@Column(name = "photo1", nullable = true)
	private byte[] photo1;

	@Column(name = "photo2", nullable = true)
	private byte[] photo2;

	@Column(name = "photo3", nullable = true)
	private byte[] photo3;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "zip", length = 5, nullable = false)
	private String zip;

	@Column(name = "price", nullable = false)
	private Long price;

	@Column(name = "adtext", length = 100, nullable = false)
	private String adtext;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "idmodel", referencedColumnName = "id")
	private Model model;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPhoto1() {
		return photo1;
	}

	public void setPhoto1(byte[] photo1) {
		this.photo1 = photo1;
	}

	public byte[] getPhoto2() {
		return photo2;
	}

	public void setPhoto2(byte[] photo2) {
		this.photo2 = photo2;
	}

	public byte[] getPhoto3() {
		return photo3;
	}

	public void setPhoto3(byte[] photo3) {
		this.photo3 = photo3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getAdtext() {
		return adtext;
	}

	public void setAdtext(String adtext) {
		this.adtext = adtext;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
