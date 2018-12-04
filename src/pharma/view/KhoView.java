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

import pharma.controller.ProductController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class KhoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textTensp, textGiaban, textGiavon, textTonkho, textNcc;
	private JButton btnSua, btnXoa;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField textMasp;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					KhoView frame = new KhoView();
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
	public KhoView(String title) {
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(250, 250, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLKho = new JLabel("QUẢN LÝ KHO");
		lblQunLKho.setForeground(Color.ORANGE);
		lblQunLKho.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLKho.setBounds(291, 11, 177, 27);
		contentPane.add(lblQunLKho);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 38, 714, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 714, 231);
		panel.add(scrollPane);
		
		try {
			tableModel = buildTableModel(new ProductController().setListSanPhamKho());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = new JTable();
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(40);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(5);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(2).setPreferredWidth(20);
		columnModel.getColumn(3).setPreferredWidth(30);
		columnModel.getColumn(4).setPreferredWidth(5);
		columnModel.getColumn(5).setPreferredWidth(30);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 280, 714, 270);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textTensp = new JTextField();
		textTensp.setBounds(297, 25, 200, 20);
		panel_1.add(textTensp);
		textTensp.setColumns(10);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setBounds(160, 28, 127, 14);
		panel_1.add(lblTnSnPhm);
		
		textGiaban = new JTextField();
		textGiaban.setBounds(297, 56, 200, 20);
		panel_1.add(textGiaban);
		textGiaban.setColumns(10);
		
		JLabel lblGiBn = new JLabel("Giá bán:");
		lblGiBn.setBounds(160, 59, 127, 14);
		panel_1.add(lblGiBn);
		
		textGiavon = new JTextField();
		textGiavon.setBounds(297, 87, 200, 20);
		panel_1.add(textGiavon);
		textGiavon.setColumns(10);
		
		JLabel lblGiVn = new JLabel("Giá vốn:");
		lblGiVn.setBounds(160, 90, 127, 14);
		panel_1.add(lblGiVn);
		
		textTonkho = new JTextField();
		textTonkho.setEditable(false);
		textTonkho.setBounds(297, 118, 200, 20);
		panel_1.add(textTonkho);
		textTonkho.setColumns(10);
		
		JLabel lblTnKho = new JLabel("Tồn kho:");
		lblTnKho.setBounds(160, 121, 127, 14);
		panel_1.add(lblTnKho);
		
		textNcc = new JTextField();
		textNcc.setEditable(false);
		textNcc.setBounds(297, 149, 200, 20);
		panel_1.add(textNcc);
		textNcc.setColumns(10);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp: ");
		lblNhCungCp.setBounds(160, 152, 127, 14);
		panel_1.add(lblNhCungCp);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setBackground(new Color(0, 123, 255));
		btnSua.setBounds(297, 214, 89, 23);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(220, 53, 69));
		btnXoa.setBounds(408, 214, 89, 23);
		panel_1.add(btnXoa);
		
		textMasp = new JTextField();
		textMasp.setEditable(false);
		textMasp.setBounds(560, 25, 86, 20);
		panel_1.add(textMasp);
		textMasp.setColumns(10);
		
		JLabel lblM = new JLabel("-   Mã:");
		lblM.setBounds(507, 28, 43, 14);
		panel_1.add(lblM);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            textMasp.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            textTensp.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            textGiaban.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            textGiavon.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            textTonkho.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
	            textNcc.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
	        }
	    });
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
	    tableHeader.add("Tồn kho");
	    tableHeader.add("NCC");
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
	
	public void updateRowTable() {
		int index = table.getSelectedRow();
		tableModel = (DefaultTableModel) table.getModel();
		if (index >= 0 ) {
			tableModel.setValueAt(getTensp(), index, 1);
			tableModel.setValueAt(getGiaban(), index, 2);
			tableModel.setValueAt(getGiavon(), index, 3);
		} else {
			JOptionPane.showMessageDialog(null, "Có lỗi khi sửa hàng trong table");
		}
	}
	
	public void removeRowTable() {
		tableModel = (DefaultTableModel) table.getModel();
		try {
			int index = table.getSelectedRow();
			tableModel.removeRow(index);
		} catch (Exception myerror1) {
			System.out.println(myerror1);
		}
	}
	
	public String getMaSpSelected() {
		String t = table.getValueAt(table.getSelectedRow(), 0).toString();
		return t;
	}
	
	public void clickSua(ActionListener listenForBtn) {
		btnSua.addActionListener(listenForBtn);
	}
	
	public void clickxoa(ActionListener listenForBtn) {
		btnXoa.addActionListener(listenForBtn);
	}
	
	public String getMasp() {
		return textMasp.getText();
	}
	
	public String getTensp() {
		return textTensp.getText();
	}
	
	public String getGiaban() {
		return textGiaban.getText();
	}
	
	public String getGiavon() {
		return textGiavon.getText();
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
