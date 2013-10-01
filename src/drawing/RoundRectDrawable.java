package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author KoA
 * @version 0.1
 * 
 *          RoundRectDrawable : classe qui herite de FormDrawable pour dessiner un
 *          Rectangle arrondi
 */

public class RoundRectDrawable extends FormDrawable {

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 */
	public RoundRectDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRoundRect(rect.x, rect.y, rect.width, rect.height, 20, 20);
		g.setColor(c);
	}
}