package pharma.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import pharma.database.DataConnection;

public class ProductModel {
	
	public void themNhaCungCap(String tenncc) {
		DataConnection query = new DataConnection();
		String sql = "insert into nhacungcap(mancc, tenncc) values (null, '" + tenncc + "')";
		query.setQuery(sql);
		query.doQuery();
	}

	public String[] showNhaCungCap() {
		try {
			DataConnection query = new DataConnection();
			String sql = "select * from nhacungcap";
			query.setQuery(sql);
			ResultSet rs = query.getAllRow();
			ArrayList<String> a = new ArrayList<>();
			while (rs.next()) {
				a.add(rs.getString("tenncc"));
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
	
	public void suaNhaCungCap(String tenncc, String newtenncc) {
		DataConnection query = new DataConnection();
		String sql = "UPDATE nhacungcap SET tenncc = '" + newtenncc + "' WHERE tenncc = '" + tenncc + "' ";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void xoaNhaCungCap(String tenncc) {
		DataConnection query = new DataConnection();
		String sql = "DELETE FROM nhacungcap WHERE tenncc = '" + tenncc + "' ";
		query.setQuery(sql);
		query.doQuery();
	}
	
	public void themSanPham(String tensp,int giaban, int giavon, int slnhap, String tenncc) {
		DataConnection query2 = new DataConnection();
		String sql = "INSERT INTO product(tensp, giaban, giavon, slnhap, mancc) "
				+ "SELECT '" + tensp + "', '" + giaban + "', '" + giavon + "', '" + slnhap + "', mancc FROM nhacungcap WHERE tenncc = '" + tenncc + "' LIMIT 1";
		query2.setQuery(sql);
		query2.doQuery();
	}
	
	public ResultSet showSanPham() {
		DataConnection query = new DataConnection();
		String sql = "SELECT * FROM product";
		query.setQuery(sql);
		ResultSet rs = query.getAllRow();
		return rs;
	}
	
//	public static void main(String[] args) {
//		ProductModel s = new ProductModel();
//		ResultSet test = s.showSanPham();
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
