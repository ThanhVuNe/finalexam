package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Account;

public class AccountAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public AccountAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Account>getAll(){
		List<Account>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from account where role=0";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new Account(rs.getInt("id"), rs.getString("email"), rs.getString("password"),rs.getInt("role")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public Account getAccountById(String id) {
		Account a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from account where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
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
	public Account checkEmail(String email) {
		Account a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from account where email=?";
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
	public void addAccount(String email,String password) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `account` (`email`, `password`, `role`) VALUES (?, ?, ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setInt(3, 0);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editAccount(String email,String password,String id) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `account` SET `email` = ?, `password` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAccount(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `account` WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		AccountAdminDao dao=new AccountAdminDao();
		System.out.println(dao.getAccountById("1"));
	}
}
