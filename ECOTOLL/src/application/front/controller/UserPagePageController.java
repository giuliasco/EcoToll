package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.controller.CaselloController;
import application.controller.ClasseItController;
import application.controller.NormativaController;
import application.controller.UtenteController;
import application.controller.VeicoloController;
import application.controller.AutostradaController;
import application.model.Casello;
import application.model.ClasseIT;
import application.model.Normativa;
import application.model.Utente;
import application.model.Veicolo;
import application.model.Autostrada;
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
	Normativa n = Normativa.getInstance();
	
	private ObservableList<Casello> caselloIn = FXCollections.observableArrayList();
	private ObservableList<Casello> caselloOut = FXCollections.observableArrayList();
	private Casello caselloSelezionatop;
	private Casello caselloSelezionatoa;
	private CaselloController caselloController = new CaselloController();
	private VeicoloController veicoloController = new VeicoloController();
	private ClasseItController classeItController = new ClasseItController();
	private AutostradaController autostradaController = new AutostradaController();
	
	
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
		System.out.println("La normativa è " + n.getNomeNormativa());
		}
		else {
		indietro.setVisible(false);
		labelBenvenuto.setText("Benvenuto " + u.getNomeUtente().toUpperCase());
		partenza.setItems(this.caselloIn);
		arrivo.setItems(this.caselloOut);
		System.out.println("La normativa è " + n.getNomeNormativa());}
	}
	
	
	@FXML
	public void getComboCaselli(ActionEvent evt) {
		caselloSelezionatop=partenza.getValue();
		caselloSelezionatoa=arrivo.getValue();
		
	}
	
	@FXML
	public void calcolaPedaggio (ActionEvent evt){
		
		String p = partenza.getValue().toString();
		String a = arrivo.getValue().toString();
		caselloController.setCaselloGlobalByName(p);
		Casello partenza = Casello.getIstance();
		caselloController.setCaselloGlobalByName(a);
		
		Casello arrivo = Casello.getIstance();
		System.out.println("la partenza =" + partenza.getNomeCasello() + partenza.getAltezzaKm() + "L'Arrivo =" + arrivo.getNomeCasello()+ arrivo.getAltezzaKm());
		if (partenza.getIdAutostrada() != arrivo.getIdAutostrada()) {
			System.out.println("Non sono sulla stessa autostrada");
		}else {
			if(!targa.getText().isEmpty()) {
				if(veicoloController.veicoloPresente(targa.getText().toUpperCase())) {
					System.out.println("Presente");
					if (n.getId()==1) {
						veicoloController.setVeicolorGlobal(targa.getText());
						Veicolo v = Veicolo.getIstance();
						classeItController.setClasseItGlobal(v.getIdCi());
						ClasseIT ci = ClasseIT.getIstance();
						System.out.println(ci.getTipo());
						autostradaController.setAutostradaGlobalbyID(partenza.getIdAutostrada());
						Autostrada aut = Autostrada.getInstance();
						System.out.println(aut.getNomeAutostrada());
						double altezza_p= partenza.getAltezzaKm();
						double altezza_a=arrivo.getAltezzaKm();
						double diff = altezza_a - altezza_p;
						double ass= (Math.abs(diff));
						double tariffa_km = aut.getTariffaKm();
						double prezzo = ass*tariffa_km;
						System.out.println(prezzo);
						double percentuale = (22*prezzo)/100;
						System.out.println(percentuale);
						double pedaggio=(Math.round((prezzo + percentuale + ci.getAggiunta())*10))/10.0;
						String totale=Double.toString(pedaggio);
						totalePedaggio.setText(totale + "  €");
				}
				
			    
			}
}
	}
	
	}
}
