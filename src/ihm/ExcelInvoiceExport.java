package ihm;


import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelInvoiceExport extends Window {
	
	private static final long serialVersionUID = 1L;
	
	int cpt=0;

	public void export() {
		try{
			df.setMaximumFractionDigits(2);
			df.setMinimumFractionDigits(2);
			Locale.setDefault(Locale.ENGLISH);
			
			try {  
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
			catch (Exception e){}
			
			JFileChooser chooser = new JFileChooser(parents){

				private static final long serialVersionUID = 1L;

				@Override
				public void approveSelection(){
					File f = null;
					
					if(getSelectedFile().getAbsolutePath().endsWith(".xls"))
						f=new File(getSelectedFile().getAbsolutePath());
					else 
						f=new File(getSelectedFile().getAbsolutePath()+".xls");
					
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
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel (.xls)","xls");
			
			chooser.setFileFilter(filter);
			
			if(customer.isEmpty())
				chooser.setSelectedFile(new File("proforma_"+new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			else
				chooser.setSelectedFile(new File("proforma_"+customer+"_"+new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			
			int returnVal=chooser.showSaveDialog(null);
			
			if(returnVal==JFileChooser.APPROVE_OPTION)
			{
				WritableWorkbook workbook;
				
				if(chooser.getSelectedFile().getAbsolutePath().endsWith(".xls"))
					workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath()));
				else 
					workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath()+".xls"));
				
				WritableSheet sheet = workbook.createSheet("Proforma", 0);
				WritableFont titrefont = new WritableFont(WritableFont.ARIAL, 8,WritableFont.BOLD); 
				WritableFont titrefont1 = new WritableFont(WritableFont.ARIAL, 8,WritableFont.NO_BOLD); 
				WritableFont datafont = new WritableFont(WritableFont.ARIAL, 5,WritableFont.BOLD);
				
				WritableCellFormat titreformat1 = new WritableCellFormat (titrefont);
				titreformat1.setBackground(Colour.WHITE);
				titreformat1.setAlignment(Alignment.CENTRE);
				titreformat1.setVerticalAlignment(VerticalAlignment.CENTRE);
				titreformat1.setOrientation(Orientation.HORIZONTAL);
				titreformat1.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				titreformat1.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				titreformat1.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				titreformat1.setShrinkToFit(true);
				titreformat1.setWrap(true);

				WritableCellFormat titreformat2 = new WritableCellFormat (titrefont1);
				titreformat2.setBackground(Colour.WHITE);
				titreformat2.setAlignment(Alignment.CENTRE);
				titreformat2.setVerticalAlignment(VerticalAlignment.CENTRE);
				titreformat2.setOrientation(Orientation.HORIZONTAL);
				titreformat2.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				titreformat2.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				titreformat2.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				titreformat2.setShrinkToFit(true);
				titreformat2.setWrap(true);

				WritableCellFormat titreformat3 = new WritableCellFormat (titrefont);
				titreformat3.setBackground(Colour.WHITE);
				titreformat3.setAlignment(Alignment.CENTRE);
				titreformat3.setVerticalAlignment(VerticalAlignment.CENTRE);
				titreformat3.setOrientation(Orientation.HORIZONTAL);
				titreformat3.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				titreformat3.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				titreformat3.setShrinkToFit(true);
				titreformat3.setWrap(true);
				
				WritableCellFormat specialtitreformat = new WritableCellFormat (titrefont);
				specialtitreformat.setBackground(Colour.WHITE);
				specialtitreformat.setAlignment(Alignment.LEFT);
				specialtitreformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				specialtitreformat.setOrientation(Orientation.HORIZONTAL);
				specialtitreformat.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				specialtitreformat.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				specialtitreformat.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				specialtitreformat.setShrinkToFit(true);
				specialtitreformat.setWrap(true);
				
				WritableCellFormat dataformat = new WritableCellFormat (titrefont1);
				dataformat.setBackground(Colour.WHITE);
				dataformat.setAlignment(Alignment.CENTRE);
				dataformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				dataformat.setOrientation(Orientation.HORIZONTAL);
				dataformat.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat.setShrinkToFit(true);
				dataformat.setWrap(true);
				
				WritableCellFormat dataformat1 = new WritableCellFormat (datafont);
				dataformat1.setBackground(Colour.WHITE);
				dataformat1.setAlignment(Alignment.LEFT);
				dataformat1.setVerticalAlignment(VerticalAlignment.CENTRE);
				dataformat1.setOrientation(Orientation.HORIZONTAL);
				dataformat1.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat1.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat1.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				dataformat1.setShrinkToFit(true);
				dataformat1.setWrap(true);

				WritableCellFormat dataformat2 = new WritableCellFormat (datafont);
				dataformat2.setBackground(Colour.WHITE);
				dataformat2.setAlignment(Alignment.LEFT);
				dataformat2.setVerticalAlignment(VerticalAlignment.CENTRE);
				dataformat2.setOrientation(Orientation.HORIZONTAL);
				dataformat2.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat2.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat2.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				dataformat2.setShrinkToFit(true);
				dataformat2.setWrap(true);

				WritableCellFormat dataformat3 = new WritableCellFormat (datafont);
				dataformat3.setBackground(Colour.WHITE);
				dataformat3.setAlignment(Alignment.LEFT);
				dataformat3.setVerticalAlignment(VerticalAlignment.CENTRE);
				dataformat3.setOrientation(Orientation.HORIZONTAL);
				dataformat3.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat3.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				dataformat3.setShrinkToFit(true);
				dataformat3.setWrap(true);

				sheet.setColumnView(0, 9);
				sheet.setColumnView(1, 9);
				sheet.setColumnView(2, 9);
				sheet.setColumnView(3, 37);
				sheet.setColumnView(4, 11);
				sheet.setColumnView(5, 26);
				sheet.setColumnView(5, 15);
				sheet.setColumnView(5, 15);

				sheet.addImage(new WritableImage(0, 0, 2.5,6, new File("logo.png")));

				sheet.mergeCells(0, 6 , 2, 6);
				Label label = new Label(0,6, "DATE", titreformat1); 
				sheet.addCell(label);

				sheet.mergeCells(0, 7 , 2, 7);
				label = new Label(0,7,date, titreformat2); 
				sheet.addCell(label);

				sheet.mergeCells(0, 8 , 2, 8);
				label = new Label(0,8, "REFERENCE", titreformat1); 
				sheet.addCell(label);

				sheet.mergeCells(0, 9 , 2, 9);
				label = new Label(0,9, "", titreformat3); 
				sheet.addCell(label);

				sheet.mergeCells(0, 10 , 2, 10);
				label = new Label(0,10, referencepro, titreformat2); 
				sheet.addCell(label);

				sheet.mergeCells(0, 11 , 2, 11);
				label = new Label(0,11, "CARRIAGE COMPANY", titreformat1); 
				sheet.addCell(label);

				sheet.mergeCells(0, 12 , 2, 12);
				label = new Label(0,12, payment, titreformat2); 
				sheet.addCell(label);

				label = new Label(3,6, "", titreformat1); 
				sheet.addCell(label);

				label = new Label(3,7, "", titreformat2); 
				sheet.addCell(label);

				label = new Label(3,8, "", titreformat1); 
				sheet.addCell(label);

				label = new Label(3,9, "PROFORMA INVOICE", titreformat3); 
				sheet.addCell(label);

				label = new Label(3,10, "", titreformat2); 
				sheet.addCell(label);

				label = new Label(3,11, "POSTAGE", titreformat1); 
				sheet.addCell(label);

				label = new Label(3,12, incoterm, titreformat2); 
				sheet.addCell(label);

				sheet.mergeCells(5, 6 , 7, 6);
				label = new Label(5,6, "INVOICING ADDRESS", specialtitreformat); 
				sheet.addCell(label);

				sheet.mergeCells(5, 7 , 7, 7);
				label = new Label(5,7, "", titreformat3); 
				sheet.addCell(label);

				sheet.mergeCells(5, 8 , 7, 8);
				label = new Label(5,8, customer, dataformat); 
				sheet.addCell(label);

				sheet.mergeCells(5, 9 , 7, 9);
				label = new Label(5,9, address, dataformat); 
				sheet.addCell(label);

				sheet.mergeCells(5, 10 , 7, 10);
				label = new Label(5,10, postcode+ " - "+location, dataformat); 
				sheet.addCell(label);

				sheet.mergeCells(5, 11 , 7, 11);
				label = new Label(5,11, "", titreformat2); 
				sheet.addCell(label);

				WritableCellFormat classicformat = new WritableCellFormat (titrefont1);
				classicformat.setBackground(Colour.WHITE);
				classicformat.setAlignment(Alignment.CENTRE);
				classicformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				classicformat.setOrientation(Orientation.HORIZONTAL);
				classicformat.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				classicformat.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				classicformat.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				classicformat.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				classicformat.setShrinkToFit(true);
				classicformat.setWrap(true);
				
				WritableCellFormat descriptionformat = new WritableCellFormat (titrefont1);
				descriptionformat.setBackground(Colour.WHITE);
				descriptionformat.setAlignment(Alignment.GENERAL);
				descriptionformat.setVerticalAlignment(VerticalAlignment.BOTTOM);
				descriptionformat.setOrientation(Orientation.HORIZONTAL);
				descriptionformat.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				descriptionformat.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				descriptionformat.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				descriptionformat.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				descriptionformat.setShrinkToFit(true);
				descriptionformat.setWrap(true);

				label = new Label(0,14, "N°", classicformat); 
				sheet.addCell(label);

				label = new Label(1,14, "Qty", classicformat); 
				sheet.addCell(label);

				label = new Label(2,14, "Un", classicformat); 
				sheet.addCell(label);

				label = new Label(3,14, "Wording", classicformat); 
				sheet.addCell(label);

				label = new Label(4,14, "Ind", classicformat); 
				sheet.addCell(label);

				label = new Label(5,14, "Product Code", classicformat); 
				sheet.addCell(label);

				label = new Label(6,14, "Unit Price", classicformat); 
				sheet.addCell(label);

				label = new Label(7,14, "Amount NP", classicformat); 
				sheet.addCell(label);
				
				cpt=0;
				int tabrow=0;
				
				for(int i=0;i<=Window.reference.size()-1;i++){
					if(!reference.get(i).isEmpty()&& !index.get(i).toString().isEmpty()){
						cpt++;
						tabrow=sheet.getRows();
						
						for(int j=0;j<=7;j++){
							if(j==0){
								label = new Label(j,tabrow, Integer.toString(cpt), classicformat); 
								sheet.addCell(label);
							}
							if(j==1){
								label = new Label(j,tabrow, quantity.get(i), classicformat); 
								sheet.addCell(label);
							}
							if(j==2){
								label = new Label(j,tabrow, "U", classicformat); 
								sheet.addCell(label);
							}
							if(j==3){
								label = new Label(j,tabrow,description.get(i), descriptionformat); 
								sheet.addCell(label);
							}
							if(j==4){
								label = new Label(j,tabrow,"-" , classicformat); 
								sheet.addCell(label);
							}
							if(j==5){
								label = new Label(j,tabrow, reference.get(i), classicformat); 
								sheet.addCell(label);
							}
							if(j==6){
								label = new Label(j,tabrow, price.get(i)+" €", classicformat); 
								sheet.addCell(label);
							}
							if(j==7){
								label = new Label(j,tabrow, totalyprice.get(i)+" €", classicformat); 
								sheet.addCell(label);
							}
						}
					}
				}
				
				if(transportval!=0){
					tabrow=sheet.getRows();
					label = new Label(0,tabrow, Integer.toString(cpt++), classicformat); 
					sheet.addCell(label);
					label = new Label(1,tabrow, "1", classicformat); 
					sheet.addCell(label);
					label = new Label(2,tabrow, "U", classicformat); 
					sheet.addCell(label);
					label = new Label(3,tabrow, "-", classicformat); 
					sheet.addCell(label);
					label = new Label(4,tabrow, "-", classicformat); 
					sheet.addCell(label);
					label = new Label(5,tabrow, "TRANSPORT COST", classicformat); 
					sheet.addCell(label);
					label = new Label(6,tabrow, transportval+" €", classicformat); 
					sheet.addCell(label);
					label = new Label(7,tabrow, transportval+" €", classicformat); 
					sheet.addCell(label);
				}
				if(Window.assistance!=0){
					tabrow=sheet.getRows();
					label = new Label(0,tabrow, Integer.toString(cpt++), classicformat); 
					sheet.addCell(label);
					label = new Label(1,tabrow, "1", classicformat); 
					sheet.addCell(label);
					label = new Label(2,tabrow, "U", classicformat); 
					sheet.addCell(label);
					label = new Label(3,tabrow, "-", classicformat); 
					sheet.addCell(label);
					label = new Label(4,tabrow, "-", classicformat); 
					sheet.addCell(label);
					label = new Label(5,tabrow, "ASSISTANCE COST", classicformat); 
					sheet.addCell(label);
					label = new Label(6,tabrow, assistance+" €", classicformat); 
					sheet.addCell(label);
					label = new Label(7,tabrow, assistance+" €", classicformat); 
					sheet.addCell(label);
				}
				
				WritableFont sentencefont = new WritableFont(WritableFont.ARIAL, 6,WritableFont.BOLD);
				
				WritableCellFormat sentence1format = new WritableCellFormat (sentencefont);
				sentence1format.setBackground(Colour.WHITE);
				sentence1format.setAlignment(Alignment.CENTRE);
				sentence1format.setVerticalAlignment(VerticalAlignment.BOTTOM);
				sentence1format.setOrientation(Orientation.HORIZONTAL);
				sentence1format.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				sentence1format.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				sentence1format.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				sentence1format.setShrinkToFit(true);
				sentence1format.setWrap(true);
				
				WritableCellFormat sentence2format = new WritableCellFormat (sentencefont);
				sentence2format.setBackground(Colour.WHITE);
				sentence2format.setAlignment(Alignment.CENTRE);
				sentence2format.setVerticalAlignment(VerticalAlignment.TOP);
				sentence2format.setOrientation(Orientation.HORIZONTAL);
				sentence2format.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				sentence2format.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				sentence2format.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				sentence2format.setShrinkToFit(true);
				sentence2format.setWrap(true);
				
				WritableFont totalfont = new WritableFont(WritableFont.ARIAL, 8,WritableFont.BOLD);
				WritableCellFormat totalformat = new WritableCellFormat (totalfont);
				totalformat.setBackground(Colour.WHITE);
				totalformat.setAlignment(Alignment.CENTRE);
				totalformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				totalformat.setOrientation(Orientation.HORIZONTAL);
				totalformat.setBorder(Border.RIGHT, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setShrinkToFit(true);
				totalformat.setWrap(true);
				
				int row=sheet.getRows();
				label = new Label(0,row, "", classicformat); 
				sheet.addCell(label);

				label = new Label(1,row, "", classicformat); 
				sheet.addCell(label);

				label = new Label(2,row, "", classicformat); 
				sheet.addCell(label);

				sheet.mergeCells(3, row , 5, row);
				label = new Label(3,row, "The export of the product covered by this document declares that, expect where otherwise cleary indicated, these", sentence1format); 
				sheet.addCell(label);

				label = new Label(6,row, "", classicformat); 
				sheet.addCell(label);

				label = new Label(7,row, "", classicformat); 
				sheet.addCell(label);

				row+=1;

				label = new Label(0,row, "", classicformat); 
				sheet.addCell(label);

				label = new Label(1,row, "", classicformat); 
				sheet.addCell(label);

				label = new Label(2,row, "", classicformat); 
				sheet.addCell(label);

				sheet.mergeCells(3, row , 5, row);
				label = new Label(3,row, "products are of France preferential origin.", sentence2format); 
				sheet.addCell(label);

				label = new Label(6,row, "", classicformat); 
				sheet.addCell(label);

				label = new Label(7,row, "", classicformat); 
				sheet.addCell(label);

				row+=1;
				sheet.mergeCells(0, row , 7, row);
				label = new Label(0,row, "0% discount for the anticipated payment and transfert of ownership at the end of the payment",new WritableCellFormat (new WritableFont(WritableFont.ARIAL, 6,WritableFont.NO_BOLD))); 
				sheet.addCell(label);

				row+=1;
				sheet.mergeCells(0, row , 3, row);
				label = new Label(0,row, "",classicformat); 
				sheet.addCell(label);

				label = new Label(5,row, "Total Net Price",classicformat); 
				sheet.addCell(label);

				label = new Label(6,row, "",classicformat); 
				sheet.addCell(label);

				label = new Label(7,row, df.format(quotationprice+transportval+assistance)+" €",classicformat); 
				sheet.addCell(label);

				row+=1;
				if(Window.discount!=0){
					sheet.mergeCells(0, row , 3, row+2);
				}
				else 
					sheet.mergeCells(0, row , 3, row+1);
				
				label = new Label(0,row, "",classicformat); 
				sheet.addCell(label);

				label = new Label(5,row, "Total VAT",classicformat); 
				sheet.addCell(label);

				label = new Label(6,row, "",classicformat); 
				sheet.addCell(label);

				label = new Label(7,row, "0,00 €",classicformat); 
				sheet.addCell(label);
				
				if(Window.discount!=0){
					row+=1;
					label = new Label(5,row, "Discount on product(s)",classicformat); 
					sheet.addCell(label);

					label = new Label(6,row, "",classicformat); 
					sheet.addCell(label);

					label = new Label(7,row, discount+" %",classicformat); 
					sheet.addCell(label);
				}

				row+=1;
				label = new Label(5,row, "Total IN EURO",totalformat); 
				sheet.addCell(label);

				label = new Label(6,row, "",classicformat); 
				sheet.addCell(label);

				label = new Label(7,row, df.format(quotationprice-(quotationprice*discount/100)+transportval+assistance)+" €",totalformat); 
				sheet.addCell(label);

				row+=2;
				sheet.mergeCells(0, row , 3, row);
				label = new Label(0,row, companyname+" - "+companyaddress+" - "+companypostcode+" "+companytown+" - "+companycountry,dataformat1); 
				sheet.addCell(label);

				sheet.mergeCells(5, row , 7, row+2);
				label = new Label(5,row, "",classicformat); 
				sheet.addCell(label);

				row+=1;
				sheet.mergeCells(0, row , 3, row);
				label = new Label(0,row, "Phone N°: "+conpanytel+" - Fax: "+conpanyfax+" - Email: "+conpanyemail,dataformat3); 
				sheet.addCell(label);

				row+=1;
				sheet.mergeCells(0, row , 3, row);
				label = new Label(0,row, conpanycomment,dataformat2); 
				sheet.addCell(label);

				workbook.write(); 
				workbook.close(); 	
				
				if(chooser.getSelectedFile().getAbsolutePath().endsWith(".xls"))
					Window.printermailer=chooser.getSelectedFile().getAbsolutePath();
				else 
					Window.printermailer=chooser.getSelectedFile().getAbsolutePath()+".xls";
				
				if ( Desktop.isDesktopSupported() ) {
    	    		// On récupère l'instance du desktop :
    	    		Desktop desktop = Desktop.getDesktop();

    	    		// On vérifie que la fonction open est bien supportée :
    	    		if (desktop.isSupported(Desktop.Action.OPEN)) {

    	    			if(chooser.getSelectedFile().getAbsolutePath().endsWith(".xls"))
    	    				desktop.open(new File(chooser.getSelectedFile().getAbsolutePath()));
    	    			else 
    	    				desktop.open(new File(chooser.getSelectedFile().getAbsolutePath()+".xls"));
    	    		}
    	    	}
			}
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e); 
		}
	}
}