package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Season;
import Model.Team;

public class TeamAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public TeamAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Team>getAll(){
		List<Team>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from team";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),rs.getString("logo"),rs.getString("img_arena"),rs.getString("description")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public Team getTeamById(String id){
		Team a=null;
		try {
			con=Connect.getConnection();
			String sql="select * from team where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				a=new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),rs.getString("logo"),rs.getString("img_arena"),rs.getString("description"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addTeam(String name,String nameArena,String logo,String imgArena,String des) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `team` (`name`, `name_arena`, `logo`, `img_arena`, `description`) VALUES (?, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, nameArena);
			ps.setString(3, logo);
			ps.setString(4, imgArena);
			ps.setString(5, des);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteTeamById(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `team` WHERE (`id` = ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);	
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EditTeam1(String name,String arena,String description,String id) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `team` SET `name` = ?, `name_arena` = ?, `description` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, arena);
			ps.setString(3, description);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EditTeam2(String name,String arena,String logo,String description,String id) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `team` SET `name` = ?, `name_arena` = ?, `logo` = ?, `description` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, arena);
			ps.setString(3, logo);
			ps.setString(4, description);
			ps.setString(5, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EditTeam3(String name,String arena,String imgArena,String description,String id) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `team` SET `name` = ?, `name_arena` = ?, `img_arena` = ?, `description` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, arena);
			ps.setString(3, imgArena);
			ps.setString(4, description);
			ps.setString(5, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EditTeam4(String name,String arena,String logo,String imgArena,String description,String id) {
		try {
			con=Connect.getConnection();
			String sql="UPDATE `team` SET `name` = ?, `name_arena` = ?, `logo` = ?, `img_arena` = ?, `description` = ? WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, arena);
			ps.setString(3, logo);
			ps.setString(4, imgArena);
			ps.setString(4, description);
			ps.setString(5, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TeamAdminDao dao=new TeamAdminDao();
		System.out.println(dao.getTeamById("17"));
	}
}
