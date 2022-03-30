module resources.unidad10_eventosdrag {
    requires javafx.controls;
    requires javafx.fxml;


    opens resources.unidad10_eventosdrag to javafx.fxml;
    exports resources.unidad10_eventosdrag;
}