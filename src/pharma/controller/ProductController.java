package pharma.controller;

import java.sql.SQLException;

import pharma.view.*;
import pharma.model.*;

public class ProductController {
	private ProductModel theProductModel = new ProductModel();
	private NhapHangView theNhapHangView;
	
	public void showWindow() {
		this.theNhapHangView = new NhapHangView("Quản lí nhập thuốc");
		this.theNhapHangView.setLocationRelativeTo(null);
		this.theNhapHangView.setVisible(true);
	}
	
	public String[] setListNCCs() {
		return this.theProductModel.showNhaCungCap();
	}
	
//	public static void main(String[] args) {
//		ProductController pc = new ProductController();
//		pc.showWindow();
//	}

}
