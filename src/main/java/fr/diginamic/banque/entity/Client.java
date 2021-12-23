package fr.diginamic.banque.entity;

import java.util.Date;
import java.util.List;

public interface Client 
{
	public String getFirstName();
	
	public String getLastName();
	
	public Date getBirthday();
	
	public Address getAddress();
	
	public List<Compte> getComptes();
}
