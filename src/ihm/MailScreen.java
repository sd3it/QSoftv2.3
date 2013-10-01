package ihm;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import database.ReadSheet;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class MailScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	public static String parents=FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	private String mailpath = "";
	
	private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jButtonMailBrowse;
    
    public MailScreen() throws IndexOutOfBoundsException, BiffException, IOException {
        initComponents();
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_mailpath"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_mailpath"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_mailpath"));
		}
        
        this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setModal(true);
    }
    
	private void initComponents() throws IndexOutOfBoundsException, BiffException, IOException {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonMailBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        if(Window.locale.toString().equals("en")){
        	Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
        	
        	jLabel1.setText("<html><b>" + (String)Window.res.getObject("lb_pathname"));
            jLabel1.setBounds(20, 30, 240, 14);
            jTextField1.setBounds(20, 60, 430, 20);
            
            jButton1.setText((String)Window.res.getObject("bt_save"));
            jButton1.setBounds(550, 60, 60, 23);
            
            jButtonMailBrowse.setText((String)Window.res.getObject("bt_browse"));
            jButtonMailBrowse.setBounds(470, 60, 70, 23);
        }
        else if(Window.locale.toString().equals("it")){
        	Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
        	
        	jLabel1.setText("<html><b>" + (String)Window.res.getObject("lb_pathname"));
            jLabel1.setBounds(20, 30, 240, 14);
            jTextField1.setBounds(20, 60, 430, 20);
            
            jButton1.setText((String)Window.res.getObject("bt_save"));
            jButton1.setBounds(550, 60, 60, 23);
            
            jButtonMailBrowse.setText((String)Window.res.getObject("bt_browse"));
            jButtonMailBrowse.setBounds(466, 60, 74, 23);
        }
        else if(Window.locale.toString().equals("fr")){
        	Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
        	
        	jLabel1.setText("<html><b>" + (String)Window.res.getObject("lb_pathname"));
            jLabel1.setBounds(20, 30, 240, 14);
            jTextField1.setBounds(20, 60, 430, 20);
            
            jButton1.setText((String)Window.res.getObject("bt_save"));
            jButton1.setBounds(550, 60, 50, 23);
            
            jButtonMailBrowse.setText((String)Window.res.getObject("bt_browse"));
            jButtonMailBrowse.setBounds(465, 60, 75, 23);
        }

        //Label + TextField Pathname for outlook
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        //Button Save
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        //Button Browse
        jLayeredPane1.add(jButtonMailBrowse, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} 
                catch (RowsExceededException e) {
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
        
        jButtonMailBrowse.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt){
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

					FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier Executable (.exe)","exe");
					chooser.setFileFilter(filter);

					int returnval=chooser.showOpenDialog(null);
					if(returnval==JFileChooser.APPROVE_OPTION)
					{
						mailpath = parents + "\\" + chooser.getSelectedFile().getName();
						jTextField1.setText(mailpath);
					}
				}
				catch (Exception ev) {
					javax.swing.JOptionPane.showMessageDialog(null,ev);
				}
        	}
        });
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        WorkbookSettings ws=new WorkbookSettings();
		ws.setSuppressWarnings(true);
		Sheet sheet=Workbook.getWorkbook(new File("mailpathname.info"),ws).getSheet(0);
        jTextField1.setText(sheet.getCell(1,0).getContents());
        pack();
    }
	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, RowsExceededException, WriteException {
		WritableWorkbook workbook = Workbook.createWorkbook(new File("mailpathname.info")); 
		WritableSheet sheet = workbook.createSheet("mailpathname", 0); 

		Label label = new Label(1,0, jTextField1.getText()); 
		sheet.addCell(label); 
		workbook.write(); 
		workbook.close(); 
		
		System.out.println("-> Modification de Mailing Path"  );
		
		dispose();
    }
}