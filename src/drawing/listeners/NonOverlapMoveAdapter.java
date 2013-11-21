package drawing.listeners;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import drawing.GUIHelper;
import drawing.JCanvas;
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
		System.out.println("+----- State Line = " + GUIHelper.isStateLine());
		// if (drawable == null) {
		setEnd(new Point(e.getX(), e.getY()));
		setMouseUp(true);

		/************************************************************************
		 * if (drawable != null) { if(SwingUtilities.isLeftMouseButton(e)) {
		 * System.out.println("Image : " + drawable.getPosition());
		 * System.out.println("Image : " + drawable.getRectangle()); } }
		 * GUIHelper.setStateChangeSize(false);
		 *************************************************************************/
		if (GUIHelper.isStateLine() == 0) {
			if (GUIHelper.isStateChangeSize()) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					ConstructScreen.changeSizeImage("gav-min");
				}
				GUIHelper.setStateChangeSize(false);
			}
		}

		if (GUIHelper.isStateLine() == 0) {
			if (GUIHelper.isStateDelete()) {
				if (SwingUtilities.isRightMouseButton(e)) {
					canvas.removeDrawable(drawable); // Del drawable clicked
					System.out.println(drawable);
				}
				GUIHelper.setStateDelete(false);
			}
		}

		if (GUIHelper.isStateLine() == 1) {

			switch (GUIHelper.isColorLine()) {
			case 1: // Click Right = RED color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLine(Color.RED);
					GUIHelper.setStateLine(0);
				}

				break;
			case 2: // Click Right = GREEN color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLine(Color.GREEN);
					GUIHelper.setStateLine(0);
				}

				break;
			case 3: // Click Right = Blue color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLine(Color.BLUE);
					GUIHelper.setStateLine(0);
				}

				break;
			case 4: // Click Right = Black color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLine(Color.BLACK);
					GUIHelper.setStateLine(0);
				}

				break;

			default:
				break;
			}
		}

		if (GUIHelper.isStateLine() == 2) {
			switch (GUIHelper.isColorLine()) {
			case 1: // Click Right = Red color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLinePointille(Color.RED);
					GUIHelper.setStateLine(0);
				}

				break;
			case 2: // Click Right = Green color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLinePointille(Color.GREEN);
					GUIHelper.setStateLine(0);
				}

				break;
			case 3: // Click Right = Blue color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLinePointille(Color.BLUE);
					GUIHelper.setStateLine(0);
				}

				break;
			case 4: // Click Right = Black color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLinePointille(Color.BLACK);
					GUIHelper.setStateLine(0);
				}

				break;

			default:
				break;
			}
			// }

			return;
		}

		if (GUIHelper.isStateLine() == 3) {
			switch (GUIHelper.isColorLine()) {
			case 1: // Click Right = Red color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLineFleche(Color.RED);
					GUIHelper.setStateLine(0);
				}

				break;
			case 2: // Click Right = Green color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLineFleche(Color.GREEN);
					GUIHelper.setStateLine(0);
				}

				break;
			case 3: // Click Right = Blue color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLineFleche(Color.BLUE);
					GUIHelper.setStateLine(0);
				}

				break;
			case 4: // Click Right = Black color
				if (SwingUtilities.isRightMouseButton(e)) {
					ConstructScreen.addLineFleche(Color.BLACK);
					GUIHelper.setStateLine(0);
				}

				break;

			default:
				break;
			}
		}
		/*
		 * if (!canvas.isAlone(drawable)) {
		 * drawable.setPosition(initialLocation); } initialLocation = null;
		 */

		drawable = null;

		canvas.repaint();
	}

	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		/*
		 * if (drawable != null) { initialLocation = drawable.getPosition(); }
		 * else {
		 */
		setMouseUp(false);
		setStart(new Point(e.getX(), e.getY()));
		System.out.println("+ START = " + getStart());
		/*
		 * }
		 */
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
	 * @param start
	 *            the start to set
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
	 * @param end
	 *            the end to set
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