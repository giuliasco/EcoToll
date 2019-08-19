package application.dao;

import java.util.List;

import application.model.Casello;


public interface DAOCasello {
	
		public List<Casello> getAllCasello();
	
		public Casello getCasello(Casello c);
				
		public boolean addCasello(Casello c);
		
		public boolean deleteCasello(Casello c);
		
		public void updateCasello(Casello c);

}
