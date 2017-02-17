package exer3_1.Modules.Menu;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import exer3_1.Classes.Settings;
import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Users.Model.BLL.BLL_User.Functions_order;
import exer3_1.Modules.Users.Model.BLL.BLL_User.functions_files;
import exer3_1.Modules.Users.Model.BLL.BLL_User.save;
import exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD.Functions_delete;
import exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD.Functions_get;
import exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD.Functions_read;
import exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD.Functions_update;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.DAO.Functions_user;
import exer3_1.Utils.Functions_menu;
import exer3_1.Utils.Functions_save_settings;

/**
 * Main menu used to crçççate Admins, Clients and Normal users using ArrayLists and saving the users on a file.
 * 
 * @version 5.1, 15/2/2017
 * @author German Rodriguez
 *
 */
public class menu {

	public static void main(String[] args) throws ParseException {

		Singleton.adminuser = new ArrayList<Admin>();
		Singleton.clientuser = new ArrayList<Client>();
		Singleton.normaluser = new ArrayList<NormalUser>();
		// Singleton.normaluser = new ArrayList<NormalUser>();
		// Singleton_menu.language = new Language("English");
		// Singleton_menu.settings = new Settings("dd/mm/yyyy", "Euro", ".0",
		// "ON", "Default", "English", "Json", "");
		int op = -1;
		int loop = 0;
		int count = 0;
		String ut = "";
		String[] type = { "Create User", "Read User", "Update User", "Delete User", "Get User", "Order", "Open",
				"Save" };
		String[] typeuser = { Language.getInstance().getProperty("admin"), Language.getInstance().getProperty("client"),
				Language.getInstance().getProperty("nuser"), Language.getInstance().getProperty("settings"),
				Language.getInstance().getProperty("about") };
		String userdir = System.getProperty("user.dir");

		final ImageIcon photo = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/About/photo.png");

		Settings.getInstance();
		// Choose an option
		// open.auto();

		do {
			if (op == -1) {
				do {

					// Main menu
					typeuser[0] = Language.getInstance().getProperty("admin");
					typeuser[1] = Language.getInstance().getProperty("client");
					typeuser[2] = Language.getInstance().getProperty("nuser");
					typeuser[3] = Language.getInstance().getProperty("settings");
					typeuser[4] = Language.getInstance().getProperty("about");
					type[5] = Language.getInstance().getProperty("order");
					type[6] = Language.getInstance().getProperty("open");
					type[7] = Language.getInstance().getProperty("save");

					ut = Functions_menu.combobox(typeuser, Language.getInstance().getProperty("pick"),
							Language.getInstance().getProperty("pick"));

					switch (ut) {
					case "Administrador":
					case "Admin":
						type[0] = Language.getInstance().getProperty("createa");
						type[1] = Language.getInstance().getProperty("reada");
						type[2] = Language.getInstance().getProperty("updatea");
						type[3] = Language.getInstance().getProperty("deletea");
						type[4] = Language.getInstance().getProperty("geta");
						Singleton_menu.option = 0;
						break;
					case "Cliente":
					case "Client":
						type[0] = Language.getInstance().getProperty("createc");
						type[1] = Language.getInstance().getProperty("readc");
						type[2] = Language.getInstance().getProperty("updatec");
						type[3] = Language.getInstance().getProperty("deletec");
						type[4] = Language.getInstance().getProperty("getc");
						Singleton_menu.option = 1;
						break;
					case "Usuari Normal":
					case "Usuario Normal":
					case "Normal User": {
						type[0] = Language.getInstance().getProperty("createn");
						type[1] = Language.getInstance().getProperty("readn");
						type[2] = Language.getInstance().getProperty("updaten");
						type[3] = Language.getInstance().getProperty("deleten");
						type[4] = Language.getInstance().getProperty("getn");
						Singleton_menu.option = 2;
						break;
					}
					case "Configuracio":
					case "Ajustes":
					case "Settings":

						Functions_menu.Settings();

						Singleton_menu.option = 3;
						break;
					case "Sobre":
					case "Acerca de":
					case "About":
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("createdabout"),
								Language.getInstance().getProperty("about"), JOptionPane.INFORMATION_MESSAGE, photo);

						Singleton_menu.option = 3;
						break;
					case "":
						Functions_save_settings.save();
						save.auto();
						System.exit(0);
						break;
					}

				} while (Singleton_menu.option == 3);
			}

			if (count == 0) {

				op = Functions_menu.menu(type, Language.getInstance().getProperty("select"), ut + " menu");
			}

			switch (op) {

			/////// CREATE////////

			case 0:

				if (Singleton_menu.option == 0)
					Functions_user.create_user();

				if (Singleton_menu.option == 1)
					Functions_user.create_user();

				if (Singleton_menu.option == 2)
					Functions_user.create_user();

				break;

			////// READ///////
			case 1:

				if (Singleton_menu.option == 0)
					Functions_read.read_admin();

				if (Singleton_menu.option == 1)
					Functions_read.read_client();

				if (Singleton_menu.option == 2)
					Functions_read.read_normal_user();

				break;

			/////// UPDATE///////
			case 2:

				if (Singleton_menu.option == 0)
					Functions_update.update_admin();

				if (Singleton_menu.option == 1)
					Functions_update.update_client();

				if (Singleton_menu.option == 2)
					Functions_update.update_normal();

				break;

			///// DELETE//////
			case 3:

				if (Singleton_menu.option == 0)
					Functions_delete.delete_admin();

				if (Singleton_menu.option == 1)
					Functions_delete.delete_client();

				if (Singleton_menu.option == 2)
					Functions_delete.delete_normal();

				break;

			//// GET////
			case 4:

				if (Singleton_menu.option == 0)
					Functions_get.get_admin();

				if (Singleton_menu.option == 1)
					Functions_get.get_client();

				if (Singleton_menu.option == 2)
					Functions_get.get_normal();

				break;
			//// ORDER////
			case 5:

				Functions_order.change_order();

				break;

			//// OPEN////
			case 6:

				functions_files.open();

				break;

			//// SAVE////
			case 7:

				functions_files.save();

				break;

			}

		} while (loop != -1);

	}

}