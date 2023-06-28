package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class UserUpdate extends JFrame {
	static final String DB_URL = "jdbc:mysql://localhost/income_tax";
	static final String USER = "root";
	static final String PASS = "Mysql@123";
	Connection conn = null;
	Statement stmt = null;

	private JPanel contentPane;
	private JTextField MobNo;
	private JTextField Address;
	private JTextField EmailId;
	private JTextField job;
	private JTextField business;
	private JTextField property;
	private JTextField PanId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdate frame = new UserUpdate();
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
	public UserUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// frame = new JFrame();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 600, 550);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Income Tax Database");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(104, 10, 373, 50);
		contentPane.add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBounds(74, 70, 430, 376);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2_2_1 = new JLabel("Address");
		lblNewLabel_2_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(10, 71, 110, 28);
		panel.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_2_2_2 = new JLabel("Mobile No.");
		lblNewLabel_2_2_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_2.setBounds(10, 21, 110, 28);
		panel.add(lblNewLabel_2_2_2);

		JLabel lblNewLabel_2_2_3 = new JLabel("Email ID");
		lblNewLabel_2_2_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_3.setBounds(10, 128, 110, 28);
		panel.add(lblNewLabel_2_2_3);

		JLabel lblNewLabel_2_2_3_1 = new JLabel("Job Income");
		lblNewLabel_2_2_3_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_3_1.setBounds(10, 181, 110, 28);
		panel.add(lblNewLabel_2_2_3_1);

		JLabel lblNewLabel_2_2_3_1_1 = new JLabel("Business Income");
		lblNewLabel_2_2_3_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_3_1_1.setBounds(10, 231, 149, 28);
		panel.add(lblNewLabel_2_2_3_1_1);

		JLabel lblNewLabel_2_2_3_1_2 = new JLabel("Property Income");
		lblNewLabel_2_2_3_1_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_3_1_2.setBounds(10, 282, 149, 28);
		panel.add(lblNewLabel_2_2_3_1_2);

		JLabel lblNewLabel_2_2_3_1_2_1 = new JLabel("Pan Number");
		lblNewLabel_2_2_3_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_3_1_2_1.setBounds(10, 338, 149, 28);
		panel.add(lblNewLabel_2_2_3_1_2_1);

		PanId = new JTextField();
		PanId.setColumns(10);
		PanId.setBounds(169, 338, 235, 28);
		panel.add(PanId);

		MobNo = new JTextField();
		MobNo.setColumns(10);
		MobNo.setBounds(170, 21, 235, 28);
		panel.add(MobNo);

		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(170, 71, 235, 28);
		panel.add(Address);

		EmailId = new JTextField();
		EmailId.setColumns(10);
		EmailId.setBounds(170, 128, 235, 28);
		panel.add(EmailId);

		job = new JTextField();
		job.setColumns(10);
		job.setBounds(170, 181, 235, 28);
		panel.add(job);

		business = new JTextField();
		business.setColumns(10);
		business.setBounds(169, 231, 235, 28);
		panel.add(business);

		property = new JTextField();
		property.setColumns(10);
		property.setBounds(169, 282, 235, 28);
		panel.add(property);

		PanId = new JTextField();
		PanId.setColumns(10);
		PanId.setBounds(169, 338, 235, 28);
		panel.add(PanId);

		JButton btnNewButton = new JButton("UPDATE INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String New_MobNo, New_EmailId, New_Address, Job, Business, Property, New_PanId;
				New_MobNo = MobNo.getText();
				New_EmailId = EmailId.getText();
				New_Address = Address.getText();
				Job = job.getText();
				Business = business.getText();
				Property = property.getText();
				New_PanId = PanId.getText();

				try {

					// to check if the driver is working and the user name and password match;
					// if not, throw exception
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("connecting to the database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();

					// New_PanId = PanId.getText();
					// System.out.println(New_PanId);

					PreparedStatement prep_stmt;
					PreparedStatement prep_stmt1;

					String query = "update taxpayer set MobNo = " + New_MobNo + ", EmailId = '" + New_EmailId
							+ "', Address = '" + New_Address + "' where PanId = '" + New_PanId+"'";
					String q2 = "update incomedetails set Job = " + Job + ", Business = " + Business + ", Property = "
							+ Property + " where incomedetails.PanId = '" + New_PanId+"'";
					prep_stmt = conn.prepareStatement(query);
					prep_stmt.execute();
					prep_stmt1 = conn.prepareStatement(q2);
					prep_stmt1.execute();

				} catch (Exception x) {
					System.out.println(x);
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(10, 457, 259, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Side u = new User_Side();
				u.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBackground(UIManager.getColor("Button.shadow"));
		btnBack.setBounds(291, 456, 259, 31);
		contentPane.add(btnBack);
	}
}
