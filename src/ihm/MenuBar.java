package ihm;

import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MenuBar {

	private JFrame frame;

	public MenuBar(JFrame frame) {
		super();
		this.frame = frame;
	}

	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;

	private javax.swing.JMenuBar jMenuBar1;

	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem10;
	private javax.swing.JMenuItem jMenuItem11;
	private javax.swing.JMenuItem jMenuItem12;
	private javax.swing.JMenuItem jMenuItem13;
	private javax.swing.JMenuItem jMenuItem14;
	private javax.swing.JMenuItem jMenuItem15;
	private javax.swing.JMenuItem jMenuItem16;
	private javax.swing.JMenuItem jMenuItem17;
	private javax.swing.JMenuItem jMenuItem18;
	private javax.swing.JMenuItem jMenuItem19;
	private javax.swing.JMenuItem jMenuItem20;
	private javax.swing.JMenuItem jMenuItem22;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JMenuItem jMenuItem9;
	private javax.swing.JMenuItem jMenuItem23;
	private javax.swing.JMenuItem jMenuItem24;
	private javax.swing.JMenuItem jMenuItem25;
	private javax.swing.JMenuItem jMenuItemHelpInstall;
	private javax.swing.JMenuItem jMenuItemHelpUse;

	private javax.swing.JPopupMenu.Separator jSeparator1;
	private javax.swing.JPopupMenu.Separator jSeparator2;
	private javax.swing.JPopupMenu.Separator jSeparator3;
	private javax.swing.JPopupMenu.Separator jSeparator4;
	private javax.swing.JPopupMenu.Separator jSeparator5;

	public void add() {

		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_send.png"));
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem9 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_exit.png"));
		jMenuItem12 = new javax.swing.JMenuItem(new ImageIcon(
				"images/flags/flag_en.png"));
		jMenuItem13 = new javax.swing.JMenuItem(new ImageIcon(
				"images/flags/flag_it.png"));
		jMenuItem14 = new javax.swing.JMenuItem();
		jMenuItem15 = new javax.swing.JMenuItem(new ImageIcon(
				"images/flags/flag_fr.png"));
		jMenuItem16 = new javax.swing.JMenuItem();
		jMenuItem19 = new javax.swing.JMenuItem();
		jMenuItem10 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_user.png"));
		jMenuItem11 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_logo.png"));
		jMenuItem17 = new javax.swing.JMenuItem();
		jMenuItem18 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_about.png"));
		jMenuItem20 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_restart.png"));
		jMenuItem22 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_mail.png"));
		jMenuItem25 = new javax.swing.JMenuItem();
		jMenuItem23 = new javax.swing.JMenuItem();
		jMenuItem24 = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_company.png"));
		jMenuItemHelpInstall = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_help.png"));
		jMenuItemHelpUse = new javax.swing.JMenuItem(new ImageIcon(
				"images/icons/ic_help.png"));
		jSeparator1 = new javax.swing.JPopupMenu.Separator();
		jSeparator2 = new javax.swing.JPopupMenu.Separator();
		jSeparator3 = new javax.swing.JPopupMenu.Separator();
		jSeparator5 = new javax.swing.JPopupMenu.Separator();
		jSeparator4 = new javax.swing.JPopupMenu.Separator();

		if (Window.locale.toString().equals("en")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/********** Menu 1 *********/
			jMenu1.setText((String) Window.res.getObject("menu_file"));
			jMenuItem1.setText((String) Window.res.getObject("lb_menuitem1"));
			jMenuItem2.setText((String) Window.res.getObject("lb_menuitem2"));
			jMenuItem8.setText((String) Window.res.getObject("lb_menuitem8"));
			jMenuItem5.setText((String) Window.res.getObject("lb_menuitem5"));
			jMenuItem6.setText((String) Window.res.getObject("lb_menuitem6"));
			jMenuItem23.setText((String) Window.res.getObject("lb_menuitem23"));
			jMenuItem7.setText((String) Window.res.getObject("lb_menuitem7"));
			jMenuItem4.setText((String) Window.res.getObject("lb_menuitem4"));
			jMenuItem20.setText((String) Window.res.getObject("lb_menuitem20"));
			jMenuItem9.setText((String) Window.res.getObject("lb_menuitem9"));
			/******** Menu 2 & 3 *******/
			jMenu2.setText((String) Window.res.getObject("menu_preference"));
			jMenu3.setText((String) Window.res.getObject("menu_language"));
			jMenuItem12.setText((String) Window.res.getObject("lb_menuitem12"));
			jMenuItem13.setText((String) Window.res.getObject("lb_menuitem13"));
			jMenuItem15.setText((String) Window.res.getObject("lb_menuitem15"));
			jMenuItem10.setText((String) Window.res.getObject("lb_menuitem10"));
			jMenuItem24.setText((String) Window.res.getObject("lb_menuitem24"));
			jMenuItem22.setText((String) Window.res.getObject("lb_menuitem22"));
			jMenuItem11.setText((String) Window.res.getObject("lb_menuitem11"));
			/********** Menu 4 *********/
			jMenu4.setText((String) Window.res.getObject("menu_help"));
			jMenuItem18.setText((String) Window.res.getObject("lb_menuitem18"));
			jMenuItemHelpInstall.setText((String) Window.res
					.getObject("lb_menuitemHelpInstall") + Window.nameTitle);
			jMenuItemHelpUse.setText((String) Window.res
					.getObject("lb_menuitemHelpUse") + Window.nameTitle);
		} else if (Window.locale.toString().equals("it")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/********** Menu 1 *********/
			jMenu1.setText((String) Window.res.getObject("menu_file"));
			jMenuItem1.setText((String) Window.res.getObject("lb_menuitem1"));
			jMenuItem2.setText((String) Window.res.getObject("lb_menuitem2"));
			jMenuItem8.setText((String) Window.res.getObject("lb_menuitem8"));
			jMenuItem5.setText((String) Window.res.getObject("lb_menuitem5"));
			jMenuItem6.setText((String) Window.res.getObject("lb_menuitem6"));
			jMenuItem23.setText((String) Window.res.getObject("lb_menuitem23"));
			jMenuItem7.setText((String) Window.res.getObject("lb_menuitem7"));
			jMenuItem4.setText((String) Window.res.getObject("lb_menuitem4"));
			jMenuItem20.setText((String) Window.res.getObject("lb_menuitem20"));
			jMenuItem9.setText((String) Window.res.getObject("lb_menuitem9"));
			/******** Menu 2 & 3 *******/
			jMenu2.setText((String) Window.res.getObject("menu_preference"));
			jMenu3.setText((String) Window.res.getObject("menu_language"));
			jMenuItem12.setText((String) Window.res.getObject("lb_menuitem12"));
			jMenuItem13.setText((String) Window.res.getObject("lb_menuitem13"));
			jMenuItem15.setText((String) Window.res.getObject("lb_menuitem15"));
			jMenuItem10.setText((String) Window.res.getObject("lb_menuitem10"));
			jMenuItem24.setText((String) Window.res.getObject("lb_menuitem24"));
			jMenuItem22.setText((String) Window.res.getObject("lb_menuitem22"));
			jMenuItem11.setText((String) Window.res.getObject("lb_menuitem11"));
			/********** Menu 4 *********/
			jMenu4.setText((String) Window.res.getObject("menu_help"));
			jMenuItem18.setText((String) Window.res.getObject("lb_menuitem18"));
			jMenuItemHelpInstall.setText((String) Window.res
					.getObject("lb_menuitemHelpInstall") + Window.nameTitle);
			jMenuItemHelpUse.setText((String) Window.res
					.getObject("lb_menuitemHelpUse") + Window.nameTitle);
		} else if (Window.locale.toString().equals("fr")) {
			Window.res = ResourceBundle.getBundle("I18nPropertiesRessources",
					Window.locale);
			/********** Menu 1 *********/
			jMenu1.setText((String) Window.res.getObject("menu_file"));
			jMenuItem1.setText((String) Window.res.getObject("lb_menuitem1"));
			jMenuItem2.setText((String) Window.res.getObject("lb_menuitem2"));
			jMenuItem8.setText((String) Window.res.getObject("lb_menuitem8"));
			jMenuItem5.setText((String) Window.res.getObject("lb_menuitem5"));
			jMenuItem6.setText((String) Window.res.getObject("lb_menuitem6"));
			jMenuItem23.setText((String) Window.res.getObject("lb_menuitem23"));
			jMenuItem7.setText((String) Window.res.getObject("lb_menuitem7"));
			jMenuItem4.setText((String) Window.res.getObject("lb_menuitem4"));
			jMenuItem20.setText((String) Window.res.getObject("lb_menuitem20"));
			jMenuItem9.setText((String) Window.res.getObject("lb_menuitem9"));
			/******** Menu 2 & 3 *******/
			jMenu2.setText((String) Window.res.getObject("menu_preference"));
			jMenu3.setText((String) Window.res.getObject("menu_language"));
			jMenuItem12.setText((String) Window.res.getObject("lb_menuitem12"));
			jMenuItem13.setText((String) Window.res.getObject("lb_menuitem13"));
			jMenuItem15.setText((String) Window.res.getObject("lb_menuitem15"));
			jMenuItem10.setText((String) Window.res.getObject("lb_menuitem10"));
			jMenuItem24.setText((String) Window.res.getObject("lb_menuitem24"));
			jMenuItem22.setText((String) Window.res.getObject("lb_menuitem22"));
			jMenuItem11.setText((String) Window.res.getObject("lb_menuitem11"));
			/********** Menu 4 *********/
			jMenu4.setText((String) Window.res.getObject("menu_help"));
			jMenuItem18.setText((String) Window.res.getObject("lb_menuitem18"));
			jMenuItemHelpInstall.setText((String) Window.res
					.getObject("lb_menuitemHelpInstall") + Window.nameTitle);
			jMenuItemHelpUse.setText((String) Window.res
					.getObject("lb_menuitemHelpUse") + Window.nameTitle);
		}

		/*************************** MENU 1 *************************/
		// Load Selling price list
		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenu1.add(jMenuItem1);
		// Load Purchasing price list
		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_M,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenu1.add(jMenuItem2);
		// Load data file
		jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_D,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenu1.add(jMenuItem8);

		jMenu1.add(jSeparator1);

		// Save proforma file (PDF)
		jMenu1.add(jMenuItem5);
		// Save quotation file (PDF)
		jMenu1.add(jMenuItem6);
		// Save purchasing sd3 order (PDF)
		jMenu1.add(jMenuItem23);
		// Save data file (DATA)
		jMenu1.add(jMenuItem7);

		jMenu1.add(jSeparator2);

		// Send by mail
		jMenu1.add(jMenuItem4);

		jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_P,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem3.setText("Print");

		jMenu1.add(jSeparator3);

		// Restart QSoft
		jMenu1.add(jMenuItem20);
		// Exit
		jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F4,
				java.awt.event.InputEvent.ALT_MASK));
		jMenu1.add(jMenuItem9);

		jMenuBar1.add(jMenu1);

		/*************************** MENU 2 & 3 *************************/
		// English
		jMenu3.add(jMenuItem12);
		// Italian
		jMenu3.add(jMenuItem13);
		// French
		jMenu3.add(jMenuItem15);

		jMenu2.add(jMenu3);

		jMenu2.add(jSeparator4);

		// Change User data
		jMenu2.add(jMenuItem10);
		// Change Company data
		jMenu2.add(jMenuItem24);
		// Change Mailing Pathname
		jMenu2.add(jMenuItem22);
		// Change logo
		jMenu2.add(jMenuItem11);

		// retiré le 27/02/13 suite à la réunion
		// jMenu2.add(jSeparator6);

		// jMenuItem17.setText("Load last pricelist");
		// jMenu2.add(jMenuItem17);

		// jMenuItem25.setText("Load last marginlist");
		// jMenu2.add(jMenuItem25);

		jMenuBar1.add(jMenu2);

		/*************************** MENU 4 *************************/
		// About QSoft
		jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F1, 0));
		jMenu4.add(jMenuItem18);
		// How to install
		jMenu4.add(jMenuItemHelpInstall);
		jMenu4.add(jMenuItemHelpUse);

		jMenuBar1.add(jMenu4);

		this.frame.setJMenuBar(jMenuBar1);
	}

	public javax.swing.JMenuItem getjMenuItem23() {
		return jMenuItem23;
	}

	public void setjMenuItem23(javax.swing.JMenuItem jMenuItem23) {
		this.jMenuItem23 = jMenuItem23;
	}

	public javax.swing.JMenuItem getjMenuItem25() {
		return jMenuItem25;
	}

	public void setjMenuItem25(javax.swing.JMenuItem jMenuItem25) {
		this.jMenuItem25 = jMenuItem25;
	}

	public javax.swing.JMenuItem getjMenuItem24() {
		return jMenuItem24;
	}

	public void setjMenuItem24(javax.swing.JMenuItem jMenuItem24) {
		this.jMenuItem24 = jMenuItem24;
	}

	public javax.swing.JMenuItem getjMenuItem22() {
		return jMenuItem22;
	}

	public void setjMenuItem22(javax.swing.JMenuItem jMenuItem22) {
		this.jMenuItem22 = jMenuItem22;
	}

	public javax.swing.JPopupMenu.Separator getjSeparator5() {
		return jSeparator5;
	}

	public void setjSeparator5(javax.swing.JPopupMenu.Separator jSeparator5) {
		this.jSeparator5 = jSeparator5;
	}

	public javax.swing.JMenu getjMenu1() {
		return jMenu1;
	}

	public void setjMenu1(javax.swing.JMenu jMenu1) {
		this.jMenu1 = jMenu1;
	}

	public javax.swing.JMenu getjMenu2() {
		return jMenu2;
	}

	public void setjMenu2(javax.swing.JMenu jMenu2) {
		this.jMenu2 = jMenu2;
	}

	public javax.swing.JMenu getjMenu3() {
		return jMenu3;
	}

	public void setjMenu3(javax.swing.JMenu jMenu3) {
		this.jMenu3 = jMenu3;
	}

	public javax.swing.JMenu getjMenu4() {
		return jMenu4;
	}

	public void setjMenu4(javax.swing.JMenu jMenu4) {
		this.jMenu4 = jMenu4;
	}

	public javax.swing.JMenuBar getjMenuBar1() {
		return jMenuBar1;
	}

	public void setjMenuBar1(javax.swing.JMenuBar jMenuBar1) {
		this.jMenuBar1 = jMenuBar1;
	}

	public javax.swing.JMenuItem getjMenuItem1() {
		return jMenuItem1;
	}

	public void setjMenuItem1(javax.swing.JMenuItem jMenuItem1) {
		this.jMenuItem1 = jMenuItem1;
	}

	public javax.swing.JMenuItem getjMenuItem10() {
		return jMenuItem10;
	}

	public void setjMenuItem10(javax.swing.JMenuItem jMenuItem10) {
		this.jMenuItem10 = jMenuItem10;
	}

	public javax.swing.JMenuItem getjMenuItem11() {
		return jMenuItem11;
	}

	public void setjMenuItem11(javax.swing.JMenuItem jMenuItem11) {
		this.jMenuItem11 = jMenuItem11;
	}

	public javax.swing.JMenuItem getjMenuItem12() {
		return jMenuItem12;
	}

	public void setjMenuItem12(javax.swing.JMenuItem jMenuItem12) {
		this.jMenuItem12 = jMenuItem12;
	}

	public javax.swing.JMenuItem getjMenuItem13() {
		return jMenuItem13;
	}

	public void setjMenuItem13(javax.swing.JMenuItem jMenuItem13) {
		this.jMenuItem13 = jMenuItem13;
	}

	public javax.swing.JMenuItem getjMenuItem14() {
		return jMenuItem14;
	}

	public void setjMenuItem14(javax.swing.JMenuItem jMenuItem14) {
		this.jMenuItem14 = jMenuItem14;
	}

	public javax.swing.JMenuItem getjMenuItem15() {
		return jMenuItem15;
	}

	public void setjMenuItem15(javax.swing.JMenuItem jMenuItem15) {
		this.jMenuItem15 = jMenuItem15;
	}

	public javax.swing.JMenuItem getjMenuItem16() {
		return jMenuItem16;
	}

	public void setjMenuItem16(javax.swing.JMenuItem jMenuItem16) {
		this.jMenuItem16 = jMenuItem16;
	}

	public javax.swing.JMenuItem getjMenuItem17() {
		return jMenuItem17;
	}

	public void setjMenuItem17(javax.swing.JMenuItem jMenuItem17) {
		this.jMenuItem17 = jMenuItem17;
	}

	public javax.swing.JMenuItem getjMenuItem18() {
		return jMenuItem18;
	}

	public void setjMenuItem18(javax.swing.JMenuItem jMenuItem18) {
		this.jMenuItem18 = jMenuItem18;
	}

	public javax.swing.JMenuItem getjMenuItem20() {
		return jMenuItem20;
	}

	public void setjMenuItem20(javax.swing.JMenuItem jMenuItem20) {
		this.jMenuItem20 = jMenuItem20;
	}

	public javax.swing.JMenuItem getjMenuItem2() {
		return jMenuItem2;
	}

	public void setjMenuItem2(javax.swing.JMenuItem jMenuItem2) {
		this.jMenuItem2 = jMenuItem2;
	}

	public javax.swing.JMenuItem getjMenuItem3() {
		return jMenuItem3;
	}

	public void setjMenuItem3(javax.swing.JMenuItem jMenuItem3) {
		this.jMenuItem3 = jMenuItem3;
	}

	public javax.swing.JMenuItem getjMenuItem4() {
		return jMenuItem4;
	}

	public void setjMenuItem4(javax.swing.JMenuItem jMenuItem4) {
		this.jMenuItem4 = jMenuItem4;
	}

	public javax.swing.JMenuItem getjMenuItem5() {
		return jMenuItem5;
	}

	public void setjMenuItem5(javax.swing.JMenuItem jMenuItem5) {
		this.jMenuItem5 = jMenuItem5;
	}

	public javax.swing.JMenuItem getjMenuItem6() {
		return jMenuItem6;
	}

	public void setjMenuItem6(javax.swing.JMenuItem jMenuItem6) {
		this.jMenuItem6 = jMenuItem6;
	}

	public javax.swing.JMenuItem getjMenuItem7() {
		return jMenuItem7;
	}

	public void setjMenuItem7(javax.swing.JMenuItem jMenuItem7) {
		this.jMenuItem7 = jMenuItem7;
	}

	public javax.swing.JMenuItem getjMenuItem8() {
		return jMenuItem8;
	}

	public void setjMenuItem8(javax.swing.JMenuItem jMenuItem8) {
		this.jMenuItem8 = jMenuItem8;
	}

	public javax.swing.JMenuItem getjMenuItem9() {
		return jMenuItem9;
	}

	public void setjMenuItem9(javax.swing.JMenuItem jMenuItem9) {
		this.jMenuItem9 = jMenuItem9;
	}

	public javax.swing.JPopupMenu.Separator getjSeparator1() {
		return jSeparator1;
	}

	public void setjSeparator1(javax.swing.JPopupMenu.Separator jSeparator1) {
		this.jSeparator1 = jSeparator1;
	}

	public javax.swing.JPopupMenu.Separator getjSeparator2() {
		return jSeparator2;
	}

	public void setjSeparator2(javax.swing.JPopupMenu.Separator jSeparator2) {
		this.jSeparator2 = jSeparator2;
	}

	public javax.swing.JPopupMenu.Separator getjSeparator3() {
		return jSeparator3;
	}

	public void setjSeparator3(javax.swing.JPopupMenu.Separator jSeparator3) {
		this.jSeparator3 = jSeparator3;
	}

	public javax.swing.JPopupMenu.Separator getjSeparator4() {
		return jSeparator4;
	}

	public void setjSeparator4(javax.swing.JPopupMenu.Separator jSeparator4) {
		this.jSeparator4 = jSeparator4;
	}

	public javax.swing.JMenuItem getjMenuItemHelpInstall() {
		return jMenuItemHelpInstall;
	}

	public javax.swing.JMenuItem getjMenuItemHelpUse() {
		return jMenuItemHelpUse;
	}

}