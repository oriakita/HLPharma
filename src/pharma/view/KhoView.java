package pharma.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class KhoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhoView frame = new KhoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KhoView() {
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 280, 714, 270);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(297, 25, 200, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setBounds(160, 28, 127, 14);
		panel_1.add(lblTnSnPhm);
		
		textField_1 = new JTextField();
		textField_1.setBounds(297, 56, 200, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGiBn = new JLabel("Giá bán:");
		lblGiBn.setBounds(160, 59, 127, 14);
		panel_1.add(lblGiBn);
		
		textField_2 = new JTextField();
		textField_2.setBounds(297, 87, 200, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGiVn = new JLabel("Giá vốn:");
		lblGiVn.setBounds(160, 90, 127, 14);
		panel_1.add(lblGiVn);
		
		textField_3 = new JTextField();
		textField_3.setBounds(297, 118, 200, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTnKho = new JLabel("Tồn kho:");
		lblTnKho.setBounds(160, 121, 127, 14);
		panel_1.add(lblTnKho);
		
		textField_4 = new JTextField();
		textField_4.setBounds(297, 149, 200, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp: ");
		lblNhCungCp.setBounds(160, 152, 127, 14);
		panel_1.add(lblNhCungCp);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBounds(297, 214, 89, 23);
		panel_1.add(btnCpNht);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(408, 214, 89, 23);
		panel_1.add(btnXa);
	}
}
