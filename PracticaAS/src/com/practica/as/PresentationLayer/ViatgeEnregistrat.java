package com.practica.as.PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViatgeEnregistrat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViatgeEnregistrat frame = new ViatgeEnregistrat();
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
	public ViatgeEnregistrat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 230, 233));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoleuReservarUn = new JLabel("Voleu reservar un hotel?");
		lblVoleuReservarUn.setBounds(153, 76, 176, 14);
		contentPane.add(lblVoleuReservarUn);
		
		JLabel lblElViatgeSha = new JLabel("El viatge s'ha enregistrat");
		lblElViatgeSha.setIcon(new ImageIcon("C:\\Documents and Settings\\TDW\\Desktop\\checked.png"));
		lblElViatgeSha.setBounds(113, 11, 216, 65);
		contentPane.add(lblElViatgeSha);
		
		JButton continuar_p3 = new JButton("Continuar");
		
		continuar_p3.setBounds(343, 232, 89, 23);
		contentPane.add(continuar_p3);
		
		JButton reservarHab_p3 = new JButton("Reservar Habitaci\u00F3");
		
		reservarHab_p3.setBounds(188, 232, 146, 23);
		contentPane.add(reservarHab_p3);
		
		JButton cancellar_p3 = new JButton("Cancel\u00B7lar");
		
		cancellar_p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		reservarHab_p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		continuar_p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		cancellar_p3.setBounds(82, 232, 96, 23);
		contentPane.add(cancellar_p3);
	}

}
