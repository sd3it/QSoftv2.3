/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Proforma.java
 *
 * Created on 14 juin 2011, 10:51:37
 */
package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author SD3 COM
 */
public class ProformaScreen extends javax.swing.JDialog {

    /** Creates new form Proforma */
    public ProformaScreen() {
        initComponents();
        
        if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_ExportProforma"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_ExportProforma"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_ExportProforma"));
		}
        
        this.setIconImage(new ImageIcon("logoframe.png").getImage());
        this.setModal(true);
        this.pack();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jCheckBox4 = new javax.swing.JCheckBox();
		jCheckBox5 = new javax.swing.JCheckBox();
		jTextField8 = new javax.swing.JTextField();
	    jLabel8 = new javax.swing.JLabel();
	    jCheckBox1 = new javax.swing.JCheckBox();
	    jCheckBox2 = new javax.swing.JCheckBox();
	    
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			jLabel1.setText((String)Window.res.getObject("lb_date"));
			jLabel1.setBounds(30, 20, 30, 20);
			
			jLabel2.setText((String)Window.res.getObject("lb_ref"));
			jLabel2.setBounds(30, 50, 70, 20);
			jTextField2.setBounds(90, 50, 120, 20);
			jTextField2.setText(Window.referencequot);
			
			jLabel3.setText((String)Window.res.getObject("lb_carriageCompany"));
			jLabel3.setBounds(30, 110, 110, 20);
			jTextField3.setBounds(140, 110, 150, 20);
			jTextField3.setText(Window.carriagecompany);
			
			jLabel4.setText((String)Window.res.getObject("lb_postage"));
			jLabel4.setBounds(30, 140, 70, 20);
			jTextField4.setBounds(90, 140, 150, 20);
			jTextField4.setText(Window.incoterm);
			
			jLabel5.setText((String)Window.res.getObject("lb_invoiceAddress"));
			jLabel5.setBounds(30, 170, 110, 20);
			jTextField5.setBounds(140, 170, 170, 20);
			jTextField5.setText(Window.address);
			
			jLabel6.setText((String)Window.res.getObject("lb_invoicePostcode"));
			jLabel6.setBounds(30, 200, 70, 20);
			jTextField6.setBounds(110, 200,70, 20);
			jTextField6.setText(Window.postcode);
			
			jLabel7.setText((String)Window.res.getObject("lb_townCountry"));
			jLabel7.setBounds(30, 230, 90, 20);
			jTextField7.setBounds(110, 230,200, 20);
			jTextField7.setText(Window.location);
	        
			jLabel8.setText((String)Window.res.getObject("lb_customer"));
			jLabel8.setBounds(30, 80, 90, 20);
			jTextField8.setBounds(110, 80, 200, 20);
			jTextField8.setText(Window.customer);
	        
			jCheckBox1.setText((String)Window.res.getObject("cb_PdfFormat"));
			jCheckBox1.setBounds(30, 260, 90, 20);

			jCheckBox2.setText((String)Window.res.getObject("cb_ExcelFromat"));
			jCheckBox2.setBounds(140, 260, 90, 20);
			
	        jButton1.setText((String)Window.res.getObject("bt_print"));
	        jButton1.setBounds(330, 260, 73, 23);
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			jLabel1.setText((String)Window.res.getObject("lb_date"));
			jLabel1.setBounds(30, 20, 30, 20);
			
			jLabel2.setText((String)Window.res.getObject("lb_ref"));
			jLabel2.setBounds(30, 50, 70, 20);
			jTextField2.setBounds(100, 50, 120, 20);
			jTextField2.setText(Window.referencequot);
			
			jLabel3.setText((String)Window.res.getObject("lb_carriageCompany"));
			jLabel3.setBounds(30, 110, 110, 20);
			jTextField3.setBounds(135, 110, 150, 20);
			jTextField3.setText(Window.carriagecompany);
			
			jLabel4.setText((String)Window.res.getObject("lb_postage"));
			jLabel4.setBounds(30, 140, 70, 20);
			jTextField4.setBounds(100, 140, 150, 20);
			jTextField4.setText(Window.incoterm);
			
