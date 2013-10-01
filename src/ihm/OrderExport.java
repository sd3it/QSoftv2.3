package ihm;

import database.Footer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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

public class OrderExport extends Window {

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
	public static double proformaprice=0.0;
	private static int cpt=0;


	public OrderExport(String date, String yourreference, String carriagecompany, String postage, String adress, String postcode, String town) {
		super();
		this.date = date;
		this.yourreference = yourreference;
		this.carriagecompany = carriagecompany;
		this.postage = postage;
		this.adress = adress;
		this.postcode = postcode;
		this.town = town;
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
	}

	@SuppressWarnings("null")
	public void print() throws BiffException, WriteException, IOException{
		try{
			proformaprice=0.0;
		
			Locale.setDefault(Locale.ENGLISH);
			try{  
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
			catch (Exception e){}
		
		JFileChooser chooser = new JFileChooser(parents){
			@Override
			public void approveSelection(){
				File f = new File(getSelectedFile().getAbsolutePath()+".pdf");
				//System.out.println(f.getAbsolutePath());
				if(f.exists()){
					//System.out.println("test");
					int answer = JOptionPane.showConfirmDialog(
							this, f + " exists. Overwrite?", "Overwrite?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
					);
					if (answer != JOptionPane.OK_OPTION)
					{
						return;
					}
					//else 

					//jLabel4.setText(this.getSelectedFile().getName());
				}//else super.approveSelection();
				super.approveSelection();
			}

		};
		chooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Fichier PDF (.pdf)","pdf");
		chooser.setFileFilter(filter);
		//	chooser.addChoosableFileFilter(new FiltreExtension("xls", "Fichier Excel"));
		//	chooser.setSelectedFile(new File("pricingfile.xls"));
		int returnVal=chooser.showSaveDialog(null);
		if(returnVal==JFileChooser.APPROVE_OPTION)
		{
			try{
				Document document = new Document();//PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("proforma.pdf"));
				//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()+".pdf"));
				//Footer event=new Footer();
				//writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
				//writer.setPageEvent(event);
				//event.settotal(1);
				document.open();

				PdfPTable table = new PdfPTable(8);

				table.setWidths(new float[]{(float)0.05,(float) 0.05,(float)0.05,(float) 0.3315,(float) 0.08,(float) 0.18,(float) 0.1016,(float) 0.14});
				table.setWidthPercentage(100f);

				PdfPCell c;

				Image img =Image.getInstance("//Serveur/PIERRE/workspace/QSoft/src/picture/LOGO.jpg");
				//img.setWidthPercentage(50);
				img.scalePercent(50);
				c= new PdfPCell(img);
				//c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setBorder(Rectangle.NO_BORDER);
				c.setColspan(3);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.NO_BORDER);
				c.setColspan(5);
				table.addCell(c);

				c = new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.NO_BORDER);
				c.setColspan(8);
				c.setFixedHeight(c.getFixedHeight()+10);
				table.addCell(c);

				c= new PdfPCell(new Phrase("DATE",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(13);
				c.setColspan(3);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setRowspan(2);
				c.setBorder(Rectangle.BOX);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setRowspan(2);
				c.setBorder(Rectangle.NO_BORDER);
				table.addCell(c);


				c= new PdfPCell(new Phrase("INVOICING and DELIVERY ADDRESS",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_TOP);
				c.setVerticalAlignment(Element.ALIGN_LEFT);
				c.setColspan(3);
				c.setRowspan(2);
				c.setBorder(13);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase(this.date,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(14);
				c.setColspan(3);
				table.addCell(c);

				c= new PdfPCell(new Phrase("YOUR REFRENCE",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setColspan(3);
				c.setBorder(13);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("PROFORMA INVOICE SD3-0011",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setRowspan(2);
				c.setBorder(Rectangle.BOX);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setRowspan(2);
				c.setBorder(Rectangle.NO_BORDER);
				table.addCell(c);

				c= new PdfPCell(new Phrase(this.adress,new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setColspan(3);
				c.setBorder(12);
				//c.setBorder();
				table.addCell(c);

				c= new PdfPCell(new Phrase(this.yourreference,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setColspan(3);
				c.setBorder(14);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase(this.postcode+" "+this.town,new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(12);
				c.setColspan(3);
				//c.setBorder();
				table.addCell(c);

				c= new PdfPCell(new Phrase("CARRIAGE COMPANY",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(13);
				c.setColspan(3);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("POSTAGE",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_TOP);
				c.setBorder(13);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.NO_BORDER);
				c.setRowspan(2);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setBorder(14);
				c.setColspan(3);
				table.addCell(c);

				c= new PdfPCell(new Phrase(this.carriagecompany,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(14);
				c.setColspan(3);
				table.addCell(c);

				c= new PdfPCell(new Phrase(this.postage,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(14);
				//	c.setColspan(3);
				table.addCell(c);

				//c= new PdfPCell(new Phrase("Page "+writer.getPageNumber()+"/"+document.getPageNumber(),new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
				c= new PdfPCell(new Phrase(""));
				c.setHorizontalAlignment(Element.ALIGN_RIGHT);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(Rectangle.NO_BORDER);
				c.setColspan(3);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setColspan(8);
				c.setBorder(Rectangle.NO_BORDER);
				c.setFixedHeight(c.getFixedHeight()+10);
				table.addCell(c);

				c= new PdfPCell(new Phrase("N°",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Qty",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Un",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Wording",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Ind",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Product Code",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);


				c= new PdfPCell(new Phrase("Unit Price",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Amount NP",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				//	c.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table.addCell(c);
				
				
			/*	if(event55.getCpt()>=2){
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

					c= new PdfPCell(new Phrase(""));
					table.addCell(c);

					c= new PdfPCell(new Phrase(""));
					table.addCell(c);

					c= new PdfPCell(new Phrase(Integer.toString(event55.getCpt()),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					c.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(c);

					c= new PdfPCell(new Phrase("U",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					c.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(c);

					c= new PdfPCell(new Phrase("Amount page"+Integer.toString(event55.getCpt()+1)+"to be followed",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					c.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(c);

					c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					c.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(c);

					c= new PdfPCell(new Phrase(""));
					table.addCell(c);

					c= new PdfPCell(new Phrase(Double.toString(proformaprice)));
					table.addCell(c);

					c= new PdfPCell(new Phrase(Double.toString(proformaprice)));
					table.addCell(c);
				}*/


				c= new PdfPCell(new Phrase(""));
				c.setFixedHeight(c.getFixedHeight()+7);
				table.addCell(c);
				c= new PdfPCell(new Phrase(""));
				table.addCell(c);
				c= new PdfPCell(new Phrase(""));
				table.addCell(c);
				c= new PdfPCell(new Phrase("The exporter of the products covered by this document declares that, expect where otherwise cleary indicated, these\nproducts are of France preferential origin.",new Font(FontFamily.HELVETICA, (float)5.3, Font.BOLD)));
				//c.setVerticalAlignment(Element.ALIGN_BOTTOM);
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
				/*	c= new PdfPCell(new Phrase("products are of France preferential origin.",new Font(FontFamily.HELVETICA, 5, Font.BOLD)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setBorder(Rectangle.BOTTOM);
			c.setVerticalAlignment(Element.ALIGN_TOP);
			c.setColspan(3);
			//c.setRowspan(2);
			table.addCell(c);*/

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
				c.setRowspan(4);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Total Net Price",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				table.addCell(c);

				c= new PdfPCell(new Phrase("Value",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(c);


				c= new PdfPCell(new Phrase(""));
				c.setColspan(4);
				c.setRowspan(3);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Total Costs Net Price",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
				table.addCell(c);
				c= new PdfPCell(new Phrase(""));
				table.addCell(c);

				c= new PdfPCell(new Phrase("0.00 €",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Total VAT",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
				table.addCell(c);
				c= new PdfPCell(new Phrase(""));
				table.addCell(c);

				c= new PdfPCell(new Phrase("0.00 €",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(c);

				c= new PdfPCell(new Phrase("Total IT EUR",new Font(FontFamily.HELVETICA, (float)5.5, Font.BOLD)));
				table.addCell(c);
				c= new PdfPCell(new Phrase(""));
				table.addCell(c);

				c= new PdfPCell(new Phrase("Value",new Font(FontFamily.HELVETICA, (float)5.5, Font.BOLD)));
				c.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setColspan(8);
				c.setBorder(Rectangle.NO_BORDER);
				c.setFixedHeight(c.getFixedHeight()+10);
				table.addCell(c);

				c= new PdfPCell(new Phrase("SD3 - ZA du Moulin de Massy - 41 rue du Saule Trapu - 91 300 MASSY - France\n\nPhone N°: +33 (0)160136724 - Fax: +33(0)160136726 - Email:sd3@sd3.net\n\nSARL au capital de 10 000 euros\n\nRSCEvry 443 225 123 - NAF 4652Z - TVA FR 443 225 123",new Font(FontFamily.HELVETICA, (float)3.3, Font.BOLD)));
				c.setVerticalAlignment(Element.ALIGN_TOP);
				c.setColspan(4);
				c.setBorder(Rectangle.BOX);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.NO_BORDER);
				table.addCell(c);

				c= new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.BOX);
				//c.setBorder(Rectangle.BOTTOM);
				c.setColspan(3);

				table.addCell(c);

				//boucle for add product
				for(int i=0;i<=reference.size()-1;i++){
				
					
					c= new PdfPCell(new Phrase(Integer.toString(i+1),new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
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

			/*	if(event55.getCpt()>=2){
					table.setHeaderRows(21);
					table.setFooterRows(9);
					
				}else{*/
					table.setHeaderRows(19);
					table.setFooterRows(9);
				//}






				//
				//	table.setFooterRows(12);
				/*		c= new PdfPCell(new Phrase("SD3 - ZA du Moulin de Massy - 41 rue du Saule Trapu",new Font(FontFamily.HELVETICA, 3, Font.BOLD)));
			c.setColspan(4);
			c.setBorder(Rectangle.LEFT);
			c.setBorder(Rectangle.RIGHT);
			c.setBorder(Rectangle.TOP);
			c.setFixedHeight(c.getFixedHeight()+10);
			table.addCell(c);

			c= new PdfPCell(new Phrase("SD3 - ZA du Moulin de Massy - 41 rue du Saule Trapu",new Font(FontFamily.HELVETICA, 3, Font.BOLD)));
			c.setColspan(4);      
			c.setBorder(Rectangle.LEFT);
			c.setBorder(Rectangle.RIGHT);
			c.setBorder(Rectangle.TOP);
			c.setFixedHeight(c.getFixedHeight()+10);
			table.addCell(c);

			c= new PdfPCell(new Phrase("SD3 - ZA du Moulin de Massy - 41 rue du Saule Trapu",new Font(FontFamily.HELVETICA, 3, Font.BOLD)));
			c.setColspan(4);
			c.setBorder(Rectangle.LEFT);
			c.setBorder(Rectangle.RIGHT);
			c.setBorder(Rectangle.TOP);
			c.setFixedHeight(c.getFixedHeight()+10);
			table.addCell(c);*/

				document.add(table);
				document.close();

				PdfReader reader = new PdfReader("proforma.pdf");
				Document document1 = new Document();//PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer1=PdfWriter.getInstance(document1, new FileOutputStream(chooser.getSelectedFile().getAbsolutePath()+".pdf"));
				MyFooter event55 = new MyFooter();
				writer1.setPageEvent(event55);
				event55.settotal(reader.getNumberOfPages());	

				document1.open();
				
				document1.add(tablepage());
				
				document1.close();

				File file = new File("proforma.pdf"); 
				file.delete();

			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		}catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e); 
		}
	}

	private Element tablepage() throws DocumentException, MalformedURLException, IOException {
		PdfPTable table = new PdfPTable(8);

		table.setWidths(new float[]{(float)0.05,(float) 0.05,(float)0.05,(float) 0.3315,(float) 0.08,(float) 0.18,(float) 0.1016,(float) 0.14});
		table.setWidthPercentage(100f);

		PdfPCell c;
		int page=0;
	
		cpt=0;
	
		//boucle for add product
		for(int i=0;i<=reference.size()-1;i++){

			//if true alors false +rajouter deux lignes objet en publique
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
			table.addCell(c);

			c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase("TRANSPORT COST",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase(df.format(Window.transportval) +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase(df.format(Window.transportval)+" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
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
			table.addCell(c);

			c= new PdfPCell(new Phrase("-",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase("ASSISTANCE COST",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase(df.format(Window.assistance) +" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(c);

			c= new PdfPCell(new Phrase(df.format(Window.assistance)+" €",new Font(FontFamily.HELVETICA, (float)6.5, Font.NORMAL)));
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
		//c.setVerticalAlignment(Element.ALIGN_BOTTOM);
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
		/*	c= new PdfPCell(new Phrase("products are of France preferential origin.",new Font(FontFamily.HELVETICA, 5, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setBorder(Rectangle.BOTTOM);
		c.setVerticalAlignment(Element.ALIGN_TOP);
		c.setColspan(3);
		//c.setRowspan(2);
		table.addCell(c);*/

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
		c.setRowspan(4);
		else c.setRowspan(5);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Total Net Price",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		table.addCell(c);

		c= new PdfPCell(new Phrase(df.format(proformaprice),new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);


		c= new PdfPCell(new Phrase(""));
		c.setColspan(4);
		if(Window.discount==0)
			c.setRowspan(3);
			else c.setRowspan(4);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Total Costs Net Price",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);

		c= new PdfPCell(new Phrase("0.00 €",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Total VAT",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		table.addCell(c);
		c= new PdfPCell(new Phrase(""));
		table.addCell(c);

		c= new PdfPCell(new Phrase("0.00 €",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);

		if(Window.discount!=0)
		{
			c= new PdfPCell(new Phrase("Discount",new Font(FontFamily.HELVETICA, (float)5.5, Font.NORMAL)));
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

		c= new PdfPCell(new Phrase(df.format((proformaprice-Window.transportval-Window.assistance)-((proformaprice-Window.transportval-Window.assistance)*Window.discount/100)+Window.transportval+Window.assistance)+" €",new Font(FontFamily.HELVETICA, (float)5.5, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setColspan(8);
		c.setBorder(Rectangle.NO_BORDER);
		c.setFixedHeight(c.getFixedHeight()+10);
		table.addCell(c);

		c= new PdfPCell(new Phrase("SD3 - ZA du Moulin de Massy - 41 rue du Saule Trapu - 91 300 MASSY - France\n\nPhone N°: +33 (0)160136724 - Fax: +33(0)160136726 - Email:sd3@sd3.net\n\nSARL au capital de 10 000 euros\n\nRSCEvry 443 225 123 - NAF 4652Z - TVA FR 443 225 123",new Font(FontFamily.HELVETICA, (float)3.3, Font.BOLD)));
		c.setVerticalAlignment(Element.ALIGN_TOP);
		c.setColspan(4);
		c.setBorder(Rectangle.BOX);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setBorder(Rectangle.NO_BORDER);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setBorder(Rectangle.BOX);
		//c.setBorder(Rectangle.BOTTOM);
		c.setColspan(3);

		table.addCell(c);
		

		
		return table;
	}
}
