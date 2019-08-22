package application.dao;

import java.util.List;
import application.model.ClasseIT;



	public interface DAOClasseIT {
	
	public List<ClasseIT> getAllClasseIT();
	
	public ClasseIT getClasseIT(ClasseIT it);
			
	public boolean addClasseIT(ClasseIT it);


}
