module resources.unidad10_eventochoice {
    requires javafx.controls;
    requires javafx.fxml;


    opens resources.unidad10_eventochoice to javafx.fxml;
    exports resources.unidad10_eventochoice;
}