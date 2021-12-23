package fr.diginamic.banque.service.impl;

import java.util.List;

import fr.diginamic.banque.dao.OperationDao;
import fr.diginamic.banque.dao.impl.OperationDaoImpl;
import fr.diginamic.banque.model.EAbstractCompte;
import fr.diginamic.banque.model.EOperation;
import fr.diginamic.banque.model.EVirement;
import fr.diginamic.banque.service.OperationService;

public class OperationServiceImpl implements OperationService 
{
	private OperationDao operationDao = new OperationDaoImpl();
	
	@Override
	public List<EOperation> getAllOperation() 
	{
		return operationDao.getAllOperation();
	}

	@Override
	public List<EVirement> getAllVirement() 
	{
		return operationDao.getAllVirement();
	}

	@Override
	public void update(EOperation operation) 
	{
		operationDao.update(operation);
	}

	@Override
	public void addOperation(EAbstractCompte compte, EOperation operation) 
	{
		operationDao.addOperation(compte, operation);
	}

}
