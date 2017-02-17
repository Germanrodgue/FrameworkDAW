package exer3_1.Modules.Users.Model.BLL.BLL_User;

import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Utils.Functions_menu;

public class Functions_find {
	public static String[] generate_vector_admin() {
		Admin a1 = null;
		String s = "";
		int arraylist = Singleton.adminuser.size();
		String[] user = new String[arraylist];
		for (int i = 0; i < arraylist; i++) {
			a1 = (Admin) Singleton.adminuser.get(i);
			s = a1.getId() + "      " + a1.getName();
			user[i] = s;
		}

		return user;
	}

	public static String[] generate_vector_client() {
		Client c1 = null;
		String s = "";
		int arraylist = Singleton.clientuser.size();
		String[] user = new String[arraylist];
		for (int i = 0; i < arraylist; i++) {
			c1 = (Client) Singleton.clientuser.get(i);
			s = c1.getId() + "      " + c1.getName();
			user[i] = s;
		}

		return user;
	}

	public static String[] generate_vector_normal() {
		NormalUser n1 = null;
		String s = "";
		int arraylist = Singleton.normaluser.size();
		String[] user = new String[arraylist];
		for (int i = 0; i < arraylist; i++) {
			n1 = (NormalUser) Singleton.normaluser.get(i);
			s = n1.getId() + "      " + n1.getName();
			user[i] = s;
		}

		return user;
	}

	public static Admin find_admin_dni() {
		Admin a1 = null;
		String ID = "";
		String[] admin = generate_vector_admin();
		String search = Functions_menu.combobox(admin, "", "");
		if (search != "") {
			for (int i = 0; i < 9; i++) {
				ID += search.charAt(i);
			}
			a1 = new Admin(ID);
		}
		return a1;
	}

	public static int find_admin(Admin a) {

		System.out.println(a.getId());

		for (int i = 0; i <= (Singleton.adminuser.size() - 1); i++) {

			if ((Singleton.adminuser.get(i)).equals_id(a)) {

				return i;
			}

		}

		for (int i = 0; i <= (Singleton.adminuser.size() - 1); i++) {

			if ((Singleton.adminuser.get(i)).equals_username(a)) {

				return i;
			}

		}

		for (int i = 0; i <= (Singleton.adminuser.size() - 1); i++) {

			if ((Singleton.adminuser.get(i)).equals_email(a)) {

				return i;
			}

		}

		return -1;
	}

	public static int find_admin_email(Admin a) {

		for (int i = 0; i <= (Singleton.adminuser.size() - 1); i++) {

			if ((Singleton.adminuser.get(i)).equals_email(a)) {

				return i;
			}

		}

		return -1;

	}

	public static int find_client_email(Client c) {

		for (int i = 0; i <= (Singleton.clientuser.size() - 1); i++) {

			if ((Singleton.clientuser.get(i)).equals_email(c)) {

				return i;
			}

		}

		return -1;

	}

	public static int find_admin_username(Admin a) {

		for (int i = 0; i <= (Singleton.adminuser.size() - 1); i++) {

			if ((Singleton.adminuser.get(i)).equals_username(a)) {

				return i;
			}

		}

		return -1;

	}

	public static int find_client_username(Client c) {

		for (int i = 0; i <= (Singleton.clientuser.size() - 1); i++) {

			if ((Singleton.clientuser.get(i)).equals_username(c)) {

				return i;
			}

		}

		return -1;

	}

	public static int find_client(Client c) {

		System.out.println(c.getId());

		for (int i = 0; i <= (Singleton.clientuser.size() - 1); i++) {

			if ((Singleton.clientuser.get(i)).equals_id(c)) {

				return i;
			}

		}

		for (int i = 0; i <= (Singleton.clientuser.size() - 1); i++) {

			if ((Singleton.clientuser.get(i)).equals_username(c)) {

				return i;
			}

		}

		for (int i = 0; i <= (Singleton.clientuser.size() - 1); i++) {

			if ((Singleton.clientuser.get(i)).equals_email(c)) {

				return i;
			}

		}

		return -1;
	}

	public static int find_normal(NormalUser n) {

		System.out.println(n.getId());

		for (int i = 0; i <= (Singleton.normaluser.size() - 1); i++) {

			if ((Singleton.normaluser.get(i)).equals_id(n)) {

				return i;
			}

		}

		return -1;
	}

	public static Client find_client_dni() {

		Client c1 = null;
		String ID = "";
		String[] client = generate_vector_client();
		String search = exer3_1.Utils.Functions_menu.combobox(client, "", "");
		if (search != "") {
			for (int i = 0; i < 9; i++) {
				ID += search.charAt(i);
			}
			c1 = new Client(ID);
		}
		return c1;
	}

	public static NormalUser find_normal_dni() {
		NormalUser n1 = null;
		String ID = "";
		String[] normal = generate_vector_normal();
		String search = exer3_1.Utils.Functions_menu.combobox(normal, "", "");
		if (search != "") {
			for (int i = 0; i < 9; i++) {
				ID += search.charAt(i);
			}
			n1 = new NormalUser(ID);
		}
		return n1;
	}
}
