package ucakOyunu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class oyunEkrani extends JFrame {
	
	
	
	public oyunEkrani(String title) throws HeadlessException{
		super(title);
	}
	

	private JPanel contentPane;

	
	public static void main(String[] args) {
		
		oyunEkrani ekran = new oyunEkrani("U�ak Oyunu");
		ekran.setResizable(false);
		ekran.setFocusable(false);
		ekran.setSize(800, 600);
		ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		oyun oyun = new oyun();
		oyun.requestFocus();
		
		oyun.addKeyListener(oyun);
		
		oyun.setFocusable(true);
		
		oyun.setFocusTraversalKeysEnabled(false);
		
		
		ekran.add(oyun);
		
		ekran.setVisible(true);
		
		
		
		
		
	}
			
}

	
	
		

	


