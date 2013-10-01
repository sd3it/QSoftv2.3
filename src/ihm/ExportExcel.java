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
import javax.swing.filechooser.FileSystemView;

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

public class ExportExcel extends Window{

	private static final long serialVersionUID = 1L;

	public void export() throws IOException, WriteException{

		boolean exist=false;
		
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
			
			chooser.setSelectedFile(new File("quotation "+new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			int returnVal=chooser.showSaveDialog(null);
			
			if(returnVal==JFileChooser.APPROVE_OPTION){
				WritableWorkbook workbook;
				
				if(chooser.getSelectedFile().getAbsolutePath().endsWith(".xls"))
					workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath()));
				else 
					workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath()+".xls"));
				
				WritableSheet sheet = workbook.createSheet("Quotation", 0);
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
								label2 = new Label(j,i+9, price.get(i).replace(".", ","), arial10format); 
								sheet.addCell(label2);
							}
							if(j==5){
								label2 = new Label(j,i+9, totalyprice.get(i).replace(".", ","), totalformat); 
								sheet.addCell(label2);
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
				label2 = new Label(5,row, df.format(quotationprice).replaceAll(",", " ")+" €", arial10format); 
				sheet.addCell(label2);
				
				if(refund){
					row=sheet.getRows();
					sheet.mergeCells(0, row , 4, row);
					label2 = new Label(0,row, "SPECIAL DISCOUNT ("+df.format(discount)+")", titleformat); 
					sheet.addCell(label2);
					label2 = new Label(5,row, df.format(quotationprice*discount/100).replaceAll(",", " ")+" €", arial10format); 
					sheet.addCell(label2);
					row=sheet.getRows();
					sheet.mergeCells(0, row , 4, row);
					label2 = new Label(0,row, "TOTAL in EUROS with SPECIAL DISCOUNT", titleformat); 
					sheet.addCell(label2);
					label2 = new Label(5,row, df.format((quotationprice-quotationprice*discount/100)).replaceAll(",", " ")+" €", arial10format); 
					sheet.addCell(label2);
				}
				if(transport){
					row=sheet.getRows();
					sheet.mergeCells(0, row , 4, row);
					label2 = new Label(0,row, "TRANSPORT COST", titleformat); 
					sheet.addCell(label2);
					label2 = new Label(5,row, df.format(transportval).replaceAll(",", " ")+" €", arial10format); 
					sheet.addCell(label2);
					row=sheet.getRows();
					sheet.mergeCells(0, row , 4, row);
					label2 = new Label(0,row, "TOTAL WITH TRANSPORT in EUROS", titleformat); 
					sheet.addCell(label2);
					label2 = new Label(5,row, df.format((quotationprice-quotationprice*discount/100)+transportval).replaceAll(",", " ")+" €", arial10format); 
					sheet.addCell(label2);
				}
				if(assistance!=0){
					row=sheet.getRows();
					sheet.mergeCells(0, row , 4, row);
					label2 = new Label(0,row, "ASSISTANCE COST", titleformat); 
					sheet.addCell(label2);
					label2 = new Label(5,row, df.format(assistance).replaceAll(",", " ")+" €", arial10format); 
					sheet.addCell(label2);
					row=sheet.getRows();
					sheet.mergeCells(0, row , 4, row);
					label2 = new Label(0,row, "TOTAL WITH ASSISTANCE in EUROS", titleformat); 
					sheet.addCell(label2);
					label2 = new Label(5,row, df.format((quotationprice-quotationprice*discount/100)+transportval+assistance).replaceAll(",", " ")+" €", arial10format); 
					sheet.addCell(label2);
				}
				
				workbook.write(); 
				workbook.close(); 	
				
				WritableSheet sheet1;
		        Workbook workbook1;
		        WritableWorkbook wwork;
		        @SuppressWarnings("unused")
				WritableCell cell;
		        
		            try {
		            	if(!new File("./Summary offers.xls").exists()){
		            		WritableWorkbook wworkbook;
		    				
		    				wworkbook = Workbook.createWorkbook(new File("./Summary offers.xls"));
		    				
		    				WritableSheet wsheet = wworkbook.createSheet("Savedata", 0);
		    				WritableFont titrefont1 = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD); 
		    				
		    				wsheet.setColumnView(0, 20);
		    				wsheet.setColumnView(1, 40);
		    				wsheet.setColumnView(2, 30);
		    				wsheet.setColumnView(3, 40);
		    				wsheet.setColumnView(4, 30);
		    				wsheet.setColumnView(5, 50);
		    				wsheet.setColumnView(6, 25);
		    				wsheet.setColumnView(7, 25);
		    				
		    				WritableCellFormat format = new WritableCellFormat (titrefont1);
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
		            	}
		            	
		                workbook1 = Workbook.getWorkbook(new File("./Summary offers.xls"));
		                wwork = Workbook.createWorkbook(new File("./Summary offers.xls"), workbook1);
		                sheet1 = wwork.getSheet(0);
		                Window.df.setMaximumFractionDigits(2);
		                Window.df.setMinimumFractionDigits(2);
		                exist=false;
		                
		                for(int k=0;k<=sheet1.getRows()-1;k++){
		                	if(sheet1.getCell(0, k).getContents().equals(new SimpleDateFormat("dd/MM/yyyy").format(new Date())) && sheet1.getCell(1, k).getContents().equals(Window.referencequot) && sheet1.getCell(2, k).getContents().equals(Window.from) && sheet1.getCell(3, k).getContents().equals(Window.to) && sheet1.getCell(4, k).getContents().equals(Window.salesman+" "+Window.gsm)&&sheet1.getCell(5, k).getContents().equals(Window.object) &&sheet1.getCell(6, k).getContents().equals(Window.df.format(Window.buyprice))&&sheet1.getCell(7, k).getContents().equals(Window.df.format(Window.quotationprice)))
		                		exist=true;
		                }
		                if(!exist){
		                	Label label = null;
		                	int row1=sheet1.getRows();
		                
		                	for(int i=0;i<=7;i++){
		                		cell = sheet1.getWritableCell(i, sheet1.getRows());
		                		if(i==0)
		                			label = new Label(i, row1, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		                		if(i==1)
		                			label = new Label(i, row1, Window.referencequot);
		                		if(i==2)
		                			label = new Label(i, row1, Window.from);
		                		if(i==3)
		                			label = new Label(i, row1, Window.to);
		                		if(i==4)
		                			label = new Label(i, row1, Window.salesman+" "+Window.gsm);
		                		if(i==5)
		                			label = new Label(i, row1, Window.object);
		                		if(i==6)
		                			label = new Label(i, row1, Window.df.format(Window.buyprice));
		                		if(i==7)
		                			label = new Label(i, row1, Window.df.format(Window.quotationprice));
		                		
		                		sheet1.addCell(label); 
		                	}
		                }
		                wwork.write(); 
		                wwork.close(); 
		            }
		            catch (Exception e) {
						System.out.println(e);
					}

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
			javax.swing.JOptionPane.showMessageDialog(null,"The file has been saved in "+Window.printermailer);
		}
	}
}