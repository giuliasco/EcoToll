package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlDAORuoloDAOimpl implements DAORuolo{
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String ROLES= "SELECT * FROM ruolo";
	private final String ADD_RUOLO = "INSERT INTO ruolo(tipo_utente) VALUES (?)";
	
	@Override
	public List<String> getAllRuoli() {
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(ROLES);
			 
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

	@Override
	public boolean addRuolo(String tipo_utente) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_RUOLO);
			prep.setString(1, tipo_utente);
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
