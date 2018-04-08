package columnStore;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColStoreMakeQueryGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColStoreMakeQueryGUI window = new ColStoreMakeQueryGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	
	
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public ColStoreMakeQueryGUI() throws Exception {
		initialize();	
		conn = SQLConn.createConn();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 713, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateQuery = new JButton("CREATE QUERY");
		btnCreateQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Select * from ";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnCreateQuery.setBounds(10, 11, 109, 23);
		frame.getContentPane().add(btnCreateQuery);
	}

}
