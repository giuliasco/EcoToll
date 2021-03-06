package application.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class Normativa {
	
	private int id;
	private String nome_normativa, anno_normativa;
	private static Normativa instance = null;
	
	public static Normativa getInstance() {
		if(instance==null) instance = new Normativa();
		return instance;
	}
	
	//costruttore vuoto
	public Normativa() {}
	

	
	//costruttore che prevede tutti i campi
	public Normativa(int id,String anno_normativa,String nome_normativa) {
		this.id= id;
		this.anno_normativa= anno_normativa;
		this.nome_normativa=nome_normativa;
	}
	
	//costruttore che prevede ResultSet (query DB)
	public Normativa(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getInt("id"));
		this.setAnnoNormativa(resultSet.getString("anno_normativa"));
		this.setNomeNormativa(resultSet.getString("nome_normativa"));
		}
	
	//metodi di get e set
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public String getAnnoNormativa() {return anno_normativa;}
	public void setAnnoNormativa(String anno_normativa) {this.anno_normativa=anno_normativa;}
	
	public String getNomeNormativa() {return nome_normativa;}
	public void setNomeNormativa(String nome_normativa) {this.nome_normativa=nome_normativa;}
	
	public String toString() {
		return this.anno_normativa;
	}
	
	public void setGlobal(Normativa n) {
		instance = n;
	}
	
}


