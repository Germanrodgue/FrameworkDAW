package exer3_1.Modules.Users.Model.DAO;

import java.text.ParseException;

import javax.swing.JOptionPane;

import exer3_1.Classes.Settings;
import exer3_1.Classes.date;
import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.BLL.BLL_Dummies.Functions_dummies;
import exer3_1.Modules.Users.Model.BLL.BLL_User.Functions_find;
import exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD.Functions_create;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.User;
import exer3_1.Modules.Users.Model.Utils.Functions_ask_date;
import exer3_1.Modules.Users.Model.Utils.Functions_data_user;
import exer3_1.Utils.Functions_menu;

public class Functions_user {
	//// CREATE USER////
	public static void create_user() throws ParseException {
		if (Settings.getInstance().getDummies().equals("ON")) {

			if (Singleton_menu.option == 0) {
				Functions_dummies.makedummies_admin();
			} else if (Singleton_menu.option == 1) {
				Functions_dummies.makedummies_client();
			} else {
				Functions_dummies.makedummies_normal();
			}

		} else {
			Functions_create.create_user();
		}
	}

	public static void set_adminDNI(User param) {
		int location = -1;

		Singleton_menu.a = Functions_data_user.ask_adminDNI();

		location = Functions_find.find_admin(Singleton_menu.a);

		if (location != -1) {

			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);

		} else {

			param.setId(Singleton.DNI);
		}
	}

	public static void set_clientDNI(User param) {
		int location = -1;

		Singleton_menu.c = Functions_data_user.ask_clientDNI();

		location = Functions_find.find_client(Singleton_menu.c);

		if (location != -1) {

			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);

		} else {

			param.setId(Singleton.DNI);
		}
	}

	public static void set_adminEmail(User param) {
		int location = -1;
		Admin a2 = null;

		a2 = Functions_data_user.ask_adminEmail();

		location = Functions_find.find_admin_email(a2);

		if (location != -1) {

			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);

		} else {

			Singleton_menu.a.setEmail(Singleton.Email);
		}
	}

	//// UPDATE USER////
	public static void update_user() throws ParseException {
		// Update admin attributes
		String attribute = "";
		int intdata = 0;
		String data = "";
		int location = -1;
		String[] updateadmin = { Language.getInstance().getProperty("id_get"),
				Language.getInstance().getProperty("name_get"), Language.getInstance().getProperty("address_get"),
				Language.getInstance().getProperty("bdate"), Language.getInstance().getProperty("gender_get"),
				Language.getInstance().getProperty("email_get"), "Avatar",
				Language.getInstance().getProperty("username_get"), Language.getInstance().getProperty("password_get"),
				Language.getInstance().getProperty("jdate_get") };
		String[] updateclient = { Language.getInstance().getProperty("id_get"),
				Language.getInstance().getProperty("name_get"), Language.getInstance().getProperty("address_get"),
				Language.getInstance().getProperty("bdate"), Language.getInstance().getProperty("gender_get"),
				Language.getInstance().getProperty("email_get"), "Avatar",
				Language.getInstance().getProperty("username_get"), Language.getInstance().getProperty("password_get"),
				Language.getInstance().getProperty("purchases_get"), Language.getInstance().getProperty("jdate_get") };
		String[] updatenormal = { Language.getInstance().getProperty("id_get"),
				Language.getInstance().getProperty("name_get"), Language.getInstance().getProperty("address_get"),
				Language.getInstance().getProperty("bdate"), Language.getInstance().getProperty("gender_get"),
				Language.getInstance().getProperty("comments_get") };

		String[] gender1 = { Language.getInstance().getProperty("male"), Language.getInstance().getProperty("female"),
				Language.getInstance().getProperty("other") };
		String[] avatar1 = { "Avatar1", "Avatar2", "Default" };
		date fnac = null;
		date fjoin = null;
		Admin a2 = null;
		Client c2 = null;

		if (Singleton_menu.option == 0) {

			attribute = Functions_menu.combobox(updateadmin, Language.getInstance().getProperty("pick"),
					Language.getInstance().getProperty("pick"));

			switch (attribute) {
			case "Dni":
			case "Id":

				Functions_user.set_adminDNI(Singleton_menu.a);

				break;
			case "Nom":
			case "Nombre":
			case "Name":

				data = Functions_data_user.Ask_name(data, 1);
				Singleton_menu.a.setName(data);

				break;
			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				fnac = Functions_ask_date.Ask_birthdate("", 1, 16);
				Singleton_menu.a.setBirthdate(fnac);

				break;
			case "Direccio":
			case "Direccion":
			case "Address":
				data = Functions_data_user.Ask_name(data, 1);
				Singleton_menu.a.setAddress(data);

				break;
			case "Sexe":
			case "Sexo":
			case "Gender":
				data = Functions_menu.combobox(gender1, Language.getInstance().getProperty("pick"),
						Language.getInstance().getProperty("pick"));
				Singleton_menu.a.setGender(data);

				break;
			case "Correu electronic":
			case "Correo electronico":
			case "Email":

				do {
					data = Functions_data_user.Ask_email(data, 1);
					Singleton.Email = data;

					a2 = new Admin(Singleton.Email, "", "", "");
					location = Functions_find.find_admin_email(a2);

					if (location != -1) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("email_used"));
					}
				} while (location != -1);
				Singleton_menu.a.setEmail(Singleton.Email);
				break;
			case "Avatar":
				data = Functions_menu.combobox(avatar1, Language.getInstance().getProperty("pick"),
						Language.getInstance().getProperty("pick"));
				Singleton_menu.a.setAvatar(data);

				break;
			case "Nom d'usuari":
			case "Nombre de usuario":
			case "Username":
				do {
					data = Functions_data_user.Ask_username(data, 1);
					Singleton.Username = data;

					a2 = new Admin(Singleton.Username, "");
					location = Functions_find.find_admin_username(a2);

					if (location != -1) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("username_used"));
					}
				} while (location != -1);
				Singleton_menu.a.setUsername(Singleton.Username);

				break;
			case "Contrasenya":
			case "Contraseña":
			case "Password":
				data = Functions_data_user.Ask_passwd(data, 1);
				Singleton_menu.a.setPassword(data);

				break;
			case "Data d'entrada":
			case "Fecha de entrada":
			case "Join Date":
				fjoin = Functions_ask_date.Ask_Joindate("", 1, fjoin, 16);
				Singleton_menu.a.setJoinDate(fjoin);

				break;
			}
		}
		if (Singleton_menu.option == 1) {
			attribute = Functions_menu.combobox(updateclient, Language.getInstance().getProperty("pick"),
					Language.getInstance().getProperty("pick"));
			switch (attribute) {
			case "Dni":
			case "Id":
				Functions_user.set_clientDNI(Singleton_menu.c);

				break;
			case "Nom":
			case "Nombre":
			case "Name":
				data = Functions_data_user.Ask_name(data, 1);
				Singleton_menu.c.setName(data);
				break;
			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				fnac = Functions_ask_date.Ask_birthdate("", 1, 16);
				Singleton_menu.c.setBirthdate(fnac);
				break;
			case "Sexe":
			case "Sexo":
			case "Gender":
				data = Functions_menu.combobox(gender1, Language.getInstance().getProperty("pick"),
						Language.getInstance().getProperty("pick"));
				Singleton_menu.c.setGender(data);
				break;
			case "Correu electronic":
			case "Correo electronico":
			case "Email":
				do {
					data = Functions_data_user.Ask_email(data, 1);
					Singleton.Email = data;

					c2 = new Client(Singleton.Email, "", "", "");
					location = Functions_find.find_client_email(c2);

					if (location != -1) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("email_used"));
					}
				} while (location != -1);
				Singleton_menu.c.setEmail(Singleton.Email);
				break;
			case "Avatar":
				data = Functions_menu.combobox(avatar1, Language.getInstance().getProperty("pick"),
						Language.getInstance().getProperty("pick"));
				Singleton_menu.c.setAvatar(data);

				break;
			case "Nom d'usuari":
			case "Nombre de usuario":
			case "Username":
				do {
					data = Functions_data_user.Ask_username(data, 1);
					Singleton.Username = data;

					c2 = new Client(Singleton.Username, "");
					location = Functions_find.find_client_username(c2);

					if (location != -1) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("username_used"));
					}
				} while (location != -1);
				Singleton_menu.c.setUsername(Singleton.Username);
				break;
			case "Contrasenya":
			case "Contraseña":
			case "Password":
				data = Functions_data_user.Ask_passwd(data, 1);
				Singleton_menu.c.setPassword(data);
				break;
			case "Compres":
			case "Compras":
			case "Purchases":
				intdata = Functions_data_user.Ask_Purchases(data, 1);
				Singleton_menu.c.setPurchases(intdata);
				break;
			case "Data d'entrada":
			case "Fecha de entrada":
			case "Join Date":
				fjoin = Functions_ask_date.Ask_Joindate("", 1, fjoin, 16);
				Singleton_menu.c.setJoinDate(fjoin);
				break;
			}
		}
		if (Singleton_menu.option == 2) {
			attribute = Functions_menu.combobox(updatenormal, Language.getInstance().getProperty("pick"),
					Language.getInstance().getProperty("pick"));
			switch (attribute) {
			case "Nom":
			case "Nombre":
			case "Name":

				data = Functions_data_user.Ask_name(data, 1);
				Singleton_menu.n.setName(data);
				break;
			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				fnac = Functions_ask_date.Ask_birthdate("", 1, 16);
				Singleton_menu.n.setBirthdate(fnac);
				break;
			case "Sexe":
			case "Sexo":
			case "Gender":
				data = Functions_menu.combobox(gender1, Language.getInstance().getProperty("pick"),
						Language.getInstance().getProperty("pick"));
				Singleton_menu.n.setGender(data);
				break;
			case "Comentaris":
			case "Comentarios":
			case "Comments":
				intdata = Functions_data_user.Ask_Comments(data, 1);
				Singleton_menu.n.setComments(intdata);
				break;
			}
		}

	}

	//// GET USER////
	public static String get_user() {

		String attribute = "";
		String[] getclient = { Language.getInstance().getProperty("id_get"),
				Language.getInstance().getProperty("name_get"), Language.getInstance().getProperty("address_get"),
				Language.getInstance().getProperty("bdate"), Language.getInstance().getProperty("gender_get"),
				Language.getInstance().getProperty("email_get"), "Avatar",
				Language.getInstance().getProperty("username_get"), Language.getInstance().getProperty("password_get"),
				Language.getInstance().getProperty("purchases_get"), Language.getInstance().getProperty("points_get"),
				Language.getInstance().getProperty("freepoints_get"),
				Language.getInstance().getProperty("discounts_get"), Language.getInstance().getProperty("jdate_get") };

		String[] getadmin = { Language.getInstance().getProperty("id_get"),
				Language.getInstance().getProperty("name_get"), Language.getInstance().getProperty("address_get"),
				Language.getInstance().getProperty("bdate"), Language.getInstance().getProperty("gender_get"),
				Language.getInstance().getProperty("type_get"), Language.getInstance().getProperty("email_get"),
				"Avatar", Language.getInstance().getProperty("username_get"),
				Language.getInstance().getProperty("password_get"), Language.getInstance().getProperty("salary_get"),
				Language.getInstance().getProperty("jdate_get"), Language.getInstance().getProperty("antiquity_get") };

		String[] getnormal = { Language.getInstance().getProperty("id_get"),
				Language.getInstance().getProperty("name_get"), Language.getInstance().getProperty("bdate"),
				Language.getInstance().getProperty("gender_get"), Language.getInstance().getProperty("comments_get"),
				Language.getInstance().getProperty("karma_get"), Language.getInstance().getProperty("points_get") };

		String ch = "";

		if (Singleton_menu.option == 0) {
			attribute = Functions_menu.combobox(getadmin, Language.getInstance().getProperty("pick"),
					Language.getInstance().getProperty("pick"));
			switch (attribute) {
			case "Dni":
			case "Id":
				ch = attribute + ": " + Singleton_menu.a.getId();
				break;
			case "Nom":
			case "Nombre":
			case "Name":
				ch = attribute + ": " + Singleton_menu.a.getName();
				break;
			case "Direccio":
			case "Direccion":
			case "Address":
				ch = attribute + ": " + Singleton_menu.a.getAddress();
				break;
			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				ch = Language.getInstance().getProperty("birthdate_get") + ": " + Singleton_menu.a.getAge();
				ch = ch + "\n" + Language.getInstance().getProperty("bdate") + ": "
						+ Singleton_menu.a.getBirthdate().getDate();
				break;
			case "Sexe":
			case "Sexo":
			case "Gender":
				ch = attribute + ": " + Singleton_menu.a.getGender();
				break;
			case "Tipus":
			case "Tipo":
			case "Type":
				ch = attribute + ": " + Language.getInstance().getProperty("admin");
				break;
			case "Correu electronic":
			case "Correo electronico":
			case "Email":
				ch = attribute + ": " + Singleton_menu.a.getEmail();
				break;
			case "Avatar":
				ch = attribute + ": " + Singleton_menu.a.getAvatar();
				break;
			case "Nom d'usuari":
			case "Nombre de usuario":
			case "Username":
				ch = attribute + ": " + Singleton_menu.a.getUsername();
				break;
			case "Contrasenya":
			case "Contraseña":
			case "Password":
				ch = attribute + ": " + Singleton_menu.a.getPassword();
				break;
			case "Salari":
			case "Salario":
			case "Salary":
				ch = attribute + ": " + Singleton_menu.a.get_Total_Salary();
				ch = ch + "\n" + Language.getInstance().getProperty("basic_salary")
						+ Singleton_menu.a.get_BasicSalary();
				break;
			case "Data d'entrada":
			case "Fecha de entrada":
			case "Join Date":
				ch = attribute + ": " + Singleton_menu.a.getJoinDate().getDate();
				break;
			case "Antigüetat":
			case "Antigüedad":
			case "Antiquity":
				ch = attribute + ": " + Singleton_menu.a.getAntiquity() + " "
						+ Language.getInstance().getProperty("years")
						+ (((Singleton_menu.a.getAntiquity()) == 1) ? "" : "s");
				ch = ch + "\n" + Language.getInstance().getProperty("%antiquity")
						+ (Singleton_menu.a.get_Percent_Salary()) + " %";
				break;
			}
			JOptionPane.showMessageDialog(null, ch);
		}
		if (Singleton_menu.option == 1) {
			attribute = Functions_menu.combobox(getclient, Language.getInstance().getProperty("pick"),
					Language.getInstance().getProperty("pick"));

			switch (attribute) {
			case "Dni":
			case "Id":
				ch = attribute + ": " + Singleton_menu.c.getId();
				break;
			case "Nom":
			case "Nombre":
			case "Name":
				ch = attribute + ": " + Singleton_menu.c.getName();
				break;
			case "Direccio":
			case "Direccion":
			case "Address":
				ch = attribute + ": " + Singleton_menu.c.getAddress();
				break;
			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				ch = Language.getInstance().getProperty("birthdate_get") + ": " + Singleton_menu.c.getAge();
				ch = ch + "\n" + Language.getInstance().getProperty("bdate") + ": "
						+ Singleton_menu.c.getBirthdate().getDate();
				break;
			case "Sexe":
			case "Sexo":
			case "Gender":
				ch = attribute + ": " + Singleton_menu.c.getGender();
				break;
			case "Correu electronic":
			case "Correo electronico":
			case "Email":
				ch = attribute + ": " + Singleton_menu.c.getEmail();
				break;
			case "Avatar":
				ch = attribute + ": " + Singleton_menu.c.getAvatar();
				break;
			case "Nom d'usuari":
			case "Nombre de usuario":
			case "Username":
				ch = attribute + ": " + Singleton_menu.c.getUsername();
				break;
			case "Contrasenya":
			case "Contraseña":
			case "Password":
				ch = attribute + ": " + Singleton_menu.c.getPassword();
				break;
			case "Punts":
			case "Puntos":
			case "Points":
				ch = attribute + ": " + Singleton_menu.c.get_TotalPoints();
				break;
			case "Punts gratis":
			case "Puntos gratis":
			case "Free Points":
				ch = attribute + ": +" + Singleton_menu.c.get_Free_Points();
				break;
			case "Compres":
			case "Compras":
			case "Purchases":
				ch = attribute + ": " + Singleton_menu.c.getPurchases();
				break;
			case "Descomptes":
			case "Descuentos":
			case "Discounts":
				ch = attribute + ": " + Singleton_menu.c.getDiscounts();
				break;
			case "Data d'entrada":
			case "Fecha de entrada":
			case "Join Date":
				ch = attribute + ": " + Singleton_menu.c.getJoinDate().getDate();
				break;
			}
			JOptionPane.showMessageDialog(null, ch);
		}
		if (Singleton_menu.option == 2) {
			attribute = Functions_menu.combobox(getnormal, Language.getInstance().getProperty("pick"),
					Language.getInstance().getProperty("pick"));
			switch (attribute) {
			case "DNI":
			case "Id":
				ch = attribute + ": " + Singleton_menu.n.getId();
				break;
			case "Nom":
			case "Nombre":
			case "Name":
				ch = attribute + ": " + Singleton_menu.n.getName();
				break;
			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				ch = Language.getInstance().getProperty("age") + Singleton_menu.n.getAge();
				ch = ch + "\n" + Language.getInstance().getProperty("birthdate")
						+ Singleton_menu.n.getBirthdate().getDate();
				break;
			case "Sexe":
			case "Sexo":
			case "Gender":
				ch = attribute + ": " + Singleton_menu.n.getGender();
				break;
			case "Comentaris":
			case "Comentarios":
			case "Comments":
				ch = attribute + ": " + Singleton_menu.n.getComments();
				break;
			case "Karma":
				ch = attribute + ": " + Singleton_menu.n.getKarma();
				break;
			case "Punts":
			case "Puntos":
			case "Points":
				ch = attribute + ": " + Singleton_menu.n.getPoints();
				break;
			}
			JOptionPane.showMessageDialog(null, ch);
		}

		return ch;

	}
}