			jLabel5.setText((String)Window.res.getObject("lb_invoiceAddress"));
			jLabel5.setBounds(30, 170, 140, 20);
			jTextField5.setBounds(160, 170, 170, 20);
			jTextField5.setText(Window.address);
			
			jLabel6.setText((String)Window.res.getObject("lb_invoicePostcode"));
			jLabel6.setBounds(30, 200, 90, 20);
			jTextField6.setBounds(120, 200,70, 20);
			jTextField6.setText(Window.postcode);
			
			jLabel7.setText((String)Window.res.getObject("lb_townCountry"));
			jLabel7.setBounds(30, 230, 90, 20);
			jTextField7.setBounds(100, 230,200, 20);
			jTextField7.setText(Window.location);
	        
			jLabel8.setText((String)Window.res.getObject("lb_customer"));
			jLabel8.setBounds(30, 80, 90, 20);
			jTextField8.setBounds(100, 80, 200, 20);
			jTextField8.setText(Window.customer);
	        
			jCheckBox1.setText((String)Window.res.getObject("cb_PdfFormat"));
			jCheckBox1.setBounds(30, 260, 90, 20);

			jCheckBox2.setText((String)Window.res.getObject("cb_ExcelFromat"));
			jCheckBox2.setBounds(140, 260, 100, 20);
			
	        jButton1.setText((String)Window.res.getObject("bt_print"));
	        jButton1.setBounds(320, 260, 83, 23);
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			jLabel1.setText((String)Window.res.getObject("lb_date"));
			jLabel1.setBounds(30, 20, 30, 20);
			
			jLabel2.setText((String)Window.res.getObject("lb_ref"));
			jLabel2.setBounds(30, 50, 70, 20);
			jTextField2.setBounds(100, 50, 120, 20);
			jTextField2.setText(Window.referencequot);
			
			jLabel3.setText((String)Window.res.getObject("lb_carriageCompany"));
			jLabel3.setBounds(30, 110, 140, 20);
			jTextField3.setBounds(160, 110, 150, 20);
			jTextField3.setText(Window.carriagecompany);
			
			jLabel4.setText((String)Window.res.getObject("lb_postage"));
			jLabel4.setBounds(30, 140, 70, 20);
			jTextField4.setBounds(100, 140, 150, 20);
			jTextField4.setText(Window.incoterm);
			
			jLabel5.setText((String)Window.res.getObject("lb_invoiceAddress"));
			jLabel5.setBounds(30, 170, 110, 20);
			jTextField5.setBounds(140, 170, 170, 20);
			jTextField5.setText(Window.address);
			
			jLabel6.setText((String)Window.res.getObject("lb_invoicePostcode"));
			jLabel6.setBounds(30, 200, 70, 20);
			jTextField6.setBounds(100, 200,70, 20);
			jTextField6.setText(Window.postcode);
			
			jLabel7.setText((String)Window.res.getObject("lb_townCountry"));
			jLabel7.setBounds(30, 230, 90, 20);
			jTextField7.setBounds(100, 230,200, 20);
			jTextField7.setText(Window.location);
	        
			jLabel8.setText((String)Window.res.getObject("lb_customer"));
			jLabel8.setBounds(30, 80, 90, 20);
			jTextField8.setBounds(100, 80, 200, 20);
			jTextField8.setText(Window.customer);
	        
			jCheckBox1.setText((String)Window.res.getObject("cb_PdfFormat"));
			jCheckBox1.setBounds(30, 260, 90, 20);

			jCheckBox2.setText((String)Window.res.getObject("cb_ExcelFromat"));
			jCheckBox2.setBounds(140, 260, 90, 20);
			
