package com.practica.as.PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Error extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error frame = new Error();
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
	public Error() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 183);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 230, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlgunaCosaNo = new JLabel("Alguna cosa no va b\u00E9");
		lblAlgunaCosaNo.setIcon(new ImageIcon("C:\\Documents and Settings\\TDW\\Desktop\\error.png"));
		lblAlgunaCosaNo.setForeground(Color.BLACK);
		lblAlgunaCosaNo.setBounds(10, 7, 242, 72);
		contentPane.add(lblAlgunaCosaNo);
		
		JLabel llistatError = new JLabel("");
		llistatError.setBackground(Color.WHITE);
		llistatError.setVerticalAlignment(SwingConstants.TOP);
		llistatError.setBounds(20, 90, 412, 50);
		contentPane.add(llistatError);
		
		JButton okerror = new JButton("OK");
		
		okerror.setBounds(343, 57, 89, 23);
		contentPane.add(okerror);
		
		JLabel lblErrors_1 = new JLabel("Errors:");
		lblErrors_1.setBounds(77, 61, 46, 14);
		contentPane.add(lblErrors_1);
		
		okerror.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
