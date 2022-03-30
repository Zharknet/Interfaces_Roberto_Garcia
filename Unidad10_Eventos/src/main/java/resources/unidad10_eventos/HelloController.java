package resources.unidad10_eventos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button boton;

    @FXML
    private TextField campotexto;

    @FXML
    void eventoDialog(ActionEvent event) {
        TextInputDialog textDialog = new TextInputDialog();
        textDialog.setTitle("Ejemplo de dialogo");
        textDialog.setHeaderText("Dialogo para introducir texto");

        textDialog.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, e->{
            if(e.getCode().equals(KeyCode.ENTER) || e.getCode().equals(KeyCode.ESCAPE)) {
                //System.out.println("Deshabilitado");
                e.consume();
            }
        });

        textDialog.getDialogPane().addEventFilter(KeyEvent.KEY_TYPED, e->{
            if(e.getCharacter().equals(e.getCharacter().toLowerCase())){
                //System.out.println("No se puede minusculas");
                e.consume();
            }
        });

        textDialog.showAndWait().ifPresent(response ->{
            campotexto.setText(response);
        });
    }

    @FXML
    void initialize() {
        assert boton != null : "fx:id=\"boton\" was not injected: check your FXML file 'validar.fxml'.";
        assert campotexto != null : "fx:id=\"campotexto\" was not injected: check your FXML file 'validar.fxml'.";

    }

}
