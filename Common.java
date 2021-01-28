/*
Common.java
* This file includes the common methods which are used in Admin API and User API
* Both the APIs requires to display a list of products in current instance.
* Uses MySQL database at backend running on localhost:3306 logically

@author: AKASH A MAHAJAN <akashmahajan025@gmail.com>

*/

import java.sql.*;

public abstract class Common
{
	public abstract void add(int product_id, String product_name, float product_price, int product_av);
        private Connection connection;
        private Statement statement;
        private ResultSet results;
	public void view()
	{
             String url = "jdbc:mysql://localhost:3306/inventory";
	     try
             {
                  Class.forName("com.mysql.cj.jdbc.Driver");
	          connection = DriverManager.getConnection(url, "root", "");
	          statement = connection.createStatement();
                  results = statement.executeQuery("SELECT * FROM inventory");
                  
                  System.out.println("ID \t Product Name \t Price (in Rs.) \t In Stock");
                  System.out.println("------------------------------------------------------------");
                  while (results.next())
                  {
                       System.out.println(results.getInt(1) + "\t\t" + results.getString(2) + "\t\t" + results.getFloat(3) + "\t\t" + results.getInt(4));
                  }
             }
             catch (Exception e)
             {
		       System.out.println("There was problem while showing products");
             }
	}
}

/*
class Main extends Common
{
     public void add(int product_id, String product_name, float product_price, int product_av) {}
     public static void main(String[] args)
     {
          Main m = new Main();
          m.view();
     }
}
*/
