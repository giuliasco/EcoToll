package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import application.model.Casello;
import application.dao.MySQLDAOFactory;

public class MySqlDAOCaselloDAOimpl implements DAOCasello {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String EXIT = "SELECT * FROM casello ORDER BY nome_casello asc";
	private final String ADD_CASELLO = "INSERT INTO casello (nome_casello, altezza_km,id_autostrada) VALUES (?,?,?)";
	private final String SELECT_INFOCASELLO = "SELECT * FROM casello WHERE nome_casello=? AND altezza_km=?";
	private final String DELETE_CASELLO= "DELETE FROM casello WHERE nome_casello=?";
	private final String UPDATE_CASELLO="UPDATE casello SET nome_casello=? OR altezza_km=? WHERE id=?";
	private final String SELECT_INFOCASELLO_NAME = "SELECT * FROM casello WHERE nome_casello=?";


		@Override
		public List<Casello> getAllCasello(){
			List<Casello> list = new ArrayList<>();
			try {
				  con = MySQLDAOFactory.createConnection();
				  prep = (PreparedStatement) con.prepareStatement(EXIT);
				 
				  res = prep.executeQuery();
				  while(res.next()) {
					  Casello casello=new Casello();
					  casello.setId(res.getInt("id"));
					  casello.setIdAutostrada(res.getInt("id_autostrada"));
					  casello.setAltezzaKm(res.getDouble("altezza_km"));
					  casello.setNomeCasello(res.getString("nome_casello"));
					  list.add(casello);
				  }
		}
			catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			}
		
			return list;
		}
	



	@Override
	/*public boolean addCasello(Casello c) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_CASELLO);
			prep.setString(1, c.getNomeCasello());
			prep.setDouble(2, c.getAltezzaKm());
			prep.setInt(3, c.getIdAutostrada());
			
			
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}*/
	

	public boolean deleteCasello(Casello c) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(DELETE_CASELLO);
			  prep.setString(1, c.getNomeCasello());
			return prep.execute();
		} catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			return false;
			}
		
	}
	

	
	@Override
	public Casello getCasello(String nome_casello, double altezza_cassello) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_INFOCASELLO);
			  prep.setString(1, nome_casello);
			  prep.setDouble(2, altezza_cassello);
			  res = prep.executeQuery();
			  res.next();
			  Casello c = new Casello(res);
			  Casello c1 = Casello.getIstance();
			  c1.setGlobal(c);
			  return c1;
			 
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		return null;
		}
	
		
	}




	@Override
	public void updateCasello(Casello c) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(UPDATE_CASELLO);
	 		prep.setInt(1, c.getId());
	 		prep.executeUpdate();

			}
			catch(SQLException e) {
				e.printStackTrace(); 
				System.out.println("Problema nel DB");
				
			}
		
	}
	
	
	@Override
	public boolean aggCasello(String nome_casello, double altezza_casello,int id_autostrada) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_CASELLO);
			prep.setString(1, nome_casello);
			prep.setDouble(2, altezza_casello);
			prep.setInt(3, id_autostrada);
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}




	@Override
	public Casello getCaselloByName(String nome_casello) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_INFOCASELLO_NAME);
			  prep.setString(1, nome_casello);
			  res = prep.executeQuery();
			  res.next();
			  Casello c = new Casello(res);
			  Casello c1 = Casello.getIstance();
			  c1.setGlobal(c);
			  return c1;
			 
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		return null;
		}
	}

}
