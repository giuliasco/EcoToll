package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseIT {
	
	private int id;
	private double aggiunta;
	private String tipo;
	
	public ClasseIT() {}
	
	public ClasseIT(int id,double aggiunta,String tipo) {
		this.id= id;
		this.aggiunta= aggiunta;
		this.tipo= tipo;
	}
	
	public ClasseIT(ResultSet resultSet)throws SQLException {
		this.setId(resultSet.getInt("id"));
		this.setAggiunta(resultSet.getDouble("aggiunta"));
		this.setTipo(resultSet.getString("tipo"));
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public double getAggiunta() {return aggiunta;}
	public void setAggiunta(double aggiunta) {this.aggiunta=aggiunta;}
	
	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo=tipo;}

}
