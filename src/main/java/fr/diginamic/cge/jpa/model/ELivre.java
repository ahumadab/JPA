package fr.diginamic.cge.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class ELivre 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "titre", length = 250)
	private String titre;
	
	@Column(name = "auteur", length = 50)
	private String auteur;
	
	@ManyToMany(mappedBy = "empruntLivres")
	private Set<EEmprunt> livreEmprunts;
	
	
	public ELivre() 
	{
		livreEmprunts = new HashSet<EEmprunt>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Set<EEmprunt> getLivreEmprunts() {
		return livreEmprunts;
	}

	public void setLivreEmprunts(Set<EEmprunt> livreEmprunts) {
		this.livreEmprunts = livreEmprunts;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
}
