package ihm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import database.ReadMargin;
import database.ReadSheet;

public class Screen1 extends Window implements ComponentListener {

	private javax.swing.JButton jButton1; // bouton de load
	private javax.swing.JButton jButton2; // bouton de start
	private javax.swing.JLabel jLabel1; // label contenant img
	private javax.swing.JLabel jLabel2; // Label nom societe
	private javax.swing.JLabel jLabel3; // Label lien du site
	private javax.swing.JLabel jLabel4; // Label "no loading file"
	private javax.swing.JLabel jLabel5; // Label "file loading"
	private javax.swing.JLayeredPane jLayeredPane1;

	private javax.swing.ButtonGroup group;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JLabel labelPO, labelPO2;

	Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit()
			.getScreenSize();
	protected int hauteur = (int) tailleEcran.getHeight();
	protected int largeur = (int) tailleEcran.getWidth();
	protected boolean launch = false;

	protected boolean clicked = false;
	private int width = 572;
	private int height = 408;
	private MenuBar menubar = new MenuBar(this);
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private static ImageIcon img = new ImageIcon("logo.png");

	public Screen1() {
		this.setTitle(nameTitle);

		this.setIconImage(new ImageIcon("logoframe.png").getImage()); // Icone

		this.init();
		this.pack();

		this.addComponentListener(this);
	}

	private void init() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		JScrollPane scroll = new JScrollPane(jLayeredPane1);
		jButton1 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		labelPO = new JLabel();
		radio1 = new JRadioButton();
		labelPO2 = new JLabel();
		radio2 = new JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		/********************** Gestion de langue (persitence) ********************/
		locale = new Locale("en", "");

		WorkbookSettings wss = new WorkbookSettings();
		wss.setSuppressWarnings(true);

