package application.dao;

import java.util.List;

import application.model.Casello;


public interface DAOCasello {
	
		public List<String> getAllCasello();
	
		public Casello getCasello(int id);
				
		public boolean addCasello(String nome_casello,double alezza_km, int id_autostrada);
			


}
