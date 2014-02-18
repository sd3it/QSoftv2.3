package ihm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import jxl.Sheet;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import database.Footer;
import database.ReadNamelist;

public class PdfScreen extends JDialog {
	boolean exist = false;

	String parents = FileSystemView.getFileSystemView().getHomeDirectory()
			.getAbsolutePath();
	ReadNamelist databaseName;
	File file = null;
	private static boolean isList = false;
	String pathnameDatabase = "\\\\SERVEUR\\commercial\\CONTACTS\\DATABASE Clients QSOFT\\BDD-Clients SD3 Row.xls";
	String pathnameDBtestcreate = "\\\\SERVEUR\\commercial\\CONTACTS\\DATABASE Clients QSOFT\\BDD-Clients SD3 Row.xls";
	boolean isExist = false;

	private javax.swing.JButton jBt_print;
	private javax.swing.JButton jBt_load;
	private javax.swing.JButton jBt_addCustomer;
	private javax.swing.JButton jBt_reset;

	private javax.swing.JCheckBox jCb_Mrs;
	private javax.swing.JCheckBox jCb_Mr;
	private javax.swing.JCheckBox jCb_userData;
	private javax.swing.JCheckBox jCb_formDate1;
	private javax.swing.JCheckBox jCb_formDate2;
	private javax.swing.JCheckBox jCb_no;
	private javax.swing.JCheckBox jCb_sameAddr;

	private javax.swing.JLabel jLb_object;
	private javax.swing.JLabel jLb_incoterm;
	private javax.swing.JLabel jLb_payment;
	private javax.swing.JLabel jLb_indicationPayment;
	private javax.swing.JLabel jLb_firstName;
	private javax.swing.JLabel jLb_tel;
	private javax.swing.JLabel jLb_lastName;
	private javax.swing.JLabel jLb_fax;
	private javax.swing.JLabel jLb_mail;
	private javax.swing.JLabel jLb_recName;
	private javax.swing.JLabel jLb_ref;
	private javax.swing.JLabel jLb_delAddress;
	private javax.swing.JLabel jLb_delPostcode;
	private javax.swing.JLabel jLb_delTown;
	private javax.swing.JLabel jLb_invAddress;
	private javax.swing.JLabel jLb_invPostcode;
	private javax.swing.JLabel jLb_invTown;
	private javax.swing.JLabel jLb_date;
	private javax.swing.JLabel jLb_from;
	private javax.swing.JLabel jLb_to;
	private javax.swing.JLabel jLb_comment;
	private javax.swing.JLabel jLb_search;

	private javax.swing.JLayeredPane jLayeredPane1;

	private javax.swing.JTextField jTf_date;
	private javax.swing.JTextField jTf_payment;
	private javax.swing.JTextField jTf_incoterm;
	private javax.swing.JTextField jTf_firstName;
	private javax.swing.JTextField jTf_tel;
	private javax.swing.JTextField jTf_lastName;
	private javax.swing.JTextField jTf_fax;
	private javax.swing.JTextField jTf_mail;
	private javax.swing.JTextField jTf_ref;
	private javax.swing.JTextField jTf_delAddress;
	private javax.swing.JTextField jTf_delPostcode;
	private javax.swing.JTextField jTf_devTown;
	private javax.swing.JTextField jTf_invAddress;
	private javax.swing.JTextField jTf_invPostcode;
	private javax.swing.JTextField jTf_invTown;
	private javax.swing.JTextField jTf_from;
	private javax.swing.JTextField jTf_to;
	private javax.swing.JTextField jTf_object;
	private javax.swing.JTextField jTf_recName;
	private javax.swing.JTextField jTf_search;

	private static javax.swing.JTextArea jTa_comment;

	private javax.swing.JScrollPane scroll;
	private javax.swing.JScrollPane scrollList;

	private javax.swing.JList listName;

