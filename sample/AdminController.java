//package sample;

/**
 * Created by HP on 12/8/2015.
 */
package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.time.LocalDate;

public class AdminController {


    @FXML
    private Label ID;

    @FXML
    private Button Cancel;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> state;

    @FXML
    private ComboBox<String> fare;

    @FXML
    private ComboBox<String> startingStation;

    @FXML
    private ComboBox<String> destination;

    @FXML
    private ComboBox<Integer> seatNumber;

    @FXML
    private ComboBox<String> departingTime;

    private Main main;
    private int idDB;
    private String staringStationDB;
    private String destinationDB;
    private String fareDB;
    private String stateDB;
    private String dateDB;
    private int seatDB;
    private String timeDB;

    @FXML
    void SubmitAction(ActionEvent event) {

        staringStationDB = startingStation.getValue();
        destinationDB = destination.getValue();
        fareDB = fare.getValue();
        stateDB = state.getValue();
        dateDB = String.valueOf(date.getValue());
        seatDB = seatNumber.getValue();
        timeDB = departingTime.getValue();


        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = String.format("select * from BusFinal2 where id = %d", idDB);
            ResultSet rs = oc.searchDB(query);
            if(rs.next())
            {
                System.out.println("Bus with this Id already exisits");
            }
            else
            {
                String insertQuery = String.format("insert into BusFinal2(id, staringStation, destination, fare, state, seat, startingTime) values " +
                                "(%d, '%s', '%s', '%s', '%s', %d, '%s')",
                                idDB, staringStationDB, destinationDB, fareDB, stateDB, seatDB, timeDB);
                oc.updateDB(insertQuery);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in addProduct: " + e);
        }
        finally
        {
            oc.close();
        }
    }


    public  void initialize() {
        startingStation.setPromptText("Select Station");
        startingStation.setItems(FXCollections.observableArrayList("Dhaka", "Rajsahi", "Chittagong", "Sylhet", "Rangpur", "Khulna", "Barisal"));
        startingStation.setTooltip(new Tooltip("Starting Station"));

        destination.setPromptText("Select Station");
        destination.setItems(FXCollections.observableArrayList("Dhaka", "Rajsahi", "Chittagong", "Sylhet", "Rangpur", "Khulna", "Barisal"));
        destination.setTooltip(new Tooltip("Destination"));

        state.setPromptText("AC/Non-AC");
        state.setItems(FXCollections.observableArrayList("AC", "Non-AC"));
        state.setTooltip(new Tooltip("Coach Type"));

        date.setPromptText("Select Date");
        //datePicker.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        date.setTooltip(new Tooltip("Enter your desired Date"));

        seatNumber.setPromptText("Seat Number");
        seatNumber.setItems(FXCollections.observableArrayList(40, 32));
        seatNumber.setTooltip(new Tooltip("Seat Number"));


        departingTime.setPromptText("24 hour format");
        departingTime.setItems(FXCollections.observableArrayList("6", "8", "10", "12", "14", "16", "18", "20", "22", "0"));
        departingTime.setTooltip(new Tooltip("Departing Time"));

        //fare.setPromptText("Fare");
        fare.setItems(FXCollections.observableArrayList("450", "500", "550", "600", "700", "800", "850", "950", "1000", "1250"));
        fare.setTooltip(new Tooltip("Fare"));

        SearchMaxDBId searchMaxDBId = new SearchMaxDBId();
        idDB = searchMaxDBId.getMaxBusID();
        idDB++;
        ID.setText(""+idDB);

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
        date.setDayCellFactory(dayCellFactory);
        date.setEditable(false);
    }


    public void setMain(Main main) {
        this.main = main;
    }
}
