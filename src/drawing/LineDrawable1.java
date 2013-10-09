/*package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import drawing.listeners.NonOverlapMoveAdapter;


public class LineDrawable extends FormDrawable3 {

	
	public LineDrawable(Color color, Point pos1, Point pos2) {
		super(color, pos1, pos2);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		//g.drawLine(pos1.x, pos1.y, pos2.x, pos2.y);
		g.drawLine(20, 60, 120, 450);
		//g.fillRect(pos1.x, pos1.y, 10, 10);
		//g.fillRect(pos2.x, pos2.y, 10, 10);
		g.setColor(c);
		//System.out.println("dep = " + pos1.x + " + " + pos1.y);
		//System.out.println("arriv = " + pos2.x + " + " + pos2.y);
	}

	@Override
	public void setPosition(Point p) {
		// TODO Auto-generated method stub	
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return null;
	}
}
*/
package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author KoA
 * @version 0.1
 * 
 *          RectangleDrawable : classe qui herite de FormDrawable pour dessiner
 *          un rectangle
 */
public class LineDrawable1 extends FormDrawable3 {

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 */
	public LineDrawable1(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x, rect.y, rect.height, rect.width);
		g.setColor(c);
	}
}