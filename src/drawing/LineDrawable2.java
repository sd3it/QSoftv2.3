package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * @author KoA
 * @version 0.1
 * 
 *          LineDrawable2 : classe qui herite de FormDrawable3 pour dessiner
 *          une ligne en pointillé
 */
public class LineDrawable2 extends FormDrawable3 {

	/**
	 * @param color
	 * @param pos
	 * @param pos2
	 * @param dim
	 */
	public LineDrawable2(Color color, Point pos, Point pos2, Dimension dim) {
		super(color, pos, pos2, dim);
	}

	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(color);
		
		float[] style = {10,5}; // Pointillé
		((Graphics2D) g).setStroke( 
			new BasicStroke( 
				4, // taille de la ligne 
				BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_MITER,
				10.0f,
				style,
				0
		    )
		);
		
		g.drawLine(rect.x, rect.y+1, rect2.x, rect2.y+1);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
		g.setColor(c);
	}
}