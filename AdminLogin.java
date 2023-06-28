package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {
	Connection conn = null;
	Statement stmt = null;

	private JPanel contentPane;
	private JTextField AdminName;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		//frame = new JFrame();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 600, 550);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Income Tax Database");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(103, 10, 373, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(74, 184, 430, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 26, 110, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 94, 110, 28);
		panel.add(lblNewLabel_2);
		
		AdminName = new JTextField();
		AdminName.setColumns(10);
		AdminName.setBounds(152, 26, 235, 28);
		panel.add(AdminName);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(152, 94, 235, 28);
		panel.add(Password);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 105, 160, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ADMIN");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(43, 0, 62, 38);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String DB_URL = "jdbc:mysql://localhost/income_tax";
					String USER = "root";
					String PASS = "Mysql@123";
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("connecting to the database");
					
					String admin_name = AdminName.getText();
					String password = Password.getText();
					int pass = Integer.parseInt(password);
					int x = 1234;
					if (pass == x) {
						Admin_op admin = new Admin_op();
						admin.setVisible(true);
						dispose();
					} else {
						JOptionPane.showInputDialog(this, "NAME AND PASSWORD DON'T MATCH");
						lblNewLabel_1.setText(" ");
						lblNewLabel_2.setText(" ");
						conn.close();
					}
				} catch (Exception x) {
					System.out.println(x);
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 64, 0));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setBounds(238, 389, 100, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				m.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(0, 64, 0));
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBackground(UIManager.getColor("Button.shadow"));
		btnBack.setBounds(238, 442, 100, 31);
		contentPane.add(btnBack);
	}

}
