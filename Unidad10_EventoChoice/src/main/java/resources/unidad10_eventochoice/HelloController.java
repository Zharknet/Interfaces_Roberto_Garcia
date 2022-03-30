package resources.unidad10_eventochoice;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button boton;

    @FXML
    private ListView<String> lista;

    @FXML
    void click(MouseEvent event) {

        if(!lista.getSelectionModel().getSelectedItems().isEmpty()){
            boton.setDisable(false);
        }else{
            boton.setDisable(true);

        }
    }

    @FXML
    void salir(MouseEvent event) {

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);

        infoAlert.setTitle("Ejemplo de diálogo");
        infoAlert.setHeaderText("Alert informativo");
        infoAlert.setContentText("Por favor seleccione una opcion");

        if(lista.getSelectionModel().getSelectedItems().isEmpty()){
                infoAlert.showAndWait();
        }
    }

    @FXML
    void click2(MouseEvent event) {
        boton.setOnAction(e -> {
            List<String> dialogData = lista.getSelectionModel().getSelectedItems();
// Se crea el ChoiceDialog con el primer elemento seleccionado
            ChoiceDialog<String> choiceDialog = new
                    ChoiceDialog<String>(dialogData.get(0), dialogData);
            choiceDialog.setTitle("Ejemplo de diálogo");
            choiceDialog.setHeaderText("Seleccione un valor...");
// Se incluye la respuesta del usuario en un campo de tipo
            choiceDialog.showAndWait().ifPresent(response -> {
                lista.getSelectionModel().clearSelection();
                lista.getSelectionModel().select(response);
            });;
        });
    }

    @FXML
    void initialize() {
        lista.getItems().addAll("Opcion1", "Opcion2", "Opcion3","Opcion4","Opcion5","Opcion6","Opcion7",
                "Opcion8","Opcion9","Opcion10");
        lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

}
