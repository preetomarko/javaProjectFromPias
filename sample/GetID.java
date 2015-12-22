package sample;

/**
 * Created by HP on 12/21/2015.
 */

import java.sql.ResultSet;
import java.time.LocalDate;

/**
 * Created by HP on 12/15/2015.
 */
public class GetID {
    private int id;
    private String from, to, time;
    LocalDate date;

    public int getCounter(){return id;}


    void init(String from, String to, String time, LocalDate date){
        //getID.init(from, to, time, date);
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query2 = "select * from BusFinal2 where staringStation = '" + from +"' and destination = '"+to+"'"+" and workingDate = '"+date+"'"+ " and startingTime = '"+ time+"'";
            String query = "select * from BusFinal2 where staringStation = '"+from+"' and destination = '"+to+"' and workingDate = '"+date+"' and startingTime = '" + time +"'";
            ResultSet rs = oc.searchDB(query);
            ResultSet rs2 = oc.searchDB(query2);

            //id = rs.getInt("id");
            //id = rs.getInt("id");

            while(rs.next())
            {
                id = rs.getInt("id");
            }

            //System.out.println(id);
            //System.out.println("Product List");
            //System.out.println("Id\t"+"Starting Counter  "+" Fare  "+"  Coach Type "+"  Destination  "+"  Date  ");

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
