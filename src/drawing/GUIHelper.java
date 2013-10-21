package drawing;

import ihm.Window;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
 *          GUIHelper : mettre le JPanel dans la frame et l'afficher � l'ecran
 */

public class GUIHelper {

	/*
	 * State of isStateLine : - 0 : no line - 1 : pleine - 2 : pointille
	 */

	protected static int stateLine = 0;
	protected static int colorLine = 0;
	protected static boolean stateGomme = false;

	public static void showOnFrame(JComponent component, String frameName) {
		final JFrame frame = new JFrame(frameName);

		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// Si non sauvegard�
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

				// si sauvegard�
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

		JMenu Menu111 = new JMenu();
		JMenuItem menuItem1111 = new JMenuItem();
		JMenuItem menuItem1112 = new JMenuItem();
		JMenuItem menuItem1113 = new JMenuItem();
		JMenuItem menuItem1114 = new JMenuItem();

		JMenu Menu112 = new JMenu();
		JMenuItem menuItem1121 = new JMenuItem();
		JMenuItem menuItem1122 = new JMenuItem();
		JMenuItem menuItem1123 = new JMenuItem();
		JMenuItem menuItem1124 = new JMenuItem();

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
		final JMenuItem menuItem311 = new JMenuItem();
		final JMenuItem menuItem312 = new JMenuItem();
		final JMenuItem menuItem313 = new JMenuItem();
		final JMenuItem menuItem314 = new JMenuItem();
		final JMenuItem menuItem315 = new JMenuItem();
		final JMenuItem menuItem316 = new JMenuItem();
		final JMenuItem menuItem317 = new JMenuItem();

		JMenu Menu4 = new JMenu();
		final JMenuItem menuItem41 = new JMenuItem();

		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText("Actions");
			menuItem11.setText("Add Text");
			Menu11.setText("Add Line");
			Menu111.setText("_________");
			menuItem1111.setText("Red");
			menuItem1112.setText("Green");
			menuItem1113.setText("Blue");
			menuItem1114.setText("Black");
			Menu112.setText("_ _ _ _ _ _");
			menuItem1121.setText("Red");
			menuItem1122.setText("Green");
			menuItem1123.setText("Blue");
			menuItem1124.setText("Black");

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
			menuItem311.setText("Synoptique DFA05");
			menuItem312.setText("Synoptique DLF");
			menuItem313.setText("Synoptique EX Adressable Interface");
			menuItem314.setText("Synoptique EX Gas Detection");
			menuItem315.setText("Synoptique Heat Cable");
			menuItem316.setText("Synoptique Monitoring Software");
			menuItem317.setText("Synoptique Passerelle Radio");

			/* Texte Menu 4 */
			Menu4.setText("Help");
			menuItem41.setText("How to use Schema");

		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText("Actions");
			menuItem11.setText("Add Text");
			Menu11.setText("Add Line");
			Menu111.setText("_________");
			menuItem1111.setText("Red");
			menuItem1112.setText("Green");
			menuItem1113.setText("Blue");
			menuItem1114.setText("Black");
			Menu112.setText("_ _ _ _ _ _");
			menuItem1121.setText("Red");
			menuItem1122.setText("Green");
			menuItem1123.setText("Blue");
			menuItem1124.setText("Black");

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
			menuItem311.setText("Synoptique DFA05");
			menuItem312.setText("Synoptique DLF");
			menuItem313.setText("Synoptique EX Adressable Interface");
			menuItem314.setText("Synoptique EX Gas Detection");
			menuItem315.setText("Synoptique Heat Cable");
			menuItem316.setText("Synoptique Monitoring Software");
			menuItem317.setText("Synoptique Passerelle Radio");

			/* Texte Menu 4 */
			Menu4.setText("Help");
			menuItem41.setText("About Schema");

		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText("Outils");
			menuItem11.setText("Outils Texte");
			Menu11.setText("Add Line");
			Menu111.setText("_________");
			menuItem1111.setText("Red");
			menuItem1112.setText("Green");
			menuItem1113.setText("Blue");
			menuItem1114.setText("Black");
			Menu112.setText("_ _ _ _ _ _");
			menuItem1121.setText("Red");
			menuItem1122.setText("Green");
			menuItem1123.setText("Blue");
			menuItem1124.setText("Black");

			menuItem12.setText("Outils Gomme");
			menuItem13.setText("Sauvegarder en fichier PNG");

			/* Texte Menu 2 */
			Menu2.setText("Ajouter des �lements");
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
			menuItem311.setText("Synoptique DFA05");
			menuItem312.setText("Synoptique DLF");
			menuItem313.setText("Synoptique EX Adressable Interface");
			menuItem314.setText("Synoptique EX Gas Detection");
			menuItem315.setText("Synoptique Heat Cable");
			menuItem316.setText("Synoptique Monitoring Software");
			menuItem317.setText("Synoptique Passerelle Radio");

			/* Texte Menu 4 */
			Menu4.setText("Aide");
			menuItem41.setText("Comment utiliser Schema");
		}

