package application.controller;

import application.dao.DAOFactory;
import application.dao.DAOVeicolo;


public class VeicoloController {
	
	private DAOFactory mysqlfactory;
	private DAOVeicolo veicolodao;
 
	
	public VeicoloController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		veicolodao = mysqlfactory.getDAOVeicolo();
				
	}
	
	
	public boolean veicoloPresente(String targa) {
		if (veicolodao.veicoloPresente(targa)) return true;
		return false;
	}
	
	
	public void setVeicolorGlobal(String targa) {
		veicolodao.getVeicolo(targa);
	}

}
