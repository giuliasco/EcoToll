package application.dao;


import java.util.List;
import application.model.Autostrada;

public interface DAOAutostrada {
	
	public Autostrada getAutostrada(String nomea);
	
	public List<Autostrada> getAllAutostrade();
	
	public Autostrada getAutostradaById(int id_autostrada);

}
