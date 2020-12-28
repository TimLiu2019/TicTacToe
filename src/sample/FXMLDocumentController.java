package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;



public class FXMLDocumentController implements Initializable {

    volatile static boolean gameStart = false;
    // Computer's turn
    volatile static boolean botTurn = false;

    volatile static boolean gameOver = false;

    volatile static boolean tieGame = false;
    /**
     * b1 to b9, nine buttons for the game
     */

    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button b9;

    // start button
    @FXML
    Button startBtn;

    @FXML
    GridPane gameBoard;


    // board text
    static ObservableList<String> board = FXCollections.observableArrayList("", "", "", "", "", "", "", "", "");
    // board styles
    static ObservableList<String> boardStyle = FXCollections.observableArrayList("", "", "", "", "", "", "", "", "");
    // Engine thread
    Runnable task = new Engine();
    Thread t = new Thread(task);

    // handler for b1
    public void buttonClickHandler1(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(0, "X");
            botTurn = true;
        }

    }

    // handler for b2
    public void buttonClickHandler2(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(1, "X");
            botTurn = true;
        }

    }

    // handler for b3
    public void buttonClickHandler3(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(2, "X");
            botTurn = true;
        }

    }

    // handler for b4
    public void buttonClickHandler4(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(3, "X");
            botTurn = true;
        }

    }

    // handler for b5
    public void buttonClickHandler5(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(4, "X");
            botTurn = true;
        }

    }

    // handler for b6
    public void buttonClickHandler6(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(5, "X");
            botTurn = true;
        }

    }

    // handler for b7
    public void buttonClickHandler7(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(6, "X");
            botTurn = true;
        }

    }

    // handler for b8
    public void buttonClickHandler8(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(7, "X");
            botTurn = true;
        }

    }

    // handler for b9
    public void buttonClickHandler9(ActionEvent evt) {
        Button clickedButton = (Button) evt.getTarget();
        String buttonLabel = clickedButton.getText();
        if (buttonLabel.equals("") && gameStart && !gameOver) {
            board.set(8, "X");
            botTurn = true;
        }


    }


    /**
     * Press button to start a game
     *
     * @param evt
     */
    public void gameStartHandler(ActionEvent evt) {
        // start the Engine thread
        t.start();

        gameStart = true;
        startBtn.setDisable(true);
    }

    /**
     * binding buttons to  board
     * binding button-style to boardStyle
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // text binding
        b1.textProperty().bind(Bindings.stringValueAt(board, 0));
        b2.textProperty().bind(Bindings.stringValueAt(board, 1));
        b3.textProperty().bind(Bindings.stringValueAt(board, 2));
        b4.textProperty().bind(Bindings.stringValueAt(board, 3));
        b5.textProperty().bind(Bindings.stringValueAt(board, 4));
        b6.textProperty().bind(Bindings.stringValueAt(board, 5));
        b7.textProperty().bind(Bindings.stringValueAt(board, 6));
        b8.textProperty().bind(Bindings.stringValueAt(board, 7));
        b9.textProperty().bind(Bindings.stringValueAt(board, 8));

        // css binding
        b1.styleProperty().bind(Bindings.stringValueAt(boardStyle, 0));
        b2.styleProperty().bind(Bindings.stringValueAt(boardStyle, 1));
        b3.styleProperty().bind(Bindings.stringValueAt(boardStyle, 2));
        b4.styleProperty().bind(Bindings.stringValueAt(boardStyle, 3));
        b5.styleProperty().bind(Bindings.stringValueAt(boardStyle, 4));
        b6.styleProperty().bind(Bindings.stringValueAt(boardStyle, 5));
        b7.styleProperty().bind(Bindings.stringValueAt(boardStyle, 6));
        b8.styleProperty().bind(Bindings.stringValueAt(boardStyle, 7));
        b9.styleProperty().bind(Bindings.stringValueAt(boardStyle, 8));

        // initialize game states
        gameStart = false;
        botTurn = false;
        gameOver = false;
        tieGame = false;
    }


}



