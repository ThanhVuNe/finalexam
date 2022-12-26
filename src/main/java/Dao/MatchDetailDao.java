package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Match;
import Model.MatchDetail;

public class MatchDetailDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public MatchDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public List<MatchDetail> getMatchDetail(int id_match, int id_season) {
		List<MatchDetail> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select m.*, t.name,t.logo, mt.date, mt.description, mt.card from match_detail as m \r\n"
					+ "inner join team as t on m.id_team=t.id\r\n" + "inner join `match` as mt on m.id_match=mt.id\r\n"
					+ " where id_match=? and mt.id_season=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_match);
			ps.setInt(2, id_season);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new MatchDetail(rs.getInt("id_team"), rs.getInt("id_match"), rs.getInt("status"),
						rs.getInt("score"), rs.getString("name"), rs.getString("logo"), rs.getString("date"),
						rs.getString("description"), rs.getInt("card")));

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public static void main(String[] args) {
		MatchDetailDao dao=new MatchDetailDao();
		System.out.println(dao.getMatchDetail(1, 1));
	}
}
