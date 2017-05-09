package Carlos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

	private Hashtable <String, Estado> estado = new Hashtable<String,Estado>();
	private JButton btnEnsearImagen;
	private JButton btnAadirEstado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{83, 78, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 26, 0, 0, 0, 15, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_lblListaDeTransiciones.gridx = 5;
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
		
		btnAadirEstado = new JButton("Añadir estado");
		btnAadirEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnAadirEstado = new GridBagConstraints();
		gbc_btnAadirEstado.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadirEstado.gridx = 3;
		gbc_btnAadirEstado.gridy = 1;
		contentPane.add(btnAadirEstado, gbc_btnAadirEstado);

		lblNewLabel = new JLabel("Estado hasta:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 7;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 5;
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
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		btnEnsearImagen = new JButton("Enseñar imagen");
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
		GridBagConstraints gbc_btnEnsearImagen = new GridBagConstraints();
		gbc_btnEnsearImagen.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnsearImagen.gridx = 5;
		gbc_btnEnsearImagen.gridy = 8;
		contentPane.add(btnEnsearImagen, gbc_btnEnsearImagen);
		añadirestados(5);
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

	private void añadirestados(int n){//segun el n� de estados que nos digan que quiere as� se crearan
		String q="q";
		for(int i=0;i<n;i++){
			comboBox.addItem(q+i);
			comboBox_1.addItem(q+i);
		}
		comboBox_2.addItem(0);
		comboBox_2.addItem(1);

	}
	public void rellenartabla(){
		modelo = new DefaultListModel();	
		Enumeration e = table.keys();
		while( e.hasMoreElements() ){
			String clave = (String) e.nextElement();	
			Transicion aux=table.get(clave);
			modelo.addElement(aux.toString());

			list.setModel(modelo);			

		}
	}
}
