package fr.diginamic.banque.model;

import javax.persistence.*;

@Entity
@Table(name = "livret_a")
public class ELivretA extends EAbstractCompte
{
	private Double taux;
	
	public ELivretA() {}

	@Override
	public String toString() 
	{
		return "ELivretA [taux=" + taux + ", id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
}
