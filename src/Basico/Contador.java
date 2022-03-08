package Basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{
	
	private int contador = 0;
	
	private void labelNumberAtt(Label label) {
		label.setText(Integer.toString(contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		
		if(contador > 0) {
			label.getStyleClass().add("verde");
		} else if(contador < 0) {
			label.getStyleClass().add("vermelho");
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label labelTittle = new Label("Contador");
		labelTittle.getStyleClass().add("titulo");
		Label number = new Label("0");
		number.getStyleClass().add("number");
		
		Button buttonIncrement = new Button("+");
		buttonIncrement.setOnAction(e -> {
			contador++;
			labelNumberAtt(number);
			
		});
		buttonIncrement.getStyleClass().add("botoes");
		Button buttonDecrement = new Button("-");
		buttonDecrement.setOnAction(e -> {
			contador--;
			labelNumberAtt(number);
		});
		buttonDecrement.getStyleClass().add("botoes");
		
		
		HBox boxButtons = new HBox();
		boxButtons.setAlignment(Pos.CENTER);
		boxButtons.setSpacing(35);
		boxButtons.getChildren().add(buttonDecrement);
		boxButtons.getChildren().add(buttonIncrement);
		
		VBox mainBox = new VBox();
		mainBox.getStyleClass().add("conteudo");
		mainBox.setSpacing(10);
		mainBox.setAlignment(Pos.CENTER);
		mainBox.getChildren().add(labelTittle);
		mainBox.getChildren().add(number);
		mainBox.getChildren().add(boxButtons);
		
		String Css = getClass().getResource("/basico/Contador.css").toExternalForm();
		Scene mainScene = new Scene(mainBox, 400, 400);
		mainScene.getStylesheets().add(Css);
		mainScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=PT+Serif");
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
