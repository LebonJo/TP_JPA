package com.bankonet.test;

import javax.persistence.*;

import com.bankonet.model.*;

/**
 * Teste la persistance de plusieurs classes, dont une "embedded".
 */
public class Test4 {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			emf = Persistence.createEntityManagerFactory("Employes");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			// Création de 3 employés
			Employe emp1 = new Employe("Dupond");
			Employe emp2 = new Employe("Durand");
			Employe emp3 = new Employe("Legrand");
			em.persist(emp1);
			em.persist(emp2);
			em.persist(emp3);
			// Création de 2 projets
			Projet pro1 = new Projet("Projet 1");
			Projet pro2 = new Projet("Projet 2");
			em.persist(pro1);
			em.persist(pro2);
			pro1.ajouterParticipant(emp1, "Chef de projet");
			pro1.ajouterParticipant(emp2, "Developpeur");
			pro2.ajouterParticipant(emp3, "Concepteur");
			pro2.ajouterParticipant(emp1, "Consultant");
			tx.commit();
		}
		catch(Exception e) {
			// En "vrai" il faudrait affiner un peu plus...
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}

