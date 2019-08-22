package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Autostrada {
	
	private int id;
	private double km,tariffa_km;
	private String nome_autostrada,inizio,fine;
	
	//costruttore vuoto
	
	public Autostrada() {}
	
	
	
	//costruttore che contiene tutti i campi
	public Autostrada(int id, double km,double tariffa_km,String nome_autostrada, String inizio,String fine) {
		this.id= id;
		this.km= km;
		this.tariffa_km= tariffa_km;
		this.nome_autostrada= nome_autostrada;
		this.inizio= inizio;
		this.fine= fine;
	}
	
	//costruttore che contiene ResultSet (query DB)
	
	public Autostrada(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getInt("id"));
		this.setKm(resultSet.getDouble("km"));
		this.setTariffaKm(resultSet.getDouble("tariffa_km"));
		this.setNomeAutostrada(resultSet.getString("nome_autostrada"));
		this.setInizio(resultSet.getString("inizio"));
		this.setFine(resultSet.getString("fine"));
	}
	
	//metodi di get e set
	
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public double getKm() {return km;}
	public void setKm(double km) {this.km=km;}
	
	public double getTariffaKm() {return tariffa_km;}
	public void setTariffaKm(double tariffa_km) {this.tariffa_km=tariffa_km;}
	
	public String getNomeAutostrada() {return nome_autostrada;}
	public void setNomeAutostrada(String nome_autostrada) {this.nome_autostrada=nome_autostrada;}
	
	public String getInizio() {return inizio;}
	public void setInizio(String inizio) {this.inizio=inizio;}
	
	public String getFine() {return fine;}
	public void setFine(String fine) {this.fine=fine;}
	
	public String toString() {
		return this.nome_autostrada;
	}
	


}
