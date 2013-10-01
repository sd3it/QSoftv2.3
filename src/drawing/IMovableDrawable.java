package drawing;

/**
 * @author KoA
 * @version 0.1
 * 
 *          IMovableDrawable : herite de IDrawable. Contient des accesseurs pour
 *          un objet de type Point. Ce type correspond a la position que l'on
 *          souhaite donner a une figure. Cette position correspond au centre de
 *          la figure.
 */

import java.awt.Point;

public interface IMovableDrawable extends IDrawable {

	void setPosition(Point p);

	Point getPosition();
}