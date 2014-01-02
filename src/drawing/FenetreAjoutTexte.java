package drawing;

import ihm.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

import drawing.demos.ConstructScreen;

/**
 * @author KoA
 * @version 0.1
 * 
 *          FenetreAjoutTexte : Frame pour ajouter du texte à notre JCanvas
 *          Champs de texte + choix de couleur
 */

public class FenetreAjoutTexte extends JDialog {

	private static final long serialVersionUID = 1L;

	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JButton jButton1;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JRadioButton jRbRed, jRbBlue, jRbGreen, jRbBlack,
			jRbBold, jRbItalic;
	private javax.swing.ButtonGroup colorGroup;
	private javax.swing.ButtonGroup styleGroup;
	private javax.swing.JComboBox jCboxPolice;

	Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	protected int hauteur = (int) tailleEcran.getHeight();
	protected int largeur = (int) tailleEcran.getWidth();

	private static Color colText;
	private static int style;
	private static int taillePolice = 12;

	public FenetreAjoutTexte() {

		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			this.setTitle((String) Window.res.getObject("title_addText"));
		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			this.setTitle((String) Window.res.getObject("title_addText"));
		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			this.setTitle((String) Window.res.getObject("title_addText"));
		}
		Toolkit.getDefaultToolkit().getScreenSize();

		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setLocation(largeur / 4, hauteur / 4);

		this.initComponents();
		this.setModal(true);
		this.pack();
	}

	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		jRbBlue = new JRadioButton();
		jRbGreen = new JRadioButton();
		jRbRed = new JRadioButton();
		jRbBlack = new JRadioButton();
		colorGroup = new ButtonGroup();
		jRbBold = new JRadioButton();
		jRbItalic = new JRadioButton();
		styleGroup = new ButtonGroup();
		jCboxPolice = new JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		if (Window.locale.toString().equals("en")) {
			jLabel1.setText((String) Window.res.getObject("lb_setText"));
			jButton1.setText((String) Window.res.getObject("lb_addElem"));
			jButton1.setBounds(340, 35, 80, 20);

		} else if (Window.locale.toString().equals("it")) {
			jLabel1.setText((String) Window.res.getObject("lb_setText"));
			jButton1.setText((String) Window.res.getObject("lb_addElem"));
			jButton1.setBounds(340, 35, 90, 20);

		} else if (Window.locale.toString().equals("fr")) {
			jLabel1.setText((String) Window.res.getObject("lb_setText"));
			jButton1.setText((String) Window.res.getObject("lb_addElem"));
			jButton1.setBounds(340, 35, 80, 20);
		}

		jLabel1.setBounds(20, 0, 150, 30);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField1.setBounds(20, 35, 300, 20);
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRbRed.setBounds(20, 70, 40, 20);
		jRbRed.setBackground(Color.RED);
		jLayeredPane1.add(jRbRed, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRbGreen.setBounds(70, 70, 40, 20);
		jRbGreen.setBackground(Color.GREEN);
		jLayeredPane1.add(jRbGreen, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRbBlue.setBounds(120, 70, 40, 20);
		jRbBlue.setBackground(Color.BLUE);
		jLayeredPane1.add(jRbBlue, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRbBlack.setBounds(170, 70, 40, 20);
		jRbBlack.setBackground(Color.BLACK);
		jRbBlack.setSelected(true);
		jLayeredPane1.add(jRbBlack, javax.swing.JLayeredPane.DEFAULT_LAYER);

		colorGroup.add(jRbRed);
		colorGroup.add(jRbGreen);
		colorGroup.add(jRbBlue);
		colorGroup.add(jRbBlack);

		jRbBold.setText("<html><b>B");
		jRbBold.setBounds(250, 70, 40, 20);
		jLayeredPane1.add(jRbBold, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRbItalic.setText("<html><i>I");
		jRbItalic.setBounds(300, 70, 40, 20);
		jLayeredPane1.add(jRbItalic, javax.swing.JLayeredPane.DEFAULT_LAYER);

		styleGroup.add(jRbBold);
		styleGroup.add(jRbItalic);

		jCboxPolice.setBounds(350, 70, 50, 20);
		jLayeredPane1.add(jCboxPolice, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCboxPolice.addItem("12");
		jCboxPolice.addItem("15");
		jCboxPolice.addItem("18");
		jCboxPolice.addItem("20");
		jCboxPolice.addItem("25");
		jCboxPolice.addItem("30");
		jCboxPolice.addItem("40");
		jCboxPolice.addItem("50");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465,
				Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		this.getContentPane().setBackground(Color.white);

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ConstructScreen.addText(jTextField1.getText());
				dispose();
				setColText(Color.BLACK);
				setStyle(0);
				setTaillePolice(12);
			}
		});

		jRbRed.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setColText(Color.RED);
			}
		});

		jRbGreen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setColText(Color.GREEN);
			}
		});

		jRbBlue.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setColText(Color.BLUE);
			}
		});

		jRbBlack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setColText(Color.BLACK);
			}
		});

		jRbBold.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setStyle(Font.BOLD);
			}
		});

		jRbItalic.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setStyle(Font.ITALIC);
			}
		});

		jCboxPolice.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setTaillePolice(Integer.parseInt((String) jCboxPolice
						.getSelectedItem()));
			}
		});
	}

	/**
	 * @param colText
	 *            the colText to set
	 */
	public static void setColText(Color colText) {
		FenetreAjoutTexte.colText = colText;
	}

	/**
	 * @return the colText
	 */
	public static Color getColText() {
		return colText;
	}

	/**
	 * @param style
	 *            the style to set
	 */
	public static void setStyle(int style) {
		FenetreAjoutTexte.style = style;
	}

	/**
	 * @return the style
	 */
	public static int getStyle() {
		return style;
	}

	/**
	 * @param taillePolice
	 *            the taillePolice to set
	 */
	public static void setTaillePolice(int taillePolice) {
		FenetreAjoutTexte.taillePolice = taillePolice;
	}

	/**
	 * @return taillePolice
	 */
	public static int getTaillePolice() {
		return taillePolice;
	}
}