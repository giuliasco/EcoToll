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

public class LoginPageController{
  
  @FXML private Button accedi;
  @FXML private Button registrati;
  @FXML private TextField email;  
  @FXML private PasswordField password;
  @FXML private Label labelErrore;
  
  private UtenteController loginManager = new UtenteController();

  
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
	  
      
    if(loginManager.login(email.getText(), password.getText())) {  
      
    
    	loginManager.setUserGlobal(email.getText(), password.getText());
    	Utente u = Utente.getIstance(); 
    	System.out.println(u.getEmail() + u.getId());
    	if (u.getIdRuolo()==2) {
    		((Node)evt.getSource()).getScene().getWindow().hide(); 
    		Stage primaryStage = new Stage();
    		FXMLLoader loader = new FXMLLoader();
    		Pane root=loader.load(getClass().getResource("/application/front/fxml/AdminPage.fxml").openStream());
    		Scene scene = new Scene(root);          
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		System.out.println("Admin");
    	}else{
    		((Node)evt.getSource()).getScene().getWindow().hide(); 
    		Stage primaryStage = new Stage();
    		FXMLLoader loader = new FXMLLoader();
    		Pane root=loader.load(getClass().getResource("/application/front/fxml/UserPage.fxml").openStream());
    		Scene scene = new Scene(root);          
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		System.out.println("User");
    		}
    }else { 
    	labelErrore.setText("Email o password errate");}
  }
  
 
}