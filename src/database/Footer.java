package database;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class Footer extends PdfPageEventHelper {
	//String header;
	//int pagenumber=1;
	//PdfTemplate total;
	// BaseFont helv;
	int total;

	public void settotal(int total){
		this.total=total;	
	}

	/*
	 public void setHeader(String header) {
            this.header = header;
        }

	 public void onEndPage(PdfWriter writer, Document document) {
            PdfPTable table = new PdfPTable(3);
            try {
                table.setWidths(new int[]{24, 24, 2});
                table.setTotalWidth(527);
                table.setLockedWidth(true);
                table.getDefaultCell().setFixedHeight(20);
                table.getDefaultCell().setBorder(Rectangle.BOTTOM);
                table.addCell(header);
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(String.format("Page %d of", writer.getPageNumber()));
                PdfPCell cell = new PdfPCell(Image.getInstance(total));
                cell.setBorder(Rectangle.BOTTOM);
                table.addCell(cell);
                table.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
            }
            catch(DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }


	 public void onOpenDocument(PdfWriter writer, Document document) {
            total = writer.getDirectContent().createTemplate(30, 16);
        }

	 */



	/*	Font FONT = new Font(FontFamily.HELVETICA, 52, Font.BOLD, new GrayColor(0.75f));

	public void onEndPage(PdfWriter writer, Document document) {
		ColumnText.showTextAligned(writer.getDirectContentUnder(),
				Element.ALIGN_CENTER, new Phrase("FOOBAR FILM FESTIVAL", FONT),
				297.5f, 421, writer.getPageNumber() % 2 == 1 ? 45 : -45);
	}


	 */



	/*	 public void onOpenDocument(PdfWriter writer, Document document) {
		  total = writer.getDirectContent().createTemplate(100, 100);
		    total.setBoundingBox(new Rectangle(-20, -20, 100, 100));
		    try {
		        helv = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
		    } catch (DocumentException e) {
		    //    LOG.error(e.getMessage(), e);
		        // TODO : gérer l'exception.
		    } catch (IOException e) {
		    //    LOG.error(e.getMessage(), e);
		        // TODO : gérer l'exception.
		    }
     }

	 public void onStartPage(PdfWriter writer, Document document) {
         pagenumber++;
     }
	 */	 
	public void onEndPage(PdfWriter writer, Document document) {
		/*
		// LOG.info("Generation des numeros de page ...");
		    final PdfContentByte directcontent = writer.getDirectContent();

		    directcontent.saveState();
		    final String text = "Page " + writer.getPageNumber()+ " of ";
		    final float textBase = document.bottom() - 20;
		    final float textSize = helv.getWidthPoint(text, 12);

		    directcontent.beginText();
		    directcontent.setFontAndSize(helv, 11);

		    // Ecriture du numero de page a gauche pour les pages impaires.
		    if ((writer.getPageNumber() % 2) == 1) {
		        directcontent.setTextMatrix(document.left(), textBase);
		        directcontent.showText(text);
		        directcontent.endText();
		        directcontent.addTemplate(total, document.left() + textSize, textBase);
		    } else {
		        // Ecriture du numero de page a droite pour les pages paires.
		        final float adjust = helv.getWidthPoint("0", 12);
		        directcontent.setTextMatrix(document.right() - textSize - adjust, textBase);
		        directcontent.showText(text);
		        directcontent.endText();
		        directcontent.addTemplate(total, document.right() - adjust, textBase);
		   }
		    directcontent.restoreState();
		 */
		Rectangle rect = writer.getBoxSize("art");

		ColumnText.showTextAligned(writer.getDirectContent(),
				Element.ALIGN_CENTER, new Phrase(String.format("Page %d of %d", writer.getCurrentPageNumber()+1,total),new Font(FontFamily.HELVETICA, 8, Font.NORMAL)),
				/* (rect.getLeft() + rect.getRight()) / 2,*/rect.getRight()-document.rightMargin(), rect.getBottom()-25, 0);

		/*     int pageNumber = writer.getPageNumber() ;
	       String text = "Page " + pageNumber  ;
	       Rectangle page = document.getPageSize();
	       PdfPTable structure = new PdfPTable (1);
	       structure.addCell(new Paragraph(text));
	       structure.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
	       structure.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(), writer.getDirectContent());
		 */
	}
}