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
 *          FormDrawable2 : classe abstraite qui permet de dessiner dans
 *          la classe, on place les infos de chaque type de forme : position,
 *          dimension, couleur, nom
 */

public abstract class FormDrawable2 implements IMovableDrawable {

	protected Rectangle rect;
	protected Point start, end;
	protected Color color;
	protected String name, quantit;
	protected int transp;
	protected int style;
	protected int taillePolice;

	/**
	 * @param color
	 *            the color of this form
	 * @param pos
	 *            the coordinate of the center this form
	 * @param dim
	 *            the dimension of this form
	 * @param name
	 *            the reference if the image          
	 * @param quantit
	 * 			  the quantity recup depuis Screen 2
	 */
	
	public FormDrawable2(Color color, Point pos, Dimension dim, String name) {
		this.color = color;
		this.rect = new Rectangle(dim);
		this.name = name;
		setPosition(pos);
	}
	
	public FormDrawable2(Color color, int style, int taillePolice, Point pos, Dimension dim, String name) {
		this.color = color;
		this.rect = new Rectangle(dim);
		this.name = name;
		this.style = style;
		this.taillePolice = taillePolice;
		setPosition(pos);
	}
	
	public FormDrawable2(Color color, Point pos, Dimension dim, String name, String quantit) {
		this.color = color;
		this.rect = new Rectangle(dim);
		this.name = name;
		this.quantit = quantit;
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
		/**/
		rect.x = (p.x - rect.width / 2);
		rect.y = (p.y - rect.height / 2);
		/**/
		/*
		rect.x = p.x;
		rect.y = p.y;
		*/
	}
}