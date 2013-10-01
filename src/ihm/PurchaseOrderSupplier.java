package ihm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.VerticalAlignment;
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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PurchaseOrderSupplier extends JDialog {

	private static String OUTPUTFILE = "purchasefinal.pdf";
	
	private javax.swing.JTextField umorder;
	private javax.swing.JCheckBox cb_excel;
	boolean exist=false;
	
	private static File f = null;
	
	static double total=0;
	static double quotationprice=0;
	
	public PurchaseOrderSupplier() {
		super();
		build();
	}
 
	private void build(){
		JDialog fenetre = new JDialog();
		this.setVisible(true);
		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_purchase"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_purchase"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_purchase"));
		}

		this.setSize(320,240);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setContentPane(buildContentPane());
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel 	lb_numorder = null, 
				lb_commercialTerms = null, 
				lb_payment = null, 
				lb_incoterm = null, 
				lb_deliveryTerms = null;
		
		final JTextField 	numorder, 
							payment, 
							incoterm, 
							deliveryTerms;
		
		JButton bt_print = null;
		//final JCheckBox cb_excel = null;
		
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			lb_numorder = new JLabel((String)Window.res.getObject("lb_numOrder"));
			lb_numorder.setBounds(20,20,60,20);
			
			lb_commercialTerms = new JLabel((String)Window.res.getObject("lb_commercialTerms"));
			lb_commercialTerms.setBounds(20,50,200,25);
			
			lb_payment = new JLabel((String)Window.res.getObject("lb_poPayment"));
			lb_payment.setBounds(40,80,70,20);
			
			lb_incoterm = new JLabel((String)Window.res.getObject("lb_poIncoterm"));
			lb_incoterm.setBounds(40,105,70,20);
			
			lb_deliveryTerms = new JLabel((String)Window.res.getObject("lb_deliveryTerms"));
			lb_deliveryTerms.setBounds(40,130,100,20);
			
			cb_excel = new JCheckBox((String)Window.res.getObject("cb_ExcelFromat"));
			cb_excel.setBounds(20,170,100,20);
			
			bt_print = new JButton((String)Window.res.getObject("bt_print"));
			bt_print.setBounds(150, 170, 73, 23);
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			lb_numorder = new JLabel((String)Window.res.getObject("lb_numOrder"));
			lb_numorder.setBounds(20,20,60,20);
			
			lb_commercialTerms = new JLabel((String)Window.res.getObject("lb_commercialTerms"));
			lb_commercialTerms.setBounds(20,50,200,25);
			
			lb_payment = new JLabel((String)Window.res.getObject("lb_poPayment"));
			lb_payment.setBounds(40,80,70,20);
			
			lb_incoterm = new JLabel((String)Window.res.getObject("lb_poIncoterm"));
			lb_incoterm.setBounds(40,105,70,20);
			
			lb_deliveryTerms = new JLabel((String)Window.res.getObject("lb_deliveryTerms"));
			lb_deliveryTerms.setBounds(40,130,100,20);
			
			cb_excel = new JCheckBox((String)Window.res.getObject("cb_ExcelFromat"));
			cb_excel.setBounds(20,170,100,20);
			
			bt_print = new JButton((String)Window.res.getObject("bt_print"));
			bt_print.setBounds(150, 170, 83, 23);
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			lb_numorder = new JLabel((String)Window.res.getObject("lb_numOrder"));
			lb_numorder.setBounds(20,20,60,20);
			
			lb_commercialTerms = new JLabel((String)Window.res.getObject("lb_commercialTerms"));
			lb_commercialTerms.setBounds(20,50,200,25);
			
			lb_payment = new JLabel((String)Window.res.getObject("lb_poPayment"));
			lb_payment.setBounds(40,80,70,20);
			
			lb_incoterm = new JLabel((String)Window.res.getObject("lb_poIncoterm"));
			lb_incoterm.setBounds(40,105,70,20);
			
			lb_deliveryTerms = new JLabel((String)Window.res.getObject("lb_deliveryTerms"));
			lb_deliveryTerms.setBounds(40,130,100,20);
			
			cb_excel = new JCheckBox((String)Window.res.getObject("cb_ExcelFromat"));
			cb_excel.setBounds(20,170,100,20);
			
			bt_print = new JButton((String)Window.res.getObject("bt_print"));
			bt_print.setBounds(150, 170, 85, 23);
		}
		
		panel.add(lb_numorder);
		
		numorder = new JTextField(Window.POnumorder); 
		numorder.setBounds(85,20,80,20);
		panel.add(numorder);
		
		panel.add(lb_commercialTerms);
		
		panel.add(lb_payment);
		
		payment = new JTextField(); 
		payment.setBounds(115,80,130,20);
		panel.add(payment);

		panel.add(lb_incoterm);
		
		incoterm = new JTextField(); 
		incoterm.setBounds(115,105,130,20);
		panel.add(incoterm);

		panel.add(lb_deliveryTerms);
		
		deliveryTerms = new JTextField(); 
		deliveryTerms.setBounds(145,130,130,20);
		panel.add(deliveryTerms);
		
		panel.add(bt_print);
		
		panel.add(cb_excel);
		
		cb_excel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}

			private void jCheckBox2ActionPerformed(ActionEvent evt) {
				if(cb_excel.isSelected()){
					System.out.println("format excel");
				}
				else{
					System.out.println("format pdf");
				}
			}
		});
		
		bt_print.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					bt_printActionPerformed(evt);	
				} 
				catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		FocusListener focuslistener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(e.getSource().equals(numorder))
				{
					Window.POnumorder=numorder.getText();
				}
				if(e.getSource().equals(payment))
				{
					Window.POpayment=payment.getText();
				}
				if(e.getSource().equals(incoterm))
				{
					Window.POincoterm=incoterm.getText();
				}
				if(e.getSource().equals(deliveryTerms))
				{
					Window.POdeliveryTerms=deliveryTerms.getText();
				}
			}
		};
		
		numorder.addFocusListener(focuslistener);
		payment.addFocusListener(focuslistener);
		incoterm.addFocusListener(focuslistener);
		deliveryTerms.addFocusListener(focuslistener);
		
		numorder.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				numorderActionPerformed(evt);
			}

			private void numorderActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.POnumorder=numorder.getText();
			}
		});
		
		payment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				paymentActionPerformed(evt);
			}

			private void paymentActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.POpayment=payment.getText();
			}
		});
		
		incoterm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				incotermActionPerformed(evt);
			}

			private void incotermActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.POincoterm=incoterm.getText();
			}
		});
		
		deliveryTerms.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deliveryTermsActionPerformed(evt);
			}

			private void deliveryTermsActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.POdeliveryTerms=deliveryTerms.getText();
			}
		});
		
		return panel;
	}
	
	private void bt_printActionPerformed(java.awt.event.ActionEvent evt) throws DocumentException, IOException {
		try{
			if(cb_excel.isSelected()){
				ExcelPurchaseExport epe = new ExcelPurchaseExport();
				epe.export();
			}
			else {
				export();
			}
			dispose();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void export() throws DocumentException, MalformedURLException, IOException{
		Window.df.setMaximumFractionDigits(2);
		Window.df.setMinimumFractionDigits(2);
		
		JFileChooser chooser = new JFileChooser(Window.parents){
			private static final long serialVersionUID = 1L;

			@Override
			public void approveSelection(){
				
				if(getSelectedFile().getAbsolutePath().endsWith(".pdf")){
					f = new File(getSelectedFile().getAbsolutePath());
				}
				else{ 
					f = new File(getSelectedFile().getAbsolutePath()+".pdf");
				}
				
				if(f.exists()){
					Window.parents=f.getParent();
					
					int answer = JOptionPane.showConfirmDialog(
						this, 
						f + " exists. Overwrite?", 
						"Overwrite?",
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE
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
		chooser.setSelectedFile(new File("SD3_PurchaseOrder_" + new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
		
		int returnVal=chooser.showSaveDialog(null);
		
		if(returnVal==JFileChooser.APPROVE_OPTION){
			//*********************************** Page 2 ******************************************
			Document document1 = new Document();

		    PdfWriter writer1 = PdfWriter.getInstance(document1, new FileOutputStream("page2.pdf"));
		    document1.open();
		    
		    // insertion du logo dans une cellule
		    PdfPTable tableLogo = new PdfPTable(1);
			PdfPCell cLogo = new PdfPCell(Image.getInstance("logo.png"), false);
			cLogo.setHorizontalAlignment(Element.ALIGN_CENTER);
			cLogo.setBorder(Rectangle.NO_BORDER);
			
			
			//ajout cellule dans tableau
			tableLogo.addCell(cLogo);
			
		    // création tableau
		    PdfPTable table2 = new PdfPTable(1);

		    PdfPCell c = new PdfPCell(new Phrase("SD3 : ZA du Moulin de Massy – 41, rue Saule Trapu – 91300 MASSY – France", new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			c.setBorder(Rectangle.NO_BORDER);
			table2.addCell(c);

			c = new PdfPCell(new Phrase("Tel : +33 (0)160136724 – Fax : +33 (0)160136726 – Email: sd3@sd3.net", new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			c.setBorder(Rectangle.NO_BORDER);
			table2.addCell(c);

			c = new PdfPCell(new Phrase(""));
			c.setBorder(Rectangle.NO_BORDER);
			c.setFixedHeight(c.getFixedHeight()+30);
			table2.addCell(c);

			c = new PdfPCell(new Phrase("Purchasing SD3 order", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			c.setBorder(Rectangle.NO_BORDER);
			table2.addCell(c);

			c = new PdfPCell(new Phrase(""));
			c.setBorder(Rectangle.NO_BORDER);
			c.setFixedHeight(c.getFixedHeight()+30);
			table2.addCell(c);
			
			document1.add(tableLogo);

			document1.add(table2);
			
			document1.add(createTable(document1));
						
		    document1.close();
		    //*************************************************************************************
		    
		    //*********************************** Page 1 ******************************************
		    PdfReader reader = new PdfReader("page2.pdf");

			Document document2 = new Document();
			PdfWriter writer2=PdfWriter.getInstance(document2, new FileOutputStream("page1.pdf"));
			document2.open();
			PdfContentByte canvas = writer2.getDirectContent();
			writer2.setCompressionLevel(0);

			canvas.saveState();
			canvas.beginText();
			canvas.moveText(280, 39);
			canvas.setFontAndSize(BaseFont.createFont(), 8);
			canvas.showText("Page 1 of " + (reader.getNumberOfPages() + 1));
			canvas.endText();
			canvas.restoreState();  
			
			canvas.saveState();
			Image img2=Image.getInstance("logo.png");
			img2.setAbsolutePosition(59, 680);
			img2.scalePercent(80);
			canvas.addImage(img2);
			canvas.restoreState(); 
			
			canvas.saveState();
			canvas.beginText();
			canvas.moveText(59, 662);
			canvas.setFontAndSize(FontFactory.getFont(BaseFont.HELVETICA, 10, 1).getCalculatedBaseFont(false), 8);
			canvas.showText(Window.companyname);
			canvas.endText();
			canvas.restoreState();  
			
			canvas.saveState();
			canvas.beginText();
			canvas.moveText(59, 650);
			canvas.setFontAndSize(BaseFont.createFont(), 8);
			canvas.showText(Window.companyaddress);
			canvas.endText();
			canvas.restoreState();  
			
			canvas.saveState();
			canvas.beginText();
			canvas.moveText(59, 638);
			canvas.setFontAndSize(BaseFont.createFont(), 8);
			canvas.showText(Window.companypostcode + " " + Window.companytown + " - " + Window.companycountry);
			canvas.endText();
			canvas.restoreState(); 

			canvas.saveState();
			canvas.beginText();
			canvas.moveText(167, 68);
			canvas.setFontAndSize(BaseFont.createFont(), 8);
			canvas.showText("Tel: "+Window.conpanytel + " - Fax: " + Window.conpanyfax + " - Email: " + Window.conpanyemail); 
			canvas.endText();
			canvas.restoreState(); 
			
			canvas.saveState();
			canvas.beginText();
			canvas.moveText(80, 58);
			canvas.setFontAndSize(BaseFont.createFont(), 8);
			canvas.showText(Window.conpanycomment);
			canvas.endText();
			canvas.restoreState();
			
			BaseFont font = FontFactory.getFont(BaseFont.HELVETICA, 10, 1).getCalculatedBaseFont(false);
			
			/************************************ ANGLAIS ******************************/
			if(Window.locale.toString().equals("en")){
				// REFERENCE
				if(!Window.referencequot.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 695);
					canvas.setFontAndSize(font, 10);
					canvas.showText("Reference :");
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
				// DELIVERY ADDRESS
				if(!Window.deliveryaddress.isEmpty() && !Window.deliverypostcode.isEmpty() && !Window.deliverylocation.isEmpty()){
					canvas.saveState(); 
					canvas.beginText();
					canvas.moveText(375, 624);
					canvas.setFontAndSize(font, 10);
					canvas.showText("Delivery address:");
					canvas.endText();
					canvas.restoreState(); 
					
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(460, 624);
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
				}
				// DE / FROM 
				if(!Window.from.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 650);  
					canvas.setFontAndSize(font, 10);
					canvas.showText("From:");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(410, 650);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText(Window.from);
					canvas.endText();
					canvas.restoreState(); 
				}
				// A / TO 
				if(!Window.to.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 637);
					canvas.setFontAndSize(font, 10);
					canvas.showText("To:");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(395, 637); 
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("SD3");
					canvas.endText();
					canvas.restoreState(); 
				}
				// Subject 
				if(!Window.POnumorder.isEmpty()){
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
					canvas.showText("Purchasing Order n° " + Window.POnumorder);
					canvas.endText();
					canvas.restoreState();
				}
				
				// Contenu 
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 529);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Dear SD3,");
				canvas.endText();
				canvas.restoreState(); 

				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 480);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Please find below our order for the material SD3.");
				canvas.endText();
				canvas.restoreState();
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 365);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Commercial terms: ");
				canvas.endText();
				canvas.restoreState();
				
				// PAYMENT
				if(!Window.POpayment.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 341);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Payment: " + Window.POpayment);
					canvas.endText();
					canvas.restoreState(); 
				}

				if(!Window.POdeliveryTerms.isEmpty()){
					canvas.saveState(); 
					canvas.beginText();
					canvas.moveText(59, 304);
					canvas.setFontAndSize(BaseFont.createFont(), 10); 
					canvas.showText("- Delivery terms: " + Window.POdeliveryTerms);
					canvas.endText();
					canvas.restoreState(); 
				}

				// INCOTERM
				if(!Window.POincoterm.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 328);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Incoterm: " + Window.POincoterm);
					canvas.endText();
					canvas.restoreState(); 
				}
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 250);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Wishing you good receipt and looking forward to hearing from you soon we remain.");
				canvas.endText();
				canvas.restoreState(); 
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 235);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Yours Faithfully,");
				canvas.endText();
				canvas.restoreState(); 
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
					canvas.moveText(375, 624);
					canvas.setFontAndSize(font, 10);
					canvas.showText("Indirizzo di consegna:");
					canvas.endText();
					canvas.restoreState(); 
					
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(482, 624);
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
					canvas.moveText(492, 598);
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
				}
				// DA  
				if(!Window.from.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 650);  
					canvas.setFontAndSize(font, 10);
					canvas.showText("Da :");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(398, 650);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText(Window.from);
					canvas.endText();
					canvas.restoreState(); 
				}
				// A 
				if(!Window.to.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 637);
					canvas.setFontAndSize(font, 10);
					canvas.showText("A :");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(393, 637); 
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("SD3");
					canvas.endText();
					canvas.restoreState(); 
				}
				// Soggetto
				if(!Window.POnumorder.isEmpty()){
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
					canvas.showText("L'acquisto di ordine n° " + Window.POnumorder);
					canvas.endText();
					canvas.restoreState();
				}
				
				// Contenu 
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 529);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Egregio SD3,");
				canvas.endText();
				canvas.restoreState(); 

				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 480);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Qui di seguito troverete il nostro preventivo con i prodotti SD3.");
				canvas.endText();
				canvas.restoreState();
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 365);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Condizioni commerciali : ");
				canvas.endText();
				canvas.restoreState();
				
				// PAYMENT
				if(!Window.POpayment.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 341);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Pagamento : " + Window.POpayment);
					canvas.endText();
					canvas.restoreState(); 
				}

				if(!Window.POdeliveryTerms.isEmpty()){
					canvas.saveState(); 
					canvas.beginText();
					canvas.moveText(59, 304);
					canvas.setFontAndSize(BaseFont.createFont(), 10); 
					canvas.showText("- Termini di consegna : " + Window.POdeliveryTerms);
					canvas.endText();
					canvas.restoreState(); 
				}

				// INCOTERM
				if(!Window.POincoterm.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 328);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Incoterm : " + Window.POincoterm);
					canvas.endText();
					canvas.restoreState(); 
				}
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 250);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("In attesa di un gradito riscontro cogliamo l'occasione per porgere,");
				canvas.endText();
				canvas.restoreState(); 
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 235);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Distinti saluti,");
				canvas.endText();
				canvas.restoreState(); 
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
					canvas.moveText(375, 624);
					canvas.setFontAndSize(font, 10);
					canvas.showText("Adresse de livraison:");
					canvas.endText();
					canvas.restoreState(); 
					
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(480, 624);
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
					canvas.moveText(492, 598);
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
				}
				// DE 
				if(!Window.from.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 650);  
					canvas.setFontAndSize(font, 10);
					canvas.showText("De :");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(398, 650);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText(Window.from);
					canvas.endText();
					canvas.restoreState(); 
				}
				// A 
				if(!Window.to.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(375, 637);
					canvas.setFontAndSize(font, 10);
					canvas.showText("A :");
					canvas.endText();
					canvas.restoreState(); 

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(393, 637); 
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("SD3");
					canvas.endText();
					canvas.restoreState(); 
				}
				// Odre d'achat
				if(!Window.POnumorder.isEmpty()){
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
					canvas.showText("Ordre d'achat n° " + Window.POnumorder);
					canvas.endText();
					canvas.restoreState();
				}
				
				// Contenu 
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 529);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Cher SD3,");
				canvas.endText();
				canvas.restoreState(); 

				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 480);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Veuillez trouver ci-dessous notre commande de matériel SD3.");
				canvas.endText();
				canvas.restoreState();
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 365);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Conditions commerciales: ");
				canvas.endText();
				canvas.restoreState();
				
				// PAYMENT
				if(!Window.POpayment.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 341);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Mode de paiement : " + Window.POpayment);
					canvas.endText();
					canvas.restoreState(); 
				}

				if(!Window.POdeliveryTerms.isEmpty()){
					canvas.saveState(); 
					canvas.beginText();
					canvas.moveText(59, 304);
					canvas.setFontAndSize(BaseFont.createFont(), 10); 
					canvas.showText("- Conditions de livraison : " + Window.POdeliveryTerms);
					canvas.endText();
					canvas.restoreState(); 
				}

				// INCOTERM
				if(!Window.POincoterm.isEmpty()){
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 328);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Incoterm : " + Window.POincoterm);
					canvas.endText();
					canvas.restoreState(); 
				}
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 250);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("En vous souhaitant bonne réception, veuillez agréer nos sincères salutations.");
				canvas.endText();
				canvas.restoreState(); 
				
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 235);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Cordialement,");
				canvas.endText();
				canvas.restoreState(); 
			}
			// DATE 
			if(!Window.date.isEmpty()){
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(437, 748);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText(Window.date);
				canvas.endText();
				canvas.restoreState();  
			}

			// NOM + PRENOM USER
			if(!Window.salesman.isEmpty()){
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 168);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText(Window.salesman + " " + Window.gsm);
				canvas.endText();
				canvas.restoreState(); 
			}
			// TEL USER
			if(!Window.tel.isEmpty()){
				canvas.saveState();                             
				canvas.beginText();                             
				canvas.moveText(59, 156);                         
				canvas.setFontAndSize(BaseFont.createFont(), 10); 
				canvas.showText("Tel: " + Window.tel);                   
				canvas.endText();                                 
				canvas.restoreState(); 
			}
			// FAX 
			if(!Window.fax.isEmpty()){
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 144);
				canvas.setFontAndSize(BaseFont.createFont(), 10);
				canvas.showText("Fax: " + Window.fax);
				canvas.endText();
				canvas.restoreState(); 
			}
			// MAIL 
			if(!Window.email.isEmpty()){
				BaseFont font1 = FontFactory.getFont(BaseFont.HELVETICA, 10, BaseColor.BLUE).getCalculatedBaseFont(true);
				canvas.saveState();
				canvas.beginText();
				canvas.moveText(59, 131);
				canvas.setFontAndSize(font1, 10);
				canvas.showText("Email: " + Window.email);
				canvas.endText();
				canvas.restoreState(); 
			}
			document2.close();
		    
		    //*************************************************************************************
			//************************************** FUSION ***************************************
			Document document4 = new Document();
			PdfCopy copy = new PdfCopy(document4, new FileOutputStream(OUTPUTFILE));

			document4.open();
			PdfReader reader3 = new PdfReader("page1.pdf");
			PdfImportedPage page1=copy.getImportedPage(reader3, 1);
			copy.addPage(page1);
			
			PdfReader reader4 = new PdfReader("page2.pdf");
			PdfImportedPage page2=copy.getImportedPage(reader4, 1);
			copy.addPage(page2);

			copy.close();   
			document4.close();
			//************************************************************************************
			PdfReader reader5 = new PdfReader(OUTPUTFILE);
			Document document5 = new Document();
			if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf")){
				copy = new PdfCopy(document5, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()));
			}
			else
				copy = new PdfCopy(document5, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()+".pdf"));

			document5.open();

			page1=copy.getImportedPage(reader5, 1);
			copy.addPage(page1);

			for(int i=1;i<=reader.getNumberOfPages();i++){
				page2=copy.getImportedPage(reader, i);
				copy.addPage(page2);
			}

			copy.close();

			document5.close();
			//*********************************** NETTOYAGE **************************************
			File file1 = new File("page1.pdf"); 
			file1.delete();
			File file2 = new File("page2.pdf"); 
			file2.delete();
			File file3 = new File("purchasefinal.pdf"); 
			file3.delete();
			//************************************************************************************
			
			WritableSheet sheet2;
	        Workbook workbook2;
	        WritableWorkbook wwork2;
	        WritableCell cell2;
	        
			try {
	        	if(!new File("./Summary Purchasing orders.xls").exists()){
	            		
	        		WritableWorkbook wworkbook;
	    			
	        		wworkbook = Workbook.createWorkbook(new File("./Summary Purchasing orders.xls"));
	    					
	        		WritableSheet wsheet = wworkbook.createSheet("Savedata", 0);
	        		WritableFont titrefont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD); 
	        		
	        		wsheet.setColumnView(0, 20);
	    			wsheet.setColumnView(1, 40);
	    			wsheet.setColumnView(2, 30);
	    				
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
					label = new Label(2,0, "TOTAL PURCHASE PRICE", format); 
					wsheet.addCell(label);
					
					wworkbook.write(); 
					wworkbook.close(); 	
	            }
	            	
	        	workbook2 = Workbook.getWorkbook(new File("./Summary Purchasing orders.xls"));
	        	wwork2 = Workbook.createWorkbook(new File("./Summary Purchasing orders.xls"), workbook2);
	        	
	        	sheet2 = wwork2.getSheet(0);
	        	
	            Window.df.setMaximumFractionDigits(2);
	            Window.df.setMinimumFractionDigits(2);
	            exist=false;
	            
	            for(int k=0;k<=sheet2.getRows()-1;k++){
	            	if(sheet2.getCell(0, k).getContents().equals(Window.date) && sheet2.getCell(1, k).getContents().equals(Window.referencequot) && sheet2.getCell(2, k).getContents().equals(Window.df.format(quotationprice)))
	            		exist=true;
	            }
	            
	            if(!exist){
	            	Label label = null;
	            	int row=sheet2.getRows();
	               
	            	for(int i=0;i<=2;i++){
	            		cell2 = sheet2.getWritableCell(i, sheet2.getRows());
	                
	            		if(i==0)
	            			label = new Label(i, row, Window.date);
	               	
	            		if(i==1)
	            			label = new Label(i, row, Window.referencequot);
	               	
	            		if(i==2)
	            			label = new Label(i, row, Window.df.format(quotationprice));
	                
	                sheet2.addCell(label); 
	            }
	            
	            wwork2.write(); 
	            wwork2.close(); 
	            System.out.println("Sauvegarde quotation dans ./Summary Purchasing orders.xls");
	            }
	        }
	        catch (Exception e) {
	        	System.out.println(e);
	        }
	        
			if ( Desktop.isDesktopSupported() ) {
				// On récupère l'instance du desktop :
				Desktop desktop = Desktop.getDesktop();

				// On vérifie que la fonction open est bien supportée :
				if (desktop.isSupported(Desktop.Action.OPEN)) {
					if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf")){
						desktop.open(new File(chooser.getSelectedFile().getAbsolutePath()));
					}
					else 
						desktop.open(new File(chooser.getSelectedFile().getAbsolutePath()+".pdf"));
				}
			}		
		}
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
		
		cell = new PdfPCell(new Phrase("Unit net price in euro", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setNoWrap(false);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Total price in euro", new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setNoWrap(false);
		table.addCell(cell);
		
		table.setHeaderRows(1);
	}
	
	public static PdfPTable createTable(Document document) throws DocumentException, MalformedURLException, IOException {

		total=0;
		quotationprice=0;

		PdfPTable table = new PdfPTable(6);
		table.setWidths(new float[]{(float)1,(float)1.6,(float) 6,(float)0.7,(float) 1.4,(float) 1.4});
		table.setWidthPercentage(100f);

		PdfPTable table2 = new PdfPTable(6);
		table2.setWidths(new float[]{(float)1,(float)1.6,(float) 6,(float)0.7,(float) 1.4,(float) 1.4});
		table2.setWidthPercentage(101f);

		PdfPCell cell = new PdfPCell();
		addHeader(table, cell);

		for(int i=0;i<=Window.reference.size()-1;i++){
			if(Window.reference.get(i).isEmpty()&&Window.index.get(i).toString().isEmpty()&&!Window.description.get(i).toString().isEmpty()){
				cell = new PdfPCell(new Phrase(Window.description.get(i), new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setBackgroundColor(BaseColor.CYAN);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(6);
				table.addCell(cell);
			}
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
			else if(Window.reference.get(i).isEmpty()&&Window.index.get(i).toString().isEmpty()&&Window.description.get(i).toString().isEmpty()){
				document.add(table);
				table = new PdfPTable(6);
				table.setWidths(new float[]{(float)1,(float)1.6,(float) 6,(float)0.7,(float) 1.4,(float) 1.4});
				table.setWidthPercentage(100f);
				document.newPage();
				addHeader(table, cell);
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
					
				cell = new PdfPCell(new Phrase(Window.marginbase.readMargin(Window.reference.get(i))+" €", new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
					
				total=Double.parseDouble(Window.marginbase.readMargin(Window.reference.get(i)))*Double.parseDouble(Window.quantity.get(i));
				
				cell = new PdfPCell(new Phrase(Window.df.format(total)+" €", new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
				quotationprice+=total;
				Window.patotal=quotationprice;

			}
		}
	
		cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(5);
		cell.setBackgroundColor(BaseColor.YELLOW);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase(Window.df.format(quotationprice).replaceAll(",","")+" €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table2.addCell(cell);

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
		cell.setFixedHeight(20f);
		table2.addCell(cell);
		
		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Please send it back by mail (sd3@sd3.net) or by fax (+33 1 60 13 67 26) ", new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
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
		
		return table;
	}
}