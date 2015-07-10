package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Projet {
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	
	//private transient String attributNonPersiste;
	
	@ManyToMany(mappedBy="projets")
	private Collection<Employe> employes = new ArrayList<Employe>();
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="projet")
	private Collection<Participation> participations = new ArrayList<Participation>();
	
	public Projet(){
		super();
	}
	
	public Projet(String nom){
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Employe> getEmployes() {
		return employes;
	}
	
	public void ajouterParticipant(Employe employe, String fonction){
		Participation participation = new Participation(employe, this, fonction);
		employe.getParticipations().add(participation);
		this.participations.add(participation);
	}
}
