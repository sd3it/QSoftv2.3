package ihm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class DataImport extends Window{

	private static final long serialVersionUID = 1L;
	private static Sheet sheet1=null;
	private static int row=0;

	public void importe() throws IndexOutOfBoundsException, BiffException, IOException {
		try{
			JFileChooser chooser;
			chooser = new JFileChooser(parents){

				private static final long serialVersionUID = 1L;

				@Override
				public void approveSelection(){
					File f = new File(getSelectedFile().getAbsolutePath());
					if(f.exists()){
						parents=f.getParent();
						super.approveSelection();
					}
				}
			};

			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Data File (.data)","data");
			chooser.setFileFilter(filter);

			int returnVal=chooser.showOpenDialog(null);
			
			if(returnVal==JFileChooser.APPROVE_OPTION) {
				dataload=true;
				
				try {
					index=new ArrayList<Object>();
					description= new ArrayList<String>();
					price= new ArrayList<String>();
					reference= new ArrayList<String>();
					quantity= new ArrayList<String>();
					discountprod= new ArrayList<String>();
					totalyprice= new ArrayList<String>();
					achat= new ArrayList<String>();
					kp= new ArrayList<Object>();
					
					WorkbookSettings ws=new WorkbookSettings();
					ws.setSuppressWarnings(true);
					sheet1=Workbook.getWorkbook(chooser.getSelectedFile(),ws).getSheet(0);

					row=0;
					buyprice=0;
					
					if(sheet1.getRows()-1 != 0){
						while(row <= sheet1.getRows()-1){
							for(int column=0; column<=8 ;column++){
								if(column==0){
									index.add(sheet1.getCell(column, row).getContents());
								}
								if(column==1){
									reference.add(sheet1.getCell(column, row).getContents());
								}
								if(column==2){
									description.add(sheet1.getCell(column, row).getContents());
								}
								if(column==3){
									quantity.add(sheet1.getCell(column, row).getContents());
								}
								if(column==4){
									price.add(sheet1.getCell(column, row).getContents());
								}
								if(column==5){
									discountprod.add(sheet1.getCell(column, row).getContents());
								}
								if(column==6){
									totalyprice.add(sheet1.getCell(column,row ).getContents());
									
									if(!sheet1.getCell(column,row ).getContents().isEmpty()){
										quotationprice+=Double.parseDouble(sheet1.getCell(column,row ).getContents());
									}

									if(!sheet1.getCell(1, row).getContents().isEmpty()){
										if(margin){
											//Modif erreur le 13/09/2013 à surveiller
											//kp.add(Double.parseDouble(sheet1.getCell(4, row).getContents())/Double.parseDouble(marginbase.readMargin(sheet1.getCell(1, row).getContents())));
											buyprice+=Double.parseDouble(marginbase.readMargin(sheet1.getCell(1, row).getContents()))*Double.parseDouble(sheet1.getCell(3, row).getContents());	
											//System.out.println("Buyprice : " + buyprice);
										}
									}
									else {
										kp.add(null);
									}
								}
								if(column==7){
									achat.add(sheet1.getCell(column, row).getContents());
								}
								if(column==8){
									kp.add(sheet1.getCell(column, row).getContents());
								}
							}
							row+=1;
						}
					}
					if(!sheet1.getCell(9,0 ).getContents().isEmpty()){
						quotationprice=Double.parseDouble(sheet1.getCell(9,0 ).getContents());
					}
					
					if(!sheet1.getCell(10,0 ).getContents().isEmpty()){
						discount=Double.parseDouble(sheet1.getCell(10,0 ).getContents());
						if(discount!=0){
							refund=true;
						}
					}
					else {
						discount=0;
					}
					
					if(!sheet1.getCell(11,0 ).getContents().isEmpty()){
						transportval=Double.parseDouble(sheet1.getCell(11,0 ).getContents());
					}
					else{
						transportval=0;
					}
					
					if(!sheet1.getCell(12,0 ).getContents().isEmpty()){
						assistance=Double.parseDouble(sheet1.getCell(12,0 ).getContents());
					}
					else{
						assistance=0;
					}

					if(!sheet1.getCell(13,0 ).getContents().isEmpty()){
						from=sheet1.getCell(13,0 ).getContents();
					}
					else{
						from="";
					}
											
					if(!sheet1.getCell(14,0 ).getContents().isEmpty()){
						to=sheet1.getCell(14,0 ).getContents();
					}
					else{
						to="";
					}
					
					if(!sheet1.getCell(15,0 ).getContents().isEmpty()){
						referencequot=sheet1.getCell(15,0 ).getContents();
					}
					else{ 
						referencequot="";
					}
					
					if(!sheet1.getCell(16,0 ).getContents().isEmpty()){
						object=sheet1.getCell(16,0 ).getContents();
					}
					else{ 
						object="";
					}
					
					if(!sheet1.getCell(17,0 ).getContents().isEmpty()){
						payment=sheet1.getCell(17,0 ).getContents();
					}
					else{
						payment="";
					}
					
					if(!sheet1.getCell(18,0 ).getContents().isEmpty()){
						incoterm=sheet1.getCell(18,0 ).getContents();
					}
					else{
						incoterm="";
					}
					
					if(!sheet1.getCell(19,0 ).getContents().isEmpty()){
						recipientname=sheet1.getCell(19,0 ).getContents();
					}
					else{
						recipientname="";
					}
					
					if(!sheet1.getCell(20,0 ).getContents().isEmpty()){
						deliveryaddress=sheet1.getCell(20,0 ).getContents();
					}
					else{
						deliveryaddress="";
					}
					
					if(!sheet1.getCell(21,0 ).getContents().isEmpty()){
						deliverypostcode=sheet1.getCell(21,0 ).getContents();
					}
					else{
						deliverypostcode="";
					}
					
					if(!sheet1.getCell(22,0 ).getContents().isEmpty()){
						deliverylocation=sheet1.getCell(22,0 ).getContents();
					}
					else{
						deliverylocation="";
					}
					
					if(!sheet1.getCell(23,0 ).getContents().isEmpty()){
						address=sheet1.getCell(23,0 ).getContents();
					}
					else{
						address="";
					}
					
					if(!sheet1.getCell(24,0 ).getContents().isEmpty()){
						postcode=sheet1.getCell(24,0 ).getContents();
					}
					else{
						postcode="";
					}
					
					if(!sheet1.getCell(25,0 ).getContents().isEmpty()){
						location=sheet1.getCell(25,0 ).getContents();
					}
					else{
						location="";
					}
					
					if(!sheet1.getCell(26,0 ).getContents().isEmpty()){
						totalbuyprice=Double.parseDouble(sheet1.getCell(26,0 ).getContents());
						System.out.println("Total PA = " + totalbuyprice + " " + buyprice);
					}
					else{
						totalbuyprice=0;
					}
					
					if(!sheet1.getCell(27,0 ).getContents().isEmpty()){
						exprofit=Double.parseDouble(sheet1.getCell(27,0 ).getContents());
						System.out.println("Profit Import = " + exprofit);
					}
					else{
						exprofit=0;
					}
					
					salesman="";
					gsm="";
					tel="";
					fax="";
					email="";
				}
				catch (Exception e) {}
			}
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e); 
		}
	}
}