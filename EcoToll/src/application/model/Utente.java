package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Utente {
	
	private int id, id_ruolo;
	private String nome_utente, cognome_utente,username,pwd;
	
	//costruttore vuoto
	public Utente() {}
	
	//costruttore che prevede tutti i campi
	public Utente(int id, int id_ruolo, String nome_utente, String cognome_utente, String username, String pwd) {
		this.id= id;
		this.id_ruolo= id_ruolo;
		this.nome_utente= nome_utente;
		this.cognome_utente= cognome_utente;
		this.username= username;
		this.pwd= pwd;
	}

	//costruttore da ResultSet (query DB)
	public Utente(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getInt("id"));
		this.setIdRuolo(resultSet.getInt("id_ruolo"));
		this.setNomeUtente(resultSet.getString("nome_utente"));
		this.setCognomeUtente(resultSet.getString("cognome_utente"));
		this.setUsername(resultSet.getString("username"));
		this.setPwd(resultSet.getString("pwd"));
	}
	
	//metodi di get e set
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public int getIdRuolo() {return id_ruolo;}
	public void setIdRuolo(int id_ruolo) {this.id_ruolo= id_ruolo;}
	
	public String getNomeUtente() {return nome_utente;}
	public void setNomeUtente(String nome_utente) {this.nome_utente= nome_utente;}
	
	public String getCognomeUtente() {return cognome_utente;}
	public void setCognomeUtente(String cognome_utente) {this.cognome_utente= cognome_utente;}
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username= username;}
	
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd= pwd;}
	
	}
	