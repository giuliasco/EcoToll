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
	
	private final String SELECT_INFO_AUTOSTRADA = "SELECT * FROM autostrada WHERE nome_autostrada=?";
	private final String HIGHWAY = "SELECT * FROM autostrada";
	private final String HIGHWAY_BY_ID = "SELECT * FROM autostrada WHERE id=?";

		
	
	

	
	
	@Override
	public List<Autostrada> getAllAutostrade(){
		List<Autostrada> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(HIGHWAY);
			 
			  res = prep.executeQuery();
			  while(res.next()) {
				  Autostrada autostrada = new Autostrada();
				  	autostrada.setId(res.getInt("id"));
				  	autostrada.setKm(res.getDouble("km"));
				  	autostrada.setTariffaKm(res.getDouble("tariffa_km"));
				  	autostrada.setNomeAutostrada(res.getString("nome_autostrada"));
				  	autostrada.setInizio(res.getString("inizio"));
				  	autostrada.setFine(res.getString("fine"));
					list.add(autostrada);
			  }
		}catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}
	
	
	@Override
	public Autostrada getAutostrada(String nomea) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_INFO_AUTOSTRADA);
			  prep.setString(1, nomea);
			  res = prep.executeQuery();
			  res.next();
			  Autostrada a = new Autostrada(res);
			  Autostrada a1= Autostrada.getInstance();
			  a1.setGlobal(a);
			  return a1;
			
		}catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		return null;
		}
	}

	
	@Override
	public Autostrada getAutostradaById(int id_autostrada) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(HIGHWAY_BY_ID);
			prep.setInt(1, id_autostrada);
			res = prep.executeQuery();
			res.next();
			Autostrada a = new Autostrada(res);
			Autostrada a1= Autostrada.getInstance();
			a1.setGlobal(a);
			return a1;
			
			}catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			return null;
		}
	}
	
}
		
	

