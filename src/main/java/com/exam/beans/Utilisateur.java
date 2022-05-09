package com.exam.beans;

import javax.ejb.Remote;

@Remote
public interface Utilisateur {
//Initialiser le bean compte bancaire utilisateur (authentification) public
	void init(String name, String passwd);
	public String getName();
	public float solde(); // Débiter le compte de l'utilisateur
	public void debite(float f) ;
	public void credit(float f) ;
}
