package application.dao;

import java.util.List;
import application.model.Utente;

public interface DAOUtente {
	
	public List<Utente> getAllUtenti();
	
	public boolean registraUtente(Utente u);
	
	public boolean deleteUtente(Utente u);
	
	public void getUtente(String email, String pwd);
	
	public boolean Login(String email, String pwd);
	
	public void updateRuoloUtente (Utente u);
	
	

}
