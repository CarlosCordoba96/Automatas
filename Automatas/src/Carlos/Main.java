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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 26, 0, 0, 0, 15, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		lblNewLabel = new JLabel("Estado hasta:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 7;
		gbc_list.insets = new Insets(0, 0, 0, 5);
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
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			DefaultListModel modelo = new DefaultListModel();
			modelo.addElement("Elemento1");
			modelo.addElement("Elemento2");
			modelo.addElement("Elemento3");
			list.setModel(modelo);
		}
	}
}
