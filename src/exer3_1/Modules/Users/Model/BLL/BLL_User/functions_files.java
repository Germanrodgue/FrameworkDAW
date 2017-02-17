package exer3_1.Modules.Users.Model.BLL.BLL_User;

import javax.swing.JOptionPane;

import exer3_1.Classes.Settings;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Modules.Users.Model.Utils.Files.Admin.Utils_files.ondemand_admin;
import exer3_1.Modules.Users.Model.Utils.Files.Client.Utils_files.ondemand_client;
import exer3_1.Modules.Users.Model.Utils.Files.NormalUser.Utils_files.ondemand_normal;

public class functions_files {

	/*
	 * 
	 * I use the Settings selection to open or save in the correct format
	 * 
	 */
	public static void open() {
		String Format = "";

		Format = Settings.getInstance().getFileformat();

		if (Singleton_menu.option == 0) {

			if (Format.equals("Json")) {
				ondemand_admin.open_Json_admin();
			} else if (Format.equals("Xml")) {
				ondemand_admin.open_Xml_admin();
			} else {
				ondemand_admin.open_Txt_admin();
			}

		}
		if (Singleton_menu.option == 1) {
			if (Format.equals("Json")) {
				ondemand_client.open_Json_client();
			} else if (Format.equals("Xml")) {
				ondemand_client.open_Xml_client();
			} else {
				ondemand_client.open_Txt_client();
			}

		}
		if (Singleton_menu.option == 2) {
			if (Format.equals("Json")) {
				ondemand_normal.open_Json_nuser();
			} else if (Format.equals("Xml")) {
				ondemand_normal.open_Xml_normal();
			} else {
				ondemand_normal.open_Txt_normal();
			}

		}
	}

	public static void save() {
		String Format2 = "";

		Format2 = Settings.getInstance().getFileformat();

		if (Singleton_menu.option == 0) {
			if (Singleton.adminuser.size() != 0) {
				if (Format2.equals("Json")) {
					ondemand_admin.save_Json_admin();
				} else if (Format2.equals("Xml")) {
					ondemand_admin.save_Xml_admin();
				} else {
					ondemand_admin.save_Txt_admin();
				}

			} else {
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("saveadmin"), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (Singleton_menu.option == 1) {
			if (Singleton.clientuser.size() != 0) {
				if (Format2.equals("Json")) {
					ondemand_client.save_Json_client();
				} else if (Format2.equals("Xml")) {
					ondemand_client.save_Xml_client();
				} else {
					ondemand_client.save_Txt_client();
				}
			} else {
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("saveclient"), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (Singleton_menu.option == 2) {
			if (Singleton.normaluser.size() != 0) {
				if (Format2.equals("Json")) {
					ondemand_normal.save_Json_nuser();
				} else if (Format2.equals("Xml")) {
					ondemand_normal.save_Xml_normal();
				} else {
					ondemand_normal.save_Txt_normal();
				}

			} else {
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("savenormal"), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
