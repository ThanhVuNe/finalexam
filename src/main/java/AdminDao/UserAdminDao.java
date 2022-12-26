package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Account;
import Model.User;

public class UserAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public UserAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<User>getAll(){
		List<User>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from user";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new User(rs.getInt("id"), rs.getString("fullname"), rs.getInt("age"),rs.getString("img"),rs.getInt("id_account")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public User getById(String id){
		User a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from user where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				a=new User(rs.getInt("id"), rs.getString("fullname"), rs.getInt("age"),rs.getString("img"),rs.getInt("id_account"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addUser(String name,String age,String img,String id_account) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `user` (`fullname`, `age`, `img`, `id_account`) VALUES (?, ?, ?, ?);\r\n"
					+ "";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, img);
			ps.setString(4, id_account);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `user` WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UserAdminDao dao=new UserAdminDao();
		System.out.println(dao.getById("1"));
	}
}
