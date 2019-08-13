package application.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Autostrada;
import application.dao.MySQLDAOFactory;


public class MySqlDAOAutostradaDAOimpl implements DAOAutostrada {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String INSERT_AUTOSTRADA ="INSERT INTO autostrada (nome_autostrada, inizio, fine, km, tariffa_km) values ('?,?,?,?,?)";
	private final String SELECT_INFO_AUTOSTRADA = "SELECT * FROM autostrada WHERE nome_autostrada=?";
	private final String HIGHWAY = "SELECT * FROM autostrada";

		
	
	
	@Override
	public boolean addAutostrada(String nome_autostrada, String inizio, String fine, double km, double tariffa_km) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(INSERT_AUTOSTRADA);
			prep.setString(1, nome_autostrada);
			prep.setString(2, inizio);
			prep.setString(3, fine);
			prep.setDouble(4, km);
			prep.setDouble(5, tariffa_km);
			
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public int getIdAutostrada (String nome_autostrada) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(SELECT_INFO_AUTOSTRADA);
			prep.setString(1, nome_autostrada);
			res = prep.executeQuery();
			if (res.next()){
			   return res.getInt(1);
			   }
		   }
		catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			}
		
			return 0;

	}
	
	
	
	@Override
	public List<String> getAllAutostrade(){
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(HIGHWAY);
			 
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
	public Autostrada getAutostrada(String nome_autostrada) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_INFO_AUTOSTRADA);
			  prep.setString(1, nome_autostrada);
			  res = prep.executeQuery();
			  if(res.next()) {
				  return new Autostrada(res);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
	
		return null;
		}
}
		
	

