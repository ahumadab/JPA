package fr.diginamic.banque.service;

import java.util.List;

import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EOperation;
import fr.diginamic.banque.model.EVirement;

public interface OperationService 
{
	public List<EOperation> getAllOperation();
	
	public List<EVirement> getAllVirement();
	
	public void update(EOperation operation);
	
	public void addOperation(EAbstractCompte compte, EOperation operation);
}