	        jButton1.setText((String)Window.res.getObject("bt_print"));
	        jButton1.setBounds(330, 260, 78, 23);
		}
        
		//Date
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField1.setBounds(70, 20, 70, 20);
		jTextField1.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		Window.date=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Reference
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Carriage company
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//postage
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Invoicing address
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		//Postcode
		jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//Town/country
		jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//customer
		jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		//CB Pdf format
		jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox1.setSelected(true);
		jLayeredPane1.add(jCheckBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}

			private void jCheckBox1ActionPerformed(ActionEvent evt) {
				if(jCheckBox1.isSelected()){
					jCheckBox2.setSelected(false);
				}
				else{
					jCheckBox1.setSelected(true);
				}
			}
		});
		
		//CB Excel format
		jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
		jLayeredPane1.add(jCheckBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}

			private void jCheckBox2ActionPerformed(ActionEvent evt) {
				if(jCheckBox2.isSelected()){
					jCheckBox1.setSelected(false);
				}
				else{
					jCheckBox2.setSelected(true);
				}
			}
		});
		
		
		jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox4.setText("dd/mm/yyyy");
		jCheckBox4.setSelected(true);
		jCheckBox4.setBounds(160, 20, 90, 20);
		jLayeredPane1.add(jCheckBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox4ActionPerformed(evt);
			}

			private void jCheckBox4ActionPerformed(ActionEvent evt) {
				if(jCheckBox4.isSelected()){
					jCheckBox5.setSelected(false);
				}
				else{
					jCheckBox4.setSelected(true);
				}
				jTextField1.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				Window.date=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
			}
		});

		jCheckBox5.setText("mm/dd/yyyy");
		jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
		jCheckBox5.setBounds(260, 20, 100, 20);
		jLayeredPane1.add(jCheckBox5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox5ActionPerformed(evt);
			}

			private void jCheckBox5ActionPerformed(ActionEvent evt) {
				if(jCheckBox5.isSelected()){
					jCheckBox4.setSelected(false);
				}
				else{
					jCheckBox5.setSelected(true);
				}
				jTextField1.setText(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
				Window.date=new SimpleDateFormat("MM/dd/yyyy").format(new Date());

			}
		});
		
        //Button Print
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
		);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
		);
		
		this.getContentPane().setBackground(new Color(255, 255, 255));
		
		FocusListener focuslistener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {}

			@Override
			public void focusLost(FocusEvent e) {
			
				if(e.getSource().equals(jTextField2))
				{
					Window.referencequot=jTextField2.getText();
				}
				if(e.getSource().equals(jTextField3))
				{
					Window.carriagecompany=jTextField3.getText();
				}
				if(e.getSource().equals(jTextField4))
				{
					Window.incoterm=jTextField4.getText();
				}
				if(e.getSource().equals(jTextField5))
				{
					Window.address=jTextField5.getText();
				}
				if(e.getSource().equals(jTextField6))
				{
					Window.postcode=jTextField6.getText();
				}
				if(e.getSource().equals(jTextField7))
				{
					Window.location=jTextField7.getText();
				}
				if(e.getSource().equals(jTextField8))
				{
					Window.customer=jTextField8.getText();
				}
			}
		};
			
		jTextField2.addFocusListener(focuslistener);
		jTextField3.addFocusListener(focuslistener);
		jTextField4.addFocusListener(focuslistener);
		jTextField5.addFocusListener(focuslistener);
		jTextField6.addFocusListener(focuslistener);
		jTextField7.addFocusListener(focuslistener);
		jTextField8.addFocusListener(focuslistener);
    }

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws BiffException, WriteException, IOException {
		if(jCheckBox1.isSelected()){
			PdfInvoiceExport ie = new PdfInvoiceExport(
				jTextField1.getText(), 
				jTextField2.getText(), 
				jTextField3.getText(), 
				jTextField4.getText(), 
				jTextField5.getText(), 
				jTextField6.getText(), 
				jTextField7.getText(), 
				jTextField8.getText()
			);
			ie.print();
		}
		
		if(jCheckBox2.isSelected()){
			ExcelInvoiceExport eie=new ExcelInvoiceExport();
			eie.export();
		}
		this.dispose();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JCheckBox jCheckBox4;
	private javax.swing.JCheckBox jCheckBox5;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
}