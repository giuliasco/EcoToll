package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import application.model.ClasseEU;

public class MySqlDAOClasseEUDAOimpl implements DAOClasseEU {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String CLASS_EU = "SELECT * FROM classe_europea";
	private final String ADD_CLASSEU = "INSERT INTO classe_europea(tipo, aggiunta,id_normativa) VALUES (?,?,?)";
	private final String SELECT_CLASSEUFROMIDNORMATIVA = "SELECT * FROM classe_europea WHERE id_normativa=?";

  
	@Override
	public List<String> getAllClasseEU() {
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(CLASS_EU);
			 
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
	public boolean addClasseEU(String tipo, double aggiunta, int id_normativa) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_CLASSEU);
			prep.setString(1, tipo);
			prep.setDouble(2, aggiunta);
			prep.setInt(3, id_normativa);
			
			
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public ClasseEU getClasseEU(int id_normativa) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_CLASSEUFROMIDNORMATIVA);
			  prep.setInt(1, id_normativa);
			  res = prep.executeQuery();
			  if(res.next()) {
				  return new ClasseEU(res);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
	
		return null;
	}

}
