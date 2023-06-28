package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// frame = new JFrame();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 600, 550);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Income Tax Database");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(105, 10, 373, 50);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(139, 185, 300, 234);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("USER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Side u = new User_Side();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(111, 236, 242));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNewButton.setBounds(89, 45, 126, 53);
		panel.add(btnNewButton);

		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin a = new AdminLogin();
				a.setVisible(true);
			}
		});
		btnAdmin.setBackground(new Color(111, 236, 242));
		btnAdmin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnAdmin.setBounds(89, 139, 126, 53);
		panel.add(btnAdmin);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 105, 160, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("WELCOME!");
		lblNewLabel_2_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(0, 0, 160, 38);
		panel_1.add(lblNewLabel_2_1);

	}

}
