package application.dao;


import java.util.List;
import application.model.Autostrada;

public interface DAOAutostrada {
	
	public Autostrada getAutostrada(String nome_autostrada);
	public int getIdAutostrada(String nome_autostrada);
	public boolean addAutostrada(String nome_autostrada, String inizio, String fine, double km, double tariffa_km);
	public List <Autostrada> getAllAutostrade();

}
