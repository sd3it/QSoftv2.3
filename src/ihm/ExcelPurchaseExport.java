package ihm;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelPurchaseExport extends Window{

	private static final long serialVersionUID = 1L;

	public void export() throws IOException, WriteException{

		boolean exist=false;
		double total = 0;
		
		try {
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
			
			chooser.setSelectedFile(new File("SD3_PurchaseOrder_" + new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			int returnVal=chooser.showSaveDialog(null);
			
			if(returnVal==JFileChooser.APPROVE_OPTION){
				WritableWorkbook workbook;
				
				if(chooser.getSelectedFile().getAbsolutePath().endsWith(".xls"))
					workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath()));
				else 
					workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath()+".xls"));
				
				WritableSheet sheet = workbook.createSheet("SD3 PurchaseOrder", 0);
				WritableFont titrefont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD); 
				WritableFont basicfont = new WritableFont(WritableFont.ARIAL, 8,WritableFont.NO_BOLD); 
				WritableFont datefont = new WritableFont(WritableFont.ARIAL, 10,WritableFont.NO_BOLD); 
				WritableFont datafont = new WritableFont(WritableFont.ARIAL, 6,WritableFont.NO_BOLD); 
				
				sheet.setColumnView(0, 11);
				sheet.setColumnView(1, 21);
				sheet.setColumnView(2, 37);
				sheet.setColumnView(3, 11);
				sheet.setColumnView(4, 15);
				sheet.setColumnView(5, 15);

				sheet.setRowView(2, 2100);
				
				sheet.addImage(new WritableImage(2, 2, 1,1, new File("logo.png")));
				
				WritableCellFormat dateformat = new WritableCellFormat (datefont);
				dateformat.setBackground(Colour.WHITE);
				dateformat.setAlignment(Alignment.CENTRE);
				dateformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				dateformat.setOrientation(Orientation.HORIZONTAL);
				dateformat.setBorder(Border.RIGHT, BorderLineStyle.HAIR,Colour.BLACK);
				dateformat.setBorder(Border.BOTTOM, BorderLineStyle.HAIR,Colour.BLACK);
				dateformat.setBorder(Border.LEFT, BorderLineStyle.HAIR,Colour.BLACK);
				dateformat.setBorder(Border.TOP, BorderLineStyle.HAIR,Colour.BLACK);
				dateformat.setShrinkToFit(true);
				dateformat.setWrap(true);
				
				WritableCellFormat dataformat = new WritableCellFormat (datafont);
				dataformat.setBackground(Colour.WHITE);
				dataformat.setAlignment(Alignment.CENTRE);
				dataformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				dataformat.setOrientation(Orientation.HORIZONTAL);
				dataformat.setShrinkToFit(true);
				dataformat.setWrap(true);
				
				Label label2 = new Label(5,1, new SimpleDateFormat("dd/MM/yyyy").format(new Date())); 
				sheet.addCell(label2);
				
				sheet.mergeCells(0, 3 , 5, 3);
				label2 = new Label(0,3,companyname+ ": "+companyaddress+ " - "+companypostcode+" "+companytown+" - "+companycountry, dataformat); 
				sheet.addCell(label2);
				sheet.mergeCells(0, 4 , 5, 4);
				label2 = new Label(0,4,"Tel: "+conpanytel+ " - Fax: "+conpanyfax+" - Email: "+conpanyemail , dataformat); 
				sheet.addCell(label2);
				
				WritableCellFormat arial10format = new WritableCellFormat (titrefont);
				arial10format.setBackground(Colour.GREY_25_PERCENT);
				arial10format.setAlignment(Alignment.CENTRE);
				arial10format.setVerticalAlignment(VerticalAlignment.CENTRE);
				arial10format.setOrientation(Orientation.HORIZONTAL);
				arial10format.setBorder(Border.ALL, BorderLineStyle.MEDIUM,Colour.BLACK);
				arial10format.setShrinkToFit(true);
				arial10format.setWrap(true);

				label2 = new Label(0,8, "Index", arial10format); 
				sheet.addCell(label2);
				label2 = new Label(1,8, "Code", arial10format); 
				sheet.addCell(label2);
				label2 = new Label(2,8, "Description", arial10format); 
				sheet.addCell(label2);
				label2 = new Label(3,8, "Qty", arial10format); 
				sheet.addCell(label2);
				label2 = new Label(4,8, "Unit net price in Euro", arial10format); 
				sheet.addCell(label2);
				label2 = new Label(5,8, "Total price in euro", arial10format); 
				sheet.addCell(label2);

				arial10format = new WritableCellFormat (basicfont);
				arial10format.setBackground(Colour.WHITE);
				arial10format.setAlignment(Alignment.CENTRE);
				arial10format.setVerticalAlignment(VerticalAlignment.CENTRE);
				arial10format.setOrientation(Orientation.HORIZONTAL);
				arial10format.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.AUTOMATIC);
				arial10format.setShrinkToFit(true);
				arial10format.setWrap(true);

				WritableCellFormat indexformat = new WritableCellFormat (basicfont);
				indexformat.setBackground(Colour.WHITE);
				indexformat.setAlignment(Alignment.CENTRE);
				indexformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				indexformat.setOrientation(Orientation.HORIZONTAL);
				indexformat.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.AUTOMATIC);
				indexformat.setBorder(Border.LEFT, BorderLineStyle.MEDIUM,Colour.BLACK);
				indexformat.setShrinkToFit(true);
				indexformat.setWrap(true);

				WritableCellFormat descriptionformat = new WritableCellFormat (basicfont);
				descriptionformat.setBackground(Colour.WHITE);
				descriptionformat.setAlignment(Alignment.GENERAL);
				descriptionformat.setVerticalAlignment(VerticalAlignment.BOTTOM);
				descriptionformat.setOrientation(Orientation.HORIZONTAL);
				descriptionformat.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.AUTOMATIC);
				descriptionformat.setShrinkToFit(true);
				descriptionformat.setWrap(true);

				WritableCellFormat totalformat = new WritableCellFormat (basicfont);
				totalformat.setBackground(Colour.WHITE);
				totalformat.setAlignment(Alignment.CENTRE);
				totalformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				totalformat.setOrientation(Orientation.HORIZONTAL);
				totalformat.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM,Colour.BLACK);
				totalformat.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setBorder(Border.LEFT, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setShrinkToFit(true);
				totalformat.setWrap(true);

				WritableCellFormat titleformat = new WritableCellFormat (titrefont);
				titleformat.setBackground(Colour.TURQUOISE);
				titleformat.setAlignment(Alignment.CENTRE);
				titleformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				titleformat.setOrientation(Orientation.HORIZONTAL);
				titleformat.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM,Colour.BLACK);
				titleformat.setBorder(Border.LEFT, BorderLineStyle.MEDIUM,Colour.BLACK);
				totalformat.setBorder(Border.BOTTOM, BorderLineStyle.THIN,Colour.BLACK);
				totalformat.setBorder(Border.TOP, BorderLineStyle.THIN,Colour.BLACK);
				titleformat.setShrinkToFit(true);
				titleformat.setWrap(true);
				
				for(int i=0;i<=Window.reference.size()-1;i++){

					if(reference.get(i).isEmpty()&& !index.get(i).toString().isEmpty()){
						sheet.mergeCells(1, i+9 , 5, i+9);
						label2 = new Label(0,i+9, index.get(i).toString(), indexformat); 
						sheet.addCell(label2);
						label2 = new Label(1,i+9, description.get(i), totalformat); 
						sheet.addCell(label2);
					}
					if(reference.get(i).isEmpty()&& index.get(i).toString().isEmpty()){
						sheet.mergeCells(0, i+9 , 5, i+9);
						label2 = new Label(0,i+9, description.get(i), titleformat); 
						sheet.addCell(label2);
					}
					if(!reference.get(i).isEmpty()&& !index.get(i).toString().isEmpty()){
						for(int j=0;j<=5;j++){

							if(j==0){
								label2 = new Label(j,i+9, index.get(i).toString(), indexformat); 
								sheet.addCell(label2);
							}
							if(j==1){
								label2 = new Label(j,i+9, reference.get(i), arial10format); 
								sheet.addCell(label2);
							}
							if(j==2){
								label2 = new Label(j,i+9, description.get(i), descriptionformat); 
								sheet.addCell(label2);
							}
							if(j==3){
								label2 = new Label(j,i+9,quantity.get(i), arial10format); 
								sheet.addCell(label2);
							}
							if(j==4){
								label2 = new Label(j,i+9, Window.marginbase.readMargin(Window.reference.get(i)).replace(".", ","), arial10format); 
								sheet.addCell(label2);
							}
							if(j==5){
								total=Double.parseDouble(Window.marginbase.readMargin(Window.reference.get(i)))*Double.parseDouble(Window.quantity.get(i));
								label2 = new Label(j,i+9, Window.df.format(total).replace(".", ","), totalformat); 
								sheet.addCell(label2);
								quotationprice+=total;
								Window.patotal=quotationprice;
								System.out.println("var patotal = " + patotal);
							}
						}
					}
				}
				titleformat = new WritableCellFormat (titrefont);
				titleformat.setBackground(Colour.YELLOW);
				titleformat.setAlignment(Alignment.CENTRE);
				titleformat.setVerticalAlignment(VerticalAlignment.CENTRE);
				titleformat.setOrientation(Orientation.HORIZONTAL);
				titleformat.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM,Colour.BLACK);
				titleformat.setBorder(Border.LEFT, BorderLineStyle.MEDIUM,Colour.BLACK);
				titleformat.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM,Colour.BLACK);
				titleformat.setBorder(Border.TOP, BorderLineStyle.MEDIUM,Colour.BLACK);
				titleformat.setShrinkToFit(true);
				titleformat.setWrap(true);
				
				arial10format = new WritableCellFormat (basicfont);
				arial10format.setBackground(Colour.WHITE);
				arial10format.setAlignment(Alignment.CENTRE);
				arial10format.setVerticalAlignment(VerticalAlignment.CENTRE);
				arial10format.setOrientation(Orientation.HORIZONTAL);
				arial10format.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM,Colour.BLACK);
				arial10format.setBorder(Border.LEFT, BorderLineStyle.MEDIUM,Colour.BLACK);
				arial10format.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM,Colour.BLACK);
				arial10format.setBorder(Border.TOP, BorderLineStyle.MEDIUM,Colour.BLACK);
				arial10format.setShrinkToFit(true);
				arial10format.setWrap(true);
				
				int row=sheet.getRows();
				sheet.mergeCells(0, row , 4, row);
				label2 = new Label(0,row, "TOTAL in EUROS", titleformat); 
				sheet.addCell(label2);
				label2 = new Label(5,row, df.format(patotal).replaceAll(",", " ")+" €", arial10format); 
				sheet.addCell(label2);
				
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
			//javax.swing.JOptionPane.showMessageDialog(null,e); 
			javax.swing.JOptionPane.showMessageDialog(null,"The file has been saved in " + Window.printermailer);
		}
	}
}