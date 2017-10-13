package br.com.zup.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Contract implements Serializable {

	private static final long serialVersionUID = 12422142342343L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String value;
	@Column
	private String status;
	@Column
	private Date date;
	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonBackReference
	private Client client;
	@ManyToOne
	@JoinColumn(name = "price_id")
	@JsonBackReference
	private Price price;
	@ManyToOne
	@JoinColumn(name = "lineofBusiness_id")
	@JsonBackReference
	private LineofBusiness lineofBusiness;

	public Contract(String name, String value, String status, Date date, Client client, Price price,
			LineofBusiness lineofBusiness) {
		super();
		this.name = name;
		this.value = value;
		this.status = status;
		this.date = date;
		this.client = client;
		this.price = price;
		this.lineofBusiness = lineofBusiness;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Contract() {

	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public LineofBusiness getLineofBusiness() {
		return lineofBusiness;
	}

	public void setLineofBusiness(LineofBusiness lineofBusiness) {
		this.lineofBusiness = lineofBusiness;
	}

}
