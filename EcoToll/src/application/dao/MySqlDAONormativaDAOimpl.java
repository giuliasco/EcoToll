package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MySqlDAONormativaDAOimpl implements DAONormativa {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String NORMATIVA = "SELECT * FROM normativa";
	private final String ADD_NORMATIVA = "INSERT INTO normativa(nome_normativa, anno_normativa) VALUES (?,?)";

	@Override
	public List<String> getAllNormative() {
		List<String> list = new ArrayList<String>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(NORMATIVA);
			 
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
	public boolean addNormativa(int anno_normativa,String nome_normativa) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_NORMATIVA);
			prep.setString(1, nome_normativa);
			prep.setDouble(2, anno_normativa);
	
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
