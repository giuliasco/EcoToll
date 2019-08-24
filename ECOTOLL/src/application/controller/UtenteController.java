package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.dao.DAOFactory;
import application.dao.DAOUtente;
import application.model.Utente;
import javafx.fxml.Initializable;

public class UtenteController{
	
	private DAOFactory mysqlfactory;
	private DAOUtente userdao;
 
	
	public UtenteController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		userdao = mysqlfactory.getDAOUtente();
				
	}
	
	
	public boolean login(String email, String pwd) {
		if (userdao.Login(email,pwd)) return true;
		return false;
	}
	 
	public void setUserGlobal(String email, String pwd) {
		userdao.getUtente(email, pwd);
		
	
	}

	public boolean addUtente(String nome, String cognome, String email, String pwd) {
		if(userdao.registraUtente(nome,cognome,email,pwd)) return true;
		else return false;
	}


	
	
}

