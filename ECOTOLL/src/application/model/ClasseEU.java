package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasseEU {
	private int id,id_normativa;
	private double aggiunta;
	private String tipo;
	
	 private static ClasseEU instance = null;
		
	    public static ClasseEU getIstance() {
	        if(instance==null)
	                instance = new ClasseEU();
	        return instance;
	}
	
	public ClasseEU() {}
	
	public ClasseEU(int id,int id_normativa,double aggiunta,String tipo) {
		this.id= id;
		this.id_normativa= id_normativa;
		this.aggiunta= aggiunta;
		this.tipo= tipo;
	}
	
	public ClasseEU(ResultSet resultSet)throws SQLException {
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

	 public void setglobal(ClasseEU classeEu) {
	    	instance = classeEu;
	    }

}
