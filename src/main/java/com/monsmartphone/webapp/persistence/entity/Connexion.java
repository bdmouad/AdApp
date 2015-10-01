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
@Table(name = "connexion")
public class Connexion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "ip", length = 15, nullable = false)
	private Long ip;

	@Column(name = "country", length = 100, nullable = false)
	private String country;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "start_time", length = 100, nullable = false)
	private String time;

	@Column(name = "duration", length = 100, nullable = false)
	private Long duration;

	@Column(name = "device", length = 100, nullable = false)
	private String device;

	@Column(name = "os", length = 100, nullable = false)
	private String os;

	@Column(name = "browser", length = 100, nullable = false)
	private String browser;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	private User user;

}
