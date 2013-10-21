package ihm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import database.ReadMargin;
import drawing.demos.ConstructScreen;


public class Screen2 extends Window implements ComponentListener{

	private static boolean list=false;
	private static int pquantity=1;
	private static double uprice=1;
	private static int rowcount=1;
	private static double quotationpricetmp=0.0;	

	/*variable duplicate*/
	private Double cpt = 0.00, total = 0.00;
	private Double prix = 0.00;
	private String test = "";

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButtonProfit2;
	private javax.swing.JButton jButtonSchema;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JCheckBox jCheckBoxPrintDiscount;
	
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabelProfit;
	private javax.swing.JLabel jLabelNameListProfit;
	
	private javax.swing.JLayeredPane jLayeredPane1;
	
	private javax.swing.JList jList1;
	
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	
	private javax.swing.JTable jTable1;
	
	private javax.swing.JTextArea jTextArea1;
	
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField12;
	private javax.swing.JTextField jTextField18;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	private javax.swing.JTextField jTextField17;
	
	private javax.swing.JToolBar jToolBar1;
	
	private javax.swing.JToolBar.Separator jSeparator1;
	private javax.swing.JToolBar.Separator jSeparator2;
	private javax.swing.JToolBar.Separator jSeparator3;
	//private javax.swing.JLabel jLabel14;
	//private javax.swing.JButton jButtonDuplicate;
	//private javax.swing.JButton jButton13;
	
	public javax.swing.JButton getjButton5() {
		return jButton5;
	}

	public void setjButton5(javax.swing.JButton jButton5) {
		this.jButton5 = jButton5;
	}

	public javax.swing.JButton getjButton7() {
		return jButton7;
	}

	public void setjButton7(javax.swing.JButton jButton7) {
		this.jButton7 = jButton7;
	}

	private MenuBar menubar=new MenuBar(this);
	
	private int widht=1013;
	private int height=582;

	public Screen2() {
		this.setTitle(nameTitle);
		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		initComponents();
		this.pack();
		this.addComponentListener(this);
	}
	
