package exer3_1.Modules.Users.Model.BLL.BLL_Dummies;

import java.util.Random;
import exer3_1.Classes.date;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;

public class Functions_dummies {
	/*
	 * Automatic dummies
	 */
	public static String dni(int dni) {

		String dni2 = String.valueOf(dni);

		if (dni2.length() == 7) {
			dni2 += '9';
		}
		int dni1 = Integer.parseInt(dni2);

		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
		return String.valueOf(dni1) + NIF_STRING_ASOCIATION.charAt(dni1 % 23);
	}

	public static String ID() {
		String cad = "";
		long time = new java.util.GregorianCalendar().getTimeInMillis();
		Random random = new Random(time);

		while (cad.length() < 8) {
			char c = (char) random.nextInt(255);
			if ((c >= '0' && c <= '9')) {
				cad += c;
			}
		}
		int numberdni = Integer.parseInt(cad);
		return dni(numberdni);
	}

	public static String user() {
		String user = "";
		String[] users = { "vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe", "jaume",
				"sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina", "pepe", "oscar",
				"lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria", "elena", "beltran",
				"pablo", "juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return user = users[position];
	}

	public static String gender() {
		String gender = "";
		String[] gender2 = { "Male", "Female", "Other" };

		int position = (int) (Math.random() * 3) % 10;
		System.out.println(position);
		return gender = gender2[position];
	}

	public static String pass() {
		String pass = "";
		String[] passwords = { "vicent123!", "walter67.", "1245jX.", "maria11,", "daniel34Z$", "josep445&", "saraL!",
				"pepa1232·", "felipe3·", "jaume23%", "sergio45·", "paco123!", "emilio11!1", "nando55!", "alfon45!s",
				"eduard123!", "atalia123·", "veronica!3", "fina123!", "pepe123/", "oscard3!", "lorelay4$", "jim4·",
				"lola123@", "laiax3!", "ismael23!", "jordi123!", "ramon55!", "javier2!", "nuria23!", "elena5!",
				"beltran52!", "pablo67!", "juanjo23!" };

		int position = (int) (Math.random() * 222) % 10;
		return pass = passwords[position];
	}

	public static String avatar() {
		String avatar = "";
		String[] avatars = { "Avatar1", "Avatar2", "Default" };

		int position = (int) (Math.random() * 3) % 10;
		return avatar = avatars[position];
	}

	public static String name() {
		String name = "";
		String[] names = { "vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe", "jaume",
				"sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina", "pepe", "oscar",
				"lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria", "elena", "beltran",
				"pablo", "juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return name = names[position];
	}

	public static String email() {
		String email = "";
		String[] emails = { "vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe", "jaume",
				"sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina", "pepe", "oscar",
				"lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria", "elena", "beltran",
				"pablo", "juanjo" };

		int position = (int) (Math.random() * 222) % 10;
		return email = emails[position] + "@gmail.com";
	}

	public static date datebirthday() {
		String[] years = { "19", "20" };
		int year3 = 0;
		int day = 0;
		int currentyear = 0;
		int month = 0;

		date d = null;

		day = (int) (Math.random() * (1 - 31) + 31);
		month = (int) (Math.random() * (1 - 12) + 12);
		do {
			year3 = (int) (Math.random() * (2000 - 1940) + 1940);
			d = new date(day, month, year3);
			currentyear = d.CalculateAge();
		} while (currentyear < 16);

		return new date(day, month, year3);
	}

	public static date datecontract() {
		String[] years = { "19", "20" };
		int year3 = 0;
		int day = 0;
		int month = 0;
		date d = datebirthday();

		day = (int) (Math.random() * (1 - 31) + 31);
		month = (int) (Math.random() * (1 - 12) + 12);
		year3 = 2013;

		return new date(day, month, year3);
	}

	public static int purchases() {
		int point = (int) (Math.random() * (5 - 50) + 50);
		return (int) Math.rint(point * 1000) / 100;
	}

	public static int comments() {
		int point = (int) (Math.random() * (5 - 50) + 50);
		return (int) Math.rint(point * 350) / 100;
	}

	/*
	 * As i don't use a regExp on the address i kept that field empty
	 * 
	 */
	public static void makedummies_admin() {
		for (int i = 0; i < 1; i++) {

			Admin a1 = new Admin(ID(), name(), "", gender(), datebirthday(), email(), avatar(), user(), pass(),
					datecontract());
			Singleton.adminuser.add(a1);
		}
	}

	public static void makedummies_client() {
		for (int i = 0; i < 1; i++) {

			Client c1 = new Client(ID(), name(), "", gender(), datebirthday(), email(), avatar(), user(), pass(),
					purchases(), datecontract());

			Singleton.clientuser.add(c1);
		}
	}

	public static void makedummies_normal() {
		for (int i = 0; i < 1; i++) {

			NormalUser u1 = new NormalUser(ID(), name(), "", gender(), datebirthday(), comments());
			Singleton.normaluser.add(u1);
		}
	}
}
