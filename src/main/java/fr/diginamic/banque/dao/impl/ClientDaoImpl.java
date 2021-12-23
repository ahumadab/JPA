package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EBClient;

public class ClientDaoImpl implements fr.diginamic.banque.dao.ClientDao 
{	
	private EntityManagerFactory efm = Persistence.createEntityManagerFactory("banque");
	private EntityManager em = efm.createEntityManager();
	
	
	@Override
	public EBClient getClient(Integer id) 
	{
		EBClient client = em.find(EBClient.class, id);
		return client;
	}

	@Override
	public List<EBClient> getAllClients() 
	{
		TypedQuery<EBClient> query = em.createQuery("SELECT c FROM EBClient c", EBClient.class);
    	return query.getResultList();
	}

	@Override
	public void save(EBClient client) 
	{
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
	}

	@Override
	public void addCompte(EBClient client, EAbstractCompte compte) 
	{
		em.getTransaction().begin();
		client.getClientComptes().add(compte);
		em.persist(client);
		em.persist(compte);
		em.getTransaction().commit();
	}

	@Override
	protected void finalize() throws Throwable 
	{
		if (em != null && em.isOpen())
		{
			em.close();
		}
		if (efm != null && efm.isOpen())
		{
			efm.close();
		}
	}

}
