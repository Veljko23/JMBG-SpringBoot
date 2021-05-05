package com.example.cubes;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Broj {
	
	private String jmbg;
	private boolean valid;
	private String datum;
	private String okrug;
	private boolean unetoSlovo;
	
	public Broj() {}

	public Broj(String jmbg, boolean valid) {
		super();
		this.jmbg = jmbg;
		this.valid = valid;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public boolean getIsValid() {
		return valid;
	}

	public void setIsValid(boolean valid) {
		this.valid = valid;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getOkrug() {
		return okrug;
	}

	public void setOkrug(String okrug) {
		this.okrug = okrug;
	}

	public boolean getIsUnetoSlovo() {
		return unetoSlovo;
	}

	public void setUnetoSlovo(boolean unetoSlovo) {
		this.unetoSlovo = unetoSlovo;
	}
	
	

}
