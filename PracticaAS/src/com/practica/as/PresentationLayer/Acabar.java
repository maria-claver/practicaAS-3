package com.practica.as.PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Acabar extends JFrame {

	private JPanel pantalla6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acabar frame = new Acabar();
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
	public Acabar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla6 = new JPanel();
		pantalla6.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla6);
		pantalla6.setLayout(null);
		
		JLabel lblElPagamentSha = new JLabel("El pagament s'ha fet amb \u00E8xit");
		lblElPagamentSha.setIcon(new ImageIcon("C:\\Documents and Settings\\TDW\\Desktop\\checked.png"));
		lblElPagamentSha.setBounds(99, 48, 237, 61);
		pantalla6.add(lblElPagamentSha);
		
		JButton btnAcabar_p6 = new JButton("Acabar");
		btnAcabar_p6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnAcabar_p6.setBounds(322, 232, 89, 23);
		pantalla6.add(btnAcabar_p6);
	}
}
