package drawing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author KoA
 * @version 0.1
 * 
 *          JCanvasMouseAdapter : listener d'evennement de souris
 */

public class JCanvasMouseAdapter extends JCanvasMouseListener implements
		MouseMotionListener {

	/**
	 * @param canvas
	 */
	public JCanvasMouseAdapter(JCanvas canvas) {
		super(canvas);
		canvas.addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}