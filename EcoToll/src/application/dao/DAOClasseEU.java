package application.dao;

import java.util.List;
import application.model.ClasseEU;



	public interface DAOClasseEU {
	
	public List<ClasseEU> getAllClasseEU();
	
			
	public boolean addClasseEU(ClasseEU eu);
	
	public ClasseEU getClasseEU(ClasseEU eu);
			

}
