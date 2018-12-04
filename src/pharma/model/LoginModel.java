package pharma.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pharma.database.DataConnection;
import pharma.mvc.InterfaceRMI;

public class LoginModel extends UnicastRemoteObject implements InterfaceRMI {
	
	public LoginModel() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean result = false;
	
	public void checkLogin(String username, String password) throws RemoteException {
		DataConnection query = new DataConnection();
		String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";
		query.setQuery(sql);
		if(query.countRow() > 0) {
			result = true;
		} else {
			result = false;
		}
	}
	
	public boolean getLoginResult() throws RemoteException {
		return result;
	}
}
