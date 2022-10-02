package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
	private Label label;
	private Button comprobarButton;
	private TextField numText;
	private VBox root;
	
	int numRandom=(int)(Math.random()*100);
	int intentos=1;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		numText = new TextField();
		numText.setPromptText("Introduce un numero");
		numText.setMaxWidth(150);
		
		label = new Label();
		label.setText("");
		
		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		comprobarButton.setDefaultButton(true);
	
		root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(numText, comprobarButton, label);

		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent e) {
		
		String num=(numText.getText());
		int numUsuario=Integer.parseInt(num);
		
		 if(numUsuario>100) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El numero introducido no es valido");
			alert.showAndWait();
		
		 }else if(numUsuario > numRandom) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El numero a adivinar es menor que "+numUsuario);
			alert.showAndWait();
			intentos++;
			
		} else if (numUsuario < numRandom) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El numero a adivinar es mayor que "+numUsuario);
			alert.showAndWait();
			intentos++;
		
		} else if(numUsuario==numRandom) {			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has Ganado!");
			alert.setContentText("Solo has necesitado "+intentos+" intentos");
			alert.showAndWait();
			intentos++;
		}
			
	}	

	public static void main(String[] args) {
		launch(args);
	}

}