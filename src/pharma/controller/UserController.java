package pharma.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javafx.collections.ListChangeListener;
import pharma.model.*;
import pharma.mvc.InterfaceRMI;
import pharma.view.*;

public class UserController {
	private UserModel theUserModel = new UserModel();
	private ViewLogin theLoginView;
	private boolean resultLogin = false;
	private DuocSiView theDuocSiView;
	InterfaceRMI objLogin;
	
	public UserController() {
		
	}
	
	public UserController(UserModel theUserModel, ViewLogin theLoginView) {
		try {
			LocateRegistry.createRegistry(1099);
			LocateRegistry.getRegistry();
			LoginModel loginModel = new LoginModel();
			Naming.rebind("Login", loginModel);
			System.out.println("RMI server is now started...");
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.theUserModel = theUserModel;
		this.theLoginView = theLoginView;
		this.theLoginView.clickLoginListener(new LoginListener());
		this.theLoginView.enterToGo(new LoginListener());
	}
	
	public void showWindowQuanLiDuocSi() {
		this.theDuocSiView = new DuocSiView("Quản lí dược sĩ");
		this.theDuocSiView.clickThemDuocSi(new ThemListener());
		this.theDuocSiView.clickSuaDuocSi(new SuaListener());
		this.theDuocSiView.clickXoaDuocSi(new XoaListener());
		this.theDuocSiView.clickClear(new ClearListener());
		//this.theDuocSiView.selectedRowTable(new SelectListener());
		this.theDuocSiView.setLocationRelativeTo(null);
		this.theDuocSiView.setVisible(true);
	}
	
	public String[] setListChiNhanh() {
		return theUserModel.showChiNhanh();
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
				try
				{
						//bind object to RMI registry with ATMmachine as name
					objLogin =(InterfaceRMI)Naming.lookup("Login");
					objLogin.checkLogin(username, password);
					if (objLogin.getLoginResult() == true) {
						HomeController theHomeController = new HomeController(sessionName());
						theLoginView.dispose();
					} else {
						theLoginView.displayErrorMessage("Sai tài khoản hoặc mật khẩu");
					}
				}
				catch(Exception ee)
				{
					System.out.println("Server Error : "+ee.getMessage());
				}
			}
		}
	}
	
	public boolean loginSuccess() {
		return resultLogin;
	}
	
	class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (theDuocSiView.getHoten().isEmpty() || theDuocSiView.getSDT().isEmpty() || theDuocSiView.getChucvu().isEmpty() || theDuocSiView.getGioitinh().isEmpty() || theDuocSiView.getNamsinh().isEmpty()) {
				theDuocSiView.displayMessage("Vui lòng nhập đầy đủ thông tin");
			} else {
				try {
					String tencn = theDuocSiView.getItemComboBox();
					String hoten = theDuocSiView.getHoten();
					int sdt = Integer.parseInt(theDuocSiView.getSDT());
					String chucvu = theDuocSiView.getChucvu();
					String gioitinh = theDuocSiView.getGioitinh();
					String namsinh = theDuocSiView.getNamsinh();
					if (gioitinh.equals("Nam") || gioitinh.equals("Nu")) {
						theUserModel.themNhanVien(hoten, sdt, chucvu, gioitinh, namsinh, tencn);
						theDuocSiView.addRowTableModel(theUserModel.showDuocSi());
						theDuocSiView.displayMessage("Thêm dược sĩ thành công");
					} else {
						theDuocSiView.displayMessage("Giới tính chỉ nhập \"Nam\" hoặc \"Nu\"");
					}
				} catch (Exception e2) {
					theDuocSiView.displayMessage("Nhập sai định dạng SDT, vui lòng nhập lại");
				}
			}
			
		}
	}
	
	class SuaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (theDuocSiView.getHoten().isEmpty() || theDuocSiView.getSDT().isEmpty() || theDuocSiView.getChucvu().isEmpty() || theDuocSiView.getGioitinh().isEmpty() || theDuocSiView.getNamsinh().isEmpty()) {
				theDuocSiView.displayMessage("Vui lòng nhập đầy đủ thông tin");
			} else {
				try {
					int uid = Integer.parseInt(theDuocSiView.getMaDuocSi());
					String tencn = theDuocSiView.getItemComboBox();
					String hoten = theDuocSiView.getHoten();
					int sdt = Integer.parseInt(theDuocSiView.getSDT());
					String chucvu = theDuocSiView.getChucvu();
					String gioitinh = theDuocSiView.getGioitinh();
					String namsinh = theDuocSiView.getNamsinh();
					if (gioitinh.equals("Nam") || gioitinh.equals("Nu")) {
						theUserModel.suaNhanVien(uid,hoten, sdt, chucvu, gioitinh, namsinh, tencn);
						theDuocSiView.updateRowSelectedTable();
						theDuocSiView.displayMessage("sửa dược sĩ thành công");
					} else {
						theDuocSiView.displayMessage("Giới tính chỉ nhập \"Nam\" hoặc \"Nu\"");
					}
				} catch (Exception e2) {
					theDuocSiView.displayMessage("Nhập sai định dạng SDT, vui lòng nhập lại");
				}
			}
		}
	}
	
	class XoaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Xác nhận xóa dược sĩ?", "Thoát", JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION) {
            	theUserModel.xoaNhanVien(Integer.parseInt(theDuocSiView.getMaDuocSi()));
            	//theDuocSiView.removeRowSelectedTable();
    			theDuocSiView.dispose();
    			showWindowQuanLiDuocSi();
            }
		}
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theDuocSiView.setAllClear();
		}
	}
	
//	class SelectListener implements ListSelectionListener {
//
//		@Override
//		public void valueChanged(ListSelectionEvent e) {
//			theDuocSiView.textHoten.setText(theDuocSiView.table.getValueAt(theDuocSiView.table.getSelectedRow(), 1).toString());
//		}
//		
//	}
	
	public ResultSet setListDuocSi() {
		return theUserModel.showDuocSi();
	}
	
	public String sessionName() {
		return theLoginView.getUsername();
	}
}
