package application.dao;

import java.util.List;
import application.model.Veicolo;


public interface DAOVeicolo {
	
	public List<Veicolo> getAllVeicoli();

	public Veicolo getVeicolo(String targa);
			
	public boolean addVeicolo(Veicolo v);
		
	public boolean deleteVeicolo(Veicolo v);
	
	
	public void updateClassIT (Veicolo v);
	
	public void updateClassEU (Veicolo v);
	
	public boolean veicoloPresente(String targa);
}