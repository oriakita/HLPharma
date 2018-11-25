package pharma.model;
import pharma.database.DataConnection;

public class UserModel {
	
	private boolean result = false;
	
	public void checkLogin(String username, String password) {
		DataConnection query = new DataConnection();
		String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";
		query.setQuery(sql);
		if(query.countRow() > 0) {
			result = true;
		} else {
			result = false;
		}
	}
	
	public boolean getLoginResult() {
		return result;
	}
	
}
