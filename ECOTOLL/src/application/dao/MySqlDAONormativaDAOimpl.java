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
	
	private final String NORMATIVA = "SELECT * FROM normativa WHERE nome_normativa=?";
	private static final String SELECT_NORMATIVA = "select * from normativa where id=1";
	private static String SELECT_NOME_NORMATIVA = "select * FROM normativa WHERE anno_normativa =?";

	
	@Override
	public List<Normativa> getAllNormative(String nome_normativa) {
		List<Normativa> list = new ArrayList<>();
		try {
			  con = MySQLDAOFactory.createConnection();
			  prep = (PreparedStatement) con.prepareStatement(NORMATIVA);
			  prep.setString(1, nome_normativa);
			  res = prep.executeQuery();
			  while(res.next()) {
				  Normativa normativa = new Normativa();
				  normativa.setId(res.getInt("id"));
				  normativa.setAnnoNormativa(res.getString("anno_normativa"));
				  normativa.setNomeNormativa(res.getString("nome_normativa"));
				  list.add(normativa);
			  }
		}catch (SQLException e) {
			e.printStackTrace(); 
			System.out.println("Problema nel DB");
		}
		return list;
	}

	
	@Override
	public String getNormativa() {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(SELECT_NORMATIVA);
			rst=pst.executeQuery();
			if (rst.next()) {
			return rst.getString("normativa");}
			else return "Nessuna Normativa presente";
		}catch (SQLException e)	{
			e.printStackTrace();
			return "Errore in SQL";
			}
	}
	
	
	@Override
	public Normativa getNomeNormativa(String annox) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep=(PreparedStatement) con.prepareStatement(SELECT_NOME_NORMATIVA);
			prep.setString(1, annox);
			res = prep.executeQuery();
			res.next();		
			Normativa n =new Normativa(res);
			Normativa n1 = Normativa.getInstance();
			n1.setGlobal(n);
			return n1;
			
		}catch (SQLException e)	{
			e.printStackTrace();
			return null;
		}
	}


}