		try {
			Sheet sheetl = Workbook.getWorkbook(new File("language.info"), wss)
					.getSheet(0);
			String str_lang = "" + sheetl.getCell(1, 0).getContents();
			locale = new Locale(str_lang, "");
		} catch (IndexOutOfBoundsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (BiffException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		jLabel1 = new javax.swing.JLabel(getImg(), JLabel.CENTER);
		jLabel1.setBounds(0, 0, 160, 110);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// ENGLISH
		if (Window.locale.toString().equals("en")) {
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jButton1.setText((String) res.getObject("button1"));
			jButton1.setBounds(width / 2 - 125 / 2, height / 2 - 23 - 25, 130,
					23);

			jButton2.setText((String) res.getObject("button2"));
			jButton2.setBounds(width - 55 - 30, height - 70 - 25, 60, 23);

			jLabel5.setText("<html><b> " + (String) res.getObject("label5"));
			jLabel4.setText("<html><font color=blue> "
					+ (String) res.getObject("label4"));

			labelPO.setText((String) res.getObject("labelPO"));
			labelPO.setBounds(width / 2 - 100, height / 2 + 57, 50, 14);

			radio1.setText((String) res.getObject("radio1"));
			radio1.setBounds(width / 2 - 58, height / 2 + 57, 50, 14);

			labelPO2.setText((String) res.getObject("labelPO2"));
			labelPO2.setBounds(width / 2 - 8, height / 2 + 57, 20, 14);

			radio2.setText((String) res.getObject("radio2"));
			radio2.setBounds(width / 2 + 10, height / 2 + 57, 90, 14);
		}
		// ITALIANO
		else if (Window.locale.toString().equals("it")) {
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jButton1.setText((String) res.getObject("button1"));
			jButton1.setBounds(width / 2 - 140 / 2, height / 2 - 23 - 25, 160,
					23);

			jButton2.setText((String) res.getObject("button2"));
			jButton2.setBounds(width - 95, height - 70 - 25, 60, 23);

			jLabel5.setText("<html><b> " + (String) res.getObject("label5"));
			jLabel4.setText("<html><font color=blue> "
					+ (String) res.getObject("label4"));

			labelPO.setText((String) res.getObject("labelPO"));
			labelPO.setBounds(width / 2 - 75, height / 2 + 57, 50, 14);

			radio1.setText((String) res.getObject("radio1"));
			radio1.setBounds(width / 2 - 58, height / 2 + 57, 50, 14);

			labelPO2.setText((String) res.getObject("labelPO2"));
			labelPO2.setBounds(width / 2 - 8, height / 2 + 57, 20, 14);

			radio2.setText((String) res.getObject("radio2"));
			radio2.setBounds(width / 2 + 7, height / 2 + 57, 90, 14);
		}
		// FRENCH
		else if (Window.locale.toString().equals("fr")) {
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jButton1.setText((String) res.getObject("button1"));
			jButton1.setBounds(width / 2 - 150 / 2, height / 2 - 23 - 25, 160,
					23);

			jButton2.setText((String) res.getObject("button2"));
			jButton2.setBounds(width - 55 - 50, height - 70 - 25, 80, 23);

			jLabel5.setText("<html><b> " + (String) res.getObject("label5"));
			jLabel4.setText("<html><font color=blue> "
					+ (String) res.getObject("label4"));

			labelPO.setText((String) res.getObject("labelPO"));
			labelPO.setBounds(width / 2 - 90, height / 2 + 57, 50, 14);

			radio1.setText((String) res.getObject("radio1"));
			radio1.setBounds(width / 2 - 38, height / 2 + 57, 50, 14);

			labelPO2.setText((String) res.getObject("labelPO2"));
			labelPO2.setBounds(width / 2 + 12, height / 2 + 57, 20, 14);

			radio2.setText((String) res.getObject("radio2"));
			radio2.setBounds(width / 2 + 30, height / 2 + 57, 90, 14);
		}

		// Button Load
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Label "File loading:"
		jLabel5.setBounds(width / 2 - 64 / 2, height / 2 - 23 + 50 - 25, 100,
				14);
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Label "No loading file"
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setBounds(width / 2 - width / 2, height / 2 - 23 + 70 - 25,
				width, 20);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Label "SD3-Security Detection Direct Distribution"
		jLabel2.setText("<html><b>SD3-Security Detection Direct Distribution");
		jLabel2.setBounds(width / 2 - 238 / 2, height - 115, 238, 14);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/**********************************************************************************************/
		// Label "Are you"
		jLayeredPane1.add(labelPO, javax.swing.JLayeredPane.DEFAULT_LAYER);

		group = new ButtonGroup();

		// Radio SD3
		group.add(radio1);
		radio1.setSelected(true);
		add(radio1);

		// or
		jLayeredPane1.add(labelPO2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Customer ?
		group.add(radio2);
		add(radio2);

		/**********************************************************************************************/

		// Label "www.sd3.fr
		if (clicked) {
			jLabel3.setText("www.sd3.fr");
			jLabel3.setForeground(new Color(70, 6, 167));
		} else {
			jLabel3.setText("www.sd3.fr");
			jLabel3.setForeground(new Color(0, 51, 255));
		}

		jLabel3.setBounds(width / 2 - 57 / 2, height - 95, 57, 14);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Button Start
		jButton2.setBackground(new java.awt.Color(255, 255, 255));
		jButton2.setEnabled(false);

		if (launch) {
			jButton2.setEnabled(true);
		} else
			jButton2.setEnabled(false);

		jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		menubar.add();

		menubar.getjMenuItem3().setEnabled(false);
		menubar.getjMenuItem4().setEnabled(false);
		menubar.getjMenuItem5().setEnabled(false);
		menubar.getjMenuItem6().setEnabled(false);
		menubar.getjMenuItem7().setEnabled(false);
		menubar.getjMenuItem23().setEnabled(false);
		menubar.getjMenuItem8().setVisible(false);
		menubar.getjMenu3().setEnabled(true);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, width,
				Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, height,
				Short.MAX_VALUE));

		this.getContentPane().setBackground(Color.white);
		getContentPane().add(scroll);
		scroll.getViewport().add(jLayeredPane1, null);
		jLabel3.addMouseMotionListener(mousemotionlistener);
		jLabel3.addMouseListener(mouselistener);
		jLayeredPane1.addMouseMotionListener(mousemotionlistener);
		menubar.getjMenuItem9().addActionListener(actionlistener);
		menubar.getjMenuItem1().addActionListener(actionlistener);
		menubar.getjMenuItem2().addActionListener(actionlistener);
		menubar.getjMenuItem8().addActionListener(actionlistener);
		menubar.getjMenuItem11().addActionListener(actionlistener);
		menubar.getjMenuItem18().addActionListener(actionlistener);
		menubar.getjMenuItem10().addActionListener(actionlistener);
		menubar.getjMenuItem20().addActionListener(actionlistener);
		menubar.getjMenuItem22().addActionListener(actionlistener);
		menubar.getjMenuItem24().addActionListener(actionlistener);
		menubar.getjMenuItem15().addActionListener(actionlistener);
		menubar.getjMenuItem12().addActionListener(actionlistener);
		menubar.getjMenuItem13().addActionListener(actionlistener);
		menubar.getjMenuItemHelpInstall().addActionListener(actionlistener);
		menubar.getjMenuItemHelpUse().addActionListener(actionlistener);
		jButton1.addActionListener(actionlistener);
		jButton2.addActionListener(actionlistener);
		radio1.addActionListener(actionlistener);
		radio2.addActionListener(actionlistener);
	}

