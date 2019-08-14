package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Utente;
import application.dao.MySQLDAOFactory;



public class MySqlDAOUtenteDAOimpl implements DAOUtente{
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private static final String SHOW_USER="SELECT * FROM utente";
	private static final String REGISTER_UTENTE="INSERT INTO utente(nome_utente,cognome_utente,email,pwd,id_ruolo) VALUES (?,?,?,?,?)";
	private static final String DELETE_UTENTE="DELETE FROM utente WHERE email=?";
	private static final String SHOW_ANAG="SELECT nome_utente,cognome_utente,email,pwd,targa FROM utente, veicolo WHERE utente.id=veicolo.id_utente AND email=? AND pwd=?;";
	private static final String LOG_IN="SELECT * FROM utente WHERE email=? AND pwd=?";
	private static final String UPDATE_ROLE_TO_ADMIN="UPDATE utente SET id_ruolo=? WHERE email=?";
	


	
	@Override
	public boolean registraUtente(String nome_utente, String cognome_utente, String email, String pwd, int id_ruolo) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(REGISTER_UTENTE);
			prep.setString(1, nome_utente);
			prep.setString(2, cognome_utente);
			prep.setString(3, email);
			prep.setString(4, pwd);
			prep.setInt(5, id_ruolo);
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}


	public boolean deleteUtente(String email) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(DELETE_UTENTE);
			  prep.setString(1, email );
			return prep.execute();
		} catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			return false;
			}
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
			return new Utente(res);
		}
		catch(SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			
		}
		return null;
	}

	@Override
	public boolean Login(String email, String pwd) {
		
		  try {
		  con = MySQLDAOFactory.createConnection();
		  prep = (PreparedStatement) con.prepareStatement(LOG_IN);
		  prep.setString(1, email);
		  prep.setString(2,pwd);
		  res = prep.executeQuery(); 
		  
		  if (res.next()) {
			  return true;	  
		  }
		  
		  } catch (SQLException e) {e.printStackTrace(); System.out.println("Errore Query");}	
		 
		return false;
	}

	@Override
	public void updateRuoloUtente(String email) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(UPDATE_ROLE_TO_ADMIN);
	 		prep.setString(1, email);
	 		prep.executeUpdate();

			}
			catch(SQLException e) {
				e.printStackTrace(); 
				System.out.println("Problema nel DB");
				
			}
		
	}

	@Override
	public List<String> getAllUtenti() {
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SHOW_USER);
			  res = prep.executeQuery();
			  while(res.next()) {
				  list.add(res.getString(1));
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}
}
