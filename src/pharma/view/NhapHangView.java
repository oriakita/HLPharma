package pharma.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import pharma.controller.ProductController;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;

public class NhapHangView extends JFrame {
	private JPanel contentPane;
	private JTextField textTenSanPham, textGiaNhap, textSoLuong;
	private JList<String> list;
	private JComboBox<String> comboBox; 
	private DefaultListModel<String> listNcc = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> comboBoxNcc = new DefaultComboBoxModel<String>();
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnThemNcc, btnSuaNcc, btnXoaNcc, btnThemSanPham, btnClear;
	private String strSelected = "";
	private JTextField textGiaBan;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhapHangView frame = new NhapHangView("home");
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
	public NhapHangView(String title) {
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 600);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.ORANGE);
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		//mnFile.setForeground(Color.WHITE);
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("exit");
		mnFile.add(mntmExit);

		JMenu mnKho = new JMenu("Kho");
		menuBar.add(mnKho);

		JMenuItem mntmQunLKho = new JMenuItem("Quản lí kho");
		mnKho.add(mntmQunLKho);

		JMenu mnGiaoDch = new JMenu("Giao dịch");
		menuBar.add(mnGiaoDch);

		JMenuItem mntmQunLNhp = new JMenuItem("Quản lí nhập hàng");
		mnGiaoDch.add(mntmQunLNhp);

		JMenuItem mntmQunLXut = new JMenuItem("Quản lí xuất hàng");
		mnGiaoDch.add(mntmQunLXut);

		JMenuItem mntmHan = new JMenuItem("Hóa đơn");
		mnGiaoDch.add(mntmHan);

		JMenu mnNhnVin = new JMenu("Nhân viên");
		menuBar.add(mnNhnVin);

		JMenuItem mntmQunLDc = new JMenuItem("Quản lí dược sĩ");
		mnNhnVin.add(mntmQunLDc);

		JMenu mnChiNhnh = new JMenu("Chi nhánh");
		menuBar.add(mnChiNhnh);

		JMenuItem mntmQunL = new JMenuItem("Quản lí");
		mnChiNhnh.add(mntmQunL);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAboutHlPharma = new JMenuItem("About HL Pharma");
		mnHelp.add(mntmAboutHlPharma);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 270, 377);
		contentPane.add(scrollPane);

		setTenNcc(new ProductController().setListNCCs());
		list = new JList<String>();
		list.setModel(listNcc);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedIndex() != -1)
					strSelected = list.getModel().getElementAt(list.getSelectedIndex());
				else
					strSelected = "";
			}
		});
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 453, 270, 75);
		Border borderNhaCungCap = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder titleBorderNcc = new TitledBorder(borderNhaCungCap, "Nhà cung cấp");
		panel.setBorder(titleBorderNcc);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnThemNcc = new JButton("Thêm");
		btnThemNcc.setForeground(Color.WHITE);
		btnThemNcc.setBackground(new Color(40, 167, 69));
		panel.add(btnThemNcc);

		btnSuaNcc = new JButton("Sửa");
		btnSuaNcc.setForeground(Color.WHITE);
		btnSuaNcc.setBackground(new Color(0, 123, 255));
		panel.add(btnSuaNcc);

		btnXoaNcc = new JButton("Xóa");
		btnXoaNcc.setForeground(Color.WHITE);
		btnXoaNcc.setBackground(new Color(220, 53, 69));
		panel.add(btnXoaNcc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(290, 317, 708, 211);
		Border borderSanPham = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder titleBorderSP = new TitledBorder(borderSanPham, "Nhập Sản Phẩm");
		panel_1.setBorder(titleBorderSP);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
				
				comboBox = new JComboBox<String>();
				comboBox.setModel(comboBoxNcc);
				comboBox.setBounds(260, 11, 205, 22);
				panel_1.add(comboBox);
				
				JLabel lblNhCungCp = new JLabel("Nhà cung cấp:");
				lblNhCungCp.setBounds(152, 11, 96, 14);
				panel_1.add(lblNhCungCp);
				
				textTenSanPham = new JTextField();
				textTenSanPham.setBounds(260, 43, 206, 20);
				panel_1.add(textTenSanPham);
				textTenSanPham.setColumns(10);
						
				JLabel lblTnSnPhm = new JLabel("Tên sản phẩm");
				lblTnSnPhm.setBounds(151, 44, 98, 14);
				panel_1.add(lblTnSnPhm);
				
				textGiaNhap = new JTextField();
				textGiaNhap.setBounds(260, 73, 205, 20);
				panel_1.add(textGiaNhap);
				textGiaNhap.setColumns(10);
				
				JLabel lblGiNhp = new JLabel("Giá nhập:");
				lblGiNhp.setBounds(152, 75, 74, 14);
				panel_1.add(lblGiNhp);
				
				textSoLuong = new JTextField();
				textSoLuong.setBounds(260, 135, 205, 20);
				panel_1.add(textSoLuong);
				textSoLuong.setColumns(10);
				
				JLabel lblSLng = new JLabel("Số lượng: ");
				lblSLng.setBounds(152, 139, 74, 14);
				panel_1.add(lblSLng);
				
				btnThemSanPham = new JButton("Thêm");
				btnThemSanPham.setBounds(260, 171, 95, 29);
				btnThemSanPham.setForeground(Color.WHITE);
				btnThemSanPham.setBackground(new Color(40, 167, 69));
				panel_1.add(btnThemSanPham);
				
				btnClear = new JButton("Clear");
				btnClear.setBounds(376, 170, 89, 29);
				btnClear.setBackground(Color.WHITE);
				panel_1.add(btnClear);
				
				textGiaBan = new JTextField();
				textGiaBan.setBounds(260, 104, 205, 20);
				panel_1.add(textGiaBan);
				textGiaBan.setColumns(10);
				
				JLabel lblGiBn = new JLabel("Giá bán: ");
				lblGiBn.setBounds(152, 107, 74, 14);
				panel_1.add(lblGiBn);

		JLabel lblQunLNhp = new JLabel("QUẢN LÍ NHẬP HÀNG");
		lblQunLNhp.setForeground(Color.ORANGE);
		lblQunLNhp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLNhp.setBounds(400, 0, 252, 52);
		contentPane.add(lblQunLNhp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(290, 65, 708, 241);
		contentPane.add(scrollPane_1);
		
		try {
			tableModel = buildTableModel(new ProductController().setListSanPham());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable();
		table.setModel(tableModel);
		table.setRowHeight(40);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(5);
		columnModel.getColumn(1).setPreferredWidth(155);
		columnModel.getColumn(2).setPreferredWidth(20);
		columnModel.getColumn(3).setPreferredWidth(30);
		columnModel.getColumn(4).setPreferredWidth(30);
		columnModel.getColumn(5).setPreferredWidth(10);
		columnModel.getColumn(6).setPreferredWidth(80);
		table.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table);
	}
	
	public void clickThemNcc(ActionListener listenForBtnThemNcc) {
		btnThemNcc.addActionListener(listenForBtnThemNcc);
	}
	
	public void clickSuaNcc(ActionListener listenForBtnSuaNcc) {
		btnSuaNcc.addActionListener(listenForBtnSuaNcc);
	}
	
	public void clickXoaNcc(ActionListener listenForBtnXoaNcc) {
		btnXoaNcc.addActionListener(listenForBtnXoaNcc);
	}
	
	public String getTenNcc() {
		return strSelected;
	}
	
	public String getNewTenNcc() {
		String tenncc = "";
		tenncc = JOptionPane.showInputDialog("Nhập tên nhà cung cấp mới: ");
		listNcc.addElement(tenncc);
		comboBoxNcc.addElement(tenncc);
		return tenncc;
	}
	
	public void setTenNcc(String[] arrayTenncc) {
		listNcc.removeAllElements();
		comboBoxNcc.removeAllElements();
		for(int index = 0; index < arrayTenncc.length; index++) {
			listNcc.addElement(arrayTenncc[index]);
			comboBoxNcc.addElement(arrayTenncc[index]);
		}
	}
	
	public String getItemComboBox() {
		String item = comboBox.getSelectedItem().toString();
		return item;
	}
	
	public String getTenSanPham() {
		return textTenSanPham.getText();
	}
	
	public String getGiaNhap() {
		return textGiaNhap.getText();
	}
	
	public String getGiaBan() {
		return textGiaBan.getText();
	}
	
	public String getSoLuong() {
		return textSoLuong.getText();
	}
	
	public void setAllClear() {
		textTenSanPham.setText("");
		textGiaNhap.setText("");
		textGiaBan.setText("");
		textSoLuong.setText("");
	}
	
	public void clickThemSanPham(ActionListener listenForBtn) {
		btnThemSanPham.addActionListener(listenForBtn);
	}
	
	public void clickClear(ActionListener listenForBtnClear) {
		btnClear.addActionListener(listenForBtnClear);
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

	    // names of columns
//	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
//	    for (int column = 1; column <= columnCount; column++) {
//	        columnNames.add(metaData.getColumnName(column));
//	    }
	    Vector<String> tableHeader = new Vector<String>();
	    tableHeader.add("Mã SP");
	    tableHeader.add("Tên sản phẩm");
	    tableHeader.add("Giá bán (vnd)");
	    tableHeader.add("Giá vốn (vnd)");
	    tableHeader.add("Số lượng nhập");
	    tableHeader.add("Mã NCC");
	    tableHeader.add("Thời gian");
	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        	if (columnIndex != 7) vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, tableHeader);

	}
	
	public void updateTableModel(ResultSet rs) {
		try {
			rs.last();
			tableModel.addRow(new Object[] {rs.getInt("masp"), rs.getString("tensp"), rs.getInt("giaban"), rs.getInt("giavon"), rs.getInt("slnhap"), rs.getInt("mancc"), rs.getString("time")});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
