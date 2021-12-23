package fr.diginamic.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "banque")
public class EBanque 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom", length = 50)
	private String nom;
	
	@OneToMany(mappedBy = "clientBanque")
	private Set<EBClient> clients;
	
	
	public EBanque() 
	{
		clients = new HashSet<EBClient>();
	}

	public Set<EBClient> getClients() {
		return clients;
	}

	public void setClients(Set<EBClient> clients) {
		this.clients = clients;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
