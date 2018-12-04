package pharma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import pharma.model.HoadonModel;
import pharma.view.XuatKhoView;

public class HoadonController {
	private HoadonModel theHdModel = new HoadonModel();
	private XuatKhoView theXKView;
	public void showXuatKhoView() {
		this.theXKView = new XuatKhoView("Quản lí xuất kho");
		this.theXKView.clickThem(new ThemListener());
		this.theXKView.clickSua(new SuaListener());
		this.theXKView.clickClear(new ClearListener());
		this.theXKView.setLocationRelativeTo(null);
		this.theXKView.setVisible(true);
	}
	
	public ResultSet setListHoaDon() {
		return theHdModel.showHoadon();
	}
	
	public ResultSet setValueTextField(int mahd) {
		return theHdModel.showHoadonSelected(mahd);
	}
	
	class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(theXKView.getMasp().isEmpty() || theXKView.getKhachhang().isEmpty() || theXKView.getSoluong().isEmpty() ) {
				theXKView.displayMessage("Lỗi: thiếu dữ liệu!");
			} else {
				try {
					int masp = Integer.parseInt(theXKView.getMasp());
					String khachhang = theXKView.getKhachhang();
					int soluong = Integer.parseInt(theXKView.getSoluong());
					theHdModel.themHoadon(masp, khachhang, soluong);
					theXKView.addRowTableModel(theHdModel.showHoadon());
					theXKView.displayMessage("Thêm thành công!");
				} catch (Exception e2) {
					theXKView.displayMessage("Sai định dạng dữ liệu");
				}
			}
		}
	}
	
	class SuaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(theXKView.getMasp().isEmpty() || theXKView.getKhachhang().isEmpty() || theXKView.getSoluong().isEmpty() ) {
				theXKView.displayMessage("Lỗi: thiếu dữ liệu!");
			} else {
				try {
					int mahd = theXKView.getMahd();
					int masp = Integer.parseInt(theXKView.getMasp());
					String khachhang = theXKView.getKhachhang();
					int soluong = Integer.parseInt(theXKView.getSoluong());
					theHdModel.suaHoadon(mahd, masp, khachhang, soluong);
					theXKView.updateRowTable(theHdModel.showHoadonSelectedCoTenSp(mahd));
					theXKView.displayMessage("Sửa thành công!");
				} catch (Exception e2) {
					theXKView.displayMessage("Sai định dạng dữ liệu");
				}
			}
		}
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theXKView.setAllClear();
		}
	}
}
