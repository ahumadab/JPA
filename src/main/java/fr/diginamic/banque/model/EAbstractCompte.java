package fr.diginamic.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@Table(name = "compte")
public abstract class EAbstractCompte 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected String numero;
	
	protected Double solde;
	
	@ManyToMany(mappedBy = "clientComptes")
	protected Set<EBClient> compteClients;
	
	@OneToMany(mappedBy = "compte")
	protected Set<EOperation> operations;

	@Override
	public String toString() {
		return "EAbstractCompte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}

	public EAbstractCompte() 
	{
		compteClients = new HashSet<EBClient>();
		operations = new HashSet<EOperation>();
	}
	
	public Set<EOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<EOperation> operations) {
		this.operations = operations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Set<EBClient> getCompteClients() {
		return compteClients;
	}

	public void setCompteClients(Set<EBClient> compteClients) {
		this.compteClients = compteClients;
	}
	
	
}
