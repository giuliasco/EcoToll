package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Normativa;



public class MySqlDAONormativaDAOimpl implements DAONormativa {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String NORMATIVA = "SELECT * FROM normativa";
	private final String ADD_NORMATIVA = "INSERT INTO normativa(nome_normativa, anno_normativa) VALUES (?,?)";

	@Override
	public List<Normativa> getAllNormative() {
		List<Normativa> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(NORMATIVA);
			 
			  res = prep.executeQuery();
			  while(res.next()) {
				  Normativa normativa = new Normativa();
				  normativa.setId(res.getInt("id"));
				  normativa.setAnnoNormativa(res.getInt("anno_normativa"));
				  normativa.setNomeNormativa(res.getString("nome_normativa"));
				  list.add(normativa);
			  }
	}
		catch (SQLException e) {
		e.printStackTrace(); 
		System.out.println("Problema nel DB");
		}
		return list;
	}

	@Override
	public boolean addNormativa(Normativa n) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(ADD_NORMATIVA);
			prep.setString(1, n.getNomeNormativa());
			prep.setDouble(2, n.getAnnoNormativa());
	
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}