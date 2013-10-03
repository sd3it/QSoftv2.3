package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import drawing.listeners.NonOverlapMoveAdapter;

/**
 * @author KoA
 * @version 0.1
 * 
 *          LineDrawable : classe qui herite de FormDrawable3 pour dessiner une
 *          ligne
 */

public class LineDrawable extends FormDrawable3 {

	/**
	 * @param color
	 * @param pos1
	 * @param pos2
	 */
	public LineDrawable(Color color, Point pos1, Point pos2) {
		super(color, pos1, pos2);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.drawLine(pos1.x, pos1.y, pos2.x, pos2.y);
		g.fillRect(pos1.x, pos1.y, 10, 10);
		g.fillRect(pos2.x, pos2.y, 10, 10);
		g.setColor(c);
		System.out.println("dep = " + pos1.x + " + " + pos1.y);
		System.out.println("arriv = " + pos2.x + " + " + pos2.y);
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