	public PdfScreen() {
		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			this.setTitle((String) Window.res.getObject("title_pdfExport"));
		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			this.setTitle((String) Window.res.getObject("title_pdfExport"));
		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			this.setTitle((String) Window.res.getObject("title_pdfExport"));
		}

		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setModal(true);
		initComponents();
		this.pack();
	}

	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();

		jLb_date = new javax.swing.JLabel();
		jTf_date = new javax.swing.JTextField();

		jLb_from = new javax.swing.JLabel();
		jTf_from = new javax.swing.JTextField();

		jLb_to = new javax.swing.JLabel();
		jTf_to = new javax.swing.JTextField();

		jLb_object = new javax.swing.JLabel();
		jTf_object = new javax.swing.JTextField();

		jLb_recName = new javax.swing.JLabel();
		jTf_recName = new javax.swing.JTextField();

		jLb_ref = new javax.swing.JLabel();
		jTf_ref = new javax.swing.JTextField();

		jCb_Mr = new javax.swing.JCheckBox();
		jCb_Mrs = new javax.swing.JCheckBox();
		jCb_no = new javax.swing.JCheckBox();

		jCb_formDate1 = new javax.swing.JCheckBox();
		jCb_formDate2 = new javax.swing.JCheckBox();

		jLb_payment = new javax.swing.JLabel();
		jTf_payment = new javax.swing.JTextField();
		jLb_indicationPayment = new javax.swing.JLabel();

		jLb_incoterm = new javax.swing.JLabel();
		jTf_incoterm = new javax.swing.JTextField();

		jLb_firstName = new javax.swing.JLabel();
		jTf_firstName = new javax.swing.JTextField();

		jLb_tel = new javax.swing.JLabel();
		jTf_tel = new javax.swing.JTextField();

		jLb_lastName = new javax.swing.JLabel();
		jTf_lastName = new javax.swing.JTextField();

		jLb_fax = new javax.swing.JLabel();
		jTf_fax = new javax.swing.JTextField();

		jLb_mail = new javax.swing.JLabel();
		jTf_mail = new javax.swing.JTextField();

		jCb_userData = new javax.swing.JCheckBox();
		jCb_sameAddr = new javax.swing.JCheckBox();

		jBt_print = new javax.swing.JButton();

		jLb_delAddress = new javax.swing.JLabel();
		// jTextField18 = new TextFieldLimit(19);
		jTf_delAddress = new javax.swing.JTextField();

		jLb_delPostcode = new javax.swing.JLabel();
		jTf_delPostcode = new javax.swing.JTextField();

		jLb_delTown = new javax.swing.JLabel();
		jTf_devTown = new javax.swing.JTextField();

		jLb_invAddress = new javax.swing.JLabel();
		// jTextField21 = new TextFieldLimit(19);
		jTf_invAddress = new javax.swing.JTextField();

		jLb_invPostcode = new javax.swing.JLabel();
		jTf_invPostcode = new javax.swing.JTextField();

		jLb_invTown = new javax.swing.JLabel();
		jTf_invTown = new javax.swing.JTextField();

		jLb_comment = new javax.swing.JLabel();
		jTa_comment = new JTextArea();
		scroll = new JScrollPane(jTa_comment);

		jLb_search = new javax.swing.JLabel();
		jTf_search = new javax.swing.JTextField();

		listName = new javax.swing.JList();
		scrollList = new JScrollPane(listName);

		jBt_load = new JButton(new ImageIcon("images/icons/database.png"));
		jBt_addCustomer = new JButton(new ImageIcon(
				"images/icons/addCustomer.png"));

		jBt_reset = new JButton();

		System.out.println("->" + Window.salesman);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		/************************************ ANGLAIS ******************************/
		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);

			jLb_date.setText((String) Window.res.getObject("lb_date"));
			jLb_date.setBounds(40, 20, 27, 20);

			jLb_from.setText((String) Window.res.getObject("lb_from"));
			jLb_from.setBounds(310, 75, 28, 20);

			jLb_to.setText((String) Window.res.getObject("lb_to"));
			jLb_to.setBounds(310, 105, 16, 20);

			jLb_ref.setText((String) Window.res.getObject("lb_ref"));
			jLb_ref.setBounds(310, 135, 60, 20);

			jLb_object.setText((String) Window.res.getObject("lb_object"));
			jLb_object.setBounds(10, 200, 50, 20);

			jLb_recName.setText((String) Window.res.getObject("lb_recName"));
			jLb_recName.setBounds(10, 230, 80, 20);

			jLb_payment.setText((String) Window.res.getObject("lb_payment"));
			jLb_payment.setBounds(10, 260, 70, 20);
			jTf_payment.setBounds(70, 260, 320, 20);
			jLb_indicationPayment.setText("[Mode of Payment] + [Nb days]");
			jLb_indicationPayment.setBounds(400, 260, 180, 20);

			jLb_incoterm.setText((String) Window.res.getObject("lb_incoterm"));
			jLb_incoterm.setBounds(10, 290, 47, 20);

			jLb_delAddress.setText((String) Window.res
					.getObject("lb_delivAddress"));
			jLb_delAddress.setBounds(10, 320, 120, 20);

			jLb_delPostcode.setText((String) Window.res
					.getObject("lb_delivPostcode"));
			jLb_delPostcode.setBounds(10, 350, 120, 20);

			jLb_delTown.setText((String) Window.res.getObject("lb_delivTown"));
			jLb_delTown.setBounds(10, 380, 120, 20);

			jLb_invAddress.setText((String) Window.res
					.getObject("lb_invoiceAddress"));
			jLb_invAddress.setBounds(10, 410, 160, 20);
			jTf_invAddress.setBounds(120, 410, 320, 20);

			jLb_invPostcode.setText((String) Window.res
					.getObject("lb_invoicePostcode"));
			jLb_invPostcode.setBounds(10, 440, 120, 20);

			jCb_sameAddr.setText((String) Window.res
					.getObject("cb_sameAddress"));
			jCb_sameAddr.setBounds(460, 440, 110, 20);

			jLb_invTown
					.setText((String) Window.res.getObject("lb_invoiceTown"));
			jLb_invTown.setBounds(10, 470, 120, 20);

			jLb_firstName
					.setText((String) Window.res.getObject("lb_firstName"));
			jLb_firstName.setBounds(10, 510, 60, 20);

			jLb_tel.setText((String) Window.res.getObject("lb_tel"));
			jLb_tel.setBounds(40, 570, 18, 20);

			jLb_lastName.setText((String) Window.res.getObject("lb_lastName"));
			jLb_lastName.setBounds(10, 540, 60, 20);

			jLb_fax.setText((String) Window.res.getObject("lb_fax"));
			jLb_fax.setBounds(40, 600, 22, 20);

			jLb_mail.setText((String) Window.res.getObject("lb_mail"));
			jLb_mail.setBounds(40, 630, 28, 20);

			jLb_comment.setText((String) Window.res.getObject("lb_comment"));
			jLb_comment.setBounds(10, 660, 70, 20);
			scroll.setBounds(70, 660, 280, 40);

			jCb_userData.setText((String) Window.res.getObject("cb_userData"));
			jCb_userData.setBounds(310, 510, 100, 23);

			jBt_print.setText((String) Window.res.getObject("bt_print"));
			jBt_print.setBounds(360, 580, 73, 23);

			jLb_search.setText((String) Window.res.getObject("lb_searchName"));
			jLb_search.setBounds(40, 50, 50, 20);

			jBt_load.setToolTipText((String) Window.res.getObject("bt_loadDB"));
			jBt_load.setBounds(25, 110, 39, 39);
			jBt_load.setBackground(new java.awt.Color(255, 255, 255));

			jBt_addCustomer.setToolTipText((String) Window.res
					.getObject("bt_addCustomer"));
			jBt_addCustomer.setBounds(480, 510, 39, 39);
			jBt_addCustomer.setBackground(new java.awt.Color(255, 255, 255));

			jBt_reset.setText("Reset");
			jBt_reset.setBounds(465, 580, 73, 23);
		}
		/*********************************** ITALIEN **********************************/
		else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);

			jLb_date.setText((String) Window.res.getObject("lb_date"));
			jLb_date.setBounds(40, 20, 27, 20);

			jLb_from.setText((String) Window.res.getObject("lb_from"));
			jLb_from.setBounds(310, 75, 28, 20);

			jLb_to.setText((String) Window.res.getObject("lb_to"));
			jLb_to.setBounds(310, 105, 16, 20);

			jLb_ref.setText((String) Window.res.getObject("lb_ref"));
			jLb_ref.setBounds(310, 135, 60, 20);

			jLb_object.setText((String) Window.res.getObject("lb_object"));
			jLb_object.setBounds(10, 200, 50, 20);

			jLb_recName.setText((String) Window.res.getObject("lb_recName"));
			jLb_recName.setBounds(10, 230, 80, 20);

			jLb_payment.setText((String) Window.res.getObject("lb_payment"));
			jLb_payment.setBounds(10, 260, 70, 20);
			jTf_payment.setBounds(70, 260, 320, 20);
			jLb_indicationPayment.setText("[Mode of Payment] + [Nb days]");
			jLb_indicationPayment.setBounds(400, 260, 180, 20);

			jLb_incoterm.setText((String) Window.res.getObject("lb_incoterm"));
			jLb_incoterm.setBounds(10, 290, 47, 20);

			jLb_delAddress.setText((String) Window.res
					.getObject("lb_delivAddress"));
			jLb_delAddress.setBounds(10, 320, 120, 20);

			jLb_delPostcode.setText((String) Window.res
					.getObject("lb_delivPostcode"));
			jLb_delPostcode.setBounds(10, 350, 120, 20);

			jLb_delTown.setText((String) Window.res.getObject("lb_delivTown"));
			jLb_delTown.setBounds(10, 380, 120, 20);

			jLb_invAddress.setText((String) Window.res
					.getObject("lb_invoiceAddress"));
			jLb_invAddress.setBounds(10, 410, 160, 20);
			jTf_invAddress.setBounds(130, 410, 320, 20);

			jLb_invPostcode.setText((String) Window.res
					.getObject("lb_invoicePostcode"));
			jLb_invPostcode.setBounds(10, 440, 120, 20);

			jCb_sameAddr.setText((String) Window.res
					.getObject("cb_sameAddress"));
			jCb_sameAddr.setBounds(460, 440, 110, 20);

			jLb_invTown
					.setText((String) Window.res.getObject("lb_invoiceTown"));
			jLb_invTown.setBounds(10, 470, 120, 20);

			jLb_firstName
					.setText((String) Window.res.getObject("lb_firstName"));
			jLb_firstName.setBounds(10, 510, 60, 20);

			jLb_tel.setText((String) Window.res.getObject("lb_tel"));
			jLb_tel.setBounds(40, 570, 18, 20);

			jLb_lastName.setText((String) Window.res.getObject("lb_lastName"));
			jLb_lastName.setBounds(10, 540, 60, 20);

			jLb_fax.setText((String) Window.res.getObject("lb_fax"));
			jLb_fax.setBounds(40, 600, 22, 20);

			jLb_mail.setText((String) Window.res.getObject("lb_mail"));
			jLb_mail.setBounds(40, 630, 28, 20);

			jLb_comment.setText((String) Window.res.getObject("lb_comment"));
			jLb_comment.setBounds(10, 660, 70, 20);
			scroll.setBounds(70, 660, 280, 40);

			jCb_userData.setText((String) Window.res.getObject("cb_userData"));
			jCb_userData.setBounds(310, 510, 100, 23);

			jBt_print.setText((String) Window.res.getObject("bt_print"));
			jBt_print.setBounds(360, 580, 85, 23);

			jLb_search.setText((String) Window.res.getObject("lb_searchName"));
			jLb_search.setBounds(40, 50, 50, 20);

			jBt_load.setToolTipText((String) Window.res.getObject("bt_loadDB"));
			jBt_load.setBounds(25, 110, 39, 39);
			jBt_load.setBackground(new java.awt.Color(255, 255, 255));

			jBt_addCustomer.setToolTipText((String) Window.res
					.getObject("bt_addCustomer"));
			jBt_addCustomer.setBounds(480, 510, 39, 39);
			jBt_addCustomer.setBackground(new java.awt.Color(255, 255, 255));

			jBt_reset.setText("Reset");
			jBt_reset.setBounds(465, 580, 73, 23);
		}
		/******************************** FRANCAIS *********************************/
		else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);

			jLb_date.setText((String) Window.res.getObject("lb_date"));
			jLb_date.setBounds(40, 20, 27, 20);

			jLb_from.setText((String) Window.res.getObject("lb_from"));
			jLb_from.setBounds(310, 75, 28, 20);

			jLb_to.setText((String) Window.res.getObject("lb_to"));
			jLb_to.setBounds(310, 105, 16, 20);

			jLb_ref.setText((String) Window.res.getObject("lb_ref"));
			jLb_ref.setBounds(310, 135, 60, 20);

			jLb_object.setText((String) Window.res.getObject("lb_object"));
			jLb_object.setBounds(10, 200, 50, 20);

			jLb_recName.setText((String) Window.res.getObject("lb_recName"));
			jLb_recName.setBounds(10, 230, 80, 20);

			jLb_payment.setText((String) Window.res.getObject("lb_payment"));
			jLb_payment.setBounds(10, 260, 70, 20);
			jTf_payment.setBounds(70, 260, 320, 20);
			jLb_indicationPayment.setText("[Mode of Payment] + [Nb days]");
			jLb_indicationPayment.setBounds(400, 260, 180, 20);

			jLb_incoterm.setText((String) Window.res.getObject("lb_incoterm"));
			jLb_incoterm.setBounds(10, 290, 47, 20);

			jLb_delAddress.setText((String) Window.res
					.getObject("lb_delivAddress"));
			jLb_delAddress.setBounds(10, 320, 120, 20);

			jLb_delPostcode.setText((String) Window.res
					.getObject("lb_delivPostcode"));
			jLb_delPostcode.setBounds(10, 350, 120, 20);

			jLb_delTown.setText((String) Window.res.getObject("lb_delivTown"));
			jLb_delTown.setBounds(10, 380, 120, 20);

			jLb_invAddress.setText((String) Window.res
					.getObject("lb_invoiceAddress"));
			jLb_invAddress.setBounds(10, 410, 160, 20);
			jTf_invAddress.setBounds(120, 410, 320, 20);

			jLb_invPostcode.setText((String) Window.res
					.getObject("lb_invoicePostcode"));
			jLb_invPostcode.setBounds(10, 440, 120, 20);

			jCb_sameAddr.setText((String) Window.res
					.getObject("cb_sameAddress"));
			jCb_sameAddr.setBounds(460, 440, 110, 20);

			jLb_invTown
					.setText((String) Window.res.getObject("lb_invoiceTown"));
			jLb_invTown.setBounds(10, 470, 120, 20);

			jLb_firstName
					.setText((String) Window.res.getObject("lb_firstName"));
			jLb_firstName.setBounds(20, 510, 60, 20);

			jLb_tel.setText((String) Window.res.getObject("lb_tel"));
			jLb_tel.setBounds(40, 570, 18, 20);

			jLb_lastName.setText((String) Window.res.getObject("lb_lastName"));
			jLb_lastName.setBounds(35, 540, 60, 20);

			jLb_fax.setText((String) Window.res.getObject("lb_fax"));
			jLb_fax.setBounds(40, 600, 22, 20);

			jLb_mail.setText((String) Window.res.getObject("lb_mail"));
			jLb_mail.setBounds(40, 630, 28, 20);

			jLb_comment.setText((String) Window.res.getObject("lb_comment"));
			jLb_comment.setBounds(10, 660, 70, 20);
			scroll.setBounds(85, 660, 280, 40);

			jCb_userData.setText((String) Window.res.getObject("cb_userData"));
			jCb_userData.setBounds(310, 510, 150, 23);

			jBt_print.setText((String) Window.res.getObject("bt_print"));
			jBt_print.setBounds(360, 580, 85, 23);

			jLb_search.setText((String) Window.res.getObject("lb_searchName"));
			jLb_search.setBounds(20, 50, 90, 20);

			jBt_load.setToolTipText((String) Window.res.getObject("bt_loadDB"));
			jBt_load.setBounds(25, 110, 39, 39);
			jBt_load.setBackground(new java.awt.Color(255, 255, 255));

			jBt_addCustomer.setToolTipText((String) Window.res
					.getObject("bt_addCustomer"));
			jBt_addCustomer.setBounds(480, 510, 39, 39);
			jBt_addCustomer.setBackground(new java.awt.Color(255, 255, 255));

			jBt_reset.setText("RàZ");
			jBt_reset.setBounds(465, 580, 73, 23);
		}

		// Date
		jLayeredPane1.add(jLb_date, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_date.setBounds(70, 20, 70, 20);
		jTf_date.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		Window.date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		jLayeredPane1.add(jTf_date, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// From
		jLayeredPane1.add(jLb_from, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_from.setBounds(350, 75, 180, 20);
		if (Window.from.isEmpty()) {
			Window.from = Window.companyname;
			jTf_from.setText(Window.from);
		} else {
			jTf_from.setText(Window.from);
		}
		jLayeredPane1.add(jTf_from, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// To
		jLayeredPane1.add(jLb_to, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_to.setBounds(350, 105, 180, 20);
		jTf_to.setText(Window.to);
		jLayeredPane1.add(jTf_to, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Reference
		jLayeredPane1.add(jLb_ref, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_ref.setBounds(380, 135, 150, 20);
		if (Window.referencequot.isEmpty()) {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setSuppressWarnings(true);
			Sheet sheetuser;
			char username;
			char userlastname;
			try {
				sheetuser = Workbook.getWorkbook(
						new File("comercialdata.info"), ws).getSheet(0);
				username = sheetuser.getCell(1, 0).getContents().charAt(0);
				userlastname = sheetuser.getCell(1, 1).getContents().charAt(0);

				Window.referencequot = username + "" + userlastname
						+ Window.date.replace("/", "");
				jTf_ref.setText(Window.referencequot);

			} catch (IndexOutOfBoundsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BiffException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			jTf_ref.setText(Window.referencequot);
		}
		jLayeredPane1.add(jTf_ref, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Subject
		jLayeredPane1.add(jLb_object, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_object.setBounds(60, 200, 380, 20);
		jTf_object.setText(Window.object);
		jLayeredPane1.add(jTf_object, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Recipient Name
		jLayeredPane1.add(jLb_recName, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_recName.setBounds(100, 230, 190, 20);
		jTf_recName.setText(Window.recipientname);
		jLayeredPane1.add(jTf_recName, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_Mr.setBackground(new java.awt.Color(255, 255, 255));
		jCb_Mr.setText("Mr");
		jCb_Mr.setSelected(true);
		jCb_Mr.setBounds(300, 230, 37, 23);
		jLayeredPane1.add(jCb_Mr, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_Mr.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}

			private void jCheckBox2ActionPerformed(ActionEvent evt) {
				if (jCb_Mr.isSelected()) {
					jCb_Mrs.setSelected(false);
					jCb_no.setSelected(false);
				}
			}
		});

		jCb_Mrs.setText("Mrs");
		jCb_Mrs.setBackground(new java.awt.Color(255, 255, 255));
		jCb_Mrs.setBounds(350, 230, 43, 23);
		jLayeredPane1.add(jCb_Mrs, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_Mrs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if (jCb_Mrs.isSelected()) {
					jCb_no.setSelected(false);
					jCb_Mr.setSelected(false);
				}
			}
		});

		jCb_no.setText("no");
		jCb_no.setBackground(new java.awt.Color(255, 255, 255));
		jCb_no.setBounds(400, 230, 43, 23);
		jLayeredPane1.add(jCb_no, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_no.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if (jCb_no.isSelected()) {
					jCb_Mrs.setSelected(false);
					jCb_Mr.setSelected(false);
				}
			}
		});

		jCb_formDate1.setBackground(new java.awt.Color(255, 255, 255));
		jCb_formDate1.setText("dd/mm/yyyy");
		jCb_formDate1.setSelected(true);
		jCb_formDate1.setBounds(160, 20, 90, 20);
		jLayeredPane1
				.add(jCb_formDate1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_formDate1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox4ActionPerformed(evt);
			}

			private void jCheckBox4ActionPerformed(ActionEvent evt) {
				if (jCb_formDate1.isSelected()) {
					jCb_formDate2.setSelected(false);
				} else {
					jCb_formDate1.setSelected(true);
				}
				jTf_date.setText(new SimpleDateFormat("dd/MM/yyyy")
						.format(new Date()));
				Window.date = new SimpleDateFormat("dd/MM/yyyy")
						.format(new Date());
			}
		});

		jCb_formDate2.setText("mm/dd/yyyy");
		jCb_formDate2.setBackground(new java.awt.Color(255, 255, 255));
		jCb_formDate2.setBounds(260, 20, 100, 20);
		jLayeredPane1
				.add(jCb_formDate2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_formDate2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox5ActionPerformed(evt);
			}

			private void jCheckBox5ActionPerformed(ActionEvent evt) {
				if (jCb_formDate2.isSelected()) {
					jCb_formDate1.setSelected(false);
				} else {
					jCb_formDate2.setSelected(true);
				}
				jTf_date.setText(new SimpleDateFormat("MM/dd/yyyy")
						.format(new Date()));
				Window.date = new SimpleDateFormat("MM/dd/yyyy")
						.format(new Date());
			}
		});

		// Payment
		jLayeredPane1.add(jLb_payment, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_payment.setText(Window.payment);
		jLayeredPane1.add(jTf_payment, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jLb_indicationPayment,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Incoterm
		jLayeredPane1.add(jLb_incoterm, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_incoterm.setBounds(70, 290, 320, 20);
		jTf_incoterm.setText(Window.incoterm);
		jLayeredPane1.add(jTf_incoterm, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Delivery Address
		jLayeredPane1.add(jLb_delAddress,
				javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_delAddress.setBounds(120, 320, 320, 20);
		jTf_delAddress.setText(Window.deliveryaddress);
		jLayeredPane1.add(jTf_delAddress,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Delivery Postcode
		jLayeredPane1.add(jLb_delPostcode,
				javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_delPostcode.setBounds(120, 350, 320, 20);
		jTf_delPostcode.setText(Window.deliverypostcode);
		jLayeredPane1.add(jTf_delPostcode,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Delivery Town or/and Country
		jLayeredPane1.add(jLb_delTown, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_devTown.setBounds(120, 380, 320, 20);
		jTf_devTown.setText(Window.deliverylocation);
		jLayeredPane1.add(jTf_devTown, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Invoicing address
		jLayeredPane1.add(jLb_invAddress,
				javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_invAddress.setText(Window.address);
		jLayeredPane1.add(jTf_invAddress,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Invoicing postcode
		jLayeredPane1.add(jLb_invPostcode,
				javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_invPostcode.setBounds(120, 440, 320, 20);
		jTf_invPostcode.setText(Window.postcode);
		jLayeredPane1.add(jTf_invPostcode,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Same Address
		jCb_sameAddr.setBackground(new java.awt.Color(255, 255, 255));
		jLayeredPane1.add(jCb_sameAddr, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCb_sameAddr.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if (jCb_sameAddr.isSelected()) {
					Window.address = jTf_delAddress.getText();
					Window.postcode = jTf_delPostcode.getText();
					Window.location = jTf_devTown.getText();
					jTf_invAddress.setText(Window.address);
					jTf_invPostcode.setText(Window.postcode);
					jTf_invTown.setText(Window.location);
				} else {
					Window.address = "";
					Window.postcode = "";
					Window.location = "";
					jTf_invAddress.setText("");
					jTf_invPostcode.setText("");
					jTf_invTown.setText("");
				}
			}
		});

		// Invoicing Town or/and Country
		jLayeredPane1.add(jLb_invTown, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_invTown.setBounds(120, 470, 320, 20);
		jTf_invTown.setText(Window.location);
		jLayeredPane1.add(jTf_invTown, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// First Name
		jLayeredPane1
				.add(jLb_firstName, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_firstName.setBounds(70, 510, 210, 20);
		jTf_firstName.setText(Window.salesman);
		jLayeredPane1
				.add(jTf_firstName, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Tel
		jLayeredPane1.add(jLb_tel, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_tel.setText(Window.gsm);
		jTf_tel.setBounds(70, 540, 210, 20);
		jLayeredPane1.add(jTf_tel, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Last name
		jLayeredPane1.add(jLb_lastName, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_lastName.setText(Window.tel);
		jTf_lastName.setBounds(70, 570, 210, 20);
		jLayeredPane1.add(jTf_lastName, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Fax
		jLayeredPane1.add(jLb_fax, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_fax.setBounds(70, 600, 210, 20);
		jTf_fax.setText(Window.fax);
		jLayeredPane1.add(jTf_fax, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Mail
		jLayeredPane1.add(jLb_mail, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_mail.setBounds(70, 630, 210, 20);
		jTf_mail.setText(Window.email);
		jLayeredPane1.add(jTf_mail, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jLb_comment, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTa_comment.setLineWrap(true);
		jLayeredPane1.add(scroll, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// user data
		jCb_userData.setBackground(new java.awt.Color(255, 255, 255));
		jLayeredPane1.add(jCb_userData, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Search
		jLayeredPane1.add(jLb_search, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTf_search.setBounds(90, 50, 180, 20);
		jTf_search.setEnabled(false);
		jLayeredPane1.add(jTf_search, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// List
		listName.setFocusable(false);
		scrollList.setBounds(90, 75, 180, 110);
		jLayeredPane1.add(scrollList, JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jBt_load, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jBt_addCustomer,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		/* Action pour reset le formulaire de devis */
		jBt_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTf_to.setText("");
				jTf_delAddress.setText("");
				jTf_delPostcode.setText("");
				jTf_devTown.setText("");
				jTf_invAddress.setText("");
				jTf_invPostcode.setText("");
				jTf_invTown.setText("");
				jTf_payment.setText("");
				jTf_incoterm.setText("");
				jTf_search.setText("");
			}
		});
		jLayeredPane1.add(jBt_reset, javax.swing.JLayeredPane.DEFAULT_LAYER);

		// Action sur CheckBox 'User Data'
		jCb_userData.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jCheckBox3ActionPerformed(evt);
				} catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void jCheckBox3ActionPerformed(ActionEvent evt)
					throws IndexOutOfBoundsException, BiffException,
					IOException {
				if (jCb_userData.isSelected()) {
					WorkbookSettings ws = new WorkbookSettings();
					ws.setSuppressWarnings(true);
					Sheet sheet = Workbook.getWorkbook(
							new File("comercialdata.info"), ws).getSheet(0);
					Window.salesman = sheet.getCell(1, 0).getContents();
					Window.gsm = sheet.getCell(1, 1).getContents();
					Window.tel = sheet.getCell(1, 2).getContents();
					Window.fax = sheet.getCell(1, 3).getContents();
					Window.email = sheet.getCell(1, 4).getContents();
					jTf_firstName.setEditable(false);
					jTf_firstName.setText(Window.salesman);
					jTf_tel.setEditable(false);
					jTf_tel.setText(Window.gsm);
					jTf_lastName.setEditable(false);
					jTf_lastName.setText(Window.tel);
					jTf_fax.setEditable(false);
					jTf_fax.setText(Window.fax);
					jTf_mail.setEditable(false);
					jTf_mail.setText(Window.email);
				} else {
					Window.salesman = "";
					Window.gsm = "";
					Window.tel = "";
					Window.fax = "";
					Window.email = "";
					jTf_firstName.setEditable(true);
					jTf_firstName.setText(Window.salesman);
					jTf_tel.setEditable(true);
					jTf_tel.setText(Window.gsm);
					jTf_lastName.setEditable(true);
					jTf_lastName.setText(Window.tel);
					jTf_fax.setEditable(true);
					jTf_fax.setText(Window.fax);
					jTf_mail.setEditable(true);
					jTf_mail.setText(Window.email);
				}
			}
		});

		// Button Print
		jBt_print.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		jLayeredPane1.add(jBt_print, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625,
				Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710,
				Short.MAX_VALUE));

		this.getContentPane().setBackground(new Color(255, 255, 255));

		FocusListener focuslistener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (e.getSource().equals(jTf_date)) {
					Window.date = jTf_date.getText();
				}
				if (e.getSource().equals(jTf_from)) {
					Window.from = jTf_from.getText();
				}
				if (e.getSource().equals(jTf_to)) {
					Window.to = jTf_to.getText();
				}
				if (e.getSource().equals(jTf_object)) {
					Window.object = jTf_object.getText();
				}
				if (e.getSource().equals(jTf_recName)) {
					Window.recipientname = jTf_recName.getText();
				}
				if (e.getSource().equals(jTf_payment)) {
					Window.payment = jTf_payment.getText();
				}
				if (e.getSource().equals(jTf_incoterm)) {
					Window.incoterm = jTf_incoterm.getText();
				}
				if (e.getSource().equals(jTf_firstName)) {
					Window.salesman = jTf_firstName.getText();
				}
				if (e.getSource().equals(jTf_tel)) {
					Window.gsm = jTf_tel.getText();
				}
				if (e.getSource().equals(jTf_lastName)) {
					Window.tel = jTf_lastName.getText();
				}
				if (e.getSource().equals(jTf_fax)) {
					Window.fax = jTf_fax.getText();
				}
				if (e.getSource().equals(jTf_mail)) {
					Window.email = jTf_mail.getText();
				}
				if (e.getSource().equals(jTf_ref)) {
					Window.referencequot = jTf_ref.getText();
				}
				if (e.getSource().equals(jTf_delAddress)) {
					Window.deliveryaddress = jTf_delAddress.getText();
				}
				if (e.getSource().equals(jTf_delPostcode)) {
					Window.deliverypostcode = jTf_delPostcode.getText();
				}
				if (e.getSource().equals(jTf_devTown)) {
					Window.deliverylocation = jTf_devTown.getText();
				}
				if (e.getSource().equals(jTf_invAddress)) {
					Window.address = jTf_invAddress.getText();
				}
				if (e.getSource().equals(jTf_invPostcode)) {
					Window.postcode = jTf_invPostcode.getText();
				}
				if (e.getSource().equals(jTf_invTown)) {
					Window.location = jTf_invTown.getText();
				}
			}
		};

		jTf_date.addFocusListener(focuslistener);
		jTf_from.addFocusListener(focuslistener);
		jTf_to.addFocusListener(focuslistener);
		jTf_object.addFocusListener(focuslistener);
		jTf_recName.addFocusListener(focuslistener);
		jTf_payment.addFocusListener(focuslistener);
		jTf_incoterm.addFocusListener(focuslistener);
		jTf_firstName.addFocusListener(focuslistener);
		jTf_tel.addFocusListener(focuslistener);
		jTf_lastName.addFocusListener(focuslistener);
		jTf_fax.addFocusListener(focuslistener);
		jTf_mail.addFocusListener(focuslistener);
		jTf_ref.addFocusListener(focuslistener);
		jTf_delAddress.addFocusListener(focuslistener);
		jTf_delPostcode.addFocusListener(focuslistener);
		jTf_devTown.addFocusListener(focuslistener);
		jTf_invAddress.addFocusListener(focuslistener);
		jTf_invPostcode.addFocusListener(focuslistener);
		jTf_invTown.addFocusListener(focuslistener);

		/* Ouverture de fichier de bdd client */
		try {
			WorkbookSettings ws = new WorkbookSettings();
			ws.setSuppressWarnings(true);
			Sheet sheet = Workbook.getWorkbook(new File(pathnameDatabase), ws)
					.getSheet(0);

			databaseName = new ReadNamelist(sheet);

			if (databaseName.isNameList(sheet)) {
				file = new File(pathnameDatabase);
				ArrayList<String> productslist = databaseName
						.readDatabase(sheet);

				String name = file.getName();
				WritableWorkbook workbook1 = Workbook.createWorkbook(new File(
						"filename.info"));
				WritableSheet sheet1 = workbook1.createSheet(
						"Premier classeur", 0);
				workbook1.setProtected(true);
				sheet1.setProtected(true);
				Label label = new Label(0, 0, file.getName());
				sheet1.addCell(label);
				workbook1.write();
				workbook1.close();

				jTf_search.setText("");
				jTf_search.setEnabled(true);

			} else {
				javax.swing.JOptionPane.showMessageDialog(null,
						"The file is not in expected format");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR : " + e);
			javax.swing.JOptionPane.showMessageDialog(null, "ERROR: File "
					+ pathnameDatabase + " was not found");
		}

		jBt_load.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					JFileChooser chooser;
					chooser = new JFileChooser(parents) {

						private static final long serialVersionUID = 1L;

						@Override
						public void approveSelection() {
							File f = new File(getSelectedFile()
									.getAbsolutePath());
							if (f.exists()) {
								parents = f.getParent();
								super.approveSelection();
							}
						}
					};

					chooser.setAcceptAllFileFilterUsed(false);

					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"Fichier Excel (.xls)", "xls");
					chooser.setFileFilter(filter);

					int returnval = chooser.showOpenDialog(null);

					if (returnval == JFileChooser.APPROVE_OPTION) {
						WorkbookSettings ws = new WorkbookSettings();
						ws.setSuppressWarnings(true);
						Sheet sheet = Workbook.getWorkbook(
								chooser.getSelectedFile(), ws).getSheet(0);

						databaseName = new ReadNamelist(sheet);

						if (databaseName.isNameList(sheet)) {
							file = chooser.getSelectedFile();
							ArrayList<String> productslist = databaseName
									.readDatabase(sheet);

							String name = file.getName();
							WritableWorkbook workbook1 = Workbook
									.createWorkbook(new File("filename.info"));
							WritableSheet sheet1 = workbook1.createSheet(
									"Premier classeur", 0);
							workbook1.setProtected(true);
							sheet1.setProtected(true);
							Label label = new Label(0, 0, file.getName());
							sheet1.addCell(label);
							workbook1.write();
							workbook1.close();

							jTf_search.setEnabled(true);
							jTf_search.setText("");

							javax.swing.JOptionPane
									.showMessageDialog(null, "The file \""
											+ chooser.getSelectedFile()
													.getName() + "\" is loaded");

						} else {
							javax.swing.JOptionPane.showMessageDialog(null,
									"The file \""
											+ chooser.getSelectedFile()
													.getName()
											+ "\" is not in expected format");
						}
					}
				} catch (Exception ev) {
					javax.swing.JOptionPane.showMessageDialog(null, ev);
				}
			}
		});

		/* Action sur la zone de texte Search Product */
		jTf_search.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jTextField1ActionPerformed(evt);
			}

			@SuppressWarnings("deprecation")
			private void jTextField1ActionPerformed(KeyEvent evt) {
				if (file == null) {
					System.out.println("WARNING ! No loaded file");
				} else if (file != null) {
					if (jTf_search.getText().equals("")) {
						if (Character.isJavaLetter(evt.getKeyChar())
								|| evt.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD
								|| evt.getKeyCode() == Event.ENTER) {
							listName.setModel(databaseName
									.readSearch(jTf_search.getText()));
							listName.setEnabled(true);
						}
					} else {
						if (Character.isJavaLetter(evt.getKeyChar())
								|| evt.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD
								|| evt.getKeyCode() == Event.ENTER
								|| evt.getKeyCode() == 8) {
							listName.setModel(databaseName
									.readSearch(jTf_search.getText()));
							listName.setEnabled(true);
						}
					}
				}
			}
		});
		listName.setFocusable(true);

		/* Action clavier sur la zone de texte Search Product */
		jTf_search.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField1KeyPressed(evt);
			}

			private void jTextField1KeyPressed(KeyEvent evt) {
				// KeyCode 40 = Flèche bas
				if (evt.getKeyCode() == 40) {
					// Si la liste != -1 (donc rempli)
					if (listName.getFirstVisibleIndex() != -1) {
						listName.setSelectedIndex(0);
						listName.requestFocus();
					}
				}
			}
		});

		/***************************/
		/* Action clavier sur List1 */
		listName.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jList1KeyPressed(evt);
			}

			@SuppressWarnings("static-access")
			private void jList1KeyPressed(KeyEvent evt) {
				if (isList) {
					if (evt.getKeyCode() == Event.ENTER) {

						DefaultListModel test = new DefaultListModel();
						test.addElement(listName.getSelectedValue().toString());
						listName.setModel(test);
						listName.setSelectedIndex(0);
					}
				}
			}
		});

		/* Action souris sur List1 */
		listName.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				listMouseClicked(evt);
			}

			private void listMouseClicked(MouseEvent evt) {
				// TODO Auto-generated method stub
				DefaultListModel test = new DefaultListModel();
				test.addElement(listName.getSelectedValue().toString());
				listName.setModel(test);
				listName.setSelectedIndex(0);
				jTf_search.setText(listName.getSelectedValue().toString());

				/* To */
				Window.to = databaseName.readCompany(listName
						.getSelectedValue().toString());
				jTf_to.setText(Window.to);

				/* Payment */
				String statePayment = null;
				switch (Integer.parseInt(databaseName
						.readPaymentReglement(listName.getSelectedValue()
								.toString()))) {
				case 32:
					statePayment = "ANTICIPATED";
					break;

				case 3:
					statePayment = "CHECK";
					break;

				case 4:
					statePayment = "SWIFT";
					break;

				case 9:
					statePayment = "AGAINST DOCUMENTS";
					break;

				case 37:
					statePayment = "LETTER OF CREDIT";
					break;

				default:
					statePayment = "UNKNOW";
					break;
				}

				/* Day payment */
				statePayment += " "
						+ databaseName.readPaymentEcheance(listName
								.getSelectedValue().toString()) + " days";
				Window.payment = statePayment;

				jTf_payment.setText(Window.payment);

				/* Incoterm */
				Window.incoterm = databaseName.readIncoterm(listName
						.getSelectedValue().toString());
				jTf_incoterm.setText(Window.incoterm);

				/* Delivery Address */
				Window.deliveryaddress = databaseName.readDelAddress(listName
						.getSelectedValue().toString())
						+ "  "
						+ databaseName.readDelAddress2(listName
								.getSelectedValue().toString());
				jTf_delAddress.setText(Window.deliveryaddress);

				/* Delivery Postcode */
				Window.deliverypostcode = databaseName.readDelPostcode(listName
						.getSelectedValue().toString());
				jTf_delPostcode.setText(Window.deliverypostcode);

				/* Delivery Town/Country */
				Window.deliverylocation = databaseName.readDelTown(listName
						.getSelectedValue().toString())
						+ " - "
						+ databaseName.readDelCountry(listName
								.getSelectedValue().toString());
				jTf_devTown.setText(Window.deliverylocation);

				/* Invoicing Address */
				Window.address = databaseName.readInvAddress(listName
						.getSelectedValue().toString())
						+ "  "
						+ databaseName.readInvAddress2(listName
								.getSelectedValue().toString());
				jTf_invAddress.setText(Window.address);

				/* Invoicing Postcode */
				Window.postcode = databaseName.readInvPostcode(listName
						.getSelectedValue().toString());
				jTf_invPostcode.setText(Window.postcode);

				/* Invoicing Town/Country */
				Window.location = databaseName.readInvTown(listName
						.getSelectedValue().toString())
						+ " - "
						+ databaseName.readInvCountry(listName
								.getSelectedValue().toString());
				jTf_invTown.setText(Window.location);
			}
		});

		jBt_addCustomer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				if (jTf_payment.getText().isEmpty()) {
					jTf_payment.setText("UNKNOW 000");
				}

				String[] textPayment = jTf_payment.getText().split(" ");
				int lenght = textPayment.length;

				String fiche = "<html><b><u>Company:</u></b>"
						+ jTf_to.getText() + "\n"
						+ "<html><b><u>Recipient name:</u></b> "
						+ jTf_recName.getText() + "\n\n"

						+ "<html><b><u>Delivery Address:</u></b>\n"
						+ jTf_delAddress.getText() + "\n"
						+ jTf_delPostcode.getText() + " "
						+ jTf_devTown.getText() + "\n\n"

						+ "<html><b><u>Invoicing Address:</u></b>\n"
						+ jTf_invAddress.getText() + "\n"
						+ jTf_invPostcode.getText() + " "
						+ jTf_invTown.getText() + "\n\n"

						+ "<html><b><i><u>Payment</u></i></b>:\n"
						+ "     Mode of payment: "
						+ textPayment[0].toUpperCase() + "\n" + "     Term: "
						+ textPayment[1] + " days" + "\n"

						+ "<html><u><i><b>Incoterm</b></i></u>: "
						+ jTf_incoterm.getText() + "\n\n";

				int alert = javax.swing.JOptionPane
						.showConfirmDialog(new javax.swing.JFrame(), fiche,
								"Please check it before adding !",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);

				WritableSheet sheet;
				Workbook workbook;
				WritableWorkbook wwork;
				WritableCell cell;

				if (alert == JOptionPane.YES_OPTION) {

					try {

						if (!new File(pathnameDBtestcreate).exists()) {
							System.out.println("Don't exist...");

							WritableWorkbook wworkbook = Workbook
									.createWorkbook(new File(
											pathnameDBtestcreate));
							WritableSheet wsheet = wworkbook.createSheet(
									"Page 1", 0);
							WritableFont titrefont = new WritableFont(
									WritableFont.ARIAL, 10,
									WritableFont.NO_BOLD);

							// Size Column 20
							for (int c = 0; c < 30; c++) {
								wsheet.setColumnView(c, 20);
							}

							// Format cell
							WritableCellFormat format = new WritableCellFormat(
									titrefont);
							format.setBackground(Colour.WHITE);
							format.setAlignment(Alignment.CENTRE);
							format.setVerticalAlignment(VerticalAlignment.CENTRE);
							format.setOrientation(Orientation.HORIZONTAL);
							format.setBorder(Border.ALL, BorderLineStyle.THIN,
									Colour.BLACK);
							format.setShrinkToFit(true);
							format.setWrap(true);

							// Column Tiltle
							Label label = new Label(0, 0, "Compte", format);
							wsheet.addCell(label);

							Label label1 = new Label(1, 0, "Abrege", format);
							wsheet.addCell(label1);

							Label label2 = new Label(2, 0, "Nom", format);
							wsheet.addCell(label2);

							Label label3 = new Label(3, 0, "Rue1", format);
							wsheet.addCell(label3);

							Label label4 = new Label(4, 0, "Rue2", format);
							wsheet.addCell(label4);

							Label label5 = new Label(5, 0, "Boite P", format);
							wsheet.addCell(label5);

							Label label6 = new Label(6, 0, "Code Post.", format);
							wsheet.addCell(label6);

							Label label7 = new Label(7, 0, "Ville", format);
							wsheet.addCell(label7);

							Label label8 = new Label(8, 0, "Pays", format);
							wsheet.addCell(label8);

							Label label9 = new Label(9, 0, "Code Pays", format);
							wsheet.addCell(label9);

							Label label10 = new Label(10, 0, "Nom Livr.",
									format);
							wsheet.addCell(label10);

							Label label11 = new Label(11, 0, "Rue1 Livr.",
									format);
							wsheet.addCell(label11);

							Label label12 = new Label(12, 0, "Rue2 Livr",
									format);
							wsheet.addCell(label12);

							Label label13 = new Label(13, 0, "C. P. Livr",
									format);
							wsheet.addCell(label13);

							Label label14 = new Label(14, 0, "Ville Livr",
									format);
							wsheet.addCell(label14);

							Label label15 = new Label(15, 0, "Pays Livr.",
									format);
							wsheet.addCell(label15);

							Label label16 = new Label(16, 0, "C. Pays L",
									format);
							wsheet.addCell(label16);

							Label label17 = new Label(17, 0, "Teleph. 1",
									format);
							wsheet.addCell(label17);

							Label label18 = new Label(18, 0, "Etablist", format);
							wsheet.addCell(label18);

							Label label19 = new Label(19, 0, "Base Echea",
									format);
							wsheet.addCell(label19);

							Label label20 = new Label(20, 0, "Code Port",
									format);
							wsheet.addCell(label20);

							Label label21 = new Label(21, 0, "Code Echea",
									format);
							wsheet.addCell(label21);

							Label label22 = new Label(22, 0, "Teleph 2", format);
							wsheet.addCell(label22);

							Label label23 = new Label(23, 0, "Contact 2",
									format);
							wsheet.addCell(label23);

							Label label24 = new Label(24, 0, "No TVA CEE",
									format);
							wsheet.addCell(label24);

							Label label25 = new Label(25, 0, "Contact1", format);
							wsheet.addCell(label25);

							Label label26 = new Label(26, 0, "Represt.", format);
							wsheet.addCell(label26);

							Label label27 = new Label(27, 0, "Nom Rep 1",
									format);
							wsheet.addCell(label27);

							Label label28 = new Label(28, 0, "Code Rglt",
									format);
							wsheet.addCell(label28);

							Label label29 = new Label(29, 0, "Type Rglt",
									format);
							wsheet.addCell(label29);

							SheetSettings Worksheet_settings = wsheet
									.getSettings();

							wworkbook.write(); /* Write in Workbook */
							wworkbook.close(); /* Close Workbook */

							System.out.println("The file was created");
						} else {
							System.out.println("The file exist");
						}

						workbook = Workbook.getWorkbook(new File(
								pathnameDBtestcreate));
						wwork = Workbook.createWorkbook(new File(
								pathnameDBtestcreate), workbook);

						sheet = wwork.getSheet(0);
						isExist = false;

						for (int k = 0; k <= sheet.getRows() - 1; k++) {
							if (sheet.getCell(0, k).getContents()
									.equals(jTf_to.getText())) {
								isExist = true;
								javax.swing.JOptionPane.showMessageDialog(null,
										"This element already exist.");
							}
						}

						if (!isExist) {
							// Label label0, label1, label2, label3 = null;
							Label label28 = null, label21 = null;
							int row = sheet.getRows();

							System.out.println("Nombre de ligne : " + row);

							for (int i = 0; i <= 29; i++) {
								cell = sheet.getWritableCell(i, sheet.getRows());

								Label label0 = new Label(0, row, "");
								sheet.addCell(label0);

								Label label1 = new Label(1, row, "");
								sheet.addCell(label1);

								Label label2 = new Label(2, row, jTf_to
										.getText());
								sheet.addCell(label2);

								Label label3 = new Label(3, row, jTf_invAddress
										.getText());
								sheet.addCell(label3);

								Label label4 = new Label(4, row, "");
								sheet.addCell(label4);

								Label label5 = new Label(5, row, "");
								sheet.addCell(label5);

								Label label6 = new Label(6, row,
										jTf_invPostcode.getText());
								sheet.addCell(label6);

								Label label7 = new Label(7, row, jTf_invTown
										.getText());
								sheet.addCell(label7);

								Label label8 = new Label(8, row, "");
								sheet.addCell(label8);

								Label label9 = new Label(9, row, "");
								sheet.addCell(label9);

								Label label10 = new Label(10, row, jTf_to
										.getText());
								sheet.addCell(label10);

								Label label11 = new Label(11, row,
										jTf_delAddress.getText());
								sheet.addCell(label11);

								Label label12 = new Label(12, row, "");
								sheet.addCell(label12);

								Label label13 = new Label(13, row,
										jTf_delPostcode.getText());
								sheet.addCell(label13);

								Label label14 = new Label(14, row, jTf_devTown
										.getText());
								sheet.addCell(label14);

								Label label15 = new Label(15, row, "");
								sheet.addCell(label15);

								Label label16 = new Label(16, row, "");
								sheet.addCell(label16);

								Label label17 = new Label(17, row, "");
								sheet.addCell(label17);

								Label label18 = new Label(18, row, "");
								sheet.addCell(label18);

								Label label19 = new Label(19, row, "");
								sheet.addCell(label19);

								Label label20 = new Label(20, row, jTf_incoterm
										.getText());
								sheet.addCell(label20);

								if (textPayment[1].isEmpty()) {
									label21 = new Label(21, row, "000");
								} else {
									label21 = new Label(21, row, textPayment[1]);
								}
								sheet.addCell(label21);

								Label label22 = new Label(22, row, "");
								sheet.addCell(label22);

								Label label23 = new Label(23, row, "");
								sheet.addCell(label23);

								Label label24 = new Label(24, row, "");
								sheet.addCell(label24);

								Label label25 = new Label(25, row, "");
								sheet.addCell(label25);

								Label label26 = new Label(26, row, "P");
								sheet.addCell(label26);

								Label label27 = new Label(27, row, jTf_from
										.getText());
								sheet.addCell(label27);

								if (textPayment[0].contains("ANTICIPATED")) {
									label28 = new Label(28, row, "32");
								} else if (textPayment[0].contains("CHECK")) {
									label28 = new Label(28, row, "3");
								} else if (textPayment[0].contains("SWIFT")) {
									label28 = new Label(28, row, "4");
								} else if (textPayment[0]
										.contains("AGAINST DOCUMENTS")) {
									label28 = new Label(28, row, "9");
								} else if (textPayment[0]
										.contains("LETTER OF CREDIT")) {
									label28 = new Label(28, row, "37");
								} else {
									label28 = new Label(28, row, "0");
								}
								sheet.addCell(label28);

								Label label29 = new Label(29, row, "");
								sheet.addCell(label29);
							}
							javax.swing.JOptionPane.showMessageDialog(null,
							"The prospect was added to the database.");
						}

						wwork.write();
						wwork.close();

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("ERROR for write in xls file: " + e);
						javax.swing.JOptionPane
								.showMessageDialog(
										null,
										"ERROR: Le processus ne peut pas accéder "
												+ "au fichier car ce fichier est utilisé par "
												+ "un autre processus.");
					}
				} else if (alert == JOptionPane.NO_OPTION) {
				}
			}
		});

		jTf_date.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}

			private void jTextField1ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.date = jTf_date.getText();
			}
		});

		jTf_from.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}

			private void jTextField2ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.from = jTf_from.getText();
			}
		});

		jTf_to.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}

			private void jTextField3ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.to = jTf_to.getText();
			}
		});

		jTf_object.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField8ActionPerformed(evt);
			}

			private void jTextField8ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.object = jTf_object.getText();
			}
		});

		jTf_payment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField10ActionPerformed(evt);
			}

			private void jTextField10ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.payment = jTf_payment.getText();
			}
		});

		jTf_incoterm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField11ActionPerformed(evt);
			}

			private void jTextField11ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.incoterm = jTf_incoterm.getText();
			}
		});

		jTf_firstName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField12ActionPerformed(evt);
			}

			private void jTextField12ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.salesman = jTf_firstName.getText();
			}
		});

		jTf_tel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField13ActionPerformed(evt);
			}

			private void jTextField13ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.gsm = jTf_tel.getText();
			}
		});

		jTf_lastName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField14ActionPerformed(evt);
			}

			private void jTextField14ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.tel = jTf_lastName.getText();
			}
		});

		jTf_fax.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField15ActionPerformed(evt);
			}

			private void jTextField15ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.fax = jTf_fax.getText();
			}
		});

		jTf_mail.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField16ActionPerformed(evt);
			}

			private void jTextField16ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.email = jTf_mail.getText();
			}
		});

		jTf_ref.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField17ActionPerformed(evt);
			}

			private void jTextField17ActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				Window.referencequot = jTf_ref.getText();
			}
		});
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
			throws DocumentException, IOException {

		try {
			System.out.println(jTf_recName.getText());
			JFileChooser chooser = new JFileChooser(Window.parents) {

				private static final long serialVersionUID = 1L;

				@Override
				public void approveSelection() {
					File f = null;

					if (getSelectedFile().getAbsolutePath().endsWith(".pdf"))
						f = new File(getSelectedFile().getAbsolutePath());
					else
						f = new File(getSelectedFile().getAbsolutePath()
								+ ".pdf");

					if (f.exists()) {
						Window.parents = f.getParent();
						int answer = JOptionPane.showConfirmDialog(this, f
								+ " exists. Overwrite?", "Overwrite?",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);

						if (answer != JOptionPane.OK_OPTION) {
							return;
						}
					}
					super.approveSelection();
				}
			};
			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Fichier PDF (.pdf)", "pdf");
			chooser.setFileFilter(filter);
			/*
			 * chooser.setSelectedFile(new File("quotation " + new
			 * SimpleDateFormat("dd.MM.yyyy").format(new
			 * Date())));//Window.referencequot
			 */
			chooser.setSelectedFile(new File("quotation "
					+ Window.referencequot));

			int returnVal = chooser.showSaveDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				this.dispose();

				Document document = new Document(PageSize.A4);// PageSize.A4,
																// 36, 36, 54,
																// 54);
				PdfWriter writer = PdfWriter.getInstance(document,
						new FileOutputStream("quotation.pdf"));

				document.open();

				PdfPTable table2 = new PdfPTable(1);
				PdfPCell c = new PdfPCell(Image.getInstance("logo.png"), false);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setBorder(Rectangle.NO_BORDER);

				table2.addCell(c);

				c = new PdfPCell(new Phrase(Window.companyname + " : "
						+ Window.companyaddress + " – "
						+ Window.companypostcode + " " + Window.companytown
						+ " – " + Window.companycountry, new Font(
						FontFamily.HELVETICA, 6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(Rectangle.NO_BORDER);
				table2.addCell(c);

				c = new PdfPCell(new Phrase("Tel : " + Window.conpanytel
						+ " – Fax : " + Window.conpanyfax + " – Email: "
						+ Window.conpanyemail, new Font(FontFamily.HELVETICA,
						6, Font.NORMAL)));
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setBorder(Rectangle.NO_BORDER);
				table2.addCell(c);

				c = new PdfPCell(new Phrase(""));
				c.setBorder(Rectangle.NO_BORDER);
				c.setFixedHeight(c.getFixedHeight() + 30);
				table2.addCell(c);

				document.add(table2);
				document.add(createTable(document));

				document.close();

				PdfReader reader = new PdfReader("quotation.pdf");

				Document document2 = new Document();
				PdfWriter writer2 = PdfWriter.getInstance(document2,
						new FileOutputStream("text.pdf"));
				document2.open();
				PdfContentByte canvas = writer2.getDirectContent();
				writer2.setCompressionLevel(0);

				canvas.saveState(); // q
				canvas.beginText(); // BT
				canvas.moveText(280, 39); // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText("Page 1 of " + (reader.getNumberOfPages() + 1));
				canvas.endText(); // ET
				canvas.restoreState();

				canvas.saveState(); // q
				Image img2 = Image.getInstance("logo.png");
				img2.setAbsolutePosition(59, 680);
				img2.scalePercent(80);
				canvas.addImage(img2); // 36 788 Td // ET
				canvas.restoreState();

				canvas.saveState(); // q
				canvas.beginText(); // BT
				canvas.moveText(59, 662); // 36 788 Td
				canvas.setFontAndSize(
						FontFactory.getFont(BaseFont.HELVETICA, 10, 1)
								.getCalculatedBaseFont(false), 8);
				canvas.showText(Window.companyname);
				canvas.endText(); // ET
				canvas.restoreState();

				canvas.saveState(); // q
				canvas.beginText(); // BT
				canvas.moveText(59, 650); // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8);
				canvas.showText(Window.companyaddress);
				canvas.endText(); // ET
				canvas.restoreState();

				canvas.saveState(); // q
				canvas.beginText(); // BT
				canvas.moveText(59, 638); // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8);
				canvas.showText(Window.companypostcode + " "
						+ Window.companytown + " - " + Window.companycountry);
				canvas.endText(); // ET
				canvas.restoreState();

				canvas.saveState(); // q
				canvas.beginText(); // BT
				canvas.moveText(167, 68); // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText("Tel: " + Window.conpanytel + " - Fax: "
						+ Window.conpanyfax + " - Email: "
						+ Window.conpanyemail); // (Hello World)Tj
				canvas.endText(); // ET
				canvas.restoreState();

				canvas.saveState(); // q
				canvas.beginText(); // BT
				canvas.moveText(80, 58); // 36 788 Td
				canvas.setFontAndSize(BaseFont.createFont(), 8); // /F1 12 Tf
				canvas.showText(Window.conpanycomment); // (Hello World)Tj
				canvas.endText(); // ET
				canvas.restoreState();

				BaseFont font = FontFactory.getFont(BaseFont.HELVETICA, 10, 1)
						.getCalculatedBaseFont(false);// 36 788 Td

				/************************************ ANGLAIS ******************************/
				if (Window.locale.toString().equals("en")) {
					// REFERENCE
					if (!Window.referencequot.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(375, 695); // 36 788 Td
						canvas.setFontAndSize(font, 10); // /F1 12 Tf
						canvas.showText("Reference :"); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();

						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(436, 695); // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText(Window.referencequot); // (Hello
																// World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
					// DELIVERY ADDRESS
					if (!Window.deliveryaddress.isEmpty()
							&& !Window.deliverypostcode.isEmpty()
							&& !Window.deliverylocation.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 637);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Delivery address:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 611);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.deliverypostcode + " "
								+ Window.deliverylocation);
						canvas.endText();
						canvas.restoreState();
					}
					// INVOICING ADDRESS
					if (!Window.address.isEmpty() && !Window.postcode.isEmpty()
							&& !Window.location.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 598);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Invoicing address:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 572);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode + " " + Window.location);
						canvas.endText();
						canvas.restoreState();
					}
					// DE / FROM
					if (!Window.from.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 663);
						canvas.setFontAndSize(font, 10);
						canvas.showText("From:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(410, 663);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.from);
						canvas.endText();
						canvas.restoreState();
					}
					// A / TO
					if (!Window.to.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 650);
						canvas.setFontAndSize(font, 10);
						canvas.showText("To:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(395, 650);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.to);
						canvas.endText();
						canvas.restoreState();
					}
					// Subject
					if (!Window.object.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 588);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Subject: ");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(100, 588);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.object); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}

					// PAYMENT
					if (!Window.payment.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(59, 341); // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText("Payment:"); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();

						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(103, 341); // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText(Window.payment); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}

					canvas.saveState(); // q
					canvas.beginText(); // BT
					canvas.moveText(59, 304); // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12
																		// Tf
					canvas.showText("- Delivery terms: 3/4 weeks from the date we receive the order"); // (Hello
																										// World)Tj
					canvas.endText(); // ET
					canvas.restoreState();

					canvas.saveState(); // q
					canvas.beginText(); // BT
					canvas.moveText(59, 291); // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12
																		// Tf
					canvas.showText("- Validity offer: 2 months"); // (Hello
																	// World)Tj
					canvas.endText(); // ET
					canvas.restoreState();

					/* INCOTERM */
					if (!Window.incoterm.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(59, 328); // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText("Incoterm:"); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();

						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(103, 328); // 36 788 Td
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText(Window.incoterm); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
				}
				/*********************************** ITALIEN **********************************/
				else if (Window.locale.toString().equals("it")) {
					// Riferimento
					if (!Window.referencequot.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 695);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Riferimento :");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(440, 695);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.referencequot);
						canvas.endText();
						canvas.restoreState();
					}
					// Indirizzo di consegna
					if (!Window.deliveryaddress.isEmpty()
							&& !Window.deliverypostcode.isEmpty()
							&& !Window.deliverylocation.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 637);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Indirizzo di consegna:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 611);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.deliverypostcode + " "
								+ Window.deliverylocation);
						canvas.endText();
						canvas.restoreState();
					}
					// Indirizzo di fatturazione
					if (!Window.address.isEmpty() && !Window.postcode.isEmpty()
							&& !Window.location.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 598);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Indirizzo di fatturazione:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 572);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode + " " + Window.location);
						canvas.endText();
						canvas.restoreState();
					}
					// DA
					if (!Window.from.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 663);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Da :");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(398, 663);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.from);
						canvas.endText();
						canvas.restoreState();
					}
					// A
					if (!Window.to.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 650);
						canvas.setFontAndSize(font, 10);
						canvas.showText("A :");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(393, 650);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.to);
						canvas.endText();
						canvas.restoreState();
					}
					// Soggetto
					if (!Window.object.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						// canvas.moveText(59, 588);
						canvas.moveText(59, 535);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Soggetto : ");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						// canvas.moveText(113, 588);
						canvas.moveText(113, 535);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.object);
						canvas.endText();
						canvas.restoreState();
					}
					// PAYMENT
					if (!Window.payment.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 311);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Pagamento: " + Window.payment);
						canvas.endText();
						canvas.restoreState();
					}

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 274);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Termini di consegna: 3/4 settimane dalla data  ricezione ordine");
					canvas.endText();
					canvas.restoreState();

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 261);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Validità dell'offerta: 2 mesi");
					canvas.endText();
					canvas.restoreState();

					/* INCOTERM */
					if (!Window.incoterm.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 298);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Incoterm: " + Window.incoterm);
						canvas.endText();
						canvas.restoreState();
					}
				}
				/******************************** FRANCAIS *********************************/
				else if (Window.locale.toString().equals("fr")) {
					// REFERENCE
					if (!Window.referencequot.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 695);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Référence :");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(436, 695);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.referencequot);
						canvas.endText();
						canvas.restoreState();
					}
					// Adresse de livraison
					if (!Window.deliveryaddress.isEmpty()
							&& !Window.deliverypostcode.isEmpty()
							&& !Window.deliverylocation.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 637);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Adresse de livraison:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 624);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.deliveryaddress);
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 611);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.deliverypostcode + " "
								+ Window.deliverylocation);
						canvas.endText();
						canvas.restoreState();
					}
					// Adresse de facturation
					if (!Window.address.isEmpty() && !Window.postcode.isEmpty()
							&& !Window.location.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 598);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Adresse de facturation:");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 585);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.address);
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 572);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.postcode + " " + Window.location);
						canvas.endText();
						canvas.restoreState();
					}
					// DE
					if (!Window.from.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 663);
						canvas.setFontAndSize(font, 10);
						canvas.showText("De :");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(398, 663);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.from);
						canvas.endText();
						canvas.restoreState();
					}
					// A
					if (!Window.to.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(375, 650);
						canvas.setFontAndSize(font, 10);
						canvas.showText("A :");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(393, 650);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.to);
						canvas.endText();
						canvas.restoreState();
					}
					// Odre d'achat
					if (!Window.object.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 588);
						canvas.setFontAndSize(font, 10);
						canvas.showText("Objet : ");
						canvas.endText();
						canvas.restoreState();

						canvas.saveState();
						canvas.beginText();
						canvas.moveText(95, 588);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.object);
						canvas.endText();
						canvas.restoreState();
					}

					// PAYMENT
					if (!Window.payment.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 341);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Paiement : " + Window.payment);
						canvas.endText();
						canvas.restoreState();
					}

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 304);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Conditions de livraison : 3/4 semaines à partir de la date de réception de l'ordre");
					canvas.endText();
					canvas.restoreState();

					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 291);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("- Validité de l'offre : 2 mois");
					canvas.endText();
					canvas.restoreState();

					/* INCOTERM */
					if (!Window.incoterm.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(59, 328);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Incoterm : " + Window.incoterm);
						canvas.endText();
						canvas.restoreState();
					}
				}

				/* DATE */
				if (!Window.date.isEmpty()) {
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(437, 748);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText(Window.date);
					canvas.endText();
					canvas.restoreState();
				}

				if (Window.locale.toString().equals("en")) {
					/* MR OU MS + RECIPIENT NAME */
					if (jCb_Mr.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Mr,");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_Mr.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Mr " + Window.recipientname + ",");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_Mrs.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms,");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_Mrs.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms " + Window.recipientname + ",");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_no.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(",");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_no.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.recipientname + ",");
						canvas.endText();
						canvas.restoreState();
					}
				} else if (Window.locale.toString().equals("it")) {
					/* MR OU MS + RECIPIENT NAME */
					if (jCb_Mr.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 493);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Mr,");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_Mr.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 493);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Mr " + Window.recipientname + ",");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_Mrs.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 493);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms,");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_Mrs.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 493);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText("Ms " + Window.recipientname + ",");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_no.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 493);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(",");
						canvas.endText();
						canvas.restoreState();
					}
					if (jCb_no.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState();
						canvas.beginText();
						canvas.moveText(130, 493);
						canvas.setFontAndSize(BaseFont.createFont(), 10);
						canvas.showText(Window.recipientname + ",");
						canvas.endText();
						canvas.restoreState();
					}
				} else if (Window.locale.toString().equals("fr")) {
					/* MR OU MS + RECIPIENT NAME */
					if (jCb_Mr.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText("Mr,"); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
					if (jCb_Mr.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText("Mr " + Window.recipientname + ","); // (Hello
																				// World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
					if (jCb_Mrs.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText("Ms,"); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
					if (jCb_Mrs.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText("Ms " + Window.recipientname + ","); // (Hello
																				// World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
					if (jCb_no.isSelected() && Window.recipientname.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText(","); // (Hello World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
					if (jCb_no.isSelected() && !Window.recipientname.isEmpty()) {
						canvas.saveState(); // q
						canvas.beginText(); // BT
						canvas.moveText(84, 539);
						canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1
																			// 12
																			// Tf
						canvas.showText(Window.recipientname + ","); // (Hello
																		// World)Tj
						canvas.endText(); // ET
						canvas.restoreState();
					}
				}

				/* NOM + PRENOM USER */
				if (!Window.salesman.isEmpty()) {
					canvas.saveState(); // q
					canvas.beginText(); // BT
					canvas.moveText(59, 168); // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12
																		// Tf
					canvas.showText(Window.salesman + " " + Window.gsm); // (Hello
																			// World)Tj
					canvas.endText(); // ET
					canvas.restoreState();
				}
				/* TEL USER */
				if (!Window.tel.isEmpty()) {
					canvas.saveState();
					canvas.beginText();
					canvas.moveText(59, 156);
					canvas.setFontAndSize(BaseFont.createFont(), 10);
					canvas.showText("Tel: " + Window.tel);
					canvas.endText();
					canvas.restoreState();
				}
				/* FAX */
				if (!Window.fax.isEmpty()) {
					canvas.saveState(); // q
					canvas.beginText(); // BT
					canvas.moveText(59, 144); // 36 788 Td
					canvas.setFontAndSize(BaseFont.createFont(), 10); // /F1 12
																		// Tf
					canvas.showText("Fax: " + Window.fax); // (Hello World)Tj
					canvas.endText(); // ET
					canvas.restoreState();
				}
				/* MAIL */
				if (!Window.email.isEmpty()) {
					BaseFont font1 = FontFactory.getFont(BaseFont.HELVETICA,
							10, BaseColor.BLUE).getCalculatedBaseFont(true);
					canvas.saveState(); // q
					canvas.beginText(); // BT
					canvas.moveText(59, 131); // 36 788 Td
					canvas.setFontAndSize(font1, 10); // /F1 12 Tf
					canvas.showText("Email: " + Window.email); // (Hello
																// World)Tj
					canvas.endText(); // ET
					canvas.restoreState();
				}
				document2.close();

				// PdfReader reader1 = new PdfReader("quotationform.pdf");
				PdfReader reader1 = null;

				if (Window.locale.toString().equals("en")) {
					System.out.println("en");
					reader1 = new PdfReader("quotationform.pdf");
				} else if (Window.locale.toString().equals("it")) {
					System.out.println("it");
					reader1 = new PdfReader("quotationformIT.pdf");
				} else if (Window.locale.toString().equals("fr")) {
					System.out.println("fr");
					reader1 = new PdfReader("quotationformFR.pdf");
				}

				Document document4 = new Document();
				PdfCopy copy = new PdfCopy(document4, new FileOutputStream(
						"quotationfinal.pdf"));

				document4.open();
				PdfImportedPage page1 = copy.getImportedPage(reader1, 1);
				copy.addPage(page1);

				PdfReader reader2 = new PdfReader("text.pdf");
				PdfImportedPage page2 = copy.getImportedPage(reader2, 1);
				copy.addPage(page2);

				copy.close();
				document4.close();

				PdfReader reader5 = new PdfReader("quotationfinal.pdf");

				Document document6 = new Document(PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer6 = PdfWriter.getInstance(document6,
						new FileOutputStream("quotation2.pdf"));
				Footer event1 = new Footer();
				writer6.setBoxSize("art", new Rectangle(36, 54, 559, 788));
				writer6.setPageEvent(event1);
				event1.settotal(reader.getNumberOfPages() + 1);
				document6.open();

				for (int i = 1; i <= reader.getNumberOfPages(); i++) {
					document6.newPage();
					writer6.setPageEmpty(false);
				}

				document6.close();
				PdfReader reader6 = new PdfReader("quotation2.pdf");

				Document document7 = new Document();
				PdfWriter writer7 = PdfWriter.getInstance(document7,
						new FileOutputStream("quotation3.pdf"));

				document7.open();

				PdfContentByte canvas3 = writer7.getDirectContent();

				for (int j = 1; j <= reader.getNumberOfPages(); j++) {
					page1 = writer7.getImportedPage(reader, j);
					canvas3.addTemplate(page1, 1f, 0, 0, 1, 0, 0);
					page2 = writer7.getImportedPage(reader6, j);
					canvas3.addTemplate(page2, 1f, 0, 0, 1, 0, 0);
					document7.newPage();
				}

				document7.close();

				reader = new PdfReader("quotation3.pdf");

				Document document3 = new Document(PageSize.A4, 36, 36, 54, 54);
				PdfWriter writer3 = PdfWriter.getInstance(document3,
						new FileOutputStream("quotationfinal1.pdf"));

				document3.open();

				PdfContentByte canvas2 = writer3.getDirectContent();
				PdfImportedPage page;

				for (int i = 1; i <= reader5.getNumberOfPages(); i++) {
					page = writer3.getImportedPage(reader5, i);
					canvas2.addTemplate(page, 1f, 0, 0, 1, 0, 0);
				}

				document3.close();

				PdfReader reader3 = new PdfReader("quotationfinal1.pdf");

				Document document1 = new Document();
				if (chooser.getSelectedFile().getAbsolutePath()
						.endsWith(".pdf")) {
					copy = new PdfCopy(document1, new FileOutputStream(chooser
							.getSelectedFile().getAbsolutePath()));
				} else {
					copy = new PdfCopy(document1, new FileOutputStream(chooser
							.getSelectedFile().getAbsolutePath() + ".pdf"));
				}

				document1.open();

				page1 = copy.getImportedPage(reader3, 1);
				copy.addPage(page1);

				for (int i = 1; i <= reader.getNumberOfPages(); i++) {
					page2 = copy.getImportedPage(reader, i);
					copy.addPage(page2);
				}

				copy.close();

				document1.close();

				File file = new File("quotationfinal1.pdf");
				file.delete();
				file = new File("quotation.pdf");
				file.delete();
				file = new File("quotationfinal.pdf");
				file.delete();
				file = new File("text.pdf");
				file.delete();
				file = new File("quotation2.pdf");
				file.delete();
				file = new File("quotation3.pdf");
				file.delete();
				file = new File("quotationform2.pdf");
				file.delete();
				WritableSheet sheet;
				Workbook workbook;
				WritableWorkbook wwork;
				WritableCell cell;

				try {
					if (!new File("./Summary offers.xls").exists()) {

						WritableWorkbook wworkbook;

						wworkbook = Workbook.createWorkbook(new File(
								"./Summary offers.xls"));

						WritableSheet wsheet = wworkbook.createSheet(
								"Savedata", 0);
						WritableFont titrefont = new WritableFont(
								WritableFont.ARIAL, 10, WritableFont.BOLD);

						wsheet.setColumnView(0, 20);

						wsheet.setColumnView(1, 40);
						wsheet.setColumnView(2, 30);
						wsheet.setColumnView(3, 40);
						wsheet.setColumnView(4, 30);
						wsheet.setColumnView(5, 50);
						wsheet.setColumnView(6, 25);
						wsheet.setColumnView(7, 25);

						WritableCellFormat format = new WritableCellFormat(
								titrefont);
						format.setBackground(Colour.WHITE);
						format.setAlignment(Alignment.CENTRE);
						format.setVerticalAlignment(VerticalAlignment.CENTRE);
						format.setOrientation(Orientation.HORIZONTAL);
						format.setBorder(Border.ALL, BorderLineStyle.THIN,
								Colour.BLACK);
						format.setShrinkToFit(true);
						format.setWrap(true);

						Label label = new Label(0, 0, "DATE", format);
						wsheet.addCell(label);
						label = new Label(1, 0, "REFERENCE", format);
						wsheet.addCell(label);
						label = new Label(2, 0, "FROM", format);
						wsheet.addCell(label);
						label = new Label(3, 0, "CUSTOMER", format);
						wsheet.addCell(label);
						label = new Label(4, 0, "NAME", format);
						wsheet.addCell(label);
						label = new Label(5, 0, "BUISNESS NAME", format);
						wsheet.addCell(label);
						label = new Label(6, 0, "PURCHASE PRICE", format);
						wsheet.addCell(label);
						label = new Label(7, 0, "QUOTATION PRICE", format);
						wsheet.addCell(label);

						wworkbook.write();
						wworkbook.close();

						System.out.println("Creation de ./Summary offers.xls");
					}

					workbook = Workbook.getWorkbook(new File(
							"./Summary offers.xls"));
					wwork = Workbook.createWorkbook(new File(
							"./Summary offers.xls"), workbook);

					sheet = wwork.getSheet(0);

					Window.df.setMaximumFractionDigits(2);
					Window.df.setMinimumFractionDigits(2);
					exist = false;

					for (int k = 0; k <= sheet.getRows() - 1; k++) {
						if (sheet.getCell(0, k).getContents()
								.equals(Window.date)
								&& sheet.getCell(1, k).getContents()
										.equals(Window.referencequot)
								&& sheet.getCell(2, k).getContents()
										.equals(Window.from)
								&& sheet.getCell(3, k).getContents()
										.equals(Window.to)
								&& sheet.getCell(4, k)
										.getContents()
										.equals(Window.salesman + " "
												+ Window.gsm)
								&& sheet.getCell(5, k).getContents()
										.equals(Window.object)
								&& sheet.getCell(6, k)
										.getContents()
										.equals(Window.df
												.format(Window.buyprice))
								&& sheet.getCell(7, k)
										.getContents()
										.equals(Window.df
												.format(Window.quotationprice)))
							exist = true;
					}

					if (!exist) {
						Label label = null;
						int row = sheet.getRows();

						for (int i = 0; i <= 7; i++) {
							cell = sheet.getWritableCell(i, sheet.getRows());

							if (i == 0)
								label = new Label(i, row, Window.date);

							if (i == 1)
								label = new Label(i, row, Window.referencequot);

							if (i == 2)
								label = new Label(i, row, Window.from);

							if (i == 3)
								label = new Label(i, row, Window.to);

							if (i == 4)
								label = new Label(i, row, Window.salesman + " "
										+ Window.gsm);

							if (i == 5)
								label = new Label(i, row, Window.object);

							if (i == 6)
								label = new Label(i, row,
										Window.df.format(Window.buyprice));

							if (i == 7)
								label = new Label(i, row,
										Window.df.format(Window.quotationprice));

							sheet.addCell(label);
						}
					}
					wwork.write();
					wwork.close();
					System.out
							.println("Sauvegarde quotation dans ./Summary offers.xls");
				} catch (Exception e) {
					System.out.println(e);
				}

				if (chooser.getSelectedFile().getAbsolutePath()
						.endsWith(".pdf"))
					Window.printermailer = chooser.getSelectedFile()
							.getAbsolutePath();
				else
					Window.printermailer = chooser.getSelectedFile()
							.getAbsolutePath() + ".pdf";

				// On vérifie que la classe Desktop soit bien supportée :
				if (Desktop.isDesktopSupported()) {
					// On récupère l'instance du desktop :
					Desktop desktop = Desktop.getDesktop();

					// On vérifie que la fonction open est bien supportée :
					if (desktop.isSupported(Desktop.Action.OPEN)) {
						System.out.println(Window.printermailer);
						// Et on lance l'application associé au fichier pour
						// l'ouvrir :
						desktop.open(new File(Window.printermailer)
								.getAbsoluteFile());
					}
				}
			}
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,
					"The file has been saved in " + Window.printermailer);
		}
	}

	public static PdfPTable createTable(Document document)
			throws DocumentException, MalformedURLException, IOException {

		PdfPTable table = null;
		PdfPTable table2 = null;

		table = new PdfPTable(6);
		table.setWidths(new float[] { (float) 1, (float) 1.6, (float) 6,
				(float) 0.7, (float) 1.6, (float) 1.4 });
		table.setWidthPercentage(100f);

		table2 = new PdfPTable(6);
		table2.setWidths(new float[] { (float) 1, (float) 1.6, (float) 6,
				(float) 0.7, (float) 1.4, (float) 1.4 });
		table2.setWidthPercentage(101f);

		PdfPCell cell = new PdfPCell();
		addHeader(table, cell);

		for (int i = 0; i <= Window.reference.size() - 1; i++) {

			// Si Reference + index VIDES et description non VIDE
			if (Window.reference.get(i).isEmpty()
					&& Window.index.get(i).toString().isEmpty()
					&& !Window.description.get(i).toString().isEmpty()) {

				cell = new PdfPCell(new Phrase(Window.description.get(i),
						new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setBackgroundColor(BaseColor.CYAN);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(6);

				table.addCell(cell);
			}

			// Si Reference VIDE et Index non VIDE
			else if (Window.reference.get(i).isEmpty()
					&& !Window.index.get(i).toString().isEmpty()) {
				cell = new PdfPCell(new Phrase(Window.index.get(i).toString(),
						new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

				table.addCell(cell);
				cell = new PdfPCell(new Phrase(Window.description.get(i),
						new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));

				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(6);

				table.addCell(cell);
			}

			// Si Reference + Index + Description VIDES
			else if (Window.reference.get(i).isEmpty()
					&& Window.index.get(i).toString().isEmpty()
					&& Window.description.get(i).toString().isEmpty()) {
				document.add(table);

				table = new PdfPTable(6);
				table.setWidths(new float[] { (float) 1, (float) 1.6,
						(float) 6, (float) 0.7, (float) 1.4, (float) 1.4 });
				table.setWidthPercentage(100f);
				addHeader(table, cell);
				System.out.println("Reference + Index + Description vides");
			} else {
				cell = new PdfPCell(new Phrase(Window.index.get(i).toString(),
						new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.reference.get(i),
						new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.description.get(i),
						new Font(FontFamily.HELVETICA, 7, Font.NORMAL)));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.quantity.get(i),
						new Font(FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);

				// Affichage normal
				if (!Window.printDiscount) {
					Phrase phrase = new Phrase(Window.price.get(i) + " €",
							new Font(FontFamily.HELVETICA, 8, Font.NORMAL));
					cell = new PdfPCell(phrase);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				}
				// Affichage avec le discount
				else if (Window.printDiscount) {
					Phrase phrase = new Phrase(Window.price.get(i) + " €"
							+ "\n" + "  (" + Window.discountprod.get(i) + "%)",
							new Font(FontFamily.HELVETICA, 8, Font.NORMAL));
					cell = new PdfPCell(phrase);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell);
				}

				cell = new PdfPCell(new Phrase(
						Window.totalyprice.get(i) + " €", new Font(
								FontFamily.HELVETICA, 8, Font.NORMAL)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(cell);
			}
		}

		if (!Window.refund) {
			if (!Window.transport) {
				cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			} else {
				cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TRANSPORT COST", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.transportval).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TOTAL in EUROS with transport",
						new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.YELLOW);
				cell.setColspan(5);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice + Window.transportval)
						.replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			}
		} else {
			if (!Window.transport) {
				cell = new PdfPCell(new Phrase("TOTAL in EUROS", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("SPECIAL DISCOUNT ("
						+ Window.discount + "%)", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice * Window.discount / 100)
						.replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TOTAL with SPECIAL DISCOUNT",
						new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice - Window.quotationprice
								* Window.discount / 100).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			} else {

				cell = new PdfPCell(new Phrase(
						"TOTAL in EUROS without transport", new Font(
								FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("SPECIAL DISCOUNT ("
						+ Window.discount + "%)", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice * Window.discount / 100)
						.replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TOTAL with SPECIAL DISCOUNT",
						new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setColspan(5);
				cell.setBackgroundColor(BaseColor.YELLOW);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.quotationprice - Window.quotationprice
								* Window.discount / 100).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TRANSPORT COST", new Font(
						FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.YELLOW);
				cell.setColspan(5);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						Window.transportval).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase("TOTAL in EUROS with transport",
						new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.YELLOW);
				cell.setColspan(5);
				table2.addCell(cell);

				cell = new PdfPCell(new Phrase(Window.df.format(
						(Window.quotationprice - Window.quotationprice
								* Window.discount / 100)
								+ Window.transportval).replaceAll(",", " ")
						+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				table2.addCell(cell);
			}
		}
		if (Window.assistance != 0) {
			cell = new PdfPCell(new Phrase("START-UP COST", new Font(
					FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.YELLOW);
			cell.setColspan(5);
			table2.addCell(cell);

			cell = new PdfPCell(new Phrase(Window.df.format(Window.assistance)
					.replaceAll(",", " ") + " €", new Font(
					FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table2.addCell(cell);

			cell = new PdfPCell(new Phrase("TOTAL in EUROS with start-up",
					new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.YELLOW);
			cell.setColspan(5);
			table2.addCell(cell);

			cell = new PdfPCell(new Phrase(Window.df.format(
					(Window.quotationprice - Window.quotationprice
							* Window.discount / 100)
							+ Window.transportval + Window.assistance)
					.replaceAll(",", " ")
					+ " €", new Font(FontFamily.HELVETICA, 8, Font.BOLD)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table2.addCell(cell);
		}

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(30f);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Order confirmation : ", new Font(
				FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(3);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Date : ", new Font(
				FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(20f);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Name : ", new Font(
				FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(20f);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Signature : ", new Font(
				FontFamily.HELVETICA, 8, Font.BOLD)));
		cell.setColspan(3);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(3);
		cell.setFixedHeight(50f);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setFixedHeight(5f);
		table2.addCell(cell);

		cell = new PdfPCell(new Phrase("Please send it back by mail ("
				+ Window.conpanyemail + ") or by fax (" + Window.conpanyfax
				+ ")", new Font(FontFamily.HELVETICA, 6, Font.BOLD)));
		cell.setColspan(6);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.addCell(cell);

		cell = new PdfPCell();
		cell.setColspan(6);
		cell.setBorder(Rectangle.NO_BORDER);
		table2.setTotalWidth(table.getTotalWidth() + cell.getBorderWidth());
		table.setExtendLastRow(true);
		cell.addElement(table2);
		table.addCell(cell);

		if (!jTa_comment.getText().contentEquals("")) {
			cell = new PdfPCell(new Phrase("*NB:\n\n" + jTa_comment.getText(),
					new Font(FontFamily.HELVETICA, 10, Font.NORMAL)));
			cell.setColspan(6);
			cell.setFixedHeight(80f);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBorder(Rectangle.NO_BORDER);
			table2.addCell(cell);
		}
		return table;
	}

	private static void addHeader(PdfPTable table, PdfPCell cell) {
		cell = new PdfPCell(new Phrase("Index", new Font(FontFamily.HELVETICA,
				10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("CODE", new Font(FontFamily.HELVETICA,
				10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("DESCRIPTION", new Font(
				FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Qty", new Font(FontFamily.HELVETICA,
				10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);

		if (!Window.printDiscount) {
			cell = new PdfPCell(new Phrase("Unit net price in €", new Font(
					FontFamily.HELVETICA, 10, Font.BOLD)));
			cell.setFixedHeight(36f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setNoWrap(false);
			table.addCell(cell);
		} else if (Window.printDiscount) {
			cell = new PdfPCell(new Phrase("Unit price\n in € \n(discount %)",
					new Font(FontFamily.HELVETICA, 10, Font.BOLD)));
			cell.setFixedHeight(36f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setNoWrap(false);
			table.addCell(cell);
		}
		cell = new PdfPCell(new Phrase("Total net price in €", new Font(
				FontFamily.HELVETICA, 10, Font.BOLD)));
		cell.setFixedHeight(36f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setNoWrap(false);
		table.addCell(cell);

		table.setHeaderRows(1);
	}

	private static void padding(PdfPCell cell, int n) {
		try {
			cell.setPadding(n);
		} catch (Exception e) {
			padding(cell, n - 1);
		}
	}
}