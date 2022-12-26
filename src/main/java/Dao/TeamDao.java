package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Season;
import Model.Team;

public class TeamDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public TeamDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Team> getTop6TeamByIdSeason(int id) {
		List<Team> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season=? limit 6";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),
						rs.getString("logo"), rs.getInt("id_season"), rs.getString("img_arena"),
						rs.getString("description")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public List<Team> getTeamByIdSeason(int id) {
		List<Team> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),
						rs.getString("logo"), rs.getInt("id_season"), rs.getString("img_arena"),
						rs.getString("description")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public List<Team> SearchByName(int id, String search) {
		List<Team> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season=? and name like ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, "%" + search + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),
						rs.getString("logo"), rs.getInt("id_season"), rs.getString("img_arena"),
						rs.getString("description")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public List<Team> SearchByNameAndPage(int id, String search, int page) {
		List<Team> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season=? and name like ? limit ?,3";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, "%" + search + "%");
			ps.setInt(3, (page - 1) * 3);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),
						rs.getString("logo"), rs.getInt("id_season"), rs.getString("img_arena"),
						rs.getString("description")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public Team getTeamById(int id) {
		Team temp = null;
		try {
			con = Connect.getConnection();
			String sql = "Select * from team where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("ok");
				temp = new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"), rs.getString("logo"),
						rs.getString("img_arena"), rs.getString("description"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public List<Team> getTeamByPage(int page, String season) {
		List<Team> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season=? limit ?,3";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(season));
			ps.setInt(2, (page - 1) * 3);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Team(rs.getInt("id"), rs.getString("name"), rs.getString("name_arena"),
						rs.getString("logo"), rs.getInt("id_season"), rs.getString("img_arena"),
						rs.getString("description")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	public static void main(String[] args) {
		TeamDao dao = new TeamDao();
		System.out.println(dao.getTeamByIdSeason(1).size());
		int pageSize=dao.getTeamByIdSeason(Integer.parseInt("1")).size();
		pageSize=pageSize%3==0?pageSize-1:pageSize;
		System.out.println(pageSize);
		pageSize=(int)Math.ceil((float)(pageSize/3)+0.1);
		System.out.println(pageSize);
	}
}
