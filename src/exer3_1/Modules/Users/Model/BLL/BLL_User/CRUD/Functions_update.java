package exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD;

import java.text.ParseException;

import javax.swing.JOptionPane;

import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.BLL.BLL_User.Functions_find;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Modules.Users.Model.DAO.Functions_user;

public class Functions_update {

	public static void update_admin() throws ParseException {
		int location1 = -1;

		if (Singleton.adminuser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			location1 = -1;
			Singleton_menu.a = Functions_find.find_admin_dni();
			if (Singleton_menu.a == null) {

			} else {
				location1 = Functions_find.find_admin(Singleton_menu.a);
				if (location1 != -1) {
					Singleton_menu.a = Singleton.adminuser.get(location1);

					Functions_user.update_user();

				}
			}
		}
	}

	public static void update_client() throws ParseException {
		int location1 = -1;

		if (Singleton.clientuser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			location1 = -1;
			Singleton_menu.c = Functions_find.find_client_dni();
			if (Singleton_menu.c == null) {

			} else {
				location1 = Functions_find.find_client(Singleton_menu.c);
				if (location1 != -1) {
					Singleton_menu.c = Singleton.clientuser.get(location1);

					Functions_user.update_user();

				}
			}
		}
	}

	public static void update_normal() throws ParseException {
		int location1 = -1;

		if (Singleton.normaluser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			location1 = -1;
			Singleton_menu.n = Functions_find.find_normal_dni();
			if (Singleton_menu.n == null) {

			} else {
				location1 = Functions_find.find_normal(Singleton_menu.n);
				if (location1 != -1) {
					Singleton_menu.n = Singleton.normaluser.get(location1);

					Functions_user.update_user();

				}
			}
		}
	}

}
