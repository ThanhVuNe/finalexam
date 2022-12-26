package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Comment;
import Model.CommentModel;
import Model.MatchModel;

public class CommentAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public CommentAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<CommentModel>getAll(){
		List<CommentModel>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from `comment`";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new CommentModel(rs.getInt("id"), rs.getString("content"), rs.getInt("id_match"),rs.getInt("id_user"),rs.getString("date")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public CommentModel getById(String id) {
		CommentModel a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from `comment` where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				a=new CommentModel(rs.getInt("id"), rs.getString("content"), rs.getInt("id_match"),rs.getInt("id_user"),rs.getString("date"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addComment(String content,String id_match,String id_user,String date) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `comment` (`content`, `id_match`, `id_user`, `date`) VALUES (?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, id_match);
			ps.setString(3, id_user);
			ps.setString(4, date);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editComment(String id,String content,String id_match,String id_user,String date) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `comment` SET `content` = ?, `id_match` = ?, `id_user` = ?, `date` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setString(2, id_match);
			ps.setString(3, id_user);
			ps.setString(4, date);
			ps.setString(5, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteComment(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `comment` WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		CommentAdminDao dao=new CommentAdminDao();
		System.out.println(dao.getById("3"));
	}
}
