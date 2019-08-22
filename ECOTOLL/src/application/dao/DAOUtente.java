package application.dao;

import java.util.List;
import application.model.Utente;

public interface DAOUtente {
	
	public List<Utente> getAllUtenti();
	
	public boolean registraUtente(String nome,String cognome,String email,String pwd);
	
	public boolean deleteUtente(Utente u);
	
	public  Utente getUtente(String email, String pwd);
	
	public boolean Login(String email, String pwd);
	
	public void updateRuoloUtente (Utente u);
	
	
	}
