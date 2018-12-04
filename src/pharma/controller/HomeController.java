package pharma.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import pharma.model.*;
import pharma.view.*;
import truyenfile.view.*;

public class HomeController {
	private HomeView theHomeView;
	private String sessionName;
	
	public HomeController(String sessionName) {
		this.sessionName = sessionName;
		this.theHomeView = new HomeView("Home - Nhà Thuốc Hòa Linh");
		this.theHomeView.setSesionName(sessionName);
		this.theHomeView.setLocationRelativeTo(null);
		this.theHomeView.clickNhapHangListener(new NhapHangListener());
		this.theHomeView.clickXuatHangListener(new XuatHangListener());
		this.theHomeView.clickKhoListener(new KhoListener());
		this.theHomeView.clickNhanVienListener(new NhanVienListener());
		this.theHomeView.clickChiNhanhListener(new ChiNhanhListener());
		this.theHomeView.clickThoatListener(new ThoatListener());
		this.theHomeView.clickChatListener(new ChatListener());
		this.theHomeView.clickFileTransferListener(new FileTransferListener());
		this.theHomeView.setVisible(true);
	}
	
	class NhapHangListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ProductController theProducController = new ProductController();
			theProducController.showWindow();
		}
	}
	
	class XuatHangListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			HoadonController theHdController = new HoadonController();
			theHdController.showXuatKhoView();
		}
	}
	
	class KhoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ProductController theProducController = new ProductController();
			theProducController.showKhoView();
		}
	}
	
	class NhanVienListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			UserController theUserController = new UserController();
			theUserController.showWindowQuanLiDuocSi();
		}
	}
	
	class ChiNhanhListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ChiNhanhController theChiNhanhController = new ChiNhanhController();
			theChiNhanhController.showWindowQuanLiChiNhanh();
		}
	}
	
	class ThoatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát chương trình?", "Thoát", JOptionPane.YES_NO_OPTION);
            if(ret==JOptionPane.YES_OPTION)
                System.exit(0);
		}
	}
	
	class ChatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ChatView theChatView = new ChatView();
			theChatView.setUsername(sessionName);
			theChatView.setLocationRelativeTo(null);
			theChatView.setVisible(true);
		}
	}
	
	class FileTransferListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(() -> new FileTransferClient()).start();
		}
	}
	
}
