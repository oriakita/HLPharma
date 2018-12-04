package pharma.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import pharma.view.*;
import pharma.model.*;

public class ProductController {
	private ProductModel theProductModel = new ProductModel();
	private NhapHangView theNhapHangView;
	private KhoView theKhoView;
	
	public void showWindow() {
		this.theNhapHangView = new NhapHangView("Quản lí nhập thuốc");
		this.theNhapHangView.clickThemNcc(new ThemNccListener());
		this.theNhapHangView.clickSuaNcc(new SuaNccListener());
		this.theNhapHangView.clickXoaNcc(new XoaNccListener());
		this.theNhapHangView.clickThemSanPham(new ThemSanPhamListener());
		this.theNhapHangView.clickClear(new ClearListener());
		this.theNhapHangView.setLocationRelativeTo(null);
		this.theNhapHangView.setVisible(true);
	}
	
	public void showKhoView() {
		this.theKhoView = new KhoView("Quản lí kho thuốc");
		this.theKhoView.clickSua(new SuaSpListener());
		this.theKhoView.clickxoa(new XoaSpListener());
		this.theKhoView.setLocationRelativeTo(null);
		this.theKhoView.setVisible(true);
	}
	
	public String[] setListNCCs() {
		return this.theProductModel.showNhaCungCap();
	}
	
	public ResultSet setListSanPham() {
		return this.theProductModel.showSanPham();
	}
	
	public ResultSet setListSanPhamKho() {
		return this.theProductModel.showSanPhamKho();
	}
	
	class ThemNccListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theProductModel.themNhaCungCap(theNhapHangView.getNewTenNcc());
		}
	}
	
	class SuaNccListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theProductModel.suaNhaCungCap(theNhapHangView.getTenNcc(), theNhapHangView.getNewTenNcc());
			theNhapHangView.setTenNcc(theProductModel.showNhaCungCap());
		}
	}
	
	class XoaNccListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Xác nhận xóa nhà cung cấp?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION) {
				theProductModel.xoaNhaCungCap(theNhapHangView.getTenNcc());
				theNhapHangView.setTenNcc(theProductModel.showNhaCungCap());
            }
		}
	}
	
	class ThemSanPhamListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (theNhapHangView.getTenSanPham().isEmpty() || theNhapHangView.getGiaBan().isEmpty() || theNhapHangView.getGiaNhap().isEmpty() || theNhapHangView.getSoLuong().isEmpty() ) {
				theNhapHangView.displayErrorMessage("Vui lòng nhập đầy đủ thông tin");
			} else {
				try {
					String tenncc = theNhapHangView.getItemComboBox();
					String tensp = theNhapHangView.getTenSanPham();
					int giaban = Integer.parseInt(theNhapHangView.getGiaBan());
					int gianhap = Integer.parseInt(theNhapHangView.getGiaNhap());
					int soluong = Integer.parseInt(theNhapHangView.getSoLuong());
					theProductModel.themSanPham(tensp, giaban, gianhap, soluong, tenncc);
					theNhapHangView.updateTableModel(theProductModel.showSanPham());
				} catch (Exception e2) {
					theNhapHangView.displayErrorMessage("Nhập sai định dạng, vui lòng nhập lại!");
				}
			}
		}
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			theNhapHangView.setAllClear();
		}
	}
	
	class SuaSpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (theKhoView.getTensp().isEmpty() || theKhoView.getGiaban().isEmpty() || theKhoView.getGiavon().isEmpty()) {
				theKhoView.displayMessage("Thiếu dữ liệu cần thiết");
			} else {
				try {
					int masp = Integer.parseInt(theKhoView.getMaSpSelected());
					String tensp = theKhoView.getTensp();
					int giaban = Integer.parseInt(theKhoView.getGiaban());
					int giavon = Integer.parseInt(theKhoView.getGiavon());
					theProductModel.suaSanPham(masp, tensp, giaban, giavon);
				} catch (Exception e2) {
					theKhoView.displayMessage("Sai định dạng dữ liệu");
				}
				theKhoView.updateRowTable();
				theKhoView.displayMessage("Cập nhật thành công");
			}
		}
	}
	
	class XoaSpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String tensp = theKhoView.getTensp();
			int ret = JOptionPane.showConfirmDialog(null, "Xóa sản phẩm \"" + tensp + "\"?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION) {
				theProductModel.xoaSanPham(Integer.parseInt(theKhoView.getMaSpSelected()));
				theKhoView.removeRowTable();
				theKhoView.displayMessage("Xóa sản phẩm thành công");
            }
		}
	}
	
//	public static void main(String[] args) {
//		ProductController pc = new ProductController();
//		pc.showWindow();
//	}

}
