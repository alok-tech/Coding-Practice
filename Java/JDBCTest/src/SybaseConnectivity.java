import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sybase.jdbcx.*;
 
public class SybaseConnectivity {
 Connection con = null;
 Statement stmt = null;
 SybDriver sybDriver = null;
 
 public void makeConnection() throws Exception {
   try
  {
   sybDriver = (SybDriver) Class.forName(
     "com.sybase.jdbc3.jdbc.SybDriver").newInstance();
   System.out.println("Driver loaded");
   con = DriverManager
		   .getConnection("jdbc:sybase:Tds:198.19.5.76:4205/TIQBIG2_1",
       "salam", "L3ath3rJack3t");
 
   Statement stmt = con.createStatement();
   // Execute the query
   ResultSet rs = stmt.executeQuery("select * from em_billing.billing_config");
 
   // Loop through the result set
   while (rs.next()) {
    System.out.println(rs.getString(2));
   }
   // Close the result set, statement and the connection
   rs.close();
   stmt.close();
   con.close();
 
  } catch(Exception e)
  {
    System.out.println("Error is "+e.getMessage());
  }
 }
 
 public static void main(String args[]) throws Exception {
  SybaseConnectivity sc = new SybaseConnectivity();
  sc.makeConnection();
 }
}