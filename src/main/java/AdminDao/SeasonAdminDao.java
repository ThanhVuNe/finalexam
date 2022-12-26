package AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Connect;
import Model.Account;
import Model.Season;

public class SeasonAdminDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public SeasonAdminDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Season>getAll(){
		List<Season>a=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="select * from season";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				a.add(new Season(rs.getInt("id"), rs.getString("year_start"), rs.getString("year_end")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void addSeason(String yearS,String yearE) {
		try {
			con=Connect.getConnection();
			String sql="INSERT INTO `season` (`year_start`, `year_end`) VALUES (?, ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, yearS);
			ps.setString(2, yearE);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteSeason(String id) {
		try {
			con=Connect.getConnection();
			String sql="DELETE FROM `season` WHERE (`id` = ?);";
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SeasonAdminDao dao=new SeasonAdminDao();
		System.out.println(dao.getAll());
	}
}
