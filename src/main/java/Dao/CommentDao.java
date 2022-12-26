package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Comment;
import Model.Match;

public class CommentDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public CommentDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Comment> getByIdUser(int id,int id_match) {
		List<Comment> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select c.*, u.fullname,u.img from comment c join user u on c.id_user=u.id where id_user=? and id_match=? order by date desc";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id_match);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Comment(rs.getInt("id"), rs.getString("content"), rs.getInt("id_match"),
						rs.getInt("id_user"),rs.getString("date"),rs.getString("fullname"),rs.getString("img")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public List<Comment> getAllComments(int id,int id_match) {
		List<Comment> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select c.*, u.fullname,u.img from comment c join user u on c.id_user=u.id where id_user!=? and id_match=? order by date desc";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id_match);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Comment(rs.getInt("id"), rs.getString("content"), rs.getInt("id_match"),
						rs.getInt("id_user"),rs.getString("date"),rs.getString("fullname"),rs.getString("img")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public void EditComment(int id,String content) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `comment` SET `content` = ? WHERE (`id` = ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void AddComment(String content, int id_match,int id_user, String date) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `comment` (`content`, `id_match`, `id_user`, `date`) VALUES (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, id_match);
			ps.setInt(3, id_user);
			ps.setString(4, date);
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void DeleteComment(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `comment` WHERE (`id` = ?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		CommentDao dao=new CommentDao();
		dao.DeleteComment("12");
	}
}
