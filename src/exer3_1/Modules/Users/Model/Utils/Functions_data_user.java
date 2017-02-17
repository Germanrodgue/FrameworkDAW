package exer3_1.Modules.Users.Model.Utils;

import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Utils.*;

public class Functions_data_user {

	public static Admin ask_adminEmail() {

		Singleton.Email = Functions_data_user.Ask_email("", 1);

		return new Admin(Singleton.Email);
	}

	public static Admin ask_adminDNI() {

		Singleton.DNI = Functions_data_user.Ask_id("", 1);

		return new Admin(Singleton.DNI);
	}

	public static Client ask_clientDNI() {

		Singleton.DNI = Functions_data_user.Ask_id("", 1);

		return new Client(Singleton.DNI);
	}

	public static NormalUser ask_normalDNI() {

		Singleton.DNI = Functions_data_user.Ask_id("", 1);

		return new NormalUser(Singleton.DNI);
	}

	//// Validate a Name, Only words
	public static String Ask_name(String name, int op) {
		String namev = "";
		boolean validate = true;
		String control = "";

		if (op == 1) {
			do {
				control = Functions.InsertString(Language_user.getInstance().getProperty("insertname"),
						Language_user.getInstance().getProperty("insertname"), op, name);
				validate = Validate.Validatename(control);

				if (validate == true) {
					namev = control;
				} else {
					namev = "false";
				}
			} while (namev == "false");
		}

		if (op == 2) {
			control = Functions.InsertString("", "", op, name);
			validate = Validate.Validatename(name);
			namev = control + " " + validate;
		}

		return namev;
	}

	//// Validate a Name, Only words
	public static String Ask_address(String address, int op) {
		String namev = "";
		boolean validate = true;
		String control = "";

		if (op == 1) {
			do {
				control = Functions.InsertString(Language_user.getInstance().getProperty("address"),
						Language_user.getInstance().getProperty("address"), op, address);
				validate = Validate.Validatename(control);

				if (validate == true) {
					namev = control;
				} else {
					namev = "false";
				}
			} while (namev == "false");
		}

		if (op == 2) {
			control = Functions.InsertString("", "", op, address);
			validate = Validate.Validatename(address);
			namev = control + " " + validate;
		}

		return namev;
	}

	//// Validate Points, max 99 points
	public static int Ask_points(String points, int op) {
		int pointsv = 0;
		int control = 0;
		boolean validate = true;

		if (op == 1) {
			do {
				control = Functions.InsertInt("Insert the points (Max: 99 points)",
						"Insert the points (Max: 100 points)", op, points);
				points = Integer.toString(control);
				validate = Validate.Validatepoints(points);

				if (validate == true) {
					pointsv = control;
				} else {
					pointsv = 1;
				}
			} while (pointsv == 1);

		}

		if (op == 2) {
			control = Functions.InsertInt("", "", op, points);

			validate = Validate.Validatepoints(points);
			if (validate == true) {
				pointsv = control + 1;
			} else {
				pointsv = 0;
			}
		}
		return pointsv;
	}

	public static int Ask_Comments(String comments, int op) {
		int commentsv = 0;
		int control = 0;
		boolean validate = true;

		if (op == 1) {
			do {
				control = Functions.InsertInt(Language_user.getInstance().getProperty("insertcomments"),
						Language_user.getInstance().getProperty("insertcomments"), op, comments);
				comments = Integer.toString(control);
				validate = Validate.Validatecomments(comments);

				if (validate == true) {
					commentsv = control;
				} else {
					commentsv = 1;
				}
			} while (commentsv == 1);

		}

		if (op == 2) {
			control = Functions.InsertInt("", "", op, comments);

			validate = Validate.Validatecomments(comments);
			if (validate == true) {
				commentsv = control + 1;
			} else {
				commentsv = 0;
			}
		}
		return commentsv;
	}

