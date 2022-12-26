package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Model.Season;

public class SeasonDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public SeasonDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Season>getAllSeason(){
		List<Season>temp=new ArrayList<>();
		try {
			con=Connect.getConnection();
			String sql="Select * from season";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				temp.add(new Season(rs.getInt("id"), rs.getString("year_start"), rs.getString("year_end")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public Season getSeasonById(int id) {
		Season season=null;
		try {
			con=Connect.getConnection();
			String sql="Select * from season where id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				season=new Season(rs.getInt("id"), rs.getString("year_start"), rs.getString("year_end"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return season;
	}
	public static void main(String[] args) {
		SeasonDao dao=new SeasonDao();
		System.out.println(dao.getSeasonById(2));
	}
}
