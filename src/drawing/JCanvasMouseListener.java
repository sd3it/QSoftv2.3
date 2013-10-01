package drawing;

import java.awt.event.*;

import javax.swing.SwingUtilities;

/**
 * @author KoA
 * @version 0.1
 * 
 *          JCanvasMouseListener : classe qui implemente l'interface pour reagir
 *          aux pressions de l'utilisateur sur la souris. Cette classe permettra
 *          selon que l'on clique sur le bouton gauche ou le droit, d'ajouter ou
 *          enlever des formes au panneau.
 */

public class JCanvasMouseListener extends MouseAdapter {
	protected JCanvas canvas;

	public JCanvasMouseListener(JCanvas canvas) {
		super();
		this.canvas = canvas;
		canvas.addMouseListener(this);
	}

	public JCanvas getCanvas() {
		return canvas;
	}

	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			leftClickAction(e);
		} 
		else {
			rightClickAction(e);
		}
	}

	/**
	 * @pre: @post:
	 */
	protected void rightClickAction(MouseEvent e) {
		//System.out.println("right click");
	}

	/**
	 * @pre: @post:
	 */
	protected void leftClickAction(MouseEvent e) {
		//System.out.println("left click");
	}
}