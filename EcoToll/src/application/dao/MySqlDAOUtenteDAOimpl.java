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
	private static final String REGISTER_UTENTE="INSERT INTO utente(nome_utente,cognome_utente,email,pwd,id_ruolo) VALUES (?,?,?,?,1)";
	private static final String DELETE_UTENTE="DELETE FROM utente WHERE email=?";

	private static final String SHOW_ANAG="SELECT * FROM utente WHERE email=? AND pwd=?";


	private static final String LOG_IN="SELECT * FROM utente WHERE email=? AND pwd=?";
	private static final String UPDATE_ROLE_TO_ADMIN="UPDATE utente SET id_ruolo=? OR email=? OR pwd=? WHERE email=?";
	


	
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
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}


	public boolean deleteUtente(Utente u) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(DELETE_UTENTE);
			  prep.setString(1, u.getEmail() );
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
			//Utente u= new Utente(res);
			//return u;
			
			 Utente utente1 = new Utente(res);
			 Utente a = Utente.getIstance();
			 a.setglobal(utente1);
			/*if (res.next()) {
				 Utente utente1 = new Utente(res);
				 Utente a = Utente.getIstance();
				 a.setglobal(utente1);
				  
			  }*/
			 return a;
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
		  prep.setString(2, pwd);
		  res = prep.executeQuery(); 
		  
		  if (res.next()) {
			  return true;	  
		  }
		  
		  } catch (SQLException e) {e.printStackTrace(); System.out.println("Errore Query");}	
		 
		return false;
	}

	@Override
	public void updateRuoloUtente(Utente u) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(UPDATE_ROLE_TO_ADMIN);
	 		prep.setString(1, u.getEmail());
	 		prep.executeUpdate();

			}
			catch(SQLException e) {
				e.printStackTrace(); 
				System.out.println("Problema nel DB");
				
			}
		
	}

	@Override
	public List<Utente> getAllUtenti() {
		List<Utente> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SHOW_USER);
			  res = prep.executeQuery();
			  while(res.next()) {
				  Utente utente = new Utente();
				  utente.setId(res.getInt("id"));
				  utente.setIdRuolo(res.getInt("id_ruolo"));
				  utente.setNomeUtente(res.getString("nome_utente"));
				  utente.setCognomeUtente(res.getString("cognome_utente"));
				  utente.setEmail(res.getString("email"));
				  utente.setPwd(res.getString("pwd"));
				  list.add(utente);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}



}
