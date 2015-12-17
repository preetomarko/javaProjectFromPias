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
    TableColumn<tableViewRow, String> availableSeatsColumn;

    @FXML
    TableColumn<tableViewRow, String> farePerSeatColumn;

    SearchTicketInfo ob;

    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) //called in the beginning of loading of this scene
    {
        init(ob);
    }

    public void init(SearchTicketInfo ob){
        this.ob = ob;

        System.out.println(ob.getStarting());
        System.out.println(ob.getDestination());
        System.out.println(ob.getDate());
        System.out.println(ob.getCoachType());

        /*

        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = "select * from BusFinal2 where staringStation = '" + ob.getStarting() +"' and destination = '"+ob.getDestination()+"'"+" and workingDate = '"+ob.getDate()+"'"+ " and state = '"+ ob.getCoachType()+"'";
            //String query = "select * from bus where counter_1 = "+ ob.getStarting()+" and " + ob.getDestination();
            ResultSet rs = oc.searchDB(query);
            System.out.println("Product List");
            System.out.println("From   "+"      To       "+" Fare  "+"Coach Type "+"    Date  "+ "         Available Seat"+ "     startingTime");
            while(rs.next())
            {
                //System.out.print(rs.getInt("id"));
                //System.out.print("	  ");
                tableViewRow t=new tableViewRow();
                t.setFrom(rs.getString("staringStation"));
                t.setTo(rs.getString("destination"));
                t.setFare(rs.getString("fare"));
                t.setAcNonAC(rs.getString("state"));
                t.setDate(rs.getDate("workingDate").toString());
                CountSeatDB countSeatDB = new CountSeatDB();
                countSeatDB.init(rs.getInt("id"));
                t.setAvailableSeats(countSeatDB.getCounter());
                t.setTimeOfDeparture(rs.getString("startingTime"));
                main.busList.add(t);


                /*
                System.out.print(rs.getString("staringStation"));
                System.out.print("	  ");
                System.out.print(rs.getString("destination"));
                System.out.print("     ");
                System.out.print(rs.getString("fare"));
                System.out.print("	  ");
                System.out.print(rs.getString("state"));
                System.out.print("	    ");
                System.out.print(rs.getDate("workingDate"));
                System.out.print("	    ");

                CountSeatDB countSeatDB = new CountSeatDB();
                countSeatDB.init(rs.getInt("id"));

                System.out.print(countSeatDB.getCounter());
                System.out.print("	           ");
                System.out.print(rs.getString("startingTime"));
                System.out.println("	  ");
                */

           // }

            //SearchMaxDBId searchMaxDBId = new SearchMaxDBId();
            //System.out.println(searchMaxDBId.getMaxBusID());
            //System.out.println(searchMaxDBId.getMaxPersonID());


    /*
        }
        catch(Exception e)
        {
            System.out.println("Exception in listProducts: " + e);
        }
        finally
        {
            oc.close();
            tableView.setItems(main.busList);
        }
         */
    //}

    public void setMain(Main main) {
        this.main = main;
    }

}