	ActionListener actionlistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			/* Action sur menu Exit */
			if (e.getSource().equals(menubar.getjMenuItem9())) {
				dispose();
			}

			/******************************* Choix Langue ****************************************/
			// ANGLAIS
			if (e.getSource().equals(menubar.getjMenuItem12())) {
				try {
					WritableWorkbook workbook = Workbook
							.createWorkbook(new File("language.info"));
					WritableSheet sheeta = workbook.createSheet("Language", 0);
					File f = new File("Language");
					f.setReadable(true);
					f.setWritable(true);

					Label labelLang = new Label(1, 0, "en");
					sheeta.addCell(labelLang);

					workbook.write();
					workbook.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				locale = new Locale("en", "");
				System.out.println(locale);
				res = ResourceBundle.getBundle("I18nPropertiesRessources",
						locale);
				// File loading
				s_label5 = (String) res.getObject("label5");
				jLabel5.setText("<html><b>" + s_label5);
				// Load selling price list
				s_button1 = (String) res.getObject("button1");
				jButton1.setText(s_button1);
				jButton1.setBounds(width / 2 - 125 / 2, height / 2 - 23 - 25,
						130, 23);
				// No loading file
				s_label4 = (String) res.getObject("label4");
				jLabel4.setText("<html><font color=blue> " + s_label4);
				// Start
				s_button2 = (String) res.getObject("button2");
				jButton2.setText(s_button2);
				jButton2.setBounds(width - 55 - 30, height - 70 - 25, 60, 23);
				// Are you
				labelPO.setText((String) res.getObject("labelPO"));
				labelPO.setBounds(width / 2 - 100, height / 2 + 57, 50, 14);
				// SD3
				radio1.setText((String) res.getObject("radio1"));
				radio1.setBounds(width / 2 - 58, height / 2 + 57, 50, 14);
				// or
				labelPO2.setText((String) res.getObject("labelPO2"));
				labelPO2.setBounds(width / 2 - 8, height / 2 + 57, 20, 14);
				// Customer
				radio2.setText((String) res.getObject("radio2"));
				radio2.setBounds(width / 2 + 10, height / 2 + 57, 90, 14);

				dispose();
				Screen1 s1 = new Screen1();
				s1.setLocation((screen.width - s1.getSize().width) / 2,
						(screen.height - s1.getSize().height) / 2);
				s1.setVisible(true);
			}
			// ITALIEN
			else if (e.getSource().equals(menubar.getjMenuItem13())) {
				try {
					WritableWorkbook workbook = Workbook
							.createWorkbook(new File("language.info"));
					WritableSheet sheeta = workbook.createSheet("Language", 0);
					File f = new File("Language");
					f.setReadable(true);
					f.setWritable(true);

					Label labelLang = new Label(1, 0, "it");
					sheeta.addCell(labelLang);

					workbook.write();
					workbook.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				locale = new Locale("it", "");
				System.out.println(locale);
				res = ResourceBundle.getBundle("I18nPropertiesRessources",
						locale);
				// File caricato
				s_label5 = (String) res.getObject("label5");
				jLabel5.setText("<html><b>" + s_label5);
				// Carico listino prezzi di vendita
				s_button1 = (String) res.getObject("button1");
				jButton1.setText(s_button1);
				jButton1.setBounds(width / 2 - 140 / 2, height / 2 - 23 - 25,
						150, 23);
				// File non caricato
				s_label4 = (String) res.getObject("label4");
				jLabel4.setText("<html><font color=blue> " + s_label4);
				// Convalidare
				s_button2 = (String) res.getObject("button2");
				jButton2.setText(s_button2);
				jButton2.setBounds(width - 95, height - 70 - 25, 60, 23);
				// Sei
				labelPO.setText((String) res.getObject("labelPO"));
				labelPO.setBounds(width / 2 - 75, height / 2 + 57, 50, 14);
				// SD3
				radio1.setText((String) res.getObject("radio1"));
				radio1.setBounds(width / 2 - 58, height / 2 + 57, 50, 14);
				// o
				labelPO2.setText((String) res.getObject("labelPO2"));
				labelPO2.setBounds(width / 2 - 8, height / 2 + 57, 20, 14);
				// Cliente
				radio2.setText((String) res.getObject("radio2"));
				radio2.setBounds(width / 2 + 7, height / 2 + 57, 90, 14);

				dispose();
				Screen1 s1 = new Screen1();
				s1.setLocation((screen.width - s1.getSize().width) / 2,
						(screen.height - s1.getSize().height) / 2);
				s1.setVisible(true);
			}
			// FRANCAIS
			else if (e.getSource().equals(menubar.getjMenuItem15())) {
				try {
					WritableWorkbook workbook = Workbook
							.createWorkbook(new File("language.info"));
					WritableSheet sheeta = workbook.createSheet("Language", 0);
					File f = new File("Language");
					f.setReadable(true);
					f.setWritable(true);

					Label labelLang = new Label(1, 0, "fr");
					sheeta.addCell(labelLang);

					workbook.write();
					workbook.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				locale = new Locale("fr", "");
				System.out.println(locale);
				res = ResourceBundle.getBundle("I18nPropertiesRessources",
						locale);
				// Fichier chargé
				s_label5 = (String) res.getObject("label5");
				jLabel5.setText("<html><b>" + s_label5);
				// Charger le liste prix de vente
				s_button1 = (String) res.getObject("button1");
				jButton1.setText(s_button1);
				jButton1.setBounds(width / 2 - 150 / 2, height / 2 - 23 - 25,
						160, 23);
				// Fichier non chargé
				s_label4 = (String) res.getObject("label4");
				jLabel4.setText("<html><font color=blue> " + s_label4);
				// Lancer
				s_button2 = (String) res.getObject("button2");
				jButton2.setText(s_button2);
				jButton2.setBounds(width - 55 - 50, height - 70 - 25, 80, 23);
				// Etes-vous
				labelPO.setText((String) res.getObject("labelPO"));
				labelPO.setBounds(width / 2 - 90, height / 2 + 57, 50, 14);
				// SD3
				radio1.setText((String) res.getObject("radio1"));
				radio1.setBounds(width / 2 - 38, height / 2 + 57, 50, 14);
				// ou
				labelPO2.setText((String) res.getObject("labelPO2"));
				labelPO2.setBounds(width / 2 + 12, height / 2 + 57, 20, 14);
				// Client
				radio2.setText((String) res.getObject("radio2"));
				radio2.setBounds(width / 2 + 30, height / 2 + 57, 90, 14);

				dispose();
				Screen1 s1 = new Screen1();
				s1.setLocation((screen.width - s1.getSize().width) / 2,
						(screen.height - s1.getSize().height) / 2);
				s1.setVisible(true);
			}
			/***************************************************************************************/

			/*
			 * Action sur menu Load Selling pricelist ou btn Load Selling
			 * pricelist
			 */
			if (e.getSource().equals(menubar.getjMenuItem1())
					|| e.getSource().equals(jButton1)) {
				try {
					JFileChooser chooser;
					chooser = new JFileChooser(parents) {

						private static final long serialVersionUID = 1L;

						@Override
						public void approveSelection() {
							File f = new File(getSelectedFile()
									.getAbsolutePath());
							if (f.exists()) {
								parents = f.getParent();
								super.approveSelection();
							}
						}
					};

					chooser.setAcceptAllFileFilterUsed(false);

					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"Fichier Excel (.xls)", "xls");
					chooser.setFileFilter(filter);

					int returnval = chooser.showOpenDialog(null);
					if (returnval == JFileChooser.APPROVE_OPTION) {
						WorkbookSettings ws = new WorkbookSettings();
						ws.setSuppressWarnings(true);
						sheet = Workbook.getWorkbook(chooser.getSelectedFile(),
								ws).getSheet(0);

						database = new ReadSheet(sheet);

						if (database.isPriceList(sheet)) {
							file = chooser.getSelectedFile();
							productslist = database.readProducts(sheet);
							jLabel4.setText("<html><font color=blue>"
									+ chooser.getSelectedFile().getName());
							jButton2.setEnabled(true);
							launch = true;
							pricelist = true;
							new Copy();
							String name = file.getName();
							WritableWorkbook workbook1 = Workbook
									.createWorkbook(new File("filename.info"));
							WritableSheet sheet1 = workbook1.createSheet(
									"Premier classeur", 0);
							workbook1.setProtected(true);
							sheet1.setProtected(true);
							Label label = new Label(0, 0, file.getName());
							sheet1.addCell(label);
							workbook1.write();
							workbook1.close();
							sheet = Workbook.getWorkbook(
									Copy.copyfile(file, new File(
											"lastpricelist.info")), ws)
									.getSheet(0);
							jButton2.setEnabled(true);
						} else {
							launch = false;
							jButton2.setEnabled(false);
							javax.swing.JOptionPane.showMessageDialog(null,
									"The file \""
											+ chooser.getSelectedFile()
													.getName()
											+ "\" is not in expected format");
						}
					}
				} catch (Exception ev) {
					javax.swing.JOptionPane.showMessageDialog(null, ev);
				}
			}

			/* Action sur menu Load Buying price list */
			if (e.getSource().equals(menubar.getjMenuItem2())) {
				try {
					JFileChooser chooser = new JFileChooser(parents) {

						private static final long serialVersionUID = 1L;

						@Override
						public void approveSelection() {
							File f = getSelectedFile();
							if (f.exists()) {
								parents = f.getParent();
								super.approveSelection();
							}
						}
					};
					if (!parents.isEmpty()) {
						File file = new File(parents);
						chooser.setCurrentDirectory(file);
					}
					chooser.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"Fichier Excel (.xls)", "xls");
					chooser.setFileFilter(filter);
					int returnval = chooser.showOpenDialog(null);
					if (returnval == JFileChooser.APPROVE_OPTION) {
						WorkbookSettings ws = new WorkbookSettings();
						ws.setSuppressWarnings(true);
						marginsheet = Workbook.getWorkbook(
								chooser.getSelectedFile(), ws).getSheet(0);

						marginbase = new ReadMargin(marginsheet);

						if (marginbase.isMarginList()) {
							margin = true;
							new Copy();
							sheet = Workbook.getWorkbook(
									Copy.copyfile(chooser.getSelectedFile(),
											new File("lastmarginfile.info")),
									ws).getSheet(0);
							javax.swing.JOptionPane.showMessageDialog(null,
									"The Buying price list has been loaded");
						} else {
							margin = false;
							javax.swing.JOptionPane
									.showMessageDialog(null, "The file \""
											+ chooser.getSelectedFile()
													.getName()
											+ "\" is not in buying file format");
						}
					}
				} catch (Exception ev) {
					javax.swing.JOptionPane.showMessageDialog(null, ev);
				}
			}

			/* Action sur menu Load data file */
			if (e.getSource().equals(menubar.getjMenuItem8())) {
				DataImport di = new DataImport();

				try {
					di.importe();
				} catch (IndexOutOfBoundsException e1) {
					e1.printStackTrace();
				} catch (BiffException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				if (dataload) {
					jButton2.setEnabled(true);
					launch = true;
				}
			}

			/* Action sur menu Change logo */
			if (e.getSource().equals(menubar.getjMenuItem11())) {
				try {
					JFileChooser chooser = new JFileChooser(parents) {

						private static final long serialVersionUID = 1L;

						@Override
						public void approveSelection() {
							File f = getSelectedFile();
							if (f.exists()) {
								parents = f.getParent();
								super.approveSelection();
							}
						}
					};
					if (!parents.isEmpty()) {
						File file = new File(parents);
						chooser.setCurrentDirectory(file);
					}
					chooser.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"Picture file (.jpg,.png,.bmp,.gif)", "jpg",
							"jpeg", "png", "bmp", "gif");
					chooser.setFileFilter(filter);
					int returnval = chooser.showOpenDialog(null);
					if (returnval == JFileChooser.APPROVE_OPTION) {
						setImg(new ImageIcon(chooser.getSelectedFile()
								.getAbsolutePath()));
						Copy.copyfile(chooser.getSelectedFile(), new File(
								"logo.png"));
						jLabel1.setIcon(getImg());
						SwingUtilities.updateComponentTreeUI(jLabel1);
					}
				} catch (Exception ev) {
					javax.swing.JOptionPane.showMessageDialog(null, ev);
				}
			}

			/* Action sur menu About QSoft */
			if (e.getSource().equals(menubar.getjMenuItem18())) {
				HelpScreen help = new HelpScreen();
				help.setLocation((screen.width - help.getSize().width) / 2,
						(screen.height - help.getSize().height) / 2);
				help.setVisible(true);
			}

			/* Action sur menu Help install */
			if (e.getSource().equals(menubar.getjMenuItemHelpInstall())) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					File help = new File("doc/help.html");

					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						try {
							try {
								desktop.browse(new URI("doc/help.html"));
								// desktop.open(help);
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (IOException ec) {
							// javax.swing.JOptionPane.showMessageDialog(null,"Unable to open your web browser (Error 1) : The file is not found");
							try {
								desktop.open(help);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								javax.swing.JOptionPane.showMessageDialog(null,
										"Unable to open the web page");
							}
						}
					}
				}
			}

