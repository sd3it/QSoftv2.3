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

/**
 * @author KoA
 * @version 0.1
 * 
 *          ImgDrawable : classe qui herite de FormDrawableBis pour dessiner une
 *          image
 */

public class ImgDrawable extends FormDrawable2 {
	/** Acces au toolkit : */
	Toolkit toolkit = Toolkit.getDefaultToolkit();

	private BufferedImage img;

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 * @param name
	 * @param quantit
	 */

	public ImgDrawable(Color color, Point pos, Dimension dim, String name,
			String quantit) {
		super(color, pos, dim, name, quantit);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);

		try {
			img = ImageIO.read(new File("images_schema/" + name + ".png"));
			System.out.println(name + " loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Img Unknown");
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
		/*
		 * BufferedImage resizedImage = new BufferedImage(rect.width,
		 * rect.height, BufferedImage.TYPE_INT_ARGB); Graphics2D graphics =
		 * resizedImage.createGraphics(); graphics.drawImage(img, 0, 0,
		 * rect.width, rect.height, null); graphics.dispose();
		 */
		int Wimg = img.getWidth();
		int Himg = img.getHeight();

		BufferedImage resizedImage = new BufferedImage(Wimg, Himg,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D graphics = resizedImage.createGraphics();
		graphics.drawImage(img, 0, 0, Wimg, Himg, null);

		graphics.dispose();

		/**
		 * Dessin de l'image + label
		 */
		g.drawImage(resizedImage, rect.x, rect.y, null);
		g.drawString("x" + quantit + " " + name,
				(rect.x + resizedImage.getHeight(null) / 4), (rect.y
						+ resizedImage.getHeight(null) + 15));
		g.setColor(c);
	}
}