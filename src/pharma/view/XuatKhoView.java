package pharma.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import pharma.controller.HoadonController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class XuatKhoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField textMasp;
	private JTextField textKhachhang;
	private JTextField textSoluong;
	private JButton btnThem, btnSua;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					XuatKhoView frame = new XuatKhoView("xuat kho");
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
	public XuatKhoView(String title) {
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(250, 250, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 764, 230);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 764, 230);
		panel.add(scrollPane);
		
		try {
			tableModel = buildTableModel(new HoadonController().setListHoaDon());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable();
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(35);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(5);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	int mahd = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
	        	setAllText(new HoadonController().setValueTextField(mahd));
	        }
	    });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 301, 764, 249);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textMasp = new JTextField();
		textMasp.setBounds(296, 11, 210, 20);
		panel_1.add(textMasp);
		textMasp.setColumns(10);
		
		JLabel lblMSp = new JLabel("Mã sp:");
		lblMSp.setBounds(196, 14, 90, 14);
		panel_1.add(lblMSp);
		
		textKhachhang = new JTextField();
		textKhachhang.setBounds(296, 43, 210, 20);
		panel_1.add(textKhachhang);
		textKhachhang.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setBounds(196, 46, 90, 14);
		panel_1.add(lblTnKhchHng);
		
		textSoluong = new JTextField();
		textSoluong.setBounds(296, 78, 210, 20);
		panel_1.add(textSoluong);
		textSoluong.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số lượng");
		lblNewLabel.setBounds(196, 81, 90, 14);
		panel_1.add(lblNewLabel);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(40, 167, 69));
		btnThem.setBounds(196, 131, 89, 23);
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(0, 123, 255));
		btnSua.setBounds(305, 131, 89, 23);
		panel_1.add(btnSua);
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(417, 131, 89, 23);
		panel_1.add(btnClear);
		
		JLabel lblQunLXut = new JLabel("QUẢN LÝ XUẤT KHO");
		lblQunLXut.setForeground(Color.ORANGE);
		lblQunLXut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLXut.setBounds(290, 11, 298, 38);
		contentPane.add(lblQunLXut);
	}
	public int getMahd() {
		int mahd = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		return mahd;
	}
	
	public String getMasp() {
		return textMasp.getText();
	}
	
	public String getKhachhang() {
		return textKhachhang.getText();
	}
	
	public String getSoluong() {
		return textSoluong.getText();
	}
	
	public void setAllClear() {
		textMasp.setText("");
		textKhachhang.setText("");
		textSoluong.setText("");
	}
	
	public void setAllText(ResultSet rs) {
		try {
			while(rs.next()) {
				textMasp.setText(rs.getString("masp"));
				textKhachhang.setText(rs.getString("nguoimua"));
				textSoluong.setText(rs.getString("slmua"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

	    int columnCount = metaData.getColumnCount();
	    Vector<String> tableHeader = new Vector<String>();
	    tableHeader.add("Mã hóa đơn");
	    tableHeader.add("Tên sản phẩm");
	    tableHeader.add("Khách hàng");
	    tableHeader.add("Số lượng");
	    tableHeader.add("Thời gian");
	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        	vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    return new DefaultTableModel(data, tableHeader);
	}
	
	public void addRowTableModel(ResultSet rs) {
		try {
			rs.last();
			tableModel.addRow(new Object[] {rs.getInt("mahd"), rs.getString("tensp"), rs.getString("nguoimua"), rs.getInt("slmua"), rs.getString("time")});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRowTable(ResultSet rs) {
		String tensp = "";
		try {
			while(rs.next()) {
				tensp = rs.getString("tensp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int index = table.getSelectedRow();
		tableModel = (DefaultTableModel) table.getModel();
		if (index >= 0 ) {
			tableModel.setValueAt(tensp, index, 1);
			tableModel.setValueAt(getKhachhang(), index, 2);
			tableModel.setValueAt(getSoluong(), index, 3);
		} else {
			JOptionPane.showMessageDialog(null, "Có lỗi khi sửa hàng trong table");
		}
	}
	
	public void clickSua(ActionListener listenForBtn) {
		btnSua.addActionListener(listenForBtn);
	}
	
	public void clickThem(ActionListener listenForBtn) {
		btnThem.addActionListener(listenForBtn);
	}
	
	public void clickClear(ActionListener listenForBtn) {
		btnClear.addActionListener(listenForBtn);
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
