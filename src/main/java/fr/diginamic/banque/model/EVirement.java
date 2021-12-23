package fr.diginamic.banque.model;

import javax.persistence.*;

@Entity
@Table(name = "virement")
public class EVirement extends EOperation
{
	private String beneficiaire;
	
	public EVirement() {}

		

	@Override
	public String toString() {
		return "EVirement [beneficiaire=" + beneficiaire + ", id=" + id + ", date=" + date + ", montant=" + montant
				+ ", motif=" + motif + "]";
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	
}
