package application.dao;

import java.util.List;

import application.model.Ruolo;

public interface DAORuolo {
	
	public List<Ruolo> getAllRuoli();
	public boolean addRuolo(Ruolo r);
	
	

}
