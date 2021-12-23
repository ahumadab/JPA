package fr.diginamic.banque.service.impl;

import java.util.List;

import fr.diginamic.banque.dao.ClientDao;
import fr.diginamic.banque.dao.impl.ClientDaoImpl;
import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EBClient;
import fr.diginamic.banque.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao = new ClientDaoImpl();
	
	@Override
	public EBClient getClient(Integer id) 
	{
		return clientDao.getClient(id);
	}

	@Override
	public List<EBClient> getAllClients() 
	{
		return clientDao.getAllClients();
	}

	@Override
	public void save(EBClient client) 
	{
		clientDao.save(client);
	}

	@Override
	public void addCompte(EBClient client, EAbstractCompte compte) 
	{
		clientDao.addCompte(client, compte);
	}

}
