package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class New_User extends JFrame {
	
	static final String DB_URL = "jdbc:mysql://localhost/income_tax";
	static final String USER = "root";
	static final String PASS = "Mysql@123";
	Connection conn = null;
	Statement stmt = null;

	private JPanel contentPane;
	private JTextField Name;
	private JTextField PanId;
	private JTextField AadharId;
	private JTextField Address;
	private JTextField MobNo;
	private JTextField EmailId;
	private JTextField job;
	private JTextField business;
	private JTextField property;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_User frame = new New_User();
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
	public New_User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//frame = new JFrame();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 1000, 650);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Income Tax Database");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(306, 10, 373, 50);
		contentPane.add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBounds(20, 120, 912, 364);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 21, 110, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pan Number");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 71, 110, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Aadhaar ID");
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(10, 128, 110, 28);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Address");
		lblNewLabel_2_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBounds(10, 181, 110, 28);
		panel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Mobile No.");
		lblNewLabel_2_2_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_2.setBounds(10, 231, 110, 28);
		panel.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Email ID");
		lblNewLabel_2_2_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_2_3.setBounds(10, 282, 110, 28);
		panel.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Job Income");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(487, 84, 110, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Business Income");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(487, 150, 148, 28);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Property Income");
		lblNewLabel_1_1_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(487, 212, 148, 28);
		panel.add(lblNewLabel_1_1_2);
	
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(198, 21, 235, 28);
		panel.add(Name);
		
		PanId = new JTextField();
		PanId.setColumns(10);
		PanId.setBounds(198, 71, 235, 28);
		panel.add(PanId);
		
		AadharId = new JTextField();
		AadharId.setColumns(10);
		AadharId.setBounds(198, 128, 235, 28);
		panel.add(AadharId);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(198, 186, 235, 28);
		panel.add(Address);
		
		MobNo = new JTextField();
		MobNo.setColumns(10);
		MobNo.setBounds(198, 236, 235, 28);
		panel.add(MobNo);
		
		EmailId = new JTextField();
		EmailId.setColumns(10);
		EmailId.setBounds(198, 291, 235, 28);
		panel.add(EmailId);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(667, 89, 235, 28);
		panel.add(job);
		
		business = new JTextField();
		business.setColumns(10);
		business.setBounds(667, 159, 235, 28);
		panel.add(business);
		
		property = new JTextField();
		property.setColumns(10);
		property.setBounds(667, 221, 235, 28);
		panel.add(property);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(365, 70, 229, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("USER INFORMATION");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(32, 0, 192, 38);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String New_Name, New_PanId, New_AadharId, New_MobNo, New_EmailId, New_Address;
				int Job, Business, Property;
				New_Name = Name.getText();
				New_PanId = PanId.getText();
				New_AadharId = AadharId.getText();
				New_MobNo = MobNo.getText();
				New_EmailId = EmailId.getText();
				New_Address = Address.getText();
				Job = Integer.parseInt(job.getText());
				Business = Integer.parseInt(business.getText());
				Property = Integer.parseInt(property.getText());

				int total_income = Job + Business + Property;

				try {
					// to check if the driver is working and the user name and password match;
					// if not, throw exception
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("connecting to the database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();

					String query = " insert into taxpayer(PanId, AadharId, Name, Address, MobNo, EmailId)"
							+ " values(?,?,?,?,?,?) ";

					String query1 = " update IncomeDetails set Total_Income = " + total_income;
					//String query6 = " update tax_calculation set Total_Income = " + total_income;

					String query2 = " insert into incomedetails(PanId, Job, Business, Property, Total_Income)"
							+ " values(?,?,?,?,?) ";

					String query3 = " insert into tax_calculation(PanId, total_income, tax_bracket, liability)"
							+ "values(? ,?, ?, ?) ";

					String query4 = " call tax_bracket()";
					
					String query5 = " call tax_calculation()";

					PreparedStatement prep_stmt;
					PreparedStatement prep_stmt1;
					PreparedStatement prep_stmt2;
					PreparedStatement prep_stmt3;
					PreparedStatement prep_stmt4;
					PreparedStatement prep_stmt5;

					prep_stmt = conn.prepareStatement(query);
					prep_stmt.setString(1, New_PanId);
					prep_stmt.setString(2, New_AadharId);
					prep_stmt.setString(3, New_Name);
					prep_stmt.setString(4, New_Address);
					prep_stmt.setString(5, New_MobNo);
					prep_stmt.setString(6, New_EmailId);
					prep_stmt.execute();

					prep_stmt1 = conn.prepareStatement(query1);
					prep_stmt1.execute();

					prep_stmt2 = conn.prepareStatement(query2);
					prep_stmt2.setString(1, New_PanId);
					prep_stmt2.setInt(2, Job);
					prep_stmt2.setInt(3, Business);
					prep_stmt2.setInt(4, Property);
					prep_stmt2.setInt(5, total_income);
					prep_stmt2.execute();

					prep_stmt3 = conn.prepareStatement(query3);
					prep_stmt3.setString(1, New_PanId);
					prep_stmt3.setInt(2, total_income);
					prep_stmt3.setString(3, "Null");
					prep_stmt3.setInt(4, 0);
					prep_stmt3.execute();

					prep_stmt4 = conn.prepareStatement(query4);
					prep_stmt4.execute();

					prep_stmt5 = conn.prepareStatement(query5);
					prep_stmt5.execute();
//					conn.close();
				} catch (Exception x) {
					System.out.println(x);
				}

				// add the display part here
				User_view v = new User_view();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setForeground(new Color(0, 64, 0));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(306, 519, 100, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_op op = new User_op();
				op.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(0, 64, 0));
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBackground(UIManager.getColor("Button.shadow"));
		btnBack.setBounds(616, 519, 100, 31);
		contentPane.add(btnBack);
	}

}
