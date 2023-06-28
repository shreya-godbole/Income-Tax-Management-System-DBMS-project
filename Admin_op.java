package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_op extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_op frame = new Admin_op();
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
	public Admin_op() {
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
		panel.setBounds(74, 184, 430, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("View All Taxpayers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_View_Users ad = new Admin_View_Users();
				ad.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(107, 22, 221, 58);
		panel.add(btnNewButton);
		
		JButton btnPendingFiling = new JButton("Filing Status");
		btnPendingFiling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_filing_status s = new Admin_filing_status();
				s.setVisible(true);
				dispose();
			}
		});
		btnPendingFiling.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnPendingFiling.setBounds(107, 104, 221, 58);
		panel.add(btnPendingFiling);
		
		JButton btnTopTaxpayers = new JButton("Top 10 Taxpayers");
		btnTopTaxpayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_top t = new Admin_top();
				t.setVisible(true);
				dispose();
			}
		});
		btnTopTaxpayers.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnTopTaxpayers.setBounds(107, 184, 221, 58);
		panel.add(btnTopTaxpayers);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 105, 160, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ADMIN");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(43, 0, 62, 38);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				m.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnBack.setBounds(231, 463, 123, 40);
		contentPane.add(btnBack);
	}
}
