package ihm;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DataExport extends Window {

	private static final long serialVersionUID = 1L;
	
	public void getValuesFromOtherClass(){
		Screen2 sc2 = new Screen2();
	}

	public void export() throws IOException{
		getValuesFromOtherClass();
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
			
					if(getSelectedFile().getAbsolutePath().endsWith(".data")){
						f=new File(getSelectedFile().getAbsolutePath());
					}
					else { 
						f=new File(getSelectedFile().getAbsolutePath()+".data");
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
						if (answer != JOptionPane.OK_OPTION){
							return;
						}
					}
					super.approveSelection();
				}
			};
			
			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Data file (.data)","data");
			chooser.setFileFilter(filter);

			chooser.setSelectedFile(new File("quotation " + new SimpleDateFormat("dd.MM.yyyy").format(new Date())));
			
			int returnVal=chooser.showSaveDialog(null);
		
			if(returnVal==JFileChooser.APPROVE_OPTION){
				try { 
					WritableWorkbook workbook;
		
					if(chooser.getSelectedFile().getAbsolutePath().endsWith(".data")){
						workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath())); 
					}
					else {
						workbook = Workbook.createWorkbook(new File(chooser.getSelectedFile().getAbsolutePath() + ".data")); 
					}
					
					WritableSheet sheet = workbook.createSheet("Premier classeur", 0); 
					workbook.setProtected(true);
					sheet.setProtected(true);
					Label label = null;

					//Crée un label а la ligne 0, colonne 0 avec le format spécifique 
					for(int row=0;row<=reference.size()-1;row++){
						if(margin==true){
							for(int column=0;column<=8;column++){
								if(column==0){
									label = new Label(column, row, index.get(row).toString());
								}
								if(column==1){
									label = new Label(column, row, reference.get(row));
									System.out.println("ref = " + reference.get(row));
								}	
								if(column==2){
									label = new Label(column, row, description.get(row));
								}
								if(column==3){
									label = new Label(column, row, quantity.get(row));
								}
								if(column==4){
									label = new Label(column, row,price.get(row));
								}
								if(column==5){
									label = new Label(column, row, discountprod.get(row));
								}
								if(column==6){
									label = new Label(column, row, totalyprice.get(row));
								}
								if(column==7){
									label = new Label(column, row, achat.get(row));
								}
								if(column==8){
									label = new Label(column, row, kp.get(row).toString());
								}
	
								//Ajout des cellules 
								sheet.addCell(label);
							}	
						}
						else if(margin==false){
							for(int column=0;column<=6;column++){
								if(column==0){
									label = new Label(column, row, index.get(row).toString());
								}
								if(column==1){
									label = new Label(column, row, reference.get(row));
									System.out.println("ref = " + reference.get(row));
								}	
								if(column==2){
									label = new Label(column, row, description.get(row));
								}
								if(column==3){
									label = new Label(column, row, quantity.get(row));
								}
								if(column==4){
									label = new Label(column, row,price.get(row));
								}
								if(column==5){
									label = new Label(column, row, discountprod.get(row));
								}
								if(column==6){
									label = new Label(column, row, totalyprice.get(row));
								}
		
								//Ajout des cellules 
								sheet.addCell(label);
							}
						}
					}
					/*
					label = new Label(9, 0, df.format(quotationprice)); 
					sheet.addCell(label);
					System.out.println("Pv total : " + df.format(quotationprice));
					*/
					label = new Label(9, 0, quotationprice+""); 
					sheet.addCell(label);
					System.out.println("Pv total : " + quotationprice);
					
					label = new Label(10, 0, df.format(discount)); 
					sheet.addCell(label); 

					label = new Label(11, 0, df.format(transportval)); 
					sheet.addCell(label); 

					label = new Label(12, 0, df.format(assistance)); 
					sheet.addCell(label);
					
					label = new Label(13, 0, from); 
					sheet.addCell(label);					

					label = new Label(14, 0, to); 
					sheet.addCell(label);	

					label = new Label(15, 0, referencequot); 
					sheet.addCell(label);

					label = new Label(16, 0, object); 
					sheet.addCell(label);

					label = new Label(17, 0, payment); 
					sheet.addCell(label);

					label = new Label(18, 0, incoterm); 
					sheet.addCell(label);
						
					label = new Label(19, 0, recipientname); 
					sheet.addCell(label);
					
					label = new Label(20, 0, deliveryaddress); 
					sheet.addCell(label);
					
					label = new Label(21, 0, deliverypostcode); 
					sheet.addCell(label);
					
					label = new Label(22, 0, deliverylocation); 
					sheet.addCell(label);
					
					label = new Label(23, 0, address); 
					sheet.addCell(label);
					
					label = new Label(24, 0, postcode); 
					sheet.addCell(label);
					
					label = new Label(25, 0, location); 
					sheet.addCell(label);
					
					label = new Label(26, 0, df.format(totalbuyprice));
					sheet.addCell(label);
					System.out.println("PA total : " + df.format(totalbuyprice));
					
					exprofit=(((quotationprice - totalbuyprice)/quotationprice)*100);
					label = new Label(27, 0, df.format(exprofit));
					sheet.addCell(label);
					System.out.println("Profit total : " + exprofit);

					//Ecriture et fermeture du classeur 
					workbook.write(); 
					workbook.close(); 
					save=true;			
				} 
				catch (RowsExceededException e1) { 
					e1.printStackTrace(); 
				} 
				catch (WriteException e1) { 
					e1.printStackTrace(); 
				} 
				catch (IOException e) { 
					e.printStackTrace(); 
				}
				finally {} 
			}
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e);
			e.printStackTrace();
		}
	}
}