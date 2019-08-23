package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddCaselloPageController implements Initializable {
	
	@FXML private TextField nomeCasello;
	@FXML private TextField altezzaCasello;
	@FXML private ComboBox<Autostrada> autostrada;
	@FXML private Button bottoneAnnulla;
	@FXML private Label messaggiVari ;
	@FXML private Button bottoneAddCasello;
	
	
	
	private ObservableList<Autostrada> elencoAutostrade = FXCollections.observableArrayList();
	private Casello casello = new Casello();
	private Autostrada autostradaselezionata  ;
	private CaselloController casc = new CaselloController(); 
	
	
	//PROVA NUOVO
	private  AutostradaController ac = new AutostradaController();
	
	
	
	
	
	
	//costruttore
		public AddCaselloPageController() {
			elencoAutostrade.setAll(AutostradaController.getIstance().getAllAut());
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			autostrada.setItems(this.elencoAutostrade);
			
			
		}
		
		@FXML
		public void getComboAutostrada(ActionEvent evt)  {
			try{
				autostradaselezionata=autostrada.getValue();
			}catch(Exception e){System.out.println("CAZZOOOOOOO");}
 
		}
		
		@FXML
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
			try {
			String x = autostrada.getValue().toString();
			ac.setAutostradaGlobal(x);
			Autostrada a = Autostrada.getInstance();
			 final double d = Double.parseDouble(altezzaCasello.getText());
			 final String s = nomeCasello.getText();
		
		
			System.out.println(a.getNomeAutostrada() +" "+d+" "+s+"   " +a.getId() +"  CAZZOOOOO");
			
			if (s==null || d == 0  ) {
				messaggiVari.setText("Campi mancanti");
					System.out.println("Campi mancanti");
					
			}else {
				
				casc.addCasello(nomeCasello.getText(), d, a.getId());
				casc.setCaselloGlobal(nomeCasello.getText(), d); 
				Casello c = Casello.getIstance();
				messaggiVari.setText("Casello aggiunto con successo");
				altezzaCasello.setText("");
				nomeCasello.setText("");
			        System.out.println(c.getNomeCasello());}
					
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Errore nel caricamento sul DB");
				messaggiVari.setText("Inserire valore numerico in 'Altezza Casello'");
			}
				
			}
		
			
		}	
		
		
		


