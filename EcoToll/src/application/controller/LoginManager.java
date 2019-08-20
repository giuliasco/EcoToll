package application.controller;

import application.dao.DAOFactory;
import application.dao.DAOUtente;
import application.model.Utente;

public class LoginManager {
	
	private DAOFactory mysqlfactory;
	private DAOUtente userdao;
 
	
	public LoginManager() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		userdao = mysqlfactory.getDAOUtente();
				
	}
	
	
	public boolean login(String email, String pwd) {
		if (userdao.Login(email,pwd)) return true;
		return false;
	}
	 
	public Utente setUserGlobal(String email, String pwd) {
		userdao.getUtente(email, pwd);
		Utente u= new Utente();
		return u;
	}
	/**
	 * verifica che lo user esiste
	 * @param user1 username
	 * @param pwd1 password
	 * @return true se esiste 
	 */
	/*public boolean isLogin(String user1, String pwd1) {
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

