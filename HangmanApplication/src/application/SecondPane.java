package application;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import java.io.*;

public class SecondPane extends StackPane {

    public SecondPane() {
        getStyleClass().add("second-pane");
        getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        VBox container = new VBox(10);
        Label inputLabel = new Label("Choose a nickname:");

        HBox secondContainer = new HBox(10);
        TextField nickname = new TextField();
        Button saveButton = new Button("SAVE");

        secondContainer.getChildren().addAll(nickname, saveButton);
        
        nickname.getStyleClass().add("inputBox");
        saveButton.getStyleClass().add("save");
        inputLabel.getStyleClass().add("inputLabel");

        nickname.setMaxWidth(300);
        secondContainer.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);

        container.getChildren().addAll(inputLabel, secondContainer);

        getChildren().addAll(container);

        saveButton.setOnAction(event -> {
            String userInput = nickname.getText();

            try (FileWriter writer = new FileWriter("users.txt")) {
                writer.write(userInput);
                System.out.println("Nickname was successfully saved!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            GamePane gamePane = new GamePane(userInput);
            
            getChildren().set(0, gamePane);
        });
    }
}
