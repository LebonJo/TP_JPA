package com.bankonet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;





import javax.persistence.CascadeType;
//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/** 
 * Un employé de l'entreprise.
 */
//@DiscriminatorValue("Employe")
@Entity
@NamedQuery(name="getNameEmployes", query="select e.nom from Employe as e")
public class Employe extends Personne{

	private BigDecimal salaire;
	@ManyToOne
	private Employe superieur;
	@ManyToOne
	private Departement departement;
	@ManyToMany
	private Collection<Projet> projets = new ArrayList<Projet>();
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="employe")
	private Collection<Participation> participations = new ArrayList<Participation>();

	public Employe(){
		super();
	}

	public Employe(String nom){
		super();
		this.setNom(nom);
	}
	
	public Employe(String nom, Departement dep, Employe sup){
		super();
		this.setNom(nom);
		dep.addEmploye(this);
		this.departement = dep;
		this.superieur = sup;
	}

	public BigDecimal getSalaire() {
		return salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public Employe getSuperieur() {
		return superieur;
	}

	public void setSuperieur(Employe employe) {
		this.superieur = employe;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Collection<Projet> getProjets() {
		return projets;
	}

	public void addProjet(Projet projet) {
		projet.getEmployes().add(this);
		this.projets.add(projet);
	}
	
	public void removeProjet(Projet projet){
		projet.getEmployes().remove(this);
		this.projets.remove(projet);
	}
	
	public Collection<Participation> getParticipations(){
		return this.participations;
	}
}
