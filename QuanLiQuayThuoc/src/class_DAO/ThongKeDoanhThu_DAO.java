package class_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import class_connectDB.ConnectDB;
import class_entity.ThongKeDoanhThu;

public class ThongKeDoanhThu_DAO {
	private ArrayList<ThongKeDoanhThu> dsThongKe;
	public ThongKeDoanhThu_DAO() {
		dsThongKe = new ArrayList<ThongKeDoanhThu>();
	}
	public ArrayList<ThongKeDoanhThu> getAllDoanhThu(Date ngayBD, Date ngayEnd) {
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql="select * from [dbo].[ThongKeDoanhThuTheoNgay]('"+ngayBD+"','"+ngayEnd+"')";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				Date ngay = rs.getDate(1);
				int tong = rs.getInt(2);
				float tongTien = rs.getFloat(3);
				
				ThongKeDoanhThu tk = new ThongKeDoanhThu(ngay, tong, tongTien);
				dsThongKe.add(tk);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsThongKe;
	}
}
