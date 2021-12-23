package fr.diginamic.banque.service;

import java.util.List;

import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EAssuranceVie;
import fr.diginamic.banque.model.EBClient;
import fr.diginamic.banque.model.ELivretA;
import fr.diginamic.banque.model.EOperation;

public interface CompteService 
{
	public void save(EAbstractCompte compte);
	
	public EAbstractCompte getCompte(Integer id);
	
	public List<ELivretA> getAllLivretA();
	
	public List<EAssuranceVie> getAllAssuranceVie();
	
	public List<EAbstractCompte> getAllCompte();
	
	public void addOwner(EAbstractCompte compte, EBClient client);
	
	public void addOperation(EAbstractCompte compte, EOperation operation);
}