	@SuppressWarnings("serial")
	private void initComponents() {
		
		jButton4 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		
		jCheckBox3 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBoxPrintDiscount = new javax.swing.JCheckBox();
		
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabelProfit = new javax.swing.JLabel();
		jLabelNameListProfit = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();

		jLayeredPane1 = new javax.swing.JLayeredPane();
		
		jList1 = new javax.swing.JList();
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		
		jTable1 = new javax.swing.JTable();
		
		jTextArea1 = new javax.swing.JTextArea();
		
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField12 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jTextField10 = new javax.swing.JTextField();
		jTextField11 = new javax.swing.JTextField();
		jTextField18 = new javax.swing.JTextField();
		jTextField17 = new javax.swing.JTextField();
		
		jToolBar1 = new javax.swing.JToolBar();

		//jButtonDuplicate = new javax.swing.JButton();
		//jButton13 = new javax.swing.JButton();
		//jLabel14 = new javax.swing.JLabel();

		/******************************** Icon ToolBar **************************************/
		jButton5 = new javax.swing.JButton(new ImageIcon("mail.png"));
		jButton11 = new javax.swing.JButton(new ImageIcon("pdf_icon.png"));
		jButton12 = new javax.swing.JButton(new ImageIcon("facture-icone.JPG"));
		jButton10 = new javax.swing.JButton(new ImageIcon("save.jpg"));
		jButton9 = new javax.swing.JButton(new ImageIcon("folder.png"));
		jButton14 = new javax.swing.JButton(new ImageIcon("excel.png"));
		jButtonProfit2 = new javax.swing.JButton(new ImageIcon("profit.png"));
		jButtonSchema = new javax.swing.JButton(new ImageIcon("schema.png"));

		if(Window.locale.toString().equals("en")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jButton5.setToolTipText("Send by mail");
			jButton11.setToolTipText("Export quotation (PDF)");
			jButton12.setToolTipText("Export proforma (PDF)");
			jButton10.setToolTipText("Save data (DATA)");
			jButton9.setToolTipText("Open data (DATA)");
			jButton14.setToolTipText("Export quotation (XLS)");
			jButtonProfit2.setToolTipText("Load Purchasing price list (XLS)");
			jButtonSchema.setToolTipText("Schema");
		}
		else if(Window.locale.toString().equals("it")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jButton5.setToolTipText("Invia per email");
			jButton11.setToolTipText("Esportare citazione(PDF)");
			jButton12.setToolTipText("Esportare proforma (PDF)");
			jButton10.setToolTipText("Salva data (DATA)");
			jButton9.setToolTipText("Caricare data (DATA)");
			jButton14.setToolTipText("Esportare citazione (XLS)");
			jButtonProfit2.setToolTipText("Caricare prezzo di Acquisto (XLS)");
			jButtonSchema.setToolTipText("Schema");
		}
		else if(Window.locale.toString().equals("fr")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jButton5.setToolTipText("Envoyer par email");
			jButton11.setToolTipText("Exporter devis (PDF)");
			jButton12.setToolTipText("Exporter proforma (PDF)");
			jButton10.setToolTipText("Sauvegarder data (DATA)");
			jButton9.setToolTipText("Ouvrir data (DATA)");
			jButton14.setToolTipText("Exporter devis (XLS)");
			jButtonProfit2.setToolTipText("Charger liste prix d'Achat (XLS)");
			jButtonSchema.setToolTipText("Schema");
		}
		
		jSeparator1 = new javax.swing.JToolBar.Separator();
		jSeparator2 = new javax.swing.JToolBar.Separator();
		jSeparator3 = new javax.swing.JToolBar.Separator();
		/*************************************************************************************/
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			/************************************ Close Program ******************************************/
            public void windowClosing(java.awt.event.WindowEvent  e){
            	//If don't saved
                if(!save){ 
                	int reponse = 0;
                	if(Window.locale.toString().equals("en")){
                		reponse = javax.swing.JOptionPane.showConfirmDialog(
                						new javax.swing.JFrame(),
                						"You forgot to save the quotation. Would you like to save it now?",
                						"Confirmation",
                						JOptionPane.YES_NO_CANCEL_OPTION,
                						JOptionPane.QUESTION_MESSAGE
                		);
                	}
                	else if(Window.locale.toString().equals("it")){
                		reponse = javax.swing.JOptionPane.showConfirmDialog(
                						new javax.swing.JFrame(),
                						"Hai dimenticato di salvare il preventivo. Volete salvare ora?",
                						"Conferma",
                						JOptionPane.YES_NO_CANCEL_OPTION,
                						JOptionPane.QUESTION_MESSAGE
                		);
                	}
                	else if(Window.locale.toString().equals("fr")){
                		reponse = javax.swing.JOptionPane.showConfirmDialog(
                						new javax.swing.JFrame(),
                						"Vous avez oublié d'enregistrer le devis. Voulez-vous sauver maintenant?",
                						"Confirmation",
                						JOptionPane.YES_NO_CANCEL_OPTION,
                						JOptionPane.QUESTION_MESSAGE
                		);
                	}
                	//Then If "YES"
                	if (reponse==JOptionPane.YES_OPTION){
                		DataExportScreen das =new DataExportScreen();
                		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                		das.setLocation((screen.width - das.getSize().width)/2,(screen.height - das.getSize().height)/2);
                		das.setVisible(true);
                		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                		System.out.println("Save quotation - Close software");
                	}
                	//Else If "NO"
                	else if(reponse==JOptionPane.NO_OPTION){
                		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                		System.out.println("No save - Close software");
                	}
                }
                //Else If saved -> Close Program
                else{
                	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                	System.out.println("Close Software");
                }
            }
            /*****************************************************************************************************/
		});
		
		/***************************************** Debug Print *****************************************************/
		System.out.println("Starting Screen2 QSoft");
		
		// TEST LANGUE RECU
		if(Window.locale.toString().equals("en")){
			System.out.println("Langue : ENGLISH");
		}
		else if(Window.locale.toString().equals("it")){
			System.out.println("Langue : ITALIANO");
		}
		else if(Window.locale.toString().equals("fr")){
			System.out.println("Langue : FRANCAIS");
		}
		
		System.out.println("\t-> State selling list file: " + file );
		System.out.println("\t-> State buying list file: " + file2 );
		
		if(purchase == true){
			System.out.println("\t-> State of purchase : " + purchase + " -> Customer");
		}
		else if(purchase == false){
			System.out.println("\t-> State of purchase : " + purchase + " -> Sd3");
		}
			
		/***********************************************************************************************************/		
		if(Window.locale.toString().equals("en")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jLabel3.setText("<html><b>" + (String)res.getObject("lb_search"));
			jLabel4.setText("<html><b>" + (String)res.getObject("lb_description"));
			jLabel5.setText("<html><b>" + (String)res.getObject("lb_sellPriceLoad"));
			//Si Selling price list load -> affichage nom fichier load, Sinon "No Selling price list loading"
			if(file!=null)
				jLabel2.setText(file.getName());
			else jLabel2.setText((String)res.getObject("lb_msgNoLoad"));

			jLabel6.setText((String)res.getObject("lb_unitPrice"));
			jLabel7.setText("<html><b>" + (String)res.getObject("lb_quantity"));
			jLabel8.setText("<html><b>" + (String)res.getObject("lb_totalPrice"));
			jButton1.setText((String)res.getObject("lb_add"));
			jLabelProfit.setText("<html><b>" + (String)res.getObject("lb_purchasePriceLoad"));
			jLabelNameListProfit.setText("<html><font color=blue><i>" + (String)res.getObject("lb_msgNoLoad"));
			jLabel9.setText((String)res.getObject("lb_discountL"));
			jLabel10.setText((String)res.getObject("lb_kp"));
			jLabel13.setText((String)res.getObject("lb_profit"));
			jCheckBoxPrintDiscount.setText("<html>" + (String)res.getObject("cb_printDiscount"));
		}
		else if(Window.locale.toString().equals("it")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jLabel3.setText("<html><b>" + (String)res.getObject("lb_search"));
			jLabel4.setText("<html><b>" + (String)res.getObject("lb_description"));
			jLabel5.setText("<html><b>" + (String)res.getObject("lb_sellPriceLoad"));
			//Si Selling price list load -> affichage nom fichier load, Sinon "No Selling price list loading"
			if(file!=null)
				jLabel2.setText(file.getName());
			else jLabel2.setText((String)res.getObject("lb_msgNoLoad"));

			jLabel6.setText((String)res.getObject("lb_unitPrice"));
			jLabel7.setText("<html><b>" + (String)res.getObject("lb_quantity"));
			jLabel8.setText("<html><b>" + (String)res.getObject("lb_totalPrice"));
			jButton1.setText((String)res.getObject("lb_add"));
			jLabelProfit.setText("<html><b>" + (String)res.getObject("lb_purchasePriceLoad"));
			jLabelNameListProfit.setText("<html><font color=blue><i>" + (String)res.getObject("lb_msgNoLoad"));
			jLabel9.setText((String)res.getObject("lb_discountL"));
			jLabel10.setText((String)res.getObject("lb_kp"));
			jLabel13.setText((String)res.getObject("lb_profit"));
			jCheckBoxPrintDiscount.setText("<html>" + (String)res.getObject("cb_printDiscount"));
		}
		else if(Window.locale.toString().equals("fr")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jLabel3.setText("<html><b>" + (String)res.getObject("lb_search"));
			jLabel4.setText("<html><b>" + (String)res.getObject("lb_description"));
			jLabel5.setText("<html><b>" + (String)res.getObject("lb_sellPriceLoad"));
			//Si Selling price list load -> affichage nom fichier load, Sinon "No Selling price list loading"
			if(file!=null)
				jLabel2.setText(file.getName());
			else jLabel2.setText((String)res.getObject("lb_msgNoLoad"));

			jLabel6.setText((String)res.getObject("lb_unitPrice"));
			jLabel7.setText("<html><b>" + (String)res.getObject("lb_quantity"));
			jLabel8.setText("<html><b>" + (String)res.getObject("lb_totalPrice"));
			jButton1.setText((String)res.getObject("lb_add"));
			jLabelProfit.setText("<html><b>" + (String)res.getObject("lb_purchasePriceLoad"));
			jLabelNameListProfit.setText("<html><font color=blue><i>" + (String)res.getObject("lb_msgNoLoad"));
			jLabel9.setText((String)res.getObject("lb_discountL"));
			jLabel10.setText((String)res.getObject("lb_kp"));
			jLabel13.setText((String)res.getObject("lb_profit"));
			jCheckBoxPrintDiscount.setText("<html>" + (String)res.getObject("cb_printDiscount"));
		}
		/* Label "Search product:" */
		jLabel3.setBounds((int) (this.widht/33.76), (int)((this.height/3.6375)-30-(this.height/29.1)), (int) (this.widht/5.065), (int)(this.height/41.571));
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Search product */
		if(file==null){
			jTextField1.setEnabled(false);
		}
		jTextField1.setBounds((int) (this.widht/33.76), (int)(this.height/3.6375)-30, (int) (this.widht/9.21), 20);
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jScrollPane1.setViewportView(jList1);
		jScrollPane1.setBounds((int) (this.widht/33.76), (int)(this.height/3.6375), (int) (this.widht/7.79), (int)(this.height/4.48));
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label "Description:" */
		jLabel4.setBounds((int) (this.widht/5.33),(int)((this.height/3.6375)-(this.height/29.1)) , 70, 14);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextArea Description */
		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		
		jScrollPane2.setViewportView(jTextArea1);
		jScrollPane2.setBounds((int) (this.widht/5.33), (int)(this.height/3.6375), (int) (this.widht/5), (int)(this.height/4.48));
		jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label "Selling price list loading:" */
		jLabel5.setBounds((int) (this.widht/33.76), (int)(this.height/8.314), 140, 14);
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label file name */		
		jLabel2.setBounds((int) (this.widht/33.76)+jLabel5.getWidth(), (int)(this.height/8.314), 320, 14);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label "Unit price:" */
		jLabel6.setBounds((int) (this.widht/33.76), (int)((this.height/1.5729)-20), 90, 14);
		jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Unit price */
		jTextField2.setBounds((int) (this.widht/33.76), (int)(this.height/1.5729), 70, 20);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Label "Quantity:" */
		jLabel7.setBounds((int) (this.widht/33.76), (int)((this.height/1.81875)-20), 60, 14);
		jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Quantity */
		jTextField3.setBounds((int) (this.widht/33.76), (int)(this.height/1.81875), 70, 20);
		jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label "Total price:" */
		jLabel8.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-80), (int)((this.height/1.81875)-20), 85, 14);
		jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Total price */
		jTextField4.setEditable(false);
		jTextField4.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-80), (int)(this.height/1.81875), 80, 20);
		jLayeredPane1.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Button "Add" */
		jButton1.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-65), (int)(this.height/1.5729), 65, 23);
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/************************************************ Profit *********************************************************/
		/* Label "Purchasing price list loading" */
		jLabelProfit.setBounds((int) (this.widht/33.76),(int)(this.height/1.23829), 190, 14 );
		jLayeredPane1.add(jLabelProfit, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Label NameListProfit */
		jLabelNameListProfit.setBounds((int) (this.widht/33.76)+(jLabelProfit.getWidth()), (int)(this.height/1.23829), 240, 14);
		jLayeredPane1.add(jLabelNameListProfit, javax.swing.JLayeredPane.DEFAULT_LAYER);
		/******************************************************************************************************************/
		/* Label "Discount (in %):" */
		jLabel9.setBounds((int) (this.widht/33.76), (int)((this.height/1.386)-20), 100, 14);
		//jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField discount (left) */
		jTextField6.setBounds((int) ((this.widht/33.76) + jCheckBoxPrintDiscount.getWidth()), (int)(this.height/1.386), 70, 20);
		jLayeredPane1.add(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label "KP:" */
		jLabel10.setBounds((int) (this.widht/5.33), (int)((this.height/1.81875)-20), 66, 14);
		jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* TextField KP */
		jTextField5.setBounds((int) (this.widht/5.33), (int)(this.height/1.81875), 80, 20);
		jLayeredPane1.add(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Label "Profit percentage:" */
		jLabel13.setBounds((int) (this.widht/5.33), (int)((this.height/1.5729)-20), 94, 14);
		jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* TextField Profit percentage */
		jTextField7.setBounds((int) (this.widht/5.33), (int)(this.height/1.5729), 80, 20);
		jLayeredPane1.add(jTextField7, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Label "The product ... has been add" */
		jLabel11.setBounds((int) (this.widht/12.6626), (int)(this.height/1.1878), 400, 14);
		jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* CheckBox Print Discount */
		jCheckBoxPrintDiscount.setBackground(new java.awt.Color(210, 210, 210));
		jCheckBoxPrintDiscount.setBounds((int) (this.widht/33.76), (int)(this.height/1.386), 105, 20);
		jLayeredPane1.add(jCheckBoxPrintDiscount, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jCheckBoxPrintDiscount.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBoxPrintDiscountActionPerformed(evt);
			}

			private void jCheckBoxPrintDiscountActionPerformed(ActionEvent evt) {

				if(jCheckBoxPrintDiscount.isSelected()){
					printDiscount=true;
					System.out.println("Afficher Discount = "+printDiscount);
					jTextField6.setEnabled(true);
				}
				else{
					printDiscount=false;
					System.out.println("Cacher Discount = "+printDiscount);
					jTextField6.setEnabled(false);
				}
			}
		});
		
		/*************************************** Tableau devis **********************************************/
		// Si margin file load
		if(margin==true){
			//Creation Tabelau avec colonne "Margin"
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {},
				new String [] {
					"Index", 		//[0]
					"Code", 		//[1]
					"Description", 	//[2]
					"Qty", 			//[3]
					"Unit price",	//[4]
					"Disc %", 		//[5]
					"Total price",	//[6]
					"Profit %",		//[7]
					"KP"			//[8]	
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
					java.lang.Object.class, //Index
					java.lang.String.class, //Code
					java.lang.String.class, //Description
					java.lang.String.class, //Qty
					java.lang.Object.class,	//Unit Price
					java.lang.Object.class, //Discount
					java.lang.Object.class, //Total Price
					java.lang.Object.class,	//Profit
					java.lang.Object.class	//KP
				};
				boolean[] canEdit = new boolean [] {
					true,	//Index
					true, 	//Code
					true, 	//Desciption
					true, 	//Qty
					true,	//Unit Price
					false,	//Discount
					false, 	//Total Price
					false,	//Profit
					false	//KP
				};	
				
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public Class getColumnClass(int columnIndex) {
					return types [columnIndex];
				}	

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return canEdit [columnIndex];
				}
			});
		}
		
		//Sinon Tableau sans la colonne "Margin"
		else{
			jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] { },
				new String [] {
					"Index", 		//[0]
					"Code", 		//[1]
					"Description", 	//[2]
					"Qty", 			//[3]
					"Unit price",	//[4]
					"Disc %",		//[5]
					"Total price" 	//[6]
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
					java.lang.Object.class, //Index
					java.lang.String.class, //Code
					java.lang.String.class, //Description
					java.lang.String.class, //Qty
					java.lang.Object.class, //Unit Price
					java.lang.Object.class,	//Discount
					java.lang.Object.class	//Total Price
				};
				boolean[] canEdit = new boolean [] {
					true, 	//Index
					true, 	//Code
					true, 	//Description
					true, 	//Qty
					true,	//Unit Price
					false,	//Discount
					false	//Total Price
				};

				@SuppressWarnings({ "rawtypes", "unchecked" })
				public Class getColumnClass(int columnIndex) {
					return types [columnIndex];
				}	

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return canEdit [columnIndex];
				}
			});
		}
		
		jTable1.getTableHeader().setReorderingAllowed(false);

		//Configuration du Tableau
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jScrollPane3.setViewportView(jTable1);
		jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jTable1.getColumnModel().getColumn(0).setResizable(true);	//Index
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
		jTable1.getColumnModel().getColumn(1).setResizable(true);	//Code
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
		jTable1.getColumnModel().getColumn(2).setResizable(true);	//Description
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
		jTable1.getColumnModel().getColumn(3).setResizable(true);	//Qty
		jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
		jTable1.getColumnModel().getColumn(4).setResizable(true);	//Unit Price
		jTable1.getColumnModel().getColumn(4).setPreferredWidth(75);
		jTable1.getColumnModel().getColumn(5).setResizable(true);	//Discount
		jTable1.getColumnModel().getColumn(5).setPreferredWidth(75);
		jTable1.getColumnModel().getColumn(6).setResizable(true);	//Total Price
		jTable1.getColumnModel().getColumn(6).setPreferredWidth(75);
		
		//Si margin ok -> config colonne "Margin"
		if(margin==true){
			jTable1.getColumnModel().getColumn(7).setResizable(true);	//Profit
			jTable1.getColumnModel().getColumn(7).setPreferredWidth(75);
			jTable1.getColumnModel().getColumn(8).setResizable(true);	//KP
			jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
		}
		//Si une donnée est load -> ajout ligne dans Tableau
		if(dataload){
			/*
			 	for(int i=0;i<=reference.size()-1;i++){
					((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
							index.get(i),
							reference.get(i), 
							description.get(i),
							quantity.get(i),
							price.get(i),
							discountprod.get(i),
							totalyprice.get(i),
							achat.get(i),
							kp.get(i)
					});   
				
					if(!index.get(i).toString().isEmpty())
						rowcount=Integer.parseInt(index.get(i).toString())+1;
				}
			 */
			if(margin==false){
				for(int i=0;i<=reference.size()-1;i++){
					((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
							index.get(i),
							reference.get(i), 
							description.get(i),
							quantity.get(i),
							price.get(i),
							discountprod.get(i),
							totalyprice.get(i)
					});   
					
					if(!index.get(i).toString().isEmpty())
						rowcount=Integer.parseInt(index.get(i).toString())+1;
				}
			}
			if(margin==true){
				for(int i=0;i<=reference.size()-1;i++){
					((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
							index.get(i),
							reference.get(i), 
							description.get(i),
							quantity.get(i),
							price.get(i),
							discountprod.get(i),
							totalyprice.get(i),
							achat.get(i),
							kp.get(i)
					});   
				
					if(!index.get(i).toString().isEmpty())
						rowcount=Integer.parseInt(index.get(i).toString())+1;
				}
			}
		}
		
		jTextField6.setEnabled(false);
		jTextField17.setEnabled(false);
		jTextField10.setEnabled(false);
		jTextField12.setEnabled(false);
		jTextField9.setEditable(true);
		//Calcul de "Quotation Price" = (Total Price - (Total Price * discount/100) + transport)
		jTextField9.setText(df.format(quotationprice -(quotationprice*discount/100)+transportval).replaceAll(","," "));
		
		//Si margin ok
		if(margin==true){
			//Si Total Price != 0 
			if(quotationprice!=0){
				//Calcul "Quotation margin indice" = (Total Price - (Total Price * discount/100))/Total Prix Achat)
				jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
				//Calcul "Quotation margin percentage" = ((Total Price - (Total Price * discount/100)- Prix Achat)/(Total Price - (Total Price * discount/100))) * 100
				jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
			}
			//Sinon vide
			else{
				jTextField11.setText("");
				jTextField18.setText("");
			}
		}
		
		//Si prix transport != 0
		if(transportval!=0){
			jTextField17.setText(df.format(transportval));
			jCheckBox1.setSelected(true);
			jTextField17.setEnabled(true);
			transport=true;
		}
		
		//Si discount != 0
		if(discount!=0){
			jTextField10.setText(df.format(discount));
			jCheckBox3.setSelected(true);
			jTextField10.setEnabled(true);
		}
		
		//Si Start-Up != 0
		if(assistance!=0){
			jTextField12.setText(df.format(assistance));
			jCheckBox2.setSelected(true);
			jTextField12.setEnabled(true);
		}
		
		//Si une donnée est chargé dans le tableau
		if(dataload){
			jCheckBox1.setEnabled(true);
			jCheckBox2.setEnabled(true);
			jCheckBox3.setEnabled(true);
			jTextField9.setEditable(true);
		}
		else{
			jCheckBox1.setEnabled(false);
			jCheckBox2.setEnabled(false);
			jCheckBox3.setEnabled(false);
			jTextField9.setEditable(false);
		}
		
		if(Window.locale.toString().equals("en")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jCheckBox2.setText((String)res.getObject("cb_startup"));
			jButton2.setText((String)res.getObject("bt_deleteRow"));
			jButton4.setText((String)res.getObject("bt_addRow"));
			jButton8.setText((String)res.getObject("bt_title"));
			jButton3.setText((String)res.getObject("bt_moveUp"));
			jButton6.setText((String)res.getObject("bt_moveDown"));
			jLabel12.setText((String)res.getObject("lb_quotationPrice"));
			jCheckBox3.setText((String)res.getObject("cb_discount"));
			jCheckBox1.setText((String)res.getObject("cb_transport"));
			jLabel15.setText((String)res.getObject("lb_kpTotal"));
			jLabel21.setText((String)res.getObject("lb_profitTotal"));
		}
		else if(Window.locale.toString().equals("it")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jCheckBox2.setText((String)res.getObject("cb_startup"));
			jButton2.setText((String)res.getObject("bt_deleteRow"));
			jButton4.setText((String)res.getObject("bt_addRow"));
			jButton8.setText((String)res.getObject("bt_title"));
			jButton3.setText((String)res.getObject("bt_moveUp"));
			jButton6.setText((String)res.getObject("bt_moveDown"));
			jLabel12.setText((String)res.getObject("lb_quotationPrice"));
			jCheckBox3.setText((String)res.getObject("cb_discount"));
			jCheckBox1.setText((String)res.getObject("cb_transport"));
			jLabel15.setText((String)res.getObject("lb_kpTotal"));
			jLabel21.setText((String)res.getObject("lb_profitTotal"));
		}
		else if(Window.locale.toString().equals("fr")){
			res = ResourceBundle.getBundle("I18nPropertiesRessources", locale);
			jCheckBox2.setText((String)res.getObject("cb_startup"));
			jButton2.setText((String)res.getObject("bt_deleteRow"));
			jButton4.setText((String)res.getObject("bt_addRow"));
			jButton8.setText((String)res.getObject("bt_title"));
			jButton3.setText((String)res.getObject("bt_moveUp"));
			jButton6.setText((String)res.getObject("bt_moveDown"));
			jLabel12.setText((String)res.getObject("lb_quotationPrice"));
			jCheckBox3.setText((String)res.getObject("cb_discount"));
			jCheckBox1.setText((String)res.getObject("cb_transport"));
			jLabel15.setText((String)res.getObject("lb_kpTotal"));
			jLabel21.setText((String)res.getObject("lb_profitTotal"));
		}
		
		/* CheckBox Start up */
		jCheckBox2.setBackground(new java.awt.Color(210, 210, 210));
		jCheckBox2.setBounds((int)(this.widht/2.251), (int)(this.height/1.23829), 65, 23);
		jLayeredPane1.add(jCheckBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* TextField Start up */
		jTextField12.setBounds((int)(this.widht/2.251)+90, (int)(this.height/1.23829), 70, 20);
		jLayeredPane1.add(jTextField12, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Scroll Tableau */
		jScrollPane3.setBounds((int)(this.widht/2.251), (int)(this.height/11.64), (int)(this.widht/2.302), (int)(this.height/1.663));
		jLayeredPane1.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Button "Delete row" */
		jButton2.setBounds((int)(this.widht/1.125), (int)(this.height/11.64), 90, 23);
		jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Add Row / Add Title */
		jTextField8.setBounds((int)(this.widht/2.251), (int)(this.height/29.1), (int)(this.widht/3.6178), 20);
		jLayeredPane1.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Button "Add row" */
		jButton4.setBounds((int)(this.widht/1.3706), (int)(this.height/29.5), 73, 23);
		jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Button "Add title" */
		jButton8.setBounds((int)(this.widht/1.3706)+jButton4.getWidth()+10, (int)(this.height/29.5), 73, 23);
		jLayeredPane1.add(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Button "Move up" */
		jButton3.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+30), 90, 23);
		jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Button "Move down" */
		jButton6.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+60), 90, 23);
		jLayeredPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Button "Update" */
		//jButton13.setText("Update");
		//jButton13.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+90), 90, 23);
		//jLayeredPane1.add(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/*********************************************** Duplicate ********************************************************/
		//jButtonDuplicate.setText("Duplicate");
		//jButtonDuplicate.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+90), 90, 23);
		//jLayeredPane1.add(jButtonDuplicate, javax.swing.JLayeredPane.DEFAULT_LAYER);
		/******************************************************************************************************************/

		/* Label "Quotation price:" */
		jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jLabel12.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70-100), (int)(this.height/1.4195), 90, 20);
		jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Quotation Price */
		jTextField9.setText(df.format(quotationprice));
		jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		jTextField9.setMaximumSize(new java.awt.Dimension(6, 20));
		jTextField9.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70), (int)(this.height/1.4195), 70, 20);
		jLayeredPane1.add(jTextField9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Discount */
		jTextField10.setBounds((int)((this.widht/2.251)+110), (int)(this.height/1.4195), 80, 20);
		jLayeredPane1.add(jTextField10, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* CheckBox Discount */
		jCheckBox3.setBackground(new java.awt.Color(210, 210, 210));
		jCheckBox3.setBounds((int)(this.widht/2.251), (int)(this.height/1.4195), 110, 23);
		jLayeredPane1.add(jCheckBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* CheckBox Transport */
		jCheckBox1.setBackground(new java.awt.Color(210, 210, 210));
		jCheckBox1.setBounds((int)(this.widht/2.251), (int)(this.height/1.32272), 80, 20);
		jLayeredPane1.add(jCheckBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Transport */
		jTextField17.setBounds((int)(this.widht/2.251)+90, (int)(this.height/1.32272), 70, 20);
		jLayeredPane1.add(jTextField17, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* Label "Total KP :" */ 
		jLabel15.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70-55), (int)(this.height/1.293), 120, 20);
		jLayeredPane1.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* TextField Total KP */
		jTextField11.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70), (int)(this.height/1.293), 70, 20);
		jLayeredPane1.add(jTextField11, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Label "Total Profit percentage:" */
		jLabel21.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70-90), (int)(this.height/1.2125), 148, 20);
		jLayeredPane1.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		/* TextField Quotation margin percentage */
		jTextField18.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70), (int)(this.height/1.2125), 70, 20);
		jLayeredPane1.add(jTextField18, javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* ToolBar */
		jToolBar1.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.setFloatable(false);

		/*********************************** Mail Icon ****************************************/
		jButton5.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButton5);
		
		/* Action sur le Bouton Mail */
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton5ActionPerformed(evt);
				} 
				catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void jButton5ActionPerformed(ActionEvent evt) throws IndexOutOfBoundsException, BiffException, IOException {
				if(printermailer.isEmpty()){
					javax.swing.JOptionPane.showMessageDialog(null,"Impossible - No quotation are been creating"); 
				}
				else{
					try {  
					WorkbookSettings ws=new WorkbookSettings();
    				ws.setSuppressWarnings(true);
    				Sheet sheet=Workbook.getWorkbook(new File("mailpathname.info"),ws).getSheet(0);
    				
					String mailPathname=sheet.getCell(1,0).getContents();
					     
						Runtime.getRuntime().exec(
								new String[] {mailPathname,"/a",printermailer}, null
						);
					} 
					catch (Exception e) {
						javax.swing.JOptionPane.showMessageDialog(null,e); 
						e.printStackTrace();
					}
				}
			}
		});
		/**************************************************************************************/

		jToolBar1.add(jSeparator1);

		/**************************** Icon PDF - Excel - Proforma *****************************/
		/* Button Proforma export */
		jButton12.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButton12);
		
		/* Button PDF export */
		jButton11.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButton11);
		
		/* Button Excel export */
		jButton14.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButton14);
		
		/* Action sur le Bouton Proforma Export */
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}

			private void jButton12ActionPerformed(ActionEvent evt) {
				if(!reference.isEmpty()){
					ProformaScreen ps=new ProformaScreen();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					ps.setLocation((screen.width - ps.getSize().width)/2,(screen.height - ps.getSize().height)/2);
					ps.setVisible(true);
				}
				else{
					javax.swing.JOptionPane.showMessageDialog(null,"There is no product to create a proforma file"); 
				}
			}
		});
		
		/* Action sur le Bouton PDF Export */
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}

			private void jButton11ActionPerformed(ActionEvent evt) {
				PdfScreen pdf=new PdfScreen();
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				pdf.setLocation((screen.width - pdf.getSize().width)/2,(screen.height - pdf.getSize().height)/2);
				pdf.setVisible(true);
			}
		});
		
		/* Action sur le Bouton Excel Export */
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				try {
					jButton14ActionPerformed(evt);
				}
				catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void jButton14ActionPerformed(ActionEvent evt) throws WriteException, IOException {
				ExportExcel ee=new ExportExcel();
				ee.export();
			}
		});
		/**************************************************************************************/
		
		jToolBar1.add(jSeparator2);

		/********************************* Save & Open Data ***********************************/
		/* Button "Save data" */
		jButton10.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButton10);
		
		/* Button "Open data" */
		jButton9.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButton9);
		
		/**************************************************************************************/
		jToolBar1.add(jSeparator3);
		
		/********************************* Load profit list ***********************************/
		/* Button Load Profit List */
		jButtonProfit2.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButtonProfit2);
		
		/********************************* Load Schema ****************************************/
		jButtonSchema.setBackground(new java.awt.Color(210, 210, 210));
		jToolBar1.add(jButtonSchema);
		
		/****************************************** Configuration MenuBar ***********************************************/
		jToolBar1.setBounds(0, 0, 300, 40);
		jLayeredPane1.add(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		menubar.add();

		menubar.getjMenuItem1().setEnabled(false);
		menubar.getjMenuItem1().setVisible(false);
		menubar.getjMenuItem2().setEnabled(false);
		menubar.getjMenuItem2().setVisible(false);
		//menubar.getjMenuItem17().setEnabled(false);
		menubar.getjMenuItem11().setEnabled(false);
		menubar.getjMenuItem24().setEnabled(false);
		//menubar.getjMenuItem25().setEnabled(false);
		menubar.getjMenu3().setEnabled(false);
		
		/* Activation (ou non) du menu Save Purchasing Order */
		if(purchase == false){
			menubar.getjMenuItem23().setEnabled(false);
		}
		else if(purchase == true){
			menubar.getjMenuItem23().setEnabled(true);
		}

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, widht-18, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, height-61, Short.MAX_VALUE)
		);

		this.getContentPane().setBackground(new Color(210, 210, 210));

		/************************************** Gestionnaire d'écoute MenuBar ********************************************/	
		ActionListener actionlistener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Action sur le Bouton Print */
				if(e.getSource().equals(menubar.getjMenuItem3())) {
					//Si printmailer vide 
					if(printermailer.isEmpty()){
						javax.swing.JOptionPane.showMessageDialog(null,"Impossible - No quotation are been creating"); 
					}
					//sinon
					else {
						try {       
							if ( Desktop.isDesktopSupported() ) {
								// On récupère l'instance du desktop :
								Desktop desktop = Desktop.getDesktop();

								// On vérifie que la fonction open est bien supportée :
								if (desktop.isSupported(Desktop.Action.OPEN)) {
									// Et on lance l'application associé au fichier pour l'ouvrir :
									desktop.print(new File(printermailer));
								}
							}
						} 
						catch (Exception e1) {
							javax.swing.JOptionPane.showMessageDialog(null,e1); 
						}
					}
				}

				
				/* Action sur Send by mail */
				if(e.getSource().equals(menubar.getjMenuItem4())) {
					//Si printermailer vide
					if(printermailer.isEmpty()){
						javax.swing.JOptionPane.showMessageDialog(null,"Impossible - No quotation are been creating"); 
					}
					//Sinon 
					else {
						WorkbookSettings ws=new WorkbookSettings();
	    				ws.setSuppressWarnings(true);
	    				Sheet sheet;
						try {
							sheet = Workbook.getWorkbook(new File("mailpathname.info"),ws).getSheet(0);
							String mailPathname=sheet.getCell(1,0).getContents();
							try {       
								Runtime.getRuntime().exec(
									new String[] { mailPathname,"/a",printermailer }, null
								);
							} 
							catch (Exception e1) {
								javax.swing.JOptionPane.showMessageDialog(null,e1); 
								e1.printStackTrace();
							}
						} 
						catch (IndexOutOfBoundsException e2) {
							// TODO Auto-generated catch block
							javax.swing.JOptionPane.showMessageDialog(null,e2);
						} 
						catch (BiffException e2) {
							// TODO Auto-generated catch block
							javax.swing.JOptionPane.showMessageDialog(null,e2);
						} 
						catch (IOException e2) {
							// TODO Auto-generated catch block
							javax.swing.JOptionPane.showMessageDialog(null,e2);
						}
					}
				}
				
				/* Action sur Proforma Save */
				if(e.getSource().equals(menubar.getjMenuItem5())) {
					//Si reference N'est PAS vide
					if(!reference.isEmpty()){
						ProformaScreen ps = new ProformaScreen();
						Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
						ps.setLocation((screen.width - ps.getSize().width)/2,(screen.height - ps.getSize().height)/2);
						ps.setVisible(true);
					}
					//Sinon
					else{
						javax.swing.JOptionPane.showMessageDialog(null,"There is no product to create a proforma file"); 
					}
				}
				
				/* Action sur Save purchasing Sd3 order (PDF) */
				if(e.getSource().equals(menubar.getjMenuItem23())) {
					if(margin==false){
						javax.swing.JOptionPane.showMessageDialog(null,"Impossible - You don't have load buying price list"); 
					}
					else {
						//Si printermailer vide
						if(printermailer.isEmpty()){
							javax.swing.JOptionPane.showMessageDialog(null,"Impossible - No quotation are been creating"); 
						}
						//Sinon 
						else{
							PurchaseOrderSupplier pos = new PurchaseOrderSupplier();
						}
					}
				}
				
				/* Action sur Save quotation file (PDF) */
				if(e.getSource().equals(menubar.getjMenuItem6())) {
					PdfScreen pdf = new PdfScreen();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					pdf.setLocation((screen.width - pdf.getSize().width)/2,(screen.height - pdf.getSize().height)/2);
					pdf.setVisible(true);
				}
				
				/* Action sur Save data file (DATA) */
				if(e.getSource().equals(menubar.getjMenuItem7())) {
					DataExport ee = new DataExport();
					try {
						ee.export();
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				/* Action sur Load data file */
				if(e.getSource().equals(menubar.getjMenuItem8()))
				{
					DataImport di=new DataImport();
					try {
						di.importe();
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
					totalbuyprice = buyprice;
					System.out.println("PA total recup : " + df.format(totalbuyprice));
					if(margin==true){
						jTable1.setModel(new javax.swing.table.DefaultTableModel(
							new Object [][] {},
							new String [] {
								"Index", 		//[0]
								"Code", 		//[1]
								"Description", 	//[2]
								"Qty", 			//[3]
								"Unit price", 	//[4]
								"Disc %",		//[5]
								"Total price",	//[6]
								"Profit %", 	//[7]
								"KP"			//[8]
							}
						) {
							@SuppressWarnings("rawtypes")
							Class[] types = new Class [] {
								java.lang.Object.class, //Index
								java.lang.String.class, //Code
								java.lang.String.class, //Description
								java.lang.String.class, //Qty
								java.lang.Object.class, //Unit Price
								java.lang.Object.class,	//Discount
								java.lang.Object.class,	//Total Price
								java.lang.Object.class, //Profit
								java.lang.Object.class	//KP
							};
							boolean[] canEdit = new boolean [] {
								true,	//Index
								true, 	//Code
								true, 	//Description
								true, 	//Qty
								true,	//Unit Price
								false,	//Discount
								false, 	//Total Price
								false, 	//Profit
								false	//KP
							};

							@SuppressWarnings({ "rawtypes", "unchecked" })
							public Class getColumnClass(int columnIndex) {
								return types [columnIndex];
							}

							public boolean isCellEditable(int rowIndex, int columnIndex) {
								return canEdit [columnIndex];
							}
						});
					}
					else{
						jTable1.setModel(new javax.swing.table.DefaultTableModel(
							new Object [][] {},
							new String [] {
								"Index", 		//[0]
								"Code", 		//[1]
								"Description", 	//[2]
								"Qty", 			//[3]
								"Unit price",	//[4]
								"Disc %",		//[5]
								"Total price"	//[6]
							}
						){
							@SuppressWarnings("rawtypes")
							Class[] types = new Class [] {
								java.lang.Object.class,	//Index 
								java.lang.String.class, //Code
								java.lang.String.class, //Description
								java.lang.String.class, //Qty
								java.lang.Object.class,	//Unit Price
								java.lang.Object.class,	//Discount
								java.lang.Object.class	//Total Price
							};
							boolean[] canEdit = new boolean [] {
								true, 	//Index
								true, 	//Code
								true, 	//Description
								true, 	//Qty
								true, 	//Unit Price
								false,	//Discount
								false	//Total Price
							};

							@SuppressWarnings({ "rawtypes", "unchecked" })
							public Class getColumnClass(int columnIndex) {
								return types [columnIndex];
							}

							public boolean isCellEditable(int rowIndex, int columnIndex) {
								return canEdit [columnIndex];
							}
						});
					}
					jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
					jTable1.getColumnModel().getColumn(0).setResizable(true);	//Index
					jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
					jTable1.getColumnModel().getColumn(1).setResizable(true);	//Code
					jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
					jTable1.getColumnModel().getColumn(2).setResizable(true);	//Description
					jTable1.getColumnModel().getColumn(2).setPreferredWidth(170);
					jTable1.getColumnModel().getColumn(3).setResizable(true);	//Qty
					jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
					jTable1.getColumnModel().getColumn(4).setResizable(true);	//Unit Price
					jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
					jTable1.getColumnModel().getColumn(5).setResizable(true);	//Discount
					jTable1.getColumnModel().getColumn(5).setPreferredWidth(75);
					jTable1.getColumnModel().getColumn(6).setResizable(true);	//Total Price
					jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);

					if(margin==true){
						jTable1.getColumnModel().getColumn(7).setResizable(true);	//Profit
						jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
						jTable1.getColumnModel().getColumn(8).setResizable(true);	//KP
						jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
					}
					jTable1.getModel().addTableModelListener(new TableModelListener(){

						@Override
						public void tableChanged(TableModelEvent arg0) {
							if(arg0.getColumn()!=-1){

								int row = arg0.getFirstRow();
								int column = arg0.getColumn();
								
								TableModel model = (TableModel)arg0.getSource();
								Object data = model.getValueAt(row, column);
								save=false;
								
								if(column==0){
									try{
										index.set(row, data.toString());
										System.out.println("data load modif =====> " + data);
									}
									catch (Exception e) {
										index.set(row, index.get(row));
									}
								}
								if(column==1){
									if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
										reference.set(row, reference.get(row));
									}
									else {
										reference.set(row, data.toString());
										System.out.println("data load modif =====> " + data);
									}
								}
								if(column==2){	
									description.set(row, data.toString());
									System.out.println("data load modif =====> " + data);
								}
								
								if(column==3){
									if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
										quantity.set(row, quantity.get(row));
									}
									else {
										if(margin==true){
											buyprice -= Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));	
										}
										
										quantity.set(row, data.toString());
										System.out.println("data load modif =====> " + data);
										
										if(margin==true){
											buyprice += Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));
										}
										try {
											quotationprice -= Double.parseDouble(totalyprice.get(row));
											totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
											quotationprice += Double.parseDouble(totalyprice.get(row));
											System.out.println("totalyprice: " + totalyprice);
											jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
											
											jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
											
											if(margin==true){
												if(quotationprice != 0){
													jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
													jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
												}
												else{
													jTextField11.setText("");
													jTextField18.setText("");
												}
											}
										}
										catch (Exception e) {
											System.out.println(e);
										}
									}
								}

								if(column==4){
									if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
										price.set(row, price.get(row));
									}
									else {
										price.set(row, data.toString());
										System.out.println("data load modif =====> " + data);
									}
									try {
										quotationprice-=Double.parseDouble(totalyprice.get(row));
										totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
										quotationprice+=Double.parseDouble(totalyprice.get(row));
										
										jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
										jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
									}
									catch (Exception e) {
										// TODO: handle exception
										System.out.println(e);
									}
									if(margin==true){
										if(quotationprice!=0){
											jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
											jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
										}
										else{
											jTextField11.setText("");
											jTextField18.setText("");
										}
									}
								}

								if(column==5){
									if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
										discountprod.set(row, discountprod.get(row));
									}
									else {
										discountprod.set(row, data.toString());
									}
								}
								
								if(column==6){
									if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
										totalyprice.set(row, totalyprice.get(row));
									}
									else {
										totalyprice.set(row, data.toString());
										System.out.println("data load modif =====> " + data);
									}
								}
							}
						}
					});
					rowcount=1;
					
					for(int i=0;i<=reference.size()-1;i++){

						if(margin==true) {
							((DefaultTableModel) jTable1.getModel()).addRow(
								new Object[]{
									index.get(i),
									reference.get(i), 
									description.get(i),
									quantity.get(i),
									price.get(i),
									discountprod.get(i),	//discount
									totalyprice.get(i),
									achat.get(i),
									kp.get(i)
								}
							); 
						}
						else {
							((DefaultTableModel) jTable1.getModel()).addRow(
								new Object[]{
									index.get(i),
									reference.get(i), 
									description.get(i),
									quantity.get(i),
									price.get(i),
									discountprod.get(i),	//discount
									totalyprice.get(i)
								}
							);
						}
						
						if(!index.get(i).toString().isEmpty()) {
							rowcount=Integer.parseInt(index.get(i).toString())+1;
						}
					}
					
					jTextField9.setText(df.format(quotationprice -(quotationprice*discount/100)+transportval).replaceAll(","," "));
					
					if(margin==true){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
					if(transportval != 0){
						jTextField17.setText(df.format(transportval));
						jTextField17.setEnabled(true);
						jCheckBox1.setSelected(true);
						transport=true;
					}
					if(discount != 0){
						jTextField10.setText(df.format(discount));
						jTextField10.setEnabled(true);
						jCheckBox3.setSelected(true);
					}
					if(assistance != 0){
						jTextField12.setText(df.format(assistance));
						jTextField12.setEnabled(true);
						jCheckBox2.setSelected(true);
					}
					jCheckBox1.setEnabled(true);
					jCheckBox2.setEnabled(true);
					jCheckBox3.setEnabled(true);
					jTextField9.setEditable(true);
				}
				
				/* Action sur Change user data */
				if(e.getSource().equals(menubar.getjMenuItem10())){
					
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					ComercialDataScreen cds;
					try {
						cds = new ComercialDataScreen();
						cds.setLocation((screen.width - cds.getSize().width)/2,(screen.height - cds.getSize().height)/2);
						cds.setVisible(true);
					} 
					catch (IndexOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (BiffException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				/* Action sur About QSOFT */
				if(e.getSource().equals(menubar.getjMenuItem18())) {
					
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					HelpScreen help=new HelpScreen();
					help.setLocation((screen.width - help.getSize().width)/2,(screen.height - help.getSize().height)/2);
					help.setVisible(true);
				}
				
				/* Action sur Change mailing pathname */
				if(e.getSource().equals(menubar.getjMenuItem22())) {
					
					MailScreen ms;
					
					try {
						ms = new MailScreen();
						Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
						ms.setLocation((screen.width - ms.getSize().width)/2, (screen.height - ms.getSize().height)/2);
						ms.setVisible(true);
					} 
					catch (IndexOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (BiffException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				/* action sur Restart QSOFT */
				if(e.getSource().equals(menubar.getjMenuItem20())) {
					
					dispose();

					sheet = null;
					marginsheet = null;
					file = null;
					database = null;
					marginbase = null;
					index = new ArrayList<Object>();
					description = new ArrayList<String>();
					price = new ArrayList<String>();
					achat = new ArrayList<String>();
					reference = new ArrayList<String>();
					quantity = new ArrayList<String>();
					totalyprice = new ArrayList<String>();
					jLabel4.setText("");
					margin = false;
					Screen1 s1 = new Screen1();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					s1.setLocation((screen.width - s1.getSize().width)/2,(screen.height - s1.getSize().height)/2);
					s1.setVisible(true);
					quotationprice = 0.0;
					totalbuyprice = 0.0;
					discount = 0.0;
					transportval = 0.0;
					transport = false;
					dataload = false;
					refund = false;
					assistance = 0;
					jTextField12.setText("0.0");
					//jTextField12.setEnabled(false);
					//jCheckBox2.setSelected(false);
					rowcount = 1;
					save = false;
					parents = "";
					date = "";
					from = "";
					to = "";
					object = "";
					payment = "";
					incoterm = "";
					salesman = "";
					tel = "";
					fax = "";
					email = "";
					referencequot = "";
					gsm = "";
					remarks = "";
					recipientname = "";
					text = false;
					image = true;
					transportval = 0.0;
					assistance = 0.0;
					jcheckb1 = false;
					jcheckb2 = true;
					jcheckb3 = false;
					printermailer = "";
					
					referencepro = "";
					address = "";
					postcode = "";
					location = "";
					customer = "";
					
					printDiscount = false;
				}
				
				/* Action sur Exit */
				if(e.getSource().equals(menubar.getjMenuItem9())) {
					dispose();
				}
				
				/* Action sur menu Help install */
				if(e.getSource().equals(menubar.getjMenuItemHelpInstall()))
				{
					if ( Desktop.isDesktopSupported() ) {
						Desktop desktop = Desktop.getDesktop();
						File help = new File("doc/help.html");
						
						if (desktop.isSupported(Desktop.Action.BROWSE)) {
							try {
								try {
									desktop.browse(new URI("doc/help.html"));
									//desktop.open(help);
								} 
								catch (URISyntaxException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							catch (IOException ec) {
								//javax.swing.JOptionPane.showMessageDialog(null,"Unable to open your web browser (Error 1) : The file is not found");
								try {
									desktop.open(help);
								} 
								catch (IOException e1) {
									// TODO Auto-generated catch block
									javax.swing.JOptionPane.showMessageDialog(null,"Unable to open the web page");
								}
							}
						}
					}
				}
				
				/* Action sur menu Help use */
				if(e.getSource().equals(menubar.getjMenuItemHelpUse()))
				{
					if ( Desktop.isDesktopSupported() ) {
						Desktop desktop1 = Desktop.getDesktop();
						File helpuse = new File("doc/help_use.html");
						
						if (desktop1.isSupported(Desktop.Action.BROWSE)) {
							try {
								try {
									desktop1.browse(new URI("doc/help_use.html"));
									//desktop1.open(helpuse);
								} 
								catch (URISyntaxException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							catch (IOException ec) {
								//javax.swing.JOptionPane.showMessageDialog(null,"Unable to open your web browser (Error 1) : The file is not found");
								try {
									desktop1.open(helpuse);
								} 
								catch (IOException e1) {
									// TODO Auto-generated catch block
									javax.swing.JOptionPane.showMessageDialog(null,"Unable to open the web page");
								}
							}
						}
					}
				}
			}
		};
		/*****************************************************************************************************************/
		menubar.getjMenuItem3().addActionListener(actionlistener);
		menubar.getjMenuItem4().addActionListener(actionlistener);
		menubar.getjMenuItem5().addActionListener(actionlistener);
		menubar.getjMenuItem6().addActionListener(actionlistener);
		menubar.getjMenuItem7().addActionListener(actionlistener);
		menubar.getjMenuItem8().addActionListener(actionlistener);
		menubar.getjMenuItem9().addActionListener(actionlistener);
		menubar.getjMenuItem20().addActionListener(actionlistener);
		menubar.getjMenuItem18().addActionListener(actionlistener);
		menubar.getjMenuItem10().addActionListener(actionlistener);
		menubar.getjMenuItem22().addActionListener(actionlistener);
		menubar.getjMenuItem23().addActionListener(actionlistener);
		menubar.getjMenuItemHelpInstall().addActionListener(actionlistener);
		menubar.getjMenuItemHelpUse().addActionListener(actionlistener);
		
		jTextField3.setFocusable(false);
		jTextField2.setFocusable(false);
		jTextField6.setFocusable(false);

		jTable1.getModel().addTableModelListener(new TableModelListener(){

			@Override
			public void tableChanged(TableModelEvent arg0) {
				if(arg0.getColumn()!=-1){

					int row = arg0.getFirstRow();
					int column = arg0.getColumn();
					
					TableModel model = (TableModel)arg0.getSource();
					Object data = model.getValueAt(row, column);
					save=false;
					
					if(column==0){
						try{
							index.set(row, data.toString());
							System.out.println("modif =====> " + data);
						}
						catch (Exception e) {
							index.set(row, index.get(row));
						}
					}
					if(column==1){
						if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
							reference.set(row, reference.get(row));
						}
						else {
							reference.set(row, data.toString());
							System.out.println("modif =====> " + data);
						}
					}
					if(column==2){	
						description.set(row, data.toString());
						System.out.println("modif =====> " + data);
					}
					
					if(column==3){
						if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
							quantity.set(row, quantity.get(row));
						}
						else {
							if(margin==true){
								buyprice -= Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));	
							}
							
							quantity.set(row, data.toString());
							System.out.println("modif =====> " + data);
							
							if(margin==true){
								buyprice += Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));
							}
							try {
								quotationprice -= Double.parseDouble(totalyprice.get(row));
								totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
								quotationprice += Double.parseDouble(totalyprice.get(row));
								
								jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
								
								jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
								
								if(margin==true){
									if(quotationprice != 0){
										jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
										jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
									}
									else{
										jTextField11.setText("");
										jTextField18.setText("");
									}
								}
							}
							catch (Exception e) {
								System.out.println(e);
							}
						}
					}

					if(column==4){
						if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
							price.set(row, price.get(row));
						}
						else {
							price.set(row, data.toString());
							System.out.println("modif =====> " + data);
						}
						try {
							quotationprice-=Double.parseDouble(totalyprice.get(row));
							totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
							quotationprice+=Double.parseDouble(totalyprice.get(row));
							
							jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
							jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
						}
						catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
						if(margin==true){
							if(quotationprice!=0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}

					if(column==5){
						if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
							discountprod.set(row, discountprod.get(row));
						}
						else {
							discountprod.set(row, data.toString());
						}
					}
					
					if(column==6){
						if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
							totalyprice.set(row, totalyprice.get(row));
						}
						else {
							totalyprice.set(row, data.toString());
							System.out.println("modif =====> " + data);
						}
					}
				}
			}
		});

		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField6.setEditable(false);

		if(margin==true){
			jLabel10.setVisible(true);
			jLabel13.setVisible(true);
			jLabel15.setVisible(true);
			jLabel21.setVisible(true);
			jTextField11.setVisible(true);
			jTextField18.setVisible(true);
			jTextField5.setVisible(true);
			jTextField7.setVisible(true);
			jTextField11.setEnabled(false);
			jTextField18.setEnabled(false);
			jTextField5.setEnabled(false);
			jTextField7.setEnabled(false);
		}
		else{
			jLabel10.setVisible(false);
			jLabel13.setVisible(false);
			jLabel15.setVisible(false);
			jLabel21.setVisible(false);
			jTextField11.setVisible(false);
			jTextField18.setVisible(false);
			jTextField5.setVisible(false);
			jTextField7.setVisible(false);
		}
	
		/* Action sur la zone texte Quotation Price */
		jTextField9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField9ActionPerformed(evt);
			}
			private void jTextField9ActionPerformed(ActionEvent evt) {
				try {
					quotationprice = Double.parseDouble(jTextField9.getText());
					if(quotationprice < 0){
						quotationprice = 0;
						jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
						
						if(margin==true){
							if(quotationprice != 0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}
				}
				catch (Exception f) {
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
					if(margin==true){
						if(quotationprice!=0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
				}
			}
		});
		jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/* Action sur zone texte Start-up */
		jTextField12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField12ActionPerformed(evt);
			}

			private void jTextField12ActionPerformed(ActionEvent evt) {
				try {
					if(jTextField12.getText().contains(",")){
						jTextField12.setText(jTextField12.getText().replace(",", "."));
					}
					
					//var assistance = contenu de TextField Start up
					assistance = Double.parseDouble(jTextField12.getText());
					//Calcul "Quotation Price" = (Total Price - (Total Price * discount/100) + transportval + assistance)
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
					//Si margin ok
					if(margin==true){
						//Si Total Price != 0 
						if(quotationprice!=0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						//Sinon vide
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the assistance is a number."); 
					assistance = 0.0;
					jTextField12.setText(df.format(assistance));
				}
			}
		});

		/* Action sur checkbox Start-up */
		jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}

			private void jCheckBox2ActionPerformed(ActionEvent evt) {

				if(jCheckBox2.isSelected()){
					assistance = 0;
					jTextField12.setText(df.format(assistance));
					jTextField12.setEnabled(true);
				}
				else{
					jTextField12.setText("");
					jTextField12.setEnabled(false);
					assistance = 0;
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
					
					if(margin==true){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
				}
			}
		});

		/* Action sur checkbox Transport */
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if(transport){
					jcheckb1 = false;
					transport = false;
					jTextField17.setEnabled(false);
					jTextField17.setText("");
					transportval = 0.0;
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)).replaceAll(","," "));
					
					if(margin==true){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
				}
				else if(!transport){
					jcheckb1 = true;
					transport = true;
					jTextField17.setEnabled(true);
					transportval = 0.0;
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
					if(margin){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
					jTextField17.setText(df.format(transportval));
				}
			}
		});

		/* Action sur la zone texte Transport */
		jTextField17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField17ActionPerformed(evt);
			}

			private void jTextField17ActionPerformed(ActionEvent evt) {
				try{
					if(jTextField17.getText().contains(",")){
						jTextField17.setText(jTextField17.getText().replace(",", "."));
					}
					transportval = Double.parseDouble(jTextField17.getText());
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
					if(margin==true){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the transport is a number."); 
					transportval=0.0;
					jTextField17.setText(df.format(transportval));
				}
			}
		});

		/* Action sur checkbox Discount */
		jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox3ActionPerformed(evt);
			}
			private void jCheckBox3ActionPerformed(ActionEvent evt) {
				if(jCheckBox3.isSelected()){
					discount = 0;
					jTextField10.setText(df.format(discount));
					jTextField10.setEnabled(true);
					jcheckb3 = true;
					refund = true;
				}
				else{
					jTextField10.setText("");
					jTextField10.setEnabled(false);
					discount = 0;
					jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
					
					if(margin==true){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
					jcheckb3 = false;
					refund = false;
				}
			}
		});
		
		/* Action sur zone texte Discount */
		jTextField10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField10ActionPerformed(evt);
			}

			private void jTextField10ActionPerformed(ActionEvent evt) {
				try{
					if(jTextField10.getText().contains(",")){
						jTextField10.setText(jTextField10.getText().replace(",", "."));
					}
					
					discount = Double.parseDouble(jTextField10.getText());
					
					if((discount>100)||(discount<0)){
						discount = 0;
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the discount is a number between 0 and 100."); 
						jTextField10.setText(df.format(discount));
					}
					else{
						jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
						if(margin==true){
							if(quotationprice != 0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the discount is a number between 0 and 100."); 
					discount = 0;
					jTextField10.setText(df.format(discount));
				}

				if(margin==true){
					if(quotationprice != 0){
						jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
						jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
					}
					else{
						jTextField11.setText("");
						jTextField18.setText("");
					}
				}
			}
		});

		/* Action sur Bouton Save Data */
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton10ActionPerformed(evt);
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void jButton10ActionPerformed(ActionEvent evt) throws IOException {
				// TODO Auto-generated method stub
				DataExportScreen das = new DataExportScreen();
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
				das.setLocation((screen.width - das.getSize().width)/2,(screen.height - das.getSize().height)/2);
				das.setVisible(true);
				System.out.println("Save data done");
			}
		});
		
		/*Action sur Bouton Schema */
		jButtonSchema.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButtonSchemaActionPerformed(evt);
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void jButtonSchemaActionPerformed(ActionEvent evt) throws IOException {
				// TODO Auto-generated method stub
				ConstructScreen tc = new ConstructScreen();
				System.out.println("Schema");
			}
		});

		/* Action sur Bouton Open Data  */
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton9ActionPerformed(evt);
				} 
				catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void jButton9ActionPerformed(ActionEvent evt) throws IndexOutOfBoundsException, BiffException, IOException {
				DataImport di=new DataImport();
				di.importe();
				totalbuyprice = buyprice;
				System.out.println("PA total recup : " + df.format(totalbuyprice));
				if(margin==true){
					jTable1.setModel(new javax.swing.table.DefaultTableModel(
						new Object [][] {},
						new String [] {
							"Index", 		//[0]
							"Code", 		//[1]
							"Description", 	//[2]
							"Qty", 			//[3]
							"Unit price", 	//[4]
							"Disc %",		//[5]
							"Total price",	//[6]
							"Profit %", 	//[7]
							"KP"			//[8]
						}
					) {
						@SuppressWarnings("rawtypes")
						Class[] types = new Class [] {
							java.lang.Object.class, //Index
							java.lang.String.class, //Code
							java.lang.String.class, //Description
							java.lang.String.class, //Qty
							java.lang.Object.class, //Unit Price
							java.lang.Object.class,	//Discount
							java.lang.Object.class,	//Total Price
							java.lang.Object.class, //Profit
							java.lang.Object.class	//KP
						};
						boolean[] canEdit = new boolean [] {
							true,	//Index
							true, 	//Code
							true, 	//Description
							true, 	//Qty
							true,	//Unit Price
							false,	//Discount
							false, 	//Total Price
							false, 	//Profit
							false	//KP
						};

						@SuppressWarnings({ "rawtypes", "unchecked" })
						public Class getColumnClass(int columnIndex) {
							return types [columnIndex];
						}

						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return canEdit [columnIndex];
						}
					});
				}
				else{
					jTable1.setModel(new javax.swing.table.DefaultTableModel(
						new Object [][] {},
						new String [] {
							"Index", 		//[0]
							"Code", 		//[1]
							"Description", 	//[2]
							"Qty", 			//[3]
							"Unit price",	//[4]
							"Disc %",		//[5]
							"Total price"	//[6]
						}
					){
						@SuppressWarnings("rawtypes")
						Class[] types = new Class [] {
							java.lang.Object.class,	//Index 
							java.lang.String.class, //Code
							java.lang.String.class, //Description
							java.lang.String.class, //Qty
							java.lang.Object.class,	//Unit Price
							java.lang.Object.class,	//Discount
							java.lang.Object.class	//Total Price
						};
						boolean[] canEdit = new boolean [] {
							true, 	//Index
							true, 	//Code
							true, 	//Description
							true, 	//Qty
							true, 	//Unit Price
							false,	//Discount
							false	//Total Price
						};

						@SuppressWarnings({ "rawtypes", "unchecked" })
						public Class getColumnClass(int columnIndex) {
							return types [columnIndex];
						}

						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return canEdit [columnIndex];
						}
					});
				}
				jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				jTable1.getColumnModel().getColumn(0).setResizable(true);	//Index
				jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
				jTable1.getColumnModel().getColumn(1).setResizable(true);	//Code
				jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
				jTable1.getColumnModel().getColumn(2).setResizable(true);	//Description
				jTable1.getColumnModel().getColumn(2).setPreferredWidth(170);
				jTable1.getColumnModel().getColumn(3).setResizable(true);	//Qty
				jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
				jTable1.getColumnModel().getColumn(4).setResizable(true);	//Unit Price
				jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
				jTable1.getColumnModel().getColumn(5).setResizable(true);	//Discount
				jTable1.getColumnModel().getColumn(5).setPreferredWidth(75);
				jTable1.getColumnModel().getColumn(6).setResizable(true);	//Total Price
				jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);

				if(margin==true){
					jTable1.getColumnModel().getColumn(7).setResizable(true);	//Profit
					jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
					jTable1.getColumnModel().getColumn(8).setResizable(true);	//KP
					jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
				}
				jTable1.getModel().addTableModelListener(new TableModelListener(){

					@Override
					public void tableChanged(TableModelEvent arg0) {
						if(arg0.getColumn()!=-1){

							int row = arg0.getFirstRow();
							int column = arg0.getColumn();
							
							TableModel model = (TableModel)arg0.getSource();
							Object data = model.getValueAt(row, column);
							save=false;
							
							if(column==0){
								try{
									index.set(row, data.toString());
									System.out.println("data load modif =====> " + data);
								}
								catch (Exception e) {
									index.set(row, index.get(row));
								}
							}
							if(column==1){
								if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
									reference.set(row, reference.get(row));
								}
								else {
									reference.set(row, data.toString());
									System.out.println("data load modif =====> " + data);
								}
							}
							if(column==2){	
								description.set(row, data.toString());
								System.out.println("data load modif =====> " + data);
							}
							
							if(column==3){
								if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
									quantity.set(row, quantity.get(row));
								}
								else {
									if(margin==true){
										buyprice -= Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));	
									}
									
									quantity.set(row, data.toString());
									System.out.println("data load modif =====> " + data);
									
									if(margin==true){
										buyprice += Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));
									}
									try {
										quotationprice -= Double.parseDouble(totalyprice.get(row));
										totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
										quotationprice += Double.parseDouble(totalyprice.get(row));
										System.out.println("totalyprice: " + totalyprice);
										jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
										
										jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
										
										if(margin==true){
											if(quotationprice != 0){
												jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
												jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
											}
											else{
												jTextField11.setText("");
												jTextField18.setText("");
											}
										}
									}
									catch (Exception e) {
										System.out.println(e);
									}
								}
							}

							if(column==4){
								if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
									price.set(row, price.get(row));
								}
								else {
									price.set(row, data.toString());
									System.out.println("data load modif =====> " + data);
								}
								try {
									quotationprice-=Double.parseDouble(totalyprice.get(row));
									totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
									quotationprice+=Double.parseDouble(totalyprice.get(row));
									
									jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
									jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
								}
								catch (Exception e) {
									// TODO: handle exception
									System.out.println(e);
								}
								if(margin==true){
									if(quotationprice!=0){
										jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
										jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
									}
									else{
										jTextField11.setText("");
										jTextField18.setText("");
									}
								}
							}

							if(column==5){
								if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
									discountprod.set(row, discountprod.get(row));
								}
								else {
									discountprod.set(row, data.toString());
								}
							}
							
							if(column==6){
								if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
									totalyprice.set(row, totalyprice.get(row));
								}
								else {
									totalyprice.set(row, data.toString());
									System.out.println("data load modif =====> " + data);
								}
							}
						}
					}
				});
				rowcount=1;
				
				for(int i=0;i<=reference.size()-1;i++){

					if(margin==true) {
						((DefaultTableModel) jTable1.getModel()).addRow(
							new Object[]{
								index.get(i),
								reference.get(i), 
								description.get(i),
								quantity.get(i),
								price.get(i),
								discountprod.get(i),	//discount
								totalyprice.get(i),
								achat.get(i),
								kp.get(i)
							}
						); 
					}
					else {
						((DefaultTableModel) jTable1.getModel()).addRow(
							new Object[]{
								index.get(i),
								reference.get(i), 
								description.get(i),
								quantity.get(i),
								price.get(i),
								discountprod.get(i),	//discount
								totalyprice.get(i)
							}
						);
					}
					
					if(!index.get(i).toString().isEmpty()) {
						rowcount=Integer.parseInt(index.get(i).toString())+1;
					}
				}
				
				jTextField9.setText(df.format(quotationprice -(quotationprice*discount/100)+transportval).replaceAll(","," "));
				
				if(margin==true){
					if(quotationprice != 0){
						jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
						jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
					}
					else{
						jTextField11.setText("");
						jTextField18.setText("");
					}
				}
				if(transportval != 0){
					jTextField17.setText(df.format(transportval));
					jTextField17.setEnabled(true);
					jCheckBox1.setSelected(true);
					transport=true;
				}
				if(discount != 0){
					jTextField10.setText(df.format(discount));
					jTextField10.setEnabled(true);
					jCheckBox3.setSelected(true);
				}
				if(assistance != 0){
					jTextField12.setText(df.format(assistance));
					jTextField12.setEnabled(true);
					jCheckBox2.setSelected(true);
				}
				jCheckBox1.setEnabled(true);
				jCheckBox2.setEnabled(true);
				jCheckBox3.setEnabled(true);
				jTextField9.setEditable(true);
			}
		});
		
		/***************************************** FocusListner *****************************************/
		FocusListener focuslistener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(e.getSource().equals(jTextField9)){
					try{
						quotationpricetmp = Double.parseDouble(jTextField9.getText());
					}
					catch (Exception f) {
						quotationpricetmp = quotationprice;
					}
				}
			}

			@Override
			public void focusLost(FocusEvent e) {

				jLabel11.setText("");
				
				/* Action sur TextField Unit price */
				if(e.getSource().equals(jTextField2)){
					try {
						if(jTextField2.getText().contains(",")){
							//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
							jTextField2.setText(df.format(uprice).replaceAll(",",""));
						}
						
						pprice = (uprice-(uprice*pdiscount/100))*pquantity;
						jTextField4.setText(df.format(pprice).replaceAll(","," "));
					}
					catch (Exception f) {
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the unit price is a number."); 
						//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
						jTextField2.setText(df.format(uprice).replaceAll(",",""));
					}
					
					if(margin==true){
						if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
							umargin = 0.0;	
							jTextField5.setText("");
							jTextField7.setText("");
						}
						else{
							umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));

							jTextField5.setText(df.format(umargin).replaceAll(",",""));
							jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
						}
					}
				}
				
				/* Action sur TextField Transport */
				if(e.getSource().equals(jTextField17))
				{
					try {
						if(jTextField17.getText().contains(",")){
							jTextField17.setText(jTextField17.getText().replace(",", "."));
						}

						transportval=Double.parseDouble(jTextField17.getText());
						jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
						
						if(margin==true){
							if(quotationprice!=0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}
					catch (Exception f) {
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the transport is a number."); 
						transportval = 0.0;
						jTextField17.setText(df.format(transportval));
					}
				}
				
				/* Action sur TextField Start up */
				if(e.getSource().equals(jTextField12)){
					try {
						if(jTextField12.getText().contains(",")){
							jTextField12.setText(jTextField12.getText().replace(",", "."));
						}

						assistance = Double.parseDouble(jTextField12.getText());

						jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
						
						if(margin==true){
							if(quotationprice != 0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}
					catch (Exception f) {
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the transport is a number."); 
						assistance = 0.0;
						jTextField12.setText(df.format(assistance));
					}
				}
				
				/* Action sur TextField Discount */
				if(e.getSource().equals(jTextField10)){
					try {
						if(jTextField10.getText().contains(",")){
							jTextField10.setText(jTextField10.getText().replace(",", "."));
						}
						
						discount = Double.parseDouble(jTextField10.getText());
						
						if((discount>100)||(discount<0)){
							discount=0;
							javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the discount is a number between 0 and 100."); 
							jTextField10.setText(df.format(discount));
						}
						else {
							jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
							if(margin==true){
								if(quotationprice != 0){
									jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
									jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
								}
								else{
									jTextField11.setText("");
									jTextField18.setText("");
								}
							}
						}
					}
					catch (Exception f) {
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the discount is a number between 0 and 100."); 
						discount = 0;
						jTextField10.setText(df.format(discount));
					}

					if(margin==true){
						if(quotationprice != 0){
							jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
							jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
						}
						else{
							jTextField11.setText("");
							jTextField18.setText("");
						}
					}
				}
				
				/* Action sur TextField Quantity */
				if(e.getSource().equals(jTextField3)){
					try {
						pquantity = Integer.parseInt(jTextField3.getText());
						pprice = (uprice-(uprice*pdiscount/100))*pquantity;
						jTextField4.setText(df.format(pprice).replaceAll(","," "));
					}
					catch (Exception f) {
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the quantity is a integer."); 
						jTextField3.setText(Integer.toString(pquantity));
					}
				}
				
				//Action sur TextField Quotation price
				if(e.getSource().equals(jTextField9)){
					try {
						if(quotationpricetmp != Double.parseDouble(jTextField9.getText())){
							quotationprice = Double.parseDouble(jTextField9.getText());
						}
						if(margin==true){
							if(quotationprice != 0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}
					catch (Exception f) {
						jTextField9.setText(df.format(quotationprice));
						if(margin==true){
							if(quotationprice != 0){
								jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
								jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
							}
							else{
								jTextField11.setText("");
								jTextField18.setText("");
							}
						}
					}
				}
				
				/* Action sur TextField refund (in %)(left) */
				if(e.getSource().equals(jTextField6)){
					try {
						if(jTextField6.getText().contains(",")){
							jTextField6.setText(jTextField6.getText().replace(",", "."));
						}
						
						pdiscount = Double.parseDouble(jTextField6.getText());
						
						if((pdiscount>100) || (pdiscount<0)){
							pdiscount = 0;
							javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the product discount is a number between 0 and 100."); 
							jTextField6.setText(df.format(pdiscount));
						}
						else{
							pprice = (uprice-(uprice*pdiscount/100))*pquantity;
							jTextField4.setText(df.format(pprice).replaceAll(","," "));
							//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
							jTextField2.setText(df.format(uprice).replaceAll(",",""));
						}
						
						if(margin==true){
							if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
								umargin = 0.0;	
								jTextField5.setText("");
								jTextField7.setText("");
							}
							else{
								umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));

								jTextField5.setText(df.format(umargin).replaceAll(",",""));
								jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
								//buyprice+=Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()))*Double.parseDouble(jTextField3.getText());
							}
						}
					}
					catch (Exception f) {
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the product discount is a number between 0 and 100."); 
						pdiscount = 0;
						jTextField6.setText(df.format(pdiscount));
						pprice = (uprice-(uprice*pdiscount/100))*pquantity;
						jTextField4.setText(df.format(pprice).replaceAll(","," "));
					}
				}
			}
		};
		/************************************************************************************************/
		
		jTextField2.addFocusListener(focuslistener);
		jTextField3.addFocusListener(focuslistener);
		jTextField6.addFocusListener(focuslistener);
		jTextField9.addFocusListener(focuslistener);
		jTextField10.addFocusListener(focuslistener);
		jTextField12.addFocusListener(focuslistener);
		jTextField17.addFocusListener(focuslistener);
		
		/* Action sur Button Update */
		/*
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}

			private void jButton13ActionPerformed(ActionEvent evt) {
				double total=0.0;
				quotationprice=0;
				buyprice=0;
				for(int i=0;i<reference.size();i++){
					if(!reference.get(i).isEmpty()){
						price.set(i, database.readPice(reference.get(i)));
						total=Double.parseDouble(database.readPice(reference.get(i)))*Double.parseDouble(quantity.get(i));
						totalyprice.set(i, df.format(total));
						quotationprice+=total;
						if(margin==true){
							marginprice.set(i,Double.parseDouble(totalyprice.get(i))/Double.parseDouble(marginbase.readMargin(reference.get(i))));
							buyprice+=Double.parseDouble(marginbase.readMargin(reference.get(i)))*Double.parseDouble(quantity.get(i));			
						}
					}
				}
				for(int i=0;i<reference.size();i++){
					if(!reference.get(i).isEmpty()){
						((DefaultTableModel)jTable1.getModel()).setValueAt(price.get(i), i, 4);
						((DefaultTableModel)jTable1.getModel()).setValueAt(totalyprice.get(i), i, 5);
						if(margin==true){
							((DefaultTableModel)jTable1.getModel()).setValueAt(marginprice.get(i), i, 7);		
						}
					}
				}
				jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(",",""));
				if(margin==true){
					if(quotationprice!=0){
						jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/buyprice).replaceAll(",",""));
						jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-buyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
					}
					else{
						jTextField11.setText("");
						jTextField18.setText("");
					}
				}
			}
		});
		*/
		
		//jButtonProfit.setEnabled(true);
		/******************************** Gestionnaire d'écoute Button buying price list ***************************/
		jButtonProfit2.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				/* Action sur Button Profit */
				if(evt.getSource().equals(jButtonProfit2)){
					int alert = 0;
					String Textes[];
					//Si tableau n'est pas vide, demande de confirmation de suppression pour chargement de buying price list
					if(rowcount > 1){
						alert = javax.swing.JOptionPane.showConfirmDialog(
									new javax.swing.JFrame(),
									"Your quotation will be deleted, do you want to continue?",
									"Warning",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE
								);
					}
					if (alert==JOptionPane.YES_OPTION){
						try {
							JFileChooser chooser = new JFileChooser(parents){

								private static final long serialVersionUID = 1L;

								@Override
								public void approveSelection(){
									File file2 = getSelectedFile();
									if(file2.exists()){
										parents = file2.getParent();
										super.approveSelection();
									
										System.out.println("\t-> State Purchasing list file: " + file2);
									
										//réinitialisation du tableau et du Qutation price si purchasing price list load
										quotationprice = 0;
										jTextField9.setText(df.format(quotationprice));
									
										rowcount = 1;
										index = new ArrayList<Object>();
										description = new ArrayList<String>();
										price = new ArrayList<String>();
										achat = new ArrayList<String>();
										reference = new ArrayList<String>();
										quantity = new ArrayList<String>();
										totalyprice = new ArrayList<String>();
										discountprod = new ArrayList<String>();
										
																			
										//Si purchasing price list load -> modif tableau
										if(file2 != null){
											jLabelNameListProfit.setText(file2.getName());
										
											jTable1.setModel(new javax.swing.table.DefaultTableModel(
												new Object [][] {},
												new String [] {
													"Index", 		//[0]
													"Code", 		//[1]
													"Description", 	//[2]
													"Qty", 			//[3]
													"Unit price", 	//[4]
													"Disc %",		//[5]
													"Total price", 	//[6]
													"Profit %", 	//[7]
													"KP"			//[8]
												}
											) {
												@SuppressWarnings("rawtypes")
												Class[] types = new Class [] {
													java.lang.Object.class, //Index
													java.lang.String.class, //Code
													java.lang.String.class, //Description
													java.lang.String.class, //Qty
													java.lang.Object.class, //Unit Price
													java.lang.Object.class,	//Discount
													java.lang.Object.class,	//Total Price
													java.lang.Object.class,	//Profit
													java.lang.Object.class	//KP
												};
												boolean[] canEdit = new boolean [] {
													true, 	//Index
													true, 	//Code
													true, 	//Description
													true, 	//Qty
													true, 	//Unit Price
													false,	//Discount
													false,	//Total Price
													false, 	//Profit
													false	//KP
												};

												@SuppressWarnings({ "rawtypes", "unchecked" })
												public Class getColumnClass(int columnIndex) {
													return types [columnIndex];
												}

												public boolean isCellEditable(int rowIndex, int columnIndex) {
													return canEdit [columnIndex];
												}
											});
											/*+++++++++++ RAJOUT +++++++++++*/
											jTable1.getModel().addTableModelListener(new TableModelListener(){

												@Override
												public void tableChanged(TableModelEvent arg0) {
													if(arg0.getColumn()!=-1){

														int row = arg0.getFirstRow();
														int column = arg0.getColumn();
														
														TableModel model = (TableModel)arg0.getSource();
														Object data = model.getValueAt(row, column);
														save=false;
														
														if(column==0){
															try{
																index.set(row, data.toString());
																System.out.println("modif with purchasing =====> " + data);
															}
															catch (Exception e) {
																index.set(row, index.get(row));
															}
														}
														if(column==1){
															if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
																reference.set(row, reference.get(row));
															}
															else {
																reference.set(row, data.toString());
																System.out.println("modif with purchasing =====> " + data);
															}
														}
														if(column==2){	
															description.set(row, data.toString());
															System.out.println("modif with purchasing =====> " + data);
														}
														
														if(column==3){
															if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
																quantity.set(row, quantity.get(row));
															}
															else {
																if(margin==true){
																	buyprice -= Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));	
																}
																
																quantity.set(row, data.toString());
																System.out.println("modif with purchasing =====> " + data);
																
																if(margin==true){
																	buyprice += Double.parseDouble(marginbase.readMargin(reference.get(row)))*Double.parseDouble(quantity.get(row));
																}
																try {
																	quotationprice -= Double.parseDouble(totalyprice.get(row));
																	totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
																	quotationprice += Double.parseDouble(totalyprice.get(row));
																	System.out.println("totalyprice: " + totalyprice);
																	jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
																	
																	jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
																	
																	if(margin==true){
																		if(quotationprice != 0){
																			jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
																			jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
																		}
																		else{
																			jTextField11.setText("");
																			jTextField18.setText("");
																		}
																	}
																}
																catch (Exception e) {
																	System.out.println(e);
																}
															}
														}

														if(column==4){
															if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
																price.set(row, price.get(row));
															}
															else {
																price.set(row, data.toString());
																System.out.println("modif with purchasing =====> " + data);
															}
															try {
																quotationprice-=Double.parseDouble(totalyprice.get(row));
																totalyprice.set(row, df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""));
																quotationprice+=Double.parseDouble(totalyprice.get(row));
																
																jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
																jTable1.getModel().setValueAt(df.format(Double.parseDouble(quantity.get(row))*((Double.parseDouble(price.get(row)))-(Double.parseDouble(price.get(row))*Double.parseDouble(discountprod.get(row))/100))).replaceAll(",",""), row, 6);
															}
															catch (Exception e) {
																// TODO: handle exception
																System.out.println(e);
															}
															if(margin==true){
																if(quotationprice!=0){
																	jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
																	jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
																}
																else{
																	jTextField11.setText("");
																	jTextField18.setText("");
																}
															}
														}

														if(column==5){
															if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
																discountprod.set(row, discountprod.get(row));
															}
															else {
																discountprod.set(row, data.toString());
															}
														}
														
														if(column==6){
															if(reference.get(row).isEmpty()||description.get(row).isEmpty()||quantity.get(row).isEmpty()||price.get(row).isEmpty()||discountprod.get(row).isEmpty()||totalyprice.get(row).isEmpty()){
																totalyprice.set(row, totalyprice.get(row));
															}
															else {
																totalyprice.set(row, data.toString());
																System.out.println("modif with purchasing =====> " + data);
															}
														}
													}
												}
											});
											/*++++++++++ FIN RAJOUT +++++++++*/
										}
									}
								}
							};
						
							if(!parents.isEmpty()){
								File file = new File(parents);
								chooser.setCurrentDirectory(file);
							}
						
							chooser.setAcceptAllFileFilterUsed(false);
							FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier Excel (.xls)","xls");
							chooser.setFileFilter(filter);
							int returnval = chooser.showOpenDialog(null);
							String msgLoad = null;
						
							if(returnval == JFileChooser.APPROVE_OPTION) {
								WorkbookSettings ws=new WorkbookSettings();
								ws.setSuppressWarnings(true);
								marginsheet = Workbook.getWorkbook(chooser.getSelectedFile(),ws).getSheet(0);
								
								marginbase = new ReadMargin(marginsheet);

								if(marginbase.isMarginList()){
									margin = true;
									new Copy();
									sheet = Workbook.getWorkbook(Copy.copyfile(chooser.getSelectedFile(), new File("lastmarginfile.info")),ws).getSheet(0);
									
									if(Window.locale.toString().equals("en")){
										msgLoad = "The Purchasing price list has been loaded";
									}
									else if(Window.locale.toString().equals("it")){
										msgLoad = "Prezzo di acquisto elenco è stato addebitato";
									}
									else if(Window.locale.toString().equals("fr")){
										msgLoad = "La liste de prix d'achat a été chargé";
									}
									javax.swing.JOptionPane.showMessageDialog(null, msgLoad); 
								
									// si purchasing pice list load -> affichage des labels & textfields caché
									jLabel10.setVisible(true);
									jLabel13.setVisible(true);
									jLabel15.setVisible(true);
									jLabel21.setVisible(true);
									jTextField11.setVisible(true);
									jTextField18.setVisible(true);
									jTextField5.setVisible(true);
									jTextField7.setVisible(true);
									jTextField11.setEnabled(false);
									jTextField18.setEnabled(false);
									jTextField5.setEnabled(false);
									jTextField7.setEnabled(false);
								}
								else{
									margin = false;
																		
									if(Window.locale.toString().equals("en")){
										msgLoad = "The file \""+chooser.getSelectedFile().getName()+"\" is not in purchasing price list file format";
									}
									else if(Window.locale.toString().equals("it")){
										msgLoad = "Il file \""+chooser.getSelectedFile().getName()+"\" non è un elenco dei prezzi di acquisto";
									}
									else if(Window.locale.toString().equals("fr")){
										msgLoad = "Le fichier \""+chooser.getSelectedFile().getName()+"\" n'est pas une liste de prix d'achat";
									}
									javax.swing.JOptionPane.showMessageDialog(null, msgLoad);
								
									jLabel10.setVisible(false);
									jLabel13.setVisible(false);
									jLabel15.setVisible(false);
									jLabel21.setVisible(false);
									jTextField11.setVisible(false);
									jTextField18.setVisible(false);
									jTextField5.setVisible(false);
									jTextField7.setVisible(false);
								}
							}
							System.out.println("\t -> State var margin: " + margin);
						}
						catch (Exception ev) {
							javax.swing.JOptionPane.showMessageDialog(null,ev);
						}
					}
					else if(alert==JOptionPane.NO_OPTION){}
				}
			}
		});
		/*******************************************************************************************************************************/
		
		jButton3.setEnabled(false);
		/* Action sur le Bouton Move up */
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		
		jButton6.setEnabled(false);
		/* Action sur le Bouton Move down */
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		
		//jButtonDuplicate.setEnabled(false);
		/* Action sur le Bouton Duplicate */
		/*jButtonDuplicate.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				jButtonDuplicateActionPerformed(evt);
			}
		});*/

		/* Action sur la zone de texte Unit Price */
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}

			private void jTextField2ActionPerformed(ActionEvent evt) {
				try {
					if(jTextField2.getText().contains(",")){
						//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
						jTextField2.setText(df.format(uprice).replaceAll(",",""));
					}
					uprice = Double.parseDouble(jTextField2.getText());
					pprice = (uprice-(uprice*pdiscount/100))*pquantity;
					jTextField4.setText(df.format(pprice).replaceAll(","," "));
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the unit price is a number."); 
					//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
					jTextField2.setText(df.format(uprice).replaceAll(",",""));
				}
				
				if(margin==true){
					if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
						umargin = 0.0;	
						jTextField5.setText("");
						jTextField7.setText("");
						//buyprice+=0.0;
					}
					else{
						umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));

						jTextField5.setText(df.format(umargin).replaceAll(",",""));
						jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
						//buyprice+=Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()))*Double.parseDouble(jTextField3.getText());
						if(jTextField2.getText().contentEquals("0")){
							System.out.println("Unit price = " + uprice + " et pdiscount = " + pdiscount + " ,donc on remplace :");
							uprice=Double.parseDouble(database.readPice(jList1.getSelectedValue().toString()));
							pdiscount=100;
							jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100));
							System.out.println("Unit price = " + uprice + " et pdiscount = " + pdiscount);
						}
					}
				}
			}
		});
		
		/* Action sur la zone de texte Quantity */
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}

			private void jTextField3ActionPerformed(ActionEvent evt) {
				try {
					pquantity = Integer.parseInt(jTextField3.getText());
					pprice = (uprice-(uprice*pdiscount/100))*pquantity;
					jTextField4.setText(df.format(pprice).replaceAll(","," "));
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the quantity is a integer."); 
					jTextField3.setText(Integer.toString(pquantity));
				}
			}
		});
		
		/* Action sur la zone de texte Refund (in %) left */
		jTextField6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField6ActionPerformed(evt);
			}

			private void jTextField6ActionPerformed(ActionEvent evt) {
				try{
					if(jTextField6.getText().contains(",")){
						jTextField6.setText(jTextField6.getText().replace(",", "."));
					}
					
					pdiscount = Double.parseDouble(jTextField6.getText());
					
					if((pdiscount>100) || (pdiscount<0)){
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the product discount is a number between 0 and 100."); 
						pdiscount = 0;
						jTextField6.setText(df.format(pdiscount));
					}
					else {
						pprice = (uprice-(uprice*pdiscount/100))*pquantity;
						jTextField4.setText(df.format(pprice).replaceAll(","," "));
						//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
						jTextField2.setText(df.format(uprice).replaceAll(",",""));
					}
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the product discount is a number between 0 and 100."); 
					pdiscount = 0;
					jTextField6.setText(df.format(pdiscount));
					pprice = (uprice-(uprice*pdiscount/100))*pquantity;
					jTextField4.setText(df.format(pprice).replaceAll(","," "));
				}
				
				if(margin==true){
					if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
						umargin = 0.0;	
						jTextField5.setText("");
						jTextField7.setText("");
						//buyprice+=0.0;
					}
					else{
						umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));

						jTextField5.setText(df.format(umargin).replaceAll(",",""));
						jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
						//buyprice+=Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()))*Double.parseDouble(jTextField3.getText());
						System.out.println("_ " + jTextField7.getText());
						System.out.println(uprice);
					}
				}
			}
		});
		
		jButton1.setEnabled(false);

		
		/* Action sur le Bouton Add */
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}

			private void jButton1ActionPerformed(ActionEvent evt) {
				try {
					if(jTextField6.getText().contains(",")){
						jTextField6.setText(jTextField6.getText().replace(",", "."));
					}
					
					pdiscount = Double.parseDouble(jTextField6.getText());
					
					if((pdiscount>100) || (pdiscount<0)){
						javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the product discount is a number between 0 and 100."); 
						pdiscount = 0;
						jTextField6.setText(df.format(pdiscount));
					}
					else{
						pprice = (uprice-(uprice*pdiscount/100))*pquantity;
						jTextField4.setText(df.format(pprice).replaceAll(","," "));
					}
					
					
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the product discount is a number between 0 and 100."); 
					pdiscount = 0;
					jTextField6.setText(df.format(pdiscount));
				}
				/****************************************************************************************************************************************/
				try {
					pquantity = Integer.parseInt(jTextField3.getText());
					pprice = (uprice-(uprice*pdiscount/100))*pquantity;
					jTextField4.setText(df.format(pprice).replaceAll(","," "));
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the quantity is a integer."); 
					jTextField3.setText(Integer.toString(pquantity));
				}
				/****************************************************************************************************************************************/
				try{
					if(jTextField2.getText().contains(",")){
						//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
						jTextField2.setText(df.format(uprice).replaceAll(",",""));
					}
					uprice = Double.parseDouble(jTextField2.getText());
					//pprice = uprice*pquantity;
					pprice = (uprice-(uprice*pdiscount/100))*pquantity;
					jTextField4.setText(df.format(pprice).replaceAll(",",""));
				}
				catch (Exception f) {
					javax.swing.JOptionPane.showMessageDialog(null,"The expected value for the unit price is a number."); 
					//jTextField2.setText(df.format((uprice-(uprice*pdiscount/100))).replaceAll(",",""));
					jTextField2.setText(df.format(uprice).replaceAll(",",""));
				}
				/****************************************************************************************************************************************/
				if(margin==true){
					//Definition de buyprice -> lecture buying list
					buyprice=Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()))*Double.parseDouble(jTextField3.getText());
										
					//Calcul Prix total d'achat
					totalbuyprice += buyprice;
					System.out.println("->Total buying price : " + totalbuyprice);
					
					//Definition de profit -> (PV - PA) / PV
					profit = Double.parseDouble(jTextField7.getText());
					System.out.println("\t -> Buying price product (Double) : "+ buyprice);
				}
				//Cast byprice et profit en String pour Remplissage du tableau
				String s_buyprice = "" + buyprice;
				String s_profit = "" + profit;
				String s_pdiscount = "" + pdiscount;
									

				/******************************* Remplissage des cellules du tableau **************************************/
				index.add(rowcount);	//index -> incrémentation ligne
				description.add(jTextArea1.getText());	//description -> contenu du TextArea1
				price.add(jTextField2.getText()); //price -> contenu de jTextField2 (Unit Price)
				achat.add(s_profit);
				discountprod.add(s_pdiscount);
				reference.add(jList1.getSelectedValue().toString()); //reference -> elem choisi dans List1 (produit)
				quantity.add(jTextField3.getText()); //quantity -> contenu de TextField3 (Quantity)
				totalyprice.add(jTextField4.getText()); //totalprice -> contenu de TextField4 (Total Price)
				quotationprice+=Double.parseDouble(jTextField4.getText()); //quotationprice = Total Price + quotationprice
				
				if(Window.locale.toString().equals("en")){
					jLabel11.setText("<html>The product <font color=red>" + jList1.getSelectedValue().toString() + "</font> has been added to the quote.</html>" );
				}
				else if(Window.locale.toString().equals("it")){
					jLabel11.setText("<html>Il prodotto <font color=red>" + jList1.getSelectedValue().toString() + "</font> è stato aggiunto al preventivo.</html>" );
				}
				else if(Window.locale.toString().equals("fr")){
					jLabel11.setText("<html>Le produit <font color=red>" + jList1.getSelectedValue().toString() + "</font> a bien été ajouté au devis</html>" );
				}
				
					
				if(margin==true){
					kp.add(Double.parseDouble(jTextField5.getText()));
					((DefaultTableModel) jTable1.getModel()).addRow(
						new Object[]{
							rowcount++, //Index
							jList1.getSelectedValue().toString(), //Code
							jTextArea1.getText(), 	//Description
							jTextField3.getText(), 	//Quantity
							jTextField2.getText(), 	//Unit Price
							pdiscount,				//Discount
							jTextField4.getText(), 	//Total Price
							profit, 				//Profit
							jTextField5.getText() 	//KP
						}
					);
					
					//Debug
					System.out.println("\t -> Buying price (String) : "+ s_buyprice);
					System.out.println("\t -> Profit (String) : " + s_profit);
					System.out.println("Remplissage test avec margin, car margin = " + margin);
					System.out.println("\t -> KP = " + kp);
					System.out.println("\t -> Profit (Double) : " + profit );
					

					String s_quote = df.format(quotationprice).replace(',',' ');
					System.out.println("Quotationprice: "+s_quote);
					
				}
				else {
					((DefaultTableModel) jTable1.getModel()).addRow(
						new Object[]{
							rowcount++, //index
							jList1.getSelectedValue().toString(), //Code
							jTextArea1.getText(), 		//Description
							jTextField3.getText(), 		//Quantity
							jTextField2.getText(),		//Unit Price
							pdiscount,					//Discount
							jTextField4.getText() 		//Total Price
						}
					);
					//Debug
					System.out.println("Remplissage test sans margin , car margin = " + margin);
				}

				if(margin==true){
					//Si valeur produit selectionnée est vide
					if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
						umargin = 0.0;	
						jTextField5.setText("");
						jTextField7.setText("");
						buyprice += 0.0;
					}
					//Sinon si valeur produit existe
					else{
						umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));
						jTextField5.setText(df.format(umargin).replaceAll(",",""));
						jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
						buyprice = Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()))*Double.parseDouble(jTextField3.getText());
					}
				}
				pdiscount = 0.0;
				jTextField6.setText(df.format(pdiscount));
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField6.setText("");
				pquantity = 1;
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField7.setText("");
				jTextArea1.setText("");
				
				jButton1.setEnabled(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField6.setEditable(false);
				jTextField3.setFocusable(false);
				jTextField2.setFocusable(false);
				jTextField6.setFocusable(false);
				jList1.setModel(new DefaultListModel());
				list = false;
				jTextField9.setEditable(true);
				jCheckBox3.setEnabled(true);
				jCheckBox2.setEnabled(true);
				jCheckBox1.setEnabled(true);
				save = false;
				jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
				
				if(margin==true){
					if(quotationprice!=0){
						jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
						jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
					}
					else{
						jTextField11.setText("");
						jTextField18.setText("");
					}
				}
			}
		});
		
		/* Action de la souris sur le tableau */
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		
		/* Action clavier sur le tableau */
		jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTable1KeyPressed(evt);
			}

			private void jTable1KeyPressed(KeyEvent evt) {
				if(evt.getKeyCode()==40 || evt.getKeyCode()==38){
					jTable1.addColumnSelectionInterval(0, 4);
					jButton2.setEnabled(true);
					//jButtonDuplicate.setEnabled(true);

					if(jTable1.getSelectedRowCount()==1)
					{
						if(jTable1.getSelectedRow()!=0){
							jButton3.setEnabled(true);
						}
						else{
							jButton3.setEnabled(false);
						}

						if(jTable1.getSelectedRow() != jTable1.getRowCount()-1){
							jButton6.setEnabled(true);
						}
						else{
							jButton6.setEnabled(false);
						}
					}
					else{
						jButton3.setEnabled(false);
						jButton6.setEnabled(false);
					}
				}
			}
		});

		/* Action sur la zone de texte Search Product */
		this.jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField1ActionPerformed(evt);
			}

			@SuppressWarnings("deprecation")
			private void jTextField1ActionPerformed(KeyEvent evt) {
				jLabel11.setText("");
				if(jTextField1.getText().equals("")){
					if (Character.isJavaLetter(evt.getKeyChar())|| evt.getKeyLocation()==KeyEvent.KEY_LOCATION_NUMPAD||evt.getKeyCode()==Event.ENTER){

						list = true;
						jTextArea1.setText(null);
						jTextField2.setText(null);
						pquantity = 1;
						jTextField4.setText(null);
						jTextField2.setEditable(false);
						jTextField3.setEditable(false);
						jTextField6.setEditable(false);

						jTextField3.setText("");
						jTextField6.setText("");
						jButton1.setEnabled(false);
						jList1.setModel(database.readSearch(jTextField1.getText()));
						jList1.setEnabled(true);
					}
				}
				else {
					if (Character.isJavaLetter(evt.getKeyChar())|| evt.getKeyLocation()==KeyEvent.KEY_LOCATION_NUMPAD||evt.getKeyCode()==Event.ENTER||evt.getKeyCode()==8){
						list = true;
						jTextArea1.setText(null);
						jTextField2.setText(null);
						pquantity = 1;
						jTextField4.setText(null);
						jTextField2.setEditable(false);
						jTextField3.setEditable(false);
						jTextField6.setEditable(false);
						jTextField3.setText("");
						jTextField6.setText("");
						jButton1.setEnabled(false);
						jList1.setModel(database.readSearch(jTextField1.getText()));
						jList1.setEnabled(true);
					}
				}
			}
		});
		
		jList1.setFocusable(true);
		/* Action clavier sur la zone de texte Search Product */
		jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField1KeyPressed(evt);
			}

			private void jTextField1KeyPressed(KeyEvent evt) {
				//KeyCode 40 = Flèche bas
				if(evt.getKeyCode()==40){
					//Si la liste != -1 (donc rempli)
					if(jList1.getFirstVisibleIndex()!=-1){
						jList1.setSelectedIndex(0);
						jList1.requestFocus(); 
					}
				}
			}
		}); 

		jButton2.setEnabled(false);
		
		/* Action sur le Bouton Delete Row */
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}

			private void jButton2ActionPerformed(ActionEvent evt) {

				int[] selectedRows = jTable1.getSelectedRows();
				int rowindexcount = 0;
				int indextmp = index.size();
				
				for(int i=0;i<=selectedRows.length-1;i++){
					
					if(totalyprice.get(jTable1.getSelectedRow()).isEmpty()){
						quotationprice-=0;
					}
					else {
						quotationprice-=Double.parseDouble(totalyprice.get(jTable1.getSelectedRow()));
						if(quotationprice<0){
							quotationprice=0;
						}
					}

					if(margin==true){
						if(reference.get(jTable1.getSelectedRow()).isEmpty()){
							buyprice-=0;
						}
						else {
							//buyprice-=Double.parseDouble(marginbase.readMargin(reference.get(jTable1.getSelectedRow())))*Double.parseDouble(quantity.get(jTable1.getSelectedRow()));//quantity;
							totalbuyprice-=Double.parseDouble(marginbase.readMargin(reference.get(jTable1.getSelectedRow())))*Double.parseDouble(quantity.get(jTable1.getSelectedRow()));//quantity;
						}
					}

					if(!index.get(jTable1.getSelectedRow()).toString().isEmpty()){
						rowindexcount++;

						if(indextmp==index.size()){
							indextmp = Integer.parseInt(index.get(jTable1.getSelectedRow()).toString());
						}
					}
					
					index.remove(jTable1.getSelectedRow());
					reference.remove(jTable1.getSelectedRow());
					description.remove(jTable1.getSelectedRow());
					quantity.remove(jTable1.getSelectedRow());
					price.remove(jTable1.getSelectedRow());
					discountprod.remove(jTable1.getSelectedRow());
					totalyprice.remove(jTable1.getSelectedRow());
					
					try {
						if(margin==true){
							achat.remove(jTable1.getSelectedRow());
							kp.remove(jTable1.getSelectedRow());
						}
					}
					catch (Exception e) {
						// TODO: handle exception
					}
					((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow());
				}
				
				jButton2.setEnabled(false);
				jButton3.setEnabled(false);
				jButton6.setEnabled(false);
				//jButtonDuplicate.setEnabled(false);
				jTextField9.setText(df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance).replaceAll(","," "));
				
				if(margin==true){
					if(quotationprice!=0){
						//buyprice-=Double.parseDouble(marginbase.readMargin(reference.get(jTable1.getSelectedRow())))*Double.parseDouble(quantity.get(jTable1.getSelectedRow()));
						jTextField11.setText(df.format((quotationprice-(quotationprice*discount/100))/totalbuyprice).replaceAll(",",""));
						jTextField18.setText(df.format((((quotationprice-(quotationprice*discount/100))-totalbuyprice)/(quotationprice-(quotationprice*discount/100)))*100).replaceAll(",",""));
					}
					else{
						jTextField11.setText("");
						jTextField18.setText("");
					}
				}
				
				rowcount=1;
				for(int i=0;i<=reference.size()-1;i++){
					try{
						if(Integer.parseInt(index.get(i).toString())>indextmp){
							index.set(i,Integer.parseInt(index.get(i).toString())-rowindexcount);
						}
					}
					catch (Exception e) {}
					
					((DefaultTableModel) jTable1.getModel()).setValueAt(index.get(i), i, 0);
					  
					if(!index.get(i).toString().isEmpty()){
						rowcount=Integer.parseInt(index.get(i).toString())+1;
					}
				}
			}
		});

		/* Action souris sur List1 */
		jList1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jList1MouseClicked(evt);
			}
		});

		/* Action clavier sur List1 */
		jList1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jList1KeyPressed(evt);
			}

			@SuppressWarnings("static-access")
			private void jList1KeyPressed(KeyEvent evt) {
				jLabel11.setText("");
				if(list){
					if(evt.getKeyCode() == Event.ENTER){
						jTextArea1.setText(null);
						jTextField2.setText(null);
						pquantity = 1;
						jTextField3.setText("1");
						jTextField4.setText(null);
						jTextField2.setEditable(true);
						jTextField3.setEditable(true);
						jTextField6.setEditable(true);
						jTextField3.setFocusable(true);
						jTextField2.setFocusable(true);
						jTextField6.setFocusable(true);
						jButton1.setEnabled(true);
						DefaultListModel test=new DefaultListModel();
						test.addElement(jList1.getSelectedValue().toString());
						jList1.setModel(test);
						jList1.setSelectedIndex(0);
						pdiscount = 0;
						jTextField6.setText(df.format(pdiscount));
						jTextArea1.setText(database.readDescription(jList1.getSelectedValue().toString()));
						jTextArea1.setFont(new Font(null).getFont(new String(database.getStreamBytes())));

						if(margin==true){
							if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
								umargin = 0.0;	
								jTextField5.setText("");
								jTextField7.setText("");
							}
							else{
								umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));
								jTextField5.setText(df.format(umargin).replaceAll(",",""));
								jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
							}
						}

						uprice = Double.parseDouble(database.readPice(jList1.getSelectedValue().toString()));
						//jTextField2.setText(df.format(uprice-(uprice*pdiscount/100)).replaceAll(",",""));
						jTextField2.setText(df.format(uprice).replaceAll(",",""));
						pprice = (uprice-(uprice*pdiscount/100))*pquantity;
						jTextField4.setText(df.format(pprice).replaceAll(","," "));
					}
				}
			}
		});

		/* Action sur le Bouton Add Row */
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}

			private void jButton4ActionPerformed(ActionEvent evt) {
				index.add(rowcount);
				//ajout ligne avec index incremente
				if(margin==true){
					((DefaultTableModel) jTable1.getModel()).addRow(
						new Object[]{
							rowcount++,				//[0]
							"", 					//[1]
							jTextField8.getText(),	//[2]
							"",						//[3]
							"",						//[4]
							"",						//[5]
							"",						//[6]
							"",						//[7]
							""						//[8]
						}
					);
					achat.add("");					
					kp.add("");
				}
				else {
					((DefaultTableModel) jTable1.getModel()).addRow(
						new Object[]{
							rowcount++,				//[0]
							"",						//[1]
							jTextField8.getText(),	//[2]
							"",						//[3]
							"",						//[4]
							"",						//[5]
							""						//[6]
						}
					);
				}
				reference.add("");
				description.add(jTextField8.getText());
				quantity.add("");
				price.add("");
				totalyprice.add("");
				discountprod.add("");
				jTextField8.setText("");
				save = false;
			}
		});
		
		/* Action sur le Bouton Add Title */
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
			private void jButton8ActionPerformed(ActionEvent evt) {
				index.add("");
				//ajout ligne vide
				if(margin==true){
					((DefaultTableModel) jTable1.getModel()).addRow(
						new Object[]{
							"",						//[0]
							"", 					//[1]
							jTextField8.getText(),	//[2]
							"",						//[3]
							"",						//[4]
							"",						//[5]
							"",						//[6]
							"",						//[7]
							""						//[8]
						}
					);
					achat.add("");					
					kp.add("");
				}
				else {
					((DefaultTableModel) jTable1.getModel()).addRow(
						new Object[]{
							"",						//[0]
							"", 					//[1]
							jTextField8.getText(),	//[2]
							"",						//[3]
							"",						//[4]
							"",						//[5]
							""						//[6]
						}
					); 
				}
				reference.add("");
				description.add(jTextField8.getText());
				quantity.add("");
				price.add("");
				totalyprice.add("");
				discountprod.add("");
				jTextField8.setText("");
				save = false;
			}
		});
	}
	
	@SuppressWarnings("static-access")
	private void jList1MouseClicked(MouseEvent e) {
		jLabel11.setText("");
		if(list){
			if(e.getClickCount()==1){ //teste sur le nombre des clicks
				jTextArea1.setText(null);
				jTextField2.setText(null);
				jTextField3.setText("1");
				pquantity = 1;
				jTextField4.setText(null);
				jTextField2.setEditable(true);
				jTextField3.setEditable(true);
				jTextField6.setEditable(true);
				jTextField3.setFocusable(true);
				jTextField2.setFocusable(true);
				jTextField6.setFocusable(true);
				jButton1.setEnabled(true);
				DefaultListModel test=new DefaultListModel();
				test.addElement(jList1.getSelectedValue().toString());
				jList1.setModel(test);
				jList1.setSelectedIndex(0);
				pdiscount = 0;
				jTextField6.setText(df.format(pdiscount));
				jTextArea1.setText(database.readDescription(jList1.getSelectedValue().toString()));
				jTextArea1.setFont(new Font(null).getFont(new String(database.getStreamBytes())));

				uprice = Double.parseDouble(database.readPice(jList1.getSelectedValue().toString()));
				jTextField2.setText(df.format(uprice).replaceAll(",",""));
				pprice = (uprice-(uprice*pdiscount/100))*pquantity;

				jTextField4.setText(df.format(pprice).replaceAll(","," "));

				if(margin==true){
					if(marginbase.readMargin(jList1.getSelectedValue().toString()).isEmpty()){
						umargin = 0.0;	
						jTextField5.setText("");
						jTextField7.setText("");
					}
					else{
						umargin = (uprice-(uprice*pdiscount/100))/Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString()));
						jTextField5.setText(df.format(umargin).replaceAll(",",""));
						jTextField7.setText(df.format((((uprice-(uprice*pdiscount/100))-Double.parseDouble(marginbase.readMargin(jList1.getSelectedValue().toString())))/uprice)*100).replaceAll(",",""));
					}
				}
			}
		}
	}

	private void jTable1MouseClicked(MouseEvent e) {
 
		jTable1.addColumnSelectionInterval(0, 4);
		jButton2.setEnabled(true);

		if(jTable1.getSelectedRowCount()==1)
		{
			if(jTable1.getSelectedRow()!=0){
				jButton3.setEnabled(true);
			}
			else{
				jButton3.setEnabled(false);
			}

			if(jTable1.getSelectedRow()!=jTable1.getRowCount()-1){
				jButton6.setEnabled(true);
			}
			else{
				jButton6.setEnabled(false);
			}
		}
		else{
			jButton3.setEnabled(false);
			jButton6.setEnabled(false);
		}
	}

	// Action sur Move Up
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int tmp=jTable1.getSelectedRow();
		if(tmp!=0){
			((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow());
			try{
				if(Integer.parseInt(index.get(tmp).toString()) >= Integer.parseInt(index.get(tmp-1).toString())){	
					index.add(tmp-1, index.get(tmp-1));
					index.remove(tmp);
				}
				else {
					index.add(tmp-1, index.get(tmp));
					index.remove(tmp+1);
				}
			}
			catch (Exception e) {
				index.add(tmp-1, index.get(tmp));
				index.remove(tmp+1);
			}
			
			if(margin==true){
				((DefaultTableModel)jTable1.getModel()).insertRow(
					tmp-1, 
					new Object[]{
						index.get(tmp-1),
						reference.get(tmp), 
						description.get(tmp),
						quantity.get(tmp),
						price.get(tmp),
						discountprod.get(tmp),
						totalyprice.get(tmp),
						achat.get(tmp),
						kp.get(tmp)
					}
				);
				achat.add(tmp-1, achat.get(tmp));
				achat.remove(tmp+1);
				
				kp.add(tmp-1, kp.get(tmp));
				kp.remove(tmp+1);
			}
			else {
				((DefaultTableModel)jTable1.getModel()).insertRow(
					tmp-1, 
					new Object[]{
						index.get(tmp-1),
						reference.get(tmp), 
						description.get(tmp),
						quantity.get(tmp),
						price.get(tmp),
						discountprod.get(tmp),
						totalyprice.get(tmp)
					}
				);
			}
			((DefaultTableModel)jTable1.getModel()).setValueAt(index.get(tmp), tmp, 0);
			
			reference.add(tmp-1, reference.get(tmp));
			reference.remove(tmp+1);
			
			description.add(tmp-1, description.get(tmp));
			description.remove(tmp+1);
			
			quantity.add(tmp-1, quantity.get(tmp));
			quantity.remove(tmp+1);

			price.add(tmp-1, price.get(tmp));
			price.remove(tmp+1);
			
			discountprod.add(tmp-1, discountprod.get(tmp));
			discountprod.remove(tmp+1);
			
			totalyprice.add(tmp-1, totalyprice.get(tmp));
			totalyprice.remove(tmp+1);
		}
		if(tmp==1){
			jButton3.setEnabled(false);
		}

		if(!jButton6.isEnabled()){
			jButton6.setEnabled(true);
		}

		jTable1.getSelectionModel().addSelectionInterval(tmp-1,tmp-1); 

	}
	
	/* Action Button6 Move down */
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		int tmp=jTable1.getSelectedRow();

		if(tmp==jTable1.getRowCount()-2){
			jButton6.setEnabled(false);
		}

		((DefaultTableModel)jTable1.getModel()).removeRow(jTable1.getSelectedRow());

		try{
			if(Integer.parseInt(index.get(tmp).toString()) <= Integer.parseInt(index.get(tmp+1).toString())){	
				index.add(tmp+2, index.get(tmp+1));
				index.remove(tmp+1);
			}
			else 
			{
				index.add(tmp+2, index.get(tmp));
				index.remove(tmp);
			}
		}
		catch (Exception e) {
			index.add(tmp+2, index.get(tmp));
			index.remove(tmp);
		}
		
		if(margin==true){
			((DefaultTableModel)jTable1.getModel()).insertRow(
				tmp+1, 
				new Object[]{
					index.get(tmp+1),		//[0]
					reference.get(tmp), 	//[1]
					description.get(tmp),	//[2]
					quantity.get(tmp),		//[3]
					price.get(tmp),			//[4]
					discountprod.get(tmp),	//[5]
					totalyprice.get(tmp),	//[6]
					achat.get(tmp),			//[7]
					kp.get(tmp)				//[8]
				}
			);
			
			achat.add(tmp+2, achat.get(tmp));
			achat.remove(tmp);
			
			kp.add(tmp+2, kp.get(tmp));
			kp.remove(tmp);
		}
		else{
			((DefaultTableModel)jTable1.getModel()).insertRow(
				tmp+1, 
				new Object[]{
						index.get(tmp+1),		//[0]
						reference.get(tmp), 	//[1]
						description.get(tmp),	//[2]
						quantity.get(tmp),		//[3]
						price.get(tmp),			//[4]
						discountprod.get(tmp),	//[5]
						totalyprice.get(tmp)	//[6]
				}
			);
		}
		((DefaultTableModel)jTable1.getModel()).setValueAt(index.get(tmp), tmp, 0);
		
		reference.add(tmp+2, reference.get(tmp));
		reference.remove(tmp);
		
		description.add(tmp+2, description.get(tmp));
		description.remove(tmp);
		
		quantity.add(tmp+2, quantity.get(tmp));
		quantity.remove(tmp);
		
		price.add(tmp+2, price.get(tmp));
		price.remove(tmp);
		
		discountprod.add(tmp+2, discountprod.get(tmp));
		discountprod.remove(tmp);
		
		totalyprice.add(tmp+2, totalyprice.get(tmp));
		totalyprice.remove(tmp);

		if(!jButton3.isEnabled()){
			jButton3.setEnabled(true);
		}

		jTable1.getSelectionModel().addSelectionInterval(tmp+1,tmp+1); 
	}
	
	/********************************************************************************************************************/
	/* Action ButtonDuplicate Duplicate */
	/*
	private void jButtonDuplicateActionPerformed(java.awt.event.ActionEvent evt) {
		
		int tmp = jTable1.getSelectedRow(); 		
		int[] selectedRows = jTable1.getSelectedRows();
		
				
		for(int i=0;i<=selectedRows.length-1;i++){
	
			index.add(rowcount);
			if(margin==true){
				((DefaultTableModel) jTable1.getModel()).addRow(
					new Object[]{
						rowcount++,				//[0]
						reference.get(tmp),		//[1]
						description.get(tmp),	//[2]
						quantity.get(tmp),		//[3]
						price.get(tmp),			//[4]
						totalyprice.get(tmp),	//[5]
						achat.get(tmp),			//[6]
						kp.get(tmp)				//[7]
					}
				);
			}
			else{
				((DefaultTableModel) jTable1.getModel()).addRow(
					new Object[]{
						rowcount++,				//[0]
						reference.get(tmp),		//[1]
						description.get(tmp),	//[2]
						quantity.get(tmp),		//[3]
						price.get(tmp),			//[4]
						totalyprice.get(tmp)	//[5]
					}	
				);
			}
			
			reference.add(jTable1.getValueAt(tmp,1).toString());
			description.add(jTable1.getValueAt(tmp,2).toString());
			quantity.add(jTable1.getValueAt(tmp,3).toString());
			price.add(jTable1.getValueAt(tmp,4).toString());
			
			totalyprice.add(jTable1.getValueAt(tmp,5).toString());

			achat.add(jTable1.getValueAt(tmp,6).toString());
		
			save=false;
			
			System.out.println("LIGNE SELECTIONNEE : " + (tmp+1)); //recup num ligne selectionnee 
			test = jTable1.getValueAt(tmp,5).toString(); //test = contenu cellule selectionne de la colonne Total Price
			prix = Double.parseDouble(test); //prix = Cast de test en Double
			
			System.out.println("Price = " + prix ); //Test de calcul

			cpt++;
		    total += prix;

		    System.out.println( "After increment " + cpt + ": total = " + total );
		    
		    jTextField9.setText(total.toString()); //total (cast Double -> String) dans Quotation Price  
		}
		System.out.println("+------------ Fin Debug Duplicate ---------------------+");
	}
	*/
	/************************************************************************************************************/
	
	//Get sur l'état de margin
	public boolean getVarMargin(){
		return margin;
	}
	
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	/* Redimensionnement auto */
	@Override
	public void componentResized(ComponentEvent arg0) {
		//Size mini
		if(this.getWidth()<1100||this.getHeight()<582){
			this.setSize(1100, 582);
		}
		
		//recup Largeur & Hauteur Screen2
		this.widht=this.getWidth();
		this.height=this.getHeight();

		//Placement des composants de Screen2
		if(Window.locale.toString().equals("en")){
			jLabel15.setBounds((int)(widht/2.251 + jScrollPane3.getWidth()-70-55), (int)(height/1.293), 120, 20);
			jLabel21.setBounds((int)(widht/2.251 + jScrollPane3.getWidth()-70-90), (int)(height/1.2125), 148, 20);
		}
		else if(Window.locale.toString().equals("it")){
			jLabel15.setBounds((int)(widht/2.251 + jScrollPane3.getWidth()-70-68), (int)(height/1.293), 120, 20);
			jLabel21.setBounds((int)(widht/2.251 + jScrollPane3.getWidth()-70-105), (int)(height/1.2125), 148, 20);
		}
		else if(Window.locale.toString().equals("fr")){
			jLabel15.setBounds((int)(widht/2.251 + jScrollPane3.getWidth()-70-65), (int)(height/1.293), 120, 20);
			jLabel21.setBounds((int)(widht/2.251 + jScrollPane3.getWidth()-70-90), (int)(height/1.2125), 148, 20);
		}
		jLabel3.setBounds((int) (this.widht/33.76), (int)((this.height/3.6375)-30-(this.height/29.1)), (int) (this.widht/5.065), (int)(this.height/41.571));
		jTextField1.setBounds((int) (this.widht/33.76), (int)(this.height/3.6375)-30, (int) (this.widht/9.21), 20);
		jScrollPane1.setBounds((int) (this.widht/33.76), (int)(this.height/3.6375), (int) (this.widht/7.79), (int)(this.height/4.48));
		jLabel4.setBounds((int) (this.widht/5.33),(int)((this.height/3.6375)-(this.height/29.1)) , 70, 14);
		jScrollPane2.setBounds((int) (this.widht/5.33), (int)(this.height/3.6375), (int) (this.widht/5), (int)(this.height/4.48));
		jLabel5.setBounds((int) (this.widht/33.76), (int)(this.height/8.314), 140, 14);
		jLabel2.setBounds((int) (this.widht/33.76)+jLabel5.getWidth(), (int)(this.height/8.314), 320, 14);
		jLabel6.setBounds((int) (this.widht/33.76), (int)((this.height/1.5729)-20), 90, 14);
		jTextField2.setBounds((int) (this.widht/33.76), (int)(this.height/1.5729), 70, 20);
		jLabel7.setBounds((int) (this.widht/33.76), (int)((this.height/1.81875)-20), 60, 14);
		jTextField3.setBounds((int) (this.widht/33.76), (int)(this.height/1.81875), 70, 20);
		jLabel8.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-80), (int)((this.height/1.81875)-20), 85, 14);
		jTextField4.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-80), (int)(this.height/1.81875), 80, 20);
		jButton1.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-65), (int)(this.height/1.5729), 65, 23);
		/************************************* Placement Profit ***********************************************************/
		//jButtonProfit.setBounds((int) ((this.widht/5.33)+jScrollPane2.getWidth()-55), (int)(this.height/1.386), 59, 23);
		//jLabelProfit.setBounds((int) (this.widht/33.76),(int)(this.height/6.84), 100, 14 );
		jLabelProfit.setBounds((int) (this.widht/33.76),(int)(this.height/1.23829), 190, 14 );
		jLabelNameListProfit.setBounds((int) (this.widht/33.76)+(jLabelProfit.getWidth()), (int)(this.height/1.23829), 240, 14);
		/******************************************************************************************************************/
		jLabel9.setBounds((int) (this.widht/33.76), (int)((this.height/1.386)-20), 100, 14);
		jTextField6.setBounds((int) ((this.widht/33.76) + jCheckBoxPrintDiscount.getWidth()), (int)(this.height/1.386), 70, 20);
		jLabel10.setBounds((int) (this.widht/5.33), (int)((this.height/1.81875)-20), 66, 14);
		jTextField5.setBounds((int) (this.widht/5.33), (int)(this.height/1.81875), 80, 20);
		jLabel13.setBounds((int) (this.widht/5.33), (int)((this.height/1.5729)-20), 94, 14);
		jTextField7.setBounds((int) (this.widht/5.33), (int)(this.height/1.5729), 80, 20);
		jLabel11.setBounds((int) (this.widht/12.6626), (int)(this.height/1.1878), 400, 14);
		jScrollPane3.setBounds((int)(this.widht/2.251), (int)(this.height/11.64), (int)(this.widht/2.302), (int)(this.height/1.663));
		jButton2.setBounds((int)(this.widht/1.125), (int)(this.height/11.64), 90, 23);
		jTextField8.setBounds((int)(this.widht/2.251), (int)(this.height/29.1), (int)(this.widht/3.6178), 20);
		jTextField17.setBounds((int)(this.widht/2.251)+90, (int)(this.height/1.32272), 70, 20);
		jButton4.setBounds((int)(this.widht/1.3706), (int)(this.height/29.5), 73, 23);
		jButton3.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+30), 90, 23);
		jButton6.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+60), 90, 23);
		jLabel12.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70-100), (int)(this.height/1.4195), 90, 20);
		jTextField9.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70), (int)(this.height/1.4195), 70, 20);
		//jLabel14.setBounds((int)((this.widht/2.251)+70), (int)(this.height/1.4195), 72, 20);
		jTextField10.setBounds((int)((this.widht/2.251)+110), (int)(this.height/1.4195), 80, 20);
		jCheckBox3.setBounds((int)(this.widht/2.251), (int)(this.height/1.4195), 110, 23);
		jCheckBox1.setBounds((int)(this.widht/2.251), (int)(this.height/1.32272), 80, 20);
		jTextField11.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70), (int)(this.height/1.293), 70, 20);	
		jTextField18.setBounds((int)((this.widht/2.251)+jScrollPane3.getWidth()-70), (int)(this.height/1.2125), 70, 20);
		jCheckBox2.setBounds((int)(this.widht/2.251), (int)(this.height/1.23829), 65, 23);
		jTextField12.setBounds((int)(this.widht/2.251)+90, (int)(this.height/1.23829), 70, 20);
		jButton8.setBounds((int)(this.widht/1.3706)+jButton4.getWidth()+10, (int)(this.height/29.5), 73, 23);
		//jButton13.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+90), 90, 23);
		jCheckBoxPrintDiscount.setBounds((int) (this.widht/33.76), (int)(this.height/1.386), 105, 20);
		/************************************************* Placement Duplicate ***********************************************/
		//jButtonDuplicate.setBounds((int)(this.widht/1.125), (int)((this.height/11.64)+90), 90, 23);
		/*********************************************************************************************************************/
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, widht-18, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, height-61, Short.MAX_VALUE)
		);
	}

	@Override
	public void componentShown(ComponentEvent arg0) {}
}
