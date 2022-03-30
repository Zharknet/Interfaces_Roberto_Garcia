package resources.unidad10_eventosdrag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text fin;

    @FXML
    private ImageView imagen;

    @FXML
    private Text inicio;

    @FXML
    void Detect(MouseEvent event) {
        Dragboard db = inicio.startDragAndDrop(TransferMode.ANY);

        ClipboardContent cb = new ClipboardContent();
        cb.putString(inicio.getText());
        db.setContent(cb);

        event.consume();
    }

    @FXML
    void Done(DragEvent event) {
        inicio.setText("Operacion drag terminada");
    }

    @FXML
    void Drop2(DragEvent event) {
        String str = event.getDragboard().getString();
        fin.setText(str);
    }

    @FXML
    void Dropp(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image (new FileInputStream(files.get(0)));
        imagen.setImage (img);
    }

    @FXML
    void Over(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    void Over2(DragEvent event) {
        if(event.getDragboard().hasString()){
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    void initialize() {

    }

}
