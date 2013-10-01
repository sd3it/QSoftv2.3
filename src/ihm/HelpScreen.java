package ihm;

import java.awt.Color;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class HelpScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLayeredPane jLayeredPane1;
    
    public HelpScreen() {
    	
		if(Window.locale.toString().equals("en")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_help") + " " + Window.nameTitle);
		}
		else if(Window.locale.toString().equals("it")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_help") + " " + Window.nameTitle);
		}
		else if(Window.locale.toString().equals("fr")){
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
			this.setTitle((String)Window.res.getObject("title_help") + " " + Window.nameTitle);
		}
    	
    	this.setIconImage(new ImageIcon("logoframe.png").getImage());
        this.initComponents();
        this.setModal(true);
        this.pack();
    }
    
	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setIcon(new ImageIcon("logosd3.png"));
        jLabel5.setBounds(0, 0, 160, 110);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("<html><h1>" + Window.nameTitle);
        jLabel8.setBounds(170, 0, 150, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        if(Window.locale.toString().equals("en")){
        	Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
        	
        	jLabel7.setText((String)Window.res.getObject("lb_help1"));
            jLabel7.setBounds(180, 50, 254, 14);
            
            jLabel6.setText((String)Window.res.getObject("lb_help2"));
            jLabel6.setBounds(180, 70, 300, 14);
        }
        else if(Window.locale.toString().equals("it")){
        	Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
        	
        	jLabel7.setText((String)Window.res.getObject("lb_help1"));
            jLabel7.setBounds(180, 50, 254, 14);
            
            jLabel6.setText((String)Window.res.getObject("lb_help2"));
            jLabel6.setBounds(180, 70, 300, 14);
        }
        else if(Window.locale.toString().equals("fr")){
        	Window.res = ResourceBundle.getBundle("I18nPropertiesRessources", Window.locale);
        	
        	jLabel7.setText((String)Window.res.getObject("lb_help1"));
            jLabel7.setBounds(180, 50, 254, 14);
            
            jLabel6.setText((String)Window.res.getObject("lb_help2"));
            jLabel6.setBounds(180, 70, 300, 14);
        }
        
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        this.getContentPane().setBackground(Color.white);
    }
}