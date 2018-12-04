package pharma.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JButton;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private JButton btnNhapHang, btnXuatHang, btnKho, btnNhanVien, btnChiNhanh, btnThoat, btnFileTransfer;
	private JButton btnChat;
	private JLabel lbSessionName;
	private JButton btnDangXuat;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeView frame = new HomeView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public HomeView(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhnMmQun = new JLabel("PHẦN MÊM QUẢN LÍ NHÀ THUỐC TƯ NHÂN");
		lblPhnMmQun.setForeground(Color.ORANGE);
		lblPhnMmQun.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhnMmQun.setBounds(60, 11, 378, 32);
		contentPane.add(lblPhnMmQun);
		
		btnNhapHang = new JButton("Nhập hàng");
		btnNhapHang.setBackground(Color.WHITE);
		btnNhapHang.setBounds(48, 98, 120, 55);
		contentPane.add(btnNhapHang);
		
		btnXuatHang = new JButton("Xuất hàng");
		btnXuatHang.setBackground(Color.WHITE);
		btnXuatHang.setBounds(308, 98, 120, 55);
		contentPane.add(btnXuatHang);
		
		btnNhanVien = new JButton("Dược Sĩ");
		btnNhanVien.setBackground(Color.WHITE);
		btnNhanVien.setBounds(48, 184, 120, 55);
		contentPane.add(btnNhanVien);
		
		btnChiNhanh = new JButton("Chi nhánh");
		btnChiNhanh.setBackground(Color.WHITE);
		btnChiNhanh.setBounds(180, 184, 120, 55);
		contentPane.add(btnChiNhanh);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setBounds(180, 265, 120, 55);
		contentPane.add(btnThoat);
		
		btnKho = new JButton("Kho");
		btnKho.setBackground(Color.WHITE);
		btnKho.setBounds(180, 98, 120, 55);
		contentPane.add(btnKho);
		
		btnChat = new JButton("Chat hệ thống");
		btnChat.setBackground(Color.WHITE);
		btnChat.setBounds(308, 184, 120, 55);
		contentPane.add(btnChat);
		
		JLabel lblcopyright = new JLabel("\u00a9 Copyright - 2018 by Huỳnh Nhật Hòa ft. Lê Thị Linh");
		lblcopyright.setBounds(60, 380, 368, 20);
		contentPane.add(lblcopyright);
		
		lbSessionName = new JLabel("New label");
		lbSessionName.setForeground(Color.BLUE);
		lbSessionName.setBounds(48, 54, 250, 14);
		contentPane.add(lbSessionName);
		
		btnFileTransfer = new JButton("Truyền File");
		btnFileTransfer.setBackground(Color.WHITE);
		btnFileTransfer.setBounds(48, 265, 120, 55);
		contentPane.add(btnFileTransfer);
		
//		btnDangXuat = new JButton("Đăng xuất");
//		btnDangXuat.setBackground(Color.WHITE);
//		btnDangXuat.setBounds(180, 266, 120, 55);
//		contentPane.add(btnDangXuat);
	}
	
	public void clickNhapHangListener(ActionListener listenForBtn) {
		btnNhapHang.addActionListener(listenForBtn);
	}
	
	public void clickXuatHangListener(ActionListener listenForBtn) {
		btnXuatHang.addActionListener(listenForBtn);
	}
	
	public void clickKhoListener(ActionListener listenForBtn) {
		btnKho.addActionListener(listenForBtn);
	}
	
	public void clickNhanVienListener(ActionListener listenForBtn) {
		btnNhanVien.addActionListener(listenForBtn);
	}
	
	public void clickChiNhanhListener(ActionListener listenForBtn) {
		btnChiNhanh.addActionListener(listenForBtn);
	}
	
	public void clickThoatListener(ActionListener listenForBtn) {
		btnThoat.addActionListener(listenForBtn);
	}
	
	public void clickChatListener(ActionListener listenForBtn) {
		btnChat.addActionListener(listenForBtn);
	}
	
	public void clickFileTransferListener(ActionListener listenForBtn) {
		btnFileTransfer.addActionListener(listenForBtn);
	}
	
	public void setSesionName(String ses) {
		lbSessionName.setText("Xin chào, " + ses);
	}
}
