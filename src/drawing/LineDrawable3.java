package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 * @author KoA
 * @version 0.1
 * 
 *          LineDrawable2 : classe qui herite de FormDrawable3 pour dessiner
 *          une ligne flèché
 */
public class LineDrawable3 extends FormDrawable3 {

	/**
	 * @param color
	 * @param pos
	 * @param pos2
	 * @param dim
	 */
	public LineDrawable3(Color color, Point pos, Point pos2, Dimension dim) {
		super(color, pos, pos2, dim);
	}

	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(color);
		
		
		
		float[] style = {40,0}; // Pas de pointillés
		((Graphics2D) g).setStroke( 
			new BasicStroke( 
				4, // taille de la ligne 
				BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_MITER,
				10.0f,
				style,
				0
		    )
		);
		/*
		g.drawLine(rect.x, rect.y+1, rect2.x, rect2.y+1);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
		
		int[] pPx = {rect.x,rect.x+10,rect.x};
		int[] pPy = {rect.y-10,rect.y,rect.y+10};
		g.fillPolygon(pPx, pPy, 3);
		
		g.setColor(c);
		*/
		/******/
		float arrowWidth = 10.0f ;
		float theta = 0.423f ;
		int[] xPoints = new int[ 3 ] ;
		int[] yPoints = new int[ 3 ] ;
		float[] vecLine = new float[ 2 ] ;
		float[] vecLeft = new float[ 2 ] ;
		float fLength;
		float th;
		float ta;
		float baseX, baseY ;
		
		xPoints[ 0 ] = rect2.x; //rect2.x
		yPoints[ 0 ] = rect2.y ; //rect2.y
		// build the line vector
		vecLine[ 0 ] = (float)xPoints[ 0 ] - rect.x ;	//rect.x
		vecLine[ 1 ] = (float)yPoints[ 0 ] - rect.y ;	//rect.y
		// build the arrow base vector - normal to the line
		vecLeft[ 0 ] = -vecLine[ 1 ] ;
		vecLeft[ 1 ] = vecLine[ 0 ] ;
		// setup length parameters
		fLength = (float)Math.sqrt( vecLine[0] * vecLine[0] + vecLine[1] * vecLine[1] ) ;
		th = arrowWidth / ( 2.0f * fLength ) ;
		ta = arrowWidth / ( 2.0f * ( (float)Math.tan( theta ) / 2.0f ) * fLength ) ;
		// find the base of the arrow
		baseX = ( (float)xPoints[ 0 ] - ta * vecLine[0]);
		baseY = ( (float)yPoints[ 0 ] - ta * vecLine[1]);
		// build the points on the sides of the arrow
		xPoints[1] = (int)( baseX + th * vecLeft[0] );
		yPoints[1] = (int)( baseY + th * vecLeft[1] );
		xPoints[2] = (int)( baseX - th * vecLeft[0] );
		yPoints[2] = (int)( baseY - th * vecLeft[1] );
		
		g.drawLine( rect.x, rect.y, (int)baseX, (int)baseY ) ;
		g.fillPolygon( xPoints, yPoints, 3 ) ;
		g.setColor(Color.CYAN);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
		g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
		
		
		g.setColor(c);
	}
}