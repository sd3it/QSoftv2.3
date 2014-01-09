package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author KoA
 * @version 0.1
 * 
 *          ImgDrawable : classe qui herite de FormDrawableBis pour dessiner une
 *          image
 */

public class ImgDrawable3 extends FormDrawable2 {
	/** Acces au toolkit : */
	Toolkit toolkit = Toolkit.getDefaultToolkit();

	private static BufferedImage img;
	private static String nomImg;

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 * @param name
	 * @param quantit
	 */

	public ImgDrawable3(Color color, Point pos, Dimension dim, String name,
			String quantit) {
		super(color, pos, dim, name, quantit);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);

		try {
			img = ImageIO.read(new File("images_schema/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				img = ImageIO.read(new File("images_schema/img_unknown.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		/**
		 * Resize de l'image chargé avec les dimensions width et height défini
		 * dans le main
		 */

		int Wimg = img.getWidth()/4;
		int Himg = img.getHeight()/4;
		nomImg = name;

		BufferedImage resizedImage = new BufferedImage(Wimg, Himg,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = resizedImage.createGraphics();
		graphics.drawImage(img, 0, 0, Wimg, Himg, null);

		graphics.dispose();
		
		/**
		 * Dessin de l'image + label
		 */
		rect.width = Wimg;
		rect.height = Himg;
		g.drawImage(resizedImage, rect.x, rect.y, null);
		//g.drawRect(rect.x, rect.y, rect.width, rect.height);	// Cadre de l'image (a retirer apres les tests)
		Font font = new Font("TimesRoman", 0, 12);
		g.setFont(font);
		g.drawString("x" + quantit + " " + name,
				(rect.x + resizedImage.getHeight(null) / 4), (rect.y
						+ resizedImage.getHeight(null) + 15));
		g.setColor(c);
	}
}