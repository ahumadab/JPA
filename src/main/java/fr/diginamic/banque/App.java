package fr.diginamic.banque;


import java.util.GregorianCalendar;

import fr.diginamic.banque.model.EBClient;
import fr.diginamic.banque.service.ClientService;
import fr.diginamic.banque.service.CompteService;
import fr.diginamic.banque.service.OperationService;
import fr.diginamic.banque.service.impl.ClientServiceImpl;
import fr.diginamic.banque.service.impl.CompteServiceImpl;
import fr.diginamic.banque.service.impl.OperationServiceImpl;

public class App 
{

	private static ClientService clientService = new ClientServiceImpl();
	private static CompteService compteService = new CompteServiceImpl();
	private static OperationService operationService = new OperationServiceImpl();
	
	public static void main(String[] args) 
	{

//		clientService.getAllClients().stream().forEach(client -> System.out.println(client));
//		
//		EBClient client =  clientService.getClient(1);
//		GregorianCalendar birthDay = new GregorianCalendar(1994, GregorianCalendar.NOVEMBER, 30);
//		client.setDateNaissance(birthDay.getTime());
//		clientService.save(client);
		
		clientService.getAllClients().stream().forEach(cl -> System.out.println(cl));
		
		compteService.getAllCompte().stream().forEach(compte -> System.out.println(compte));
		
		
	}

}
