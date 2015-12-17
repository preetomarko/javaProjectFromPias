package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main extends Application {

    Stage stage;
    PersonalInfo customer;
    PersonalController personalController;
    CancellController cancellController;
    //MySQLConnect mySQLConnect;
    SearchTicketController searchTicketController;
    SeatController seatController;
    TicketViewController ticketViewController;
    availableBusTableviewController avBusControl;
    static SearchTicketInfo ob;
    //static ArrayList<tableViewRow> busList=new ArrayList<>();
    static ObservableList<tableViewRow> busList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        searchTicket();
        //personalForm();
        //AdminEdit();
    }

    public void personalForm() throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonalForm.fxml"));
        Parent root = loader.load();

        //Personal Controller
        personalController = loader.getController();
        personalController.setMain(this);

        //Set The Primary stage
        stage.setTitle("Personal Form");
        stage.setScene(new Scene(root, 600, 520));
        stage.show();
    }

    public void showTicket() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TicketViewController.fxml"));
        Parent root = loader.load();

        //PersonalController controller = loader.getController();
        ticketViewController = loader.getController();//= new TicketViewController(customer);
        ticketViewController.setMain(this);

        //set the primary Stage
        stage.setTitle("Search Ticket");
        stage.setScene(new Scene(root, 500, 300));
        stage.show();

    }

    public void searchTicket() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchTicket.fxml"));
        Parent root = loader.load();


        searchTicketController = loader.getController();
        searchTicketController.setMain(this);
        //ob = searchTicketController.ob;


        //set the primary Stage

        stage.setTitle("Search Ticket");
        stage.setScene(new Scene(root, 600, 420));
        stage.show();

    }


    public void showDB() throws IOException { // NOW UNNECESSARY
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showTicketDB.fxml"));
        Parent root = loader.load();


        ShowTicketDBController controller = loader.getController();
        controller.setMain(this);

        //set the primary Stage
        stage.setTitle("Select");
        stage.setScene(new Scene(root, 600, 420));
        stage.show();
    }

    public void AdminEdit() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Admin.fxml"));
        Parent root = loader.load();


        AdminController controller = loader.getController();
        controller.setMain(this);

        //set the primary Stage
        stage.setTitle("Welcome Admin !!!");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();
    }
    //public void

    public void availableBusView()throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clientAvailableBusTable.fxml"));
        Parent root = loader.load();
        //availableBusTableviewController
        avBusControl=loader.getController();
        if(avBusControl==null)System.out.println("avBusControl is null");
        avBusControl.setMain(this);
        avBusControl.ob=ob;

        avBusControl.dateColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow,String>("date"));
        avBusControl.departureTimeColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow,String>("timeOfDeparture"));
        avBusControl.fromColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, String>("from"));
        avBusControl.toColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, String>("to"));
        avBusControl.ACnonAC_column.setCellValueFactory(new PropertyValueFactory<tableViewRow, String>("acNonAC"));
        avBusControl.availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, String>("availableSeats"));
        avBusControl.farePerSeatColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, String>("fare"));

        //avBusControl.tableView.setEditable(false);

        avBusControl.dateColumn.setStyle("-fx-alignment: CENTER;");
        avBusControl.departureTimeColumn.setStyle("-fx-alignment: CENTER;");
        avBusControl.fromColumn.setStyle("-fx-alignment: CENTER;");
        avBusControl.toColumn.setStyle("-fx-alignment: CENTER;");
        avBusControl.availableSeatsColumn.setStyle("-fx-alignment: CENTER;");
        avBusControl.ACnonAC_column.setStyle("-fx-alignment: CENTER;");
        avBusControl.farePerSeatColumn.setStyle("-fx-alignment: CENTER;");

        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = "select * from BusFinal2 where staringStation = '" + ob.getStarting() +"' and destination = '"+ob.getDestination()+"'"+" and workingDate = '"+ob.getDate()+"'"+ " and state = '"+ ob.getCoachType()+"'";
            //String query = "select * from bus where counter_1 = "+ ob.getStarting()+" and " + ob.getDestination();
            ResultSet rs = oc.searchDB(query);
            System.out.println("Product List");
            System.out.println("From   "+"      To       "+" Fare  "+"Coach Type "+"    Date  "+ "         Available Seat"+ "     startingTime");
            while(rs.next()) {
                //System.out.print(rs.getInt("id"));
                //System.out.print("	  ");
                tableViewRow t = new tableViewRow();
                t.setFrom(rs.getString("staringStation"));
                t.setTo(rs.getString("destination"));
                t.setFare(rs.getString("fare"));
                t.setAcNonAC(rs.getString("state"));
                t.setDate(rs.getDate("workingDate").toString());
                CountSeatDB countSeatDB = new CountSeatDB();
                countSeatDB.init(rs.getInt("id"));
                t.setAvailableSeats(countSeatDB.getCounter());
                t.setTimeOfDeparture(rs.getString("startingTime"));
                busList.add(t);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in listProducts: " + e);
        }
        finally
        {
            oc.close();

        }
        avBusControl.tableView.setItems(busList);


        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
