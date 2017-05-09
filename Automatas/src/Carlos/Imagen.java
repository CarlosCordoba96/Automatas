package Carlos;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//C:/Users/Carlos/workspace/Game/pics/alhambra.png
public class Imagen {

	private static JFrame frame;
	private BufferedImage img;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Imagen(BufferedImage img) {
		initialize();
		this.img=img;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void printimg(){
		
		frame.getContentPane().removeAll();
    	int imgwidth,imgheigth;
    	imgwidth=img.getWidth();
    	imgheigth=img.getHeight();
    	frame.getContentPane().setLayout(new FlowLayout());
    	frame.getContentPane().add(new JLabel(new ImageIcon(img)));
    	
    	frame.setSize(imgwidth+30, imgheigth+50);
    	frame.setVisible(true);
    	
    	
    }
	

}
