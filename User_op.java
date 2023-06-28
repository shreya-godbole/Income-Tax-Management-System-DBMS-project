package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

public class User_op extends JFrame {
	static final String DB_URL = "jdbc:mysql://localhost/income_tax";
	static final String USER = "root";
	static final String PASS = "Mysql@123";
	Connection conn = null;
	Statement stmt = null;

	private JPanel contentPane;
	private JTextField Name;
	private JTextField PanId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_op frame = new User_op();
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
	public User_op() {
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
		panel.setBounds(74, 169, 430, 189);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 26, 110, 28);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pan Number");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 94, 110, 28);
		panel.add(lblNewLabel_2);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(167, 26, 235, 28);
		panel.add(Name);

		PanId = new JTextField();
		PanId.setColumns(10);
		PanId.setBounds(167, 94, 235, 28);
		panel.add(PanId);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 105, 160, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel(" EXISTING USER");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(10, 0, 140, 38);
		panel_1.add(lblNewLabel_2_1);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				UserUpdate update = new UserUpdate();
//				update.setVisible(true);
				dispose();
				try {
					String DB_URL = "jdbc:mysql://localhost/income_tax";
					String USER = "root";
					String PASS = "Mysql@123";
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("connecting to the database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();
					String name = Name.getText();
					String panid = PanId.getText();
					Statement stm = conn.createStatement();
					System.out.println(name);
					System.out.println(panid);
					String sql = "select * from TaxPayer where Name ='" + name + "'and PanId ='" + panid + "'";
					ResultSet rs = stm.executeQuery(sql);

					if (rs.next()) {
						dispose();
						UserUpdate update = new UserUpdate();
						update.setVisible(true);
					} else {
						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");
						lblNewLabel_1.setText(" ");
						lblNewLabel_2.setText(" ");

						conn.close();
					}
				} catch (Exception x) {
					System.out.println(x);
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setForeground(new Color(0, 64, 0));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(48, 399, 100, 31);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Delete d = new User_Delete();
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 64, 0));
		btnNewButton_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_1.setBounds(439, 399, 100, 31);
		contentPane.add(btnNewButton_1);

		JButton btnViewDetails_1 = new JButton("VIEW DETAILS");
		btnViewDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String New_PanId;
//				New_PanId = PanId.getText();
//
//				New_PanId = PanId.getText();
				String name = Name.getText();
				String panid = PanId.getText();

				try {
					// to check if the driver is working and the user name and password match;
					// if not, throw exception
					String DB_URL = "jdbc:mysql://localhost/income_tax";
					String USER = "root";
					String PASS = "Mysql@123";
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("connecting to the database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = conn.createStatement();

					//String query = "select * from taxpayer where PanId =  '"+panid+"'";
					String sql = "select * from TaxPayer where Name ='"+name+"'and PanId ='"+panid+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					//PreparedStatement prep_stmt;
					if (rs.next()) {
						User_view v = new User_view();
						v.setVisible(true);
						dispose();
						
//						prep_stmt = conn.prepareStatement(query);
//						prep_stmt.execute();
					} else {
						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");
//						lblNewLabel_1.setText(" ");
//						lblNewLabel_2.setText(" ");
						conn.close();
					}
					
			}
				 catch (Exception x) {
						System.out.println(x);
					}
			}
		});
		btnViewDetails_1.setForeground(new Color(0, 64, 0));
		btnViewDetails_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnViewDetails_1.setBounds(205, 399, 180, 31);
		contentPane.add(btnViewDetails_1);
		
		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Side us = new User_Side();
				us.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 64, 0));
		btnNewButton_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(242, 460, 100, 31);
		contentPane.add(btnNewButton_1_1);

//		JButton btnViewDetails = new JButton("VIEW DETAILS");
//		btnViewDetails.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
////					String query = "select * from taxpayer where PanId =  "+New_PanId;
////					String query1 = "select * from incomedetails where PanId =  "+New_PanId;
////					
////					PreparedStatement prep_stmt;
////					PreparedStatement prep_stmt1;
////					prep_stmt = conn.prepareStatement(query);
////					prep_stmt1 = conn.prepareStatement(query1);
////					
////					prep_stmt.execute();
////					prep_stmt1.execute();
//
//				} catch (Exception x) {
//					System.out.println(x);
//				}
//			}
//		});
//		
	}

}
