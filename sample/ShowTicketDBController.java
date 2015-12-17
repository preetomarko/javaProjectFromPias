package sample;

/**
* Created by HP on 12/6/2015.
        */
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowTicketDBController {

    @FXML
    private TableColumn<?, ?> startingColumn;

    @FXML
    private TableColumn<?, ?> destinationColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> coachTypeColumn;

    @FXML
    private ImageView selectImage;

    private Main main;

    public void setMain(Main main) {
        this.main = main;


        Image image = new Image(sample.Main.class.getResourceAsStream("select.jpg"));
        selectImage.setImage(image);
    }
}
