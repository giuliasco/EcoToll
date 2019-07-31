package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Casello {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nome_casello = new SimpleStringProperty();
	private IntegerProperty altezza_km = new SimpleIntegerProperty();
	private StringProperty id_autostrada = new SimpleStringProperty();
	private Autostrada autostrada;
	
	public Casello() {
		id = new SimpleIntegerProperty();
		nome_casello = new SimpleStringProperty();
		altezza_km = new SimpleIntegerProperty();
		id_autostrada = new SimpleStringProperty();
		autostrada = new Autostrada();
	}
	
	@Override
	public String toString() {
		return getNomeCasello();
	}
	
	//metodi getter
	public final int getIdCasello() { return id.get();}
	public final String getNomeCasello() {return nome_casello.get();}
	public final int getAltezzaKm() {return altezza_km.get();}
	public final String getIdAutostrada() {return id_autostrada.get();}
	
	//metodi setter
	
	public final void setIdCasello(int value) {id.set(value);}
	public final void setNomeCasello(String value) {nome_casello.set(value);}
	public final void setAltezzaKm(int value) {altezza_km.set(value);}
	public final void setIdAutostrada(String value) {id_autostrada.set(value);}
	
	//metodi getter per i "Property"
	
	public IntegerProperty idCaselloProperty() {return id;}
	public StringProperty NomeCaselloProperty() {return nome_casello;}
	public IntegerProperty AltezzaKmProperty() {return altezza_km;}
	public StringProperty IdAutostradaProperty() {return id_autostrada;}
	
	public Autostrada getAutostrada() {return this.autostrada;}
	
	public void setAutostrada(Autostrada autostrada) {this.autostrada=autostrada;}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Casello))
			return false;
		Casello other = (Casello) obj;
		if (altezza_km == null) {
			if (other.altezza_km != null)
				return false;
		} else if (!altezza_km.equals(other.altezza_km))
			return false;
		if (autostrada == null) {
			if (other.autostrada != null)
				return false;
		} else if (!autostrada.equals(other.autostrada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome_casello == null) {
			if (other.nome_casello != null)
				return false;
		} else if (!nome_casello.equals(other.nome_casello))
			return false;
		return true;
	}

	

}
