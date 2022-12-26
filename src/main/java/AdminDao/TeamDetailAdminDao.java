package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.TeamDetail;

public class TeamDetailAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public TeamDetailAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<TeamDetail>getAll(){
		List<TeamDetail>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from team_detail order by id_season ";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new TeamDetail(rs.getInt("id"),rs.getInt("id_season"),rs.getInt("id_team")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public TeamDetail checkExists(String id_season,String id_team) {
		TeamDetail a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from team_detail where id_season=? and id_team=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id_season);
			ps.setString(2, id_team);
			rs=ps.executeQuery();
			while(rs.next()) {
				a=new TeamDetail(rs.getInt("id"),rs.getInt("id_season"),rs.getInt("id_team"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public void addTeamDetail(String id_season,String id_team) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `team_detail` (`id_season`, `id_team`) VALUES (?, ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id_season);
			ps.setString(2, id_team);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editTeamDetail(String id,String id_season,String id_team) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `team_detail` SET `id_season` = ?, `id_team` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id_season);
			ps.setString(2, id_team);
			ps.setString(3, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteTeamDetail(String id_season,String id_team) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `team_detail` WHERE (`id_season` = ?) and (`id_team` = ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, id_season);
			ps.setString(2, id_team);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TeamDetailAdminDao dao=new TeamDetailAdminDao();
		System.out.println(dao);
	}
}
