package application.dao;

import java.util.List;



public interface DAONormativa {
	
	public List<String> getAllNormative();
	
	public boolean addNormativa(int anno_normativa,String nome_normativa);

	

}
