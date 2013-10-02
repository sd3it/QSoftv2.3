package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	
	protected static boolean stateLine;

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

		JMenu Menu1 = new JMenu("Actions");

		JMenuItem menuItem11 = new JMenuItem("Add Text");
		JMenuItem menuItem12 = new JMenuItem("Add Line");
		JMenuItem menuItem13 = new JMenuItem("Save to PNG file");
		JMenuItem menuItem14 = new JMenuItem("Gomme");

		Menu1.add(menuItem11);
		Menu1.add(menuItem12);
		Menu1.add(menuItem13);
		Menu1.add(menuItem14);

		JMenu Menu2 = new JMenu("Add");
		JMenuItem menuItem21 = new JMenuItem("EoL (End of Line)");
		JMenuItem menuItem22 = new JMenuItem("+");
		JMenuItem menuItem23 = new JMenuItem("=");
		JMenuItem menuItem24 = new JMenuItem("RAL");
		
		JMenu Menu3 = new JMenu("Add schema");
		final JMenuItem menuItem31 = new JMenuItem("Synoptique ALPHA 2");
		final JMenuItem menuItem32 = new JMenuItem("Synoptique ALPHA 4-8-12");
		final JMenuItem menuItem33 = new JMenuItem("Synoptique ALPHA 16-248");
		final JMenuItem menuItem34 = new JMenuItem("Synoptique MEPFLASH");
		final JMenuItem menuItem35 = new JMenuItem("Synoptique HEPHAIS 128");
		final JMenuItem menuItem36 = new JMenuItem("Synoptique HEPHAIS 1600NE");
		final JMenuItem menuItem37 = new JMenuItem("Synoptique HEPHAIS 1600");
		final JMenuItem menuItem38 = new JMenuItem("Synoptique HEPHAIS 1600 NETWORK");
		final JMenuItem menuItem39 = new JMenuItem("Synoptique HEPHAIS 1600 COMFORT");
		final JMenuItem menuItem310 = new JMenuItem("Synoptique WIRELESS SYSTEM");
		
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

		menuBar.add(Menu1);
		menuBar.add(Menu2);

		menuItem11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FenetreAjoutTexte tf = new FenetreAjoutTexte();
				tf.setVisible(true);
			}
		});
		
		menuItem12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStateLine(true);
				System.out.println("stateLine = " + isStateLine());
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

	public static boolean isStateLine() {
		return stateLine;
	}

	public static void setStateLine(boolean stateLine) {
		GUIHelper.stateLine = stateLine;
	}
}