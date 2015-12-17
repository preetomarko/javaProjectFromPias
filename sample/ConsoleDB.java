package sample;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.ResultSet;

/**
 * Created by HP on 12/6/2015.
 */
public class ConsoleDB {

    SearchTicketInfo ob;

    void init(SearchTicketInfo ob){
        this.ob = ob;

        System.out.println(ob.getStarting());
        System.out.println(ob.getDestination());
        System.out.println(ob.getDate());
        System.out.println(ob.getCoachType());



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

            }
            //SearchMaxDBId searchMaxDBId = new SearchMaxDBId();
            //System.out.println(searchMaxDBId.getMaxBusID());
            //System.out.println(searchMaxDBId.getMaxPersonID());
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


}
