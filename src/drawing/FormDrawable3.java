package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author KoA
 * @version 0.1
 * 
 *          FormDrawable3 : classe abstraite qui permet de dessiner une ligne dans
 *          la classe, on place les infos de chaque type de forme : position, position2
 *          dimension, couleur
 */

public abstract class FormDrawable3 implements IMovableDrawable {

	protected Rectangle rect, rect2;
	protected Point start, end;
	protected Color color;

	/**
	 * @param color
	 *            the color of this form
	 *            
	 * @param pos
	 *            the coordinate of the center this form
	 *            
	 * @param pos2
	 *            the coordinate of the center this form
	 *            
	 * @param dim
	 *            the dimension of this form
	 */
	
	public FormDrawable3(Color color, Point pos, Point pos2, Dimension dim) {
		this.color = color;
		this.rect = new Rectangle(dim);
		this.rect2 = new Rectangle(dim);
		setPosition(pos);
		setPosition2(pos2);
	}

	public abstract void draw(Graphics g);

	public Rectangle getRectangle() {
		return (Rectangle) rect.clone();
	}

	public Point getPosition() {
		Point p = rect.getLocation();
		p.x = (p.x + rect.width / 2);
		p.y = (p.y + rect.width / 2);
		return p;
	}

	public void setPosition(Point p) {
		rect.x = (p.x - rect.width / 2);
		rect.y = (p.y - rect.height / 2);
	}

	public Point getPosition2() {
		Point p2 = rect2.getLocation();
		p2.x = (p2.x + rect2.width / 2);
		p2.y = (p2.y + rect2.width / 2);
		return p2;
	}

	public void setPosition2(Point p2) {
		rect2.x = (p2.x - rect2.width / 2);
		rect2.y = (p2.y - rect2.height / 2);
	}
}