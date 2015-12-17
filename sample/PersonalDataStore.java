package sample;

import java.sql.ResultSet;
import java.util.Random;

/**
 * Created by HP on 12/9/2015.
 */
public class PersonalDataStore {

    PersonalInfo customer;

    private int ID;
    private String pin;
    Random randomGenerator = new Random();

    public PersonalDataStore(PersonalInfo customer) {

        SearchMaxDBId searchMaxDBId = new SearchMaxDBId();
        ID = searchMaxDBId.getMaxPersonID();
        //System.out.println(++ID);
        int rand = randomGenerator.nextInt(1000)+1000;
        pin = ""+rand+""+customer.getMobile();
        //System.out.println(pin);
        this.customer = customer;
        addCustomer(++ID, customer.getName(), customer.getMobile(), customer.getAddress(), customer.getGender(), customer.getAge(), customer.getEmail(), customer.getPaymentMethod(), pin);
    }


    public static void addCustomer(int id, String name,String mobile,String address,String gender,String age,String email,String paymentMethod, String pin)
    {
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = String.format("select * from personalinfo4 where id = %d", id);
            ResultSet rs = oc.searchDB(query);
            if(rs.next())
            {
                System.out.println("Product with this Id already exisits");
            }
            else
            {
                String insertQuery = String.format("insert into personalinfo4 values (%d, '%s', %s, '%s', '%s', '%s', '%s', '%s', '%s')",
                        id, name, mobile, address, gender, age, email, paymentMethod, pin);
                oc.updateDB(insertQuery);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in addProduct: " + e);
        }
        finally
        {
            oc.close();
        }
    }

}
