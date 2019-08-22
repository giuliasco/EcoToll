package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ruolo {
	
	private int id;
	private String tipo_utente;
	
	//costrutore vuoto
	public Ruolo() {}
	
	//costruttore che prevede tutti i campi
	public Ruolo(int id,String tipo_utente) {
		this.id=id;
		this.tipo_utente= tipo_utente;
	}
	
	//costruttore con ResultSet (query DB)
	public Ruolo(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getInt("id"));
		this.setTipoUtente(resultSet.getString("tipo_utente"));
	}
	
	//metodi di get e set
	public int getId() {return id;}
	public void setId(int id) {this.id= id;}
	
	public String getTipoUtente() {return tipo_utente;}
	public void setTipoUtente(String tipo_utente) {this.tipo_utente= tipo_utente;}
}
