package br.com.zup.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Price {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String status;
	@Column
	private Date date;
	
	@OneToMany(mappedBy = "price", targetEntity = Contract.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Contract> contracts;

	

	public Price(String name, String description, String status, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.date = date;
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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



	public Price() {

	}



	public List<Contract> getContracts() {
		return contracts;
	}



	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}


}
