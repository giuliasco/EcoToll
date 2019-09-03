package application.front.controller;


import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.controller.CaselloController;
import application.controller.NormativaController;
import application.model.Casello;
import application.model.Normativa;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminPagePageController implements Initializable {
	
	@FXML private ComboBox<Normativa> normativeDisponibili;
	@FXML private ComboBox tipoNormativa; 
	@FXML private Button bottoneAggiornaNormativa;
	@FXML private ComboBox<Casello> caselli;
	@FXML private Button bottoneEliminaCasello;
	@FXML private Button bottoneAggiungiCasello;
	@FXML private Button bottoneCalcolaPedaggio;
	@FXML private Button bottoneLogout;
	@FXML private Label normativaCorrente;
	@FXML private Label labelBenvenuto;
	
	
	private ObservableList<Normativa> elencoNormative = FXCollections.observableArrayList();
	private ObservableList<Casello> elencoCaselli = FXCollections.observableArrayList();
	private ObservableList<String> tipi = FXCollections.observableArrayList("Italiana","Europea");
	private Normativa normativaselezionata;
	private String nomeSelezionato;
	private CaselloController cc = new CaselloController();
	private NormativaController normativaController = new NormativaController();
	Normativa n = Normativa.getInstance();
	Utente u=Utente.getIstance();
	private Casello caselloselezionato = null;
	
	//costruttore
			public AdminPagePageController() {
				
				elencoCaselli.setAll(CaselloController.getIstance().getAllCas());
			}
			
			@Override
			public void initialize(URL location, ResourceBundle resources) {
				normativeDisponibili.setItems(this.elencoNormative);
				if(n.getNomeNormativa() == null) {
					normativaCorrente.setText("");
				} else {
				normativaCorrente.setText(n.getNomeNormativa() + "   " + n.getAnnoNormativa());}
				labelBenvenuto.setText("Benvenuto Admin " + u.getNomeUtente().toUpperCase());
				caselli.setItems(this.elencoCaselli);
				tipoNormativa.setItems(tipi);
			Iterator<String> I =	tipi.iterator();
			while(I.hasNext()) {
				System.out.println(I.next());
			}
				System.out.println(tipi);
			}
			
			
			
			
			public void getComboCaselli(ActionEvent evt) {
				caselloselezionato=caselli.getValue();
			}
			
			public void getComboNormative(ActionEvent evt) {
				normativaselezionata=normativeDisponibili.getValue();
				}
			
			
			public void update (ActionEvent evt) {
				elencoNormative.setAll(NormativaController.getIstance().getAllNorm((String) tipoNormativa.getSelectionModel().getSelectedItem()));
			}
	
	
	public void logout (ActionEvent evt) throws IOException{
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Errore logout!");
			JOptionPane.showMessageDialog(null, "Errore logout. Riprova.");
			}
		}
	
	
	@FXML 
	  public void openPedaggio (ActionEvent evt) throws IOException{
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Pedaggio.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Errore apertura Pedaggio");
			}
		}
	
	
	@FXML
	public void eliminaCasello(ActionEvent evt) throws IOException {
		try{
		caselloselezionato = caselli.getValue();
		cc.delete(caselloselezionato);
		caselli.getItems().remove(caselloselezionato);}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore eliminazione casello");
			JOptionPane.showMessageDialog(null, "Errore eliminazione casello. Riprova");
		}
	
	}
		
	@FXML	
	public void aggiornaNormativa (ActionEvent evt) throws IOException{
	    try {
		normativaselezionata=normativeDisponibili.getValue();
		String x = normativaselezionata.toString();
		//System.out.println(normativaselezionata.getNomeNormativa() + normativaselezionata.getAnnoNormativa());
		normativaCorrente.setText(normativaselezionata.getNomeNormativa() + "   " + normativaselezionata.getAnnoNormativa());
		normativaController.setNormativaGlobal(x);
		}
	    catch(Exception e) {
	    	e.printStackTrace();
	    	System.out.println("Errore aggiornamento normativa");
	    	JOptionPane.showMessageDialog(null, "Errore aggiornamento normativa. Riprova");
	    	
	    }}
			
			
		public void openAddCasello (ActionEvent evt) throws IOException {
			try {
				((Node)evt.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/front/fxml/AddCasello.fxml").openStream());
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();		
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Errore apertura CaselloPage");
				}
			}
}
	
	
	


