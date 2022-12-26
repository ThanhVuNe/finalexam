package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Match;
import Model.Team;

public class MatchDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public MatchDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Match> getAllMatchByIdSeason(int id_season) {
		List<Match> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select m.*, t.name, t.logo from match_detail m join team t on m.id_team=t.id join `match` on m.id_match=`match`.id where id_season=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_season);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Match(rs.getInt("id_team"), rs.getInt("id_match"), rs.getInt("status"), rs.getInt("score"),
						rs.getString("name"), rs.getString("logo")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public List<Match> SearchByNameAndPage(int id, String search, int page) {
		
		return null;
	}
	

	public List<Match> SearchByName(int parseInt, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Match> getTeamByPage(int page, String season) {
		List<Match> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select m.*, t.name, t.logo from match_detail m join team t on m.id_team=t.id join `match` on m.id_match=`match`.id\r\n"
					+ "where id_season=? order by id_match limit ?,6;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(season));
			ps.setInt(2, (page - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Match(rs.getInt("id_team"), rs.getInt("id_match"), rs.getInt("status"), rs.getInt("score"),
						rs.getString("name"), rs.getString("logo")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public static void main(String[] args) {
		MatchDao dao=new MatchDao();
		System.out.println(dao.getTeamByPage(1, "1"));
		System.out.println(Math.round((float)dao.getAllMatchByIdSeason(Integer.parseInt("1")).size()/6));
		System.out.println(Math.round((float)(13/6)));
	}
}
