package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class TicketViewController {
    private Main main;

    @FXML
    private Label NameOfClient;

    @FXML
    private Label NoOfSeats;

    @FXML
    private Label startingStation;

    @FXML
    private Label cost;

    @FXML
    private Label pin;

    @FXML
    private Label destinationStation;

    ///PersonalInfo customer=new PersonalInfo();

    //public TicketViewController(PersonalInfo customer) {this.customer = customer;}


    public void initialize(){
        ///NameOfClient = new Label(customer.getName());
        NameOfClient.setText("Pias");
        destinationStation.setText("Pias");
        startingStation.setText("Pias");
        NoOfSeats.setText("Pias");
        cost.setText("Pias");
        pin.setText("Pias");


    }


    void setMain(Main main){
        this.main = main;
        destinationStation.setText("Pias");
        NameOfClient.setText("Pias");
        destinationStation.setText("Pias");
        startingStation.setText("Pias");
        NoOfSeats.setText("Pias");
        cost.setText("Pias");
        pin.setText("Pias");
    }

}
