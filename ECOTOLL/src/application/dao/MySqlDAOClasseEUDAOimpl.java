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
	public List<ClasseEU> getAllClasseEU() {
		List<ClasseEU> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(CLASS_EU);
			 
			  res = prep.executeQuery();
			  while(res.next()) {
				  ClasseEU classeeu=new ClasseEU();
				  classeeu.setId(res.getInt("id"));
				  classeeu.setIdNormativa(res.getInt("id_normativa"));
				  classeeu.setAggiunta(res.getDouble("aggiunta"));
				  classeeu.setTipo(res.getString("tipo"));
				  list.add(classeeu);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}


	@Override
	public boolean addClasseEU(ClasseEU eu) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_CLASSEU);
			prep.setString(1, eu.getTipo());
			prep.setDouble(2, eu.getAggiunta());
			prep.setInt(3, eu.getIdNormativa());
			
			
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public ClasseEU getClasseEU(ClasseEU eu) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_CLASSEUFROMIDNORMATIVA);
			  prep.setInt(1, eu.getIdNormativa());
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