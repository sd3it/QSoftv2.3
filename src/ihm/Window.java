package ihm;


import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.filechooser.FileSystemView;

import database.ReadMargin;
import database.ReadSheet;

import jxl.Sheet;


@SuppressWarnings("serial")
public abstract class Window extends javax.swing.JFrame {
	
	protected static String nameTitle="QSoft 2.3";
	
	//static Workbook workbook=null;
	protected static Sheet sheet;
	protected static Sheet marginsheet;
	protected static File file, file2;
	protected static ReadSheet database;
	protected static ReadMargin marginbase;
	protected static double discount=0;
	protected static double quotationprice=0;
	protected static double pprice=0;
	protected static double pdiscount=0;
	protected static double umargin=0;
	protected static double quotmargin=0;
	protected static double buyprice=0;
	protected static double totalbuyprice=0;
	protected static double exprofit=0;
	protected static double profit=0;
	protected static boolean margin=false;
	protected static boolean purchase = false;
	protected static boolean pricelist=false;
	protected static boolean printDiscount=false;
	public static String parents=FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	protected static Screen2 screen2;
	protected static ArrayList<String> productslist;
	
	protected static ArrayList<Object> index = new ArrayList<Object>();
	protected static ArrayList<String> description= new ArrayList<String>();
	protected static ArrayList<String> price= new ArrayList<String>();
	public static ArrayList<String> reference= new ArrayList<String>();
	public static ArrayList<String> quantity= new ArrayList<String>();
	protected static ArrayList<String> totalyprice= new ArrayList<String>();
	protected static ArrayList<String> discountprod = new ArrayList<String>();
	protected static ArrayList<String> achat= new ArrayList<String>();
	protected static ArrayList<Object> kp= new ArrayList<Object>();
	
	protected static DecimalFormat df = new DecimalFormat ("#,###,###,###,###.##") ; 
	
	protected boolean button2=true;
	protected static boolean transport=false;
	protected static boolean refund=false;
	protected static boolean dataload=false;
	protected static String date="";
	protected static String from="";
	protected static String to="";
	protected static String object="";
	protected static String payment="";
	protected static String incoterm="";
	protected static String salesman="";
	protected static String carriagecompany="";
	protected static String tel="";
	protected static String fax="";
	protected static String email="";
	public static String referencequot="";
	protected static String gsm="";
	protected static String remarks="";
	protected static String recipientname="";
	protected static boolean text=false;
	protected static boolean image=true;
	protected static double transportval=0.0;
	protected static double assistance=0.0;
	protected static boolean jcheckb1=false;
	protected static boolean jcheckb2=true;
	protected static boolean jcheckb3=false;
	protected static String printermailer="";
	
	protected static String POnumorder="";
	protected static String POpayment="";
	protected static String POincoterm="";
	protected static String POdeliveryTerms="";
	
	protected static String referencepro="";
	protected static String address="";
	protected static String postcode="";
	protected static String location="";
	protected static String deliveryaddress="";
	protected static String deliverypostcode="";
	protected static String deliverylocation="";
	protected static String customer="";
	
	protected static String companyname="";
	protected static String companyaddress="";
	protected static String companypostcode="";
	protected static String companytown="";
	protected static String companycountry="";
	protected static String conpanytel="";
	protected static String conpanyemail="";
	protected static String conpanyfax="";
	protected static String conpanycomment="";
	
	protected static Boolean save=false;
	
	protected static String s_label5, s_label4, s_button1, s_button2, s_labelPO, s_labelPO2; 
	protected static Locale locale; 
	protected static ResourceBundle res;
	
	protected static double patotal;

	protected static String deliveryaddress2;
}
