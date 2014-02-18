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
 *          GUIHelper : mettre le JPanel dans la frame et l'afficher à l'ecran
 */

public class GUIHelper {

	/*
	 * State of isStateLine : - 0 : no line - 1 : pleine - 2 : pointille
	 */

	protected static int stateLine = 0;
	protected static int colorLine = 0;
	protected static boolean stateDelete = false;
	protected static boolean stateChangeSize = false;

	public static void showOnFrame(JComponent component, String frameName) {
		final JFrame frame = new JFrame(frameName);

		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// Si non sauvegardé
				if (!ConstructScreen.getSave()) {
					int reponse = 0;
					if (Window.locale.toString().equals("en")) {
						reponse = javax.swing.JOptionPane
								.showConfirmDialog(
										new javax.swing.JFrame(),
										"You forgot to save your schema. Would you like to save it now?",
										"Confirmation",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
					} else if (Window.locale.toString().equals("it")) {
						reponse = javax.swing.JOptionPane
								.showConfirmDialog(
										new javax.swing.JFrame(),
										"Hai dimenticato di salvare il diagramma. Vuoi salvare ora?",
										"Conferma", JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
					} else if (Window.locale.toString().equals("fr")) {
						reponse = javax.swing.JOptionPane
								.showConfirmDialog(
										new javax.swing.JFrame(),
										"Vous avez oublié d'enregistrer le schéma. Voulez-vous sauver maintenant?",
										"Confirmation",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
					}

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
		JMenuBar menuBar = new JMenuBar(); // Barre menu

		/* Menu 1 */
		JMenu Menu1 = new JMenu(); // menu "Actions"
		JMenuItem menuItem11 = new JMenuItem(new ImageIcon(
				"images/icons/ic_text.png")); // Add Text
		JMenu Menu11 = new JMenu(); // Add Line
		JMenuItem menuItemDel = new JMenuItem(new ImageIcon(
				"images/icons/ic_delete.png")); // Delete drawable
		JMenuItem menuItemChangeSize = new JMenuItem(new ImageIcon(
				"images/icons/ic_resize.png")); // Change size
		
		JMenuItem menuItem13 = new JMenuItem(new ImageIcon(
				"images/icons/ic_save.png")); // Save to PNG file

		JMenu Menu111 = new JMenu(); // Ligne Pleine
		JMenuItem menuItem1111 = new JMenuItem(new ImageIcon(
				"images/color/red.gif"));
		JMenuItem menuItem1112 = new JMenuItem(new ImageIcon(
				"images/color/green.gif"));
		JMenuItem menuItem1113 = new JMenuItem(new ImageIcon(
				"images/color/blue.gif"));
		JMenuItem menuItem1114 = new JMenuItem(new ImageIcon(
				"images/color/black.gif"));

		JMenu Menu112 = new JMenu(); // Ligne Pointille
		JMenuItem menuItem1121 = new JMenuItem(new ImageIcon(
				"images/color/red.gif"));
		JMenuItem menuItem1122 = new JMenuItem(new ImageIcon(
				"images/color/green.gif"));
		JMenuItem menuItem1123 = new JMenuItem(new ImageIcon(
				"images/color/blue.gif"));
		JMenuItem menuItem1124 = new JMenuItem(new ImageIcon(
				"images/color/black.gif"));

		/*
		 * JMenu Menu113 = new JMenu(); // Ligne Fléché JMenuItem menuItem1131 =
		 * new JMenuItem(new ImageIcon( "images/color/red.gif")); JMenuItem
		 * menuItem1132 = new JMenuItem(new ImageIcon(
		 * "images/color/green.gif")); JMenuItem menuItem1133 = new
		 * JMenuItem(new ImageIcon( "images/color/blue.gif")); JMenuItem
		 * menuItem1134 = new JMenuItem(new ImageIcon(
		 * "images/color/black.gif"));
		 */
		/* Menu 2 */
		JMenu Menu2 = new JMenu(); // menu "Add Elements"
		JMenuItem menuItem21 = new JMenuItem(); // "EoL"
		JMenuItem menuItem22 = new JMenuItem(); // "+"
		JMenuItem menuItem23 = new JMenuItem(); // "-"
		JMenuItem menuItem24 = new JMenuItem(); // "RAL"

		/* Menu 3 */
		JMenu Menu3 = new JMenu(); // ss-menu "Add Synoptique"
		final JMenuItem menuItem31 = new JMenuItem(); // "ALPHA 2"
		final JMenuItem menuItem32 = new JMenuItem(); // "ALPHA 4/8/12"
		final JMenuItem menuItem33 = new JMenuItem(); // "ALPHA 16/248"
		final JMenuItem menuItem34 = new JMenuItem(); // "MEPFLASH"
		final JMenuItem menuItem35 = new JMenuItem(); // "HEPHAIS 128"
		final JMenuItem menuItem36 = new JMenuItem(); // "HEPHAIS 1600NE"
		final JMenuItem menuItem37 = new JMenuItem(); // "HEPHAIS 1600"
		final JMenuItem menuItem38 = new JMenuItem(); // "HEPHAIS 1600 NETWORK"
		final JMenuItem menuItem39 = new JMenuItem(); // "HEPHAIS 1600 COMFORT"
		final JMenuItem menuItem310 = new JMenuItem(); // "WIRELESS SYSTEM"
		final JMenuItem menuItem311 = new JMenuItem(); // "DFA05"
		final JMenuItem menuItem312 = new JMenuItem(); // "DLF"
		final JMenuItem menuItem313 = new JMenuItem(); // "EX Adressable Interface"
		final JMenuItem menuItem314 = new JMenuItem(); // "EX Gas Detection"
		final JMenuItem menuItem315 = new JMenuItem(); // "Heat Cable"
		final JMenuItem menuItem316 = new JMenuItem(); // "Monitoring Software"
		final JMenuItem menuItem317 = new JMenuItem(); // "Passerelle Radio"

		JMenu Menu4 = new JMenu(); // menu "Help"
		final JMenuItem menuItem41 = new JMenuItem(new ImageIcon(
				"images/icons/ic_help.png")); // "How to use schema"

		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText((String) Window.res.getObject("menu_actions"));
			menuItem11.setText((String) Window.res
					.getObject("menuitem_addtext"));
			Menu11.setText((String) Window.res.getObject("menu_addline"));
			Menu111.setText((String) Window.res.getObject("menu_linepleine"));
			menuItem1111.setText((String) Window.res.getObject("menuitem_red"));
			menuItem1112.setText((String) Window.res
					.getObject("menuitem_green"));
			menuItem1113
					.setText((String) Window.res.getObject("menuitem_blue"));
			menuItem1114.setText((String) Window.res
					.getObject("menuitem_black"));
			Menu112.setText((String) Window.res.getObject("menu_linepointille"));
			menuItem1121.setText((String) Window.res.getObject("menuitem_red"));
			menuItem1122.setText((String) Window.res
					.getObject("menuitem_green"));
			menuItem1123
					.setText((String) Window.res.getObject("menuitem_blue"));
			menuItem1124.setText((String) Window.res
					.getObject("menuitem_black"));
			/*
			 * Menu113.setText("---------->"); menuItem1131.setText("Red");
			 * menuItem1132.setText("Green"); menuItem1133.setText("Blue");
			 * menuItem1134.setText("Black");
			 */

			menuItemDel.setText((String) Window.res
					.getObject("menuitem_delete"));
			menuItemChangeSize.setText((String) Window.res
					.getObject("menuitem_changesize"));
			menuItem13.setText((String) Window.res.getObject("menuitem_save"));

			/* Texte Menu 2 */
			Menu2.setText((String) Window.res.getObject("menu_addElem"));
			menuItem21.setText((String) Window.res.getObject("menuitem_eol"));
			menuItem22.setText((String) Window.res.getObject("menuitem_plus"));
			menuItem23.setText((String) Window.res.getObject("menuitem_egal"));
			menuItem24.setText((String) Window.res.getObject("menuitem_ral"));

			/* Texte Menu 3 */
			Menu3.setText((String) Window.res.getObject("menu_addSynop"));
			menuItem31
					.setText((String) Window.res.getObject("menuitem_alpha2"));
			menuItem32.setText((String) Window.res
					.getObject("menuitem_alpha4812"));
			menuItem33.setText((String) Window.res
					.getObject("menuitem_alpha16248"));
			menuItem34.setText((String) Window.res
					.getObject("menuitem_mepflash"));
			menuItem35.setText((String) Window.res
					.getObject("menuitem_hephais128"));
			menuItem36.setText((String) Window.res
					.getObject("menuitem_hephais1600ne"));
			menuItem37.setText((String) Window.res
					.getObject("menuitem_hephais1600"));
			menuItem38.setText((String) Window.res
					.getObject("menuitem_hephais1600net"));
			menuItem39.setText((String) Window.res
					.getObject("menuitem_hephais1600comfort"));
			menuItem310.setText((String) Window.res
					.getObject("menuitem_wireless"));
			menuItem311
					.setText((String) Window.res.getObject("menuitem_dfa05"));
			menuItem312.setText((String) Window.res.getObject("menuitem_dlf"));
			menuItem313.setText((String) Window.res
					.getObject("menuitem_exAdressableInterface"));
			menuItem314.setText((String) Window.res
					.getObject("menuitem_exGasDetection"));
			menuItem315.setText((String) Window.res
					.getObject("menuitem_heatCable"));
			menuItem316.setText((String) Window.res
					.getObject("menuitem_moniSoftware"));
			menuItem317.setText((String) Window.res
					.getObject("menuitem_passRadio"));

			/* Texte Menu 4 */
			Menu4.setText((String) Window.res.getObject("menu_help"));
			menuItem41.setText((String) Window.res
					.getObject("menuitem_helpSchema"));

		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText((String) Window.res.getObject("menu_actions"));
			menuItem11.setText((String) Window.res
					.getObject("menuitem_addtext"));
			Menu11.setText((String) Window.res.getObject("menu_addline"));
			Menu111.setText((String) Window.res.getObject("menu_linepleine"));
			menuItem1111.setText((String) Window.res.getObject("menuitem_red"));
			menuItem1112.setText((String) Window.res
					.getObject("menuitem_green"));
			menuItem1113
					.setText((String) Window.res.getObject("menuitem_blue"));
			menuItem1114.setText((String) Window.res
					.getObject("menuitem_black"));
			Menu112.setText((String) Window.res.getObject("menu_linepointille"));
			menuItem1121.setText((String) Window.res.getObject("menuitem_red"));
			menuItem1122.setText((String) Window.res
					.getObject("menuitem_green"));
			menuItem1123
					.setText((String) Window.res.getObject("menuitem_blue"));
			menuItem1124.setText((String) Window.res
					.getObject("menuitem_black"));
			/*
			 * Menu113.setText("---------->"); menuItem1131.setText("Red");
			 * menuItem1132.setText("Green"); menuItem1133.setText("Blue");
			 * menuItem1134.setText("Black");
			 */

			menuItemDel.setText((String) Window.res
					.getObject("menuitem_delete"));
			menuItemChangeSize.setText((String) Window.res
					.getObject("menuitem_changesize"));
			menuItem13.setText((String) Window.res.getObject("menuitem_save"));

			/* Texte Menu 2 */
			Menu2.setText((String) Window.res.getObject("menu_addElem"));
			menuItem21.setText((String) Window.res.getObject("menuitem_eol"));
			menuItem22.setText((String) Window.res.getObject("menuitem_plus"));
			menuItem23.setText((String) Window.res.getObject("menuitem_egal"));
			menuItem24.setText((String) Window.res.getObject("menuitem_ral"));

			/* Texte Menu 3 */
			Menu3.setText((String) Window.res.getObject("menu_addSynop"));
			menuItem31
					.setText((String) Window.res.getObject("menuitem_alpha2"));
			menuItem32.setText((String) Window.res
					.getObject("menuitem_alpha4812"));
			menuItem33.setText((String) Window.res
					.getObject("menuitem_alpha16248"));
			menuItem34.setText((String) Window.res
					.getObject("menuitem_mepflash"));
			menuItem35.setText((String) Window.res
					.getObject("menuitem_hephais128"));
			menuItem36.setText((String) Window.res
					.getObject("menuitem_hephais1600ne"));
			menuItem37.setText((String) Window.res
					.getObject("menuitem_hephais1600"));
			menuItem38.setText((String) Window.res
					.getObject("menuitem_hephais1600net"));
			menuItem39.setText((String) Window.res
					.getObject("menuitem_hephais1600comfort"));
			menuItem310.setText((String) Window.res
					.getObject("menuitem_wireless"));
			menuItem311
					.setText((String) Window.res.getObject("menuitem_dfa05"));
			menuItem312.setText((String) Window.res.getObject("menuitem_dlf"));
			menuItem313.setText((String) Window.res
					.getObject("menuitem_exAdressableInterface"));
			menuItem314.setText((String) Window.res
					.getObject("menuitem_exGasDetection"));
			menuItem315.setText((String) Window.res
					.getObject("menuitem_heatCable"));
			menuItem316.setText((String) Window.res
					.getObject("menuitem_moniSoftware"));
			menuItem317.setText((String) Window.res
					.getObject("menuitem_passRadio"));

			/* Texte Menu 4 */
			Menu4.setText((String) Window.res.getObject("menu_help"));
			menuItem41.setText((String) Window.res
					.getObject("menuitem_helpSchema"));

		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/* Texte Menu 1 */
			Menu1.setText((String) Window.res.getObject("menu_actions"));
			menuItem11.setText((String) Window.res
					.getObject("menuitem_addtext"));
			Menu11.setText((String) Window.res.getObject("menu_addline"));
			Menu111.setText((String) Window.res.getObject("menu_linepleine"));
			menuItem1111.setText((String) Window.res.getObject("menuitem_red"));
			menuItem1112.setText((String) Window.res
					.getObject("menuitem_green"));
			menuItem1113
					.setText((String) Window.res.getObject("menuitem_blue"));
			menuItem1114.setText((String) Window.res
					.getObject("menuitem_black"));
			Menu112.setText((String) Window.res.getObject("menu_linepointille"));
			menuItem1121.setText((String) Window.res.getObject("menuitem_red"));
			menuItem1122.setText((String) Window.res
					.getObject("menuitem_green"));
			menuItem1123
					.setText((String) Window.res.getObject("menuitem_blue"));
			menuItem1124.setText((String) Window.res
					.getObject("menuitem_black"));
			/*
			 * Menu113.setText("---------->"); menuItem1131.setText("Red");
			 * menuItem1132.setText("Green"); menuItem1133.setText("Blue");
			 * menuItem1134.setText("Black");
			 */

			menuItemDel.setText((String) Window.res
					.getObject("menuitem_delete"));
			menuItemChangeSize.setText((String) Window.res
					.getObject("menuitem_changesize"));
			menuItem13.setText((String) Window.res.getObject("menuitem_save"));

			/* Texte Menu 2 */
			Menu2.setText((String) Window.res.getObject("menu_addElem"));
			menuItem21.setText((String) Window.res.getObject("menuitem_eol"));
			menuItem22.setText((String) Window.res.getObject("menuitem_plus"));
			menuItem23.setText((String) Window.res.getObject("menuitem_egal"));
			menuItem24.setText((String) Window.res.getObject("menuitem_ral"));

			/* Texte Menu 3 */
			Menu3.setText((String) Window.res.getObject("menu_addSynop"));
			menuItem31
					.setText((String) Window.res.getObject("menuitem_alpha2"));
			menuItem32.setText((String) Window.res
					.getObject("menuitem_alpha4812"));
			menuItem33.setText((String) Window.res
					.getObject("menuitem_alpha16248"));
			menuItem34.setText((String) Window.res
					.getObject("menuitem_mepflash"));
			menuItem35.setText((String) Window.res
					.getObject("menuitem_hephais128"));
			menuItem36.setText((String) Window.res
					.getObject("menuitem_hephais1600ne"));
			menuItem37.setText((String) Window.res
					.getObject("menuitem_hephais1600"));
			menuItem38.setText((String) Window.res
					.getObject("menuitem_hephais1600net"));
			menuItem39.setText((String) Window.res
					.getObject("menuitem_hephais1600comfort"));
			menuItem310.setText((String) Window.res
					.getObject("menuitem_wireless"));
			menuItem311
					.setText((String) Window.res.getObject("menuitem_dfa05"));
			menuItem312.setText((String) Window.res.getObject("menuitem_dlf"));
			menuItem313.setText((String) Window.res
					.getObject("menuitem_exAdressableInterface"));
			menuItem314.setText((String) Window.res
					.getObject("menuitem_exGasDetection"));
			menuItem315.setText((String) Window.res
					.getObject("menuitem_heatCable"));
			menuItem316.setText((String) Window.res
					.getObject("menuitem_moniSoftware"));
			menuItem317.setText((String) Window.res
					.getObject("menuitem_passRadio"));

			/* Texte Menu 4 */
			Menu4.setText((String) Window.res.getObject("menu_help"));
			menuItem41.setText((String) Window.res
					.getObject("menuitem_helpSchema"));
		}

		/* Ajout des Items */
		Menu1.add(menuItem11);
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

		/*
		 * Menu11.add(Menu113); Menu113.add(menuItem1131);
		 * Menu113.add(menuItem1132); Menu113.add(menuItem1133);
		 * Menu113.add(menuItem1134);
		 */

		Menu1.add(menuItemDel);
		Menu1.add(menuItemChangeSize);
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

		/*********** Couleur pour ligne fléché ****************/
		/*
		 * menuItem1131.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { setStateLine(3); setColorLine(1);
		 * } }); menuItem1132.addActionListener(new ActionListener() { public
		 * void actionPerformed(ActionEvent arg0) { setStateLine(3);
		 * setColorLine(2); } }); menuItem1133.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
		 * setStateLine(3); setColorLine(3); } });
		 * menuItem1134.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { setStateLine(3); setColorLine(4);
		 * } });
		 */
		menuItemDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateDelete(true);
			}
		});

		menuItemChangeSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Solution mise de coté le 02/12 :
				 * 
				 * setStateChangeSize(true);
				 */
				FenetreAjoutComposant fac = new FenetreAjoutComposant();
				fac.setVisible(true);

			}
		});

		menuItem13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.saveAndPrintPNG();
			}
		});

		menuItem21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ConstructScreen.addText("EoL");
				ConstructScreen.addImg("EoL");
			}
		});

		menuItem22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addTextGrd("+");
			}
		});

		menuItem23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConstructScreen.addTextGrd("=");
			}
		});

		menuItem24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ConstructScreen.addText("RAL");
				ConstructScreen.addImg("RAL");
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
								if (Window.locale.toString().equals("en")) {
									javax.swing.JOptionPane
											.showMessageDialog(null,
													"Unable to open the web page");
								} else if (Window.locale.toString()
										.equals("it")) {
									javax.swing.JOptionPane.showMessageDialog(
											null,
											"Impossibile aprire la pagina web");
								} else if (Window.locale.toString()
										.equals("fr")) {
									javax.swing.JOptionPane.showMessageDialog(
											null,
											"Impossible d'ouvrir la page web");
								}
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

	/* Suppression d'un Drawable */
	public static boolean isStateDelete() {
		return stateDelete;
	}

	public static void setStateDelete(boolean stateDelete) {
		GUIHelper.stateDelete = stateDelete;
	}

	/* Changement de taille d'une image */
	public static boolean isStateChangeSize() {
		return stateChangeSize;
	}

	public static void setStateChangeSize(boolean stateChangeSize) {
		GUIHelper.stateChangeSize = stateChangeSize;
	}
}