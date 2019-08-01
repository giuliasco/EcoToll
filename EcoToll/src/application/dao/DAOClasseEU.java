package application.dao;

import java.util.List;
import application.model.ClasseEU;



	public interface DAOClasseEU {
	
	public List<ClasseEU> getAllClasseEU();
	
	public ClasseEU getClasseEU(String tipo);
			
	public boolean addClasseEU(ClasseEU classe_eu);
		
	public boolean deleteClasseEU(ClasseEU classe_eu );

}
