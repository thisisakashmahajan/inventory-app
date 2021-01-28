/*
Admin.java
* This API allows a user of system to login as ADMIN
* Admin is important role in system and has control on the inventory present in system
* Uses view() method from Common API to display list of products

@author: AKASH A MAHAJAN <akashmahajan025@gmail.com>

*/


import java.sql.*;

public class Admin extends Common
{
        private Connection connection;
        private Statement statement;
        private ResultSet results;
        private final String url = "jdbc:mysql://localhost:3306/inventory";
        public Admin()
        {
        	/*
        	The Admin interacts with database. In order to initialize a new ADMIN role, application must establish connection with database. If connection succeed user can continue else there is a exception message shown `We cannot intiate admin`
        	*/
             try
             {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  connection = DriverManager.getConnection(url, "root", "");
	          statement = connection.createStatement();
                  
             }
             catch (Exception e)
             {
                  System.out.println("We cannot initiate admin");
             }
        }
	public void add(int product_id, String product_name, float product_price, int product_av)
	{
		/*
		Admin can add new product in inventory. This product requires few parameter Viz. product ID (int), product name, its price and stock available in database i.e. product availability
		*/
             String query;
             if (isAvailable(product_id) > 0)
             {
                  System.out.println("The product with this ID is present");
             }
             else
             {
                  try 
                  {
	               query = "INSERT INTO inventory VALUES(" + product_id + ", '" + product_name + "'," + product_price + "," + product_av + ")";
                       int rows = statement.executeUpdate(query);
                       System.out.println(rows + " product inserted");
                  }
                  catch (Exception e)
                  {
                       System.out.println("Internal problem occured"); 
                  }
             }
	}
	public void increase(int product_id, int by) 	// focus on product_av
	{
		// Increase the existing stock of product by `by`. It requires to provide a unique product id. For example, if product_id = 2345 and having existing product_av = 100, and if by = 20 then after executing method, product_av = 120
	     if (isAvailable(product_id) == 0)
             {
                  System.out.println("The product with this ID is not present. Please add");
             }
             else
             {
                  String query = "UPDATE inventory SET product_av = product_av + " + by + " WHERE product_id = " + product_id;
                  try {
                       int rows = statement.executeUpdate(query);
                  }
 	 	  catch (Exception e) 
                  {
                       System.out.println("Internal problem occured"); 
                  }
                  System.out.println(product_id + "'s availibility incremented by " + by);
             }
	}
	public void decrease(int product_id, int by) 	// focus on product_av
	{
	     // Inversion of increase() method
	     if (isAvailable(product_id) == 0)
             {
                  System.out.println("The product with this ID is not present. Please add");
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
                  System.out.println(product_id + "'s availibility decremented by " + by);
             }		
	}
        private int isAvailable(int product_id)
        {
             // This method checks if a product with product_id is available in inventory. A product is NOT available if its product_av = 		// 0 else it is available.
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
        public static void main(String[] args)
        {
	     /*
              * This method is for testing purpose
	      * Every method of this class is function-intensive. Only perform function when you're sure
	      * Use with only Admin object. 'Common' object is not possible.
             */
        }
}
