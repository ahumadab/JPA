package fr.diginamic.banque.dao.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EAssuranceVie;
import fr.diginamic.banque.model.EBClient;
import fr.diginamic.banque.model.ELivretA;
import fr.diginamic.banque.model.EOperation;

public class CompteDaoImpl implements fr.diginamic.banque.dao.CompteDao 
{
	private EntityManagerFactory efm = Persistence.createEntityManagerFactory("banque");
	private EntityManager em = efm.createEntityManager();
	
	
	@Override
	public void save(EAbstractCompte compte) 
	{
		em.getTransaction().begin();
		em.persist(compte);
		em.getTransaction().commit();
	}

	@Override
	public EAbstractCompte getCompte(Integer id) 
	{
		EAbstractCompte compte = em.find(EAbstractCompte.class, id);
		return compte;
	}

	@Override
	public List<ELivretA> getAllLivretA() 
	{
		TypedQuery<ELivretA> query = em.createQuery("SELECT la FROM ELivretA la", ELivretA.class);
		return query.getResultList();
	}

	@Override
	public List<EAssuranceVie> getAllAssuranceVie() 
	{
		TypedQuery<EAssuranceVie> query = em.createQuery("SELECT av FROM EAssuranceVie av", EAssuranceVie.class);
		return query.getResultList();
	}

	@Override
	public List<EAbstractCompte> getAllCompte() 
	{
		TypedQuery<EAbstractCompte> query = em.createQuery("SELECT c FROM EAbstractCompte c", EAbstractCompte.class);
		return query.getResultList();
	}

	@Override
	public void addOwner(EAbstractCompte compte, EBClient client) 
	{
		new ClientDaoImpl().addCompte(client, compte);
	}

	@Override
	public void addOperation(EAbstractCompte compte, EOperation operation) 
	{
		em.getTransaction().begin();
		compte.getOperations().add(operation);
		em.persist(compte);
		em.persist(operation);
		em.getTransaction().commit();
	}

}
