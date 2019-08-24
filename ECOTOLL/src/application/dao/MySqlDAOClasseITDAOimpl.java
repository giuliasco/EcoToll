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
	private final String SELECT_CLASSEIT_FROM_ID = "SELECT * FROM classe_italiana WHERE id=?";


	@Override
	public List<ClasseIT> getAllClasseIT() {
		List<ClasseIT> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(CLASS_IT);
			  res = prep.executeQuery();
			  while(res.next()) {
				  ClasseIT classeit= new ClasseIT();
				  classeit.setId(res.getInt("id"));
				  classeit.setIdNormativa(res.getInt("id_normativa"));
				  classeit.setAggiunta(res.getDouble("aggiunta"));
				  classeit.setTipo(res.getString("tipo"));
				  list.add(classeit);
			  }
		}catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}

	
	@Override
	public ClasseIT getClasseIT(int id) {
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(SELECT_CLASSEIT_FROM_ID);
			  prep.setInt(1, id);
			  res = prep.executeQuery();
			  res.next(); 
			  ClasseIT ci =new ClasseIT(res);
			  ClasseIT ci1 = ClasseIT.getIstance();
			  ci1.setglobal(ci);
			  return ci1;
		}catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return null;
	}

	
}
