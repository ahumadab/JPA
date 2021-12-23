package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.OperationDao;
import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EOperation;
import fr.diginamic.banque.model.EVirement;

public class OperationDaoImpl implements OperationDao 
{
	private EntityManagerFactory efm = Persistence.createEntityManagerFactory("banque");
	private EntityManager em = efm.createEntityManager();
	
	
	@Override
	public List<EOperation> getAllOperation() 
	{
		TypedQuery<EOperation> query = em.createQuery("SELECT o FROM EOperation o", EOperation.class);
		return query.getResultList();
	}

	@Override
	public List<EVirement> getAllVirement() 
	{
		TypedQuery<EVirement> query = em.createQuery("SELECT v FROM EVirement v", EVirement.class);
		return query.getResultList();
	}

	@Override
	public void update(EOperation operation) 
	{
		em.getTransaction().begin();
		em.persist(operation);
		em.getTransaction().commit();
	}

	@Override
	public void addOperation(EAbstractCompte compte, EOperation operation) 
	{
		new CompteDaoImpl().addOperation(compte, operation);
	}

	
}
