package exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD;

import javax.swing.JOptionPane;

import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Users.Model.BLL.BLL_User.Functions_find;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Utils.Functions_menu;

public class Functions_delete {
	public static void delete_admin() {
		int location = -1;
		Admin a1 = null;
		int menu2 = 0;
		String[] type = { Language_user.getInstance().getProperty("deleteall"),
				Language_user.getInstance().getProperty("deleteone") };

		if (Singleton.adminuser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			menu2 = Functions_menu.menu(type, Language_user.getInstance().getProperty("optionshow"),
					Language_user.getInstance().getProperty("optionshow"));

			switch (menu2) {
			case 0:

				Singleton.adminuser.clear();

				break;

			case 1:

				if (Singleton.adminuser.isEmpty()) {

				} else {
					location = -1;
					a1 = Functions_find.find_admin_dni();
					if (a1 == null) {

					} else {
						location = Functions_find.find_admin(a1);
						if (location != -1) {
							Singleton.adminuser.remove(location);

						}

					}
				}
				break;

			}
		}
	}

	public static void delete_client() {
		int location = -1;
		Client c1 = null;
		int menu2 = 0;
		String[] type = { Language_user.getInstance().getProperty("deleteall"),
				Language_user.getInstance().getProperty("deleteone") };

		if (Singleton.clientuser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			menu2 = Functions_menu.menu(type, Language_user.getInstance().getProperty("optionshow"),
					Language_user.getInstance().getProperty("optionshow"));

			switch (menu2) {
			case 0:

				Singleton.clientuser.clear();

				break;

			case 1:

				if (Singleton.clientuser.isEmpty()) {
					
				} else {
					location = -1;
					c1 = Functions_find.find_client_dni();
					if (c1 == null) {
						
					} else {
						location = Functions_find.find_client(c1);
						if (location != -1) {
							Singleton.adminuser.remove(location);
							
						} 
					}
				}
				break;

			}
		}

	}

	public static void delete_normal() {
		int location = -1;
		NormalUser n1 = null;
		int menu2 = 0;
		String[] type = { Language_user.getInstance().getProperty("deleteall"),
				Language_user.getInstance().getProperty("deleteone") };

		if (Singleton.normaluser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			menu2 = Functions_menu.menu(type, Language_user.getInstance().getProperty("optionshow"),
					Language.getInstance().getProperty("optionshow"));

			switch (menu2) {
			case 0:

				Singleton.normaluser.clear();

				break;

			case 1:

				if (Singleton.normaluser.isEmpty()) {
					
				} else {
					location = -1;
					n1 = Functions_find.find_normal_dni();
					if (n1 == null) {
						
					} else {
						location = Functions_find.find_normal(n1);
						if (location != -1) {
							Singleton.normaluser.remove(location);
							
						} 
					}
				}
				break;

			}
		}

	}
}
