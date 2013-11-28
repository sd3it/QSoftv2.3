package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgDrawable2 extends FormDrawable2 {
	/** Acces au toolkit : */
	Toolkit toolkit = Toolkit.getDefaultToolkit();

	private static BufferedImage img2;

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 * @param name
	 * @param quantit
	 */

	public ImgDrawable2(Color color, Point pos, Dimension dim, String name,
			String quantit) {
		super(color, pos, dim, name, quantit);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);

		img2 = ImgDrawable.getImg();

		/**
		 * Resize de l'image chargé avec les dimensions width et height défini
		 * dans le main
		 */

		int Wimg2 = img2.getWidth()/2;
		int Himg2 = img2.getHeight()/2;

		BufferedImage resizedImage = new BufferedImage(Wimg2, Himg2,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = resizedImage.createGraphics();
		graphics.drawImage(img2, 0, 0, Wimg2, Himg2, null);

		graphics.dispose();

		/**
		 * Dessin de l'image + label
		 */
		rect.width = Wimg2;
		rect.height = Himg2;
		g.drawImage(resizedImage, rect.x, rect.y, null);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);	// Cadre de l'image (a retirer apres les tests)
		g.drawString("x" + quantit + " " + name,
				(rect.x + resizedImage.getHeight(null) / 4), (rect.y
						+ resizedImage.getHeight(null) + 15));
		g.setColor(c);
	}
}