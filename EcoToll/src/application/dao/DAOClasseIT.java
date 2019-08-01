package application.dao;

import java.util.List;
import application.model.ClasseIT;



	public interface DAOClasseIT {
	
	public List<ClasseIT> getAllClasseIT();
	
	public ClasseIT getClasseIT(String tipo);
			
	public boolean addClasseIT(ClasseIT classe_it);
		
	public boolean deleteClasseIT(ClasseIT classe_it );

}
