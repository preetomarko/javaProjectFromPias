package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.cell.TextFieldTableCell;
import jdk.nashorn.internal.runtime.ECMAException;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

class newClientThread implements Runnable{
    Thread t;
    newClientThread()
    {
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run()
    {

    }
}

public class Main extends Application {

    Stage stage;
    PersonalInfo customer;
    PersonalController personalController;
    CancellController cancellController;
    homepageController hc;
    //MySQLConnect mySQLConnect;
    SearchTicketController searchTicketController;
    SeatController seatController;
    TicketViewController ticketViewController;
    availableBusTableviewController avBusControl;
    static SearchTicketInfo ob;
    //static ArrayList<tableViewRow> busList=new ArrayList<>();
    static ObservableList<tableViewRow> busList = FXCollections.observableArrayList();
    static int busID=1000;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        showHomepage();
        //searchTicket();
        //personalForm();
        //AdminEdit();
        //showSeat();
    }

    public void showHomepage() throws Exception
    {
        FXMLLoader loader=new FXMLLoader();
        if(loader==null)System.out.println("loader is null inside main");
        loader.setLocation(getClass().getResource("homepage.fxml"));


        Parent root = loader.load();
        hc=loader.getController();
        if(hc==null)System.out.println("hc is null inside main");
        hc.init();
        hc.setMain(this);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

//        hc.menuTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
//
//            @Override
//            public void changed(ObservableValue<? extends Tab> arg0, Tab hc.homeMenu, Tab arg2) {
//
//            }
//        });

        hc.buyTktMenu.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (hc.buyTktMenu.isSelected()) {
                    try{
                        searchTicket();
                    }catch(Exception e){e.printStackTrace();}
                }
            }
        });

        hc.cancelTktMenu.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (hc.cancelTktMenu.isSelected()) {

                }
            }
        });

        hc.availableRouteMenu.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (hc.availableRouteMenu.isSelected()) {

                }
            }
        });

        hc.FAQmenu.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (hc.FAQmenu.isSelected()) {

                }
            }
        });

        hc.creditsMenu.setOnSelectionChanged(new EventHandler<Event>() {
            @Override
            public void handle(Event t) {
                if (hc.creditsMenu.isSelected()) {

                }
            }
        });

//        hc.buyTktMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("File menu clicked");
//
//                Stage myDialog = new Stage();
//                myDialog.initModality(Modality.WINDOW_MODAL);
//
//                Scene myDialogScene = new Scene(VBoxBuilder.create()
//                        .children(new Text("Hello! it's My Dialog."))
//                        .alignment(Pos.CENTER)
//                        .padding(new Insets(10))
//                        .build());
//
//                myDialog.setScene(myDialogScene);
//                myDialog.show();
//            }
//        });



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

    public void showSeat() throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("seatview2.fxml"));
        Parent root = loader.load();


        //Personal Controller
        SeatViewController seatViewController = loader.getController();
        seatViewController.setMain(this);
        seatViewController.setID(busID);
        seatViewController.init();

        //Set The Primary stage
        Scene myScene = new Scene(root, 240, 520);
        myScene.getStylesheets().add(getClass().getResource("MyCSS.css").toExternalForm());
        stage.setTitle("Seat View");
        stage.setScene(myScene);
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
        avBusControl.availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, Integer>("availableSeats"));
        avBusControl.farePerSeatColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, String>("fare"));
        //avBusControl.farePerSeatColumn.setCellValueFactory(new PropertyValueFactory<tableViewRow, Integer>("fare"));

        avBusControl.tableView.setEditable(false);

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

            ResultSet rs = oc.searchDB(query);
            System.out.println("Product List");
            System.out.println("From   "+"      To       "+" Fare  "+"Coach Type "+"    Date  "+ "         Available Seat"+ "     startingTime");
            while(rs.next()) {
                //System.out.println("entered in the loop");
                String from=rs.getString("staringStation");
                String to=rs.getString("destination");
                String fare=rs.getString("fare");
                String state=rs.getString("state");
                String DATE=rs.getDate("workingDate").toString();

                CountSeatDB countSeatDB = new CountSeatDB();
                countSeatDB.init(rs.getInt("id"));
                int seatCount=countSeatDB.getCounter();;

                String starting=rs.getString("startingTime");

                tableViewRow t=new tableViewRow(DATE,starting,from,to,state,seatCount,fare);
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

        //System.out.println("Bus LIST:");
        //System.out.println(busList);
        avBusControl.tableView.setItems(busList);


        avBusControl.tableView.setRowFactory(tv -> {
            TableRow<tableViewRow> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty()) ) {
                    tableViewRow rowData = row.getItem();
                    LocalDate date = LocalDate.parse(row.getItem().getDate());
                    String from = row.getItem().getFrom();
                    String to = row.getItem().getTo();
                    String time = row.getItem().getTimeOfDeparture();
                    String x = row.getText();

                    GetID getID = new GetID();
                    getID.init(from, to, time, date);
                    int id = getID.getCounter();
                    System.out.println(id);
                    busID = id;

                    if (busID != 0) {
                        avBusControl.setBusID(busID);
                    }
                    //System.out.println(rowData);
                }
            });
            return row;
        });

        stage.setScene(new Scene(root));
        stage.show();

        if(busID !=0){
            try {
                showSeat();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}
