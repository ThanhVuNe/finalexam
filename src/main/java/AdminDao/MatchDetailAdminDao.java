package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Account;
import Model.MatchDetailModel;
import Model.MatchModel;

public class MatchDetailAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public MatchDetailAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<MatchDetailModel>getAll(){
		List<MatchDetailModel>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from match_detail";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new MatchDetailModel(rs.getInt("id"), rs.getInt("id_team"), rs.getInt("id_match"), rs.getInt("status"), rs.getInt("score")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addMatchDetail(String id_team,String id_match,String status,String score) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `match_detail` (`id_team`, `id_match`, `status`, `score`) VALUES (?, ?, ?, ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id_team);
			ps.setString(2, id_match);
			ps.setString(3, status);
			ps.setString(4, score);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteMatchDetail(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `match_detail` WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MatchDetailAdminDao dao=new MatchDetailAdminDao();
		System.out.println(dao.getAll());
	}
}
