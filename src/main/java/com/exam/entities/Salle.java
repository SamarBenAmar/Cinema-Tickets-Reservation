package com.exam.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="SALLE")
@NamedQueries({
	@NamedQuery(name = "findAllSalles", query = "SELECT s FROM Salle s"),
	@NamedQuery(name = "findSalleByName", query = "SELECT s FROM Salle s WHERE s.name =:sname"),
	@NamedQuery(name = "findSalleById", query = "SELECT s FROM Salle WHERE s.id =:sid")
})

public class Salle implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private int capacity;
	@OneToOne
	@JoinColumn(name="idSalleProg",nullable=false)
	private SalleProg salleProg;
	public Salle() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Salle[id=").append(getId()).append(", name=").append(getName()).append(", address=").append(getAddress()).append(", capacity=").append(getCapacity()).append("]");
		return sb.toString();
	}
}
