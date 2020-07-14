module org.wik {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.megaja to javafx.fxml;
    exports org.megaja;
}