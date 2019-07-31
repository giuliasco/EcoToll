package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Normativa {
	
	private int id,anno_normativa;
	private String nome_normativa;
	
	//costruttore vuoto
	public Normativa() {}
	
	//costruttore che prevede tutti i campi
	public Normativa(int id,int anno_normativa,String nome_normativa) {
		this.id= id;
		this.anno_normativa= anno_normativa;
		this.nome_normativa=nome_normativa;
	}
	
	//costruttore che prevede ResultSet (query DB)
	public Normativa(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getInt("id"));
		this.setAnnoNormativa(resultSet.getInt("anno_normativa"));
		this.setNomeNormativa(resultSet.getString("nome_normativa"));
		}
	
	//metodi di get e set
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public int getAnnoNormativa() {return anno_normativa;}
	public void setAnnoNormativa(int anno_normativa) {this.anno_normativa=anno_normativa;}
	
	public String getNomeNormativa() {return nome_normativa;}
	public void setNomeNormativa(String nome_normativa) {this.nome_normativa=nome_normativa;}
	
}


