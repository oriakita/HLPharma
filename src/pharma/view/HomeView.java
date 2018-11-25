package pharma.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JButton;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private JButton btnNhapHang, btnXuatHang, btnKho, btnNhanVien, btnChiNhanh, btnThoat;

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
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhnMmQun = new JLabel("PHẦN MÊM QUẢN LÍ HIỆU THUỐC TƯ NHÂN");
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
		
		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBackground(Color.WHITE);
		btnNhanVien.setBounds(48, 184, 120, 55);
		contentPane.add(btnNhanVien);
		
		btnChiNhanh = new JButton("Chi nhánh");
		btnChiNhanh.setBackground(Color.WHITE);
		btnChiNhanh.setBounds(180, 184, 120, 55);
		contentPane.add(btnChiNhanh);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.WHITE);
		btnThoat.setBounds(308, 184, 120, 55);
		contentPane.add(btnThoat);
		
		btnKho = new JButton("Kho");
		btnKho.setBackground(Color.WHITE);
		btnKho.setBounds(180, 98, 120, 55);
		contentPane.add(btnKho);
		
		JLabel lblcopyright = new JLabel("@Copyright - 2018");
		lblcopyright.setBounds(60, 323, 112, 14);
		contentPane.add(lblcopyright);
	}
	
	public void clickNhapHangListener(ActionListener listenForBtnNhapHang) {
		btnNhapHang.addActionListener(listenForBtnNhapHang);
	}
	
	public void clickXuatHangListener(ActionListener listenForBtnXuatHang) {
		btnXuatHang.addActionListener(listenForBtnXuatHang);
	}
	
	public void clickKhoListener(ActionListener listenForBtnKho) {
		btnKho.addActionListener(listenForBtnKho);
	}
	
	public void clickNhanVienListener(ActionListener listenForBtnNhanVien) {
		btnNhanVien.addActionListener(listenForBtnNhanVien);
	}
	
	public void clickChiNhanhListener(ActionListener listenForBtnChiNhanh) {
		btnChiNhanh.addActionListener(listenForBtnChiNhanh);
	}
	
	public void clickThoatListener(ActionListener listenForBtnThoat) {
		btnThoat.addActionListener(listenForBtnThoat);
	}

}
