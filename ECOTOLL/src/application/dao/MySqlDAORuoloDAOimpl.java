package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Ruolo;

public class MySqlDAORuoloDAOimpl implements DAORuolo{
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String ROLES= "SELECT * FROM ruolo";
	private final String ADD_RUOLO = "INSERT INTO ruolo(tipo_utente) VALUES (?)";
	
	@Override
	public List<Ruolo> getAllRuoli() {
		List<Ruolo> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(ROLES);
			 
			  res = prep.executeQuery();
			  while(res.next()) {
				  Ruolo ruolo=new Ruolo();
				  ruolo.setId(res.getInt("id"));
				  ruolo.setTipoUtente(res.getString("tipo_utente"));
				  
				  list.add(ruolo);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}

	@Override
	public boolean addRuolo(Ruolo r) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_RUOLO);
			prep.setString(1, r.getTipoUtente());
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
