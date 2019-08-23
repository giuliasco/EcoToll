package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class Casello {
	
		
		private int id,id_autostrada;
		private double altezza_km;
		private String nome_casello;
		
		//costruttore vuoto
		
		public Casello() {}
		
		 private static Casello instance = null;
			
		    public static Casello getIstance() {
		        if(instance==null)
		                instance = new Casello();
		        return instance;}
		
		//costruttore che contiene tutti i campi
		public Casello(int id,int id_autostrada, double altezza_km,String nome_casello) {
			this.id= id;
			this.id_autostrada= id_autostrada;
			this.altezza_km= altezza_km;
			this.nome_casello= nome_casello;
		}
		
		//costruttore che contiene ResultSet (query DB)
		
		public Casello(ResultSet resultSet) throws SQLException{
			this.setId(resultSet.getInt("id"));
			this.setIdAutostrada(resultSet.getInt("id_autostrada"));
			this.setAltezzaKm(resultSet.getDouble("altezza_km"));
			this.setNomeCasello(resultSet.getString("nome_casello"));
		}
		
		//metodi di get e set
		
		public int getId() {return id;}
		public void setId(int id) {this.id=id;}
		
		public int getIdAutostrada() {return id_autostrada;}
		public void setIdAutostrada(int id_autostrada) {this.id_autostrada=id_autostrada;}
		
		public double getAltezzaKm() {return altezza_km;}
		public void setAltezzaKm(double altezza_km) {this.altezza_km=altezza_km;}
		
		public String getNomeCasello() {return nome_casello;}
		public void setNomeCasello(String nome_casello) {this.nome_casello=nome_casello;}
		
		public String toString() {
			return this.nome_casello;
		}
		
		public void setGlobal(Casello c) {
			instance=c;
		}
	
	}


