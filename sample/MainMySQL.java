package sample;

import java.sql.ResultSet;
import java.util.Scanner;

public class MainMySQL
{


    public static void listProducts()
    {
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = "select * from BusFinal2";
            ResultSet rs = oc.searchDB(query);
            System.out.println("Product List");
            System.out.println("Id	Name	Price	Description");
            while(rs.next())
            {
                System.out.print(rs.getInt("id"));
                System.out.print("	");
                System.out.print(rs.getString("staringStation"));
                System.out.print("	");
                System.out.print(rs.getString("fare"));
                System.out.print("	");
                System.out.println(rs.getString("destination"));
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


    public static void addProduct(int id, String name, double price, String desc)
    {
        MySQLConnect oc=new MySQLConnect("localhost","person","root","quantumraj");
        try
        {
            String query = String.format("select * from products where id = %d", id);
            ResultSet rs = oc.searchDB(query);
            if(rs.next())
            {
                System.out.println("Product with this Id already exisits");
            }
            else
            {
                String insertQuery = String.format("insert into products(id, name, price, description) values (%d, '%s', %f, '%s')",
                        id, name, price, desc);
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

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        listProducts();
        while(true)
        {
            System.out.println("Enter Product Information: ");
            System.out.print("Enter Id:");
            int id = scanner.nextInt();
            System.out.print("Enter Name:");
            String name = scanner.next();
            System.out.print("Enter Price:");
            double price = scanner.nextDouble();
            System.out.print("Enter Description:");
            String desc = scanner.next();
            addProduct(id, name, price, desc);
            listProducts();
            System.out.println("Do you want to continue (y/n)?");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("n")) break;
        }
        scanner.close();
    }
}

	