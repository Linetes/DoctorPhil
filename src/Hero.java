import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Hero extends GameObject{
	private int option,counti=0,countd=0,state=0;
	private boolean inv;
	public Hero() {
		super();
	
		
		
		// TODO Auto-generated constructor stub
	}



	public Hero(int x, int y, int sizex, int sizey, int dir, String srcName) {
		super(x, y, sizex, sizey, dir, srcName);

		// TODO Auto-generated constructor stub
	}
	
	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public boolean isInv() {
		return inv;
	}



	public void setInv(boolean inv) {
		this.inv = inv;
	}



	public void moveH() {

		//change(true);

		if(dir>0){
			if(countd<3){
				srcName="img/WRight.png";
				countd++;
			}
			else if(countd<6){
				srcName="img/Right.png";
				countd++;
				
			}
			else if(countd>=6){
				countd=0;
			}


				x+=4;

		}
		else{
			if(counti<3){
				srcName="img/WLeft.png";
				counti++;
			}
			else if(counti<6){
				srcName="img/Left.png";
				counti++;
				
			}
			if(counti>=6){
				counti=0;
			}

				x-=4;

		}
		
	}
	public void change(boolean t){
		if(dir>0){
			if(t)
				srcName="img/Right.png";
			else
				srcName="img/WRight.png";
		}
		else{
			if(t)
				srcName="img/Left.png";
			else
				srcName="img/WLeft.png";
			
		}

		
	}
	public void attack(){
		if(dir>0){
			srcName="img/RightHit.png";
		}
		else{
			srcName="img/LeftHit.png";
		}

	}
	/*public void position(){
		srcName="img/Man.gif";
	}*/
	public void paint(Graphics g){
		srcFile = new File(srcName);
		
		try{
			image = ImageIO.read(srcFile);
		}catch (IOException e){
			e.printStackTrace();
		}
		g.drawImage(image, x, y, sizex, sizey, null);
	}

	@Override
	public String toString() {
		return "Hero []";
	}
}
