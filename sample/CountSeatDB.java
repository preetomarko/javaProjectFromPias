package sample;

import java.sql.ResultSet;

/**
 * Created by HP on 12/15/2015.
 */
public class CountSeatDB {
    private int counter = 0;

    public int getCounter(){return counter;}


    void init(int ob){
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = "select * from busSeatReservation where id = " + ob ;
            ResultSet rs = oc.searchDB(query);
            //System.out.println("Product List");
            //System.out.println("Id\t"+"Starting Counter  "+" Fare  "+"  Coach Type "+"  Destination  "+"  Date  ");
            while(rs.next())
            {
                String str;
                //System.out.print(rs.getInt("id"));
                System.out.print("	  ");
                for(int x =1; x<=40; x++){
                    str = "s"+x;
                    if(rs.getString(""+str).equals("0"))
                        counter++;
                }
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
}
