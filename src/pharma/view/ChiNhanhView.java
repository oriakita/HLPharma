package pharma.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pharma.controller.*;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class ChiNhanhView extends JFrame {

	private JPanel contentPane;
	private JTextField textMacn, textTencn, textDiachi, textSdt;
	private JButton btnThem, btnSua, btnXoa, btnClear;
	private JList<String> list;
	private DefaultListModel<String> listChiNhanh = new DefaultListModel<String>();
	private String strSelected;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChiNhanhView frame = new ChiNhanhView("Quản lí chi nhánh");
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
	public ChiNhanhView(String title) {
		setTitle(title);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLChi = new JLabel("QUẢN LÍ CHI NHÁNH NHÀ THUỐC");
		lblQunLChi.setForeground(Color.ORANGE);
		lblQunLChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQunLChi.setBounds(203, 11, 321, 27);
		contentPane.add(lblQunLChi);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 48, 220, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 200, 270);
		panel.add(scrollPane);
		setListChiNhanh(new ChiNhanhController().setListChiNhanh());
		list = new JList<String>();
		list.setModel(listChiNhanh);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedIndex() != -1) {
					strSelected = list.getModel().getElementAt(list.getSelectedIndex());
					setAllText(new ChiNhanhController().setValueTextField(strSelected));
				} else {
					strSelected = "";
				}
			}
		});
		scrollPane.setViewportView(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(240, 49, 434, 301);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textMacn = new JTextField();
		textMacn.setBounds(154, 35, 70, 20);
		panel_1.add(textMacn);
		textMacn.setColumns(10);
		
		JLabel lblMChiNhnh = new JLabel("Mã chi nhánh:");
		lblMChiNhnh.setBounds(46, 38, 98, 14);
		panel_1.add(lblMChiNhnh);
		
		textTencn = new JTextField();
		textTencn.setBounds(154, 66, 245, 20);
		panel_1.add(textTencn);
		textTencn.setColumns(10);
		
		JLabel lblTnChiNhnh = new JLabel("Tên chi nhánh:");
		lblTnChiNhnh.setBounds(46, 69, 98, 14);
		panel_1.add(lblTnChiNhnh);
		
		textDiachi = new JTextField();
		textDiachi.setBounds(154, 97, 245, 20);
		panel_1.add(textDiachi);
		textDiachi.setColumns(10);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setBounds(46, 100, 98, 14);
		panel_1.add(lblaCh);
		
		textSdt = new JTextField();
		textSdt.setBounds(154, 128, 245, 20);
		panel_1.add(textSdt);
		textSdt.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại: ");
		lblSinThoi.setBounds(46, 131, 98, 14);
		panel_1.add(lblSinThoi);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(40, 167, 69));
		btnThem.setBounds(25, 235, 98, 23);
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(0, 123, 255));
		btnSua.setBounds(133, 235, 91, 23);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(220, 53, 69));
		btnXoa.setBounds(234, 235, 91, 23);
		panel_1.add(btnXoa);
		
		btnClear = new JButton("Clear");
		btnClear.setForeground(Color.DARK_GRAY);
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(335, 235, 89, 23);
		panel_1.add(btnClear);
	}
	
	public void setListChiNhanh(String[] arrayTenncc) {
		listChiNhanh.removeAllElements();
		for(int index = 0; index < arrayTenncc.length; index++) {
			listChiNhanh.addElement(arrayTenncc[index]);
		}
	}
	
	public String getTencnFromList() {
		return strSelected;
	}
	
	public String getMacn() {
		return textMacn.getText();
	}
	
	public String getTencn() {
		return textTencn.getText();
	}
	
	public String getDiachi() {
		return textDiachi.getText();
	}
	
	public String getSdt() {
		return textSdt.getText();
	}
	
	public void clickThemChiNhanh(ActionListener listenForBtn) {
		btnThem.addActionListener(listenForBtn);
	}
	
	public void clickSuaChiNhanh(ActionListener listenForBtn) {
		btnSua.addActionListener(listenForBtn);
	}
	
	public void clickXoaChiNhanh(ActionListener listenForBtn) {
		btnXoa.addActionListener(listenForBtn);
	}
	
	public void clickClear(ActionListener listenForBtn) {
		btnClear.addActionListener(listenForBtn);
	}
	
	public void setAllClear() {
		textMacn.setText("");
		textTencn.setText("");
		textDiachi.setText("");
		textSdt.setText("");
	}
	
	public void setAllText(ResultSet rs) {
		try {
			while(rs.next()) {
				textMacn.setText(rs.getString("macn"));
				textTencn.setText(rs.getString("tenchinhanh"));
				textDiachi.setText(rs.getString("diachi"));
				textSdt.setText(rs.getString("sdt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
