package exer3_1.Utils;

public class Validate {

	//Only words
	public static boolean Validatename(String name) {

		return name.matches("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*");
	}

	//0-999
	public static boolean Validatepoints(String points) {
		return points.matches("^([1-9][0-9][0-9]?)$");
	}

	public static boolean Validatecomments(String comments) {
		return comments.matches("[0-9][0-9]*");
	}

	public static boolean Validatepurchases(String purchases) {
		return purchases.matches("[0-9][0-9]*");
	}

	//****@***.com
	public static boolean Validateemail(String email) {
		return email.matches(
				"^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
	}

	//Words and numbers, username length >=3
	public static boolean Validateusername(String username) {
		return username.matches("^[a-zA-Z0-9._-]{3,}$");
	}

	//(0-9), (a-z), no white space, minim length 6
	public static boolean Validatepasswd(String passwd) {
		return passwd.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\s]).{6,16}");
	}

	//Validate an id number
	public static boolean Validateid(String id) {

		boolean val = true;
		String id2 = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
		int ID = 0, module = 0;
		char let = ' ';
		char word = ' ';

		if (id.matches("(\\d{8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])")) {

			for (int i = 0; i < 8; i++)
				id2 += id.charAt(i);
			word = id.charAt(8);
			ID = Integer.parseInt(id2);
			module = ID % 23;
			let = caracteres.charAt(module);
			if (let == word)
				val = true;
			else
				val = false;
		} else {
			val = false;
		}

		return val;

	}

	//Validate Salary
	public static boolean Validatesalary(String salary) {

		return salary.matches("^([0-9].[0-9]{0,5}|[1-9][0-9]{0,2}.{0,1}[0-9]{0,5})$");

	}

	//Validate a date, dd/mm/yyyy
	public static boolean Validatedate_slash(String date) {

		return date.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");

	}

	//Validate a date, dd-mm-yyyy
	public static boolean Validatedate_hyphen(String date) {

		return date.matches("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");

	}

	//Validate a date, dd-mm-yyyy
	public static boolean Validatedate_reverse_slash(String date) {

		return date.matches("((19|20)\\d\\d)/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])");

	}

	//Validate a date, dd-mm-yyyy
	public static boolean Validatedate_reverse_hyphen(String date) {

		return date.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");

	}

	//Validate a resolution

	public static boolean Validate_resolution(String res) {
		return res.matches("[0-9]{0,4}x[0-9]{0,4}");

	}

}
