package fr.diginamic.banque.service.impl;

import java.util.List;

import fr.diginamic.banque.dao.CompteDao;
import fr.diginamic.banque.dao.impl.CompteDaoImpl;
import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EAssuranceVie;
import fr.diginamic.banque.model.EBClient;
import fr.diginamic.banque.model.ELivretA;
import fr.diginamic.banque.model.EOperation;
import fr.diginamic.banque.service.CompteService;

public class CompteServiceImpl implements CompteService 
{
	private CompteDao compteDao = new CompteDaoImpl();

	@Override
	public EAbstractCompte getCompte(Integer id) 
	{
		return compteDao.getCompte(id);
	}

	@Override
	public List<ELivretA> getAllLivretA() 
	{
		return compteDao.getAllLivretA();
	}

	@Override
	public List<EAssuranceVie> getAllAssuranceVie() 
	{
		return compteDao.getAllAssuranceVie();
	}

	@Override
	public List<EAbstractCompte> getAllCompte() 
	{
		return compteDao.getAllCompte();
	}

	@Override
	public void addOwner(EAbstractCompte compte, EBClient client) 
	{
		compteDao.addOwner(compte, client);
	}

	@Override
	public void save(EAbstractCompte compte) 
	{
		compteDao.save(compte);
	}

	@Override
	public void addOperation(EAbstractCompte compte, EOperation operation) 
	{
		compteDao.addOperation(compte, operation);
	}
	
}
