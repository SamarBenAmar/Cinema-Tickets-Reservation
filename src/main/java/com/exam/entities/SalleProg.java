package com.exam.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="SALLEPROG")
@NamedQueries({
	@NamedQuery(name = "findAllSallesProg", query = "SELECT sp FROM SalleProg sp"),
	@NamedQuery(name = "findSalleProgByName", query = "SELECT sp FROM SalleProg sp WHERE sp.name =:spname"),
	@NamedQuery(name = "findSalleProgById", query = "SELECT sp FROM SalleProg WHERE sp.id =:spid")
})

public class SalleProg {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="idSalle",nullable=false)
	private Salle salle;
	@OneToMany(targetEntity=Seance.class, mappedBy="salleProg")
	private List<Seance> sceances = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="idFilm", nullable=false)
	private Film film;
	public SalleProg() {
		super();
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public List<Seance> getSceances() {
		return sceances;
	}
	public void setSceances(List<Seance> sceances) {
		this.sceances = sceances;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SalleProg[id=").append(getId()).append("]");
		return sb.toString();
	}
}
