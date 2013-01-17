package com.practica.as.PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReservarHabitació extends JFrame {

	private JPanel contentPane;
	private JTable table_p4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservarHabitació frame = new ReservarHabitació();
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
	public ReservarHabitació() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_p4 = new JScrollPane();
		scrollPane_p4.setBounds(10, 47, 422, 174);
		contentPane.add(scrollPane_p4);
		
		final JButton continuar_p4 = new JButton("Continuar");
		continuar_p4.setEnabled(false);
		continuar_p4.setBounds(343, 232, 89, 23);
		contentPane.add(continuar_p4);
		
		table_p4 = new JTable();
		table_p4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Nom Hotel", "Preu(\u20AC)"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_p4.setViewportView(table_p4);
		
		JLabel lblSeleccioneuUnHotel = new JLabel("Seleccioneu un hotel i premeu Continuar");
		lblSeleccioneuUnHotel.setBounds(10, 11, 422, 14);
		contentPane.add(lblSeleccioneuUnHotel);
		
		JButton cancellar_p4 = new JButton("Cancel\u00B7lar");
		cancellar_p4.setBounds(237, 232, 96, 23);
		contentPane.add(cancellar_p4);
		
		continuar_p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		table_p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				continuar_p4.setEnabled(true);
			}
		});
		
		cancellar_p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	
	}
}
