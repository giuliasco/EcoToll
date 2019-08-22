package application.dao;


import java.util.List;
import application.model.Autostrada;

public interface DAOAutostrada {
	
	public Autostrada getAutostrada(String nomea);
	public int getIdAutostrada(Autostrada a);
	public boolean addAutostrada(Autostrada a);
	public List<Autostrada> getAllAutostrade();

}
