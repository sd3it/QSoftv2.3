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
import javax.swing.JDialog;

public class DataExportScreen extends JDialog{

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;

	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	
	private javax.swing.JLayeredPane jLayeredPane1;

	private javax.swing.JTextField jTextField10;
	private javax.swing.JTextField jTextField11;
	private javax.swing.JTextField jTextField17;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9; 

	public DataExportScreen() {
		
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_saveData"));
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_saveData"));
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_saveData"));
		}
		this.setIconImage(new ImageIcon("logoframe.png").getImage());
		this.setModal(true);
		this.setResizable(false);
		initComponents();
		this.pack();
	}

	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		new javax.swing.JLabel();
		new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jLabel20 = new javax.swing.JLabel();
		jTextField9 = new javax.swing.JTextField();
		jLabel21 = new javax.swing.JLabel();
		jTextField17 = new javax.swing.JTextField();
		new javax.swing.JCheckBox();
		new javax.swing.JCheckBox();
		new javax.swing.JCheckBox();
		new javax.swing.JCheckBox();
		jLabel13 = new javax.swing.JLabel();
		jTextField10 = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jTextField11 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);

			jLabel21.setText((String)Window.res.getObject("lb_ref"));
			jLabel21.setBounds(210, 35, 150, 20);
			jTextField17.setBounds(280, 35, 100, 20);
			jTextField17.setText(Window.referencequot);
			
			jLabel4.setText((String)Window.res.getObject("lb_from"));
			jLabel4.setBounds(30, 20, 28, 20);
			jTextField2.setBounds(70, 20, 120, 20);
			
			jLabel7.setText((String)Window.res.getObject("lb_to"));
			jLabel7.setBounds(40, 50, 16, 20);
			jTextField3.setBounds(70, 50, 120, 20);

			jLabel10.setText((String)Window.res.getObject("lb_object"));
			jLabel10.setBounds(10, 80, 40, 20);
			jTextField8.setBounds(70, 80, 320, 20);
			
			jLabel20.setText((String)Window.res.getObject("lb_recName"));
			jLabel20.setBounds(10, 110, 80, 20);
			jTextField9.setBounds(105, 110, 190, 20);
			
			jLabel13.setText((String)Window.res.getObject("lb_payment"));
			jLabel13.setBounds(10, 140, 46, 20);
			jTextField10.setBounds(70, 140, 320, 20);
			
			jLabel12.setText((String)Window.res.getObject("lb_incoterm"));
			jLabel12.setBounds(10, 170, 47, 20);
			jTextField11.setBounds(70, 170, 320, 20);
			
			jButton1.setText((String)Window.res.getObject("bt_save"));
			jButton1.setBounds(420, 170, 60, 20);
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);

			jLabel21.setText((String)Window.res.getObject("lb_ref"));
			jLabel21.setBounds(210, 35, 150, 20);
			jTextField17.setBounds(280, 35, 100, 20);
			jTextField17.setText(Window.referencequot);
			
			jLabel4.setText((String)Window.res.getObject("lb_from"));
			jLabel4.setBounds(42, 20, 28, 20);
			jTextField2.setBounds(70, 20, 120, 20);
			
			jLabel7.setText((String)Window.res.getObject("lb_to"));
			jLabel7.setBounds(47, 50, 16, 20);
			jTextField3.setBounds(70, 50, 120, 20);

			jLabel10.setText((String)Window.res.getObject("lb_object"));
			jLabel10.setBounds(10, 80, 50, 20);
			jTextField8.setBounds(70, 80, 320, 20);
			
			jLabel20.setText((String)Window.res.getObject("lb_recName"));
			jLabel20.setBounds(10, 110, 80, 20);
			jTextField9.setBounds(70, 110, 190, 20);
			
			jLabel13.setText((String)Window.res.getObject("lb_payment"));
			jLabel13.setBounds(10, 140, 65, 20);
			jTextField10.setBounds(80, 140, 310, 20);
			
			jLabel12.setText((String)Window.res.getObject("lb_incoterm"));
			jLabel12.setBounds(10, 170, 47, 20);
			jTextField11.setBounds(70, 170, 320, 20);
			
			jButton1.setText((String)Window.res.getObject("bt_save"));
			jButton1.setBounds(420, 170, 60, 20);
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);

			jLabel21.setText((String)Window.res.getObject("lb_ref"));
			jLabel21.setBounds(210, 35, 150, 20);
			jTextField17.setBounds(280, 35, 100, 20);
			jTextField17.setText(Window.referencequot);
			
			jLabel4.setText((String)Window.res.getObject("lb_from"));
			jLabel4.setBounds(42, 20, 28, 20);
			jTextField2.setBounds(70, 20, 120, 20);
			
			jLabel7.setText((String)Window.res.getObject("lb_to"));
			jLabel7.setBounds(47, 50, 16, 20);
			jTextField3.setBounds(70, 50, 120, 20);

			jLabel10.setText((String)Window.res.getObject("lb_object"));
			jLabel10.setBounds(27, 80, 50, 20);
			jTextField8.setBounds(70, 80, 320, 20);
			
			jLabel20.setText((String)Window.res.getObject("lb_recName"));
			jLabel20.setBounds(10, 110, 80, 20);
			jTextField9.setBounds(80, 110, 190, 20);
			
			jLabel13.setText((String)Window.res.getObject("lb_payment"));
			jLabel13.setBounds(10, 140, 65, 20);
			jTextField10.setBounds(70, 140, 320, 20);
			
			jLabel12.setText((String)Window.res.getObject("lb_incoterm"));
			jLabel12.setBounds(10, 170, 47, 20);
			jTextField11.setBounds(70, 170, 320, 20);
			
			jButton1.setText((String)Window.res.getObject("bt_save"));
			jButton1.setBounds(420, 170, 60, 20);
		}
		
		//Reference
		jLayeredPane1.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField17.addFocusListener(focuslistener);
		jLayeredPane1.add(jTextField17, javax.swing.JLayeredPane.DEFAULT_LAYER);

		Window.date=new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		jTextField2.addFocusListener(focuslistener);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField3.addFocusListener(focuslistener);
		jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField8.addFocusListener(focuslistener);
		jLayeredPane1.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField9.addFocusListener(focuslistener);
		jLayeredPane1.add(jTextField9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField10.addFocusListener(focuslistener);
		jLayeredPane1.add(jTextField10, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField11.addFocusListener(focuslistener);
		jLayeredPane1.add(jTextField11, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}

			private void jButton1ActionPerformed(ActionEvent evt) {
				dispose();

				Window.from=jTextField2.getText();
				Window.to=jTextField3.getText();
				Window.referencequot=jTextField17.getText();
				Window.object=jTextField8.getText();
				Window.payment=jTextField10.getText();
				Window.incoterm=jTextField11.getText();
				Window.recipientname=jTextField9.getText();

				DataExport ee=new DataExport();
				try {
					ee.export();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField2.setText(Window.from);
		jTextField3.setText(Window.to);
		jTextField17.setText(Window.referencequot);
		jTextField8.setText(Window.object);
		jTextField10.setText(Window.payment);
		jTextField11.setText(Window.incoterm);
		jTextField9.setText(Window.recipientname);
		
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
		);
		this.getContentPane().setBackground(new Color(255, 255, 255));
	}

	FocusListener focuslistener = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {}

		@Override
		public void focusLost(FocusEvent e) {
		
			if(e.getSource().equals(jTextField2))
			{
				Window.from=jTextField2.getText();
			}
			if(e.getSource().equals(jTextField3))
			{
				Window.to=jTextField3.getText();
			}
			if(e.getSource().equals(jTextField17))
			{
				Window.referencequot=jTextField17.getText();
			}
			if(e.getSource().equals(jTextField8))
			{
				Window.object=jTextField8.getText();
			}
			if(e.getSource().equals(jTextField10))
			{
				Window.payment=jTextField10.getText();
			}
			if(e.getSource().equals(jTextField11))
			{
				Window.incoterm=jTextField11.getText();
			}
			if(e.getSource().equals(jTextField9))
			{
				Window.recipientname=jTextField9.getText();
			}
		}
	};
}