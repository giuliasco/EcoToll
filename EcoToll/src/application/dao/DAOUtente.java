package application.dao;

import java.util.List;
import application.model.Utente;

public interface DAOUtente {
	
	public List<String> getAllUtenti();
	
	public boolean registraUtente(String nome_utente, String cognome_utente, String email, String pwd, int id_ruolo);
	
	public boolean deleteUtente(String email);
	
	public Utente getUtente(String email, String pwd);
	
	public boolean Login(String email, String pwd);
	
	public void updateRuoloUtente (String email);
	
	

}
