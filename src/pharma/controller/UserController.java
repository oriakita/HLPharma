package pharma.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pharma.model.*;
import pharma.view.*;

public class UserController {
	private UserModel theUserModel;
	private ViewLogin theLoginView;
	private boolean resultLogin = false;
	
	public UserController(UserModel theUserModel, ViewLogin theLoginView) {
		this.theUserModel = theUserModel;
		this.theLoginView = theLoginView;
		this.theLoginView.clickLoginListener(new LoginListener());
		this.theLoginView.enterToGo(new LoginListener());
	}
	
	class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String username, password = "";
			username = theLoginView.getUsername();
			password = theLoginView.getPassword();
			if (username.isEmpty() || password.isEmpty() ) {
				theLoginView.displayErrorMessage("Tài khoản và mật khẩu không được để trống!");
			} else {
				theUserModel.checkLogin(username, password);
				if (theUserModel.getLoginResult() == true) {
					HomeController theHomeController = new HomeController();
					theLoginView.dispose();
				} else {
					theLoginView.displayErrorMessage("Sai tài khoản hoặc mật khẩu");
				}
			}
		}
	}
	
	public boolean loginSuccess() {
		return resultLogin;
	}
}
