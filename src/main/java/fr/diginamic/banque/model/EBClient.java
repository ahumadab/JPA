package fr.diginamic.banque.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class EBClient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom", length = 50)
	private String nom;
	
	@Column(name = "prenom", length = 50)
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	private Date dateNaissance;
	
	@ManyToOne
	@JoinColumn(name = "id_banque")
	private EBanque clientBanque;
	
	@ManyToMany
	@JoinTable(
		name = "client_compte",
		joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id")
	)
	private Set<EAbstractCompte> clientComptes;

	@Embedded
	private EAdresse adresse;
	
	public EBClient()
	{
		clientComptes = new HashSet<EAbstractCompte>();
	}
	
	public EBClient(String prenom, String nom, Date dateNaissance)
	{
		this();
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "EBClient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}

	public EBanque getClientBanque() {
		return clientBanque;
	}

	public void setClientBanque(EBanque clientBanque) {
		this.clientBanque = clientBanque;
	}

	public Set<EAbstractCompte> getClientComptes() {
		return clientComptes;
	}

	public void setClientComptes(Set<EAbstractCompte> clientComptes) {
		this.clientComptes = clientComptes;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public EAdresse getAdresse() {
		return adresse;
	}

	public void setAdresse(EAdresse adresse) {
		this.adresse = adresse;
	}
	
	
}
