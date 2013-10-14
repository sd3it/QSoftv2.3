package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author KoA
 * @version 0.1
 * 
 *          GommeRectDrawable : classe qui herite de FormDrawable pour dessiner
 *          un rectangle
 */
public class GommeRectDrawable extends FormDrawable {

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 */
	public GommeRectDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x, rect.y, rect.height, rect.width);
		//g.clearRect(rect.x, rect.y, rect.height, rect.width);
		g.setColor(c);
	}
}