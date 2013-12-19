package drawing;

import ihm.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.border.BevelBorder;

import drawing.demos.ConstructScreen;

/**
 * @author KoA
 * @version 0.1
 * 
 *          FenetreAjoutComposant : Frame pour ajouter un composant à notre
 *          JCanvas Champs Nom du produits + Quantité + choix de la taille de
 *          l'image
 */

public class FenetreAjoutComposant extends JDialog {

	private static final long serialVersionUID = 1L;

	private javax.swing.JLabel jLabel1, jLabel2, jLabel3;
	private javax.swing.JTextField jTextField1, jTextField2;
	private javax.swing.JList list;
	private javax.swing.JButton jButton1;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JRadioButton jRb100, jRb30;
	private javax.swing.ButtonGroup sizeGroup;

	Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	protected int hauteur = (int) tailleEcran.getHeight();
	protected int largeur = (int) tailleEcran.getWidth();

	private static int style = 100;

	public FenetreAjoutComposant() {

		this.setTitle("Add Component");
		Toolkit.getDefaultToolkit().getScreenSize();

		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setLocation(largeur / 4, hauteur / 4);

		this.initComponents();
		this.setModal(true);
		this.pack();
	}

	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		list = new javax.swing.JList();
		jButton1 = new javax.swing.JButton();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		jRb100 = new javax.swing.JRadioButton();
		jRb30 = new javax.swing.JRadioButton();
		sizeGroup = new javax.swing.ButtonGroup();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Product : ");
		jLabel1.setBounds(40, 10, 90, 30);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField1.setBounds(95, 15, 300, 20);
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		list.setBounds(95, 45, 160, 120);
		list.setBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED,
				new Color(255, 255, 255), null));
		list.setFocusable(false);
		jLayeredPane1.add(list, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel2.setText("Quantity : ");
		jLabel2.setBounds(280, 50, 70, 20);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField2.setBounds(335, 50, 50, 20);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel3.setText("Size : ");
		jLabel3.setBounds(280, 95, 50, 20);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRb100.setBounds(310, 95, 85, 20);
		jRb100.setText("100 x 100");
		jRb100.setSelected(true);
		jLayeredPane1.add(jRb100, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRb30.setBounds(310, 120, 85, 20);
		jRb30.setText("30 x 30");
		jLayeredPane1.add(jRb30, javax.swing.JLayeredPane.DEFAULT_LAYER);

		sizeGroup.add(jRb100);
		sizeGroup.add(jRb30);

		jButton1.setText("Add");
		jButton1.setBounds(320, 170, 80, 20);
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jButton1.setEnabled(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465,
				Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		this.getContentPane().setBackground(Color.white);

		/************* Liste de produits ************/
		/* Action clavier sur la zone de texte */
		jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField1ActionPerformed(evt);
			}

			@SuppressWarnings("deprecation")
			private void jTextField1ActionPerformed(KeyEvent evt) {
				if (Window.file != null) {
					if (jTextField1.getText().equals("")) {
						if (Character.isJavaLetter(evt.getKeyChar())
								|| evt.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD
								|| evt.getKeyCode() == Event.ENTER) {
							jTextField2.setText("1");
							jButton1.setEnabled(false);
							list.setModel(Window.database
									.readSearch(jTextField1.getText()));
							list.setEnabled(true);
						}
					} else {
						if (Character.isJavaLetter(evt.getKeyChar())
								|| evt.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD
								|| evt.getKeyCode() == Event.ENTER
								|| evt.getKeyCode() == 8) {
							jTextField2.setText("1");
							jButton1.setEnabled(false);
							list.setModel(Window.database
									.readSearch(jTextField1.getText()));
							list.setEnabled(true);
						}
					}
				}
			}
		});
		list.setFocusable(true);
		/* Action clavier sur la zone de texte Search Product */
		jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField1KeyPressed(evt);
			}

			private void jTextField1KeyPressed(KeyEvent evt) {
				// KeyCode 40 = Flèche bas
				if (evt.getKeyCode() == 40) {
					// Si la liste != -1 (donc rempli)
					if (list.getFirstVisibleIndex() != -1) {
						list.setSelectedIndex(0);
						list.requestFocus();
					}
				}
			}
		});

		/***************************/
		/* Action clavier sur sur la liste de produits */
		list.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jList1KeyPressed(evt);
			}

			@SuppressWarnings("static-access")
			private void jList1KeyPressed(KeyEvent evt) {
				// if(isList){
				if (evt.getKeyCode() == Event.ENTER) {
					jTextField2.setText("1");
					jButton1.setEnabled(true);
					DefaultListModel test = new DefaultListModel();
					test.addElement(list.getSelectedValue().toString());
					list.setModel(test);
					list.setSelectedIndex(0);
				}
				// }
			}
		});

		/* Action souris sur la liste de produits */
		list.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				listMouseClicked(evt);
			}

			private void listMouseClicked(MouseEvent evt) {
				// TODO Auto-generated method stub
				jTextField2.setText("1");
				jButton1.setEnabled(true);
				DefaultListModel test = new DefaultListModel();
				test.addElement(list.getSelectedValue().toString());
				list.setModel(test);
				list.setSelectedIndex(0);
				jTextField1.setText(list.getSelectedValue().toString());
			}

		});

		/* Action clique sur le bouton d'ajout du composant */
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String nameProduct = jTextField1.getText();
				/*
				 * Si colonne reference contient un "/" -> on le
				 * remplace par un ""
				 */
				if (nameProduct.contains("/")) {
					ConstructScreen.addImgComponant(
							nameProduct.replace("/", ""), jTextField2.getText());
				} else {
					ConstructScreen.addImgComponant(nameProduct,
							jTextField2.getText());
				}
				dispose();
			}
		});

		/* Action de clique sur le btn radio 100x100 px */
		jRb100.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setStyle(100);
			}
		});

		/* Action de clique sur le btn radio 30x30 px */
		jRb30.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setStyle(30);
			}
		});

	}

	/**
	 * @param style
	 *            the style to set
	 */

	public static void setStyle(int style) {
		FenetreAjoutComposant.style = style;
	}

	/**
	 * @return the style
	 */
	public static int getStyle() {
		return style;
	}

}