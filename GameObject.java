import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {
	protected int x,y,sizex,sizey;
	protected BufferedImage image;
	protected int dir;
	protected String srcName;
	protected File srcFile;
	protected Color rC=new Color(0,0,0,0);
	protected int bounds = 305;
	
	public GameObject(){
		x=0;
		y=0;
		sizex=0;
		sizey=0;
		image=null;
		dir=0;
		srcName="";
		srcFile= null;

	}

	public GameObject(int x, int y, int sizex, int sizey,int dir, String srcName) {
		super();
		this.x = x;
		this.y = y;
		this.sizex = sizex;
		this.sizey = sizey;
		this.dir = dir;
		this.srcName = srcName;
	}
	


	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public File getSrcFile() {
		return srcFile;
	}

	public void setSrcFile(File srcFile) {
		this.srcFile = srcFile;
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

	public int getSizex() {
		return sizex;
	}

	public void setSizex(int sizex) {
		this.sizex = sizex;
	}

	public int getSizey() {
		return sizey;
	}

	public void setSizey(int sizey) {
		this.sizey = sizey;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public Color getrC() {
		return rC;
	}

	public void setrC(Color rC) {
		this.rC = rC;
	}
	
	public int getBounds() {
		return bounds;
	}

	public void setBounds(int bounds) {
		this.bounds = bounds;
	}

	public void paint(Graphics g){
		
		srcFile = new File(srcName);
		try{
			image = ImageIO.read(srcFile);
		}catch (IOException e){
			e.printStackTrace();
		}
		g.drawImage(image, x, y, sizex, sizey, null);
		//no se como colisionar
	}
	public void drawRect(Graphics h){
		h.setColor(rC);
		h.drawRect(x, y, sizex, sizey);
	}
	public void move(){
		if(dir>0){

				x+=5;

		}
		else{

				x-=5;

		}
		
	}
	public void moveH(){
		
	}
	public void follow(int n){
		if(x>n){
			x-=3;
			dir=1;
		}
		if(x<n){
			x+=3;
			dir=-1;
		}
			
	}
	public void change(boolean t){
		
	}
	public void changeFly(boolean t){
		
	}
	public void attack(){
		
	}
	public boolean gravity(){
		if(x<60||x>700||y<bounds-5||y>bounds+5){
			y+=9;	
			return true;
		}
		return false;

	}
	public boolean respawn(){
		if(y>500){
			x=380;
			y=200;
			return true;
		}
		return false;
	}
			
	public Rectangle bounds(){
		Rectangle r = new Rectangle(x,y,sizex,sizey);
		return r;
		
	}
	@Override
	public String toString() {
		return "GameObject [x=" + x + ", y=" + y + ", sizex=" + sizex + ", sizey=" + sizey + ", image=" + image
				+ ", dir=" + dir + ", srcName=" + srcName + ", srcFile=" + srcFile + "]";
	}

	public void jump() {
		if(y>bounds-5&&y<bounds+5){
			y-=100;
			srcName="img/Jump.png";
		}
	}


	public void moveBullet() {
		// TODO Auto-generated method stub
		
	}

}
