package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Player;
import Model.Team;

public class PlayerDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public PlayerDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Player> getPlayersByIdTeam(int id) {
		List<Player> temp = new ArrayList<>();
		try {
			con = Connect.getConnection();
			String sql = "select player.* from player inner join team_detail on player.id_team=team_detail.id_team where id_season=1 and team_detail.id_team=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				temp.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getInt("shirt"), rs.getInt("id_team")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public static void main(String[] args) {
		PlayerDao dao=new PlayerDao();
		System.out.println(dao.getPlayersByIdTeam(8));
	}
}
