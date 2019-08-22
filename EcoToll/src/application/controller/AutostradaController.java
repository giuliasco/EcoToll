package application.controller;

import java.util.List;

import application.dao.DAOFactory;
import application.dao.DAOUtente;
import application.model.Autostrada;

public class AutostradaController {
	
	private DAOFactory mysqlfactory;
	private DAOUtente userdao;
	
	
	public AutostradaController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		userdao = mysqlfactory.getDAOUtente();
	}
	
	public static AutostradaController getIstance() {
		return new AutostradaController();
	}
	
	public Autostrada getAutostrada(Autostrada a) {
		return mysqlfactory.getDAOAutostrada().getAutostrada(a);
	}
	
	//Lista di autostrade
	public List<String> getAllAut() {
		return mysqlfactory.getDAOAutostrada().getAllAutostrade();
	}

}
