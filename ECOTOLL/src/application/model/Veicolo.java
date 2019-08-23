package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Veicolo {

	private int id,id_ci,id_ceu,id_utente;
	private String targa;
	
	 private static Veicolo instance = null;
		
	    public static Veicolo getIstance() {
	        if(instance==null)
	                instance = new Veicolo();
	        return instance;
	    }
	//Costruttore vuoto
	public Veicolo() {}
	
	//Costruttore che prevede tutti i campi
	public Veicolo(int id, int id_ci, int id_ceu, int id_utente, String targa) {
		this.id=id;
		this.id_ci=id_ci;
		this.id_ceu=id_ceu;
		this.targa=targa;
		this.id_utente=id_utente;
	}
	
	 //costruttore da oggetto ResultSet (query DB)
	 public Veicolo(ResultSet resultSet) throws SQLException {
	        this.setId(resultSet.getInt("id"));
	        this.setIdCi(resultSet.getInt("id_ci"));
	        this.setIdCeu(resultSet.getInt("id_ceu"));
	        this.setTarga(resultSet.getString("targa"));
	        this.setIdUtente(resultSet.getInt("id_utente"));
	 }
	 
	 

	
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public int getIdUtente() {return id_utente;}
	public void setIdUtente(int id_utente) {this.id_utente=id_utente;}
	

	public int getIdCi() {return id_ci;}
	public void setIdCi(int id_ci) {this.id_ci=id_ci;}
	
	
	public int getIdCeu() {return id_ceu;}
	public void setIdCeu(int id_ceu) {this.id_ceu=id_ceu;}
	
	
	public String getTarga() {return targa;}
	public void setTarga(String targa) {this.targa=targa;}
	

	 public void setglobal(Veicolo v) {
	    	instance = v;
	    }
	
	
}
