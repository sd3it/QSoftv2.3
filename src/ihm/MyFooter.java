package ihm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class MyFooter extends PdfPageEventHelper {


	int total=0;
	boolean reference=false;
	int cpt=0;
	DecimalFormat df = new DecimalFormat ( ) ; 
	
	public MyFooter(){
		total=0;
		cpt=0;
	}

	public void settotal(int total){
		this.total=total;	
	}
	
	public void setreference(boolean reference){
		this.reference=reference;	
	}

	public int getCpt(){
		return cpt;
	}

	public void onStartPage(PdfWriter pdfWriter, Document document) {
		cpt+=1;
		PdfPTable table = new PdfPTable(8);

		try {
			table.setWidths(new float[]{(float)0.05,(float) 0.05,(float)0.05,(float) 0.3315,(float) 0.08,(float) 0.18,(float) 0.1016,(float) 0.14});
		} 
		catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setWidthPercentage(100f);

		PdfPCell c;

		Image img = null;
		
		try {
			img = Image.getInstance("logo.png");
		} 
		catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		img.scalePercent(50);
		c= new PdfPCell(img);

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

		c= new PdfPCell(new Phrase("INVOICING ADDRESS",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_TOP);
		c.setVerticalAlignment(Element.ALIGN_LEFT);
		c.setColspan(3);
		c.setRowspan(2);
		c.setBorder(13);
		table.addCell(c);

		c= new PdfPCell(new Phrase(PdfInvoiceExport.date,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setBorder(14);
		c.setColspan(3);
		table.addCell(c);

		c= new PdfPCell(new Phrase("YOUR REFRENCE",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setColspan(3);
		c.setRowspan(2);
		c.setBorder(13);
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("PROFORMA INVOICE SD3",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setRowspan(3);
		c.setBorder(Rectangle.BOX);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setRowspan(3);
		c.setBorder(Rectangle.NO_BORDER);
		table.addCell(c);

		c= new PdfPCell(new Phrase(PdfInvoiceExport.customer,new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setColspan(3);
		c.setBorder(12);
		table.addCell(c);
		
		c= new PdfPCell(new Phrase(PdfInvoiceExport.adress,new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setColspan(3);
		c.setBorder(12);
		table.addCell(c);

		c= new PdfPCell(new Phrase(PdfInvoiceExport.yourreference,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setColspan(3);
		c.setBorder(14);
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase(PdfInvoiceExport.postcode+" "+PdfInvoiceExport.town,new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setBorder(12);
		c.setColspan(3);
		table.addCell(c);

		c= new PdfPCell(new Phrase("CARRIAGE COMPANY",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setBorder(13);
		c.setColspan(3);
		table.addCell(c);

		c= new PdfPCell(new Phrase("POSTAGE",new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_TOP);
		c.setBorder(13);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setBorder(Rectangle.NO_BORDER);
		c.setRowspan(2);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setBorder(14);
		c.setColspan(3);
		table.addCell(c);

		c= new PdfPCell(new Phrase(PdfInvoiceExport.carriagecompany,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setBorder(14);
		c.setColspan(3);
		table.addCell(c);

		c= new PdfPCell(new Phrase(PdfInvoiceExport.postage,new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setBorder(14);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Page "+cpt+"/"+total,new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		c.setHorizontalAlignment(Element.ALIGN_RIGHT);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c.setBorder(Rectangle.NO_BORDER);
		c.setColspan(3);
		table.addCell(c);

		c= new PdfPCell(new Phrase(""));
		c.setColspan(8);
		c.setBorder(Rectangle.NO_BORDER);
		c.setFixedHeight(c.getFixedHeight()+10);
		table.addCell(c);

		c= new PdfPCell(new Phrase("N°",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Qty",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Un",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Wording",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Ind",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Product Code",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);


		c= new PdfPCell(new Phrase("Unit Price",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		c= new PdfPCell(new Phrase("Amount NP",new Font(FontFamily.HELVETICA, 6, Font.NORMAL)));
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(c);

		try {
			document.add(table);
		} 
		catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onEndPage(PdfWriter writer, Document document) {}
	
}