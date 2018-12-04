package pharma.model;

import java.sql.ResultSet;

import pharma.database.DataConnection;

public class HoadonModel {
	public ResultSet showHoadon() {
		DataConnection query = new DataConnection();
		String sql = "SELECT h.mahd, p.tensp, h.nguoimua, h.slmua, h.time FROM hoadon AS h, product AS p WHERE h.masp = p.masp";
		query.setQuery(sql);
		ResultSet rs = query.getAllRow();
		return rs;
	}
	
	public ResultSet showHoadonSelected(int mahd) {
		DataConnection query = new DataConnection();
		String sql = "SELECT * FROM hoadon WHERE mahd = " + mahd + " ";
		query.setQuery(sql);
		ResultSet rs = query.getAllRow();
		return rs;
	}
	
	public ResultSet showHoadonSelectedCoTenSp(int mahd) {
		DataConnection query = new DataConnection();
		String sql = "SELECT h.mahd, p.tensp, h.nguoimua, h.slmua, h.time FROM hoadon AS h, product AS p WHERE h.masp = p.masp AND h.mahd = " + mahd + "";
		query.setQuery(sql);
		ResultSet rs = query.getAllRow();
		return rs;
	}
	
	public void themHoadon(int masp, String khachhang, int soluong) {
		DataConnection query = new DataConnection();
		String sql = "INSERT INTO hoadon(masp, nguoimua, slmua) VALUES ( " + masp + ", '" + khachhang + "', " + soluong + ")";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void suaHoadon(int mahd, int masp, String khachhang, int soluong) {
		DataConnection query = new DataConnection();
		String sql = "UPDATE hoadon SET masp = " + masp + ", nguoimua = '" + khachhang + "', slmua = " + soluong + " WHERE mahd = " + mahd + "";
		query.setQuery(sql);
		query.doQuery();
	}
}
