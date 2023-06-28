package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class User_view extends JFrame {

	private JPanel contentPane;
	private JTable table;
	final String DB_URL = "jdbc:mysql://localhost/income_tax";
	final String USER = "root";
	final String PASS = "Mysql@123";
	Connection conn = null;
	Statement stmt = null;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_view frame = new User_view();
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
	public User_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 1000, 550);
		// contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Income Tax Database");

		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(330, 10, 373, 50);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 241, 934, 117);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel_11 = new JLabel("Name");
		lblNewLabel_11.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_11.setBounds(10, 26, 110, 28);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_2 = new JLabel("Pan Number");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 94, 110, 28);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(167, 26, 235, 28);
		panel.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 94, 235, 28);
		panel.add(textField_1);
		JButton btnNewButton = new JButton("Search");
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
					String sql = "select * from TaxPayer where Name ='" + name + "'and PanId ='" + panid + "'";
					ResultSet rs = stm.executeQuery(sql);

					if (rs.next()) {
						String query = "select * from incomedetails inner join tax_calculation on tax_calculation.panid = incomedetails.panid where incomedetails.PanId = '" + panid + "'";
						PreparedStatement stm1 = conn.prepareStatement(query);
						ResultSet rs1 = stm1.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs1));
						// ADD VIEW FRAME
						// UserUpdate update = new UserUpdate();
						// update.setVisible(true);
					} else {
						JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");

						// String query = "select * from IncomeDetails where PanId ='"++"'";
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(457, 185, 119, 29);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(236, 104, 157, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(725, 100, 167, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(150, 100, 62, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Pan ID");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(635, 101, 68, 26);
		contentPane.add(lblNewLabel_3);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_op op = new User_op();
				op.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBounds(457, 424, 119, 29);
		contentPane.add(btnBack);
	}
}