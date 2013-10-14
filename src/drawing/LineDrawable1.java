package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author KoA
 * @version 0.1
 * 
 *          LineDrawable1 : classe qui herite de FormDrawable3 pour dessiner
 *          une ligne
 */
public class LineDrawable1 extends FormDrawable3 {

	/**
	 * @param color
	 * @param pos
	 * @param pos2
	 * @param dim
	 */
	public LineDrawable1(Color color, Point pos, Point pos2, Dimension dim) {
		super(color, pos, pos2, dim);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.drawLine(rect.x, rect.y, rect2.x, rect2.y);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
		g.setColor(c);
	}
}