// fxml done and controller skeleton copied by ARKO on 16 december at 1:50 am
package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class availableBusTableviewController //implements Initializable
{

    private Main main;
    int busID;

    public void setBusID(int busID){
        this.busID = busID;
        System.out.println(busID);
    }

    @FXML
    TableView<tableViewRow> tableView;

    @FXML
    TableColumn<tableViewRow, String> dateColumn;

    @FXML
    TableColumn<tableViewRow, String> departureTimeColumn;

    @FXML
    TableColumn<tableViewRow, String> fromColumn;

    @FXML
    TableColumn<tableViewRow, String> toColumn;

    @FXML
    TableColumn<tableViewRow, String> ACnonAC_column;

    @FXML
    TableColumn<tableViewRow, Integer> availableSeatsColumn;

    @FXML
    TableColumn<tableViewRow, String> farePerSeatColumn;

    SearchTicketInfo ob;


    public void setMain(Main main) {
        this.main = main;
    }

}