	public static int Ask_Purchases(String purchases, int op) {
		int purchasesv = 0;
		int control = 0;
		boolean validate = true;

		if (op == 1) {
			do {
				control = Functions.InsertInt(Language_user.getInstance().getProperty("insertpurchases"),
						Language_user.getInstance().getProperty("insertpurchases"), op, purchases);
				purchases = Integer.toString(control);
				validate = Validate.Validatecomments(purchases);

				if (validate == true) {
					purchasesv = control;
				} else {
					purchasesv = 1;
				}
			} while (purchasesv == 1);

		}

		if (op == 2) {
			control = Functions.InsertInt("", "", op, purchases);

			validate = Validate.Validatecomments(purchases);
			if (validate == true) {
				purchasesv = control + 1;
			} else {
				purchasesv = 0;
			}
		}
		return purchasesv;
	}

	//// Validate Salary
	public static int Ask_salary(String salary, int op) {
		int salaryv = 0;
		int control = 0;
		boolean validate = true;

		if (op == 1) {
			do {
				control = Functions.InsertInt("Insert the salary (Max: 1.000€)", "Insert the salary (Max: 1.000€)", op,
						salary);
				salary = Integer.toString(control);
				validate = Validate.Validatesalary(salary);

				if (validate == true) {
					salaryv = control;

				} else {
					salaryv = 1;
				}
			} while (salaryv == 1);
		}

		if (op == 2) {
			control = Functions.InsertInt("", "", op, salary);

			validate = Validate.Validatesalary(salary);

			if (validate == true) {
				salaryv = control + 1;
			} else {
				salaryv = 0;
			}
		}
		return salaryv;
	}

	//// Validate email, **@**.**
	public static String Ask_email(String email, int op) {
		String emailv = "";
		boolean validate = true;
		String control = "";
		if (op == 1) {
			do {
				control = Functions.InsertString(Language_user.getInstance().getProperty("insertmail"),
						Language_user.getInstance().getProperty("insertmail"), op, email);
				validate = Validate.Validateemail(control);
				if (validate == true) {
					emailv = control;
				} else {
					emailv = "false";
				}
			} while (emailv == "false");
		}

		if (op == 2) {
			control = Functions.InsertString("", "", op, email);
			validate = Validate.Validateemail(email);

			emailv = control + " " + validate;

		}
		return emailv;
	}

	//// Validate username, no symbols
	public static String Ask_username(String username, int op) {
		String usernamev = "";
		boolean validate = true;
		String control = "";

		if (op == 1) {
			do {
				control = Functions.InsertString(Language_user.getInstance().getProperty("insertun"),
						Language_user.getInstance().getProperty("insertun"), op, username);
				validate = Validate.Validateusername(control);

				if (validate == true) {
					usernamev = control;
				} else {
					usernamev = "false";
				}
			} while (usernamev == "false");
		}

		if (op == 2) {
			control = Functions.InsertString("", "", op, username);
			validate = Validate.Validateusername(username);
			usernamev = control + " " + validate;

		}
		return usernamev;
	}

	//// Validate password, min length 6, at least one special symbol and one
	//// word
	public static String Ask_passwd(String passwd, int op) {
		String passwdv = "";
		boolean validate = true;
		String control = "";

		if (op == 1) {
			do {
				control = Functions.InsertString(Language_user.getInstance().getProperty("insertpasswd"),
						Language_user.getInstance().getProperty("insertpasswd"), op, passwd);
				validate = Validate.Validatepasswd(control);

				if (validate == true) {
					passwdv = control;
				} else {
					passwdv = "false";
				}
			} while (passwdv == "false");
		}

		if (op == 2) {
			control = Functions.InsertString("", "", op, passwd);
			validate = Validate.Validatepasswd(passwd);
			passwdv = control + " " + validate;

		}
		return passwdv;
	}

	//// Validate id, 11111111X
	public static String Ask_id(String id, int op) {
		String idv = "";
		boolean validate = true;
		String control = "";

		if (op == 1) {
			do {
				control = Functions.InsertString(Language_user.getInstance().getProperty("insertid"),
						Language_user.getInstance().getProperty("insertid"), op, id);
				control = control.toUpperCase();

				validate = Validate.Validateid(control);
				if (validate == true) {
					idv = control;
				} else {
					idv = "false";
				}
			} while (idv == "false");
		}
		if (op == 2) {
			control = Functions.InsertString("", "", op, id);
			validate = Validate.Validateid(id);
			idv = control + " " + validate;

		}
		return idv;
	}
}
