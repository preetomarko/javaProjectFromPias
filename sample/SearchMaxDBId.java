package sample;

import java.sql.ResultSet;

/**
 * Created by HP on 12/15/2015.
 */
public class SearchMaxDBId {

    private int max=0;

    public int getMaxBusID(){
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            //select max(id) from busfinal2;
            String query = "select max(id) from busfinal2" ;
            ResultSet rs = oc.searchDB(query);
            //System.out.println("Product List");
            //System.out.println("Id\t"+"Starting Counter  "+" Fare  "+"  Coach Type "+"  Destination  "+"  Date  ");
            while(rs.next())
            {
                max = rs.getInt("max(id)");
                return max;
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
        //return 0;
        return max;
    }

    public int getMaxPersonID(){
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            //select max(id) from busfinal2;
            String query = "select max(id) from personalinfo4" ;
            ResultSet rs = oc.searchDB(query);
            //System.out.println("Product List");
            //System.out.println("Id\t"+"Starting Counter  "+" Fare  "+"  Coach Type "+"  Destination  "+"  Date  ");
            while(rs.next())
            {
                max = rs.getInt("max(id)");
                return max;
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
        //return 0;
        return max;
    }

}
