package exer3_1.Modules.Users.Model.BLL.BLL_User.CRUD;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.BLL.BLL_User.Functions_find;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Utils.Functions_menu;

public class Functions_read {
	public static void read_admin() {

		Admin a1 = null;
		String userdir = System.getProperty("user.dir");
		final ImageIcon icon1 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar1.png");
		final ImageIcon icon2 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar2.png");
		final ImageIcon icon3 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar3.png");
		int menu2 = 0, location = -1;
		String ch = "";
		String[] type = { Language_user.getInstance().getProperty("showall"),
				Language_user.getInstance().getProperty("showone") };

		if (Singleton.adminuser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {
			menu2 = Functions_menu.menu(type, Language_user.getInstance().getProperty("optionshow"),
					Language_user.getInstance().getProperty("optionshow"));

			switch (menu2) {
				case 0:
					for (int i = 0; i < Singleton.adminuser.size(); i++) {
						ch = "";

						ch = ch + (Singleton.adminuser.get(i).toString());

						if (Singleton.adminuser.get(i).getAvatar_icon().equals("icon")) {
							JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
									JOptionPane.INFORMATION_MESSAGE, icon1);
						} else if (Singleton.adminuser.get(i).getAvatar_icon().equals("icon2")) {
							JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
									JOptionPane.INFORMATION_MESSAGE, icon2);
						} else if (Singleton.adminuser.get(i).getAvatar_icon().equals("icon3")) {
							JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
									JOptionPane.INFORMATION_MESSAGE, icon3);
						}

					}
					break;

				case 1:

					location = -1;
					a1 = Functions_find.find_admin_dni();
					if (a1 == null) {
						
					} else {

						location = Functions_find.find_admin(a1);
						if (location != -1) {
							Singleton_menu.a = Singleton.adminuser.get(location);

							if (Singleton_menu.a.getAvatar_icon().equals("icon")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.a.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon1);
							} else if (Singleton_menu.a.getAvatar_icon().equals("icon2")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.a.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon2);
							} else if (Singleton_menu.a.getAvatar_icon().equals("icon3")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.a.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon3);
							}

						}
					}
					break;

			}
		}

	}

	public static void read_client() {

		Client c2 = null;
		String userdir = System.getProperty("user.dir");
		final ImageIcon icon1 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar1.png");
		final ImageIcon icon2 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar2.png");
		final ImageIcon icon3 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar3.png");
		int menu2 = 0, location = -1;
		String ch = "";
		String[] type = { Language_user.getInstance().getProperty("showall"),
				Language_user.getInstance().getProperty("showone") };

		if (Singleton.clientuser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {

			menu2 = Functions_menu.menu(type, Language_user.getInstance().getProperty("optionshow"),
					Language_user.getInstance().getProperty("optionshow"));

			switch (menu2) {
				case 0:
					for (int i = 0; i < Singleton.clientuser.size(); i++) {
						ch = "";
						System.out.println("entra");
						ch = ch + (Singleton.clientuser.get(i).toString());

						if (Singleton.clientuser.get(i).getAvatar_icon().equals("icon")) {
							JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
									JOptionPane.INFORMATION_MESSAGE, icon1);
						} else if (Singleton.clientuser.get(i).getAvatar_icon().equals("icon2")) {
							JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
									JOptionPane.INFORMATION_MESSAGE, icon2);
						} else if (Singleton.clientuser.get(i).getAvatar_icon().equals("icon3")) {
							JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
									JOptionPane.INFORMATION_MESSAGE, icon3);
						}

					}
					break;

				case 1:
					location = -1;
					c2 = Functions_find.find_client_dni();
					if (c2 == null) {
						
					} else {
						location = Functions_find.find_client(c2);
						if (location != -1) {
							Singleton_menu.c = Singleton.clientuser.get(location);
							System.out.println(Singleton_menu.c.toString() + " XD");
							if (Singleton_menu.c.getAvatar_icon().equals("icon")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.c.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon1);
							} else if (Singleton_menu.c.getAvatar_icon().equals("icon2")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.c.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon2);
							} else if (Singleton_menu.c.getAvatar_icon().equals("icon3")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.c.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon3);
							}

						}
					}
					break;

			}
		}

	}

	public static void read_normal_user() {

		NormalUser n2 = null;
		String userdir = System.getProperty("user.dir");
		final ImageIcon icon1 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar1.png");
		final ImageIcon icon2 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar2.png");
		final ImageIcon icon3 = new ImageIcon(userdir + "/src/exer3_1/Modules/Menu/Resources/Avatars/Avatar3.png");
		int menu2 = 0, location = -1;
		String ch = "";
		String[] type = { Language_user.getInstance().getProperty("showall"),
				Language_user.getInstance().getProperty("showone") };
		if (Singleton.normaluser.isEmpty()) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("createfirst"),
					Language_user.getInstance().getProperty("createfirst"), JOptionPane.INFORMATION_MESSAGE);
		} else {

			menu2 = Functions_menu.menu(type, Language_user.getInstance().getProperty("optionshow"),
					Language_user.getInstance().getProperty("optionshow"));

			switch (menu2) {
				case 0:
					for (int i = 0; i < Singleton.normaluser.size(); i++) {

						ch = "";
						try {

							ch = ch + (Singleton.normaluser.get(i).toString());
							if (Singleton.normaluser.get(i).getAvatar_icon().equals("icon")) {
								JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
										JOptionPane.INFORMATION_MESSAGE, icon1);
							} else if (Singleton.normaluser.get(i).getAvatar_icon().equals("icon2")) {
								JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
										JOptionPane.INFORMATION_MESSAGE, icon2);
							} else if (Singleton.normaluser.get(i).getAvatar_icon().equals("icon3")) {
								JOptionPane.showMessageDialog(null, ch, Language_user.getInstance().getProperty("read"),
										JOptionPane.INFORMATION_MESSAGE, icon3);
							}
						} catch (Exception e) {

						}

					}

					break;

				case 1:
					location = -1;
					n2 = Functions_find.find_normal_dni();
					if (n2 == null) {
						
					} else {
						location = Functions_find.find_normal(n2);
						if (location != -1) {
							Singleton_menu.n = Singleton.normaluser.get(location);

							if (Singleton_menu.n.getAvatar_icon().equals("icon")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.n.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon1);
							} else if (Singleton_menu.n.getAvatar_icon().equals("icon2")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.n.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon2);
							} else if (Singleton_menu.n.getAvatar_icon().equals("icon3")) {
								JOptionPane.showMessageDialog(null, Singleton_menu.n.toString(),
										Language_user.getInstance().getProperty("read"), JOptionPane.INFORMATION_MESSAGE,
										icon3);
							}

						}
					}

					break;

			}
		}
	}
}
