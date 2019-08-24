package application.controller;

import java.util.List;

import application.dao.DAOFactory;
import application.dao.DAONormativa;
import application.model.Normativa;
public class NormativaController {
	
	private DAOFactory mysqlfactory;
	private DAONormativa normativadao;
	
	public NormativaController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		normativadao = mysqlfactory.getDAONormativa();
	}
	
	public static NormativaController getIstance() {
		return new NormativaController();
	}
	
	
	public String getNormativa() {
		return normativadao.getNormativa();
	}
	
	
 
	
	
	//Lista di normative
	public List<Normativa> getAllNorm() {
		return normativadao.getAllNormative();
	}
		
	public void setNormativaGlobal(String nomex) {
		normativadao.getNomeNormativa(nomex);
		}
	
		

}
