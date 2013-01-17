package com.practica.as.PresentationLayer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.practica.as.DomainModel.Pair;

public class ContractarViatgeView extends JFrame{
	
	private JPanel pantalla1;
	private JPanel pantalla2;
	private JPanel pantalla3;
	private JPanel pantalla4;
	private JPanel pantalla5;
	private JPanel pantalla6;
	private JPanel pantalla7;
	private JPanel pantallaError;
	private JTextField txtAixsUna;
	private ContractarViatgeController controlador;
	private int di = -1;
	private int mi = -1;
	private int ai = -1;
	private int df = -1;
	private int mf = -1;
	private int af = -1;
	private int selectedRow = -1;
	private int selectedRow_2 = -1;
	private int selectedCol = -1;
	private long numTar = -1;
	private int dataCadu = -1;
	private Date dataInici;
	private Date dataFi;
	private JButton btnContinua_p2;
	private JButton btnContinuar_p5;
	private JTextField dni;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public ContractarViatgeView() {		
		//creació pantalla 1
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla1 = new JPanel();
		pantalla1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla1);
		pantalla1.setLayout(null);
		JLabel lblVoleuContractarUn_p1 = new JLabel("Voleu contractar un viatge?");
		lblVoleuContractarUn_p1.setBounds(147, 59, 178, 14);
		pantalla1.add(lblVoleuContractarUn_p1);
		
		JButton btncancel_p1 = new JButton("Cancel·lar");
		btncancel_p1.setBounds(190, 232, 108, 23);
		pantalla1.add(btncancel_p1);
		btncancel_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.sortir();
			}
		});
		JButton btnComenar_p1 = new JButton("Començar");
		btnComenar_p1.setBounds(307, 232, 108, 23);
		pantalla1.add(btnComenar_p1);
		
		btnComenar_p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 controlador.contractar();
			}
		});
		controlador = new ContractarViatgeController(this);

	}
	
	public void mostraCiutatsIPreus(HashSet<Pair> ciutatPreus) {
		//creació pantalla 2
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla2 = new JPanel();
		pantalla2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla2);
		pantalla2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 11, 302, 103);
		pantalla2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {			},
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
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		});
		
		for(Pair v : ciutatPreus){
			((DefaultTableModel) table.getModel() ).addRow(  new Object[]{v.getNom(), v.getPreu()});			
		}
		
		scrollPane.setViewportView(table);
		
		JLabel lblCiutat = new JLabel("Ciutat:");
		lblCiutat.setBounds(45, 15, 46, 14);
		pantalla2.add(lblCiutat);
		
		JLabel lblDniClient = new JLabel("DNI Client:");
		lblDniClient.setBounds(45, 124, 63, 14);
		pantalla2.add(lblDniClient);
		
		dni = new JTextField();
		dni.setBounds(118, 121, 302, 20);
		pantalla2.add(dni);
		dni.setColumns(10);
		
		JLabel lblDataInici = new JLabel("Data Inici:");
		lblDataInici.setBounds(45, 149, 63, 14);
		pantalla2.add(lblDataInici);
		
		final JTextField d_i = new JTextField();
		
		/*d_i.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//System.out.print(d_i.getText());
			}
			@Override
			public void keyTyped(KeyEvent e) {
				//System.out.print(d_i.getText());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.print(d_i.getText());

			}
		});*/
		d_i.setText("");
		d_i.setToolTipText("");
		d_i.setBounds(118, 146, 25, 20);
		pantalla2.add(d_i);
		d_i.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(153, 149, 12, 14);
		pantalla2.add(label);
		
		final JTextField m_i = new JTextField();
		m_i.setText("");
		m_i.setColumns(10);
		m_i.setBounds(164, 146, 25, 20);
		pantalla2.add(m_i);
		
		final JTextField a_i = new JTextField();
		a_i.setText("");
		a_i.setColumns(10);
		a_i.setBounds(209, 146, 36, 20);
		pantalla2.add(a_i);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(199, 149, 12, 14);
		pantalla2.add(label_1);
		
		JLabel label_2 = new JLabel("Data Fi:");
		label_2.setBounds(45, 177, 63, 14);
		pantalla2.add(label_2);
		
		final JTextField d_f = new JTextField();
		d_f.setText("");
		d_f.setColumns(10);
		d_f.setBounds(118, 174, 25, 20);
		pantalla2.add(d_f);
		
		JLabel label_3 = new JLabel("/");
		label_3.setBounds(153, 177, 12, 14);
		pantalla2.add(label_3);
		
		final JTextField m_f = new JTextField();
		m_f.setText("");
		m_f.setColumns(10);
		m_f.setBounds(164, 174, 25, 20);
		pantalla2.add(m_f);
		
		final JTextField a_f = new JTextField();
		a_f.setText("");
		a_f.setColumns(10);
		a_f.setBounds(209, 174, 36, 20);
		pantalla2.add(a_f);
		
		JLabel label_4 = new JLabel("/");
		label_4.setBounds(199, 177, 12, 14);
		pantalla2.add(label_4);
		
		JButton btnCancella = new JButton("Cancel\u00B7la");
		btnCancella.setBounds(232, 232, 89, 23);
		pantalla2.add(btnCancella);
		
		btnContinua_p2 = new JButton("Continuar");
		btnContinua_p2.setBounds(331, 232, 89, 23);
		pantalla2.add(btnContinua_p2);
		
