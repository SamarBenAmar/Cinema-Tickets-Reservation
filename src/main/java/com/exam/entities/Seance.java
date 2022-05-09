package com.exam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="SEANCE")
@NamedQueries({
	@NamedQuery(name = "findAllSeances", query = "SELECT sc FROM Seance sc"),
	@NamedQuery(name = "findSeanceById", query = "SELECT sc FROM Seance WHERE sc.id =:scid")
})

public class Seance {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date horaire;
	private float tarif;
	private int places;
	
	@ManyToOne
	@JoinColumn(name="idSalleProg", nullable = false)
	private SalleProg salleProg;
	public Seance() {
		super();
	}
	public Seance(int id, Date horaire, float tarif, int places) {
		this.id = id;
		this.horaire= horaire;
		this.tarif=tarif;
		this.places=places;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getHoraire() {
		return horaire;
	}
	public void setHoraire(Date horaire) {
		this.horaire = horaire;
	}
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	public int getPlaces() {
		return places;
	}
	public void setPlaces(int places) {
		this.places = places;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Seance[id=").append(getId()).append(", horaire=").append(getHoraire()).append(", places=").append(getPlaces()).append(", tarif=").append(getTarif()).append("]");
		return sb.toString();
	}
	public SalleProg getSalleProg() {
		return salleProg;
	}
	public void setSalleProg(SalleProg salleProg) {
		this.salleProg = salleProg;
	}
}
