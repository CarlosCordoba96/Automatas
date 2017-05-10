package Carlos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Vocabulary extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private LinkedList<String> vocabulario = new LinkedList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vocabulary frame = new Vocabulary();
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
	public Vocabulary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeoriaDeAutomatas = new JLabel("TEORIA DE AUTOMATAS Y COMPUTACIÓN");
		lblTeoriaDeAutomatas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeoriaDeAutomatas.setBounds(15, 16, 727, 39);
		contentPane.add(lblTeoriaDeAutomatas);
		
		JLabel lblNewLabel = new JLabel("GENERADOR DE AUTÓMATAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(15, 55, 727, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblDefinicinDelVocabulario = new JLabel("Definición del Vocabulario");
		lblDefinicinDelVocabulario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDefinicinDelVocabulario.setBounds(15, 134, 227, 39);
		contentPane.add(lblDefinicinDelVocabulario);
		
		JLabel lblPorFavorIntroduzca = new JLabel("Por favor, introduzca cada uno de los símbolos del vocabulario a utilizar:");
		lblPorFavorIntroduzca.setBounds(15, 176, 727, 20);
		contentPane.add(lblPorFavorIntroduzca);
		
		JLabel lblVocab = new JLabel("Su vocabulario actual es: ");
		lblVocab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVocab.setBounds(15, 279, 379, 39);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(15, 212, 44, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnInsertarSmbolo = new JButton("Insertar símbolo");
		btnInsertarSmbolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vocabulario.add(textField.getText());
				lblVocab.setText(lblVocab.getText() + textField.getText() + ", ");
				textField.setText("");
			}
		});
		btnInsertarSmbolo.setBounds(74, 219, 177, 29);
		contentPane.add(btnInsertarSmbolo);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSiguiente.setBounds(409, 279, 146, 39);
		contentPane.add(btnSiguiente);
		
		
		contentPane.add(lblVocab);
	}
}
