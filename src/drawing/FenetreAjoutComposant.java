package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import drawing.demos.ConstructScreen;


/**
 * @author KoA
 * @version 0.1
 * 
 *          FenetreAjoutComposant : Frame pour ajouter un composant à notre JCanvas
 *          Champs Nom du produits + Quantité + choix de la taille de l'image
 */

public class FenetreAjoutComposant  extends JDialog {

	private static final long serialVersionUID = 1L;


	private javax.swing.JLabel jLabel1, jLabel2, jLabel3;
	private javax.swing.JTextField jTextField1, jTextField2;
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
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new JTextField();
		jButton1 = new javax.swing.JButton();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		jRb100 = new JRadioButton();
		jRb30 = new JRadioButton();
		sizeGroup = new ButtonGroup();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Product : ");
		jLabel1.setBounds(40, 10, 90, 30);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField1.setBounds(95, 15, 300, 20);
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jLabel2.setText("Quantity : ");
		jLabel2.setBounds(40, 50, 70, 20);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jTextField2.setBounds(95, 50, 50, 20);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jLabel3.setText("Size : ");
		jLabel3.setBounds(190, 50, 50, 20);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jRb100.setBounds(230, 50, 85, 20);
		jRb100.setText("100 x 100");
		jRb100.setSelected(true);
		jLayeredPane1.add(jRb100, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jRb30.setBounds(230, 80, 85, 20);
		jRb30.setText("30 x 30");
		jLayeredPane1.add(jRb30, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		sizeGroup.add(jRb100);
		sizeGroup.add(jRb30);
				
		jButton1.setText("Add");
		jButton1.setBounds(150, 120, 80, 20);
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465,
				Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		this.getContentPane().setBackground(Color.white);

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ConstructScreen.addImgComponant(jTextField1.getText(), jTextField2.getText());
				dispose();
			}
		});
		
		jRb100.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setStyle(100);
			}
		});
		
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