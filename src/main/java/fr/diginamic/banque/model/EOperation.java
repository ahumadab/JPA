package fr.diginamic.banque.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@Table(name = "operation")
public class EOperation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENTAL
	protected int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	protected Date date;
	
	protected Double montant;
	
	protected String motif;
	
	@ManyToOne
	@JoinColumn(name = "id_compte")
	protected EAbstractCompte compte; 
	
	public EOperation() {}
	
	@Override
	public String toString() {
		return "EOperation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}



	public EAbstractCompte getCompte() {
		return compte;
	}

	public void setCompte(EAbstractCompte compte) {
		this.compte = compte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

}
