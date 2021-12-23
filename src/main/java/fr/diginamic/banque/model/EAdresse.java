package fr.diginamic.banque.model;

import javax.persistence.*;

@Embeddable
public class EAdresse 
{
	
	private Integer numero;
	
	private String rue;
	
	@Column(name = "code_postal")
	private Integer codePostal;
	
	private String ville;
	
	public EAdresse() {}



	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	
}
