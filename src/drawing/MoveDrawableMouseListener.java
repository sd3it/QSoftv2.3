package drawing;

import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author KoA
 * @version 0.1
 * 
 *          MoveDrawableMouseListener : permet de recuperer le drawable
 *          lorsqu'un bouton de la souris est pressed (methode mousePressed).
 *          Lorsque le bouton est relached (mouseReleased) la variable est mise
 *          a null. Entre ces 2 opérations, si la souris est deplacee, la
 *          methode mouseDragged est appelee. A chaque fois, nous donnons au
 *          drawable la position du curseur et rafraichissons l'ecran.
 */

public class MoveDrawableMouseListener extends JCanvasMouseAdapter {

	protected IMovableDrawable drawable;

	/**
	 * @param canvas
	 */
	public MoveDrawableMouseListener(JCanvas canvas) {
		super(canvas);
	}

	public void mouseDragged(MouseEvent e) {
		if (drawable != null) {
			drawable.setPosition(e.getPoint());
			canvas.repaint();
		}
	}

	public void mousePressed(MouseEvent e) {
		List selectedDrawables = canvas.findDrawables(e.getPoint());
		if (selectedDrawables.size() == 0)
			return;
		drawable = (IMovableDrawable) selectedDrawables.get(0);
	}

	public void mouseReleased(MouseEvent e) {
		drawable = null;
	}
}