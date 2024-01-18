package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Map;

public class GamePane extends StackPane {
    private StringBuilder currentGuess;
    private String hint;
    private String word;
    private int chances = 6;
    protected WordManager wordManager;
    private Label playerLabel;

    public void wordFinder() {
        wordManager = new WordManager();
        Map.Entry<String, String> randomEntry = wordManager.getRandomWordAndHint();
        word = randomEntry.getKey().toLowerCase();
        currentGuess = new StringBuilder("-".repeat(word.length()));
        hint = randomEntry.getValue();
    }

    public GamePane(String playerName) {
        getStyleClass().add("game-pane");
        getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        wordFinder(); 

        
        HBox playerData = new HBox(520);
        VBox actualGame = new VBox(10);
        HBox buttons = new HBox(20);
        playerLabel = new Label("Player: " + playerName);
        Label playerChances = new Label("Chances: " + chances);
        Label hints = new Label("HINT: " + hint);
        Label currentGuessLabel = new Label("" + currentGuess);
        TextField input = new TextField();
        Button guessButton = new Button("Guess");
        Button tryAgain = new Button("Play Again");
        buttons.getChildren().addAll(guessButton,tryAgain);

        guessButton.setOnAction(event -> {
            String guess = input.getText().toLowerCase();
            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                processGuess(guess.charAt(0));
                updateUI(currentGuessLabel, playerChances , hints);

                // Checks win or loss
                if (currentGuess.toString().equals(word)) {
                    showGameResult("Congratulations! You've won!");
                } else if (chances == 0) {
                    showGameResult("Sorry, you've run out of attempts. The word was: " + word);
                }
            } else {
                showAlert("Invalid guess. Please enter a single letter.");
            }
            input.clear();
        });
        
        tryAgain.setOnAction(event -> {
            initializeGame();
            updateUI(currentGuessLabel, playerChances,hints);
        });

        input.getStyleClass().add("input");
        guessButton.getStyleClass().add("guess-button");
        tryAgain.getStyleClass().add("try-again-button");
        hints.setStyle("-fx-font-size:18;-fx-text-fill:white;");
        currentGuessLabel.setStyle("-fx-font-size:20;-fx-text-fill:white;");
        playerLabel.setStyle("-fx-font-size:14;-fx-text-fill:white;-fx-font-weight:bold");
        playerChances.setStyle("-fx-font-size:14;-fx-text-fill:white;-fx-font-weight:bold;");
        
        input.setMaxWidth(150);
        playerData.setPadding(new Insets(20));
        actualGame.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);
        
        actualGame.getChildren().addAll(hints, currentGuessLabel, input, buttons);
        playerData.getChildren().addAll(playerLabel, playerChances);
       
        getChildren().addAll(playerData, actualGame);
    }

    private void processGuess(char guess) {
        
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                currentGuess.setCharAt(i, guess);
                found = true;
            }
        }

        if (!found) {
            chances--;
        }
    }

    private void updateUI(Label wordLabel, Label attemptsLabel , Label hintLabel) {
        
        wordLabel.setText("" + currentGuess);
        attemptsLabel.setText("Chances: " + chances);
        hintLabel.setText("HINT: " + hint);
    }

    private void showGameResult(String message) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        initializeGame();
    }

    private void showAlert(String message) {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void initializeGame() {
        wordFinder();
        chances = 6;
        currentGuess = new StringBuilder("-".repeat(word.length()));
        
        playerLabel.setText("Hangman Game");
    }
}
