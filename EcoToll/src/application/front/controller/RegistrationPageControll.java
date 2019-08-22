package application.front.controller;

import java.io.IOException;

import application.controller.UtenteController;
import application.model.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrationPageControll {
	
	@FXML private TextField nome;
	@FXML private TextField cognome;
	@FXML private TextField email;
	@FXML private PasswordField password;
	@FXML private PasswordField password1;
	@FXML private Button bottoneRegistrati;
	@FXML private Button bottoneAnnulla;
	@FXML private Label giaPresente;
	
	
	 private UtenteController uc = new UtenteController();
	  
	
	  
	  @FXML 
	
	public void Registra(ActionEvent evt) throws IOException {
	
		if(!uc.login(email.getText(),password.getText())) {
		
			uc.addUtente(nome.getText(),cognome.getText(),email.getText(),password.getText());
			uc.setUserGlobal(email.getText(), password.getText());
			 ((Node)evt.getSource()).getScene().getWindow().hide(); 
		        Stage primaryStage = new Stage();
		        FXMLLoader loader = new FXMLLoader();
		        Pane root=loader.load(getClass().getResource("/application/front/fxml/UserPage.fxml").openStream());
		        Scene scene = new Scene(root);          
		        primaryStage.setScene(scene);
		        primaryStage.show();
		        System.out.println("Utente registrato");
			
		}else {giaPresente.setText("Utente già presente");
		nome.setText("");
		cognome.setText("");
		email.setText("");
		password.setText("");
		}
		
	}
	
	  
	  @FXML
	  public void Annulla(ActionEvent evt) throws IOException {
		nome.setText("");
		cognome.setText("");
		email.setText("");
		password.setText("");
		giaPresente.setText("");
	        	  
		  
	  }
	

}
