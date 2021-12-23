package fr.diginamic.cge.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class EClient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom", length = 50)
	private String nom;
	
	@Column(name = "prenom", length = 50)
	private String prenom;
	
	@OneToMany(mappedBy = "clientEmprunt")
	private Set<EEmprunt> emprunts;
	
	public EClient() 
	{
		 emprunts = new HashSet<EEmprunt>();
	}

	public Integer getId() {
		return id;
	}

	public Set<EEmprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<EEmprunt> emprunts) {
		this.emprunts = emprunts;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