			/* Action sur menu Help use */
			if (e.getSource().equals(menubar.getjMenuItemHelpUse())) {
				if (Desktop.isDesktopSupported()) {
					Desktop desktop1 = Desktop.getDesktop();
					File helpuse = new File("doc/help_use.html");

					if (desktop1.isSupported(Desktop.Action.BROWSE)) {
						try {
							try {
								desktop1.browse(new URI("doc/help_use.html"));
								// desktop1.open(helpuse);
							} catch (URISyntaxException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (IOException ec) {
							// javax.swing.JOptionPane.showMessageDialog(null,"Unable to open your web browser (Error 1) : The file is not found");
							try {
								desktop1.open(helpuse);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								javax.swing.JOptionPane.showMessageDialog(null,
										"Unable to open the web page");
							}
						}
					}
				}
			}

			/* Action sur menu Change user data */
			if (e.getSource().equals(menubar.getjMenuItem10())) {
				ComercialDataScreen cds;
				try {
					cds = new ComercialDataScreen();
					cds.setLocation((screen.width - cds.getSize().width) / 2,
							(screen.height - cds.getSize().height) / 2);
					cds.setVisible(true);
				} catch (IndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			/* Actin sur menu Change company data */
			if (e.getSource().equals(menubar.getjMenuItem24())) {
				CompanyScreen cs;
				try {
					cs = new CompanyScreen();
					cs.setLocation((screen.width - cs.getSize().width) / 2,
							(screen.height - cs.getSize().height) / 2);
					cs.setVisible(true);
				} catch (IndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			/* Action sur menu Change mailing pathname */
			if (e.getSource().equals(menubar.getjMenuItem22())) {
				MailScreen ms;

				try {
					ms = new MailScreen();
					ms.setLocation((screen.width - ms.getSize().width) / 2,
							(screen.height - ms.getSize().height) / 2);
					ms.setVisible(true);
				} catch (IndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			/* Action sur btn Start */
			if (e.getSource().equals(jButton2)) {
				WorkbookSettings ws = new WorkbookSettings();
				ws.setSuppressWarnings(true);
				try {
					Sheet sheet = Workbook.getWorkbook(
							new File("companydata.info"), ws).getSheet(0);
					companyname = sheet.getCell(1, 0).getContents();
					companyaddress = sheet.getCell(1, 1).getContents();
					companypostcode = sheet.getCell(1, 2).getContents();
					companytown = sheet.getCell(1, 3).getContents();
					companycountry = sheet.getCell(1, 4).getContents();
					conpanytel = sheet.getCell(1, 5).getContents();
					conpanyemail = sheet.getCell(1, 6).getContents();
					conpanyfax = sheet.getCell(1, 7).getContents();
					conpanycomment = sheet.getCell(1, 8).getContents();
				} catch (IndexOutOfBoundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (radio1.isSelected()) {
					purchase = false;
				}
				if (radio2.isSelected()) {
					purchase = true;
				}

				dispose();
				screen2 = new Screen2();
				screen2.setLocation(
						(screen.width - screen2.getSize().width) / 2,
						(screen.height - screen2.getSize().height) / 2);
				screen2.setVisible(true);
			}

			/* Action sur menu Restart QSoft */
			if (e.getSource().equals(menubar.getjMenuItem20())) {
				dispose();

				sheet = null;
				marginsheet = null;
				file = null;
				database = null;
				marginbase = null;
				index = new ArrayList<Object>();
				description = new ArrayList<String>();
				price = new ArrayList<String>();
				reference = new ArrayList<String>();
				quantity = new ArrayList<String>();
				totalyprice = new ArrayList<String>();
				kp = new ArrayList<Object>();
				jLabel4.setText("");
				margin = false;
				Screen1 s1 = new Screen1();
				s1.setLocation((screen.width - s1.getSize().width) / 2,
						(screen.height - s1.getSize().height) / 2);
				s1.setVisible(true);
				quotationprice = 0.0;
				discount = 0.0;
				transportval = 0.0;
				transport = false;
				dataload = false;
			}
		}
	};

	/* Action au clique sur le lien */
	MouseListener mouselistener = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("http://www.sd3.fr"));
						jLabel3.setText("www.sd3.fr");
						jLabel3.setForeground(new Color(70, 6, 167));
						clicked = true;
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	};

	MouseMotionListener mousemotionlistener = new MouseMotionListener() {

		@Override
		public void mouseMoved(MouseEvent e) {
			if (e.getSource().equals(jLabel3)) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			if (e.getSource().equals(jLayeredPane1)) {
				setCursor(Cursor.getDefaultCursor());
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}
	};

	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	/* Redimensionnement auto */
	@Override
	public void componentResized(ComponentEvent arg0) {
		if (this.getWidth() < 508 || this.getHeight() < 472)
			this.setSize(508, 472);

		this.width = this.getWidth();
		this.height = this.getHeight();

		// ENGLISH
		if (Window.locale.toString().equals("en")) {
			jButton1.setBounds(width / 2 - 125 / 2, height / 2 - 23 - 25, 130,
					23);
			jLabel5.setBounds(width / 2 - 64 / 2, height / 2 - 23 + 50 - 25,
					100, 14);
			jLabel4.setBounds(width / 2 - width / 2, height / 2 - 23 + 70 - 25,
					width, 20);
			jLabel2.setBounds(width / 2 - 238 / 2, height - 115, 238, 14);
			jLabel3.setBounds(width / 2 - 57 / 2, height - 95, 57, 14);
			jButton2.setBounds(width - 55 - 30, height - 70 - 25, 60, 23);
			labelPO.setBounds(width / 2 - 100, height / 2 + 57, 50, 14);
			radio1.setBounds(width / 2 - 58, height / 2 + 57, 50, 14);
			labelPO2.setBounds(width / 2 - 8, height / 2 + 57, 20, 14);
			radio2.setBounds(width / 2 + 10, height / 2 + 57, 90, 14);
		}
		// ITALIANO
		else if (Window.locale.toString().equals("it")) {
			jButton1.setBounds(width / 2 - 140 / 2, height / 2 - 23 - 25, 160,
					23);
			jLabel5.setBounds(width / 2 - 64 / 2, height / 2 - 23 + 50 - 25,
					100, 14);
			jLabel4.setBounds(width / 2 - width / 2, height / 2 - 23 + 70 - 25,
					width, 20);
			jLabel2.setBounds(width / 2 - 238 / 2, height - 115, 238, 14);
			jLabel3.setBounds(width / 2 - 57 / 2, height - 95, 57, 14);
			jButton2.setBounds(width - 95, height - 70 - 25, 60, 23);
			labelPO.setBounds(width / 2 - 75, height / 2 + 57, 50, 14);
			radio1.setBounds(width / 2 - 58, height / 2 + 57, 50, 14);
			labelPO2.setBounds(width / 2 - 8, height / 2 + 57, 20, 14);
			radio2.setBounds(width / 2 + 7, height / 2 + 57, 90, 14);
		}
		// FRENCH
		else if (Window.locale.toString().equals("fr")) {
			jButton1.setBounds(width / 2 - 150 / 2, height / 2 - 23 - 25, 160,
					23);
			jLabel5.setBounds(width / 2 - 64 / 2, height / 2 - 23 + 50 - 25,
					300, 14);
			jLabel4.setBounds(width / 2 - width / 2, height / 2 - 23 + 70 - 25,
					width, 20);
			jLabel2.setBounds(width / 2 - 238 / 2, height - 115, 238, 14);
			jLabel3.setBounds(width / 2 - 57 / 2, height - 95, 57, 14);
			jButton2.setBounds(width - 55 - 50, height - 70 - 25, 80, 23);
			labelPO.setBounds(width / 2 - 90, height / 2 + 57, 50, 14);
			radio1.setBounds(width / 2 - 38, height / 2 + 57, 50, 14);
			labelPO2.setBounds(width / 2 + 12, height / 2 + 57, 20, 14);
			radio2.setBounds(width / 2 + 30, height / 2 + 57, 90, 14);
		}
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}

	/**
	 * @param img the img to set
	 */
	public static void setImg(ImageIcon img) {
		Screen1.img = img;
	}

	/**
	 * @return the img
	 */
	public static ImageIcon getImg() {
		return img;
	}
}
