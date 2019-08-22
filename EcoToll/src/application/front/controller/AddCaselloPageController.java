package application.front.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.AutostradaController;
import application.controller.CaselloController;
import application.model.Autostrada;
import application.model.Casello;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddCaselloPageController implements Initializable {
	
	@FXML private TextField nomeCasello;
	@FXML private TextField altezzaCasello;
	@FXML private ComboBox<Autostrada> autostrada;
	
	public CaselloController caselloController = new CaselloController();
	
	private ObservableList<Autostrada> elencoAutostrade = FXCollections.observableArrayList();
	private Casello casello = new Casello();
	private Autostrada autostradaselezionata = null;
	
	//costruttore
		public AddCaselloPageController() {
			elencoAutostrade.setAll(AutostradaController.getIstance().getAllAut());
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			autostrada.setItems(this.elencoAutostrade);
		}
		
		public void getComboAutostrada(ActionEvent evt) {
			autostradaselezionata=autostrada.getValue();
		}

}
