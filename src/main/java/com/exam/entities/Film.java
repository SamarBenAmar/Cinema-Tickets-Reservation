package com.exam.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="FILMS")
@NamedQueries({
	@NamedQuery(name = "findAllFilms", query = "SELECT f FROM Films f"),
	@NamedQuery(name = "findFilmByPattern", query = "SELECT f FROM Films f WHERE f.name =:%fname%"),
	@NamedQuery(name = "findFilmById", query = "SELECT f FROM Films WHERE f.id =:fid"),
	@NamedQuery(name = "findFilmByTarif", query = "SELECT f FROM Films WHERE f.tarif =:ftarif"),
})
public class Film implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(targetEntity=SalleProg.class, mappedBy="id")
	private List<SalleProg> salleProg = new ArrayList<>();
	public Film() {
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Film[id=").append(getId()).append(", name=").append(getName()).append("]");
		return sb.toString();
	}
	
}
