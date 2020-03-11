package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleArray;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	ParoleArray elencoArray ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
    	double start = System.nanoTime();
    	elencoArray.addParola(txtParola.getText());
    	double stop = System.nanoTime();
    	txtResult.setText(elencoArray.toString());
    	txtParola.clear();
    	double tempo = stop-start;
    	txtTempi.appendText(tempo + " nanosecondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	double start = System.nanoTime();
    	elencoArray.reset();
    	double stop = System.nanoTime();
    	double tempo = stop-start;
    	txtTempi.appendText(tempo + " nanosecondi\n");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	double start = System.nanoTime();
    	elencoArray.cancellaParola(txtResult.getSelectedText());
    	double stop = System.nanoTime();
    	txtResult.setText(elencoArray.toString());
    	double tempo = stop-start;
    	txtTempi.appendText(tempo + " nanosecondi\n");
    }

    

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempi != null : "fx:id=\"txtTempi\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
        elencoArray = new ParoleArray();
    }
}
