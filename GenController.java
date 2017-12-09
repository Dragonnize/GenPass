import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;

public class GenController {

	@FXML
	CheckBox checkBoxMaj = new CheckBox();
	@FXML
	CheckBox checkBoxLettre = new CheckBox();
	@FXML
	CheckBox checkBoxChiffre = new CheckBox();
	@FXML
	TextField textFieldPassword = new TextField();
	@FXML
	Slider sliderField = new Slider();
	 
	ArrayList<String> CharTab = new ArrayList<String>();
	
	Stage PrimaryStage;
	
	public int Min;
	public int Max;
	 
	@FXML
	private void initialize() {
		checkBoxMaj.setSelected(true);
		checkBoxLettre.setSelected(true);
		checkBoxChiffre.setSelected(true);
		
		sliderField.setBlockIncrement(1);
	}
	 
	@FXML
	public void handleButtonGen() {
		String text = new String();
		
		text = this.op();
		 
		this.addValueTextField(text);
	}
	 
	public void addValueTextField(String text) {
		this.textFieldPassword.setText(text);
	}
	 
	public String op() {
		
		this.CharTab = new ArrayList<String>();
		String value = "";
		
		if(checkBoxMaj.isSelected() != true && checkBoxLettre.isSelected() != true && checkBoxChiffre.isSelected() != true) {
			this.displayError();
		} else {
			
			if(checkBoxMaj.isSelected()) {
				this.addMajList();
			}
			 
			if(checkBoxLettre.isSelected()) {
				this.addLettreList();	 
			}
			
			if(checkBoxChiffre.isSelected()) {
				this.addChiffreList();
			}
			
			this.Min = 0;
			this.Max = CharTab.size();
			
			int MaxLengthPass = (int) sliderField.getValue();
			
			for(int i=0; i < MaxLengthPass; i++) {
				int randInt = this.getRandom();
				String res = CharTab.get(randInt);
				value += res;
			}
		}
		
		return value;
	}
	 
	public void addMajList() {
		 
		CharTab.add("A");
		CharTab.add("B");
		CharTab.add("C");
		CharTab.add("D");
		CharTab.add("E");
		CharTab.add("F");
		CharTab.add("G");
		CharTab.add("H");
		CharTab.add("I");
		CharTab.add("J");
		CharTab.add("K");
		CharTab.add("L");
		CharTab.add("M");
		CharTab.add("N");
		CharTab.add("O");
		CharTab.add("P");
		CharTab.add("Q");
		CharTab.add("R");
		CharTab.add("S");
		CharTab.add("T");
		CharTab.add("U");
		CharTab.add("V");
		CharTab.add("W");
		CharTab.add("X");
		CharTab.add("Y");
		CharTab.add("Z");
	}
	 
	public void addLettreList() {
		
		CharTab.add("a");
		CharTab.add("b");
		CharTab.add("c");
		CharTab.add("d");
		CharTab.add("e");
		CharTab.add("f");
		CharTab.add("g");
		CharTab.add("h");
		CharTab.add("j");
		CharTab.add("k");
		CharTab.add("l");
		CharTab.add("m");
		CharTab.add("n");
		CharTab.add("o");
		CharTab.add("p");
		CharTab.add("q");
		CharTab.add("r");
		CharTab.add("s");
		CharTab.add("t");
		CharTab.add("u");
		CharTab.add("v");
		CharTab.add("w");
		CharTab.add("x");
		CharTab.add("y");
		CharTab.add("z");
	}
	
	public void addChiffreList() {
		
		CharTab.add("0");
		CharTab.add("1");
		CharTab.add("2");
		CharTab.add("3");
		CharTab.add("4");
		CharTab.add("5");
		CharTab.add("6");
		CharTab.add("7");
		CharTab.add("8");
		CharTab.add("9");
	}
	
	public int getRandom() {
		Random rand = new Random(); 
		int nombreAleatoire = rand.nextInt(this.Max - this.Min) + this.Min;
		return nombreAleatoire;
	}
	
	@FXML
	public void handleCopy() {
		if(this.textFieldPassword.getText() != "") {
			Clipboard clipboard = Clipboard.getSystemClipboard();
			ClipboardContent content = new ClipboardContent();
		    content.putString(this.textFieldPassword.getText());
		    clipboard.setContent(content);
		}
	}
	
	public void displayError() {
		// Nothing selected.
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(this.PrimaryStage);
        alert.setTitle("Erreurs");
        alert.setHeaderText("Aucune option sélectionnée.");
        alert.setContentText("Vous devez sélectionner au moins une option.");

        alert.showAndWait();
	}
}
