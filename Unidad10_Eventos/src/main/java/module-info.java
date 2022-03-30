module resources.unidad10_eventos {
    requires javafx.controls;
    requires javafx.fxml;


    opens resources.unidad10_eventos to javafx.fxml;
    exports resources.unidad10_eventos;
}