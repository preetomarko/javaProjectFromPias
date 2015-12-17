package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

import java.sql.ResultSet;

import javafx.scene.layout.GridPane;

public class SeatViewController {

    public String[] customerPhone;
    public String[] tempSelection;

    @FXML
    private GridPane seatViewGridPane;

    @FXML
    private Button seatSubmitButton;

    @FXML
    private ToggleButton s1;

    @FXML
    private ToggleButton s2;

    @FXML
    private ToggleButton s3;

    @FXML
    private ToggleButton s4;

    @FXML
    private ToggleButton s5;

    @FXML
    private ToggleButton s6;

    @FXML
    private ToggleButton s7;

    @FXML
    private ToggleButton s8;

    @FXML
    private ToggleButton s9;

    @FXML
    private ToggleButton s10;

    @FXML
    private ToggleButton s11;

    @FXML
    private ToggleButton s12;

    @FXML
    private ToggleButton s13;

    @FXML
    private ToggleButton s14;

    @FXML
    private ToggleButton s15;

    @FXML
    private ToggleButton s16;

    @FXML
    private ToggleButton s17;

    @FXML
    private ToggleButton s18;

    @FXML
    private ToggleButton s19;

    @FXML
    private ToggleButton s20;

    @FXML
    private ToggleButton s21;

    @FXML
    private ToggleButton s22;

    @FXML
    private ToggleButton s23;

    @FXML
    private ToggleButton s24;

    @FXML
    private ToggleButton s25;

    @FXML
    private ToggleButton s26;

    @FXML
    private ToggleButton s27;

    @FXML
    private ToggleButton s28;

    @FXML
    private ToggleButton s29;

    @FXML
    private ToggleButton s30;

    @FXML
    private ToggleButton s31;

    @FXML
    private ToggleButton s32;

    @FXML
    private ToggleButton s33;

    @FXML
    private ToggleButton s34;

    @FXML
    private ToggleButton s35;

    @FXML
    private ToggleButton s36;

    @FXML
    private ToggleButton s37;

    @FXML
    private ToggleButton s38;

    @FXML
    private ToggleButton s39;

    @FXML
    private ToggleButton s40;

    /*
    public void initialize(ShowAvailableBus ob){

        customerPhone = new String[41];
        tempSelection = new String[41];

        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = "select * from BusSeatReservation where id = '" +ob.getID +"'";
            //String query = "select * from bus where counter_1 = "+ ob.getStarting()+" and " + ob.getDestination();
            ResultSet rs = oc.searchDB(query);
            System.out.println("Bus List");
            System.out.println("Id\t"+"Starting Counter  "+" Fare  "+"  Coach Type "+"  Destination  "+"  Date  ");
            while(rs.next())
            {
                System.out.print(rs.getInt("id"));
                System.out.print("	  ");
                customerPhone[0] = rs.getString("id");

                System.out.print(rs.getString("s1"));
                System.out.print("	  ");
                customerPhone[1] = rs.getString("s1");

                System.out.print(rs.getString("s2"));
                System.out.print("	  ");
                System.out.print(rs.getString("s3"));
                System.out.print("	  ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s1"));
                System.out.print("	  ");
                System.out.print(rs.getString("s2"));
                System.out.print("	  ");
                System.out.print(rs.getString("s3"));
                System.out.print("	  ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s1"));
                System.out.print("	  ");
                System.out.print(rs.getString("s2"));
                System.out.print("	  ");
                System.out.print(rs.getString("s3"));
                System.out.print("	  ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s3"));
                System.out.print("	  ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");
                System.out.print(rs.getString("s4"));
                System.out.print("    ");


                System.out.println(rs.getDate("workingDate"));
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
    }
    */

    @FXML
    void s10Action(ActionEvent event) {

    }

    @FXML
    void s11Action(ActionEvent event) {

    }

    @FXML
    void s12Action(ActionEvent event) {

    }

    @FXML
    void s13Action(ActionEvent event) {

    }

    @FXML
    void s14Action(ActionEvent event) {

    }

    @FXML
    void s15Action(ActionEvent event) {

    }

    @FXML
    void s16Action(ActionEvent event) {

    }

    @FXML
    void s17Action(ActionEvent event) {

    }

    @FXML
    void s18Action(ActionEvent event) {

    }

    @FXML
    void s19Action(ActionEvent event) {

    }

    @FXML
    void s1Action(ActionEvent event) {

    }

    @FXML
    void s20Action(ActionEvent event) {

    }

    @FXML
    void s21Action(ActionEvent event) {

    }

    @FXML
    void s22Action(ActionEvent event) {

    }

    @FXML
    void s23Action(ActionEvent event) {

    }

    @FXML
    void s24Action(ActionEvent event) {

    }

    @FXML
    void s25Action(ActionEvent event) {

    }

    @FXML
    void s26Action(ActionEvent event) {

    }

    @FXML
    void s27Action(ActionEvent event) {

    }

    @FXML
    void s28Action(ActionEvent event) {

    }

    @FXML
    void s29Action(ActionEvent event) {

    }

    @FXML
    void s2Action(ActionEvent event) {

    }

    @FXML
    void s30Action(ActionEvent event) {

    }

    @FXML
    void s31Action(ActionEvent event) {

    }

    @FXML
    void s32Action(ActionEvent event) {

    }

    @FXML
    void s33Action(ActionEvent event) {

    }

    @FXML
    void s34Action(ActionEvent event) {

    }

    @FXML
    void s35Action(ActionEvent event) {

    }

    @FXML
    void s36Action(ActionEvent event) {

    }

    @FXML
    void s37Action(ActionEvent event) {

    }

    @FXML
    void s38Action(ActionEvent event) {

    }

    @FXML
    void s39Action(ActionEvent event) {

    }

    @FXML
    void s3Action(ActionEvent event) {

    }

    @FXML
    void s40Action(ActionEvent event) {

    }

    @FXML
    void s4Action(ActionEvent event) {

    }

    @FXML
    void s5Action(ActionEvent event) {

    }

    @FXML
    void s6Action(ActionEvent event) {

    }

    @FXML
    void s7Action(ActionEvent event) {

    }

    @FXML
    void s8Action(ActionEvent event) {

    }

    @FXML
    void s9Action(ActionEvent event) {

    }

    @FXML
    void seatSubmit(ActionEvent event) {
        for(int i=1; i<=40; i++){
            customerPhone[i] = tempSelection[i];
        }
    }




}

