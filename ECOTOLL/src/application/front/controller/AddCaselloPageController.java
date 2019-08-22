package application.front.controller;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddCaselloPageController implements Initializable {
	
	@FXML private TextField nomeCasello;
	@FXML private TextField altezzaCasello;
	@FXML private ComboBox<Autostrada> autostrada;
	@FXML private Button bottoneAnnulla;
	
	
	
	private ObservableList<Autostrada> elencoAutostrade = FXCollections.observableArrayList();
	private Casello casello = new Casello();
	private Autostrada autostradaselezionata = null;
	CaselloController casc = null;
	
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
			System.out.println(autostrada.getValue());

		}
		
		public void annulla (ActionEvent evt){
			try {
				((Node)evt.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/front/fxml/AdminPage.fxml").openStream());
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();		
			}catch(Exception e){
				}
			}
		
		
		
		@FXML 
		
	public void Aggiungi(ActionEvent evt) throws IOException {
			
			System.out.println("Campi mancantieeeeeeeeeeeee");
			if (nomeCasello.getText().isEmpty() || altezzaCasello.getText().isEmpty()) {
					System.out.println("Campi mancanti");
			}else {
				System.out.println(autostradaselezionata.getNomeAutostrada());
				casc.addCasello(nomeCasello.getText(), altezzaCasello.getText(), autostradaselezionata.hashCode());
				casc.setCaselloGlobal(nomeCasello.getText(), altezzaCasello.getText(), autostradaselezionata.getId());
			        System.out.println("casello aggiunto");
					
			}
			}
			
		}	
		
		
		


