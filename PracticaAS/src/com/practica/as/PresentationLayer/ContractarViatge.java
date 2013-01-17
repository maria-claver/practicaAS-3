package com.practica.as.PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import org.hibernate.dialect.JDataStoreDialect;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class ContractarViatge extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField dni;
	private JTextField d_i;
	private JTextField m_i;
	private JTextField a_i;
	private JTextField d_f;
	private JTextField m_f;
	private JTextField a_f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractarViatge frame = new ContractarViatge();
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
	public ContractarViatge() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 11, 302, 103);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.print(table.getSelectedRow());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Ciutat", "Preu (\u20AC)"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblCiutat = new JLabel("Ciutat:");
		lblCiutat.setBounds(45, 15, 46, 14);
		contentPane.add(lblCiutat);
		
		JLabel lblDniClient = new JLabel("DNI Client:");
		lblDniClient.setBounds(45, 124, 63, 14);
		contentPane.add(lblDniClient);
		
		dni = new JTextField();
		dni.setBounds(118, 121, 302, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		JLabel lblDataInici = new JLabel("Data Inici:");
		lblDataInici.setBounds(45, 149, 63, 14);
		contentPane.add(lblDataInici);
		
		d_i = new JTextField();
		d_i.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				//System.out.print(d_i.getText() + "*");
			}
		});
		d_i.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {

			}
		});
		d_i.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				System.out.print(d_i.getText());

			}
		});
		d_i.setText("DD");
		d_i.setToolTipText("");
		d_i.setBounds(118, 146, 25, 20);
		contentPane.add(d_i);
		d_i.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(153, 149, 12, 14);
		contentPane.add(label);
		
		m_i = new JTextField();
		m_i.setText("MM");
		m_i.setColumns(10);
		m_i.setBounds(164, 146, 25, 20);
		contentPane.add(m_i);
		
		a_i = new JTextField();
		a_i.setText("AAAA");
		a_i.setColumns(10);
		a_i.setBounds(209, 146, 36, 20);
		contentPane.add(a_i);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(199, 149, 12, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Data Fi:");
		label_2.setBounds(45, 177, 63, 14);
		contentPane.add(label_2);
		
		d_f = new JTextField();
		d_f.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				System.out.println("*");
			}
		});
		d_f.setText("DD");
		d_f.setColumns(10);
		d_f.setBounds(118, 174, 25, 20);
		contentPane.add(d_f);
		
		JLabel label_3 = new JLabel("/");
		label_3.setBounds(153, 177, 12, 14);
		contentPane.add(label_3);
		
		m_f = new JTextField();
		m_f.setText("MM");
		m_f.setColumns(10);
		m_f.setBounds(164, 174, 25, 20);
		contentPane.add(m_f);
		
		a_f = new JTextField();
		a_f.setText("AAAA");
		a_f.setColumns(10);
		a_f.setBounds(209, 174, 36, 20);
		contentPane.add(a_f);
		
		JLabel label_4 = new JLabel("/");
		label_4.setBounds(199, 177, 12, 14);
		contentPane.add(label_4);
		
		JButton btnCancella = new JButton("Cancel\u00B7la");
		btnCancella.setBounds(232, 232, 89, 23);
		contentPane.add(btnCancella);
		
		JButton btnContinua = new JButton("Continuar");
		btnContinua.setEnabled(false);
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinua.setBounds(331, 232, 89, 23);
		contentPane.add(btnContinua);
		
	}
}
