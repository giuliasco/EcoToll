package application.dao;

import java.util.List;
import application.model.ClasseEU;



	public interface DAOClasseEU {
	
	public List<String> getAllClasseEU();
	
			
	public boolean addClasseEU(String tipo, double aggiunta, int id_normativa);
	
	public ClasseEU getClasseEU(int id_normativa);
			

}
