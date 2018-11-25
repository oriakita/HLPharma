package pharma.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import pharma.controller.ProductController;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class NhapHangView extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JList<String> list;

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
		mnFile.setForeground(Color.WHITE);
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

		list = new JList<String>(new ProductController().setListNCCs());
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 453, 270, 75);
		Border borderPhongBan = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder titleBorder = new TitledBorder(borderPhongBan, "Nhà cung cấp");
		panel.setBorder(titleBorder);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnThm = new JButton("Thêm");
		panel.add(btnThm);

		JButton btnNewButton = new JButton("Sửa");
		panel.add(btnNewButton);

		JButton btnXa = new JButton("Xóa");
		panel.add(btnXa);

		JLabel lblQunLNhp = new JLabel("QUẢN LÍ NHẬP HÀNG");
		lblQunLNhp.setForeground(Color.ORANGE);
		lblQunLNhp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQunLNhp.setBounds(400, 0, 252, 52);
		contentPane.add(lblQunLNhp);

		table = new JTable();
		table.setBounds(290, 65, 708, 241);
		contentPane.add(table);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(506, 317, 205, 22);
		contentPane.add(comboBox);

		JLabel lblNhCungCp = new JLabel("Nhà cung cấp:");
		lblNhCungCp.setBounds(400, 321, 96, 14);
		contentPane.add(lblNhCungCp);

		textField = new JTextField();
		textField.setBounds(505, 350, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm");
		lblTnSnPhm.setBounds(398, 353, 98, 14);
		contentPane.add(lblTnSnPhm);
	}
	
	public void setListNCC(String[] a) {
		
	}
}
