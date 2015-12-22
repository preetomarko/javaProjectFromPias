

/**
 * Created by HP on 11/30/2015.
 */
package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.time.LocalDate;

public class SearchTicketController {

    @FXML
    private ComboBox<String> startingStation;

    @FXML
    private ComboBox<String> coachType;


    @FXML
    private DatePicker datePicker;


    @FXML
    private ComboBox<String> destinationStation;

    @FXML
    private Button searchTicket;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView image2;


    private Main main;

    SearchTicketInfo ob;

    public  void initialize() {
        startingStation.setPromptText("Select Station");
        startingStation.setItems(FXCollections.observableArrayList("Dhaka", "Rajshahi", "Chittagong", "Sylhet", "Rangpur", "Khulna", "Barisal"));
        startingStation.setTooltip(new Tooltip("Starting Station"));

        destinationStation.setPromptText("Select Station");
        destinationStation.setItems(FXCollections.observableArrayList("Dhaka", "Rajshahi", "Chittagong", "Sylhet", "Rangpur", "Khulna", "Barisal"));
        destinationStation.setTooltip(new Tooltip("Destination"));

        coachType.setPromptText("AC/Non-AC");
        coachType.setItems(FXCollections.observableArrayList("AC", "Non-AC"));
        coachType.setTooltip(new Tooltip("Coach Type"));

        datePicker.setPromptText("Select Date");
        //datePicker.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        datePicker.setTooltip(new Tooltip("Enter your desired Date"));

        Image image3 = new Image(Main.class.getResourceAsStream("searchBus.jpg"));
        searchTicket.setGraphic(new ImageView(image3));

        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(LocalDate.now())) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        datePicker.setDayCellFactory(dayCellFactory);
        datePicker.setEditable(false);
    }

    @FXML
    void search(ActionEvent event) {
        ob = new SearchTicketInfo(startingStation.getValue(), destinationStation.getValue(), datePicker.getValue(), coachType.getValue());
        Main.ob=ob;

        System.out.println("Search");
        System.out.println(startingStation.getValue());
        System.out.println(destinationStation.getValue());
        System.out.println(datePicker.getValue());
        System.out.println(coachType.getValue());
        /*
        ConsoleDB consoleDB = new ConsoleDB();
        consoleDB.init(ob);
        */

        try {
            //main.showTicket();
            main.availableBusView();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void setMain(Main main) {
        this.main = main;

        Image image = new Image(Main.class.getResourceAsStream("busPic.png"));
        imageView.setImage(image);

        Image img2 = new Image(Main.class.getResourceAsStream("busPic2.png"));
        image2.setImage(img2);
    }
}
