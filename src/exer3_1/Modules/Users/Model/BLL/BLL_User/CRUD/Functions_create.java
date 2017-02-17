package exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD;

import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import exer3_1.Classes.Settings;
import exer3_1.Classes.date;
import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.BLL.BLL_User.Functions_find;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Modules.Users.Model.Utils.Functions_ask_date;
import exer3_1.Modules.Users.Model.Utils.Functions_data_user;
import exer3_1.Utils.Functions;

public class Functions_create {

	////CREATE USER DUMMIES////
	public static void create_user() throws ParseException {

		String id = "";
		String name = "";
		String address = "";
		int purchasesv = 0;
		int commentsv = 0;
		String comments = "";
		String email = "";
		String avatar = "";
		String username = "";
		String passwd = "";
		String birthdate = "";
		String jdate = "";
		String emailv = "";
		String namev = "";
		String usernamev = "";
		String passwdv = "";
		String gender = "";
		String idv = "";
		String type = "";
		String[] gender1 = { Language_user.getInstance().getProperty("male"),Language.getInstance().getProperty("female"),
				Language_user.getInstance().getProperty("other") };
		String[] avatar1 = { "Default", "Avatar1", "Avatar2" };
		int location = 0;
		int cont = 0;
		int result = 0;
		boolean control = false;
		JTextField resid = new JTextField("");
		JTextField resname = new JTextField("");
		JTextField resaddress = new JTextField("");
		JTextField resemail = new JTextField("");
		JTextField resusername = new JTextField("");
		JPasswordField respasswd = new JPasswordField("");
		JTextField respurchases = new JTextField("");
		JTextField rescomments = new JTextField("");
		JTextField resdate = new JTextField("");
		JTextField resjdate = new JTextField("");
		JComboBox combo = new JComboBox(gender1);
		JComboBox combo3 = new JComboBox(avatar1);
		JPanel panel = new JPanel(new GridLayout(0, 1));
		String purchases = "";
		date fnac = null;
		date fjoin = null;


		if (Singleton_menu.option == 2) {
			panel.add(new JLabel(Language_user.getInstance().getProperty("id")));
			panel.add(resid);
			panel.add(new JLabel(Language_user.getInstance().getProperty("name")));
			panel.add(resname);
			panel.add(new JLabel(Language_user.getInstance().getProperty("bday") + "("
					+ Settings.getInstance().getDateformat() + "): "));
			panel.add(resdate);
			panel.add(new JLabel(Language_user.getInstance().getProperty("gender")));
			panel.add(combo);
			panel.add(new JLabel(Language_user.getInstance().getProperty("comments")));
			panel.add(rescomments);
			panel.add(new JLabel(Language_user.getInstance().getProperty("requiredfields")));

			do {

				result = JOptionPane.showConfirmDialog(null, panel, Language_user.getInstance().getProperty("form"),
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if ((result == JOptionPane.CANCEL_OPTION) || (result == -1)) {
					control = true;
				} else {
					////////////////////////Converts to string///////////////////////
					name = Functions.ConvertObjectToString(resname.getText());
					birthdate = Functions.ConvertObjectToString(resdate.getText());
					gender = Functions.ConvertObjectToString(combo.getSelectedItem());
					id = Functions.ConvertObjectToString(resid.getText());
					comments = Functions.ConvertObjectToString(rescomments.getText());
					/////////////////////////////////////////////////////////////////

					//////////////////Validate the fields///////////////////////////
					if (!birthdate.equals("")) {
						fnac = Functions_ask_date.Ask_birthdate(birthdate, 2, 18);
					} else {
						fnac = null;
					}
					namev = Functions_data_user.Ask_name(name, 2);
					commentsv = Functions_data_user.Ask_Comments(comments, 2);
					idv = Functions_data_user.Ask_id(id, 2);
					///////////////////////////////////////////////////////////////
					Singleton.DNI = id;

					Singleton_menu.n = new NormalUser(Singleton.DNI);
					if ((namev.equals("true true")) && (fnac != null) && (commentsv == 2)) {
						commentsv = Integer.parseInt(comments);
						Singleton_menu.n = new NormalUser(id, name, address, gender, fnac, commentsv);
						Singleton.normaluser.add(Singleton_menu.n);
						control = true;
					} else {
						cont++;
						if (cont == 1) {
							panel.add(new JLabel(Language_user.getInstance().getProperty("requiredfields2")));
						}
					}
				}
			} while (control == false);
		}

		if (Singleton_menu.option == 1) {
			panel.add(new JLabel(Language_user.getInstance().getProperty("id")));
			panel.add(resid);
			panel.add(new JLabel(Language_user.getInstance().getProperty("name")));
			panel.add(resname);
			panel.add(new JLabel(Language_user.getInstance().getProperty("address")));
			panel.add(resaddress);
			panel.add(new JLabel(Language_user.getInstance().getProperty("bday") + "("
					+ Settings.getInstance().getDateformat() + "): "));
			panel.add(resdate);
			panel.add(new JLabel(Language_user.getInstance().getProperty("jdate") + "("
					+ Settings.getInstance().getDateformat() + "): "));
			panel.add(resjdate);
			panel.add(new JLabel(Language_user.getInstance().getProperty("gender")));
			panel.add(combo);
			panel.add(new JLabel(Language_user.getInstance().getProperty("email")));
			panel.add(resemail);
			panel.add(new JLabel(Language_user.getInstance().getProperty("avatar")));
			panel.add(combo3);
			panel.add(new JLabel(Language_user.getInstance().getProperty("username")));
			panel.add(resusername);
			panel.add(new JLabel(Language_user.getInstance().getProperty("password")));
			panel.add(respasswd);
			panel.add(new JLabel(Language_user.getInstance().getProperty("purchases")));
			panel.add(respurchases);
			panel.add(new JLabel(Language_user.getInstance().getProperty("requiredfields")));
			do {
				result = JOptionPane.showConfirmDialog(null, panel, Language_user.getInstance().getProperty("form"),
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if ((result == JOptionPane.CANCEL_OPTION) || (result == -1)) {
					control = true;
				} else {

					////////////////////////Converts to string///////////////////////
					gender = Functions.ConvertObjectToString(combo.getSelectedItem());
					id = Functions.ConvertObjectToString(resid.getText());
					name = Functions.ConvertObjectToString(resname.getText());
					address = Functions.ConvertObjectToString(resaddress.getText());
					email = Functions.ConvertObjectToString(resemail.getText());
					avatar = Functions.ConvertObjectToString(combo3.getSelectedItem());
					username = Functions.ConvertObjectToString(resusername.getText());
					passwd = Functions.ConvertObjectToString(respasswd.getText());
					purchases = Functions.ConvertObjectToString(respurchases.getText());
					birthdate = Functions.ConvertObjectToString(resdate.getText());
					jdate = Functions.ConvertObjectToString(resjdate.getText());
					/////////////////////////////////////////////////////////////////	

					//////////////////Validate the fields////////////////////////////
					idv = Functions_data_user.Ask_id(id, 2);
					namev = Functions_data_user.Ask_name(name, 2);
					emailv = Functions_data_user.Ask_email(email, 2);
					purchasesv = Functions_data_user.Ask_Purchases(purchases, 2);
					if (!birthdate.equals("")) {
						fnac = Functions_ask_date.Ask_birthdate(birthdate, 2, 18);
					} else {
						fnac = null;
					}
					if (fnac != null) {

						fjoin = Functions_ask_date.Ask_Joindate(jdate, 2, fnac, 18);

					}
					usernamev = Functions_data_user.Ask_username(username, 2);
					passwdv = Functions_data_user.Ask_passwd(passwd, 2);
					////////////////////////////////////////////////////////////////
					
					Singleton.DNI = id;
					Singleton.Username = username;
					Singleton.Email = email;

					Singleton_menu.c = new Client(Singleton.DNI, Singleton.Username, Singleton.Email);

					location = Functions_find.find_client(Singleton_menu.c);

					if ((namev.equals("true true")) && (fnac != null) && (fjoin != null) && (purchasesv == 2)
							&& ((emailv.equals("true true"))
									&& ((usernamev.equals("true true")) && ((passwdv.equals("true true"))
											&& ((idv.equals("true true"))) && (location == -1))))) {
						purchasesv = Integer.parseInt(purchases);
						Singleton_menu.c = new Client(id, name, address, gender, fnac, email, avatar, username,
								passwd, purchasesv, fjoin);
						Singleton.clientuser.add(Singleton_menu.c);
						control = true;
					} else {
						cont++;
						if (cont == 1) {
							panel.add(new JLabel(Language_user.getInstance().getProperty("requiredfields2")));
						}
					}
				}
			} while (control == false);
		}

		if (Singleton_menu.option == 0) {
			panel.add(new JLabel(Language_user.getInstance().getProperty("id")));
			panel.add(resid);
			panel.add(new JLabel(Language_user.getInstance().getProperty("name")));
			panel.add(resname);
			panel.add(new JLabel(Language_user.getInstance().getProperty("address")));
			panel.add(resaddress);
			panel.add(new JLabel(Language_user.getInstance().getProperty("bdateadmin") + " ("
					+ Settings.getInstance().getDateformat() + "): "));
			panel.add(resdate);
			panel.add(new JLabel(Language_user.getInstance().getProperty("jdateadmin") + " ("
					+ Settings.getInstance().getDateformat() + "): "));
			panel.add(resjdate);
			panel.add(new JLabel(Language_user.getInstance().getProperty("gender")));
			panel.add(combo);
			panel.add(new JLabel(Language_user.getInstance().getProperty("email")));
			panel.add(resemail);
			panel.add(new JLabel(Language_user.getInstance().getProperty("avatar")));
			panel.add(combo3);
			panel.add(new JLabel(Language_user.getInstance().getProperty("username")));
			panel.add(resusername);
			panel.add(new JLabel(Language_user.getInstance().getProperty("password")));
			panel.add(respasswd);
			panel.add(new JLabel(Language_user.getInstance().getProperty("requiredfields")));

			do {

				result = JOptionPane.showConfirmDialog(null, panel, Language_user.getInstance().getProperty("form"),
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if ((result == JOptionPane.CANCEL_OPTION) || (result == -1)) {
					control = true;
				} else {

					////////////////////////Converts to string///////////////////////
					gender = Functions.ConvertObjectToString(combo.getSelectedItem());
					id = Functions.ConvertObjectToString(resid.getText());
					name = Functions.ConvertObjectToString(resname.getText());
					address = Functions.ConvertObjectToString(resaddress.getText());
					email = Functions.ConvertObjectToString(resemail.getText());
					avatar = Functions.ConvertObjectToString(combo3.getSelectedItem());
					username = Functions.ConvertObjectToString(resusername.getText());
					passwd = Functions.ConvertObjectToString(respasswd.getText());
					birthdate = Functions.ConvertObjectToString(resdate.getText());
					jdate = Functions.ConvertObjectToString(resjdate.getText());
					////////////////////////////////////////////////////////////////

					//////////////////Validate the fields////////////////////////////
					idv = Functions_data_user.Ask_id(id, 2);
					namev = Functions_data_user.Ask_name(name, 2);
					emailv = Functions_data_user.Ask_email(email, 2);
					if (!birthdate.equals("")) {
						fnac = Functions_ask_date.Ask_birthdate(birthdate, 2, 16);
					} else {
						fnac = null;
					}
					if (fnac != null) {
						fjoin = Functions_ask_date.Ask_Joindate(jdate, 2, fnac, 16);
					}
					usernamev = Functions_data_user.Ask_username(username, 2);
					passwdv = Functions_data_user.Ask_passwd(passwd, 2);
					////////////////////////////////////////////////////////////////

					//////////////////////////////ID////////////////////////////////

					Singleton.DNI = id;
					Singleton.Username = username;
					Singleton.Email = email;

					Singleton_menu.a = new Admin(Singleton.DNI, Singleton.Username, Singleton.Email);

					location = Functions_find.find_admin(Singleton_menu.a);

					if ((namev.equals("true true")) && ((emailv.equals("true true")) && (fnac != null)
							&& (fjoin != null) && ((usernamev.equals("true true")) && ((passwdv.equals("true true"))
									&& ((idv.equals("true true")) && (location == -1)))))) {

						Singleton_menu.a = new Admin(id, name, address, gender, fnac, email, avatar, username,
								passwd, fjoin);

						Singleton.adminuser.add(Singleton_menu.a);
						control = true;
					} else {
						cont++;
						if (cont == 1) {
							panel.add(new JLabel(Language_user.getInstance().getProperty("requiredfields2")));
						}
					}

				}
			} while (control == false);
		}

	}

}
