import java.awt.image.BufferedImage;
import java.io.File;

public class Enemy extends GameObject{
	private int id;
	public Enemy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enemy(int x, int y, int sizex, int sizey, int dir, String srcName) {
		super(x, y, sizex, sizey, dir, srcName);
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void change(boolean t){
		if(dir==-1){
			if(t){
				
				srcName="img/Monster1.png";
			}
			else
			{
				srcName="img/Monster2.png";
			}
		}
		else{
			if(t){
				
				srcName="img/Monster3.png";
			}
			else
			{
				srcName="img/Monster4.png";
			}
		
		}
			
			
	}
	public void changeFly(boolean t){
		if(t){
			srcName="img/FlyMonster.png";
		}
		else
		{
			srcName="img/FlyMonster2.png";
		}
	}
	public void moveBullet() {
		y = y+10;
	}
	
}
