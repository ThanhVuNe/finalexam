package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Match;
import Model.User;

public class UserDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public User getByIdAccount(int id) {
		User temp = null;
		try {
			con = Connect.getConnection();
			String sql = "select * from user where id_account=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				temp = new User(rs.getInt("id"), rs.getString("fullname"), rs.getInt("age"), rs.getString("img"),
						rs.getInt("id_account"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public User getByIdUser(int id) {
		User temp = null;
		try {
			con = Connect.getConnection();
			String sql = "select * from user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				temp = new User(rs.getInt("id"), rs.getString("fullname"), rs.getInt("age"), rs.getString("img"),
						rs.getInt("id_account"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public void EditAccount(int id,String name,String age,String img) {
		try {
			con = Connect.getConnection();
			String sql = "";
			if(img.equals("")) {
				sql="UPDATE `user` SET `fullname` = ?, age=? WHERE (`id` = ?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, age);
				ps.setInt(3, id);
			}else {
				sql="UPDATE `user` SET `fullname` = ?, `age` = ?, `img` =? WHERE (`id` = ?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, age);
				ps.setString(3, img);
				ps.setInt(4, id);
			}
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		System.out.println(dao.getByIdUser(1));
	}
}
