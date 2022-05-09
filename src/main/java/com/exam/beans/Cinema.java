package com.exam.beans;

import java.util.Set;

import javax.ejb.Remote;

import com.exam.entities.Film;
import com.exam.entities.SalleProg;
import com.exam.entities.Seance;

@Remote
public interface Cinema {
	// Lister l'ensemble de films disponible au cinema.
	public Set<Film> list();
	// Trouver les films correspondants au pattern donn� en entr�e.
	public Set<Film> findByPattern (String pattern);
	// Trouver un film � partir d'un id.
	public Film findFilm (int id);
	// R�server une s�ance pour un utilisateur.
	public void reserve (Seance seance, Utilisateur u);
	public Set<SalleProg> getAllSalleProg ();
	public Film createFilm (String name);
	public void update (Film f);
	public float getTarif (Seance sc);
}