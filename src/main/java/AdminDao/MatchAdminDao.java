package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Match;
import Model.MatchModel;
import Model.Team;

public class MatchAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public MatchAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<MatchModel>getAll(){
		List<MatchModel>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from `match`";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new MatchModel(rs.getInt("id"), rs.getString("date"), rs.getInt("id_season"),rs.getInt("card")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public MatchModel getMatchById(String id){
		MatchModel a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from `match` where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				a=new MatchModel(rs.getInt("id"), rs.getString("date"), rs.getInt("id_season"),rs.getInt("card"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addMatch(String date,String id_season,String cart) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `match` (`date`, `id_season`, `card`) VALUES (?, ?, ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, id_season);
			ps.setString(3, cart);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editMatch(String date,String id_season,String card,String id) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `match` SET `date` = ?, `id_season` = ?, `card` = ? WHERE (`id` = ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, id_season);
			ps.setString(3, card);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteMatch(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `match` WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		MatchAdminDao dao=new MatchAdminDao();
		System.out.println(dao.getAll());
	}
}
