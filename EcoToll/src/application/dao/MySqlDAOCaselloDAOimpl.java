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
	
	private final String EXIT = "SELECT * FROM casello";
	private final String ADD_CASELLO = "INSERT INTO casello (nome_casello, altezza_km,id_autostrada) VALUES (?,?,?)";
	private final String SELECT_INFOCASELLO = "SELECT * FROM casello WHERE id=?";


		@Override
		public List<String> getAllCasello(){
			List<String> list = new ArrayList<String>();
			try {
				  con = MySQLDAOFactory.createConnection();
				  prep = (PreparedStatement) con.prepareStatement(EXIT);
				 
				  res = prep.executeQuery();
				  while(res.next()) {
					  list.add(res.getString(1) +" " + res.getString(2) );
				  }
		}
			catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			}
		
			return list;
		}
	



	@Override
	public boolean addCasello(String nome_casello,double altezza_km, int id_autostrada) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_CASELLO);
			prep.setString(1, nome_casello);
			prep.setDouble(2, altezza_km);
			prep.setInt(3, id_autostrada);
			
			
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}
	

	
	@Override
	public Casello getCasello(int id) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_INFOCASELLO);
			  prep.setInt(1, id);
			  res = prep.executeQuery();
			  if(res.next()) {
				  return new Casello(res);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
	
		return null;
	}


}
