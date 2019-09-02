package application.dao;

import java.util.List;

import application.model.Normativa;



public interface DAONormativa {
	
	public List<Normativa> getAllNormative(String nome_normativa);
	
	public String getNormativa();
	
	public Normativa getNomeNormativa(String annox);

	

}
