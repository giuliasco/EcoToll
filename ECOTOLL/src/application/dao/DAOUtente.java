package application.dao;

import application.model.Utente;

public interface DAOUtente {
	
	
	public boolean registraUtente(String nome,String cognome,String email,String pwd);
	
	public  Utente getUtente(String email, String pwd);
	
	public boolean Login(String email, String pwd);
	
	}
