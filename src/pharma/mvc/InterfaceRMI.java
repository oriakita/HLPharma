package pharma.mvc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote{
	default void checkLogin(String username, String password) throws RemoteException {};
	boolean getLoginResult() throws RemoteException;
}
