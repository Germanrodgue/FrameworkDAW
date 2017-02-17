package exer3_1.Utils;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import exer3_1.Classes.Settings;
import exer3_1.Classes.Language.Language;

/**
 * Functions used by the menu
 * 
 * @version 5.1, 15/2/2017
 * @author German Rodriguez
 *
 */

public class Functions_menu {
	// Settings menu
	public static void Settings() {

		String[] dateStrings = { "dd/mm/yyyy", "dd-mm-yyyy", "yyyy-mm-dd", "yyyy/mm/dd" };
		String[] CoinStrings = { "Euros", "Dollars", "Pounds" };
		String[] DecimalStrings = { ".0", ".00", ".000" };
		String[] type2 = { "Metal", "GTK", "Motif", "Ninbus" };
		String[] type3 = { "ON", "OFF" };
		String[] type4 = { Language.getInstance().getProperty("eng"), Language.getInstance().getProperty("spa"),
				Language.getInstance().getProperty("val") };
		String[] fformatStrings = { "Json", "Xml", "Txt" };
		SpinnerListModel dateModel = new SpinnerListModel(dateStrings);
		JSpinner spinner_date = new JSpinner(dateModel);
		SpinnerListModel CoinModel = new SpinnerListModel(CoinStrings);
		JSpinner spinner_coin = new JSpinner(CoinModel);
		SpinnerListModel DecimalModel = new SpinnerListModel(DecimalStrings);
		JSpinner spinner_decimal = new JSpinner(DecimalModel);
		SpinnerListModel fformat = new SpinnerListModel(fformatStrings);
		JSpinner spinner_fformat = new JSpinner(fformat);
		JComboBox combo2 = new JComboBox(type3);
		JComboBox combo3 = new JComboBox(type4);
		JComboBox combo4 = new JComboBox(type2);
		JCheckBox check = new JCheckBox("Dummies");
		JToggleButton reset2 = new JToggleButton("Reset");
		String spinnerdate = "";
		String spinnercoin = "";
		String spinnerdecimal = "";
		String spinnerfformat = "";
		JPanel panel = new JPanel(new GridLayout(0, 1));
		String lang = "";
		String theme = "";
		String dummies = "";
		int result = 0;
		boolean control = false;

		// Functions_save_settings.open();
		/*
		 * Save settings meanwhile the user is using the application
		 * 
		 * As i use the JPanel i need to keep the changes visible.
		 */
		/////////// SAVE SETTINGS////////////
		if (Settings.getInstance().getDateformat() != null) {
			///////
			type3[0] = Settings.getInstance().getDummies();

			if (type3[0].equals("OFF")) {

				type3[1] = "ON";
			} else {
				type3[0] = "ON";
				type3[1] = "OFF";
			}

			fformatStrings[0] = Settings.getInstance().getFileformat();

			if (fformatStrings[0].equals("Xml")) {
				fformatStrings[1] = "Json";
				fformatStrings[2] = "Txt";
			} else if (fformatStrings[0].equals("Txt")) {
				fformatStrings[1] = "Xml";
				fformatStrings[2] = "Json";
			} else {
				fformatStrings[0] = "Json";
				fformatStrings[1] = "Xml";
				fformatStrings[2] = "Txt";
			}

			type4[0] = Settings.getInstance().getLanguage();
			System.out.println(type4[0]);
			if ((type4[0].equals("Spanish")) || (type4[0].equals("Español")) || (type4[0].equals("Espanyol"))) {

				type4[0] = Language.getInstance().getProperty("spa");
				type4[1] = Language.getInstance().getProperty("eng");
				type4[2] = Language.getInstance().getProperty("val");

			} else if ((type4[0].equals("Valencian")) || (type4[0].equals("Valenciano"))
					|| (type4[0].equals("Valencia"))) {

				type4[0] = Language.getInstance().getProperty("val");
				type4[1] = Language.getInstance().getProperty("eng");
				type4[2] = Language.getInstance().getProperty("spa");

			} else {
				type4[0] = Language.getInstance().getProperty("eng");
				type4[1] = Language.getInstance().getProperty("spa");
				type4[2] = Language.getInstance().getProperty("val");

			}

			///////////
			dateStrings[0] = Settings.getInstance().getDateformat();

			if (dateStrings[0].equals("dd-mm-yyyy")) {
				dateStrings[1] = "dd/mm/yyyy";
				dateStrings[2] = "yyyy-mm-dd";
				dateStrings[3] = "yyyy/mm/dd";

			} else if (dateStrings[0].equals("yyyy-mm-dd")) {
				dateStrings[1] = "dd/mm/yyyy";
				dateStrings[2] = "dd-mm-yyyy";
				dateStrings[3] = "yyyy/mm/dd";

			} else if (dateStrings[0].equals("yyyy/mm/dd")) {
				dateStrings[1] = "dd/mm/yyyy";
				dateStrings[2] = "dd-mm-yyyy";
				dateStrings[3] = "yyyy-mm-dd";

			} else {
				dateStrings[0] = "dd/mm/yyyy";
				dateStrings[1] = "dd-mm-yyyy";
				dateStrings[2] = "yyyy-mm-dd";
				dateStrings[3] = "yyyy/mm/dd";
			}
			//////////

			//////////
			CoinStrings[0] = Settings.getInstance().getCoinformat();
			if (CoinStrings[0].equals("Euro")) {
				CoinStrings[0] = Language.getInstance().getProperty("euro");
				CoinStrings[1] = Language.getInstance().getProperty("dollar");
				CoinStrings[2] = Language.getInstance().getProperty("pounds");
			} else if ((CoinStrings[0].equals("Dollars")) || (CoinStrings[0].equals("Dolares"))
					|| (CoinStrings[0].equals("Dolars"))) {
				CoinStrings[0] = Language.getInstance().getProperty("dollar");
				CoinStrings[1] = Language.getInstance().getProperty("euro");
				CoinStrings[2] = Language.getInstance().getProperty("pounds");
			} else if ((CoinStrings[0].equals("Pounds")) || (CoinStrings[0].equals("Libras"))
					|| (CoinStrings[0].equals("Lliures"))) {
				CoinStrings[0] = Language.getInstance().getProperty("pounds");
				CoinStrings[1] = Language.getInstance().getProperty("euro");
				CoinStrings[2] = Language.getInstance().getProperty("dollar");
			} else {
				CoinStrings[0] = Language.getInstance().getProperty("euro");
				CoinStrings[1] = Language.getInstance().getProperty("dollar");
				CoinStrings[2] = Language.getInstance().getProperty("pounds");
			}
			///////////
			DecimalStrings[0] = Settings.getInstance().getDecimalformat();
			if (DecimalStrings[0].equals(".00")) {
				DecimalStrings[1] = ".0";
				DecimalStrings[2] = ".000";
			} else if (DecimalStrings[0].equals(".000")) {
				DecimalStrings[1] = ".0";
				DecimalStrings[2] = ".00";
			} else {
				DecimalStrings[0] = ".0";
				DecimalStrings[1] = ".00";
				DecimalStrings[2] = ".000";
			}

			type2[0] = Settings.getInstance().getTheme();
			// "Metal", "GTK", "Motif", "Ninbus"};
			if (type2[0].equals("Metal")) {
				type2[1] = "GTK";
				type2[2] = "Motif";
				type2[3] = "Ninbus";
			} else if (type2[0].equals("GTK")) {
				type2[1] = "Motif";
				type2[2] = "Ninbus";
				type2[3] = "Metal";
			} else if (type2[0].equals("Motif")) {
				type2[1] = "Ninbus";
				type2[2] = "Metal";
				type2[3] = "GTK";

			} else if (type2[0].equals("Ninbus")) {
				type2[1] = "Metal";
				type2[2] = "GTK";
				type2[3] = "Motif";
			}

		}

		dateModel = new SpinnerListModel(dateStrings);
		spinner_date = new JSpinner(dateModel);
		CoinModel = new SpinnerListModel(CoinStrings);
		spinner_coin = new JSpinner(CoinModel);
		DecimalModel = new SpinnerListModel(DecimalStrings);
		spinner_decimal = new JSpinner(DecimalModel);
		fformat = new SpinnerListModel(fformatStrings);
		spinner_fformat = new JSpinner(fformat);
		combo4 = new JComboBox(type2);
		combo2 = new JComboBox(type3);
		combo3 = new JComboBox(type4);
		panel.add(new JLabel(Language.getInstance().getProperty("dateformat")));
		panel.add(spinner_date);
		panel.add(new JLabel(Language.getInstance().getProperty("coinformat")));
		panel.add(spinner_coin);
		panel.add(new JLabel(Language.getInstance().getProperty("decimalformat")));
		panel.add(spinner_decimal);
		panel.add(new JLabel(Language.getInstance().getProperty("fformat")));
		panel.add(spinner_fformat);
		panel.add(new JLabel(Language.getInstance().getProperty("language")));
		panel.add(combo3);
		panel.add(new JLabel(Language.getInstance().getProperty("theme")));
		panel.add(combo4);
		panel.add(new JLabel("                                           "));
		panel.add(new JLabel(Language.getInstance().getProperty("options")));
		panel.add(new JLabel(Language.getInstance().getProperty("dummies")));
		if (Settings.getInstance().getDummies().equals("ON")) {
			check.setSelected(true);
		} else {
			check.setSelected(false);
		}
		panel.add(check);
		panel.add(reset2);

		do {

			result = JOptionPane.showConfirmDialog(null, panel, Language.getInstance().getProperty("settings"),
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if ((result == JOptionPane.CANCEL_OPTION) || (result == -1)) {

				control = true;

			} else {
				////////////////////////////////////////////////////////////////////////////////////
				spinnerdate = Functions.ConvertObjectToString(spinner_date.getValue());
				spinnercoin = Functions.ConvertObjectToString(spinner_coin.getValue());
				spinnerdecimal = Functions.ConvertObjectToString(spinner_decimal.getValue());
				spinnerfformat = Functions.ConvertObjectToString(spinner_fformat.getValue());
				if (check.isSelected()) {
					dummies = "ON";
				} else {
					dummies = "OFF";
				}
				// dummies =
				// Functions.ConvertObjectToString(combo2.getSelectedItem());
				lang = Functions.ConvertObjectToString(combo3.getSelectedItem());
				theme = Functions.ConvertObjectToString(combo4.getSelectedItem());
				////////////////////////////////////////////////////////////////////////////////////

				if ((control = true)) {
					control = true;
					Settings.getInstance().setDateformat(spinnerdate);
					Settings.getInstance().setCoinformat(spinnercoin);
					Settings.getInstance().setDecimalformat(spinnerdecimal);
					Settings.getInstance().setDummies(dummies);
					Settings.getInstance().setLanguage(lang);
					Settings.getInstance().setFileformat(spinnerfformat);
					Settings.getInstance().setTheme(theme);
					if (reset2.isSelected()) {
						Functions_save_settings.open_default();
					}
				}

			}

		} while (control == false);

	}

	/*
	 * 
	 * Used on the main menu to make the first menu
	 * 
	 */
	// Menu with buttons, needs "type", "message" and returns "op"
	public static int menu(String[] type, String message, String title) {

		int op = 0;

		op = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.PLAIN_MESSAGE, null, type, type[0]);
		return op;
	}

	/*
	 * 
	 * Combobox that uses the ConverObjectToString bc i need to use the
	 * selection as a String
	 */
	// ComboBox
	public static String combobox(String[] type, String message, String title) {
		Object selection = "";
		String str = "";
		selection = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, type, type[0]);
		str = Functions.ConvertObjectToString(selection);
		return str;
	}

}
