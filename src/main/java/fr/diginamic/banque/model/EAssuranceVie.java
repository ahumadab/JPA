package fr.diginamic.banque.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "assurance_vie")
public class EAssuranceVie extends EAbstractCompte
{
	@Column(name = "date_fin")
	private Date dateFin;
	
	private Double taux;
	
	public EAssuranceVie() {}

	@Override
	public String toString() 
	{
		return "EAssuranceVie [dateFin=" + dateFin + ", taux=" + taux + ", id=" + id + ", numero=" + numero + ", solde="
				+ solde + "]";
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
}
