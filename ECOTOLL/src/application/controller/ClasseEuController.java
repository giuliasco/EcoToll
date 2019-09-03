package application.controller;

import application.dao.DAOClasseEU;
import application.dao.DAOFactory;

public class ClasseEuController {

	private DAOFactory mysqlfactory;
	private DAOClasseEU classeEudao;
	
	public ClasseEuController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		classeEudao = mysqlfactory.getDAOClasseEU();
	}
	
	public void setClasseEUGlobal(int id) {
		classeEudao.getClasseEU(id);
		
	
	}
}
