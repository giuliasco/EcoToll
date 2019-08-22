package application.controller;

import application.dao.DAOFactory;
import application.dao.DAONormativa;
import application.model.Normativa;
public class NormativaController {
	
	private DAOFactory mysqlfactory;
	private DAONormativa userdao;
	
	public String getNormativa() {
		return mysqlfactory.getDAONormativa().getNormativa();
	}
	
	public boolean addNormativa(Normativa normativa) {
		return mysqlfactory.getDAONormativa().addNormativa(normativa);
	}
 

}
