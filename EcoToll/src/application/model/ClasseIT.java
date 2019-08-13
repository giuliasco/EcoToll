package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseIT {
	
	private int id, id_normativa;
	private double aggiunta;
	private String tipo;
	
	public ClasseIT() {}
	
	public ClasseIT(int id,int id_normativa,double aggiunta,String tipo) {
		this.id= id;
		this.id_normativa= id_normativa;
		this.aggiunta= aggiunta;
		this.tipo= tipo;
	}
	
	public ClasseIT(ResultSet resultSet)throws SQLException {
		this.setId(resultSet.getInt("id"));
		this.setIdNormativa(resultSet.getInt("id_normativa"));
		this.setAggiunta(resultSet.getDouble("aggiunta"));
		this.setTipo(resultSet.getString("tipo"));
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public int getIdNormativa() {return id_normativa;}
	public void setIdNormativa(int id_normativa) {this.id_normativa=id_normativa;}
	
	public double getAggiunta() {return aggiunta;}
	public void setAggiunta(double aggiunta) {this.aggiunta=aggiunta;}
	
	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo=tipo;}

}
