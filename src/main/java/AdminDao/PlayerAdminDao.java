package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.CommentModel;
import Model.Player;

public class PlayerAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public PlayerAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Player>getAll(){
		List<Player>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from `player`";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new Player(rs.getInt("id"), rs.getString("name"),rs.getInt("shirt"),rs.getInt("id_team")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public static void main(String[] args) {
		PlayerAdminDao dao=new PlayerAdminDao();
		System.out.println(dao.getAll());
	}
}
