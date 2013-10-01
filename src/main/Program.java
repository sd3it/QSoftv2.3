package main;

import ihm.Screen1;
import ihm.Window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.UIManager;

public class Program {
	
	public static void main(String arg[]){
		
		Locale.setDefault(Locale.ENGLISH);
		
		try{  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e) {}
		
		Screen1 s1=new Screen1();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		s1.setLocation((screen.width - s1.getSize().width)/2,(screen.height - s1.getSize().height)/2);
		
		s1.setVisible(true);
	}
}
