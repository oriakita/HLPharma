package pharma.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewLogin frame = new ViewLogin("Đăng nhập");
//					frame.setLocationRelativeTo(null); 
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
	public ViewLogin(String title) {
		setTitle(title);
		setResizable(false);
		setBackground(Color.WHITE);
		setSize(new Dimension(450, 440));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setSize(new Dimension(400, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLHiu = new JLabel("PHẦN MỀM QUẢN LÝ HIỆU THUỐC");
		lblQunLHiu.setForeground(Color.ORANGE);
		lblQunLHiu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLHiu.setBounds(21, 25, 352, 32);
		contentPane.add(lblQunLHiu);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(86, 115, 80, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(86, 181, 113, 14);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(86, 140, 228, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(86, 209, 228, 20);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setBounds(133, 266, 120, 32);
		contentPane.add(btnLogin);
	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText().toString();
	}
	
	public void clickLoginListener(ActionListener listenForLoginBtn) {
		btnLogin.addActionListener(listenForLoginBtn);
	}
	
	public void enterToGo(ActionListener listenForEnter) {
		passwordField.addActionListener(listenForEnter);
		usernameField.addActionListener(listenForEnter);
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
