package application.dao;

import java.util.List;
import application.model.Veicolo;


public interface DAOVeicolo {
	
	public List<String> getAllVeicoli();

	public Veicolo getVeicolo(int id);
			
	public boolean addVeicolo(String targa,int id_ci, int id_ceu, int id_utente);
		
	public boolean deleteVeicolo(String targa );
	
	
	public void updateClassIT (String targa);
	
	public void updateClassEU (String targa);
	
}
