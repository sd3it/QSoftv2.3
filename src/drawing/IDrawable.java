package drawing;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author KoA
 * @version 0.1
 * 
 *          IDrawable : interface qui represente un ojet qui sait commment etre
 *          dessine.
 * 
 */

public interface IDrawable {
	/**
	 * @pre: g!=null
	 * @post: configuration de g inchangee
	 */
	public abstract void draw(Graphics g);

	/**
	 * @pre:
	 * @return le rectangle qui contient completement this.
	 */
	public abstract Rectangle getRectangle();	
	
}