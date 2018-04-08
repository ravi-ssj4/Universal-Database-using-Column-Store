package columnStore;

import java.sql.Connection;

import javax.swing.*;

import java.sql.DriverManager;

public class SQLConn {

	public static Connection createConn() throws Exception{

		Class.forName("com.mysql.jdbc.Driver"); //it is to load driver
	 	String url = "jdbc:mysql://localhost:3306/MARKET_FACT"; //database name
	    String uname="root";
	    String pass="Kamasutra@2018";
	    
	    Connection conn = DriverManager.getConnection(url,uname,pass); 
	    JOptionPane.showMessageDialog(null, "Connection is successful");
	    return conn;

	}
}
