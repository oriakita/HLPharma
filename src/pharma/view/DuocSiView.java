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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import pharma.controller.ProductController;
import pharma.controller.UserController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class DuocSiView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textHoten, textSDT, textChucvu, textGioitinh, textNamsinh;
	private JButton btnThem, btnSua, btnXoa, btnClear;
	private JList<String> list;
	private JComboBox<String> comboBox;
	private DefaultListModel<String> listChiNhanh = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> comboBoxChiNhanh = new DefaultComboBoxModel<String>();
	private DefaultTableModel tableModel = new DefaultTableModel();
	private String strSelected;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DuocSiView frame = new DuocSiView("Quản lí Dược Sĩ");
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
	public DuocSiView(String title) {
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuanLyDuocSi = new JLabel("QUẢN LÍ DƯỢC SĨ");
		lblQuanLyDuocSi.setForeground(Color.ORANGE);
		lblQuanLyDuocSi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuanLyDuocSi.setBounds(400, 0, 252, 52);
		contentPane.add(lblQuanLyDuocSi);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 85, 252, 515);
		Border borderChiNhanh = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder titleBorderChiNhanh = new TitledBorder(borderChiNhanh, "Danh sách chi nhánh: ");
		panel.setBorder(titleBorderChiNhanh);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 232, 479);
		panel.add(scrollPane);
		
		setListChiNhanh(new UserController().setListChiNhanh());
		list = new JList<String>();
		list.setModel(listChiNhanh);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(272, 85, 662, 236);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 662, 236);
		panel_1.add(scrollPane_1);
		try {
			tableModel = buildTableModel(new UserController().setListDuocSi());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable();
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(40);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(5);
		scrollPane_1.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(272, 332, 662, 268);
		Border borderNhanVien = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder titleBorderNhanVien = new TitledBorder(borderNhanVien, "Thông tin nhân viên");
		panel_2.setBorder(titleBorderNhanVien);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(comboBoxChiNhanh);
		comboBox.setBounds(235, 23, 205, 22);
		panel_2.add(comboBox);
		
		JLabel lblChiNhnh = new JLabel("Chi nhánh: ");
		lblChiNhnh.setBounds(120, 27, 105, 14);
		panel_2.add(lblChiNhnh);
		
		textHoten = new JTextField();
		textHoten.setBounds(235, 56, 205, 20);
		panel_2.add(textHoten);
		textHoten.setColumns(10);
		
		JLabel lblTnDcS = new JLabel("Tên dược sĩ:");
		lblTnDcS.setBounds(120, 59, 105, 14);
		panel_2.add(lblTnDcS);
		
		textSDT = new JTextField();
		textSDT.setBounds(235, 87, 205, 20);
		panel_2.add(textSDT);
		textSDT.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số điện thoại:");
		lblNewLabel.setBounds(120, 90, 105, 14);
		panel_2.add(lblNewLabel);
		
		textChucvu = new JTextField();
		textChucvu.setBounds(235, 118, 205, 20);
		panel_2.add(textChucvu);
		textChucvu.setColumns(10);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setBounds(120, 121, 105, 14);
		panel_2.add(lblChcV);
		
		textGioitinh = new JTextField();
		textGioitinh.setBounds(235, 149, 205, 20);
		panel_2.add(textGioitinh);
		textGioitinh.setColumns(10);
		
		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setBounds(120, 152, 105, 14);
		panel_2.add(lblGiiTnh);
		
		textNamsinh = new JTextField();
		textNamsinh.setBounds(235, 180, 205, 20);
		panel_2.add(textNamsinh);
		textNamsinh.setColumns(10);
		
		JLabel lblNmSinh = new JLabel("Năm sinh:");
		lblNmSinh.setBounds(120, 183, 105, 14);
		panel_2.add(lblNmSinh);
		
		//SET giá trị các textField khi select hàng trong JTABLE
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            textHoten.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            textSDT.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            textChucvu.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            textGioitinh.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
	            textNamsinh.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
	        }
	    });
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(40, 167, 69));
		btnThem.setBounds(120, 226, 105, 31);
		panel_2.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(0, 123, 255));
		btnSua.setBounds(235, 226, 105, 31);
		panel_2.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(220, 53, 69));
		btnXoa.setBounds(350, 226, 105, 31);
		panel_2.add(btnXoa);
		
		btnClear = new JButton("Clear");
		btnClear.setForeground(Color.DARK_GRAY);
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(466, 226, 105, 31);
		panel_2.add(btnClear);
	}
	
	public String getMaDuocSi() {
		String t = table.getValueAt(table.getSelectedRow(), 0).toString();
		return t;
	}
	
	public void updateRowSelectedTable() {
		int index = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (index >= 0 ) {
			model.setValueAt(getHoten(), index, 1);
			model.setValueAt(getSDT(), index, 2);
			model.setValueAt(getChucvu(), index, 3);
			model.setValueAt(getGioitinh(), index, 4);
			model.setValueAt(getNamsinh(), index, 5);
		} else {
			JOptionPane.showMessageDialog(null, "Có lỗi khi sửa hàng trong table");
		}
	}
	
	public void removeRowSelectedTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();


	       try{
	       int SelectedRowIndex = table.getSelectedRow();
	       if (SelectedRowIndex >=0) {
	    	   model.removeRow(SelectedRowIndex);
		       table.getSelectionModel().clearSelection();
	       } else {
	    	   JOptionPane.showMessageDialog(null, "error");
	       }
	       }catch(Exception ex)
	       {
	           JOptionPane.showMessageDialog(null, ex + "--Có lỗi nhưng vẫn xóa thành công");
	       }
	}
	
	public void setListChiNhanh(String[] arrayTenncc) {
		listChiNhanh.removeAllElements();
		comboBoxChiNhanh.removeAllElements();
		for(int index = 0; index < arrayTenncc.length; index++) {
			listChiNhanh.addElement(arrayTenncc[index]);
			comboBoxChiNhanh.addElement(arrayTenncc[index]);
		}
	}
	
	public String getTenChiNhanh() {
		return strSelected;
	}
	
	public void clickThemDuocSi(ActionListener listenForBtn) {
		btnThem.addActionListener(listenForBtn);
	}
	
	public void clickSuaDuocSi(ActionListener listenForBtn) {
		btnSua.addActionListener(listenForBtn);
	}
	
	public void clickXoaDuocSi(ActionListener listenForBtn) {
		btnXoa.addActionListener(listenForBtn);
	}
	
	public void clickClear(ActionListener listenForBtn) {
		btnClear.addActionListener(listenForBtn);
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
	    tableHeader.add("Mã");
	    tableHeader.add("Họ và tên");
	    tableHeader.add("SDT");
	    tableHeader.add("Chức vụ");
	    tableHeader.add("Giới tính");
	    tableHeader.add("Năm sinh");
	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= (columnCount-2); columnIndex++) {
	        	if(columnIndex == 2 || columnIndex == 3 ) {
	        		
	        	} else {
	        		vector.add(rs.getObject(columnIndex));
	        	}
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, tableHeader);

	}
	
	public void addRowTableModel(ResultSet rs) {
		try {
			rs.last();
			tableModel.addRow(new Object[] {rs.getInt("uid"), rs.getString("hoten"), rs.getInt("sdt"), rs.getString("chucvu"), rs.getString("gioitinh"), rs.getString("namsinh")});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getItemComboBox() {
		String item = comboBox.getSelectedItem().toString();
		return item;
	}
	
	public String getHoten() {
		return textHoten.getText();
	}
	
	public String getSDT() {
		return textSDT.getText();
	}
	
	public String getChucvu() {
		return textChucvu.getText();
	}
	
	public String getGioitinh() {
		return textGioitinh.getText();
	}
	
	public String getNamsinh() {
		return textNamsinh.getText();
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public void setAllClear() {
		textHoten.setText("");
		textSDT.setText("");
		textChucvu.setText("");
		textGioitinh.setText("");
		textNamsinh.setText("");
	}
	
	public void selectedRowTable(ListSelectionListener listenForSelect) {
		table.getSelectionModel().addListSelectionListener(listenForSelect);
	}
}
