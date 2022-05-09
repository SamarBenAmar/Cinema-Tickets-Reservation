package com.exam.beans;


import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.exam.entities.Film;
import com.exam.entities.SalleProg;
import com.exam.entities.Seance;

@Stateless(name="CN")
public class CinemaBean implements Cinema {
@PersistenceContext(unitName="cinemaapp")
	private EntityManager em = null;

@Override
public Set<Film> list() {
	Query q = em.createNamedQuery("findAllFilms");
	Set<Film> res = (Set<Film>)q.getResultList();
	if (res==null || res.size()==0) {
		throw new RuntimeException("La liste des films disponibles est vide.");
	}else{ 
		return res;
	}
}

@Override
public Set<Film> findByPattern(String pattern) {
	Query q = em.createNamedQuery("findFilmByPattern");
	Set<Film> res = (Set<Film>)q.getResultList();
	q.setParameter("fname",pattern);
	if (res==null || res.size()==0) {
		throw new RuntimeException("Pas de films avec ce pattern.");
	}else{ 
		return res;
	}
}

@Override
public Film findFilm(int id) {
	Query q = em.createNamedQuery("findFilmById");
	Film res = (Film)q.getResultList();
	q.setParameter("fid",id);
	if (res==null) {
		throw new RuntimeException("Pas de films avec cet id.");
	}else{ 
		return res;
	}
}

@Override
public void reserve(Seance seance, Utilisateur u) {
	Query q = em.createNamedQuery("findSeanceById");
	Seance res = (Seance)q.getResultList();
	q.setParameter("scid",seance.getId());
	SalleProg salleProg = res.getSalleProg();
	int capacite = salleProg.getSalle().getCapacity();
	int places = res.getPlaces();
	float tarif = res.getTarif();
	if (places < capacite) {
		places++;
		u.credit(tarif);
		em.merge(seance);
	} else {
		throw new RuntimeException("Pas de places vides.");
	}
	
}

@Override
public Set<SalleProg> getAllSalleProg() {
	Query q = em.createNamedQuery("findAllSalleProg");
	Set<SalleProg> res = (Set<SalleProg>)q.getResultList();
	if (res==null || res.size()==0) {
		throw new RuntimeException("La liste des salles est vide.");
	}else{ 
		return res;
	}
}

@Override
public Film createFilm(String name) {
	Film f = new Film();
	f.setName(name);
	em.persist(f);
	return f;	
}

@Override
public void update(Film f) {
	em.merge(f);
}

public Seance getSeanceById(int id) {
	Query q = em.createNamedQuery("FindSeanceById");
	Seance res = (Seance)q.getResultList();
	q.setParameter("scid",id);
	if (res==null) {
		throw new RuntimeException("Pas de seances avec cet id.");
	}else{ 
		return res;
	}
}

@Override
public float getTarif(Seance sc) {
	return sc.getTarif();
}
}
