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

public class Controller extends Application {

    public Label result;
    public Pane scene;
    private boolean check = false;
    private String current = "";
    private final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
        primaryStage.setTitle("oo.Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void clear(MouseEvent mouseEvent) {
        current = "";
        result.setText(String.valueOf(calculator.clear()));
    }

    // TODO Add comments

    public void equal() {
        if (check) {
            check = false;
            current = String.valueOf(calculator.get(current));
        }
        result.setText(current);
    }

    public void numberPress(MouseEvent mouseEvent) {
        String buttonName = mouseEvent.getSource().toString();
        buttonName = buttonName.substring(buttonName.indexOf("'") + 1);
        buttonName = buttonName.substring(0, buttonName.indexOf("'"));
        current += buttonName;
        result.setText(current);
    }

    public void actionPress(MouseEvent mouseEvent) {
        String buttonName = mouseEvent.getSource().toString();
        buttonName = buttonName.substring(buttonName.indexOf("'") + 1);
        buttonName = buttonName.substring(0, buttonName.indexOf("'"));
        if (check) {
            if (!Character.isDigit(current.charAt(current.length()-1))) {
                current = current.substring(0, current.length()-1) + buttonName;
            }
            else{
                equal();
            }
        }
            else {
            check = true;
            current += buttonName;
        }
        result.setText(current);
    }
}
