package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.UtenteController;
import application.dao.DAOUtente;
import application.model.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
  private Utente utente;

  
  
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
      
    
      loginManager.setUserGlobal(email.getText(), password.getText()); /* quando viene effettuato il login questa funziona
      esegue la query per prendere tutte le informazioni dell'utente loggato, dopodiché prese le informazioni
      istanzia un oggetto di tipo utente di tipo statico ( che rimane salvato per tutta l'esecuzione del processo)
      
      la funzione dopo prende ogni volta l'istanza dell'utente in sessione, per prendere le info ogni volta bisogna fare così
      Utente u = utente.getIstance ( da notare anche la riga 30, senza di essa non può essere fatto questo lavoro)
      */
      
      
      Utente u = utente.getIstance(); 
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
    }
     else{
          ((Node)evt.getSource()).getScene().getWindow().hide(); 
          Stage primaryStage = new Stage();
          FXMLLoader loader = new FXMLLoader();
          Pane root=loader.load(getClass().getResource("/application/front/fxml/UserPage.fxml").openStream());
          Scene scene = new Scene(root);          
          primaryStage.setScene(scene);
          primaryStage.show();
          System.out.println("User");
      }
  
      
    } 
  
    else { labelErrore.setText("Email o password errate");}
   
     
}
  
 
}