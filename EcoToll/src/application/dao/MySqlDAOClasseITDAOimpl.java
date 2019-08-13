package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import application.model.ClasseIT;

public class MySqlDAOClasseITDAOimpl implements DAOClasseIT{
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String CLASS_IT = "SELECT * FROM classe_italiana";
	private final String ADD_CLASSIT = "INSERT INTO classe_italiana(tipo, aggiunta,id_normativa) VALUES (?,?,?)";
	private final String SELECT_CLASSITFROMIDNORMATIVA = "SELECT * FROM classe_italiana WHERE id_normativa=?";


	@Override
	public List<String> getAllClasseIT() {
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(CLASS_IT);
			 
			  res = prep.executeQuery();
			  while(res.next()) {
				  list.add(res.getString(1) +" " + res.getString(2) );
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return null;
	}

	@Override
	public ClasseIT getClasseIT(int id_normativa) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_CLASSITFROMIDNORMATIVA);
			  prep.setInt(1, id_normativa);
			  res = prep.executeQuery();
			  if(res.next()) {
				  return new ClasseIT(res);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
	
		return null;
	}

	@Override
	public boolean addClasseIT(String tipo, double aggiunta, int id_normativa) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_CLASSIT);
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

	

}
