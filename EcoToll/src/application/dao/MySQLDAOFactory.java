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
	public DAOAutostrada getDAOAutostrada() {return new MySqlAutostrada();}
	@Override
	public DAOCasello getDAOCasello() {return new MySqlCasello();}
	@Override
	public DAOClasseEU getDAOClasseEU() {return new MySqlClasseEU();}
	@Override
	public DAOClasseIT getDAOClasseIT() {return new MySqlClasseIT();}
	@Override
	public DAONormativa getDAONormativa() {return new MySqlNormativa();}
	@Override
	public DAORuolo getDAORuolo() {return new MySqlRuolo();}
	@Override
	public DAOUtente getDAOUtente() {return new MySqlUtente();}
	@Override
	public DAOVeicolo getDAOVeicolo() {return new MySqlVeicolo();}
	
	

}
