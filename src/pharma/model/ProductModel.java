package pharma.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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

}
