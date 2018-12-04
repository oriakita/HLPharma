package pharma.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pharma.database.DataConnection;

public class ChiNhanhModel {
	
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
	
	public ResultSet showChiNhanhSelected(String tenchinhanh) {
		DataConnection query = new DataConnection();
		String sql = "SELECT * FROM chinhanh WHERE tenchinhanh = '" + tenchinhanh + "'";
		query.setQuery(sql);
		ResultSet rs = query.getAllRow();
		return rs;
	}
	
	public void themChiNhanh(String tenchinhanh, String diachi, int sdt) {
		DataConnection query = new DataConnection();
		String sql = "INSERT INTO chinhanh(tenchinhanh, diachi, sdt) VALUES ('" + tenchinhanh + "', '" + diachi + "', " + sdt + ")";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void suaChiNhanh(String tencn, String newtencn, String diachi, int sdt) {
		DataConnection query = new DataConnection();
		String sql = "UPDATE chinhanh SET tenchinhanh = '" + newtencn + "' , diachi = '" + diachi + "', sdt = " + sdt + " WHERE tenchinhanh = '" + tencn + "' ";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void xoaChiNhanh(String tencn) {
		DataConnection query = new DataConnection();
		String sql = "DELETE FROM chinhanh WHERE tenchinhanh = '" + tencn + "' ";
		query.setQuery(sql);
		query.doQuery();
	}
//	public static void main(String[] args) {
//		ChiNhanhModel cm = new ChiNhanhModel();
//		ResultSet rs = cm.showChiNhanhSelected("Hiệu thuốc số 1");
//		System.out.println("hello");
//		try {
//			while(rs.next()) {
//				System.out.println(rs.getString("macn") + rs.getString("tenchinhanh")+rs.getString("diachi")+rs.getInt("sdt"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
