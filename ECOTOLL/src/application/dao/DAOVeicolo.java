package application.dao;

import application.model.Veicolo;


public interface DAOVeicolo {
	

	public Veicolo getVeicolo(String targa);
			
	public boolean veicoloPresente(String targa);
}
