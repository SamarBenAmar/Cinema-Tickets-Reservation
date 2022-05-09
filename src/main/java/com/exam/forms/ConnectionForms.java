package com.exam.forms;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import com.exam.beans.CinemaBean;
import com.exam.beans.Utilisateur;
import com.exam.entities.Compte;

public class ConnectionForms {
	private EntityManager em;
	private String resultat;
	private CinemaBean cinema;
	public ConnectionForms() {
		super();
	}
	public void verif(HttpServletRequest req) {
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		Utilisateur user = null;
		user.init(login, pass);
		Query q = em.createNamedQuery("findCompteByName");
		q.setParameter("cid",user.getName());
		List<Compte> res = (List<Compte>)(q.getResultList());
		if(res.size()==0){
			resultat ="Introuvable!";
		}else{
			resultat="Réservation terminée!";
			user.credit(cinema.getTarif(null));
		}
	}
	public String getResultat() {
		return resultat;
	}
}
