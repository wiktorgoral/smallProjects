package org.megaja;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

// Controller from MVC
public class Controller extends Application {

    // Handle for updating text displayed
    public Label result;
    // Handle for whole scene
    public Pane scene;
    // Flag for checking if operation sign was used
    private boolean check = false;
    // Variable string to hold characters pressed
    private String current = "";
    // Model from MVC
    private final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Function to clear display
    public void clear(MouseEvent mouseEvent) {
        current = "";
        result.setText(String.valueOf(calculator.clear()));
    }

    // Function to calculate current result
    public void equal() {
        // check if there is operation sign, otherwise just show current
        if (check) {
            check = false;
            current = String.valueOf(calculator.get(current));
        }
        result.setText(current);
    }

    // Register number press
    public void numberPress(MouseEvent mouseEvent) {
        // get number pressed from button name
        String buttonName = mouseEvent.getSource().toString();
        buttonName = buttonName.substring(buttonName.indexOf("'") + 1);
        buttonName = buttonName.substring(0, buttonName.indexOf("'"));
        // add number to current
        current += buttonName;
        result.setText(current);
    }

    // Register operation press
    public void actionPress(MouseEvent mouseEvent) {
        // get operation pressed from button name
        String buttonName = mouseEvent.getSource().toString();
        buttonName = buttonName.substring(buttonName.indexOf("'") + 1);
        buttonName = buttonName.substring(0, buttonName.indexOf("'"));
        // check if there was already operation pressed
        if (check) {
            // if last character is operation change it
            if (!Character.isDigit(current.charAt(current.length()-1))) {
                current = current.substring(0, current.length()-1) + buttonName;
            }
            // if it is digit calculate result
            else{
                equal();
                check = true;
                current+=buttonName;
            }
        }
        // if there is no opration character just add it
        else {
            check = true;
            current += buttonName;
        }
        result.setText(current);
    }
}
