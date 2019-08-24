package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.model.Utente;
import application.dao.MySQLDAOFactory;



public class MySqlDAOUtenteDAOimpl implements DAOUtente{
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private static final String REGISTER_UTENTE="INSERT INTO utente(nome_utente,cognome_utente,email,pwd,id_ruolo) VALUES (?,?,?,?,1)";
	private static final String SHOW_ANAG="SELECT * FROM utente WHERE email=? AND pwd=?";
	private static final String LOG_IN="SELECT * FROM utente WHERE email=? AND pwd=?";
	

	@Override
	public boolean registraUtente(String nome, String cognome,String email,String pwd) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(REGISTER_UTENTE);
			prep.setString(1, nome);
			prep.setString(2, cognome);
			prep.setString(3, email);
			prep.setString(4, pwd);
			return prep.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}



	@Override
	public Utente getUtente(String email, String pwd) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(SHOW_ANAG);
			prep.setString(1, email);
			prep.setString(2, pwd);
			res = prep.executeQuery();
			res.next();
			 Utente utente1 = new Utente(res);
			 Utente a = Utente.getIstance();
			 a.setglobal(utente1);
			 return a;
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			return null;
		}
	}

	@Override
	public boolean Login(String email, String pwd) {
		  try {
			  	con = MySQLDAOFactory.createConnection();
		  		prep = (PreparedStatement) con.prepareStatement(LOG_IN);
		  		prep.setString(1, email);
		  		prep.setString(2, pwd);
		  		res = prep.executeQuery(); 
		  		if (res.next()) {
		  			return true;	  
		  		}
		  }catch (SQLException e) {e.printStackTrace(); System.out.println("Errore Query");}	
		return false;
	}

}
