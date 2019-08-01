package application.dao;


import java.util.List;
import application.model.Autostrada;

public interface DAOAutostrada {
	
	public Autostrada getAutostrada(String nome_autostrada);
	public int getIdAutostrada(String nome_autostrada);
	public boolean addAutostrada(Autostrada autostrada);
	public List <Autostrada> getAllAutostrade();

}
