package pharma.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pharma.database.DataConnection;

public class UserModel {
	
	public String[] showChiNhanh() {
		try {
			DataConnection query = new DataConnection();
			String sql = "select * from chinhanh";
			query.setQuery(sql);
			ResultSet rs = query.getAllRow();
			ArrayList<String> a = new ArrayList<>();
			while (rs.next()) {
				a.add(rs.getString("tenchinhanh"));
			}
			String[] b = new String[a.size()];
			for (int i = 0; i < b.length; i++) {
				b[i] = a.get(i);
			}
			return b;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ResultSet showDuocSi() {
		DataConnection query = new DataConnection();
		String sql = "SELECT * FROM user";
		query.setQuery(sql);
		ResultSet rs = query.getAllRow();
		return rs;
	}
	
	public void themNhanVien(String hoten, int sdt, String chucvu, String gioitinh, String namsinh, String tencn) {
		DataConnection query = new DataConnection();
		String sql = "INSERT INTO user(hoten, sdt, chucvu, gioitinh, namsinh, macn) "
				+ "SELECT '" + hoten + "', '" + sdt + "', '" + chucvu + "', '" + gioitinh + "', '" + namsinh + "', macn FROM chinhanh WHERE tenchinhanh = '" + tencn + "' LIMIT 1";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void xoaNhanVien(int uid) {
		DataConnection query = new DataConnection();
		String sql = "DELETE FROM user WHERE uid = '" + uid + "'";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void suaNhanVien(int uid, String hoten, int sdt, String chucvu, String gioitinh, String namsinh, String tencn) {
		DataConnection query = new DataConnection();
		String sql = "UPDATE user SET hoten = '" + hoten + "', sdt = '" + sdt + "', chucvu = '" + chucvu + "', gioitinh = '" + gioitinh + "', namsinh = '" + namsinh + "', macn = (SELECT macn FROM chinhanh WHERE tenchinhanh = '" + tencn + "' LIMIT 1) "
				+ "WHERE uid = '" + uid + "' ";
		query.setQuery(sql);
		query.doQuery();
	}
	
//	public static void main(String[] args) {
//		UserModel c = new UserModel();
//		ResultSet test = c.showDuocSi();
//		try {
//			while(test.next()) {
//				System.out.println(test.getObject(2));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
