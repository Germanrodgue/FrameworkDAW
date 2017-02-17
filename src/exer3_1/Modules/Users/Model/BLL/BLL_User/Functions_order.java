package exer3_1.Modules.Users.Model.BLL.BLL_User;
import java.util.Collections;
import javax.swing.JOptionPane;


import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Age;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Avatar_Admin;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Avatar_Client;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Birthday;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Comments;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Discounts;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Email_Admin;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Email_Client;
import exer3_1.Modules.Users.Model.Classes.Order.Order_JoinDate_Admin;
import exer3_1.Modules.Users.Model.Classes.Order.Order_JoinDate_Client;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Karma;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Name;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Points_Client;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Points_Normal;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Purchases;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Salary;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Username_Admin;
import exer3_1.Modules.Users.Model.Classes.Order.Order_Username_Client;
import exer3_1.Utils.Functions_menu;

public class Functions_order {

	//private static final String Language_user_user = null;

	public static void change_order() {
		String[] options = { Language_user.getInstance().getProperty("id_get"), Language_user.getInstance().getProperty("username_get"),
				Language_user.getInstance().getProperty("name_get"), Language_user.getInstance().getProperty("birthdate_get"),
				Language_user.getInstance().getProperty("bdate"), Language_user.getInstance().getProperty("email_get"), "Avatar",
				Language_user.getInstance().getProperty("salary_get"), Language_user.getInstance().getProperty("jdate_get"),
				Language_user.getInstance().getProperty("antiquity_get") };
		String[] options2 = { Language_user.getInstance().getProperty("id_get"), Language_user.getInstance().getProperty("username_get"),
				Language_user.getInstance().getProperty("name_get"), Language_user.getInstance().getProperty("birthdate_get"),
				Language_user.getInstance().getProperty("bdate"), Language_user.getInstance().getProperty("email_get"), "Avatar",
				Language_user.getInstance().getProperty("salary_get"), Language_user.getInstance().getProperty("jdate_get"),
				Language_user.getInstance().getProperty("antiquity_get"), Language_user.getInstance().getProperty("purchases_get"),
				Language_user.getInstance().getProperty("points_get"), Language_user.getInstance().getProperty("discounts_get") };
		String[] options3 = { Language_user.getInstance().getProperty("name_get"), Language_user.getInstance().getProperty("bdate"),
				Language_user.getInstance().getProperty("comments_get"), Language_user.getInstance().getProperty("karma_get"),
				Language_user.getInstance().getProperty("points_get") };
		String menu2 = "";

		if (Singleton_menu.option == 0) {
			if (Singleton.adminuser.isEmpty()) {
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
			} else {
				menu2 = Functions_menu.combobox(options, Language_user.getInstance().getProperty("chooseorder"),
						Language_user.getInstance().getProperty("chooseorder"));
			}
		}
		if (Singleton_menu.option == 1) {
			if (Singleton.clientuser.isEmpty()) {
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
			} else {
				menu2 = Functions_menu.combobox(options2, Language_user.getInstance().getProperty("chooseorder"),
						Language_user.getInstance().getProperty("chooseorder"));
			}
		}
		if (Singleton_menu.option == 2) {
			if (Singleton.normaluser.isEmpty()) {
		
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
			} else {
				menu2 = Functions_menu.combobox(options3, Language_user.getInstance().getProperty("chooseorder"),
						Language_user.getInstance().getProperty("chooseorder"));
			}
		}

		switch (menu2) {
			case "Id":
			case "Dni":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser);
				}
				if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser);
				}
				break;

			case "Nom d'usuari":
			case "Nombre de usuario":
			case "Username":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_Username_Admin());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Username_Client());
				}
				break;

			case "Nom":
			case "Nombre":
			case "Name":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_Name());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Name());
				}
				break;

			case "Edat":
			case "Edad":
			case "Age":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_Age());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Age());
				}
				break;

			case "Data de naixement":
			case "Fecha de nacimiento":
			case "Birthdate":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_Birthday());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Birthday());
				} else if (Singleton_menu.option == 2) {
					Collections.sort(Singleton.normaluser, new Order_Birthday());
				}
				break;

			case "Correu electronic":
			case "Correo electronico":
			case "Email":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_Email_Admin());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Email_Client());
				}
				break;

			case "Avatar":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_Avatar_Admin());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Avatar_Client());
				}
				break;

			case "Salari":
			case "Salario":
			case "Salary":
				Collections.sort(Singleton.adminuser, new Order_Salary());
				break;

			case "Data d'entrada":
			case "Fecha de entrada":
			case "Join Date":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_JoinDate_Admin());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_JoinDate_Client());
				}
				break;

			case "Antigüetat":
			case "Antigüedad":
			case "Antiquity":
				if (Singleton_menu.option == 0) {
					Collections.sort(Singleton.adminuser, new Order_JoinDate_Admin());
				} else if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_JoinDate_Client());
				}
				break;
			case "Compres":
			case "Compras":
			case "Purchases":

				Collections.sort(Singleton.clientuser, new Order_Purchases());
				break;
			case "Punts":
			case "Puntos":
			case "Points":
				if (Singleton_menu.option == 1) {
					Collections.sort(Singleton.clientuser, new Order_Points_Client());
				} else if (Singleton_menu.option == 2) {
					Collections.sort(Singleton.clientuser, new Order_Points_Normal());
				}
				break;
			case "Descomptes":
			case "Descuentos":
			case "Discounts":
				Collections.sort(Singleton.clientuser, new Order_Discounts());
				break;
			case "Comentaris":
			case "Comentarios":
			case "Comments":
				Collections.sort(Singleton.normaluser, new Order_Comments());
				break;
			case "Karma":
				Collections.sort(Singleton.normaluser, new Order_Karma());
				break;

		}

	}
}
