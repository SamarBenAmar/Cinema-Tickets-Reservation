package com.exam.beans;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.exam.entities.Compte;

@Stateful public class UtilisateurBean implements Utilisateur {
@PersistenceContext(unitName="cinemaapp")
	private EntityManager em = null;
	private int user_id;
	public UtilisateurBean() {
		super();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void debite(float somme){
		float solde;
		solde = solde();
		if( solde+somme <= 0 ){
	
			throw new RuntimeException("Impossible de completer l'opération: solde négatif");
	
		}else{
	
			Compte compte;
			Query q = em.createNamedQuery("findCompteById");
			q.setParameter("cid",user_id);
			List<Compte> res = (List<Compte>)(q.getResultList());
			if(res.size()==0){
				throw new RuntimeException("Impossible de completer l'opération.");
			}else{
				compte = res.get(0);
				compte.setSolde(solde+somme);
				em.merge(compte);
			}
		}
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void credit(float somme){
		float solde;
		solde = solde();
		if( solde-somme <= 0 ){
	
			throw new RuntimeException("Impossible de completer l'opération: solde négatif");
	
		}else{
	
			Compte compte;
			Query q = em.createNamedQuery("findCompteById");
			q.setParameter("cid",user_id);
			List<Compte> res = (List<Compte>)(q.getResultList());
			if(res.size()==0){
				
			}else{
				compte = res.get(0);
				compte.setSolde(solde-somme);
				em.merge(compte);
			}
		}
	}
	public String getName() {
		Query q = em.createNamedQuery("findCompteById");
		q.setParameter("cid",user_id);
		List<Compte> res = (List<Compte>)(q.getResultList());
		if(res.size()==0){
			throw new RuntimeException("Impossible de completer l'opération: utilisateur introuvable");
			
		}else{
			 String nom = res.get(0).getName();
			 return nom;
		}
	}
	public void init(String name, String passwd){
		Query q = em.createNamedQuery("findCompteByName");
		q.setParameter("cname",name);
		List<Compte> res = (List<Compte>)q.getResultList();
		if (res==null || res.size()==0) {
			throw new RuntimeException("Impossible de completer l'opération: utilisateur introuvable");
		}else{
			if (res.get(0).getName().equals(name) && res.get(0).getPassword().equals(passwd)){
				user_id = res.get(0).getId();
			}else {
				
			}
		}
	}
	public float solde(){
		Query q = em.createNamedQuery("findCompteById");
		q.setParameter("cid",user_id);
		List<Compte> res = (List<Compte>)(q.getResultList());
		if(res.size()==0) {
			throw new RuntimeException("Impossible de completer l'opération: utilisateur introuvable");
		}else {
			float sld = res.get(0).getSolde();
			return sld;
		}
		
	}
}