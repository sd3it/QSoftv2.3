package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

/**
 * @author KoA
 * @version 0.3
 * 
 *          JCanvas : dessin de plusieurs objets de type IDrawable pour chaque
 *          IDrawable contenu dans la liste, on appelle la methode paint
 */

public class JCanvas extends JPanel {

	private List drawables = new LinkedList();

	/**
	 * @pre: d != null
	 * @post: le drawable d est ajoute sur this
	 */
	public void addDrawable(IDrawable d) {
		drawables.add(d);
		repaint();
	}
	
	public void resizeDrawable(IDrawable d) {
		drawables.add(d);
		
		System.out.println("Size IDrawable : " + d.getRectangle().height / 2);
		repaint();
	}
	
	/**
	 * @pre: d!= null
	 * @post: d est retire de this
	 */
	public void removeDrawable(IDrawable d) {
		
		drawables.remove(d);
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (Iterator iter = drawables.iterator(); iter.hasNext();) {
			((IDrawable) iter.next()).draw(g);
		}
	}

	public void clear() {
		drawables.clear();
		repaint();
	}

	public List findDrawables(Point p) {
		List l = new ArrayList();
		for (Iterator iter = drawables.iterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if (element.getRectangle().contains(p)) {
				l.add(element);
			}
		}
		return l;
	}

	public boolean isFree(Rectangle rect) {
		for (Iterator iter = drawables.iterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			System.out.println(element.getRectangle());
			if (element.getRectangle().intersects(rect)) {
				System.out.println("non-libre");
				return false;
			}
		}
		return true;
	}

	public boolean isAlone(IDrawable drawable) {
		Rectangle rect = drawable.getRectangle();
		System.out.println("----------------------------------------------------------");
		for (Iterator iter = drawables.iterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			System.out.println("+ " + element.getRectangle());
			if (!element.equals(drawable)
					&& element.getRectangle().intersects(rect)) {
				System.out.println("non-libre");
				return false;
			}
		}
		return true;
	}
}