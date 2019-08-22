package application.controller;

import java.util.List;

import application.dao.DAOFactory;
import application.dao.DAONormativa;
import application.model.Autostrada;
import application.model.Normativa;
public class NormativaController {
	
	private DAOFactory mysqlfactory;
	private DAONormativa userdao;
	
	public NormativaController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		userdao = mysqlfactory.getDAONormativa();
	}
	
	public String getNormativa() {
		return mysqlfactory.getDAONormativa().getNormativa();
	}
	
	public boolean addNormativa(Normativa normativa) {
		return mysqlfactory.getDAONormativa().addNormativa(normativa);
	}
 
	public static NormativaController getIstance() {
		return new NormativaController();
	}
	
	//Lista di normative
		public List<Normativa> getAllNorm() {
			return mysqlfactory.getDAONormativa().getAllNormative();
		}
		
		public void setNormativaGlobal(String nomex) {
			userdao.getNomeNormativa(nomex);
		}
		
		

}