//		d_i.addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent e) {
//				try{
//					di = Integer.parseInt(d_i.getText());
//				}
//				catch(Exception ex) {
//					di = -1;
//					d_i.setText("");
//				}
//				if(di>31 || di<-1 || di == 0) {
//					di = -1;
//					d_i.setText("");
//				}
//				checkValues();
//			}
//		});
//		
//		m_i.addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent e) {
//				mi = Integer.parseInt(m_i.getText());
//				checkValues();
//			}
//		});
//		
//		a_i.addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent e) {
//				ai = Integer.parseInt(a_i.getText());
//				checkValues();
//			}
//		});
//		
//		d_f.addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent e) {
//				df = Integer.parseInt(d_f.getText());
//				checkValues();
//			}
//		});
//		
//		a_f.addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent e) {
//				af = Integer.parseInt(a_f.getText());
//				checkValues();
//			}
//		});
//		
//		m_f.addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent e) {
//				mf = Integer.parseInt(m_f.getText());
//				checkValues();
//			}
		d_i.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try{
					di = Integer.parseInt(d_i.getText());
				}
				catch(Exception ex) {
					di = -1;
					d_i.setText("");
				}
				if(di>31 || di<-1 || di == 0) {
					di = -1;
					d_i.setText("");
				}
				checkValues();
			}
		});
		
		m_i.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try{
					mi = Integer.parseInt(m_i.getText());
				}
				catch(Exception ex) {
					mi = -1;
					m_i.setText("");
				}
				if(mi>12 || mi<-1 || mi == 0) {
					mi = -1;
					m_i.setText("");
				}
				checkValues();
			}
		});
		
		a_i.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try{
					ai = Integer.parseInt(a_i.getText());
				}
				catch(Exception ex) {
					ai = -1;
					a_i.setText("");
				}
				if(ai>3000 || ai<-1 || ai == 0) {
					ai = -1;
					a_i.setText("");
				}
				checkValues();
			}
		});
		
		d_f.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try{
					df = Integer.parseInt(d_f.getText());
				}
				catch(Exception ex) {
					df = -1;
					d_f.setText("");
				}
				if(df>31 || df<-1 || df == 0) {
					df = -1;
					d_f.setText("");
				}
				checkValues();
			}
		});
		
		a_f.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try{
					af = Integer.parseInt(a_f.getText());
				}
				catch(Exception ex) {
					af = -1;
					a_f.setText("");
				}
				if(af>3000 || af<-1 || af == 0) {
					af = -1;
					a_f.setText("");
				}
				checkValues();
			}
		});
		
		m_f.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try{
					mf = Integer.parseInt(m_f.getText());
				}
				catch(Exception ex) {
					mf = -1;
					m_f.setText("");
				}
				if(mf>12 || mf<-1 || mf == 0) {
					mf = -1;
					m_f.setText("");
				}
				checkValues();
			}
		});
		
		dni.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				checkValues();
			}
		});
		
		btnContinua_p2.setEnabled(false);
		btnContinua_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.sortir();
			}
		});
		
		
		btnContinua_p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.OKenregistrarViatge((String)table.getModel().getValueAt(selectedRow, 0), dni.getText(), dataInici, dataFi);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow  = table.getSelectedRow();
				selectedCol = table.getSelectedColumn();
				checkValues();
			}
		});
		
		pantalla1.setVisible(false);
		setContentPane(pantalla2);
		setSize(getWidth(), getHeight() + 1);
	}
	
	protected void checkValues() {
		Object o = table.getValueAt(0, 0);
		if(di!=-1 && mi!= -1 && ai!= -1){
			dataInici = new Date(ai-1900,mi-1 , di);
	
		}
		if(df!=-1 && mf!= -1 && af!= -1){
			dataFi = new Date(af-1900,mf-1 , df);
		}
		if(df!=-1 && mf!= -1 && af!= -1 && di!=-1 && mi!= -1 && ai!= -1 && dataInici.after(new Date())){
			if(dataInici.before(dataFi) && !dni.getText().equals("") && selectedRow != -1){
				btnContinua_p2.setEnabled(true);
			}
			else btnContinua_p2.setEnabled(false);
		}
		else btnContinua_p2.setEnabled(false);
	}

	public void mostraEscullPagarOReservarHabitacio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla3 = new JPanel();
		pantalla3.setBackground(new Color(232, 230, 233));
		pantalla3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla3);
		pantalla3.setLayout(null);
		
		JLabel lblVoleuReservarUn = new JLabel("Voleu reservar un hotel?");
		lblVoleuReservarUn.setBounds(153, 76, 176, 14);
		pantalla3.add(lblVoleuReservarUn);
		
		JLabel lblElViatgeSha = new JLabel("El viatge s'ha enregistrat");
		lblElViatgeSha.setIcon(new ImageIcon("C:\\Users\\maria\\UPC\\AS\\WS\\PracticaAS\\checked.png"));
		lblElViatgeSha.setBounds(113, 11, 216, 65);
		pantalla3.add(lblElViatgeSha);
		
		JButton continuar_p3 = new JButton("Continuar");
		
		continuar_p3.setBounds(343, 232, 89, 23);
		pantalla3.add(continuar_p3);
		
		JButton reservarHab_p3 = new JButton("Reservar Habitaci\u00F3");
		
		reservarHab_p3.setBounds(188, 232, 146, 23);
		pantalla3.add(reservarHab_p3);
		
		JButton cancellar_p3 = new JButton("Cancel\u00B7lar");
		
		cancellar_p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.sortir();
			}
		});
		reservarHab_p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.reservaHabitacio();
			}
		});
		continuar_p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pagament();
				setSize(getWidth(), getHeight() + 1);

			}
		});

		cancellar_p3.setBounds(82, 232, 98, 23);
		pantalla3.add(cancellar_p3);
	}
	
	public void mostraHotelsIPreus(HashSet<Pair> hotelsPreus) {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla4 = new JPanel();
		pantalla4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla4);
		pantalla4.setLayout(null);
		
		JScrollPane scrollPane_p4 = new JScrollPane();
		scrollPane_p4.setBounds(10, 47, 422, 174);
		pantalla4.add(scrollPane_p4);
		
		final JButton continuar_p4 = new JButton("Continuar");
		continuar_p4.setEnabled(false);
		continuar_p4.setBounds(343, 232, 89, 23);
		pantalla4.add(continuar_p4);
		
		final JTable table_p4 = new JTable();
		table_p4.setModel(new DefaultTableModel(
				new Object[][] {
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
				@Override
			    public boolean isCellEditable(int row, int column) {
			       return false;
			    }
			});
		
		for(Pair v : hotelsPreus){
			((DefaultTableModel) table_p4.getModel() ).addRow(  new Object[]{v.getNom(), v.getPreu()});			
		}
		
		scrollPane_p4.setViewportView(table_p4);
		
		JLabel lblSeleccioneuUnHotel = new JLabel("Seleccioneu un hotel i premeu Continuar");
		lblSeleccioneuUnHotel.setBounds(10, 11, 422, 14);
		pantalla4.add(lblSeleccioneuUnHotel);
		
		JButton cancellar_p4 = new JButton("Cancel\u00B7lar");
		cancellar_p4.setBounds(244, 232, 96, 23);
		pantalla4.add(cancellar_p4);
		
		continuar_p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String hotel_t = (String)table_p4.getModel().getValueAt(selectedRow_2, 0);
				controlador.OKreservaHabitacio(hotel_t);
			}
		});
		
		table_p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				continuar_p4.setEnabled(true);
				selectedRow_2  = table_p4.getSelectedRow();
			}
		});
		
		cancellar_p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.pagament();

			}
		});
		pantalla3.setVisible(false);
		setContentPane(pantalla4);
		setSize(getWidth(), getHeight() + 1);

	}
	
	public void mostraPagament(float importTotal) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla5 = new JPanel();
		pantalla5.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla5);
		pantalla5.setLayout(null);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setBounds(23, 35, 80, 14);
		pantalla5.add(lblTotalAPagar);
		
		JTextField aPagar_p5 = new JTextField(String.valueOf(importTotal));
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
		
		final JTextField numTarja = new JTextField();
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
		
		final JTextField dataCaducitat_mes = new JTextField();
		dataCaducitat_mes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		dataCaducitat_mes.setBounds(113, 102, 22, 20);
		pantalla5.add(dataCaducitat_mes);
		dataCaducitat_mes.setColumns(10);
		
		final JTextField textField_any = new JTextField();
		textField_any.setBounds(155, 102, 39, 20);
		pantalla5.add(textField_any);
		textField_any.setColumns(10);
		setContentPane(pantalla5);
		setSize(getWidth(), getHeight() + 1);
		
		JButton btnContinuar_p5 = new JButton("Continuar");
		btnContinuar_p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.OKpagament(numTarja.getText(), new Date(Integer.parseInt(textField_any.getText()) - 1900, Integer.parseInt(dataCaducitat_mes.getText()), 1));
			}
		});
		btnContinuar_p5.setBounds(331, 232, 89, 23);
		pantalla5.add(btnContinuar_p5);
		
		JButton btnCancellar_p5 = new JButton("Cancel\u00B7lar");
		btnCancellar_p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.sortir();
			}
		});
		btnCancellar_p5.setBounds(232, 232, 96, 23);
		pantalla5.add(btnCancellar_p5);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(143, 105, 14, 14);
		pantalla5.add(lblNewLabel);
		
		

		
	}
	
	protected void checkPantalla5() {
		if(numTar != -1 && dataCadu != -1)
			btnContinuar_p5.setEnabled(true);
	}

	public void mostraFiContracte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pantalla6 = new JPanel();
		pantalla6.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla6);
		pantalla6.setLayout(null);
		
		JLabel lblElPagamentSha = new JLabel("El pagament s'ha fet amb \u00E8xit");
		lblElPagamentSha.setIcon(new ImageIcon("C:\\Users\\maria\\UPC\\AS\\WS\\PracticaAS\\checked.png"));
		lblElPagamentSha.setBounds(99, 48, 237, 61);
		pantalla6.add(lblElPagamentSha);
		
		JButton btnAcabar_p6 = new JButton("Acabar");
		btnAcabar_p6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.sortir();
			}
		});
		btnAcabar_p6.setBounds(322, 232, 89, 23);
		pantalla6.add(btnAcabar_p6);
	}
	
	public void mostraError(String error) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 183);
		pantallaError = new JPanel();
		pantallaError.setBackground(new Color(232, 230, 233));
		pantallaError.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantallaError);
		pantallaError.setLayout(null);
		
		JLabel lblAlgunaCosaNo = new JLabel("Alguna cosa no va b\u00E9");
		lblAlgunaCosaNo.setIcon(new ImageIcon("C:\\Users\\maria\\UPC\\AS\\WS\\PracticaAS\\error.png"));
		lblAlgunaCosaNo.setForeground(Color.BLACK);
		lblAlgunaCosaNo.setBounds(10, 7, 242, 72);
		pantallaError.add(lblAlgunaCosaNo);
		
		JLabel llistatError = new JLabel(error);
		llistatError.setBackground(Color.WHITE);
		llistatError.setVerticalAlignment(SwingConstants.TOP);
		llistatError.setBounds(20, 90, 412, 50);
		pantallaError.add(llistatError);
		
		JButton okerror = new JButton("OK");
		
		okerror.setBounds(343, 57, 89, 23);
		pantallaError.add(okerror);
		
		JLabel lblErrors_1 = new JLabel("Errors:");
		lblErrors_1.setBounds(77, 61, 46, 14);
		pantallaError.add(lblErrors_1);
		
		if(error == "No hi ha ciutats" || error == "Pagament no efectuat" || error == "Servei de pagament no disponible"){
			okerror.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.sortir();
			}
			});
		}
		if(error == "El sistema no té cap client identificat amb aquest DNI a la base de dades" || error == "El client ja té un viatge contractat per a aquestes dates"){
			okerror.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaError.setVisible(false);
				//setContentPane(pantalla2);
				controlador.contractar();
				di = mi = ai = df = mf = af = selectedRow = -1;
				setSize(getWidth(), getHeight() + 1);
			}
			});
		}
		if(error == "No hi ha hotels lliures"){
			okerror.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pantallaError.setVisible(false);
				controlador.pagament();
				setSize(getWidth(), getHeight() + 1);
			}
			});
		}
	}
	
	public void tancar() {
		System.exit(0);
	}

}
