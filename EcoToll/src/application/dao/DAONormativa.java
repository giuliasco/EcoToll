package application.dao;

import java.util.List;

import application.model.Normativa;



public interface DAONormativa {
	
	public List<Normativa> getAllNormative();
	
	public boolean addNormativa(Normativa n);
	
	public String getNormativa();

	

}
