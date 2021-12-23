package fr.diginamic.banque.dao;

import java.util.List;

import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EBClient;

public interface ClientDao 
{
	public EBClient getClient(Integer id);
	
	public List<EBClient> getAllClients();
	
	public void save(EBClient client);
	
	public void addCompte(EBClient client, EAbstractCompte compte);
}