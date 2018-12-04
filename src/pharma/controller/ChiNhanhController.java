package pharma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

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
	
	public ResultSet setValueTextField(String tencn) {
		ResultSet rs = theCnModel.showChiNhanhSelected(tencn);
		return rs;
	}
	
	class ThemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(theCnView.getTencn().isEmpty() || theCnView.getDiachi().isEmpty() || theCnView.getSdt().isEmpty()) {
				theCnView.displayErrorMessage("Vui lòng nhập đầy đủ thông tin");
			} else {
				try {
					String tencn = theCnView.getTencn();
					String diachi = theCnView.getDiachi();
					int sdt = Integer.parseInt(theCnView.getSdt());
					theCnModel.themChiNhanh(tencn, diachi, sdt);
					theCnView.setListChiNhanh(theCnModel.showChiNhanh());
				} catch (Exception e2) {
					theCnView.displayErrorMessage("Nhập sai định dạng vui lòng nhập lại");
				}
			}
			
		}
	}
	
	class SuaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String tencn = theCnView.getTencnFromList();
			if (theCnView.getTencn().isEmpty() || theCnView.getDiachi().isEmpty() || theCnView.getSdt().isEmpty()) {
				theCnView.displayErrorMessage("Vui lòng nhập đày đủ thông tin");
			} else {
				try {
					String newtencn = theCnView.getTencn();
					String newdiachi = theCnView.getDiachi();
					int newsdt = Integer.parseInt(theCnView.getSdt());
					theCnModel.suaChiNhanh(tencn, newtencn, newdiachi, newsdt);
					theCnView.setListChiNhanh(theCnModel.showChiNhanh());
					theCnView.displayErrorMessage("Sửa chi nhánh thành công");
				} catch (Exception e2) {
					theCnView.displayErrorMessage("Nhập sai định dạng vui lòng nhập lại");
				}
			}
			
		}
	}
	
	class XoaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String tencn = theCnView.getTencnFromList();
			int ret = JOptionPane.showConfirmDialog(null, "Xóa \"" + tencn + "\" ?", "Thoát", JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION) {
    			theCnModel.xoaChiNhanh(tencn);
    			theCnView.setListChiNhanh(theCnModel.showChiNhanh());
				theCnView.displayErrorMessage("Xóa " + tencn + " thành công");
            }
		}
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theCnView.setAllClear();
		}
	}
}

