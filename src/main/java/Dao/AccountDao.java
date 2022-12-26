package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Account;

public class AccountDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public AccountDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Account login(String email,String pass) {
		Account a=null;
		try {
			con=Connect.getConnection();
			String sql="Select * from account where email=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			if(rs.next()) {
				a=new Account(rs.getInt("id"), rs.getString("email"), pass,rs.getInt("role"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void signUp(String email,String password) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO account (`email`, `password`, `role`) VALUES (?, ?, ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setInt(3, 0);
//			ps.setInt(4, 0);
			ps.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account checkEmail(String email) {
		Account a=null;
		try {
			con=Connect.getConnection();
			String sql="Select * from account where email=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				a=new Account(rs.getInt("id"), rs.getString("email"), rs.getString("password"),rs.getInt("role"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public void updatePassword(String email,String pass) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `account` SET `password` = ? WHERE (`email` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, email);
			ps.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		AccountDao accountDao=new AccountDao();
	}
}
