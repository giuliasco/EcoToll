package application.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Autostrada;

public class MySqlDAOAutostradaDAOimpl implements DAOAutostrada {
	
	private Connection con = null;
	private PreparedStatement prep=null;
	private ResultSet res = null;
	
	private final String INSERT_AUTOSTRADA ="INSERT INTO autostrada (nome_autostrada, inizio, fine, km, tariffa_km) values ('?,?,?,?,?)";
	private final String GET_ID_AUTOSTRADA = "SELECT * FROM autostrada WHERE nome_autostrada=?";
	
	@Override
	public boolean addAutostrada(String nome_autostrada, String inizio, String fine, double km, double tariffa_km) {
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(INSERT_AUTOSTRADA);
			prep.setString(1, nome_autostrada);
			prep.setString(2, inizio);
			prep.setString(3, fine);
			prep.setDouble(4, km);
			prep.setDouble(5, tariffa_km);
			
			return prep.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public int getIdAutostrada (String nome_autostrada) {
		int ida=0;
		try {
			con = MySQLDAOFactory.createConnection();
			prep = (PreparedStatement) con.prepareStatement(GET_ID_AUTOSTRADA);
			prep.setString(1, nome_autostrada);
			res = prep.executeQuery();
			while (res.next()){
			ida = res.getInt("id");
			}}
			catch (Exception e)	{
				e.printStackTrace();
				}
		return ida;
		}
	}

