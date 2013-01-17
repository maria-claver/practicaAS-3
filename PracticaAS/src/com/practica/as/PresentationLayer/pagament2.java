package com.practica.as.PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pagament2 extends JFrame {
	

	private JPanel pantalla5;
	private JTextField aPagar_p5;
	private JTextField numTarja;
	private JTextField dataCaducitat_mes;
	private JTextField textField_any;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagament frame = new Pagament();
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
	public pagament2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla5 = new JPanel();
		pantalla5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla5);
		pantalla5.setLayout(null);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setBounds(23, 35, 80, 14);
		pantalla5.add(lblTotalAPagar);
		
		aPagar_p5 = new JTextField();
		aPagar_p5.setEditable(false);
		aPagar_p5.setBounds(113, 32, 135, 20);
		pantalla5.add(aPagar_p5);
		aPagar_p5.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(258, 35, 46, 14);
		pantalla5.add(label);
		
		JLabel lblNmeroTarjeta = new JLabel("N\u00FAmero Tarjeta:");
		lblNmeroTarjeta.setBounds(23, 69, 86, 14);
		pantalla5.add(lblNmeroTarjeta);
		
		numTarja = new JTextField();
		numTarja.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
		numTarja.setBounds(113, 66, 139, 20);
		pantalla5.add(numTarja);
		numTarja.setColumns(16);
		
		JLabel lblDataCaducitat = new JLabel("Data Caducitat:");
		lblDataCaducitat.setBounds(23, 105, 80, 14);
		pantalla5.add(lblDataCaducitat);
		
		dataCaducitat_mes = new JTextField();
		dataCaducitat_mes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		dataCaducitat_mes.setBounds(113, 102, 22, 20);
		pantalla5.add(dataCaducitat_mes);
		dataCaducitat_mes.setColumns(10);
		
		JButton btnContinuar_p5 = new JButton("Continuar");
		btnContinuar_p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnContinuar_p5.setBounds(331, 232, 89, 23);
		pantalla5.add(btnContinuar_p5);
		
		JButton btnCancellar_p5 = new JButton("Cancel\u00B7lar");
		btnCancellar_p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnCancellar_p5.setBounds(232, 232, 89, 23);
		pantalla5.add(btnCancellar_p5);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(143, 105, 14, 14);
		pantalla5.add(lblNewLabel);
		
		textField_any = new JTextField();
		textField_any.setBounds(155, 102, 39, 20);
		pantalla5.add(textField_any);
		textField_any.setColumns(10);
	}
}
