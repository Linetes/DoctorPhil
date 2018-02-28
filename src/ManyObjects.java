import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.JOptionPane;

public class ManyObjects {

	private  ArrayList <GameObject> objects;

	
	public ManyObjects(){
		objects=new ArrayList<GameObject>();
		for(int i=0;i<3;i++){
			Life l=new Life(i*25,0,25,25,1,"img/life.png");
			objects.add(l);
		}

	}
	
	public void add(GameObject e){
		objects.add(e);


	}
	
	public void remove(int id){
		ListIterator<GameObject> itr=objects.listIterator();
		while(itr.hasNext()){
			Enemy aux=(Enemy)itr.next();
			if(aux.getId()==id){
				itr.remove();
			}
		}
	}
	
	public boolean die(GameObject o){
		ListIterator<GameObject> itr=objects.listIterator();
		while(itr.hasNext()){
			GameObject o2=itr.next();
			if(o2.bounds().intersects(o.bounds())&& o.getDir()!=o2.getDir()&& o2 instanceof Enemy){
				itr.remove();
				return true;
			}
		}
		return false;
	}
	public boolean kill(GameObject o){
		ListIterator<GameObject> itr=objects.listIterator();
		ListIterator<GameObject> itr2=objects.listIterator();
		while(itr.hasNext()&&itr2.hasNext()){
			GameObject o2=itr.next();
			if(!((Hero)o).isInv()){
				if(((Hero)o).getState()==0 || (((Hero)o).getState()==1 && o.getDir()==o2.getDir())){
					
					if(o2.bounds().intersects(o.bounds()) && o2 instanceof Enemy||o.respawn()){	
						if(itr2.next() instanceof Life){
							itr2.remove();
							return true;
						}
							JOptionPane.showMessageDialog(null, "Game Over\n Your score is: "+MyCanvas.score);
							System.exit(0);
							return false;
							
						}
					}
			}
		}
		return false;
			
	}
	
	public void paint(Graphics g){
		ListIterator<GameObject> itr=objects.listIterator();
		while(itr.hasNext()){
			itr.next().paint(g);
		}
	}
	public void createMons(){
		GameObject e=new Enemy(randInt(60,700),310,36,36,-1,"img/Monster2.png");
		if(e.getX()<380)
			e.setDir(1);
		objects.add(e);
	}
	public int randInt(int min, int max){
		Random rand=new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
		
	}
	
	/*public void createBullet(Object flymons){
		GameObject aux;
		aux = (Enemy) flymons;
		Enemy e = new Enemy((aux.getX()+aux.getSizex()/2)-20,aux.getY()+aux.getSizey(),10,10,1,"img/Bullet.png");
		objects.add(e);
	}*/
	public void move(){
		ListIterator<GameObject> itr=objects.listIterator();
		while(itr.hasNext()){
			GameObject aux=itr.next();
			if(aux instanceof Enemy){
				aux.move();
				if(aux.gravity()&&aux.getY()>500){
					itr.remove();
				}
			}
				
		}
		
	}

	public void change(boolean t){
		ListIterator<GameObject> itr=objects.listIterator();
		while(itr.hasNext()){
			GameObject aux=itr.next();
			if(aux instanceof Enemy)
				aux.change(t);
				
		}
	}
	
	public void onBox(GameObject o){
		
		ListIterator<GameObject> itr=objects.listIterator();
		while(itr.hasNext()){
			GameObject aux=itr.next();
			if(aux instanceof Box){
				if(o.getX()>aux.getX()-o.getSizex()&&o.getX()<aux.getX()+aux.getSizex()){
					if(o.getY()+o.getSizey()<aux.getY()){
						o.setBounds(273);
					}
				}
				else
					o.setBounds(310);
			}

				
		}
	}
	
}