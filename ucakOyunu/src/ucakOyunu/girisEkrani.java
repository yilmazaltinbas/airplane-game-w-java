package ucakOyunu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class girisEkrani extends JFrame  {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisEkrani frame = new girisEkrani();
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
	public girisEkrani() {
		setBackground(new Color(255, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setForeground(new Color(102, 51, 255));
		setTitle("yilmazaltinbas_2017141028");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\YILMAZ\\Desktop\\ucakk.png"));
		setBounds(100, 100, 398, 584);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("OYUNA BA\u015ELA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				oyunEkrani ekran = new oyunEkrani("Uçak Oyunu");
				ekran.setResizable(false);
				ekran.setFocusable(false);
				ekran.setSize(800, 600);
				ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				oyun oyun = new oyun();
				oyun.requestFocus();
				
				oyun.addKeyListener(oyun);
				
				oyun.setFocusable(true);
				
				oyun.setFocusTraversalKeysEnabled(false);
				
				
				ekran.getContentPane().add(oyun);
				
				ekran.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(110, 75, 167, 49);
		panel.add(btnNewButton);
		
		JButton btnNaslOynanr = new JButton("NASIL OYNANIR?");
		btnNaslOynanr.setForeground(Color.WHITE);
		btnNaslOynanr.setBackground(new Color(0, 139, 139));
		btnNaslOynanr.setBounds(110, 195, 167, 49);
		panel.add(btnNaslOynanr);
		
		JButton btnk = new JButton("\u00C7IKI\u015E");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnk.setForeground(Color.WHITE);
		btnk.setBackground(new Color(0, 139, 139));
		btnk.setBounds(110, 330, 167, 49);
		panel.add(btnk);
		
		
		JButton btnNewButton_1 = new JButton("Hakkýmda");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 139, 139));
		btnNewButton_1.setBounds(190, 443, 167, 49);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane panel = new JOptionPane();
				panel.showMessageDialog(btnNewButton_1, "Yýlmaz Altýnbaþ \n 2017141028 \n II. Öðretim \n Uçak Oyunu Ödevi");
				
				
			}
			
			
			
		});
		
           
		    btnNaslOynanr.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane panel = new JOptionPane();
				panel.showMessageDialog(btnNaslOynanr, "Öncelikle oyunda ki amaç en az mermi ile en kýsa sürede hareketli topu vurmak.\n Klavyenizde ki sað ve sol ok"
						+ "tuþlarýyla uçaðýnýzý hareket ettirebilir Control(CTRL) tuþuyla ateþ edebilirsiniz. ");
				
				
			}
			
			
			
		});
		
		
		
		
	}

	
}
