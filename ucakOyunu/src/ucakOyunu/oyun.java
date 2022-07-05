package ucakOyunu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import javax.swing.JPanel;

class Ates{
	
	private int x;
	private int y;
	
	public Ates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}


public class oyun extends JPanel implements KeyListener,ActionListener{

	
	javax.swing.Timer timer = new javax.swing.Timer(3,this);
	
	
	
	private int gecen_sure =0;
	private int harcanan_ates=0;
	
	private BufferedImage image;
	
	private ArrayList<Ates> atesler = new ArrayList<Ates>();
	
	private int atesdirY =1;
	
	
	private int topX = 0;
	
	private int topdirX = 2;
	
	private int ucakX = 0;
	
	private int dirUcakX = 20;
	
	public boolean kontrolEt() {
		
		for (Ates ates : atesler) {
			
			if(new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(topX,0,20,20))) {
				return true;
			}
			
		}
		return false;
		
	}
	

	public oyun() {
		
		try {
			image = ImageIO.read(new FileImageInputStream(new File("ucakk.png")));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		setBackground(Color.BLACK);
		timer.start();
		
			
	}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		gecen_sure +=3;
		
		
		Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);    
        g2d.setRenderingHints(rh);
        
		
		g2d.setColor(Color.RED);
		g2d.fillOval(topX, 0, 20, 20);
		
		
		
		g2d.drawImage(image, ucakX, 450, image.getWidth()/2,image.getHeight()/2,this);
		
		for(Ates ates : atesler ) {
			if(ates.getY()<0) {
				atesler.remove(ates);
			}
		}
		
		g.setColor(Color.YELLOW);
		
		for(Ates ates : atesler) {
			g.fillRect(ates.getX(), ates.getY(), 10, 20);
		}
		
		if (kontrolEt()) {
			
			timer.stop();
			String message = "Kazandýnýz...\n"+"Harcanan Ateþ : "+harcanan_ates+"\nGeçen Süre : "+gecen_sure /1000.0 + " saniye";
			JOptionPane.showMessageDialog(this, message);
			System.exit(0);
			
		}
		
		
	}
	

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	

	public oyun(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		
	}

	public oyun(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public oyun(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Ates ates : atesler) {
			ates.setY(ates.getY() - atesdirY);
			
		}
		
		topX +=topdirX;
		
		if (topX >=750) {
			topdirX = -topdirX;
			
			
		}
		if(topX <=0) {
			topdirX = -topdirX;
		}
		repaint();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
int c =e.getKeyCode();
		
		if(c == KeyEvent.VK_LEFT) {
			if(ucakX<=0) {
				ucakX=0; // DAHA FAZLA SOLA GÝDÝLEMÝYOR
			}
			else {
				ucakX -= dirUcakX;
			}
			
		}
		else if (c==KeyEvent.VK_RIGHT) {
			
			if(ucakX >=700){
				ucakX=700;
			}
			else {
				ucakX+=dirUcakX;
			}
			
		}
		else if (c==KeyEvent.VK_CONTROL) {
			atesler.add(new Ates(ucakX+35,485));
			
			harcanan_ates++;
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	

}
