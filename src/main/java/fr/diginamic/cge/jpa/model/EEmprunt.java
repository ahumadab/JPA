package fr.diginamic.cge.jpa.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "emprunt")
public class EEmprunt 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	private java.util.Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	private java.util.Date dateFin;
	
	@Column(name = "delai", length = 10)
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private EClient clientEmprunt;
	
//	@Column(name = "id_client", length = 10)
//	private Integer idClient;
	
	@ManyToMany
	@JoinTable(
		name = "compo",
		joinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "id")
	)
	private Set<ELivre> empruntLivres;
	
	public EEmprunt() 
	{ 
		empruntLivres = new HashSet<ELivre>();
	}

	public Set<ELivre> getEmpruntLivres() {
		return empruntLivres;
	}

	public void setEmpruntLivres(Set<ELivre> empruntLivres) {
		this.empruntLivres = empruntLivres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public java.util.Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(java.util.Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public java.util.Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(java.util.Date dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public EClient getClientEmprunt() {
		return clientEmprunt;
	}

	public void setClientEmprunt(EClient clientEmprunt) {
		this.clientEmprunt = clientEmprunt;
	}
	
	
}