		/* Ajout des Items */
		Menu1.add(menuItem11);
		Menu1.add(menuItem12);
		Menu1.add(Menu11);

		Menu11.add(Menu111);
		Menu111.add(menuItem1111);
		Menu111.add(menuItem1112);
		Menu111.add(menuItem1113);
		Menu111.add(menuItem1114);

		Menu11.add(Menu112);
		Menu112.add(menuItem1121);
		Menu112.add(menuItem1122);
		Menu112.add(menuItem1123);
		Menu112.add(menuItem1124);

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
		Menu3.add(menuItem311);
		Menu3.add(menuItem312);
		Menu3.add(menuItem313);
		Menu3.add(menuItem314);
		Menu3.add(menuItem315);
		Menu3.add(menuItem316);
		Menu3.add(menuItem317);

		Menu2.add(Menu3);
		Menu2.add(menuItem21);
		Menu2.add(menuItem22);
		Menu2.add(menuItem23);
		Menu2.add(menuItem24);

		Menu4.add(menuItem41);

		/* Ajout des Menu au MenuBar */
		menuBar.add(Menu1);
		menuBar.add(Menu2);
		menuBar.add(Menu4);

		menuItem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FenetreAjoutTexte tf = new FenetreAjoutTexte();
				tf.setVisible(true);
			}
		});

		/*********** Couleur pour ligne pleine ****************/
		menuItem1111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(1);
				setColorLine(1);
			}
		});

		menuItem1112.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(1);
				setColorLine(2);
			}
		});

		menuItem1113.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(1);
				setColorLine(3);
			}
		});

		menuItem1114.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(1);
				setColorLine(4);
			}
		});

		/*********** Couleur pour ligne pointille ****************/
		menuItem1121.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(2);
				setColorLine(1);
			}
		});

		menuItem1122.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(2);
				setColorLine(2);
			}
		});

		menuItem1123.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(2);
				setColorLine(3);
			}
		});
		menuItem1124.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(2);
				setColorLine(4);
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

		menuItem311.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem311.getText());
			}
		});

		menuItem312.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem312.getText());
			}
		});

		menuItem313.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem313.getText());
			}
		});

		menuItem314.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem314.getText());
			}
		});

		menuItem315.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem315.getText());
			}
		});

		menuItem316.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem316.getText());
			}
		});

		menuItem317.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addImg(menuItem317.getText());
			}
		});

		menuItem41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop1 = Desktop.getDesktop();
					File helpuseSchema = new File("doc/help_use_schema.html");

					if (desktop1.isSupported(Desktop.Action.BROWSE)) {
						try {
							try {
								desktop1.browse(new URI(
										"doc/help_use_schema.html"));
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (IOException ec) {
							try {
								desktop1.open(helpuseSchema);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								javax.swing.JOptionPane.showMessageDialog(null,
										"Unable to open the web page");
							}
						}
					}
				}
			}
		});

		return menuBar;
	}

	/* Etat ligne */
	public static int isStateLine() {
		return stateLine;
	}

	public static void setStateLine(int stateLine) {
		GUIHelper.stateLine = stateLine;
	}

	/* Couleur ligne */
	public static int isColorLine() {
		return colorLine;
	}

	public static void setColorLine(int colorLine) {
		GUIHelper.colorLine = colorLine;
	}

	public static boolean isStateGomme() {
		return stateGomme;
	}

	public static void setStateGomme(boolean stateGomme) {
		GUIHelper.stateGomme = stateGomme;
	}
}