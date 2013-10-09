package drawing.listeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import drawing.GUIHelper;
import drawing.IDrawable;
import drawing.JCanvas;
import drawing.LineDrawable1;
import drawing.MoveDrawableMouseListener;
import drawing.demos.ConstructScreen;

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
		System.out.println("+ END = " + getEnd());
		if (drawable == null) {
			setEnd(new Point(e.getX(), e.getY()));
			//System.out.println("+ END = " + getEnd());
			setMouseUp(true);
			/*
			System.out.println("stateLine = " + GUIHelper.isStateLine());
			if (GUIHelper.isStateLine()) {
				IDrawable line = new LineDrawable(Color.GREEN, start, end);
				canvas.addDrawable(line);
				GUIHelper.setStateLine(false);
			}
			*/
			System.out.println("stateLine = " + GUIHelper.isStateLine());
			if (GUIHelper.isStateLine()) {
				/*IDrawable r = new LineDrawable1(Color.black, new Point(60,85), new Dimension(120,46));
				canvas.addDrawable(r);*/
				ConstructScreen.addLine(Color.BLUE);
				GUIHelper.setStateLine(false);
			}
			
			return;
		}
		/*if (!canvas.isAlone(drawable)) {
			drawable.setPosition(initialLocation);
			System.out.println("aie");
		}*/
		//initialLocation = null;
		drawable = null;

		canvas.repaint();
	}

	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		/*
		if (drawable != null) {
			initialLocation = drawable.getPosition();
		} else {
		*/
			setMouseUp(false);
			setStart(new Point(e.getX(), e.getY()));
			System.out.println("+ START = " + getStart());

		//}
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