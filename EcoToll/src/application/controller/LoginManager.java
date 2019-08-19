package application.controller;

import application.dao.DAOFactory;
import application.model.Utente;

public class LoginManager {
	
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);
	
	
	public LoginManager() {}
	/* SINGLETON pattern */
	public static LoginManager getInstance() {
		return new LoginManager();
	}
	
	public Utente get(String email, String pwd) {
		return DaoFactory.getDAOUtente().getUtente(email, pwd);
	}
	
	/**
	 * verifica che lo user esiste
	 * @param user1 username
	 * @param pwd1 password
	 * @return true se esiste 
	 */
	public boolean isLogin(String user1, String pwd1) {
		if (DaoFactory.getDAOUtente().Login(user1, pwd1)) return true;
		else return false;		
	}
	/**
	 * Aggiunge un utente User - gli amministratori non possono essere aggiunti 
	 * @param login username
	 * @return true se aggiunto
	 
	public boolean addLogin(Login login) {
		if (DaoFactory.getDAOLogin().addUser(login)) return true;
		else return false;
	}*/
	

	
}

