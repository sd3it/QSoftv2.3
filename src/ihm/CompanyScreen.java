package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
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

public class CompanyScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	
	public CompanyScreen() throws IndexOutOfBoundsException, BiffException, IOException {
		initComponents();
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_companyData"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_companyData"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_companyData"));
		}
		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setModal(true);
		this.pack();
	}

	private void initComponents() throws IndexOutOfBoundsException, BiffException, IOException {
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		
		WorkbookSettings ws=new WorkbookSettings();
		ws.setSuppressWarnings(true);
		Sheet sheet=Workbook.getWorkbook(new File("companydata.info"),ws).getSheet(0);
		
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			jLabel1.setText((String)Window.res.getObject("lb_companyName"));
		    jLabel1.setBounds(30, 20, 100, 20);
		    jTextField1.setBounds(120, 20, 130, 20);
		    
		    jLabel2.setText((String)Window.res.getObject("lb_address"));
		    jLabel2.setBounds(30, 50, 100, 20);
		    jTextField2.setBounds(120, 50, 200, 20);
		    
		    jLabel3.setText((String)Window.res.getObject("lb_postcode"));
		    jLabel3.setBounds(30, 80, 100, 20);
		    jTextField3.setBounds(120, 80, 130, 20);
		    
		    jLabel4.setText((String)Window.res.getObject("lb_town"));
		    jLabel4.setBounds(30, 110, 100, 20);	        
		    jTextField4.setBounds(120, 110, 250, 20);

		    jLabel5.setText((String)Window.res.getObject("lb_country"));
		    jLabel5.setBounds(30, 140, 100, 20);
		    jTextField5.setBounds(120, 140, 150, 20);

		    jLabel6.setText((String)Window.res.getObject("lb_tel"));
		    jLabel6.setBounds(30, 170, 100, 20);
		    jTextField6.setBounds(120, 170, 130, 20);

		    jLabel7.setText((String)Window.res.getObject("lb_mail"));
		    jLabel7.setBounds(30, 200, 100, 20);
		    jTextField7.setBounds(120, 200, 200, 20);
		    
		    jLabel8.setText((String)Window.res.getObject("lb_fax"));
		    jLabel8.setBounds(30, 230, 100, 20);
		    jTextField8.setBounds(120, 230, 130, 20);

		    jLabel9.setText((String)Window.res.getObject("lb_comment"));
		    jLabel9.setBounds(30, 260, 100, 20);
		    jTextField9.setBounds(120, 260, 300, 20);
		    
		    jButton1.setText((String)Window.res.getObject("bt_save"));
		    jButton1.setBounds(430, 260, 60, 23);
		}
		
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			jLabel1.setText((String)Window.res.getObject("lb_companyName"));
		    jLabel1.setBounds(30, 20, 100, 20);
		    jTextField1.setBounds(120, 20, 130, 20);
		    
		    jLabel2.setText((String)Window.res.getObject("lb_address"));
		    jLabel2.setBounds(30, 50, 100, 20);
		    jTextField2.setBounds(120, 50, 200, 20);
		    
		    jLabel3.setText((String)Window.res.getObject("lb_postcode"));
		    jLabel3.setBounds(30, 80, 100, 20);
		    jTextField3.setBounds(120, 80, 130, 20);
		    
		    jLabel4.setText((String)Window.res.getObject("lb_town"));
		    jLabel4.setBounds(30, 110, 100, 20);	        
		    jTextField4.setBounds(120, 110, 250, 20);

		    jLabel5.setText((String)Window.res.getObject("lb_country"));
		    jLabel5.setBounds(30, 140, 100, 20);
		    jTextField5.setBounds(120, 140, 150, 20);

		    jLabel6.setText((String)Window.res.getObject("lb_tel"));
		    jLabel6.setBounds(30, 170, 100, 20);
		    jTextField6.setBounds(120, 170, 130, 20);

		    jLabel7.setText((String)Window.res.getObject("lb_mail"));
		    jLabel7.setBounds(30, 200, 100, 20);
		    jTextField7.setBounds(120, 200, 200, 20);
		    
		    jLabel8.setText((String)Window.res.getObject("lb_fax"));
		    jLabel8.setBounds(30, 230, 100, 20);
		    jTextField8.setBounds(120, 230, 130, 20);

		    jLabel9.setText((String)Window.res.getObject("lb_comment"));
		    jLabel9.setBounds(30, 260, 100, 20);
		    jTextField9.setBounds(120, 260, 300, 20);
		    
		    jButton1.setText((String)Window.res.getObject("bt_save"));
		    jButton1.setBounds(430, 260, 60, 23);
		}
		
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			
			jLabel1.setText((String)Window.res.getObject("lb_companyName"));
		    jLabel1.setBounds(30, 20, 100, 20);
		    jTextField1.setBounds(120, 20, 130, 20);
		    
		    jLabel2.setText((String)Window.res.getObject("lb_address"));
		    jLabel2.setBounds(30, 50, 100, 20);
		    jTextField2.setBounds(120, 50, 200, 20);
		    
		    jLabel3.setText((String)Window.res.getObject("lb_postcode"));
		    jLabel3.setBounds(30, 80, 100, 20);
		    jTextField3.setBounds(120, 80, 130, 20);
		    
		    jLabel4.setText((String)Window.res.getObject("lb_town"));
		    jLabel4.setBounds(30, 110, 100, 20);	        
		    jTextField4.setBounds(120, 110, 250, 20);

		    jLabel5.setText((String)Window.res.getObject("lb_country"));
		    jLabel5.setBounds(30, 140, 100, 20);
		    jTextField5.setBounds(120, 140, 150, 20);

		    jLabel6.setText((String)Window.res.getObject("lb_tel"));
		    jLabel6.setBounds(30, 170, 100, 20);
		    jTextField6.setBounds(120, 170, 130, 20);

		    jLabel7.setText((String)Window.res.getObject("lb_mail"));
		    jLabel7.setBounds(30, 200, 100, 20);
		    jTextField7.setBounds(120, 200, 200, 20);
		    
		    jLabel8.setText((String)Window.res.getObject("lb_fax"));
		    jLabel8.setBounds(30, 230, 100, 20);
		    jTextField8.setBounds(120, 230, 130, 20);

		    jLabel9.setText((String)Window.res.getObject("lb_comment"));
		    jLabel9.setBounds(30, 260, 100, 20);
		    jTextField9.setBounds(120, 260, 300, 20);
		    
		    jButton1.setText((String)Window.res.getObject("bt_save"));
		    jButton1.setBounds(430, 260, 60, 23);
		}
		
	    //Label + TextField Compagny Name
	    jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField Address
	    jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
	        
	    //Label + TextField Postcode
	    jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField Town
	    jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField Country
	    jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField Tel
	    jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField Email
	    jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField7, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField fax
	    jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Label + TextField Comment
	    jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    jLayeredPane1.add(jTextField9, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    //Bouton Save
	    jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
	    
	    jButton1.addActionListener(new java.awt.event.ActionListener() {
	    	public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}

			private void jButton1ActionPerformed(ActionEvent evt) {
				try {
					WritableWorkbook workbook = Workbook.createWorkbook(new File("companydata.info")); 
					WritableSheet sheet = workbook.createSheet("Company data", 0); 
					File f=new File("Company data");
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
					label = new Label(1, 5, jTextField6.getText()); 
					sheet.addCell(label); 
					label = new Label(1, 6, jTextField7.getText()); 
					sheet.addCell(label); 
					label = new Label(1, 7, jTextField8.getText()); 
					sheet.addCell(label); 
					label = new Label(1, 8, jTextField9.getText()); 
					sheet.addCell(label); 
					
					workbook.write(); 
					workbook.close(); 
					
					System.out.println("-> Modification de " + f );
						
					dispose();
				}
				catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(null,e); 
				}
			}
		});
	        
	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    this.setLayout(layout);
	    
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
	    );
	    
	    layout.setVerticalGroup(
	    	layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	    	.addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
	    );
	    
	    this.getContentPane().setBackground(Color.white);
	        
	    jTextField1.setText(sheet.getCell(1,0).getContents());
	    jTextField2.setText(sheet.getCell(1,1).getContents());
	    jTextField3.setText(sheet.getCell(1,2).getContents());
	    jTextField4.setText(sheet.getCell(1,3).getContents());
	    jTextField5.setText(sheet.getCell(1,4).getContents());
	    jTextField6.setText(sheet.getCell(1,5).getContents());
	    jTextField7.setText(sheet.getCell(1,6).getContents());
	    jTextField8.setText(sheet.getCell(1,7).getContents());
	    jTextField9.setText(sheet.getCell(1,8).getContents());
	}
}