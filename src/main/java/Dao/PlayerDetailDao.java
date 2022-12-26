package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.PlayerDetail;
import Model.Team;

public class PlayerDetailDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public PlayerDetailDao() {
		// TODO Auto-generated constructor stub
	}

	public List<PlayerDetail> getGoal(int id_match, int id_team) {
		List<PlayerDetail> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select p.id_team,p.name,g.minute from player_detail pd join player p on pd.id_player=p.id join `match` m on pd.id_match=m.id join goal g on pd.id=g.id_player_detail\r\n"
					+ "where pd.id_match=? and p.id_team=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_match);
			ps.setInt(2, id_team);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new PlayerDetail(rs.getInt("id_team"), rs.getString("name"), rs.getInt("minute")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public static void main(String[] args) {
		PlayerDetailDao dao=new PlayerDetailDao();
		System.out.println(dao.getGoal(1, 4));
	}
}
