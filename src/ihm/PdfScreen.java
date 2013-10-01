package ihm;

import java.awt.Color;
import java.awt.Desktop;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import other.TextFieldLimit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import database.Footer;

public class PdfScreen extends JDialog {
	boolean exist=false;
	
	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JCheckBox jCheckBox4;
	private javax.swing.JCheckBox jCheckBox5;
	private javax.swing.JCheckBox jCheckBox6;
	private javax.swing.JCheckBox jCheckBox7;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField12;
	private javax.swing.JTextField jTextField13;
	private javax.swing.JTextField jTextField14;
	private javax.swing.JTextField jTextField15;
	private javax.swing.JTextField jTextField16;
	private javax.swing.JTextField jTextField17;
	private javax.swing.JTextField jTextField18;
	private javax.swing.JTextField jTextField19;
	private javax.swing.JTextField jTextField20;
	private javax.swing.JTextField jTextField21;
	private javax.swing.JTextField jTextField22;
	private javax.swing.JTextField jTextField23;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	private static javax.swing.JTextArea jTextArea1 ;
	private javax.swing.JLabel jLabel28;

	public PdfScreen() {
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_pdfExport"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_pdfExport"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_pdfExport"));
		}
		
		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setModal(true);
		initComponents();
		this.pack();
	}

	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jLabel20 = new javax.swing.JLabel();
		jTextField9 = new javax.swing.JTextField();
		jLabel21 = new javax.swing.JLabel();
		jTextField17 = new javax.swing.JTextField();
		jCheckBox2 = new javax.swing.JCheckBox();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox4 = new javax.swing.JCheckBox();
		jCheckBox5 = new javax.swing.JCheckBox();
		jLabel13 = new javax.swing.JLabel();
		jTextField10 = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jTextField11 = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jTextField12 = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		jTextField13 = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		jTextField14 = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();
		jTextField15 = new javax.swing.JTextField();
		jLabel18 = new javax.swing.JLabel();
		jTextField16 = new javax.swing.JTextField();
		
		jCheckBox3 = new javax.swing.JCheckBox();
		jCheckBox6 = new javax.swing.JCheckBox();
		jCheckBox7 = new javax.swing.JCheckBox();
		
		jButton1 = new javax.swing.JButton();
		
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		
		//jTextField18 = new TextFieldLimit(19);
		jTextField18 = new javax.swing.JTextField();
		jTextField19 = new javax.swing.JTextField();
		jTextField20 = new javax.swing.JTextField();
		//jTextField21 = new TextFieldLimit(19);
		jTextField21 = new javax.swing.JTextField();
		jTextField22 = new javax.swing.JTextField();
		jTextField23 = new javax.swing.JTextField();
		jLabel28 = new javax.swing.JLabel();
		
		jTextArea1 = new JTextArea();
		//jTextArea1.setBackground(Color.GRAY);
		jTextArea1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(135,153,255)));
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		/************************************ ANGLAIS ******************************/
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			jLabel21.setText((String)Window.res.getObject("lb_ref"));
			jLabel21.setBounds(210, 65, 60, 20);
			
			jLabel3.setText((String)Window.res.getObject("lb_date"));
			jLabel3.setBounds(40, 20, 27, 20);
			
			jLabel4.setText((String)Window.res.getObject("lb_from"));
			jLabel4.setBounds(40, 50, 28, 20);

			jLabel7.setText((String)Window.res.getObject("lb_to"));
			jLabel7.setBounds(50, 80, 16, 20);
			
			jLabel10.setText((String)Window.res.getObject("lb_object"));
			jLabel10.setBounds(25, 110, 40, 20);

			jLabel20.setText((String)Window.res.getObject("lb_recName"));
			jLabel20.setBounds(10, 140, 80, 20);
			
			jLabel13.setText((String)Window.res.getObject("lb_payment"));
			jLabel13.setBounds(10, 170, 46, 20);
			jTextField10.setBounds(70, 170, 320, 20);
			
			jLabel12.setText((String)Window.res.getObject("lb_incoterm"));
			jLabel12.setBounds(10, 200, 47, 20);
			
			jLabel22.setText((String)Window.res.getObject("lb_delivAddress"));
			jLabel22.setBounds(10, 230, 120, 20);

			jLabel23.setText((String)Window.res.getObject("lb_delivPostcode"));
			jLabel23.setBounds(10, 260, 120, 20);
			
			jLabel24.setText((String)Window.res.getObject("lb_delivTown"));
			jLabel24.setBounds(10, 290, 120, 20);
			
			jLabel25.setText((String)Window.res.getObject("lb_invoiceAddress"));
			jLabel25.setBounds(10, 320, 120, 20);
			jTextField21.setBounds(120, 320, 320, 20);

			jLabel26.setText((String)Window.res.getObject("lb_invoicePostcode"));
			jLabel26.setBounds(10, 350, 120, 20);
			
			jCheckBox7.setText((String)Window.res.getObject("cb_sameAddress"));
			jCheckBox7.setBounds(460, 350, 110, 20);
			
			jLabel27.setText((String)Window.res.getObject("lb_invoiceTown"));
			jLabel27.setBounds(10, 380, 120, 20);

			jLabel14.setText((String)Window.res.getObject("lb_firstName"));
			jLabel14.setBounds(10, 420, 60, 20);
			
			jLabel15.setText((String)Window.res.getObject("lb_tel"));
			jLabel15.setBounds(40, 480, 18, 20);
			
			jLabel16.setText((String)Window.res.getObject("lb_lastName"));
			jLabel16.setBounds(10, 450, 60, 20);

			jLabel17.setText((String)Window.res.getObject("lb_fax"));
			jLabel17.setBounds(40, 510, 22, 20);
			
			jLabel18.setText((String)Window.res.getObject("lb_mail"));
			jLabel18.setBounds(40, 540, 28, 20);
			
			jLabel28.setText((String)Window.res.getObject("lb_comment"));
			jLabel28.setBounds(10, 570, 50, 20);
			jTextArea1.setBounds(70, 570, 280, 100);
			
			jCheckBox3.setText((String)Window.res.getObject("cb_userData"));
			jCheckBox3.setBounds(310, 470, 100, 23);
			
			jButton1.setText((String)Window.res.getObject("bt_print"));
			jButton1.setBounds(360, 530, 73, 23);
		}
		/*********************************** ITALIEN **********************************/
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			jLabel21.setText((String)Window.res.getObject("lb_ref"));
			jLabel21.setBounds(210, 65, 60, 20);
			
			jLabel3.setText((String)Window.res.getObject("lb_date"));
			jLabel3.setBounds(40, 20, 27, 20);
			
			jLabel4.setText((String)Window.res.getObject("lb_from"));
			jLabel4.setBounds(45, 50, 28, 20);

			jLabel7.setText((String)Window.res.getObject("lb_to"));
			jLabel7.setBounds(50, 80, 16, 20);
			
			jLabel10.setText((String)Window.res.getObject("lb_object"));
			jLabel10.setBounds(10, 110, 50, 20);
			
			jLabel20.setText((String)Window.res.getObject("lb_recName"));
			jLabel20.setBounds(10, 140, 77, 20);
			
			jLabel13.setText((String)Window.res.getObject("lb_payment"));
			jLabel13.setBounds(10, 170, 70, 20);
			jTextField10.setBounds(90, 170, 320, 20);
			
			jLabel12.setText((String)Window.res.getObject("lb_incoterm"));
			jLabel12.setBounds(10, 200, 47, 20);
			
			jLabel22.setText((String)Window.res.getObject("lb_delivAddress"));
			jLabel22.setBounds(10, 230, 120, 20);
			
			jLabel23.setText((String)Window.res.getObject("lb_delivPostcode"));
			jLabel23.setBounds(10, 260, 120, 20);
			
			jLabel24.setText((String)Window.res.getObject("lb_delivTown"));
			jLabel24.setBounds(10, 290, 120, 20);
			
			jLabel25.setText((String)Window.res.getObject("lb_invoiceAddress"));
			jLabel25.setBounds(10, 320, 130, 20);
			jTextField21.setBounds(140, 320, 320, 20);
			
			jLabel26.setText((String)Window.res.getObject("lb_invoicePostcode"));
			jLabel26.setBounds(10, 350, 120, 20);
			
			jCheckBox7.setText((String)Window.res.getObject("cb_sameAddress"));
			jCheckBox7.setBounds(460, 350, 110, 20);
			
			jLabel27.setText((String)Window.res.getObject("lb_invoiceTown"));
			jLabel27.setBounds(10, 380, 120, 20);

			jLabel14.setText((String)Window.res.getObject("lb_firstName"));
			jLabel14.setBounds(28, 420, 60, 20);
			
			jLabel15.setText((String)Window.res.getObject("lb_tel"));
			jLabel15.setBounds(40, 480, 18, 20);
			
			jLabel16.setText((String)Window.res.getObject("lb_lastName"));
			jLabel16.setBounds(12, 450, 60, 20);
			
			jLabel17.setText((String)Window.res.getObject("lb_fax"));
			jLabel17.setBounds(40, 510, 22, 20);
			
			jLabel18.setText((String)Window.res.getObject("lb_mail"));
			jLabel18.setBounds(40, 540, 28, 20);
			
			jLabel28.setText((String)Window.res.getObject("lb_comment"));
			jLabel28.setBounds(10, 570, 70, 20);
			jTextArea1.setBounds(70, 570, 280, 100);
			
			jCheckBox3.setText((String)Window.res.getObject("cb_userData"));
			jCheckBox3.setBounds(310, 470, 100, 23);
			
			jButton1.setText((String)Window.res.getObject("bt_print"));
			jButton1.setBounds(360, 530, 85, 23);
		}
		/******************************** FRANCAIS *********************************/
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			jLabel21.setText((String)Window.res.getObject("lb_ref"));
			jLabel21.setBounds(210, 65, 60, 20);
			
			jLabel3.setText((String)Window.res.getObject("lb_date"));
			jLabel3.setBounds(40, 20, 27, 20);
			
			jLabel4.setText((String)Window.res.getObject("lb_from"));
			jLabel4.setBounds(45, 50, 28, 20);

			jLabel7.setText((String)Window.res.getObject("lb_to"));
			jLabel7.setBounds(50, 80, 16, 20);
			
			jLabel10.setText((String)Window.res.getObject("lb_object"));
			jLabel10.setBounds(30, 110, 36, 20);
			
			jLabel20.setText((String)Window.res.getObject("lb_recName"));
			jLabel20.setBounds(10, 140, 77, 20);
			
			jLabel13.setText((String)Window.res.getObject("lb_payment"));
			jLabel13.setBounds(10, 170, 50, 20);
			jTextField10.setBounds(70, 170, 320, 20);
			
			jLabel12.setText((String)Window.res.getObject("lb_incoterm"));
			jLabel12.setBounds(10, 200, 47, 20);
			
			jLabel22.setText((String)Window.res.getObject("lb_delivAddress"));
			jLabel22.setBounds(10, 230, 120, 20);
			
			jLabel23.setText((String)Window.res.getObject("lb_delivPostcode"));
			jLabel23.setBounds(10, 260, 120, 20);
			
			jLabel24.setText((String)Window.res.getObject("lb_delivTown"));
			jLabel24.setBounds(10, 290, 120, 20);
			
			jLabel25.setText((String)Window.res.getObject("lb_invoiceAddress"));
			jLabel25.setBounds(10, 320, 120, 20);
			jTextField21.setBounds(120, 320, 320, 20);
			
			jLabel26.setText((String)Window.res.getObject("lb_invoicePostcode"));
			jLabel26.setBounds(10, 350, 120, 20);
			
			jCheckBox7.setText((String)Window.res.getObject("cb_sameAddress"));
			jCheckBox7.setBounds(460, 350, 110, 20);
			
			jLabel27.setText((String)Window.res.getObject("lb_invoiceTown"));
			jLabel27.setBounds(10, 380, 120, 20);

			jLabel14.setText((String)Window.res.getObject("lb_firstName"));
			jLabel14.setBounds(20, 420, 60, 20);
			
			jLabel15.setText((String)Window.res.getObject("lb_tel"));
			jLabel15.setBounds(40, 480, 18, 20);
			
			jLabel16.setText((String)Window.res.getObject("lb_lastName"));
			jLabel16.setBounds(35, 450, 60, 20);
			
			jLabel17.setText((String)Window.res.getObject("lb_fax"));
			jLabel17.setBounds(40, 510, 22, 20);
			
			jLabel18.setText((String)Window.res.getObject("lb_mail"));
			jLabel18.setBounds(40, 540, 28, 20);
			
			jLabel28.setText((String)Window.res.getObject("lb_comment"));
			jLabel28.setBounds(10, 570, 70, 20);
			jTextArea1.setBounds(85, 570, 280, 100);
			
			jCheckBox3.setText((String)Window.res.getObject("cb_userData"));
			jCheckBox3.setBounds(310, 470, 150, 23);
			
			jButton1.setText((String)Window.res.getObject("bt_print"));
			jButton1.setBounds(360, 530, 85, 23);
		}
		
		//Reference
		jLayeredPane1.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField17.setBounds(270, 65, 100, 20);
		jTextField17.setText(Window.referencequot);
		jLayeredPane1.add(jTextField17, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Date
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField1.setBounds(70, 20, 70, 20);
		jTextField1.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		Window.date=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//From
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField2.setBounds(70, 50, 120, 20);
		jTextField2.setText(Window.from);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//To
		jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField3.setBounds(70, 80, 120, 20);
		jTextField3.setText(Window.to);
		jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Object
		jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField8.setBounds(70, 110, 330, 20);
		jTextField8.setText(Window.object);
		jLayeredPane1.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Recipient Name
		jLayeredPane1.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField9.setBounds(90, 140, 190, 20);
		jTextField9.setText(Window.recipientname);
		jLayeredPane1.add(jTextField9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox2.setText("Mr");
		jCheckBox2.setSelected(true);
		jCheckBox2.setBounds(300, 140, 37, 23);
		jLayeredPane1.add(jCheckBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}

			private void jCheckBox2ActionPerformed(ActionEvent evt) {
				if(jCheckBox2.isSelected()){
					jCheckBox1.setSelected(false);
					jCheckBox6.setSelected(false);
				}
			}
		});

		jCheckBox1.setText("Mrs");
		jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox1.setBounds(350, 140, 43, 23);
		jLayeredPane1.add(jCheckBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if(jCheckBox1.isSelected()){
					jCheckBox6.setSelected(false);
					jCheckBox2.setSelected(false);
				}
			}
		});

		jCheckBox6.setText("no");
		jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox6.setBounds(400, 140, 43, 23);
		jLayeredPane1.add(jCheckBox6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if(jCheckBox6.isSelected()){
					jCheckBox1.setSelected(false);
					jCheckBox2.setSelected(false);
				}
			}
		});
		
		jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox4.setText("dd/mm/yyyy");
		jCheckBox4.setSelected(true);
		jCheckBox4.setBounds(160, 20, 90, 20);
		jLayeredPane1.add(jCheckBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox4ActionPerformed(evt);
			}

			private void jCheckBox4ActionPerformed(ActionEvent evt) {
				if(jCheckBox4.isSelected()){
					jCheckBox5.setSelected(false);
				}
				else{
					jCheckBox4.setSelected(true);
				}
				jTextField1.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				Window.date=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			}
		});

		jCheckBox5.setText("mm/dd/yyyy");
		jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox5.setBounds(260, 20, 100, 20);
		jLayeredPane1.add(jCheckBox5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox5ActionPerformed(evt);
			}

			private void jCheckBox5ActionPerformed(ActionEvent evt) {
				if(jCheckBox5.isSelected()){
					jCheckBox4.setSelected(false);
				}
				else{
					jCheckBox5.setSelected(true);
				}
				jTextField1.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
				Window.date=new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			}
		});
		
		//Payment
		jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField10.setText(Window.payment);
		jLayeredPane1.add(jTextField10, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Incoterm
		jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField11.setBounds(70, 200, 320, 20);
		jTextField11.setText(Window.incoterm);
		jLayeredPane1.add(jTextField11, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Delivery Address
		jLayeredPane1.add(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField18.setBounds(120, 230, 320, 20);
		jTextField18.setText(Window.deliveryaddress);
		jLayeredPane1.add(jTextField18, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//postcode
		jLayeredPane1.add(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField19.setBounds(120, 260, 320, 20);
		jTextField19.setText(Window.deliverypostcode);
		jLayeredPane1.add(jTextField19, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//Town or/and Country
		jLayeredPane1.add(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField20.setBounds(120, 290, 320, 20);
		jTextField20.setText(Window.deliverylocation);
		jLayeredPane1.add(jTextField20, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//Invoicing address
		jLayeredPane1.add(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField21.setText(Window.address);
		jLayeredPane1.add(jTextField21, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//postcode
		jLayeredPane1.add(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField22.setBounds(120, 350, 320, 20);
		jTextField22.setText(Window.postcode);
		jLayeredPane1.add(jTextField22, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//Same Address
		jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
		jLayeredPane1.add(jCheckBox7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if(jCheckBox7.isSelected()){
					Window.address=jTextField18.getText();
					Window.postcode=jTextField19.getText();
					Window.location=jTextField20.getText();
					jTextField21.setText(Window.address);
					jTextField22.setText(Window.postcode);
					jTextField23.setText(Window.location);
				}
				else{
					Window.address="";
					Window.postcode="";
					Window.location="";
					jTextField21.setText("");
					jTextField22.setText("");
					jTextField23.setText("");
				}
			}
		});
		
		//Town or/and Country
		jLayeredPane1.add(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField23.setBounds(120, 380, 320, 20);
		jTextField23.setText(Window.location);
		jLayeredPane1.add(jTextField23, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//First Name
		jLayeredPane1.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField12.setBounds(70, 420, 210, 20);
		jTextField12.setText(Window.salesman);
		jLayeredPane1.add(jTextField12, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Tel
		jLayeredPane1.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField13.setText(Window.gsm);
		jTextField13.setBounds(70, 450, 210, 20);
		jLayeredPane1.add(jTextField13, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Last name
		jLayeredPane1.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField14.setText(Window.tel);
		jTextField14.setBounds(70, 480, 210, 20);
		jLayeredPane1.add(jTextField14, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Fax
		jLayeredPane1.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField15.setBounds(70, 510, 210, 20);
		jTextField15.setText(Window.fax);
		jLayeredPane1.add(jTextField15, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//mail
		jLayeredPane1.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField16.setBounds(70, 540, 210, 20);
		jTextField16.setText(Window.email);
		jLayeredPane1.add(jTextField16, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jLayeredPane1.add(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextArea1.setLineWrap(true);
		jLayeredPane1.add(jTextArea1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//user data
		jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
		jLayeredPane1.add(jCheckBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jCheckBox3ActionPerformed(evt);
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

			private void jCheckBox3ActionPerformed(ActionEvent evt) throws IndexOutOfBoundsException, BiffException, IOException {
				if(jCheckBox3.isSelected()){
					WorkbookSettings ws=new WorkbookSettings();
					ws.setSuppressWarnings(true);
					Sheet sheet=Workbook.getWorkbook(new File("comercialdata.info"),ws).getSheet(0);
					Window.salesman=sheet.getCell(1,0).getContents();
					Window.gsm=sheet.getCell(1,1).getContents();
					Window.tel=sheet.getCell(1,2).getContents();
					Window.fax=sheet.getCell(1,3).getContents();
					Window.email=sheet.getCell(1,4).getContents();
					jTextField12.setEditable(false);
					jTextField12.setText(Window.salesman);
					jTextField13.setEditable(false);
					jTextField13.setText(Window.gsm);
					jTextField14.setEditable(false);
					jTextField14.setText(Window.tel);
					jTextField15.setEditable(false);
					jTextField15.setText(Window.fax);
					jTextField16.setEditable(false);
					jTextField16.setText(Window.email);
				}
				else{
					Window.salesman="";
					Window.gsm="";
					Window.tel="";
					Window.fax="";
					Window.email="";
					jTextField12.setEditable(true);
					jTextField12.setText(Window.salesman);
					jTextField13.setEditable(true);
					jTextField13.setText(Window.gsm);
					jTextField14.setEditable(true);
					jTextField14.setText(Window.tel);
					jTextField15.setEditable(true);
					jTextField15.setText(Window.fax);
					jTextField16.setEditable(true);
					jTextField16.setText(Window.email);
				}
			}
		});

		//Button Print
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				try {
					jButton1ActionPerformed(evt);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
		);
		
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
		);
		
		this.getContentPane().setBackground(new Color(255, 255, 255));

		FocusListener focuslistener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent e) {

				if(e.getSource().equals(jTextField1))
				{
					Window.date=jTextField1.getText();
				}
				if(e.getSource().equals(jTextField2))
				{
					Window.from=jTextField2.getText();
				}
				if(e.getSource().equals(jTextField3))
				{
					Window.to=jTextField3.getText();
				}
				if(e.getSource().equals(jTextField8))
				{
					Window.object=jTextField8.getText();
				}
				if(e.getSource().equals(jTextField9))
				{
					Window.recipientname=jTextField9.getText();
				}
				if(e.getSource().equals(jTextField10))
				{
					Window.payment=jTextField10.getText();
				}
				if(e.getSource().equals(jTextField11))
				{
					Window.incoterm=jTextField11.getText();
				}
				if(e.getSource().equals(jTextField12))
				{
					Window.salesman=jTextField12.getText();
				}
				if(e.getSource().equals(jTextField13))
				{
					Window.gsm=jTextField13.getText();
				}
				if(e.getSource().equals(jTextField14))
				{
					Window.tel=jTextField14.getText();
				}
				if(e.getSource().equals(jTextField15))
				{
					Window.fax=jTextField15.getText();
				}
				if(e.getSource().equals(jTextField16))
				{
					Window.email=jTextField16.getText();
				}
				if(e.getSource().equals(jTextField17))
				{
					Window.referencequot=jTextField17.getText();
				}
				if(e.getSource().equals(jTextField18))
				{
					Window.deliveryaddress=jTextField18.getText();
				}
				if(e.getSource().equals(jTextField19))
				{
					Window.deliverypostcode=jTextField19.getText();
				}
				if(e.getSource().equals(jTextField20))
				{
					Window.deliverylocation=jTextField20.getText();
				}
				if(e.getSource().equals(jTextField21))
				{
					Window.address=jTextField21.getText();
				}
				if(e.getSource().equals(jTextField22))
				{
					Window.postcode=jTextField22.getText();
				}
				if(e.getSource().equals(jTextField23))
				{
					Window.location=jTextField23.getText();
				}
			}
		};
		
		jTextField1.addFocusListener(focuslistener);
		jTextField2.addFocusListener(focuslistener);
		jTextField3.addFocusListener(focuslistener);
		jTextField8.addFocusListener(focuslistener);
		jTextField9.addFocusListener(focuslistener);
		jTextField10.addFocusListener(focuslistener);
		jTextField11.addFocusListener(focuslistener);
		jTextField12.addFocusListener(focuslistener);
		jTextField13.addFocusListener(focuslistener);
		jTextField14.addFocusListener(focuslistener);
		jTextField15.addFocusListener(focuslistener);
		jTextField16.addFocusListener(focuslistener);
		jTextField17.addFocusListener(focuslistener);
		jTextField18.addFocusListener(focuslistener);
		jTextField19.addFocusListener(focuslistener);
		jTextField20.addFocusListener(focuslistener);
		jTextField21.addFocusListener(focuslistener);
		jTextField22.addFocusListener(focuslistener);
		jTextField23.addFocusListener(focuslistener);

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}

			private void jTextField1ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.date=jTextField1.getText();
			}
		});
		
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}

			private void jTextField2ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.from=jTextField2.getText();
			}
		});
		
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}

			private void jTextField3ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.to=jTextField3.getText();
			}
		});
		
		jTextField8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField8ActionPerformed(evt);
			}

			private void jTextField8ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.object=jTextField8.getText();
			}
		});

		jTextField10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField10ActionPerformed(evt);
			}

			private void jTextField10ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.payment=jTextField10.getText();
			}
		});
		
		jTextField11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField11ActionPerformed(evt);
			}

			private void jTextField11ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.incoterm=jTextField11.getText();
			}
		});

		jTextField12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField12ActionPerformed(evt);
			}

			private void jTextField12ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.salesman=jTextField12.getText();
			}
		});
		
		jTextField13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField13ActionPerformed(evt);
			}

			private void jTextField13ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.gsm=jTextField13.getText();
			}
		});
		
		jTextField14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField14ActionPerformed(evt);
			}

			private void jTextField14ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.tel=jTextField14.getText();
			}
		});
		
		jTextField15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField15ActionPerformed(evt);
			}

			private void jTextField15ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.fax=jTextField15.getText();
			}
		});
		
		jTextField16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField16ActionPerformed(evt);
			}

			private void jTextField16ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.email=jTextField16.getText();
			}
		});
		
		jTextField17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField17ActionPerformed(evt);
			}

			private void jTextField17ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.referencequot=jTextField17.getText();
			}
		});
	}	

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws DocumentException, IOException {

		try{

			JFileChooser chooser = new JFileChooser(Window.parents){
				
				private static final long serialVersionUID = 1L;

				@Override
				public void approveSelection(){
					File f = null;
					
					if(getSelectedFile().getAbsolutePath().endsWith(".pdf"))
						f = new File(getSelectedFile().getAbsolutePath());
					else 
						f = new File(getSelectedFile().getAbsolutePath()+".pdf");

					if(f.exists()){
						Window.parents=f.getParent();
						int answer = JOptionPane.showConfirmDialog(
								this, f + " exists. Overwrite?", "Overwrite?",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
						);
						
						if (answer != JOptionPane.OK_OPTION)
						{
							return;
						}
					}
					super.approveSelection();
				}
			};
			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier PDF (.pdf)","pdf");
			chooser.setFileFilter(filter);
			chooser.setSelectedFile(new File("quotation "+new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			
			int returnVal=chooser.showSaveDialog(null);
			
			if(returnVal==JFileChooser.APPROVE_OPTION)
			{
				this.dispose();
							
				Document document = new Document(PageSize.A4);//PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("quotation.pdf"));

				document.open();

				PdfPTable table2 = new PdfPTable(1);
				PdfPCell c = new PdfPCell(Image.getInstance("logo.png"), false);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setBorder(Rectangle.NO_BORDER);

				table2.addCell(c);

				c = new PdfPCell(new Phrase(Window.companyname+" : "+Window.companyaddress+" – "+Window.companypostcode+" "+Window.companytown+" – "+Window.companycountry, new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(Rectangle.NO_BORDER);
				table2.addCell(c);

				c = new PdfPCell(new Phrase("Tel : "+Window.conpanytel+" – Fax : "+Window.conpanyfax+" – Email: "+Window.conpanyemail, new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(Rectangle.NO_BORDER);
				table2.addCell(c);

				c = new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.NO_BORDER);
				c.setFixedHeight(c.getFixedHeight()+30);
				table2.addCell(c);

				document.add(table2);
				document.add(createTable(document));

				document.close();

				PdfReader reader = new PdfReader("quotation.pdf");

				Document document2 = new Document();
				PdfWriter writer2=PdfWriter.getInstance(document2, new FileOutputStream("text.pdf"));
				document2.open();
				PdfContentByte canvas = writer2.getDirectContent();
				writer2.setCompressionLevel(0);

				canvas.saveState();                               // q
				canvas.beginText();                               // BT
				canvas.moveText(280, 39);                         // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText("Page 1 of "+(reader.getNumberOfPages()+1));                   // (Hello World)Tj
				canvas.endText();                                 // ET
				canvas.restoreState();  
				
				canvas.saveState();                               // q
				Image img2=Image.getInstance("logo.png");
				img2.setAbsolutePosition(59, 680);
				img2.scalePercent(80);
				canvas.addImage(img2);                         // 36 788 Td                         // ET
				canvas.restoreState(); 
				
				
				canvas.saveState();                               // q
				canvas.beginText();                               // BT
				canvas.moveText(59, 662);                         // 36 788 Td
				canvas.setFontAndSize(FontFactory.getFont(BaseFont.HELVETICA, 10, 1).getCalculatedBaseFont(false), 8); // /F1 12 Tf
				canvas.showText(Window.companyname);                   // (Hello World)Tj
				canvas.endText();                                 // ET
				canvas.restoreState();  
				
				canvas.saveState();                               // q
				canvas.beginText();                               // BT
				canvas.moveText(59, 650);                         // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText(Window.companyaddress);                   // (Hello World)Tj
				canvas.endText();                                 // ET
				canvas.restoreState();  
				
				canvas.saveState();                               // q
				canvas.beginText();                               // BT
				canvas.moveText(59, 638);                         // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText(Window.companypostcode+" "+Window.companytown+" - "+Window.companycountry);                   // (Hello World)Tj
				canvas.endText();                                 // ET
				canvas.restoreState(); 

				canvas.saveState();                               // q
				canvas.beginText();                               // BT
				canvas.moveText(167, 68);                         // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText("Tel: "+Window.conpanytel+" - Fax: "+Window.conpanyfax+" - Email: "+Window.conpanyemail);                   // (Hello World)Tj
				canvas.endText();                                 // ET
				canvas.restoreState(); 
				
				canvas.saveState();                               // q
				canvas.beginText();                               // BT
				canvas.moveText(80, 58); 							// 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText(Window.conpanycomment);           // (Hello World)Tj
				canvas.endText();                                 // ET
				canvas.restoreState();
				
				BaseFont font = FontFactory.getFont(BaseFont.HELVETICA, 10, 1).getCalculatedBaseFont(false);// 36 788 Td

				/************************************ ANGLAIS ******************************/
				if(Window.locale.toString().equals("en")){
					// REFERENCE
					if(!Window.referencequot.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(375, 695);                         // 36 788 Td
						canvas.setFontAndSize(font, 10); // /F1 12 Tf
						canvas.showText("Reference :");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 

						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(436, 695);                         // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText(Window.referencequot);                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState();  
					}
					// DELIVERY ADDRESS
					if(!Window.deliveryaddress.isEmpty() && !Window.deliverypostcode.isEmpty() && !Window.deliverylocation.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(375, 637);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Delivery address:");
						canvas.endText();
						canvas.restoreState(); 
						/*
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(460, 637);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliverypostcode + " " + Window.deliverylocation);
						canvas.endText();
						canvas.restoreState(); 
						*/						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 611);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliverypostcode + " " + Window.deliverylocation);
						canvas.endText();
						canvas.restoreState(); 
					}
					// INVOICING ADDRESS
					if(!Window.address.isEmpty() && !Window.postcode.isEmpty() && !Window.location.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 598);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Invoicing address:");
						canvas.endText();
						canvas.restoreState(); 
						/*
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(465, 598);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode+" "+Window.location);
						canvas.endText();
						canvas.restoreState(); 
						*/
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 572);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode+" "+Window.location);
						canvas.endText();
						canvas.restoreState(); 
					}
					// DE / FROM 
					if(!Window.from.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 663);  
						canvas.setFontAndSize(font, 10);
						canvas.showText("From:");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(410, 663);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.from);
						canvas.endText();
						canvas.restoreState(); 
					}
					// A / TO 
					if(!Window.to.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 650);
						canvas.setFontAndSize(font, 10);
						canvas.showText("To:");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(395, 650); 
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.to);
						canvas.endText();
						canvas.restoreState(); 
					}
					// Subject 
					if(!Window.object.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 588); 
						canvas.setFontAndSize(font, 10);
						canvas.showText("Subject: ");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(100, 588); 
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.object);                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}

					// PAYMENT
					if(!Window.payment.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(59, 341);                         // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText("Payment:");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 

						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(103, 341);                         // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText(Window.payment);                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}

					canvas.saveState();                               // q
					canvas.beginText();                               // BT
					canvas.moveText(59, 304);                         // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
					canvas.showText("- Delivery terms: 3/4 weeks from the date we receive the order");                   // (Hello World)Tj
					canvas.endText();                                 // ET
					canvas.restoreState(); 

					canvas.saveState();                               // q
					canvas.beginText();                               // BT
					canvas.moveText(59, 291);                         // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
					canvas.showText("- Validity offer: 2 months");                   // (Hello World)Tj
					canvas.endText();                                 // ET
					canvas.restoreState(); 

					/* INCOTERM */
					if(!Window.incoterm.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(59, 328);                         // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText("Incoterm:");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 

						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(103, 328);                         // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText(Window.incoterm);                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}
				}
				/*********************************** ITALIEN **********************************/
				else if(Window.locale.toString().equals("it")){
					// Riferimento
					if(!Window.referencequot.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 695);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Riferimento :");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(440, 695);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.referencequot);
						canvas.endText();
						canvas.restoreState();  
					} 
					// Indirizzo di consegna
					if(!Window.deliveryaddress.isEmpty() && !Window.deliverypostcode.isEmpty() && !Window.deliverylocation.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(375, 637);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Indirizzo di consegna:");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 611);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliverypostcode + " " + Window.deliverylocation);
						canvas.endText();
						canvas.restoreState(); 
					}
					// Indirizzo di fatturazione
					if(!Window.address.isEmpty() && !Window.postcode.isEmpty() && !Window.location.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 598);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Indirizzo di fatturazione:");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 572);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode+" "+Window.location);
						canvas.endText();
						canvas.restoreState(); 
					}
					// DA  
					if(!Window.from.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 663);  
						canvas.setFontAndSize(font, 10);
						canvas.showText("Da :");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(398, 663);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.from);
						canvas.endText();
						canvas.restoreState(); 
					}
					// A 
					if(!Window.to.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 650);
						canvas.setFontAndSize(font, 10);
						canvas.showText("A :");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(393, 650); 
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.to);
						canvas.endText();
						canvas.restoreState(); 
					}
					// Soggetto
					if(!Window.object.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 588); 
						canvas.setFontAndSize(font, 10);
						canvas.showText("Soggetto : ");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(113, 588); 
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.object);
						canvas.endText();
						canvas.restoreState(); 
					}
					// PAYMENT
					if(!Window.payment.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 341);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Pagamento: " + Window.payment);
						canvas.endText();
						canvas.restoreState(); 
					}

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 304);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Termini di consegna: 3/4 settimane dalla data  ricezione ordine");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 291);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Validità dell'offerta: 2 mesi");
					canvas.endText();
					canvas.restoreState(); 

					/* INCOTERM */
					if(!Window.incoterm.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 328);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Incoterm: " + Window.incoterm);
						canvas.endText();
						canvas.restoreState(); 
					}
				}
				/******************************** FRANCAIS *********************************/
				else if(Window.locale.toString().equals("fr")){
					// REFERENCE
					if(!Window.referencequot.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 695);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Référence :");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(436, 695);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.referencequot);
						canvas.endText();
						canvas.restoreState();  
					}
					// Adresse de livraison
					if(!Window.deliveryaddress.isEmpty() && !Window.deliverypostcode.isEmpty() && !Window.deliverylocation.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(375, 637);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Adresse de livraison:");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 611);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.deliverypostcode + " " + Window.deliverylocation);
						canvas.endText();
						canvas.restoreState(); 
					}
					// Adresse de facturation
					if(!Window.address.isEmpty() && !Window.postcode.isEmpty() && !Window.location.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 598);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Adresse de facturation:");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 572);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode+" "+Window.location);
						canvas.endText();
						canvas.restoreState(); 
					}
					// DE 
					if(!Window.from.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 663);  
						canvas.setFontAndSize(font, 10);
						canvas.showText("De :");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(398, 663);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.from);
						canvas.endText();
						canvas.restoreState(); 
					}
					// A 
					if(!Window.to.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 650);
						canvas.setFontAndSize(font, 10);
						canvas.showText("A :");
						canvas.endText();
						canvas.restoreState(); 

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(393, 650); 
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.to);
						canvas.endText();
						canvas.restoreState(); 
					}
					// Odre d'achat
					if(!Window.object.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 588); 
						canvas.setFontAndSize(font, 10);
						canvas.showText("Objet : ");
						canvas.endText();
						canvas.restoreState(); 
						
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(95, 588); 
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.object);
						canvas.endText();
						canvas.restoreState(); 
					}
					
					// PAYMENT
					if(!Window.payment.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 341);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Paiement : " + Window.payment);
						canvas.endText();
						canvas.restoreState(); 
					}

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 304);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Conditions de livraison : 3/4 semaines à partir de la date de réception de l'ordre");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 291);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Validité de l'offre : 2 mois");
					canvas.endText();
					canvas.restoreState(); 

					/* INCOTERM */
					if(!Window.incoterm.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 328);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Incoterm : " + Window.incoterm);
						canvas.endText();
						canvas.restoreState(); 
					}
				}

				/* DATE */
				if(!Window.date.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(437, 748);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText(Window.date);
					canvas.endText();
					canvas.restoreState();  
				}

				if(Window.locale.toString().equals("en")){
					/* MR OU MS + RECIPIENT NAME */
					if(jCheckBox2.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);  
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText("Mr,");
						canvas.endText();
						canvas.restoreState(); 
					}	
					if(jCheckBox2.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText(); 
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText("Mr "+Window.recipientname+","); 
						canvas.endText(); 
						canvas.restoreState(); 
					}	
					if(jCheckBox1.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms,");
						canvas.endText();
						canvas.restoreState(); 
					}	
					if(jCheckBox1.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText("Ms "+Window.recipientname+","); 
						canvas.endText();
						canvas.restoreState(); 
					}
					if(jCheckBox6.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(","); 
						canvas.endText();
						canvas.restoreState(); 
					}	
					if(jCheckBox6.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.recipientname+",");
						canvas.endText();
						canvas.restoreState(); 
					}
				}
				else if(Window.locale.toString().equals("it")){
					/* MR OU MS + RECIPIENT NAME */
					if(jCheckBox2.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 539);  
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText("Mr,"); 
						canvas.endText(); 
						canvas.restoreState(); 
					}	
					if(jCheckBox2.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(130, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText("Mr "+Window.recipientname+",");
						canvas.endText();
						canvas.restoreState(); 
					}	
					if(jCheckBox1.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(130, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms,"); 
						canvas.endText();
						canvas.restoreState(); 
					}	
					if(jCheckBox1.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms "+Window.recipientname+",");
						canvas.endText(); 
						canvas.restoreState(); 
					}
					if(jCheckBox6.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(",");
						canvas.endText();
						canvas.restoreState(); 
					}	
					if(jCheckBox6.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState(); 
						canvas.beginText();
						canvas.moveText(130, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); 
						canvas.showText(Window.recipientname+","); 
						canvas.endText();
						canvas.restoreState(); 
					}
				}
				else if(Window.locale.toString().equals("fr")){
					/* MR OU MS + RECIPIENT NAME */
					if(jCheckBox2.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(84, 539);  
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText("Mr,");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}	
					if(jCheckBox2.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText("Mr "+Window.recipientname+",");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}	
					if(jCheckBox1.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText("Ms,");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}	
					if(jCheckBox1.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText("Ms "+Window.recipientname+",");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}
					if(jCheckBox6.isSelected()&& Window.recipientname.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText(",");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}	
					if(jCheckBox6.isSelected()&& !Window.recipientname.isEmpty()){
						canvas.saveState();                               // q
						canvas.beginText();                               // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
						canvas.showText(Window.recipientname+",");                   // (Hello World)Tj
						canvas.endText();                                 // ET
						canvas.restoreState(); 
					}
				}
				
				/* NOM + PRENOM USER */
				if(!Window.salesman.isEmpty()){
					canvas.saveState();                               // q
					canvas.beginText();                               // BT
					canvas.moveText(59, 168);                         // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
					canvas.showText(Window.salesman+" "+Window.gsm);                   // (Hello World)Tj
					canvas.endText();                                 // ET
					canvas.restoreState(); 
				}
				/* TEL USER */
				if(!Window.tel.isEmpty()){
					canvas.saveState();                             
					canvas.beginText();                             
					canvas.moveText(59, 156);                         
					canvas.setFontAndSize(BaseFont.createFont(), 10); 
					canvas.showText("Tel: "+Window.tel);                   
					canvas.endText();                                 
					canvas.restoreState(); 
				}
				/* FAX */
				if(!Window.fax.isEmpty()){
					canvas.saveState();                               // q
					canvas.beginText();                               // BT
					canvas.moveText(59, 144);                         // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12 Tf
					canvas.showText("Fax: "+Window.fax);                   // (Hello World)Tj
					canvas.endText();                                 // ET
					canvas.restoreState(); 
				}
				/* MAIL */
				if(!Window.email.isEmpty()){
					BaseFont font1 = FontFactory.getFont(BaseFont.HELVETICA, 10, BaseColor.BLUE).getCalculatedBaseFont(true);
					canvas.saveState();                               // q
					canvas.beginText();                               // BT
					canvas.moveText(59, 131);                         // 36 788 Td
					canvas.setFontAndSize(font1, 10); // /F1 12 Tf
					canvas.showText("Email: "+Window.email);                   // (Hello World)Tj
					canvas.endText();                                 // ET
					canvas.restoreState(); 
				}
				document2.close();

				//PdfReader reader1 = new PdfReader("quotationform.pdf");
				PdfReader reader1 = null;
				
				if(Window.locale.toString().equals("en")){
					System.out.println("en");
					reader1 = new PdfReader("quotationform.pdf");
				}
				else if(Window.locale.toString().equals("it")){
					System.out.println("it");
					reader1 = new PdfReader("quotationformIT.pdf");
				}
				else if(Window.locale.toString().equals("fr")){
					System.out.println("fr");
					reader1 = new PdfReader("quotationformFR.pdf");
				}

				Document document4 = new Document();
				PdfCopy copy = new PdfCopy(document4, new FileOutputStream("quotationfinal.pdf"));

				document4.open();
				PdfImportedPage page1=copy.getImportedPage(reader1, 1);
				copy.addPage(page1);
				
				PdfReader reader2 = new PdfReader("text.pdf");
				PdfImportedPage page2=copy.getImportedPage(reader2, 1);
				copy.addPage(page2);

				copy.close();   
				document4.close();

				PdfReader reader5 = new PdfReader("quotationfinal.pdf");

				Document document6 = new Document(PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer6=PdfWriter.getInstance(document6, new FileOutputStream("quotation2.pdf"));
				Footer event1=new Footer();
				writer6.setBoxSize("art", new Rectangle(36, 54, 559, 788));
				writer6.setPageEvent(event1);
				event1.settotal(reader.getNumberOfPages()+1);
				document6.open();
				
				for(int i=1;i<=reader.getNumberOfPages();i++){
					document6.newPage();
					writer6.setPageEmpty(false);
				}

				document6.close();
				PdfReader reader6 = new PdfReader("quotation2.pdf");

				Document document7 = new Document();
				PdfWriter writer7=PdfWriter.getInstance(document7, new FileOutputStream("quotation3.pdf"));

				document7.open();

				PdfContentByte canvas3 = writer7.getDirectContent();

				for(int j=1;j<=reader.getNumberOfPages();j++){
					page1=writer7.getImportedPage(reader, j);
					canvas3.addTemplate(page1, 1f, 0, 0, 1, 0, 0);
					page2=writer7.getImportedPage(reader6, j);
					canvas3.addTemplate(page2, 1f, 0, 0, 1, 0, 0);
					document7.newPage();
				}

				document7.close();

				reader = new PdfReader("quotation3.pdf");

				Document document3 = new Document(PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer3=PdfWriter.getInstance(document3, new FileOutputStream("quotationfinal1.pdf"));

				document3.open();

				PdfContentByte canvas2 = writer3.getDirectContent();
				PdfImportedPage page;

				for (int i = 1; i <= reader5.getNumberOfPages(); i++) {
					page = writer3.getImportedPage(reader5, i);
					canvas2.addTemplate(page, 1f, 0, 0, 1, 0, 0);
				}

				document3.close();

				PdfReader reader3 = new PdfReader("quotationfinal1.pdf");

				Document document1 = new Document();
				if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf")){
					copy = new PdfCopy(document1, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()));
				}
				else {
					copy = new PdfCopy(document1, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()+".pdf"));
				}
				
				document1.open();

				page1=copy.getImportedPage(reader3, 1);
				copy.addPage(page1);

				for(int i=1;i<=reader.getNumberOfPages();i++){
					page2=copy.getImportedPage(reader, i);
					copy.addPage(page2);
				}

				copy.close();

				document1.close();

				File file = new File("quotationfinal1.pdf"); 
				file.delete();
				file = new File("quotation.pdf"); 
				file.delete();
				file = new File("quotationfinal.pdf"); 
				file.delete();
				file = new File("text.pdf"); 
				file.delete();
				file = new File("quotation2.pdf"); 
				file.delete();
				file = new File("quotation3.pdf"); 
				file.delete();
				file = new File("quotationform2.pdf"); 			
				file.delete();
				WritableSheet sheet;
		        Workbook workbook;
		        WritableWorkbook wwork;
		        WritableCell cell;
		        
		        try {
		        	if(!new File("./Summary offers.xls").exists()){
		            		
		        		WritableWorkbook wworkbook;
		    				
		        		wworkbook = Workbook.createWorkbook(new File("./Summary offers.xls"));
		    					
		        		WritableSheet wsheet = wworkbook.createSheet("Savedata", 0);
		        		WritableFont titrefont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD); 
		        		
		        		wsheet.setColumnView(0, 20);
		    		
		    			wsheet.setColumnView(1, 40);
		    			wsheet.setColumnView(2, 30);
		    			wsheet.setColumnView(3, 40);
		    			wsheet.setColumnView(4, 30);
		    			wsheet.setColumnView(5, 50);
		    			wsheet.setColumnView(6, 25);
		    			wsheet.setColumnView(7, 25);
		    				
		    			WritableCellFormat format = new WritableCellFormat (titrefont);
		    			format.setBackground(Colour.WHITE);
		    			format.setAlignment(Alignment.CENTRE);
		    			format.setVerticalAlignment(VerticalAlignment.CENTRE);
		    			format.setOrientation(Orientation.HORIZONTAL);
		    			format.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK);
		    			format.setShrinkToFit(true);
		    			format.setWrap(true);
		    				
		    			Label label = new Label(0,0, "DATE", format); 
		    			wsheet.addCell(label);
						label = new Label(1,0, "REFERENCE", format); 
						wsheet.addCell(label);
						label = new Label(2,0, "FROM", format); 
						wsheet.addCell(label);
						label = new Label(3,0, "CUSTOMER", format); 
						wsheet.addCell(label);
						label = new Label(4,0, "NAME", format); 
						wsheet.addCell(label);
						label = new Label(5,0, "BUISNESS NAME", format); 
						wsheet.addCell(label);
						label = new Label(6,0, "PURCHASE PRICE", format); 
						wsheet.addCell(label);
						label = new Label(7,0, "QUOTATION PRICE", format); 
						wsheet.addCell(label);
						
						wworkbook.write(); 
						wworkbook.close(); 	
							
						System.out.println("Creation de ./Summary offers.xls");
		            }
		            	
		        	workbook = Workbook.getWorkbook(new File("./Summary offers.xls"));
		        	wwork = Workbook.createWorkbook(new File("./Summary offers.xls"), workbook);
		        	
		        	sheet = wwork.getSheet(0);
		        	
		            Window.df.setMaximumFractionDigits(2);
		            Window.df.setMinimumFractionDigits(2);
		            exist=false;
		            
		            for(int k=0;k<=sheet.getRows()-1;k++){
		            	if(sheet.getCell(0, k).getContents().equals(Window.date) && sheet.getCell(1, k).getContents().equals(Window.referencequot) && sheet.getCell(2, k).getContents().equals(Window.from) && sheet.getCell(3, k).getContents().equals(Window.to) && sheet.getCell(4, k).getContents().equals(Window.salesman+" "+Window.gsm)&&sheet.getCell(5, k).getContents().equals(Window.object) &&sheet.getCell(6, k).getContents().equals(Window.df.format(Window.buyprice))&&sheet.getCell(7, k).getContents().equals(Window.df.format(Window.quotationprice)))
		            		exist=true;
		            }
		            
		            if(!exist){
		            	Label label = null;
		            	int row=sheet.getRows();
		                
		                for(int i=0;i<=7;i++){
		                	cell = sheet.getWritableCell(i, sheet.getRows());
		                
		                	if(i==0)
		                		label = new Label(i, row, Window.date);
		                	
		                	if(i==1)
				                label = new Label(i, row, Window.referencequot);
		                	
		                	if(i==2)
				                label = new Label(i, row, Window.from);
		                	
		                	if(i==3)
				                label = new Label(i, row, Window.to);
		                	
		                	if(i==4)
				                label = new Label(i, row, Window.salesman+" "+Window.gsm);
		                	
		                	if(i==5)
				                label = new Label(i, row, Window.object);
		                	
		                	if(i==6)
				                label = new Label(i, row, Window.df.format(Window.buyprice));
		                	
		                	if(i==7)
				                label = new Label(i, row, Window.df.format(Window.quotationprice));
			                
		                	sheet.addCell(label); 
		                }
		            }
		            wwork.write(); 
		            wwork.close(); 
		            System.out.println("Sauvegarde quotation dans ./Summary offers.xls");
		        }
		        catch (Exception e) {
		        	System.out.println(e);
		        }

				if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf"))
					Window.printermailer=chooser.getSelectedFile().getAbsolutePath();
				else 
					Window.printermailer=chooser.getSelectedFile().getAbsolutePath()+".pdf";

				// On vérifie que la classe Desktop soit bien supportée :				
    	    	if ( Desktop.isDesktopSupported() ) {
    	    		// On récupère l'instance du desktop :
    	    		Desktop desktop = Desktop.getDesktop();

    	    		// On vérifie que la fonction open est bien supportée :
    	    		if (desktop.isSupported(Desktop.Action.OPEN)) {
    	    			System.out.println(Window.printermailer);
    	    			// Et on lance l'application associé au fichier pour l'ouvrir :
    	    			desktop.open(new File(Window.printermailer).getAbsoluteFile());
    	    		}    	    			
    	    	}
			}
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,"The file has been saved in "+Window.printermailer);
		}
	}
	
	public static PdfPTable createTable(Document document) throws DocumentException, MalformedURLException, IOException {
		
		PdfPTable table = null;
		PdfPTable table2 = null;

		table= new PdfPTable(6);
		table.setWidths(new float[]{(float)1,(float)1.6,(float) 6,(float)0.7,(float) 1.6,(float) 1.4});
		table.setWidthPercentage(100f);

		table2 = new PdfPTable(6);
		table2.setWidths(new float[]{(float)1,(float)1.6,(float) 6,(float)0.7,(float) 1.4,(float) 1.4});
		table2.setWidthPercentage(101f);
		
		PdfPCell cell = new PdfPCell();
		addHeader(table, cell);

		for(int i=0;i<=Window.reference.size()-1;i++){
			
			// Si Reference + index VIDES et description non VIDE
			if(Window.reference.get(i).isEmpty()&&Window.index.get(i).toString().isEmpty()&&!Window.description.get(i).toString().isEmpty()){
					
				cell = new PdfPCell(new Phrase(Window.description.get(i), new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setBackgroundColor(BaseColor.CYAN);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(6);

				table.addCell(cell);
			}
			
			// Si Reference VIDE et Index non VIDE
			else if(Window.reference.get(i).isEmpty()&& !Window.index.get(i).toString().isEmpty()){
				cell = new PdfPCell(new Phrase(Window.index.get(i).toString(), new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

				table.addCell(cell);
				cell = new PdfPCell(new Phrase(Window.description.get(i), new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(6);

				table.addCell(cell);
			}
			
			// Si Reference + Index + Description VIDES
			else if(Window.reference.get(i).isEmpty()&&Window.index.get(i).toString().isEmpty()&&Window.description.get(i).toString().isEmpty()){
				document.add(table);
				
				table = new PdfPTable(6);
				table.setWidths(new float[]{(float)1,(float)1.6,(float) 6,(float)0.7,(float) 1.4,(float) 1.4});
				table.setWidthPercentage(100f);
				addHeader(table, cell);
				System.out.println("Reference + Index + Description vides");
			}
			else{				
				cell = new PdfPCell(new Phrase(Window.index.get(i).toString(), new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.reference.get(i), new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.description.get(i), new Font(FontFamily.HELVETICA, 7, Font.NORMAL)));
				table.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.quantity.get(i), new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				
				// Affichage normal
				if(!Window.printDiscount){
					Phrase phrase = new Phrase(
						Window.price.get(i)+" €", new Font(FontFamily.HELVETICA, 8, Font.NORMAL)
					);
					cell = new PdfPCell(phrase);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				}
				// Affichage avec le discount
				else if(Window.printDiscount){
					Phrase phrase = new Phrase(
						Window.price.get(i) + " €" + "\n" + "  (" + Window.discountprod.get(i) + "%)" , 
						new Font(FontFamily.HELVETICA, 8, Font.NORMAL)
					);
					cell = 	new PdfPCell(phrase);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				}
				
				cell = new PdfPCell(new Phrase(Window.totalyprice.get(i)+" €", new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
			}
		}
	
		if(!Window.refund){
			if(!Window.transport){
				cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			}
			else{
				cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TRANSPORT COST", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.df.format(Window.transportval).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
				
				cell = new PdfPCell(new Phrase("TOTAL in EUROS with transport", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.YELLOW);
				cell.setColspan(5);
				table2.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice+Window.transportval).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			}
		}
		else{
			if(!Window.transport){
				cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("SPECIAL DISCOUNT ("+Window.discount+"%)", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice*Window.discount/100).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TOTAL with SPECIAL DISCOUNT", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice-Window.quotationprice*Window.discount/100).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			}
			else{

				cell = new PdfPCell(new Phrase("TOTAL in EUROS without transport", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("SPECIAL DISCOUNT ("+Window.discount+"%)", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice*Window.discount/100).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TOTAL with SPECIAL DISCOUNT", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(Window.quotationprice-Window.quotationprice*Window.discount/100).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TRANSPORT COST", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.YELLOW);
				cell.setColspan(5);
				table2.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.df.format(Window.transportval).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
				
				cell = new PdfPCell(new Phrase("TOTAL in EUROS with transport", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.YELLOW);
				cell.setColspan(5);
				table2.addCell(cell);
				
				cell = new PdfPCell(new Phrase(Window.df.format((Window.quotationprice-Window.quotationprice*Window.discount/100)+Window.transportval).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			}
		}
		if(Window.assistance!=0){
			cell = new PdfPCell(new Phrase("START-UP COST", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.YELLOW);
			cell.setColspan(5);
			table2.addCell(cell);
			
			cell = new PdfPCell(new Phrase(Window.df.format(Window.assistance).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table2.addCell(cell);
			
			cell = new PdfPCell(new Phrase("TOTAL in EUROS with start-up", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.YELLOW);
			cell.setColspan(5);
			table2.addCell(cell);
			
			cell = new PdfPCell(new Phrase(Window.df.format((Window.quotationprice-Window.quotationprice*Window.discount/100)+Window.transportval+Window.assistance).replaceAll(","," ")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table2.addCell(cell);
		}

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(30f);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Order confirmation : ", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(3);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Date : ", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(20f);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Name : ", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(20f);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Signature : ", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(50f);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Please send it back by mail ("+Window.conpanyemail+") or by fax ("+Window.conpanyfax+")", new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		cell.setColspan(6);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);
		
		cell=new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.setTotalWidth(table.getTotalWidth()+cell.getBorderWidth());
		table.setExtendLastRow(true);
		cell.addElement(table2);
		table.addCell(cell);
		
		if(!jTextArea1.getText().contentEquals("")){
			cell = new PdfPCell(new Phrase("*NB:\n\n" + jTextArea1.getText(), new Font(FontFamily.HELVETICA, 10, Font.NORMAL)));
			cell.setColspan(6);
			cell.setFixedHeight(80f);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell);
		}
		return table;
	}

	private static void addHeader(PdfPTable table,PdfPCell cell) {
		cell = new PdfPCell(new Phrase("Index",new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("CODE",new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("DESCRIPTION", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Qty", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		
		if(!Window.printDiscount){
			cell = new PdfPCell(new Phrase("Unit net price in €", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
			cell.setFixedHeight(36f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setNoWrap(false);
			table.addCell(cell);
		}
		else if(Window.printDiscount){
			cell = new PdfPCell(new Phrase("Unit price\n in € \n(discount %)", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
			cell.setFixedHeight(36f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setNoWrap(false);
			table.addCell(cell);
		}
		cell = new PdfPCell(new Phrase("Total net price in €", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setNoWrap(false);
		table.addCell(cell);
		
		table.setHeaderRows(1);
	}

	private static void padding(PdfPCell cell,int n){
		try{
			cell.setPadding(n);
		}
		catch (Exception e) {
			padding(cell,n-1);
		}
	}
}