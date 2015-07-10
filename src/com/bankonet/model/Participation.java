package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participation {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Employe employe;
	@ManyToOne
	private Projet projet;
	private String fonction;
	
	public Participation(){
		super();
	}
	
	public Participation(Employe employe, Projet projet, String fonction){
		super();
		this.employe = employe;
		this.projet = projet;
		this.fonction = fonction;
	}
	
	public String getFonction(){
		return this.fonction;
	}

}
