package pharma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import pharma.model.*;
import pharma.view.*;

public class ChiNhanhController {
	private ChiNhanhModel theCnModel = new ChiNhanhModel();
	private ChiNhanhView theCnView;
	
	public ChiNhanhController() {}
	
	public void showWindowQuanLiChiNhanh() {
		theCnView = new ChiNhanhView("Quản lí chi nhánh");
		theCnView.clickThemChiNhanh(new ThemListener());
		theCnView.clickSuaChiNhanh(new SuaListener());
		theCnView.clickXoaChiNhanh(new XoaListener());
		theCnView.clickClear(new ClearListener());
		theCnView.setLocationRelativeTo(null);
		theCnView.setVisible(true);
	}

	public String[] setListChiNhanh() {
		return theCnModel.showChiNhanh();
	}
	
	public void setValueTextField(String tencn) {
		ResultSet rs = theCnModel.showChiNhanhSelected(tencn);
	}
	
	class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	class SuaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	class XoaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theCnView.setAllClear();
		}
	}
}

