import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MyCanvas extends Canvas implements MouseListener, KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameObject phil,mons,block;
	private Timer t1,t2,inv,t4,monst;

	static int score=0;
	private ManyObjects me;

	BufferedImage image;
	/*
	 * 
	 * */
	public MyCanvas(){
		JOptionPane.showMessageDialog(null, "Welcome\nDoctor Phil\nBy Joaquín Herrera and César Buenfil");
		JOptionPane.showMessageDialog(null, "Kill the most enemies\n Remember you can only kill while pressing space\nYou jump with the up arrow\nYou can't kill from the back");

		phil=new Hero(100,310,36,36,1,"img/Right.png");
		me=new ManyObjects();
		//flymons= new FlyEnemy(400,175,36,36,-1,"img/FlyMonster.png");
		mons= new Enemy(300,310,36,36,-1,"img/Monster2.png");
		block=new Box(400,0,40,40,1,"img/Block.png");
		//bullet = new Enemy((flymons.getX()+flymons.getSizex()/2)-20,flymons.getY()+flymons.getSizey(),10,10,1,"img/Bullet.png");
		//me.add(bullet);
		me.add(mons);
		//me.add(flymons);
		me.add(block);
		addKeyListener(this);
		t1=new Timer(100, this);
		t2=new Timer(100, this);
		inv=new Timer(3000,this);//Defensa
		t4=new Timer(100,this);
		monst=new Timer(3000,this);
		t1.start();
		monst.start();
		
		File srcFile = new File("img/Background.png");
		
		try{
			image = ImageIO.read(srcFile);
			
		}catch (IOException e){
			e.printStackTrace();
		}
		setFocusable(true);
		requestFocus();


	}
	BufferedImage im= new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
	public void paint(Graphics g){
		Graphics b= im.createGraphics();
		b.fillRect(0, 0, 800, 500);
		
		b.drawImage(image, 0, 0, null);
		phil.paint(b);
		me.paint(b);
		b.drawString("Score: "+score,700,20);
		if(me.kill(phil)){
			((Hero)phil).setInv(true);
			inv.start();
		}
		g.drawImage(im, 0, 0, null);
		
	}
	
	public void update(Graphics g){
		paint(g);
	}
	


	@Override
	public void keyPressed(KeyEvent k) {
		
		int keyCode = k.getKeyCode();
		switch( keyCode ) { 
        case KeyEvent.VK_UP:
        	((Hero)phil).setState(1);
        	t4.start();
        	phil.jump();
            break;
        case KeyEvent.VK_DOWN:
        	
            break;
        case KeyEvent.VK_LEFT:
        	//t1.start();
        	phil.setDir(-1);
        	
        	phil.moveH();
            break;
        case KeyEvent.VK_RIGHT :
        	//t1.start();
        	phil.setDir(1);
        	phil.moveH();

            break;
        case KeyEvent.VK_SPACE:
        	((Hero)phil).setState(1);
        	if(me.die(phil)){
        		score++;
        	}
        	phil.attack();
        	
        	break;
            
		}
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent k) {

		int keyCode = k.getKeyCode();
		switch( keyCode ) { 
        case KeyEvent.VK_UP:
        	((Hero)phil).setState(0);
            break;
        case KeyEvent.VK_DOWN:
        	
            break;
        case KeyEvent.VK_LEFT:
        	phil.setSrcName("img/Left.png");
            break;
        case KeyEvent.VK_RIGHT :
        	phil.setSrcName("img/Right.png");
            break;
        case KeyEvent.VK_SPACE:
        	((Hero)phil).setState(0);
        	if(phil.getDir()==1){
        		phil.setSrcName("img/Right.png");
        	}
        	else{
        		phil.setSrcName("img/Left.png");}
        	break;
            
		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent a) {
		phil.gravity();
		me.onBox(phil);

		block.gravity();
		//bullet.moveBullet();
		if(a.getSource()==t1){
			t1.stop();
			t2.start();
			
			me.change(false);
			//flymons.changeFly(false);
		}
		else if(a.getSource()==t2){
			t1.start();
			t2.stop();

			me.change(true);
			//flymons.changeFly(true);
		}
		me.move();
		//flymons.follow(phil.getX());
		
		if(a.getSource()==inv){
			((Hero)phil).setInv(false);
		}
		if(a.getSource()==monst){
			me.createMons();
		}
		repaint();		
	}

}
