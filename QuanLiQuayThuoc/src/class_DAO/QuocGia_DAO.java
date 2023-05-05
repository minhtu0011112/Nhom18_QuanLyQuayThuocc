package class_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.QuocGia;

public class QuocGia_DAO {
	public ArrayList<QuocGia> getAllQuocGia() {
		ArrayList<QuocGia> listQG  = new ArrayList<QuocGia>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();	
			String sql = "Select * from QuocGia";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maQG = rs.getString(1);
				String tenQG = rs.getString(2);
				QuocGia hc = new QuocGia(maQG,tenQG);	 		
				listQG.add(hc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listQG;
	}
}
