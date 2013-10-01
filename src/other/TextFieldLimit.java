package other;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class TextFieldLimit extends JTextField{
	private boolean utilityKeyPressed = false;
	private int maxChar = 19;
	
	public TextFieldLimit(int max){
		super();
		maxChar = max;
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				checkLenght(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				e.consume();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				checkUtilityKey(e);
			}
		});
	}
	
	/* Vérifictaion des touches BACKSPACE, LEFT, RIGHT pour les  garder actives */
	private void checkUtilityKey(KeyEvent e){
		utilityKeyPressed = (
			e.getKeyCode()==KeyEvent.VK_BACK_SPACE || 
			e.getKeyCode()==KeyEvent.VK_LEFT || 
			e.getKeyCode()==KeyEvent.VK_RIGHT || 
			e.getKeyCode()==KeyEvent.VK_UP || 
			e.getKeyCode()==KeyEvent.VK_DOWN
		);
	}
	
	/* Vérification de la longueur */
	private void checkLenght(KeyEvent e){
		if(!utilityKeyPressed && this.getText().length() >= maxChar)
			e.consume(); 
	}
}
