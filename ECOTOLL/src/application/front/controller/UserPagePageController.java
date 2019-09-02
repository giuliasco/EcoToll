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
	

	Utente u = Utente.getIstance();
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
			System.out.println("Errore");
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
			System.out.println("Errore");
			}
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
					String nome="italiana-2019";
					String nomeNorm = n.getNomeNormativa();
					System.out.println(nome + nomeNorm);
					if (nomeNorm.equalsIgnoreCase(nome)) {
						veicoloController.setVeicolorGlobal(targa.getText());
						Veicolo v = Veicolo.getIstance();
						classeItController.setClasseItGlobal(v.getIdCi());
						ClasseIT ci = ClasseIT.getIstance();
						autostradaController.setAutostradaGlobalbyID(partenza.getIdAutostrada());
						Autostrada aut = Autostrada.getInstance();
						double pedaggio=(Math.round(((Math.abs(arrivo.getAltezzaKm() - partenza.getAltezzaKm()))*aut.getTariffaKm() + (22*(Math.abs(arrivo.getAltezzaKm() - partenza.getAltezzaKm()))*aut.getTariffaKm())/100 + ci.getAggiunta())*10))/10.0;
						/*PASSAGGI CHE ABBIAMO INIZIALMENTE UTILIZZATO PER ARRIVARE A CALCOLARE IL PARAMETRO PEDAGGIO
						 * double altezza_p= partenza.getAltezzaKm();
						//double altezza_a=arrivo.getAltezzaKm();
						//double diff = arrivo.getAltezzaKm() - partenza.getAltezzaKm();
						//double ass= (Math.abs(arrivo.getAltezzaKm() - partenza.getAltezzaKm()));
						//double tariffa_km = aut.getTariffaKm();
						//double prezzo = (Math.abs(arrivo.getAltezzaKm() - partenza.getAltezzaKm()))*aut.getTariffaKm();
						double percentuale = (22*(Math.abs(arrivo.getAltezzaKm() - partenza.getAltezzaKm()))*aut.getTariffaKm())/100;*/
						String totale=Double.toString(pedaggio);
						totalePedaggio.setText(totale + "  €");
				}else {
					System.out.println("Errore");
				}
			}
			}
		}
		}
	
}

