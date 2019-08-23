package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.CaselloController;
import application.controller.NormativaController;
import application.controller.UtenteController;
import application.model.Casello;
import application.model.Utente;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserPagePageController implements Initializable{
	
	@FXML private ComboBox<Casello> partenza;
	@FXML private ComboBox<Casello> arrivo;
	@FXML private TextField targa;
	@FXML private TextField totalePedaggio;
	@FXML private Button logout;
	@FXML private Button bottonePedaggio;
	@FXML private Label labelBenvenuto;
	@FXML private Button indietro;
	

	Utente u=Utente.getIstance();
	
	private ObservableList<Casello> caselloIn = FXCollections.observableArrayList();
	private ObservableList<Casello> caselloOut = FXCollections.observableArrayList();
	private Casello caselloSelezionatop= null;
	private Casello caselloSelezionatoa= null;
	private CaselloController caselloController = new CaselloController();
	
	//costruttore
	public UserPagePageController() {
		caselloIn.setAll(CaselloController.getIstance().getAllCas());
		caselloOut.setAll(CaselloController.getIstance().getAllCas());
	}
	
	

	 @FXML 
	  public void logout (ActionEvent evt){
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			}
		}
	 
	 
	 @FXML 
	  public void indietro (ActionEvent evt){
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



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (u.getIdRuolo()==2) {indietro.setVisible(true);
		labelBenvenuto.setText("Benvenuto Admin " + u.getNomeUtente().toUpperCase());
		partenza.setItems(this.caselloIn);
		arrivo.setItems(this.caselloOut);
		}
		else {
		indietro.setVisible(false);
		labelBenvenuto.setText("Benvenuto " + u.getNomeUtente().toUpperCase());
		partenza.setItems(this.caselloIn);
		arrivo.setItems(this.caselloOut);}
	}
	
	
	
	public void getComboCaselli(ActionEvent evt) {
		caselloSelezionatop=partenza.getValue();
		caselloSelezionatoa=arrivo.getValue();
		
	}
	
	
	
	

}
