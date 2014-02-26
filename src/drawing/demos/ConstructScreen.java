package drawing.demos;

import ihm.Screen1;
import ihm.Window;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.itextpdf.text.Font;

import drawing.FenetreAjoutComposant;
import drawing.FenetreAjoutTexte;
import drawing.GUIHelper;
import drawing.IDrawable;
import drawing.ImgDrawable;
import drawing.ImgDrawable3;
import drawing.ImgDrawable4;
import drawing.JCanvas;
import drawing.LineDrawable1;
import drawing.LineDrawable2;
import drawing.LineDrawable3;
import drawing.TextDrawable;
import drawing.listeners.NonOverlapMoveAdapter;

/**
 * @author KoA
 * @version 0.1
 * 
 *          ConstructScreen : Class permettant la construction du JCanvas
 * 
 */
public class ConstructScreen {

	static JCanvas jc = new JCanvas();
	static Image img;
	static String parents = FileSystemView.getFileSystemView()
			.getHomeDirectory().getAbsolutePath();
	private static File f = null;
	private static Boolean save = false;

	private javax.swing.JLabel lb_logo;
	private JScrollPane scroll = new JScrollPane(jc);

	public ConstructScreen() {

		jc.setBackground(Color.WHITE);

		int widthScreen = 800;
		int heightScreen = 600;

		int px = 80;
		int py = 180;

		jc.setPreferredSize(new Dimension(widthScreen, heightScreen));

		Dimension dim = new Dimension(100, 100);

		for (int row = 0; row <= Window.reference.size() - 1; row++) {
			for (int column = 0; column <= 6; column++) {
				if (column == 1) {
					// Si colonne reference n'est pas vide
					if (!Window.reference.get(row).isEmpty()) {
						/*
						 * Si colonne reference contient un "/" -> on le
						 * remplace par un "" et suppression de l'espace final si besoin
						 */
						if (Window.reference.get(row).contains("/")) {
							IDrawable img = new ImgDrawable(Color.BLACK,
									new Point(px, py), dim, Window.reference
											.get(row).replace("/", "").trim(),
									Window.quantity.get(row));
							jc.addDrawable(img);
						} else { // Sinon Ok
							IDrawable img = new ImgDrawable(Color.BLACK,
									new Point(px, py), dim,
									Window.reference.get(row).trim(),
									Window.quantity.get(row));
							jc.addDrawable(img);
						}
					}

				}
				px = px + 20;
				if (px >= 750) {
					py = py + 150;
					px = 80;
				}
			}
		}

		IDrawable date = new TextDrawable(Color.BLACK, Font.NORMAL, 15,
				new Point(20, 20), new Dimension(10, 10), new SimpleDateFormat(
						"dd/MM/yyyy").format(new Date()));
		jc.addDrawable(date);

		if (!Window.referencequot.isEmpty()) {
			IDrawable reference = new TextDrawable(Color.BLACK, Font.NORMAL,
					15, new Point(20, 40), new Dimension(10, 10), "Reference: "
							+ Window.referencequot);
			jc.addDrawable(reference);
		}

		lb_logo = new JLabel(Screen1.getImg());
		jc.add(lb_logo);

		new NonOverlapMoveAdapter(jc);

		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			GUIHelper.showOnFrame(jc,
					(String) Window.res.getObject("title_schema"));
		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			GUIHelper.showOnFrame(jc,
					(String) Window.res.getObject("title_schema"));
		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			GUIHelper.showOnFrame(jc,
					(String) Window.res.getObject("title_schema"));
		}
	}

	/**
	 * Methode d'ajout d'une ligne pleine
	 */
	public static void addLine(Color c) {
		IDrawable l1 = new LineDrawable1(c, new Point(
				NonOverlapMoveAdapter.getEnd()), new Point(
				NonOverlapMoveAdapter.getStart()), new Dimension(8, 8));
		/*IDrawable l1 = new LineDrawable1(c, new Point(
				100,60), new Point(
				60,60), new Dimension(8, 8));*/
		jc.addDrawable(l1);
	}

	/**
	 * Methode d'ajout d'une ligne pointille
	 */
	public static void addLinePointille(Color c) {
		// IDrawable l2 = new LineDrawable2(c, new
		// Point(NonOverlapMoveAdapter.getEnd()), new
		// Point(NonOverlapMoveAdapter.getStart()), new Dimension(2, 3));
		IDrawable l2 = new LineDrawable2(c, new Point(
				NonOverlapMoveAdapter.getEnd()), new Point(
				NonOverlapMoveAdapter.getStart()), new Dimension(8, 8));
		jc.addDrawable(l2);
	}

	/**
	 * Methode d'ajout d'une ligne flèché
	 */
	public static void addLineFleche(Color c) {
		IDrawable l3 = new LineDrawable3(c, new Point(
				NonOverlapMoveAdapter.getEnd()), new Point(
				NonOverlapMoveAdapter.getStart()), new Dimension(8, 8));
		jc.addDrawable(l3);
	}

	/**
	 * Methode d'ajout de Texte
	 */
	public static void addText(String lab) {
		IDrawable txt3 = new TextDrawable(FenetreAjoutTexte.getColText(),
				FenetreAjoutTexte.getStyle(),
				FenetreAjoutTexte.getTaillePolice(), new Point(500, 100),
				new Dimension(10, 30), lab);
		jc.addDrawable(txt3);
	}

	/**
	 * Methode d'ajout de Texte plus grand
	 */
	public static void addTextGrd(String lab) {
		IDrawable txt3 = new TextDrawable(Color.BLACK, Font.BOLD, 26,
				new Point(500, 100), new Dimension(10, 30), lab);
		jc.addDrawable(txt3);
	}

	/**
	 * Méthode d'ajout d'une image
	 */
	public static void addImg(String name) {
		IDrawable img3 = new ImgDrawable(Color.BLACK, new Point(200, 250),
				new Dimension(200, 200), name, "1");
		jc.addDrawable(img3);
	}
	
	/**
	 * Méthode d'ajout d'une image sans texte
	 */
	public static void addImgNoNamed(String name) {
		IDrawable img4 = new ImgDrawable4(Color.BLACK, new Point(200, 250),
				new Dimension(200, 200), name, "1");
		jc.addDrawable(img4);
	}
	
	/**
	 * Méthode d'ajout d'un composant avec choix de la taille de l'image
	 */
	public static void addImgComponant(String name, String quantity) {
		if (FenetreAjoutComposant.getStyle() == 100) {
			IDrawable img3 = new ImgDrawable(Color.BLACK, new Point(670, 170),
					new Dimension(100, 100), name, quantity);
			jc.addDrawable(img3);
		} else if (FenetreAjoutComposant.getStyle() == 30) {
			IDrawable img3 = new ImgDrawable3(Color.BLACK, new Point(670, 170),
					new Dimension(30, 30), name, quantity);
			jc.addDrawable(img3);
		}
		FenetreAjoutComposant.setStyle(100);
	}

	/**
	 * Sauvegarde en PNG du JCanvas
	 */
	public static void savePNG() {
		JFileChooser chooser = new JFileChooser(parents) {
			private static final long serialVersionUID = 1L;

			@Override
			public void approveSelection() {

				if (getSelectedFile().getAbsolutePath().endsWith(".png")) {
					f = new File(getSelectedFile().getAbsolutePath());
				} else {
					f = new File(getSelectedFile().getAbsolutePath() + ".png");
				}

				if (f.exists()) {
					parents = f.getParent();

					int answer = 0;
					if (Window.locale.toString().equals("en")) {
						answer = JOptionPane.showConfirmDialog(this, f
								+ " exists. Overwrite?", "Overwrite?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
					}
					if (Window.locale.toString().equals("it")) {
						answer = JOptionPane.showConfirmDialog(this, f
								+ " esiste. Sovrascrivere?", "Sovrascrivere?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
					}
					if (Window.locale.toString().equals("fr")) {
						answer = JOptionPane.showConfirmDialog(this, f
								+ " existe. Remplacer?", "Remplacer?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
					}

					if (answer != JOptionPane.OK_OPTION) {
						return;
					}
				}
				super.approveSelection();
			}
		};

		chooser.setAcceptAllFileFilterUsed(false);

		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"PNG File (.png)", "png");
		chooser.setFileFilter(filter);
		chooser.setSelectedFile(new File("Schema_"
				+ new SimpleDateFormat("dd.MM.yyyy").format(new Date())));

		int returnVal = chooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				Rectangle r = jc.getBounds();
				img = jc.createImage(r.width, r.height);
				Graphics g = img.getGraphics();
				jc.paint(g);
				ImageIO.write((RenderedImage) img, "png", f);
				setSave(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sauvegarder et Afficher le PNG du JCanvas
	 */
	public static void saveAndPrintPNG() {

		JFileChooser chooser = new JFileChooser(parents) {
			private static final long serialVersionUID = 1L;

			@Override
			public void approveSelection() {

				if (getSelectedFile().getAbsolutePath().endsWith(".png")) {
					f = new File(getSelectedFile().getAbsolutePath());
				} else {
					f = new File(getSelectedFile().getAbsolutePath() + ".png");
				}

				if (f.exists()) {
					parents = f.getParent();

					int answer = 0;
					if (Window.locale.toString().equals("en")) {
						answer = JOptionPane.showConfirmDialog(this, f
								+ " exists. Overwrite?", "Overwrite?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
					}
					if (Window.locale.toString().equals("it")) {
						answer = JOptionPane.showConfirmDialog(this, f
								+ " esiste. Sovrascrivere?", "Sovrascrivere?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
					}
					if (Window.locale.toString().equals("fr")) {
						answer = JOptionPane.showConfirmDialog(this, f
								+ " existe. Remplacer?", "Remplacer?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
					}

					if (answer != JOptionPane.OK_OPTION) {
						return;
					}
				}
				super.approveSelection();
			}
		};

		chooser.setAcceptAllFileFilterUsed(false);

		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"PNG File(.png)", "png");
		chooser.setFileFilter(filter);
		chooser.setSelectedFile(new File("Schema_"
				+ new SimpleDateFormat("dd.MM.yyyy").format(new Date())));

		int returnVal = chooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				Rectangle r = jc.getBounds();
				img = jc.createImage(r.width, r.height);
				Graphics g = img.getGraphics();
				jc.paint(g);
				ImageIO.write((RenderedImage) img, "png", f);
				setSave(true);
				System.out.println("save = " + save);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();

				if (desktop.isSupported(Desktop.Action.OPEN)) {
					if (chooser.getSelectedFile().getAbsolutePath()
							.endsWith(".png")) {
						try {
							desktop.open(new File(chooser.getSelectedFile()
									.getAbsolutePath()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							desktop.open(new File(chooser.getSelectedFile()
									.getAbsolutePath() + ".png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * Permet de vider le jCanvas quand on quitte
	 */
	public static void clear() {
		jc.clear();
		jc.removeAll();
		System.out.println("Clean frame");
	}

	/**
	 * @param save
	 *            the save to set
	 */
	public static void setSave(Boolean save) {
		ConstructScreen.save = save;
	}

	/**
	 * @return the save
	 */
	public static Boolean getSave() {
		return save;
	}
}