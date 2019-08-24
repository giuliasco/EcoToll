package application.dao;

import java.util.List;

import application.model.Casello;


public interface DAOCasello {
	
		public List<Casello> getAllCasello();
	
		public Casello getCasello(String nome_casello, double altezza_casello );
				
		public boolean deleteCasello(Casello c);
		
		public boolean aggCasello (String nome_casello, double altezza_casello, int id_autostrada);
		
		public Casello getCaselloByName(String nome_casello);

}
