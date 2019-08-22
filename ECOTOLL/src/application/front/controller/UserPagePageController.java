package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.UtenteController;
import application.model.Casello;
import application.model.Utente;
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
	

	Utente u=Utente.getIstance();
	
	

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



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelBenvenuto.setText("Benvenuto " + u.getNomeUtente());
		
	}
	
	
	

}
