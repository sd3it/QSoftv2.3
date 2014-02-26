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
 *          ImgDrawable4 : classe qui herite de FormDrawable2 pour dessiner une
 *          image sans texte en dessous
 */

public class ImgDrawable4 extends FormDrawable2 {
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

	public ImgDrawable4(Color color, Point pos, Dimension dim, String name,
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

		int Wimg = img.getWidth();
		int Himg = img.getHeight();
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
		// g.drawRect(rect.x, rect.y, rect.width, rect.height); // Cadre de
		// l'image (a retirer apres les tests)

		g.setColor(c);
	}

	public static String getNomImg() {
		return nomImg;
	}

	public static void setNomImg(String nomImg) {
		ImgDrawable4.nomImg = nomImg;
	}

	/** NEW FOR RESIZE IMG **/
	public static BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
}
