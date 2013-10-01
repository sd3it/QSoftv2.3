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
 *          FormDrawable : classe abstraite qui permet de dessiner un carre dans
 *          la classe, on place les infos de chaque type de forme : position,
 *          dimension, couleur
 */

public abstract class FormDrawable implements IMovableDrawable {

	protected Rectangle rect;
	protected Point start, end;
	protected Color color;

	/**
	 * @param color
	 *            the color of this form
	 * @param pos
	 *            the coordinate of the center this form
	 * @param dim
	 *            the dimension of this form
	 */
	public FormDrawable(Color color, Point pos, Dimension dim) {
		this.color = color;
		this.rect = new Rectangle(dim);
		setPosition(pos);
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
}