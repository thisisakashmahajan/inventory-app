/*
User.java
* This is user API allows a system user to login as USER
* User is just somebody who has limited access and one extra feature to buy a list of products
* Uses Common API and LinkedList API to run 

@author: AKASH A MAHAJAN <akashmahajan025@gmail.com>

*/


import java.sql.*;

public class User extends Common
{
        private Connection connection;
        private LinkedList list;
        private Statement statement;
        private ResultSet results;
        private final String url = "jdbc:mysql://localhost:3306/inventory";

        public User()
        {
        /* In order to login as USER, one must establish connection with database. If not, then the login fails */
             try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  connection = DriverManager.getConnection(url, "root", "");
                  statement = connection.createStatement();
                  list = new LinkedList();
             }
             catch (Exception e)
             {
                  System.out.println("We cannot initiate user");
             }
        }
        public void add(int product_id, String product_name, float product_price, int product_av){
        
        /* Unsupported Operation */
        
        }
	public void add(int product_id, int amount)
	{
		// This method is used to add a product into cart. The cart is actually a LinkedList instance
                String product_name = "";
	        float price = 0.0f;
		if (isAvailable(product_id) == 0)
                {
                     System.out.println("The product you are requesting is out of stock.");
                }
                else 
                {
                     String query = "SELECT product_name, product_price FROM inventory WHERE product_id = " + product_id;
                     try
                     {
                          results = statement.executeQuery(query);
                          results.next();
                          product_name = results.getString(1);
                          price = results.getFloat(2);
                          list.insert(product_id, product_name, price, amount);
                          System.out.println(amount + " x " + product_name + " added to cart");
                     }
                     catch (Exception e)
                     {
                          System.out.println("Products details not available");
                     }

                }
	}
	public float total()
	{
		// Returns the total price or amount of shopping done.
                int[][] cart = list.getCart();	// getCart() returns a 2D array containing product_id and its amount
                for(int[] item: cart)
                {
                     decrease(item[0], item[1]);	// Internally uses decrease method to reduce the product availability as it was 								// bought by user
                }
		return list.getTotal();
	}
        public void displayList()
        {
        	// Simply displays the list
                list.display();
        }
	public void emptyCart()
	{
		// Empties the cart
		list.empty();
                System.out.println("Cart emptied");
	}
        private int isAvailable(int product_id)
        {
        // Checks if a product available in database
             int count = 0;
             String query;
             try 
             {
	          query = "SELECT COUNT(*) FROM inventory WHERE product_id = " + product_id;
                  results = statement.executeQuery(query);
                  results.next();
                  count = results.getInt(1);
             }
             catch (Exception e)
             {
                  System.out.println("Internal problem occured"); 
             }
             return count;
        }
	private void decrease(int product_id, int by) 	// focus on product_av
	{
		// Decrease the product_av of product_id by `by`
	     if (isAvailable(product_id) == 0)
             {
             }
             else
             {
                  String query = "UPDATE inventory SET product_av = product_av - " + by + " WHERE product_id = " + product_id;
                  try {
                       int rows = statement.executeUpdate(query);
                  }
 	 	  catch (Exception e)
                  {
                       System.out.println("Internal problem occured"); 
                  }
             }		
	}
        public static void main(String[] args)
        {
             User usr = new User();
             usr.view();
        }
}
