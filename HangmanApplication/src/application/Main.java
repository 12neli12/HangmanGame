package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
	    primaryStage.setTitle("Hangman Game");

	    StackPane root = new StackPane();
	    root.getStyleClass().add("root");
	    
	    Scene scene = new Scene(root, 800, 400);
	    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	    VBox centerContainer = new VBox();
	    centerContainer.setSpacing(10);
	    Text header = new Text("How to play");
	    Text description = new Text("Welcome to Hangman! Your goal is to guess the secret word by suggesting letters. "
	            + "The word is initially displayed as dashes, and each correct guess reveals the corresponding letters. "
	            + "Enter a letter in the text box and press Enter. Incorrect guesses result in the gradual appearance of the hangman figure. "
	            + "Keep guessing until you uncover the entire word to win, or the hangman is completed, resulting in a loss. "
	            + "Remember to guess one letter at a time and pay attention to the feedback. Enjoy playing!");
	    Button button = new Button("CONTINUE");
	    button.getStyleClass().add("next");
	    
	    button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Replace the content of the existing StackPane with the new pane
            	root.getChildren().set(0, new SecondPane());
            }
        });
	    
	    centerContainer.getChildren().addAll(header, description,button);
	    centerContainer.getStyleClass().add("hangman-description");
	    centerContainer.setAlignment(Pos.CENTER);
	    
	    description.setWrappingWidth(500);
	    header.getStyleClass().add("header");
	    description.getStyleClass().add("description");
	    
	    
	    root.getChildren().addAll(centerContainer);
	    StackPane.setAlignment(centerContainer, Pos.CENTER);

	    primaryStage.setScene(scene);
	    primaryStage.show();
	}


    public static void main(String[] args) {
        launch(args);
    }
}
