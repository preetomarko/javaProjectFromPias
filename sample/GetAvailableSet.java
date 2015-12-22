package sample;

import java.sql.ResultSet;

/**
 * Created by HP on 12/21/2015.
 */
public class GetAvailableSet {

    int id;

    public void setId(int id){
        this.id = id;
        //System.out.println(this.id);
    }

    public void init(String[] phoneNumber){
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = "select * from busSeatReservation where id = " + id ;
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
                    phoneNumber[x] = rs.getString(""+str);
                    //System.out.println(phoneNumber[x]);
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
