package application.dao;

import java.util.List;
import application.model.Utente;

public interface DAOUtente {
	
	public List<Utente> getAllUtenti();
	
	public boolean registraUtente(Utente u);
	
	public boolean deleteUtente(Utente u);
	
	public Utente getUtente(Utente u);
	
	public boolean Login(Utente u);
	
	public void updateRuoloUtente (Utente u);
	
	

}
