package database;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import jxl.Cell;
import jxl.Sheet;

public class ReadNamelist {

	private Sheet datalist;
	private static ArrayList<String> names = null;
	private static byte[] streamBytes = null;
	private int pricecolumn = 0;

	public byte[] getStreamBytes() {
		return streamBytes;
	}

	public void setStreamBytes(byte[] streamBytes) {
		this.streamBytes = streamBytes;
	}

	public ReadNamelist(Sheet namelist) {
		super();
		this.datalist = namelist;
		pricecolumn = 0;
	}

	/*
	 * Methode pour savoir si la feuille est une NameList ou pas
	 */
	public boolean isNameList(Sheet sheet) {
		try {
			boolean namelist = false;
			boolean find = false;
			int row = 0;
			Cell ctmp = null;
			
			while (!find && row <= sheet.getRows() - 1) {
				if (sheet.getCell(2, row).getContents()
						.contentEquals(("Nom"))) {
					ctmp = sheet.findCell("Nom");
					find = true;
				}
				row += 1;
			}
			
			if (find) {
				if (sheet.getCell(ctmp.getColumn() + 1, ctmp.getRow())
						.getContents().contentEquals("Rue1")) {
					if (sheet.getCell(ctmp.getColumn() + 2, ctmp.getRow())
							.getContents().contains("Rue2")
							|| sheet.getCell(ctmp.getColumn() + 3,
									ctmp.getRow()).getContents()
									.contains("Rue2")) {
						namelist = true;
					}
				}
			}

			try {
				int column = 1;
				while (!sheet.getCell(column, ctmp.getRow()).getContents()
						.contains("Rue2")
						&& column <= sheet.getColumns() - 1) {
					pricecolumn = column + 1;
					column += 1;
				}
			} catch (Exception e) {
				pricecolumn = 0;
			}

			return namelist;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}

	public ArrayList<String> readDatabase(Sheet sheet) {
		try {
			Cell ctmp;
			ArrayList<String> altmp = new ArrayList<String>();

			for (int row = 0; row <= sheet.getRows() - 1; row++) {
				
				ctmp = sheet.getCell(0, row);
				
				if (ctmp.getContents() != "") {
					
					if (ctmp.getCellFormat().getFont().getBoldWeight() != 700 && ctmp.getContents() != "") {
						
						if (ctmp.getContents().contains(" or ")) {
							
							altmp.add(ctmp.getContents().substring(0, ctmp.getContents().indexOf(" or")));
							altmp.add(ctmp.getContents().substring(
											ctmp.getContents().indexOf(" or") + 4,
											ctmp.getContents().length()).trim());
							
						} else {
							altmp.add(ctmp.getContents());
						}
					}
				}
			}
			
			this.names = altmp;
			return altmp;
			
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

	public String readCompany(String word) {
		try {
			String company = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					company = datalist.getCell(2, row).getContents();

					streamBytes = datalist.getCell(2, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(company);
					find = true;

				}
				row += 1;
			} while (!find);

			return company;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readDelAddress(String word) {
		try {
			String delAddress = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					delAddress = datalist.getCell(11, row).getContents();

					streamBytes = datalist.getCell(11, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(delAddress);
					find = true;

				}
				row += 1;
			} while (!find);

			return delAddress;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}
	
	public String readDelAddress2(String word) {
		try {
			String delAddress2 = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					delAddress2 = datalist.getCell(12, row).getContents();

					streamBytes = datalist.getCell(12, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(delAddress2);
					find = true;

				}
				row += 1;
			} while (!find);

			return delAddress2;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readDelPostcode(String word) {
		try {
			String delPostcode = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					delPostcode = datalist.getCell(13, row).getContents();

					streamBytes = datalist.getCell(13, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(delPostcode);
					find = true;

				}
				row += 1;
			} while (!find);

			return delPostcode;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readDelTown(String word) {
		try {
			String delTown = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					delTown = datalist.getCell(14, row).getContents();

					streamBytes = datalist.getCell(14, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(delTown);
					find = true;

				}
				row += 1;
			} while (!find);

			return delTown;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}
	
	public String readDelCountry(String word) {
		try {
			String delCountry = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					delCountry = datalist.getCell(15, row).getContents();

					streamBytes = datalist.getCell(15, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(delCountry);
					find = true;

				}
				row += 1;
			} while (!find);

			return delCountry;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readInvAddress(String word) {
		try {
			String invAddress = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					invAddress = datalist.getCell(3, row).getContents();

					streamBytes = datalist.getCell(3, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(invAddress);
					find = true;

				}
				row += 1;
			} while (!find);

			return invAddress;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}
	
	public String readInvAddress2(String word) {
		try {
			String invAddress2 = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					invAddress2 = datalist.getCell(4, row).getContents();

					streamBytes = datalist.getCell(4, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(invAddress2);
					find = true;

				}
				row += 1;
			} while (!find);

			return invAddress2;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readInvPostcode(String word) {
		try {
			String invPostcode = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					invPostcode = datalist.getCell(6, row).getContents();

					streamBytes = datalist.getCell(6, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(invPostcode);
					find = true;

				}
				row += 1;
			} while (!find);

			return invPostcode;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readInvTown(String word) {
		try {
			String invTown = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					invTown = datalist.getCell(7, row).getContents();

					streamBytes = datalist.getCell(7, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(invTown);
					find = true;

				}
				row += 1;
			} while (!find);

			return invTown;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}
	
	public String readInvCountry(String word) {
		try {
			String invCountry = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					invCountry = datalist.getCell(8, row).getContents();

					streamBytes = datalist.getCell(8, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(invCountry);
					find = true;

				}
				row += 1;
			} while (!find);

			return invCountry;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readPaymentReglement(String word) {
		try {
			String payment = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					payment = datalist.getCell(28, row).getContents();

					streamBytes = datalist.getCell(28, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(payment);
					find = true;

				}
				row += 1;
			} while (!find);

			return payment;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}
	
	public String readPaymentEcheance(String word) {
		try {
			String payment = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					payment = datalist.getCell(21, row).getContents();

					streamBytes = datalist.getCell(21, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(payment);
					find = true;

				}
				row += 1;
			} while (!find);

			return payment;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public String readIncoterm(String word) {
		try {
			String incoterm = null;
			boolean find = false;
			int row = 0;

			do {
				if (datalist.getCell(0, row).getContents().contains(word)) {

					incoterm = datalist.getCell(20, row).getContents();

					streamBytes = datalist.getCell(20, row).getContents()
							.getBytes();

					StringTokenizer st = new StringTokenizer(incoterm);
					find = true;

				}
				row += 1;
			} while (!find);

			return incoterm;
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, e);
			return "";
		}
	}

	public ListModel readSearch(String word) {
		try {
			DefaultListModel search = new DefaultListModel();

			for (int i = 0; i < this.names.size(); i++) {
				if (this.names.get(i).startsWith(word.toLowerCase())
						|| this.names.get(i).startsWith(word.toUpperCase())) {
					search.addElement(names.get(i));
				}
			}
			return search;
		} catch (Exception e) {

			javax.swing.JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

	public Sheet getPricelist() {
		return datalist;
	}

	public void setPricelist(Sheet pricelist) {
		this.datalist = pricelist;
	}

	public ArrayList<String> getProducts() {
		return names;
	}

	public void setProducts(ArrayList<String> products) {
		this.names = products;
	}
}