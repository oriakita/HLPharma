package pharma.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import truyenfile.view.FileTransferClient;

public class RunTruyenFile extends JFrame {

	public RunTruyenFile() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		JButton btn = new JButton("Run");
		add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("row 1");
				new Thread(() -> new FileTransferClient()).start();
				System.out.println("row 2");
			}
		});
	}

	public static void main(String[] args) {
		RunTruyenFile t = new RunTruyenFile();
		t.setLocationRelativeTo(null);
		t.setVisible(true);
	}
}
