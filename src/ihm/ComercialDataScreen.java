package ihm;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JDialog;


import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ComercialDataScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JTextField jTextField5;
	
	public ComercialDataScreen() throws IndexOutOfBoundsException, BiffException, IOException {
		initComponents();
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_userData"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_userData"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_userData"));
		}
		
		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setModal(true);
		this.pack();
	}

	private void initComponents() throws IndexOutOfBoundsException, BiffException, IOException {

		jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        WorkbookSettings ws=new WorkbookSettings();
		ws.setSuppressWarnings(true);
		Sheet sheet=Workbook.getWorkbook(new File("comercialdata.info"),ws).getSheet(0);
		
		if(Window.locale.toString().equals("en")){
			
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
	        jLabel5.setText("<html><h3>" + (String)Window.res.getObject("lb_userData"));
	        jLabel5.setBounds(10, 0, 230, 37);
	        
	        jLabel1.setText((String)Window.res.getObject("lb_firstName"));
	        jLabel1.setBounds(30, 40, 100, 20);
	        jTextField1.setBounds(90, 40, 130, 20);
	        
	        jLabel3.setText((String)Window.res.getObject("lb_lastName"));
	        jLabel3.setBounds(30, 70, 100, 20);
	        jTextField2.setBounds(90, 70, 130, 20);
	        
	        jLabel2.setText((String)Window.res.getObject("lb_tel"));
	        jLabel2.setBounds(30, 100, 100, 20);
	        jTextField3.setBounds(90, 100, 130, 20);
	        
	        jLabel4.setText((String)Window.res.getObject("lb_fax"));
	        jLabel4.setBounds(30, 130, 90, 20);
	        jTextField4.setBounds(90, 130, 130, 20);
	        
	        jLabel6.setText((String)Window.res.getObject("lb_mail"));
	        jLabel6.setBounds(30, 160, 28, 20);
	        jTextField5.setBounds(90, 160, 130, 20);
	       
	        jButton1.setText((String)Window.res.getObject("bt_save"));
	        jButton1.setBounds(240, 180, 60, 23);
		}
		
		else if(Window.locale.toString().equals("it")){
			
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
	        jLabel5.setText("<html><h3>" + (String)Window.res.getObject("lb_userData"));
	        jLabel5.setBounds(10, 0, 230, 37);
	        
	        jLabel1.setText((String)Window.res.getObject("lb_firstName"));
	        jLabel1.setBounds(30, 40, 100, 20);
	        jTextField1.setBounds(90, 40, 130, 20);
	        
	        jLabel3.setText((String)Window.res.getObject("lb_lastName"));
	        jLabel3.setBounds(30, 70, 100, 20);
	        jTextField2.setBounds(90, 70, 130, 20);
	        
	        jLabel2.setText((String)Window.res.getObject("lb_tel"));
	        jLabel2.setBounds(30, 100, 100, 20);
	        jTextField3.setBounds(90, 100, 130, 20);
	        
	        jLabel4.setText((String)Window.res.getObject("lb_fax"));
	        jLabel4.setBounds(30, 130, 90, 20);
	        jTextField4.setBounds(90, 130, 130, 20);
	        
	        jLabel6.setText((String)Window.res.getObject("lb_mail"));
	        jLabel6.setBounds(30, 160, 28, 20);
	        jTextField5.setBounds(90, 160, 130, 20);
	       
	        jButton1.setText((String)Window.res.getObject("bt_save"));
	        jButton1.setBounds(240, 180, 60, 23);
		}

		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
	
			jLabel5.setText("<html><h3>" + (String)Window.res.getObject("lb_userData"));
			jLabel5.setBounds(10, 0, 230, 37);
			
			jLabel1.setText((String)Window.res.getObject("lb_firstName"));
			jLabel1.setBounds(30, 40, 100, 20);
			jTextField1.setBounds(90, 40, 130, 20);
    
			jLabel3.setText((String)Window.res.getObject("lb_lastName"));
			jLabel3.setBounds(30, 70, 100, 20);
			jTextField2.setBounds(90, 70, 130, 20);
    
			jLabel2.setText((String)Window.res.getObject("lb_tel"));
			jLabel2.setBounds(30, 100, 100, 20);
			jTextField3.setBounds(90, 100, 130, 20);
    
			jLabel4.setText((String)Window.res.getObject("lb_fax"));
			jLabel4.setBounds(30, 130, 90, 20);
			jTextField4.setBounds(90, 130, 130, 20);
    
			jLabel6.setText((String)Window.res.getObject("lb_mail"));
			jLabel6.setBounds(30, 160, 28, 20);
			jTextField5.setBounds(90, 160, 130, 20);
   
			jButton1.setText((String)Window.res.getObject("bt_save"));
			jButton1.setBounds(240, 180, 60, 23);
		}
		
		//Label User data
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        //Label + TextField First name
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        //Label Last name
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        //Label Phone Nb
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        //Label Fax
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        //Label + TextField Email
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        //Button Save
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
        	
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} 
				catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        this.getContentPane().setBackground(Color.white);
     
        jTextField1.setText(sheet.getCell(1,0).getContents());
        jTextField2.setText(sheet.getCell(1,1).getContents());
        jTextField3.setText(sheet.getCell(1,2).getContents());
        jTextField4.setText(sheet.getCell(1,3).getContents());
        jTextField5.setText(sheet.getCell(1,4).getContents());
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IndexOutOfBoundsException, BiffException, IOException, RowsExceededException, WriteException {
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("comercialdata.info")); 
			WritableSheet sheet = workbook.createSheet("Comercial data", 0); 
			File f=new File("Comercial data");
			f.setReadable(true);
			f.setWritable(true);

			Label label = new Label(1,0, jTextField1.getText()); 
			sheet.addCell(label);
			label = new Label(1, 1, jTextField2.getText()); 
			sheet.addCell(label); 
			label = new Label(1, 2, jTextField3.getText()); 
			sheet.addCell(label); 
			label = new Label(1, 3, jTextField4.getText()); 
			sheet.addCell(label); 
			label = new Label(1, 4, jTextField5.getText()); 
			sheet.addCell(label); 
			//label = new Label(1,5, "\\\\SERVEUR\\commercial\\CONTACTS\\DATABASE Clients QSOFT\\BDD-Clients SD3 Row.xls");
			//sheet.addCell(label);
			workbook.write(); 
			workbook.close();
			
			System.out.println("-> Modification de " + f );
			//System.out.println("-> db: " + sheet.getCell(1,5).getContents() );
		
			dispose();
		}
		catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null,e); 
		}
	}
}