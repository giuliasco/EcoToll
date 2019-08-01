package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLDAOFactory extends DAOFactory {
	
	
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/ecotoll";
	
	 public static Connection createConnection() {
	        Connection conn = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = (Connection) DriverManager.getConnection(DBURL, "root", "ecotoll");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	        	e.printStackTrace();
	        }
	        return conn;
	    } 
	 
	 public static void closeDbConnection(ResultSet rs,  Statement stmt,  Connection conn){
		 
	        try  {
	            if (rs != null)  {
	                rs.close();
	            }
	            if (stmt != null)  {
	                stmt.close();
	            }
	            if (conn != null)  {
	                conn.close();
	            }
	        } catch (SQLException se) {se.printStackTrace();} {
	            	            
	        }
	    }

	@Override
	public DAOAutostrada getDAOAutostrada() {return new MySqlDAOAutostradaDAOimpl();}
	@Override
	public DAOCasello getDAOCasello() {return new MySqlDAOCaselloDAOimpl();}
	@Override
	public DAOClasseEU getDAOClasseEU() {return new MySqlDAOClasseEUDAOimpl();}
	@Override
	public DAOClasseIT getDAOClasseIT() {return new MySqlDAOClasseITDAOimpl();}
	@Override
	public DAONormativa getDAONormativa() {return new MySqlDAONormativaDAOimpl();}
	@Override
	public DAORuolo getDAORuolo() {return new MySqlDAORuoloDAOimpl();}
	@Override
	public DAOUtente getDAOUtente() {return new MySqlDAOUtenteDAOimpl();}
	@Override
	public DAOVeicolo getDAOVeicolo() {return new MySqlDAOVeicoloDAOimpl();}
	
	

}
