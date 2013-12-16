package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author KoA
 * @version 0.1
 * 
 *          TextDrawable : classe qui herite de FormDrawable pour ecrire du
 *          texte
 */

public class TextDrawable extends FormDrawable2 {

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 * @param name
	 * @param style
	 */

	public TextDrawable(Color color, int style, int taillePolice, Point pos, Dimension dim,
			String name) {
		super(color, style, taillePolice, pos, dim, name);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);

		Font font = new Font("TimesRoman", style, taillePolice);
		g.setFont(font);

		g.drawString(name, rect.x, rect.y + 10);
		// g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.setColor(c);
	}
}