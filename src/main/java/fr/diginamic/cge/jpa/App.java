package fr.diginamic.cge.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EAdresse;
import fr.diginamic.banque.model.EAssuranceVie;
import fr.diginamic.banque.model.EBClient;
import fr.diginamic.banque.model.EBanque;
import fr.diginamic.banque.model.ELivretA;
import fr.diginamic.banque.model.EOperation;
import fr.diginamic.banque.model.EVirement;
import fr.diginamic.cge.jpa.model.EEmprunt;
import fr.diginamic.cge.jpa.model.ELivre;


public class App 
{
    public static void main( String[] args )
    {
       

    }
    
   
    
    
    
    
    
    private static void getLivreById(EntityManager em, Integer id)
    {
    	
        ELivre eLivre1 = em.find(ELivre.class, id);
        System.out.println(eLivre1.getTitre());
        System.out.println(eLivre1.getAuteur());
    }
    
    private static void setNewLivre(EntityManager em, String auteur, String titre)
    {
    	em.getTransaction().begin();
        ELivre eLivre2 = new ELivre();
        eLivre2.setAuteur("Auteur");
        eLivre2.setTitre("Titre");
        em.persist(eLivre2);
        em.getTransaction().commit();
        System.out.println(eLivre2.getId());
    }
    
    private static void setTitreById(EntityManager em, String titre, Integer id)
    {
    	em.getTransaction().begin();
        ELivre eLivre = em.find(ELivre.class, id);
        eLivre.setTitre(titre);
        em.merge(eLivre);
        em.getTransaction().commit();
    }
    
    private static void getAllLivre(EntityManager em)
    {
    	List<ELivre> results = em.createQuery("select l from ELivre l", ELivre.class)
        	.getResultList();
        results.stream().forEach(livre -> System.out.println(livre.getTitre() + " - " + livre.getAuteur()));
    }
    
    private static void getLivreByTitre(EntityManager em, String titre)
    {
        ELivre result = em.createQuery("select l from ELivre l where l.titre LIKE :titre", ELivre.class)
        	.setParameter("titre", titre)
        	.getResultList().get(0);
        System.out.println(result.getAuteur());
    }
    
    private static void getLivreByAuteur(EntityManager em, String auteur)
    {
    	ELivre result = em.createQuery("select l from ELivre l where l.auteur LIKE :auteur", ELivre.class)
    		.setParameter("auteur", auteur)
    		.getResultList().get(0);
    	System.out.println(result.getTitre());
    }
    
    private static void deleteLivre(EntityManager em, Integer id)
    {
        em.getTransaction().begin();
        ELivre livreToDelete = em.find(ELivre.class, id);
        em.remove(livreToDelete);
        em.getTransaction().commit();
    }
    
    private static void getEmpruntWithBooks(EntityManager em, Integer id)
    {
        EEmprunt emprunt = em.find(EEmprunt.class, id);
        System.out.println(emprunt.getId());
        System.out.println(emprunt.getDateDebut());
        System.out.println(emprunt.getDelai());
        System.out.println(emprunt.getDateDebut());
        System.out.println(emprunt.getClientEmprunt().getPrenom() + " " + emprunt.getClientEmprunt().getNom());
        System.out.println("Livres empruntés :");
        emprunt.getEmpruntLivres().stream().forEach(livre -> System.out.println(livre.getTitre()));
    }
    
    private static void getBookWithEmprunts(EntityManager em, Integer id)
    {
    	ELivre livre = em.find(ELivre.class, id);
    	System.out.println(livre.getTitre());
    	System.out.println(livre.getAuteur());
    	System.out.println("Emprunté par :");
    	livre.getLivreEmprunts().stream().forEach(emprunt -> System.out.println(emprunt.getClientEmprunt().getPrenom() + " " + emprunt.getClientEmprunt().getNom()));
    }
}
