package application.dao;

import java.util.List;
import application.model.ClasseIT;



	public interface DAOClasseIT {
	
	public List<String> getAllClasseIT();
	
	public ClasseIT getClasseIT(int id_normativa);
			
	public boolean addClasseIT(String tipo, double aggiunta, int id_normativa);


}
