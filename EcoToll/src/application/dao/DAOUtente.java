package application.dao;

import java.util.List;
import application.model.Utente;

public interface DAOUtente {
	
	public List <Utente> getAllUtenti();
	public boolean addUtente(Utente utente);
	public boolean deleteUtente(Utente utente);
	public Utente getUtente(String username, String password);

}
