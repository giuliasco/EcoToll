package application.controller;

import java.util.List;

import application.dao.DAOAutostrada;
import application.dao.DAOFactory;
import application.model.Autostrada;

public class AutostradaController {
	
	private DAOFactory mysqlfactory;
	private DAOAutostrada autostradaDao;
	
	
	public AutostradaController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		autostradaDao = mysqlfactory.getDAOAutostrada();
	}
	
	public static AutostradaController getIstance() {
		return new AutostradaController();
	}
	
	/*public Autostrada getAutostrada(Autostrada a) {
		return autostradaDao.getAutostrada(a);
	}*/
	
	//Lista di autostrade
	public List<Autostrada> getAllAut() {
		return autostradaDao.getAllAutostrade();
	}
	
	//inizializza un nuovo oggetto autostrada a partire dal nome
	public void setAutostradaGlobal(String nomea) {
		autostradaDao.getAutostrada(nomea);
	}

	//inizializza un nuovo oggetto autostrada a partire dall'id
	public void setAutostradaGlobalbyID(int id_autostrada) {
		autostradaDao.getAutostradaById(id_autostrada);
	}
}
