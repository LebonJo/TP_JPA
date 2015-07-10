package com.bankonet.model;

//import javax.persistence.Embedded;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@DiscriminatorValue("Client")
public class Client extends Personne {
	
	@Embedded // optionnel 
	private Adresse adresse;

	public Client(){
		super();
	}

	public Client(String nom, Adresse adresse){
		super();
		this.setNom(nom);
		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
