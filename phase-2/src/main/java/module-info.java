module com.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.phase2 to javafx.fxml;
    exports com.example.phase2;
    /*exports com.example.phase2.Registering;*/
    opens com.example.phase2.Registering to javafx.fxml;
    exports Control;
    opens Control to javafx.fxml;
}