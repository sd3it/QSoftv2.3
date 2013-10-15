package drawing;

import ihm.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import drawing.demos.ConstructScreen;

/**
 * @author KoA
 * @version 0.1
 * 
 *          GUIHelper : mettre le JPanel dans la frame et l'afficher à l'ecran
 */

public class GUIHelper {

	/*
	 * State of isStateLine : - 0 : no line - 1 : pleine - 2 : pointille
	 */

	protected static int stateLine = 0;
	protected static boolean stateGomme = false;

	public static void showOnFrame(JComponent component, String frameName) {
		final JFrame frame = new JFrame(frameName);

		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// Si non sauvegardé
				if (!ConstructScreen.getSave()) {
					int reponse = 0;

					reponse = javax.swing.JOptionPane
							.showConfirmDialog(
									new javax.swing.JFrame(),
									"You forgot to save your schema. Would you like to save it now?",
									"Confirmation", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);

					// si rep = yes
					if (reponse == JOptionPane.YES_OPTION) {
						ConstructScreen.savePNG();
						// System.exit(0);
						frame.dispose();
						ConstructScreen.clear();
					}
					// sinon si rep = no
					else if (reponse == JOptionPane.NO_OPTION) {
						// System.exit(0);
						frame.dispose();
						ConstructScreen.clear();
					}
				}

				// si sauvegardé
				else {
					// System.exit(0);
					frame.dispose();
					ConstructScreen.clear();
				}
			}
		};

		frame.addWindowListener(wa);
		frame.getContentPane().add(component);

		frame.setJMenuBar(createMenuBar());
		frame.setIconImage(new ImageIcon("logoframe.png").getImage());

		frame.setLocation(50, 50);

		frame.pack();

		frame.setVisible(true);
	}

	// Creation menu
	public static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		/* Menu 1 */
		JMenu Menu1 = new JMenu();
		JMenuItem menuItem11 = new JMenuItem();
		JMenu Menu11 = new JMenu();
		JMenuItem menuItem111 = new JMenuItem();
		JMenuItem menuItem112 = new JMenuItem();
		// JMenuItem menuItem113 = new JMenuItem("-------->");
		JMenuItem menuItem12 = new JMenuItem();
		JMenuItem menuItem13 = new JMenuItem();

		/* Menu 2 */
		JMenu Menu2 = new JMenu();
		JMenuItem menuItem21 = new JMenuItem();
		JMenuItem menuItem22 = new JMenuItem();
		JMenuItem menuItem23 = new JMenuItem();
		JMenuItem menuItem24 = new JMenuItem();

		/* Menu 3 */
		JMenu Menu3 = new JMenu();
		final JMenuItem menuItem31 = new JMenuItem();
		final JMenuItem menuItem32 = new JMenuItem();
		final JMenuItem menuItem33 = new JMenuItem();
		final JMenuItem menuItem34 = new JMenuItem();
		final JMenuItem menuItem35 = new JMenuItem();
		final JMenuItem menuItem36 = new JMenuItem();
		final JMenuItem menuItem37 = new JMenuItem();
		final JMenuItem menuItem38 = new JMenuItem();
		final JMenuItem menuItem39 = new JMenuItem();
		final JMenuItem menuItem310 = new JMenuItem();

		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText("Actions");
			menuItem11.setText("Add Text");
			Menu11.setText("Add Line");
			menuItem111.setText("_________");
			menuItem112.setText("_ _ _ _ _ _");
			menuItem12.setText("Add Gomme");
			menuItem13.setText("Save to PNG file");

			/* Texte Menu 2 */
			Menu2.setText("Add elements");
			menuItem21.setText("EoL (End of Line)");
			menuItem22.setText("+");
			menuItem23.setText("=");
			menuItem24.setText("RAL");

			/* Texte Menu 3 */
			Menu3.setText("Add synoptique");
			menuItem31.setText("Synoptique ALPHA 2");
			menuItem32.setText("Synoptique ALPHA 4-8-12");
			menuItem33.setText("Synoptique ALPHA 16-248");
			menuItem34.setText("Synoptique MEPFLASH");
			menuItem35.setText("Synoptique HEPHAIS 128");
			menuItem36.setText("Synoptique HEPHAIS 1600NE");
			menuItem37.setText("Synoptique HEPHAIS 1600");
			menuItem38.setText("Synoptique HEPHAIS 1600 NETWORK");
			menuItem39.setText("Synoptique HEPHAIS 1600 COMFORT");
			menuItem310.setText("Synoptique WIRELESS SYSTEM");

		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText("Actions");
			menuItem11.setText("Add Text");
			Menu11.setText("Add Line");
			menuItem111.setText("_________");
			menuItem112.setText("_ _ _ _ _ _");
			menuItem12.setText("Add Gomme");
			menuItem13.setText("Save to PNG file");

			/* Texte Menu 2 */
			Menu2.setText("Add elements");
			menuItem21.setText("EoL (End of Line)");
			menuItem22.setText("+");
			menuItem23.setText("=");
			menuItem24.setText("RAL");

			/* Texte Menu 3 */
			Menu3.setText("Add schema");
			menuItem31.setText("Synoptique ALPHA 2");
			menuItem32.setText("Synoptique ALPHA 4-8-12");
			menuItem33.setText("Synoptique ALPHA 16-248");
			menuItem34.setText("Synoptique MEPFLASH");
			menuItem35.setText("Synoptique HEPHAIS 128");
			menuItem36.setText("Synoptique HEPHAIS 1600NE");
			menuItem37.setText("Synoptique HEPHAIS 1600");
			menuItem38.setText("Synoptique HEPHAIS 1600 NETWORK");
			menuItem39.setText("Synoptique HEPHAIS 1600 COMFORT");
			menuItem310.setText("Synoptique WIRELESS SYSTEM");

		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText("Outils");
			menuItem11.setText("Outils Texte");
			Menu11.setText("Outils Ligne");
			menuItem111.setText("_________");
			menuItem112.setText("_ _ _ _ _ _");
			menuItem12.setText("Outils Gomme");
			menuItem13.setText("Sauvegarder en fichier PNG");

			/* Texte Menu 2 */
			Menu2.setText("Ajouter des élements");
			menuItem21.setText("EoL (End of Line)");
			menuItem22.setText("+");
			menuItem23.setText("=");
			menuItem24.setText("RAL");

			/* Texte Menu 3 */
			Menu3.setText("Ajouter un synoptique");
			menuItem31.setText("Synoptique ALPHA 2");
			menuItem32.setText("Synoptique ALPHA 4-8-12");
			menuItem33.setText("Synoptique ALPHA 16-248");
			menuItem34.setText("Synoptique MEPFLASH");
			menuItem35.setText("Synoptique HEPHAIS 128");
			menuItem36.setText("Synoptique HEPHAIS 1600NE");
			menuItem37.setText("Synoptique HEPHAIS 1600");
			menuItem38.setText("Synoptique HEPHAIS 1600 NETWORK");
			menuItem39.setText("Synoptique HEPHAIS 1600 COMFORT");
			menuItem310.setText("Synoptique WIRELESS SYSTEM");
		}

		/* Ajout des Items */
		Menu1.add(menuItem11);
		Menu1.add(menuItem12);
		Menu1.add(Menu11);
		Menu11.add(menuItem111);
		Menu11.add(menuItem112);
		// Menu11.add(menuItem113);
		Menu1.add(menuItem13);

		Menu3.add(menuItem31);
		Menu3.add(menuItem32);
		Menu3.add(menuItem33);
		Menu3.add(menuItem34);
		Menu3.add(menuItem35);
		Menu3.add(menuItem36);
		Menu3.add(menuItem37);
		Menu3.add(menuItem38);
		Menu3.add(menuItem39);
		Menu3.add(menuItem310);

		Menu2.add(Menu3);
		Menu2.add(menuItem21);
		Menu2.add(menuItem22);
		Menu2.add(menuItem23);
		Menu2.add(menuItem24);

		/* Ajout des Menu au MenuBar */
		menuBar.add(Menu1);
		menuBar.add(Menu2);

		menuItem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FenetreAjoutTexte tf = new FenetreAjoutTexte();
				tf.setVisible(true);
			}
		});

		menuItem111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(1);
			}
		});

		menuItem112.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(2);
			}
		});
		/*
		 * menuItem113.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { setStateLine(3); } });
		 */

		menuItem12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateGomme(true);
			}
		});

		menuItem13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.saveAndPrintPNG();
			}
		});

		menuItem21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addText("EoL");
			}
		});

		menuItem22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addText("+");
			}
		});

		menuItem23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addText("=");
			}
		});

		menuItem24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addText("RAL");
			}
		});

		menuItem31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem31.getText());
			}
		});

		menuItem32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem32.getText());
			}
		});

		menuItem33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem33.getText());
			}
		});

		menuItem34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem34.getText());
			}
		});

		menuItem35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem35.getText());
			}
		});

		menuItem36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem36.getText());
			}
		});

		menuItem37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem37.getText());
			}
		});

		menuItem38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem38.getText());
			}
		});

		menuItem39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem39.getText());
			}
		});

		menuItem310.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem310.getText());
			}
		});

		return menuBar;
	}

	public static int isStateLine() {
		return stateLine;
	}

	public static void setStateLine(int stateLine) {
		GUIHelper.stateLine = stateLine;
	}

	public static boolean isStateGomme() {
		return stateGomme;
	}

	public static void setStateGomme(boolean stateGomme) {
		GUIHelper.stateGomme = stateGomme;
	}
}