package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class User_Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	final String DB_URL = "jdbc:mysql://localhost/income_tax";
	final String USER = "root";
	final String PASS = "Mysql@123";
	Connection conn = null;
	Statement stmt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Delete frame = new User_Delete();
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
	public User_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 600, 550);
		// contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Income Tax Database");

		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(104, 10, 373, 50);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
//		JLabel lblNewLabel_11 = new JLabel("Name");
//		lblNewLabel_11.setFont(new Font("Century Gothic", Font.BOLD, 18));
//		lblNewLabel_11.setBounds(10, 26, 110, 28);
//		panel.add(lblNewLabel_11);
//		
//		JLabel lblNewLabel_2 = new JLabel("Pan Number");
//		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
//		lblNewLabel_2.setBounds(10, 94, 110, 28);
//		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Deleting Entry");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel_1.setBounds(168, 70, 255, 50);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(31, 177, 99, 34);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Pan ID");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(31, 245, 99, 34);
		contentPane.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(166, 165, 212, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(166, 240, 212, 46);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Confirm Delete");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					String name = textField.getText();
					String panid = textField_1.getText();
					Statement stm = conn.createStatement();
//					System.out.println(name);
//					System.out.println(panid);
					
					String sql1 = "select * from incomedetails where incomedetails.PanId ='" + panid + "'";
					ResultSet rs1 = stm.executeQuery(sql1);
					if (rs1.next()) {
						//System.out.println("Hi");
						String query2 = "Delete from IncomeDetails where incomedetails.PanId = '" + panid + "'";
						PreparedStatement stm2 = conn.prepareStatement(query2);
						stm2.execute();
					}  else {
						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");

						// String query = "select * from IncomeDetails where PanId ='"++"'";
					}
					
					String sql2 = "select * from tax_calculation where tax_calculation.PanId ='" + panid + "'";
					ResultSet rs2 = stm.executeQuery(sql2);
					if (rs2.next()) {
						//System.out.println("Hi");
						String query3 = "Delete from tax_calculation where tax_calculation.PanId = '" + panid + "'";
						PreparedStatement stm3 = conn.prepareStatement(query3);
						stm3.execute();
					}  else {
						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");

						// String query = "select * from IncomeDetails where PanId ='"++"'";
					}
					
					String sql = "select * from TaxPayer where taxpayer.PanId ='" + panid + "'";
					ResultSet rs = stm.executeQuery(sql);

					if (rs.next()) {
						//System.out.println("Hi");
						String query1 = "Delete from taxpayer where taxpayer.PanId = '" + panid + "'";
						PreparedStatement stm1 = conn.prepareStatement(query1);
						stm1.execute();
					}  else {
						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");

						// String query = "select * from IncomeDetails where PanId ='"++"'";
					}
//					String sql3 = "select * from filing where Name ='" + name + "'and PanId ='" + panid + "'";
//					ResultSet rs3 = stm.executeQuery(sql);
//					if (rs2.next()) {
//						//System.out.println("Hi");
//						String query4 = "Delete from filing where PanId = '" + panid + "'";
//						PreparedStatement stm4 = conn.prepareStatement(query4);
//						stm4.execute();
//					}  else {
//						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");
//
//						// String query = "select * from IncomeDetails where PanId ='"++"'";
//					}
				
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(189, 330, 234, 73);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_op op = new User_op();
				op.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBounds(243, 443, 135, 46);
		contentPane.add(btnBack);
	}

}