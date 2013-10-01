package database;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Product {
	
	private float unitprice;
	private String name;
	private String description;
	private float refund=0;
	private float quantity=1;
	private float productprice;

	
	public Product(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public float getUnitprice() {
		return unitprice;
	}

	public void setUnitprix(float unitprix) {
		this.unitprice = unitprix;
	}

	public String getDescription() {
		return description;
	}

	public float getRefund() {
		return refund;
	}

	public void setRefund(float refund) {
		this.refund = refund;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getProductprice() {
		return productprice;
	}

	public void setProductprice(float productprice) {
		this.productprice = productprice;
	}

	public float calculProductPrice(){
		return unitprice*quantity-(unitprice*quantity*refund/100);
	}
	
	public float calculUnitPrice(){
		return unitprice-(unitprice*refund/100);
	}

}
