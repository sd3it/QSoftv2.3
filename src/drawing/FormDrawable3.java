package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class FormDrawable3 implements IMovableDrawable{
	
	protected Point pos1, pos2;
	protected Color color;

	public FormDrawable3(Color color, Point pos1, Point pos2) {
		this.color = color;
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
	
	public abstract void draw(Graphics g);

	public Point getPos1() {
		return pos1;
	}

	public void setPos1(Point pos1) {
		this.pos1 = pos1;
	}

	public Point getPos2() {
		return pos2;
	}

	public void setPos2(Point pos2) {
		this.pos2 = pos2;
	}
}
