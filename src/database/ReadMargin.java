package database;

import java.util.StringTokenizer;

import jxl.Cell;
import jxl.Sheet;

public class ReadMargin {

	private Sheet marginfile;
	private Cell margincell;

	public ReadMargin(Sheet marginfile) {
		super();
		this.marginfile = marginfile;
	}

	public boolean isMarginList(){
		try{
			boolean marginlist=false; 
			boolean find=false;
			int row=0;
			Cell ctmp = null;
		
			while(!find && row<=marginfile.getRows()-1){
				if(marginfile.getCell(0, row).getContents().contentEquals(("Reference")))
				{
					ctmp=marginfile.findCell("Reference");
					find=true;
				}
				row+=1;
			}
		
			if(find){
				try{
					int column=2;	// 3eme colonne 
					
					while(!marginfile.getCell(column,ctmp.getRow()).getContents().contains("PP") && column<=marginfile.getColumns()-1)
					{
						column+=1;
					}
					//Si la 3e colonne contient la chaine de caractères "PP", alors c'est une purchasing price list
					if(marginfile.getCell(column,ctmp.getRow()).getContents().contains("PP")){
						marginlist=true;
						margincell=marginfile.getCell(2,ctmp.getRow());
					}
				}
				catch (Exception e) {}
			}
			return marginlist;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public String readMargin(String word){
		String umargin = null;
		boolean find=false;
		int row=0;
		Cell ctmp = null;

		try{
			while(!find && row<=marginfile.getRows()-1){
				if(marginfile.getCell(0, row).getContents().contains((word)))
				{
					ctmp=marginfile.getCell(margincell.getColumn(), row);
					find=true;
				}
				row+=1;
			}
			umargin=marginfile.getCell(margincell.getColumn(), ctmp.getRow()).getContents();
			try{
				StringTokenizer st=new StringTokenizer(umargin);
				if(umargin.contains(",")){
					umargin=umargin.replace(",", ".");
				}
				umargin=st.nextToken();
			
				Double.parseDouble(umargin);
				return umargin;
			}
			catch(Exception g){
				return "";
			}
		}
		catch (Exception e) {
			return "";
		}
	}
}
