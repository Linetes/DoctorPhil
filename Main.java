import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	/* public static void main(String[] args) throws MalformedURLException {

		 	
	    }*/
	static MyWindow mw;
	public static void main(String[] args) throws MalformedURLException {
		
		mw=new MyWindow();
		mw.setSize(800, 540);
		mw.setVisible(true);
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mw.playSound();
		
		
		

		
		
		

	}

	

}
