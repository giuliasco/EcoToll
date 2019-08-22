package application.front.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.AutostradaController;
import application.controller.CaselloController;
import application.controller.NormativaController;
import application.model.Autostrada;
import application.model.Casello;
import application.model.Normativa;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminPagePageController implements Initializable {
	
	@FXML private ComboBox<Normativa> normativeDisponibili;
	@FXML private Button bottoneAggiornaNormativa;
	@FXML private ComboBox<Casello> caselli;
	@FXML private Button bottoneEliminaCasello;
	@FXML private Button bottoneAggiungiCasello;
	@FXML private Button bottoneCalcolaPedaggio;
	@FXML private Button bottoneLogout;
	@FXML private Label normativaCorrente;
	
	
	
	private ObservableList<Normativa> elencoNormative = FXCollections.observableArrayList();
	private Normativa normativaselezionata = null;
	private NormativaController normativaController = new NormativaController();
	Normativa n = Normativa.getInstance();
	
	
	
	
	//costruttore
			public AdminPagePageController() {
				elencoNormative.setAll(NormativaController.getIstance().getAllNorm());
			}
			
			@Override
			public void initialize(URL location, ResourceBundle resources) {
				normativeDisponibili.setItems(this.elencoNormative);
				normativaCorrente.setText(n.getNomeNormativa());
				
			}
			
			public void getComboNormative(ActionEvent evt) {
				normativaselezionata=normativeDisponibili.getValue();
				
			
			}
	
	
	
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
	
		
		public void aggiornaNormativa (ActionEvent evt) {
		normativaselezionata=normativeDisponibili.getValue();
		//System.out.println(normativaselezionata);
		String x = normativaselezionata.toString();
		normativaCorrente.setText(x);
		normativaController.setNormativaGlobal(x);
		
		}
			
			
		public void openAddCasello (ActionEvent evt){
			try {
				((Node)evt.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/front/fxml/AddCasello.fxml").openStream());
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();		
			}catch(Exception e){
				}
			}
		
		
	
		
	
	
	

}
