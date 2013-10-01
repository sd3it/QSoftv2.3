package ihm;

import database.Footer;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEventSplit;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.events.PdfPTableEventForwarder;

public class PdfInvoiceExport extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String date="";
	public static String yourreference="";
	public static String carriagecompany="";
	public static String postage="";
	public static String adress="";
	public static String postcode="";
	public static String town="";
	public static String customer="";
	public static double proformaprice=0.0;
	private static int cpt=0;


	public PdfInvoiceExport(String date, String yourreference, String carriagecompany, String postage, String adress, String postcode, String town, String customer) {
		super();
		this.date = date;
		this.yourreference = yourreference;
		this.carriagecompany = carriagecompany;
		this.postage = postage;
		this.adress = adress;
		this.postcode = postcode;
		this.town = town;
		this.customer=customer;
	}

	@SuppressWarnings("null")
	public void print() throws BiffException, WriteException, IOException{
		try {
			proformaprice=0.0;
			df.setMaximumFractionDigits(2);
			df.setMinimumFractionDigits(2);
			Locale.setDefault(Locale.ENGLISH);
			try {  
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
			catch (Exception e) {}
		
			JFileChooser chooser = new JFileChooser(parents){
				@Override
				public void approveSelection(){
					File f=null;
					
					if(getSelectedFile().getAbsolutePath().endsWith(".pdf"))
						f= new File(getSelectedFile().getAbsolutePath());
					else 
						f = new File(getSelectedFile().getAbsolutePath()+".pdf");
					
					if(f.exists()){
						Window.parents=f.getParent();
						int answer = JOptionPane.showConfirmDialog(
							this, f + " exists. Overwrite?", "Overwrite?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
						);
							
						if (answer != JOptionPane.OK_OPTION){
							return;
						}
					}
					super.approveSelection();
				}
			};
			chooser.setAcceptAllFileFilterUsed(false);
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier PDF (.pdf)","pdf");
			chooser.setFileFilter(filter);
					
			//Nom fichier proformat
			if(customer.isEmpty())
				chooser.setSelectedFile(new File("proforma_"+new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			else
				chooser.setSelectedFile(new File("proforma_"+customer +"_"+new SimpleDateFormat("dd.MM.yyyy").format(new Date())));

			int returnVal=chooser.showSaveDialog(null);
				
			if(returnVal==JFileChooser.APPROVE_OPTION){
				try{
					Document document = new Document();
					PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("proforma.pdf"));
					MyFooter event56 = new MyFooter();
					writer.setPageEvent(event56);
					event56.settotal(0);	
					document.open();
						
					document.add(tablepage());
						
					document.close();

					PdfReader reader = new PdfReader("proforma.pdf");
					Document document1 = new Document();
					PdfWriter writer1;
					
					if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf")){
						writer1=PdfWriter.getInstance(document1, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()));
					}
					else 
						writer1=PdfWriter.getInstance(document1, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()+".pdf"));
					
					MyFooter event55 = new MyFooter();
					writer1.setPageEvent(event55);
					event55.settotal(reader.getNumberOfPages());	
						
					document1.open();
						
					document1.add(tablepage());
						
					document1.close();

					File file = new File("proforma.pdf"); 
					file.delete();
				
					if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf"))
						Window.printermailer=chooser.getSelectedFile().getAbsolutePath();
					else 
						Window.printermailer=chooser.getSelectedFile().getAbsolutePath()+".pdf";
				
					if ( Desktop.isDesktopSupported() ) {
						// On récupère l'instance du desktop :
						Desktop desktop = Desktop.getDesktop();

						// On vérifie que la fonction open est bien supportée :
						if (desktop.isSupported(Desktop.Action.OPEN)) {
							if(chooser.getSelectedFile().getAbsolutePath().endsWith(".pdf"))
								// Et on lance l'application associé au fichier pour l'ouvrir :
								desktop.open(new File(chooser.getSelectedFile().getAbsolutePath()));
							else 
								desktop.open(new File(chooser.getSelectedFile().getAbsolutePath()+".pdf"));
						}
					}
				}
				catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e); 
		}
	}

	private Element tablepage() throws DocumentException, MalformedURLException, IOException {
		PdfPTable table = new PdfPTable(8);
	
		table.setWidths(new float[]{(float)0.05,(float) 0.05,(float)0.05,(float) 0.3315,(float) 0.08,(float) 0.18,(float) 0.1016,(float) 0.14});
		table.setWidthPercentage(100f);

		PdfPCell c;
		int page=0;
			
		proformaprice=0;		
		cpt=0;
		
		//boucle for add product
		for(int i=0;i<=reference.size()-1;i++){

			//if true alors false + rajouter deux lignes objet en publique
			if( !reference.get(i).isEmpty() && !description.get(i).isEmpty()&& !quantity.get(i).isEmpty() && !price.get(i).isEmpty() && !totalyprice.get(i).isEmpty() )
			{
				try{
					proformaprice+=Double.parseDouble(totalyprice.get(i));
				}
				catch (Exception e) {}
				
				cpt+=1;
				c= new PdfPCell(new Phrase(Integer.toString(cpt),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
	
				c= new PdfPCell(new Phrase(quantity.get(i),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
	
				c= new PdfPCell(new Phrase("U",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
	
				c= new PdfPCell(new Phrase(description.get(i),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				table.addCell(c);
			
				c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
	
				c= new PdfPCell(new Phrase(reference.get(i),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
	
				c= new PdfPCell(new Phrase(price.get(i) +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
	
				c= new PdfPCell(new Phrase(totalyprice.get(i) +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c);
			}
		}
		
		if(Window.transportval!=0){
			cpt+=1;
			c= new PdfPCell(new Phrase(Integer.toString(cpt),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("1",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase("U",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("TRANSPORT COST",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase(df.format(Window.transportval).replaceAll(",", " ") +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
				
			c= new PdfPCell(new Phrase(df.format(Window.transportval).replaceAll(",", " ") +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
			
			proformaprice+=Window.transportval;
		}
	
		if(Window.assistance!=0){
			cpt+=1;
			c= new PdfPCell(new Phrase(Integer.toString(cpt),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
				
			c= new PdfPCell(new Phrase("1",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("U",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
	
			c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
					
			c= new PdfPCell(new Phrase("ASSISTANCE COST",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
				
			c= new PdfPCell(new Phrase(df.format(Window.assistance).replaceAll(",", " ") +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
					
			c= new PdfPCell(new Phrase(df.format(Window.assistance).replaceAll(",", " ")+" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);
				
			proformaprice+=Window.assistance;
				
		}
			
		c= new PdfPCell(new Phrase(""));
		c.setFixedHeight(c.getFixedHeight()+7);
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase("The exporter of the products covered by this document declares that, expect where otherwise cleary indicated, these\nproducts are of France preferential origin.",new Font(FontFamily.HELVETICA, (float)5.3, Font.BOLD)));
		
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setBorder(Rectangle.BOTTOM);
		c.setColspan(3);
		c.setRowspan(2);
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
				
		c= new PdfPCell(new Phrase("0% discount for the anticipated payment and transfert of ownership at the end of payment",new Font(FontFamily.HELVETICA, (float)4.5, Font.NORMAL)));
		c.setColspan(8);
		c.setBorder(Rectangle.NO_BORDER);
		table.addCell(c);
			
		c= new PdfPCell(new Phrase(""));
		c.setColspan(4);
		table.addCell(c);
			
		c= new PdfPCell(new Phrase(""));
			
		if(Window.discount==0)
			c.setRowspan(3);
		else 
			c.setRowspan(4);
			
		table.addCell(c);
	
		c= new PdfPCell(new Phrase("Total Net Price",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		table.addCell(c);
				
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);
	
		c= new PdfPCell(new Phrase(df.format(proformaprice).replaceAll(",", " ")+" €",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);
				
		c= new PdfPCell(new Phrase(""));
		c.setColspan(4);
				
		if(Window.discount==0)
			c.setRowspan(2);
		else c.setRowspan(3);
			table.addCell(c);


		c= new PdfPCell(new Phrase("Total VAT",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);

		c= new PdfPCell(new Phrase("0.00 €",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);
	
		if(Window.discount!=0){
			c= new PdfPCell(new Phrase("Discount on product(s)",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
			table.addCell(c);
			c= new PdfPCell(new Phrase(""));
			table.addCell(c);
	
			c= new PdfPCell(new Phrase(df.format(Window.discount)+" %",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(c);
		}
			
		c= new PdfPCell(new Phrase("Total IN EUR",new Font(FontFamily.HELVETICA, (float)5.5, Font.BOLD)));
		table.addCell(c);
			
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);

		c= new PdfPCell(new Phrase(df.format((proformaprice-Window.transportval-Window.assistance)-((proformaprice-Window.transportval-Window.assistance)*Window.discount/100)+Window.transportval+Window.assistance).replaceAll(",", " ")+" €",new Font(FontFamily.HELVETICA, (float)5.5, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);
	
		c= new PdfPCell(new Phrase(""));
		c.setColspan(8);
		c.setBorder(Rectangle.NO_BORDER);
		c.setFixedHeight(c.getFixedHeight()+10);
		table.addCell(c);

		c= new PdfPCell(new Phrase(companyname+" - "+companyaddress+" - "+companypostcode+" "+companytown+" - "+companycountry+"\n\nPhone N°: "+conpanytel+" - Fax: "+conpanyfax+" - Email:"+conpanyemail+"\n\n"+conpanycomment,new Font(FontFamily.HELVETICA, (float)3.3, Font.BOLD)));
		c.setVerticalAlignment(Element.ALIGN_TOP);
		c.setColspan(4);
		c.setBorder(Rectangle.BOX);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setBorder(Rectangle.NO_BORDER);
		table.addCell(c);
	
		c= new PdfPCell(new Phrase(""));
		c.setBorder(Rectangle.BOX);
		c.setColspan(3);

		table.addCell(c);

		return table;
	}
}
