package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.LoginManager;
import application.model.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController{
	
	@FXML private Button accedi;
	@FXML private Button registrati;
	@FXML private TextField email;	
	@FXML private TextField password;
	
	private LoginManager loginManager = new LoginManager();
	Utente u = new Utente();
	
	
/**
 * Verifica username e password ed il ruolo
 * se admin apre l'interfaccia amministratore fxml altrimenti Percorso.fxml 
 * @param evt action event
 * @throws IOException errore sull'IO 
 */
	
    
	@FXML
 		public void Registrazione (ActionEvent actionEvent) throws IOException 
	    {			
				((Node)actionEvent.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/front/fxml/Registration.fxml").openStream());
				Scene scene = new Scene(root);				
				primaryStage.setScene(scene);
				primaryStage.show();		
		} 
	
	
	@FXML
	public void login (ActionEvent evt) throws IOException {
			
		if (loginManager.login(email.getText(), password.getText())) {			
			u=loginManager.setUserGlobal(email.getText(), password.getText());
			System.out.println(u.getCognomeUtente());
			/*if (u.getIdRuolo()==2) {
				((Node)evt.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/front/fxml/UserPage.fxml").openStream());
				Scene scene = new Scene(root);					
				primaryStage.setScene(scene);
				primaryStage.show();
				
             System.out.println("Admin");
		}
			/*if (loginManager.setUserGlobal(email.getText(), password.getText()).getIdRuolo()==1) 
				{
					((Node)evt.getSource()).getScene().getWindow().hide(); 
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root=loader.load(getClass().getResource("/application/front/fxml/AdminPage.fxml").openStream());
					Scene scene = new Scene(root);							
					primaryStage.setScene(scene);
					primaryStage.show();
					
			}else{
					((Node)evt.getSource()).getScene().getWindow().hide(); 
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root=loader.load(getClass().getResource("/application/front/fxml/AdminPage.fxml").openStream());
					Scene scene = new Scene(root);					
					primaryStage.setScene(scene);
					primaryStage.show();
					System.out.println("User");
			}*/
	
			
		} 
	
		
   
 		
}
}
