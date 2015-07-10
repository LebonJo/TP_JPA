package com.bankonet.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankonet.model.Employe;

public class Test3 {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employes");
		EntityManager em = emf.createEntityManager();
		
		
		// Récupère des entités
		// 1
//		String texteQuery1 = "select e from Employe as e where upper(e.departement.nom) = :nomDept";
//		Query  query1 = em.createQuery(texteQuery1);
//		query1.setParameter("nomDept", "Direction");
//		List<Employe> listeEmployes = (List<Employe>)query1.getResultList();
//		for(Employe employe : listeEmployes){
//			System.out.println("Employés du département Direction = " + employe.getNom());
//			employe.setSalaire(employe.getSalaire().multiply(new BigDecimal(1.05)));
//			EntityTransaction tx = em.getTransaction();
//			try{
//				tx.begin();
//				em.persist(employe);
//				tx.commit();
//			} catch(Exception e) {
//				e.printStackTrace();
//				if (tx != null) {
//					tx.rollback();
//				}
//			}
//		}
		
		// 2
		String texteQuery2 = "select e.nom, e.salaire from Employe as e";
		Query query2 = em.createQuery(texteQuery2);
//		List<Object[]> liste = (List<Object[]>)query2.getResultList();
//		for (Object[] info : liste) {
//			System.out.println(info[0] + "gagne" + info[1]);
//		}
		
		// 3
//		List<String> names = em.createNamedQuery("getNameEmployes").getResultList();
//		for(String name : names){
//			System.out.println(name);
//		}
		
		// 4
		String texteQuery1 = "select e from Employe as e";
		Query  query1 = em.createQuery(texteQuery1);
		List<Employe> listeEmployes = (List<Employe>)query1.getResultList();
		EntityTransaction tx = em.getTransaction();
		String texteQuery4 = "update Employe e set e.salaire = 2200";
		Query  query4 = em.createQuery(texteQuery4);
		tx.begin();
		int updateCount = query4.executeUpdate();
		tx.commit();
		System.out.println("Nombre de salaires modifiés = " + updateCount);
		Employe emp = listeEmployes.get(0);
		System.out.println("Salaire de " + emp.getNom() + "avant refresh = " + emp.getSalaire());
		em.refresh(emp);
		System.out.println("Salaire de " + emp.getNom() + "après refresh = " + emp.getSalaire());
		
		
	}

}
