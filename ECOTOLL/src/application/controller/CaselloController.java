package application.controller;

import java.util.List;

import application.dao.DAOCasello;
import application.dao.DAOFactory;
import application.model.Casello;

public class CaselloController {
	
	private DAOFactory mysqlfactory;
	private DAOCasello casellodao;
	
	public CaselloController() {
		mysqlfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		casellodao = mysqlfactory.getDAOCasello();
	}
	
	public static CaselloController getIstance() {
		return new CaselloController();
	}

	//restituisce una lista di autostrade
	public List<Casello> getAllCas() {
		return casellodao.getAllCasello();
	}
	
	
	//metodo usato per l'eliminazione di caselli dal DB
	public boolean delete(Casello casello) {
		return casellodao.deleteCasello(casello);
	}
	
	
	//inizializza un nuovo oggetto casello a partire dal nome e l'altezza
	public void setCaselloGlobal(String nome_casello, double altezza_casello) {
		casellodao.getCasello(nome_casello, altezza_casello);	
	}
	
	//metodo utilizzato per aggiungere caselli
	public boolean addCasello(String nome_casello, double altezza_casello, int id_autostrada ) {
		if(casellodao.aggCasello(nome_casello, altezza_casello, id_autostrada)) return true;
		else return false;
	}
   
	//inizializza un nuovo oggetto casello a partire dall'id
	public void setCaselloGlobalByName (String nome_casello) {
		casellodao.getCaselloByName(nome_casello);
	}
}
