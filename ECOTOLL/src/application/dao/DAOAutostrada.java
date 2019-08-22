package application.dao;


import java.util.List;
import application.model.Autostrada;

public interface DAOAutostrada {
	
	public Autostrada getAutostrada(Autostrada a);
	public int getIdAutostrada(Autostrada a);
	public boolean addAutostrada(Autostrada a);
	public List<Autostrada> getAllAutostrade();

}
