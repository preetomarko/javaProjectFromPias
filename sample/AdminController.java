//package sample;

/**
 * Created by HP on 12/8/2015.
 */
package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.ResultSet;
import java.util.Scanner;

public class AdminController {

    @FXML
    private TextField ID;

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


    /*
    id int primary key,
    staringStation varchar(30),
    destination varchar(30),
    fare varchar(30),
    state varchar(30),
    workingDate date,
    seat int,
    startingTime varchar(30)
    */
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

        idDB = Integer.parseInt(ID.getText());
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
            String query = "select * from BusFinal2";
            ResultSet rs = oc.searchDB(query);
            System.out.println("Product List");
            System.out.println("Id	Name	Price	Description");
            while(rs.next())
            {
                System.out.print(rs.getInt("id"));
                System.out.print("	");
                System.out.print(rs.getString("staringStation"));
                System.out.print("	");
                System.out.print(rs.getString("fare"));
                System.out.print("	");
                System.out.println(rs.getString("destination"));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in listProducts: " + e);
        }




        //MySQLConnect oc=new MySQLConnect("localhost","bus","root","quantumraj");
        try
        {
            String query = String.format("select * from BusFinal2 where id = %d", idDB);
            ResultSet rs = oc.searchDB(query);
            if(rs.next())
            {
                System.out.println("Product with this Id already exisits");
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


        departingTime.setPromptText("Departing Time");
        departingTime.setItems(FXCollections.observableArrayList("6", "8", "10", "12", "14", "16", "18", "20", "22", "0"));
        departingTime.setTooltip(new Tooltip("Departing Time"));

        fare.setPromptText("Fare");
        fare.setItems(FXCollections.observableArrayList("450", "500", "550", "600", "700", "800", "850", "950", "1000", "1250"));
        fare.setTooltip(new Tooltip("Fare"));
    }




    public void setMain(Main main) {
        this.main = main;
    }
}
