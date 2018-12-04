package pharma.mvc;

import pharma.controller.*;
import pharma.view.*;
import pharma.model.*;

public class MVCPharma {
	public static void main(String[] args) {
		UserModel theModel = new UserModel();
		ViewLogin theLogin = new ViewLogin("Đăng nhập");
		UserController theController = new UserController(theModel, theLogin);
		theLogin.setLocationRelativeTo(null);
		theLogin.setVisible(true);
	} 
}