package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Veicolo;

public class MySqlDAOVeicoloDAOimpl implements DAOVeicolo {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private static final String SHOW_VEICOLO="SELECT * FROM veicolo WHERE targa=?";

	

	@Override
	public Veicolo getVeicolo(String targa) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(SHOW_VEICOLO);
			prep.setString(1, targa);
			res = prep.executeQuery();
			res.next();
			Veicolo v= new Veicolo(res);
			Veicolo v1=Veicolo.getIstance();
			v1.setglobal(v);
			return v1;
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
		}
		return null;
	}

	@Override
	public boolean veicoloPresente(String targa) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SHOW_VEICOLO);
			  prep.setString(1, targa);
			  res = prep.executeQuery(); 
			  if (res.next()) {
				  return true;	  
			  }
			}catch (SQLException e) {e.printStackTrace(); System.out.println("Errore Query");}	
		return false;
		}

	}
