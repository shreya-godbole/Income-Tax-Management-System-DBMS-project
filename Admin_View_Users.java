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

public class Admin_View_Users extends JFrame {
	static final String DB_URL = "jdbc:mysql://localhost/income_tax";
	static final String USER = "root";
	static final String PASS = "Mysql@123";
	Connection conn = null;
	Statement stmt = null;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_View_Users frame = new Admin_View_Users();
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
	public Admin_View_Users() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		//frame = new JFrame();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 600, 550);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Income Tax Database");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(103, 10, 373, 50);
		contentPane.add(lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 70, 160, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ADMIN");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(43, 0, 62, 38);
		panel_1.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 566, 327);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection(DB_URL,USER,PASS);

				Statement stm = conn.createStatement();
				String sql = "select * from TaxPayer";
				ResultSet rs = stm.executeQuery(sql);
				
				if(rs.next()) {
					String query = "select * from TaxPayer";
					PreparedStatement stm1 = conn.prepareStatement(query);
					ResultSet rs1 = stm1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					//ADD VIEW FRAME
					//UserUpdate update = new UserUpdate();
				// update.setVisible(true);
				}else {
					JOptionPane.showInputDialog(this, "NAME AND PAN ID DO NOT MATCH");
					
					//String query = "select * from  IncomeDetails where PanId ='"++"'";
				}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(31, 108, 141, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_op op = new Admin_op();
				op.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBounds(433, 108, 96, 31);
		contentPane.add(btnBack);
	}
}
