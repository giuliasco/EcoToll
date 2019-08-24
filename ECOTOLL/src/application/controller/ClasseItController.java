package application.controller;


import application.dao.DAOClasseIT;
import application.dao.DAOFactory;

public class ClasseItController {
	
	private DAOFactory mysqlfactory;
	private DAOClasseIT classeitdao;
	
	public ClasseItController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		classeitdao = mysqlfactory.getDAOClasseIT();
	}
	
	public void setClasseItGlobal(int id) {
		classeitdao.getClasseIT(id);
		
	
	}

	

}
