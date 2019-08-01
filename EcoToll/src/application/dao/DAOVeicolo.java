package application.dao;

import java.util.List;
import application.model.Veicolo;


public interface DAOVeicolo {
	
	public List<Veicolo> getAllVeicoli();

	public Veicolo getVeicolo(int id_utente);
			
	public boolean addVeicolo(Veicolo veicolo);
		
	public boolean deleteVeicolo(Veicolo veicolo );

}
