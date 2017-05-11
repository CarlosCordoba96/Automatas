package Carlos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblEstadoDesde;
	private JLabel lblListaDeTransiciones;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JList list;
	private JComboBox comboBox_1;
	private JLabel lblTransicion;
	private JComboBox comboBox_2;
	private JButton btnNewButton;
	private DefaultListModel modelo;
	private Hashtable <String, Transicion> table = new Hashtable<String,Transicion>();

	private  Hashtable <String, Estado> estado = new Hashtable<String,Estado>();
	private JButton btnEnsearImagen;
	private JButton btnAadirEstado;
	private JPanel panel;
	private LinkedList <String> vocabulario;
	private JList list_1;
	private DefaultListModel modelo2;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param vocabulario2 
	 */
	public Main(LinkedList<String> vocabulario2) {
		vocabulario=vocabulario2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{83, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 26, 0, 0, 0, 0, 15, 61, 25, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblEstadoDesde = new JLabel("Estado desde:");
		GridBagConstraints gbc_lblEstadoDesde = new GridBagConstraints();
		gbc_lblEstadoDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoDesde.gridx = 0;
		gbc_lblEstadoDesde.gridy = 0;
		contentPane.add(lblEstadoDesde, gbc_lblEstadoDesde);
		
				lblListaDeTransiciones = new JLabel("Lista de transiciones");
				GridBagConstraints gbc_lblListaDeTransiciones = new GridBagConstraints();
				gbc_lblListaDeTransiciones.insets = new Insets(0, 0, 5, 5);
				gbc_lblListaDeTransiciones.gridx = 8;
				gbc_lblListaDeTransiciones.gridy = 0;
				contentPane.add(lblListaDeTransiciones, gbc_lblListaDeTransiciones);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;

		contentPane.add(comboBox, gbc_comboBox);

		lblNewLabel = new JLabel("Estado hasta:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 2;
		gbc_list.gridheight = 9;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 7;
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);

		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 3;
		contentPane.add(comboBox_1, gbc_comboBox_1);

		lblTransicion = new JLabel("Transicion");
		GridBagConstraints gbc_lblTransicion = new GridBagConstraints();
		gbc_lblTransicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblTransicion.gridx = 0;
		gbc_lblTransicion.gridy = 4;
		contentPane.add(lblTransicion, gbc_lblTransicion);
				
						comboBox_2 = new JComboBox();
						GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
						gbc_comboBox_2.gridwidth = 2;
						gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
						gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboBox_2.gridx = 0;
						gbc_comboBox_2.gridy = 5;
						contentPane.add(comboBox_2, gbc_comboBox_2);
		
				btnNewButton = new JButton("Insertar ");
				btnNewButton.addActionListener(new BtnNewButtonActionListener());
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.gridwidth = 2;
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton.gridx = 4;
				gbc_btnNewButton.gridy = 5;
				contentPane.add(btnNewButton, gbc_btnNewButton);
				rellenarVocabulario();
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridwidth = 5;
		gbc_panel.gridheight = 7;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);
		
		btnAadirEstado = new JButton("Añadir estado");
		btnAadirEstado.setBounds(85, 208, 157, 52);
		panel.add(btnAadirEstado);
		
		JCheckBox chckbxEstadoInicial = new JCheckBox("Estado Inicial");
		chckbxEstadoInicial.setBounds(37, 60, 139, 29);
		panel.add(chckbxEstadoInicial);
		
		JCheckBox chckbxEstadoFinal = new JCheckBox("Estado Final");
		chckbxEstadoFinal.setBounds(37, 97, 139, 29);
		panel.add(chckbxEstadoFinal);
		
		JLabel lblAadirUnNuevo = new JLabel("Añadir un nuevo estado");
		lblAadirUnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirUnNuevo.setBounds(15, 16, 423, 32);
		panel.add(lblAadirUnNuevo);
										
												btnEnsearImagen = new JButton("Mostrar imagen");
												btnEnsearImagen.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
													}
												});
												btnEnsearImagen.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {

														File file = new File("pics/alhambra.png"); 

														FileInputStream img = null;
														BufferedImage image=null;
														try {
															img = new FileInputStream(file);
														} catch (FileNotFoundException e2) {
															// TODO Auto-generated catch block
															e2.printStackTrace();
														}

														try {
															image = ImageIO.read(img);
														} catch (IOException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														Imagen im=new Imagen(image);
														im.printimg();

													}
												});
												
												JButton btnEliminarTransicion = new JButton("Eliminar transicion");
												btnEliminarTransicion.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														String selected =(String) list.getSelectedValue();
														Enumeration e = table.keys();
														while( e.hasMoreElements() ){
															String clave = (String) e.nextElement();	
															Transicion aux=table.get(clave);
															if(aux.toString().equals(selected)){
																table.remove(aux.hashName());
															}														
														}
														rellenartabla();
														
														
														
														
														
														
													}
												});
												GridBagConstraints gbc_btnEliminarTransicion = new GridBagConstraints();
												gbc_btnEliminarTransicion.insets = new Insets(0, 0, 5, 5);
												gbc_btnEliminarTransicion.gridx = 9;
												gbc_btnEliminarTransicion.gridy = 8;
												contentPane.add(btnEliminarTransicion, gbc_btnEliminarTransicion);
												
												JLabel lblListaDeEstados = new JLabel("Lista de estados:");
												GridBagConstraints gbc_lblListaDeEstados = new GridBagConstraints();
												gbc_lblListaDeEstados.insets = new Insets(0, 0, 5, 5);
												gbc_lblListaDeEstados.gridx = 8;
												gbc_lblListaDeEstados.gridy = 10;
												contentPane.add(lblListaDeEstados, gbc_lblListaDeEstados);
												
												scrollPane = new JScrollPane();
												GridBagConstraints gbc_scrollPane = new GridBagConstraints();
												gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
												gbc_scrollPane.fill = GridBagConstraints.BOTH;
												gbc_scrollPane.gridx = 8;
												gbc_scrollPane.gridy = 11;
												contentPane.add(scrollPane, gbc_scrollPane);
												
									
												
												list_1 = new JList();
												scrollPane.setViewportView(list_1);
												
												JButton btnEliminarEstado = new JButton("Eliminar estado");
												btnEliminarEstado.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														String selected =(String) list_1.getSelectedValue();
														Enumeration e1 = estado.keys();
														while( e1.hasMoreElements() ){
															String clave = (String) e1.nextElement();	
															Estado aux=estado.get(clave);
															if(aux.toString().equals(selected)){
																estado.remove(aux.getEstado());
																 eliminarcomunes(aux);
															}														
														}
														rellenartablaEstados();
														
														
														
														
														
														
													}
												});
												GridBagConstraints gbc_btnEliminarEstado = new GridBagConstraints();
												gbc_btnEliminarEstado.insets = new Insets(0, 0, 5, 5);
												gbc_btnEliminarEstado.gridx = 9;
												gbc_btnEliminarEstado.gridy = 11;
												contentPane.add(btnEliminarEstado, gbc_btnEliminarEstado);
												GridBagConstraints gbc_btnEnsearImagen = new GridBagConstraints();
												gbc_btnEnsearImagen.insets = new Insets(0, 0, 0, 5);
												gbc_btnEnsearImagen.gridx = 8;
												gbc_btnEnsearImagen.gridy = 13;
												contentPane.add(btnEnsearImagen, gbc_btnEnsearImagen);
										
		btnAadirEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean inicial, fin;
				String name = "q";
				
				inicial = chckbxEstadoInicial.isSelected();
				fin = chckbxEstadoFinal.isSelected();
				
				Estado nuevo=new Estado(name+ultimoestado(),inicial,fin);
				estado.put(name+ultimoestado(), nuevo);
				
				rellenartablaEstados();
			}
		});

	}
	
	
	
	
	
	
	
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String desde=comboBox.getSelectedItem().toString();
			Estado desd=new Estado(desde,false,false);
			String hasta=comboBox_1.getSelectedItem().toString();
			Estado hast=new Estado(hasta,false,false);
			String transicion=comboBox_2.getSelectedItem().toString();
			Transicion t=new Transicion(desd,hast,transicion);
			table.put(desde+hasta+transicion, t);
			rellenartabla();
		}
	}
	public int ultimoestado(){	
		int count=0;
		Enumeration e = estado.keys();
		while( e.hasMoreElements() ){
			String clave = (String) e.nextElement();	
			Estado aux=estado.get(clave);
			
				count++;	

		}
		return count;
	}
	
	
	public LinkedList<String> estadoss(){
		LinkedList<String> est=new LinkedList();
		Enumeration e = estado.keys();
		while( e.hasMoreElements() ){
			String clave = (String) e.nextElement();	
			Estado aux=estado.get(clave);
			
				est.add(aux.getEstado());	

		}
		
		
		return est;
	}
	public void rellenartabla(){
		modelo = new DefaultListModel();	
		Enumeration e = table.keys();
		while( e.hasMoreElements() ){
			String clave = (String) e.nextElement();	
			Transicion aux=table.get(clave);
			modelo.addElement(aux.toString());
						
		}
		list.setModel(modelo);
	}
	public void rellenartabla2(){
		modelo = new DefaultListModel();	
		Enumeration e = estado.keys();
		while( e.hasMoreElements() ){
			String clave = (String) e.nextElement();	
			Estado aux=estado.get(clave);
			modelo.addElement(aux.toString());
		}
		list_1.setModel(modelo);
	}
	
	public void eliminarcomunes(Estado e){
		Enumeration e1 = table.keys();
		while( e1.hasMoreElements() ){
			String clave = (String) e1.nextElement();	
			Transicion aux=table.get(clave);
			if(aux.getDesde().getEstado().equals(e.getEstado())||aux.getHasta().getEstado().equals(e.getEstado()) ){
				table.remove(aux.hashName());
			}
						
		}
		rellenartabla();
	}
	public void rellenartablaEstados(){
		comboBox.removeAllItems();
		 comboBox_1.removeAllItems();
		  Enumeration e = estado.keys();
		  while( e.hasMoreElements() ){
		   String clave = (String) e.nextElement(); 
		   Estado aux=estado.get(clave);
		   comboBox.addItem(aux.getEstado());
		   comboBox_1.addItem(aux.getEstado());
		  
		  }
		  rellenartabla2();
		 }
	
	public void rellenarVocabulario(){
		for(int i=0;i<vocabulario.size();i++){
			comboBox_2.addItem(vocabulario.get(i));
		}
	}
}
