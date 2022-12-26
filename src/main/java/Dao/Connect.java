package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");	
//            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalexam","root","zucoder2002");
            connection=DriverManager.getConnection("jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_0fe71376f4f3f46","b9faf2e0059240","b98d0774");
            System.out.print("connected");
//            connection.setAutoCommit(false);
        }
        return connection;
    }
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		System.out.println(getConnection());
	}
}
