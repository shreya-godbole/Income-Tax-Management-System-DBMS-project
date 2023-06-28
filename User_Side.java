package mini_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class User_Side extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Side frame = new User_Side();
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
	public User_Side() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBounds(100, 100, 600, 550);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Income Tax Database");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(104, 10, 373, 50);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("EXISTING USER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_op up = new User_op();
				up.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setForeground(new Color(0, 64, 0));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(195, 132, 212, 77);
		contentPane.add(btnNewButton);

		JButton btnNewUser = new JButton("NEW USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New_User n = new New_User();
				n.setVisible(true);
				dispose();
			}
		});
		btnNewUser.setForeground(new Color(0, 64, 0));
		btnNewUser.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewUser.setBounds(195, 251, 212, 77);
		contentPane.add(btnNewUser);
		
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
		btnBack.setBounds(195, 382, 212, 77);
		contentPane.add(btnBack);
	}

}
