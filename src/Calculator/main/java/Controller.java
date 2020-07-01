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
    private Calculator calculator = new Calculator();

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

    public void clear(MouseEvent mouseEvent) {
        current = "";
        result.setText(String.valueOf(calculator.clear()));
    }

    public void one(MouseEvent mouseEvent) {
        current += "1";
        result.setText(current);
    }

    public void two(MouseEvent mouseEvent) {
        current += "2";
        result.setText(current);
    }

    public void three(MouseEvent mouseEvent) {
        current += "3";
        result.setText(current);
    }

    public void four(MouseEvent mouseEvent) {
        current += "4";
        result.setText(current);
    }

    public void five(MouseEvent mouseEvent) {
        current += "5";
        result.setText(current);
    }

    public void six(MouseEvent mouseEvent) {
        current += "6";
        result.setText(current);
    }

    public void seven(MouseEvent mouseEvent) {
        current += "7";
        result.setText(current);
    }

    public void eight(MouseEvent mouseEvent) {
        current += "8";
        result.setText(current);
    }

    public void nine(MouseEvent mouseEvent) {
        current += "9";
        result.setText(current);
    }
    // TODO add case for changing action
    public void divide(MouseEvent mouseEvent) {
        if (check) {
            check = false;
            current =String.valueOf(calculator.get(current));
        }
        else {
            check = true;
            current += "/";
        }
        result.setText(current);
    }

    public void multiply(MouseEvent mouseEvent) {
        if (check) {
            check = false;
            current =String.valueOf(calculator.get(current));
        }
        else {
            check = true;
            current += "*";
        }
        result.setText(current);
    }

    public void minus(MouseEvent mouseEvent) {
        if (check) {
            check = false;
            current =String.valueOf(calculator.get(current));
        }
        else {
            check = true;
            current += "-";
        }
        result.setText(current);
    }

    public void add(MouseEvent mouseEvent) {
        if (check) {
            check = false;
            current =String.valueOf(calculator.get(current));
        }
        else {
            check = true;
            current += "+";
        }
        result.setText(current);
    }

    public void equal(MouseEvent mouseEvent) {
        if (check) {
            check = false;
            current = String.valueOf(calculator.get(current));
        }
        result.setText(current);
    }
}
