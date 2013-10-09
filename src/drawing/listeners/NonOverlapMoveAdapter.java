package drawing.listeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import drawing.GUIHelper;
import drawing.IDrawable;
import drawing.JCanvas;
import drawing.LineDrawable;
import drawing.MoveDrawableMouseListener;

/**
 * @author KoA
 * @version 0.1
 * 
 *          NonOverlapMoveAdapter : verification, avant de relacher la figure,
 *          qu'elle ne sera pas deposee a un endroit ou il y a deja une autre
 *          figure. Si c'est le cas, le drawable est remis a sa position
 *          initiale.
 */
public class NonOverlapMoveAdapter extends MoveDrawableMouseListener {

	private Point initialLocation;
	private static Point start;
	private static Point end;
	private static boolean mouseUp = false;

	/**
	 * @param canvas
	 */
	public NonOverlapMoveAdapter(JCanvas canvas) {
		super(canvas);
	}
	

	public void mouseReleased(MouseEvent e) {
		if (drawable == null) {
			setEnd(new Point(e.getX(), e.getY()));
			System.out.println("+ END = " + getEnd());
			setMouseUp(true);
			/*
			System.out.println("stateLine = " + GUIHelper.isStateLine());
			if (GUIHelper.isStateLine()) {
				IDrawable line = new LineDrawable(Color.GREEN, start, end);
				canvas.addDrawable(line);
				GUIHelper.setStateLine(false);
			}
			*/
			return;
		}
		if (!canvas.isAlone(drawable)) {
			drawable.setPosition(initialLocation);
		}
		initialLocation = null;
		drawable = null;

		canvas.repaint();
	}

	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);

		if (drawable != null) {
			initialLocation = drawable.getPosition();
		} else {
			setMouseUp(false);
			setStart(new Point(e.getX(), e.getY()));
			System.out.println("+ START = " + getStart());
		}
	}

	/**
	 * @param mouseUp
	 *            the mouseUp to set
	 */
	public void setMouseUp(boolean mouseUp) {
		NonOverlapMoveAdapter.mouseUp = mouseUp;
	}

	/**
	 * @return the mouseUp
	 */
	public static boolean isMouseUp() {
		return mouseUp;
	}

	/**
	 * @param start the start to set
	 */
	public static void setStart(Point start) {
		NonOverlapMoveAdapter.start = start;
	}

	/**
	 * @return the start
	 */
	public static Point getStart() {
		return start;
	}

	/**
	 * @param end the end to set
	 */
	public static void setEnd(Point end) {
		NonOverlapMoveAdapter.end = end;
	}

	/**
	 * @return the end
	 */
	public static Point getEnd() {
		return end;
	}
}