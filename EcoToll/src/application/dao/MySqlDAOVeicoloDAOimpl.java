package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Veicolo;

public class MySqlDAOVeicoloDAOimpl implements DAOVeicolo {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private static final String SHOW_VEICOLI="SELECT * FROM veicolo";
	private static final String ADD_VEICOLO="INSERT INTO veicolo(targa,id_ci,id_ceu,id_utente) VALUES (?,?,?,?)";
	private static final String DELETE_VEICOLO="DELETE FROM veicolo WHERE targa=?";
	private static final String SHOW_INFO="SELECT targa,classe_europea.tipo,classe_italiana.tipo FROM veicolo, classe_europea, classe_italiana WHERE classe_europea.id=veicolo.id_ceu AND classe_italiana.id=veicolo.id_ci AND veicolo.id=?";
	private static final String UPDATE_CLASSIT="UPDATE veicolo SET id_ci=? WHERE targa=?";
	private static final String UPDATE_CLASSEU="UPDATE veicolo SET id_ceu=? WHERE targa=?";

	

	@Override
	public List<String> getAllVeicoli() {
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SHOW_VEICOLI);
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
	public Veicolo getVeicolo(int id) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(SHOW_INFO);
			prep.setInt(1, id);
			res = prep.executeQuery();
			res.next();
			return new Veicolo(res);
		}
		catch(SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			
		}
		return null;
	}

	@Override
	public boolean addVeicolo(String targa, int id_ci, int id_ceu, int id_utente) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_VEICOLO);
			prep.setString(1, targa);
			prep.setInt(2, id_ci);
			prep.setInt(3, id_ceu);
			prep.setInt(4, id_utente);
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	
	public boolean deleteVeicolo(String targa) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(DELETE_VEICOLO	);
			  prep.setString(1, targa );
			return prep.execute();
		} catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
			return false;
			}
	}



	@Override
	public void updateClassIT(String targa) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(UPDATE_CLASSIT);
	 		prep.setString(1, targa);
	 		prep.executeUpdate();

			}
			catch(SQLException e) {
				e.printStackTrace(); 
				System.out.println("Problema nel DB");
				
			}
		
	}

	@Override
	public void updateClassEU(String targa) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(UPDATE_CLASSEU);
	 		prep.setString(1, targa);
	 		prep.executeUpdate();

			}
			catch(SQLException e) {
				e.printStackTrace(); 
				System.out.println("Problema nel DB");
				
			}
		
	}

}
