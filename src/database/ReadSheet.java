package database;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.text.Style;

import jxl.Cell;
import jxl.Sheet;
import jxl.format.Font;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.biff.StyleXFRecord;

public class ReadSheet {

	private Sheet pricelist;
	private static ArrayList<String> products =null;
	private static byte[] streamBytes = null;
	private int pricecolumn=0;

	public byte[] getStreamBytes() {
		return streamBytes;
	}

	public void setStreamBytes(byte[] streamBytes) {
		this.streamBytes = streamBytes;
	}

	public ReadSheet(Sheet pricelist) {
		super();
		this.pricelist = pricelist;
		//this.products=this.readProducts(pricelist);
		pricecolumn=0;
	}

	public boolean isPriceList(Sheet sheet){
		try{
			boolean pricelist=false; 
			boolean find=false;
			int row=0;
			Cell ctmp = null;
			while(!find && row<=sheet.getRows()-1){
				if(sheet.getCell(0, row).getContents().contentEquals(("Reference")))
				{
					ctmp=sheet.findCell("Reference");
					find=true;
				}
				row+=1;
			}
			if(find){
				if(sheet.getCell(ctmp.getColumn()+1,ctmp.getRow()).getContents().contentEquals("Description")){
					if(sheet.getCell(ctmp.getColumn()+2,ctmp.getRow()).getContents().contains("PRICE")||sheet.getCell(ctmp.getColumn()+3,ctmp.getRow()).getContents().contains("PRICE")){
						pricelist=true;
					}
				}
			}

			try{
				int column=1;
				while(!sheet.getCell(column,ctmp.getRow()).getContents().contains("NET PRICE")&&column<=sheet.getColumns()-1)
				{
					pricecolumn=column+1;	
					column+=1;
				}	
			}
			catch (Exception e) {
				pricecolumn=0;
			}

		/*if(sheet.getCell(ctmp.getColumn()+2,ctmp.getRow()).getContents().contains("NET PRICE"))pricecolumn=ctmp.getColumn()+2;
			if(sheet.getCell(ctmp.getColumn()+3,ctmp.getRow()).getContents().contains("NET PRICE"))pricecolumn=ctmp.getColumn()+3;
			if(sheet.getCell(ctmp.getColumn()+3,ctmp.getRow()).getContents().contains("NET PRICE"))pricecolumn=ctmp.getColumn()+3;
		 */
			return pricelist;
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e);
			return false;
		}
	}

	public ArrayList<String> readProducts(Sheet sheet){
		try{
			Cell ctmp;
			ArrayList<String> altmp = new ArrayList<String>();
			
			for (int row=0;row<=sheet.getRows()-1;row++){
				ctmp = sheet.getCell(0, row);
				if(ctmp.getContents()!= ""){
					if(ctmp.getCellFormat().getFont().getBoldWeight()!=700 && ctmp.getContents()!= "")
					{
						if(ctmp.getContents().contains(" or ")){
							altmp.add(ctmp.getContents().substring(0, ctmp.getContents().indexOf(" or")));
							altmp.add(ctmp.getContents().substring(ctmp.getContents().indexOf(" or")+4,ctmp.getContents().length() ).trim());
						}	
						else 
							altmp.add(ctmp.getContents());
					}
				}
			}
			this.products=altmp;
			return altmp;
		}
		catch (Exception e) {
	
			javax.swing.JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

	public String readDescription(String word){
		try{
			String description = null;
			boolean find=false;
			int row=0;

			do{
				if(pricelist.getCell(0, row).getContents().contains(word))
				{

					//System.out.println(pricelist.getCell(0, row).getCellFormat().getFont().getScriptStyle());
					description=pricelist.getCell(1, row).getContents();

					streamBytes=pricelist.getCell(1, row).getContents().getBytes();
					
					StringTokenizer st= new StringTokenizer(description);
					find=true;

				}
				row+=1;
			}while(!find);
		
			return description;
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e);
			return "";
		}
	}

	public String readPice(String word){
		try{
			String uprice = null;
			boolean find=false;
			int row=0;
			
			while(!find){
				if(pricelist.getCell(0, row).getContents().contains(word))
				{
					if(pricecolumn==0){
						uprice=pricelist.getCell(2, row).getContents();
						System.out.println(uprice);
						find=true;
					}
					else{
						uprice=pricelist.getCell(2, row).getContents();
						System.out.println(uprice);
						find=true;
					}
				}
				row+=1;
			}

			try{
				StringTokenizer st=new StringTokenizer(uprice);
				//if(uprice.contains(",")){
				//	uprice=uprice.replace(",", ".");
				//}
				uprice=st.nextToken();
	
				int pos = uprice.length()-2;
				if(pos>0){
					if(uprice.substring(pos-1, pos).contains(","))uprice=uprice.substring(0, pos-1)+uprice.substring(pos-1, pos).replace(",", ".")+uprice.substring(pos, uprice.length());
						uprice=uprice.replaceAll(",", "");
				}
				Double.parseDouble(uprice);
			
				return uprice;
			}
			catch(Exception g){
				System.out.println(g);
				return "0.00";
			}
		}
		catch (Exception e) {	
			javax.swing.JOptionPane.showMessageDialog(null,e);
			return "";
		}
	}

	public ListModel readSearch(String word){
		try{
			DefaultListModel search = new DefaultListModel();

			for(int i=0;i<this.products.size();i++){
				if(this.products.get(i).startsWith(word.toLowerCase())||this.products.get(i).startsWith(word.toUpperCase()))
				{
					search.addElement(products.get(i));
					//System.out.println(products.get(i));
				}
			}
			return search;
		}
		catch (Exception e) {
	
			javax.swing.JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

	public Sheet getPricelist() {
		return pricelist;
	}

	public void setPricelist(Sheet pricelist) {
		this.pricelist = pricelist;
	}

	public ArrayList<String> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}
}