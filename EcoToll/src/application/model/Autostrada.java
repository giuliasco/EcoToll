package application.model;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Autostrada {
	
	private StringProperty id=new SimpleStringProperty();
	private StringProperty nome_autostrada=new SimpleStringProperty();
	private StringProperty inizio=new SimpleStringProperty();
	private StringProperty fine=new SimpleStringProperty();
	private IntegerProperty km=new SimpleIntegerProperty();
	private DoubleProperty tariffa_km= new SimpleDoubleProperty();
	
	
	
	private final ObservableList<Autostrada> autostrade;
	
	public Autostrada() {
		id=new SimpleStringProperty();
		nome_autostrada=new SimpleStringProperty();
		inizio=new SimpleStringProperty();
		fine=new SimpleStringProperty();
		km=new SimpleIntegerProperty();
		tariffa_km= new SimpleDoubleProperty();
		
	
		
		autostrade=FXCollections.observableArrayList();
	}
	
/*metodi di get*/
	public final String getId() {return id.get();}
	public final String getNomeAutostrada() {return nome_autostrada.get();}
	public final String getInizio() {return inizio.get();}
	public final String getFine() {return fine.get();}
	public final int getKm() {return km.get();}
	public final double getTariffaKm() {return tariffa_km.get();}
	
	/*medodi di set*/
	public final void setId(String value) {id.set(value);}
	public final void setNomeAutostrada(String value) {nome_autostrada.set(value);}
	public final void setInizio(String value) {inizio.set(value);}
	public final void setFine(String value) {fine.set(value);}
	public final void setKm(int value) {km.set(value);}
	public final void setTariffaKm(double value) {tariffa_km.set(value);}
	
	//metodi di getter per le property
	public StringProperty idProperty() {return id;}
	public StringProperty nomeAutostradaProperty() {return nome_autostrada;}
	public StringProperty inizioProperty() {return inizio;}
	public StringProperty fineProperty() {return fine;}
	public IntegerProperty kmProperty() {return km;}
	public DoubleProperty tariffaKmProperty() {return tariffa_km;}
	
	public List<Autostrada> getElencoAutostrade(){ return this.autostrade;}
	
	public void setElencoAutostrade(List<Autostrada> autostrade) {
		this.autostrade.setAll(autostrade);}
	
	public ObservableList<Autostrada> autostradaObsList(){return this.autostrade;}
	
	
	
	@Override
	public String toString() {
		return getId() ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Autostrada))
			return false;
		Autostrada other = (Autostrada) obj;
		if (fine == null) {
			if (other.fine != null)
				return false;
		} else if (!fine.equals(other.fine))
			return false;
		if (autostrade == null) {
			if (other.autostrade != null)
				return false;
		} else if (!autostrade.equals(other.autostrade))
			return false;
		if (inizio == null) {
			if (other.inizio != null)
				return false;
		} else if (!inizio.equals(other.inizio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (km == null) {
			if (other.km != null)
				return false;
		} else if (!km.equals(other.km))
			return false;
		if (nome_autostrada == null) {
			if (other.nome_autostrada != null)
				return false;
		} else if (!nome_autostrada.equals(other.nome_autostrada))
			return false;
		if (tariffa_km == null) {
			if (other.tariffa_km != null)
				return false;
		} else if (!tariffa_km.equals(other.tariffa_km))
			return false;
		return true;
	}
	
	
	
	
	
}
