package exer3_1.Modules.Users.Model.Utils;

import java.text.ParseException;
import exer3_1.Classes.*;
import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Utils.*;

public class Functions_ask_date {

	////Validate Birthdate, +18. Ex:dd/MM/yyyy - dd-MM-yyyy - yyyy-MM-dd - yyyy/MM/dd
	public static date Ask_birthdate(String bdate, int op, int type_user) {
		String bdatev = "";
		boolean validate = true;
		boolean validate2 = false;
		String control = "";
		date fnac = null;
		int c = 0;
		int ysubfnac = 0;
		int ysubfjoin = 0;
		int dsubfnac = 0;
		int dsubfjoin = 0;
		int msubfnac = 0;
		int msubfjoin = 0;
		int y_ok = 0;
		String dateformat = Settings.getInstance().getDateformat();

		if (op == 1) {
			do {
				do {
					if (dateformat.equals("yyyy-mm-dd")) {
						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdate);
						validate = Validate.Validatedate_reverse_hyphen(control);
					}
					if (dateformat.equals("yyyy/mm/dd")) {
						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdate);
						validate = Validate.Validatedate_reverse_slash(control);
					}
					if (dateformat.equals("dd/mm/yyyy")) {
						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdate);
						validate = Validate.Validatedate_slash(control);
					}
					if (dateformat.equals("dd-mm-yyyy")) {
						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdate);
						validate = Validate.Validatedate_hyphen(control);
					}

				} while (validate == false);

				if (validate == true) {
					fnac = new date(control);
					validate2 = fnac.CheckDate();
					c = fnac.CalculateAge();

					if ((validate2 == true) && (((c >= type_user)) || (c < 99))) {

						fnac = new date(control);

						if (Singleton_menu.a instanceof Admin) {
							ysubfnac = fnac.getyear();
							ysubfjoin = Singleton_menu.a.getJoinDate().getyear();
							dsubfnac = fnac.getday();
							dsubfjoin = Singleton_menu.a.getJoinDate().getday();
							msubfnac = fnac.getmonth();
							msubfjoin = Singleton_menu.a.getJoinDate().getmonth();
						}
						if (Singleton_menu.c instanceof Client) {
							ysubfnac = fnac.getyear();
							ysubfjoin = Singleton_menu.c.getJoinDate().getyear();
							dsubfnac = fnac.getday();
							dsubfjoin = Singleton_menu.c.getJoinDate().getday();
							msubfnac = fnac.getmonth();
							msubfjoin = Singleton_menu.c.getJoinDate().getmonth();
						}
						if (Singleton_menu.n instanceof NormalUser) {
							ysubfnac = fnac.getyear();
							ysubfjoin = fnac.currentyear();
							dsubfnac = fnac.getday();
							dsubfjoin = fnac.currentday();
							msubfnac = fnac.getmonth();
							msubfjoin = fnac.currentmonth();
						}
						y_ok = ysubfjoin - ysubfnac;

						if (y_ok < type_user) {
							fnac = null;
						} else if ((y_ok >= type_user) && (dsubfjoin >= dsubfnac) && (msubfjoin >= msubfnac)) {

							fnac = new date(control);

						} else if ((y_ok == type_user) && (dsubfjoin < dsubfnac) && (msubfjoin < msubfnac)) { // year equals 16, day less than fnacday, month less than fnac month

							fnac = null;
						} else if ((y_ok == type_user) && (msubfjoin < msubfnac)) { // y = 16 , m < mbd

							fnac = null;
						} else if ((y_ok == type_user) && (dsubfjoin < dsubfnac) && (msubfjoin == msubfnac)) { // y==16, d< dbd, m==mbd

							fnac = null;
						}

					} else {
						fnac = null;
					}
				}
			} while (fnac == null);
		}

		if (op == 2) {

			if (dateformat.equals("yyyy-mm-dd")) {
				control = Functions.InsertString("", "", op, bdate);
				validate = Validate.Validatedate_reverse_hyphen(bdate);
			}
			if (dateformat.equals("yyyy/mm/dd")) {
				control = Functions.InsertString("", "", op, bdate);
				validate = Validate.Validatedate_reverse_slash(bdate);
			}
			if (dateformat.equals("dd/mm/yyyy")) {
				control = Functions.InsertString("", "", op, bdate);
				validate = Validate.Validatedate_slash(bdate);
			}
			if (dateformat.equals("dd-mm-yyyy")) {
				control = Functions.InsertString("", "", op, bdate);
				validate = Validate.Validatedate_hyphen(bdate);
			}
			bdatev = control + " " + validate;

			if (bdatev.equals("true true")) {

				fnac = new date(bdate);
				validate2 = fnac.CheckDate();
				c = fnac.CalculateAge();
				System.out.println(c + "c");
				if ((validate2 == true) && (((c >= type_user)) && (c < 99))) {

					fnac = new date(bdate);

				} else {
					fnac = null;
				}

			}

		}
		return fnac;
	}

	////Validate Join Date, +16(Admin), +18(Client). Ex:dd/MM/yyyy - dd-MM-yyyy - yyyy-MM-dd - yyyy/MM/dd
	public static date Ask_Joindate(String jdate, int op, date fnac, int type_user) throws ParseException {
		String jdatev = "";
		String bdatev = "";
		boolean validate = true;
		boolean validate2 = true;
		boolean validate3 = true;
		String control = "";
		date fjoin = null;
		int compare_jyearint = 0;
		int ysubfnac = 0;
		int ysubfjoin = 0;
		int dsubfnac = 0;
		int dsubfjoin = 0;
		int msubfnac = 0;
		int msubfjoin = 0;
		int y_ok = 0;
		int c = 0;
		String dateformat = Settings.getInstance().getDateformat();

		if (op == 1) {

			if (Singleton_menu.a instanceof Admin) {
				bdatev = Singleton_menu.a.getBirthdate().getDate();
			} else {
				bdatev = Singleton_menu.a.getBirthdate().getDate();
			}
			do {

				do {
					if (dateformat.equals("yyyy-mm-dd")) {

						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdatev);
						validate = Validate.Validatedate_reverse_hyphen(control);
					}
					if (dateformat.equals("yyyy/mm/dd")) {

						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdatev);
						validate = Validate.Validatedate_reverse_slash(control);
					}
					if (dateformat.equals("dd/mm/yyyy")) {

						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdatev);
						validate = Validate.Validatedate_slash(control);
					}
					if (dateformat.equals("dd-mm-yyyy")) {
						control = Functions.InsertString(Language_user.getInstance().getProperty("date") + dateformat,
								Language_user.getInstance().getProperty("date") + dateformat, op, bdatev);
						validate = Validate.Validatedate_hyphen(control);
					}

				} while (validate == false);

				if (validate == true) {
					fjoin = new date(control);

					validate2 = fjoin.CheckDate();

					compare_jyearint = fjoin.compareDates_currentyear(fjoin);

					if (compare_jyearint == 2) {
						validate3 = true;
					} else {
						validate3 = false;
					}
					if ((validate2 == true) && (validate3 == true)) {

						fnac = new date(bdatev);
						c = fjoin.compareDates(fnac);
						if (c == 2) {
							fjoin = new date(control);
						} else {
							fjoin = null;
						}
					} else {
						fjoin = null;
					}

					if (c == 2) {

						ysubfnac = fnac.getyear();
						ysubfjoin = fjoin.getyear();
						dsubfnac = fnac.getday();
						dsubfjoin = fjoin.getday();
						msubfnac = fnac.getmonth();
						msubfjoin = fjoin.getmonth();
						y_ok = ysubfjoin - ysubfnac;

						if (y_ok < type_user) {
							fjoin = null;

						} else if ((y_ok >= type_user) && (dsubfjoin >= dsubfnac) && (msubfjoin >= msubfnac)) {
							fjoin = new date(control);

						} else if ((y_ok == type_user) && (dsubfjoin < dsubfnac) && (msubfjoin < msubfnac)) { // year equals 16, day less than fnacday, month less than fnac month

							fjoin = null;
						} else if ((y_ok == type_user) && (msubfjoin < msubfnac)) { // y = 16 , m < mbd

							fjoin = null;
						} else if ((y_ok == type_user) && (dsubfjoin < dsubfnac) && (msubfjoin == msubfnac)) { // y==16, d< dbd, m==mbd

							fjoin = null;
						}
					}
				}
			} while (fjoin == null);
		}

		if (op == 2) {
			if (dateformat.equals("yyyy-mm-dd")) {

				control = Functions.InsertString("", "", op, jdate);
				validate = Validate.Validatedate_reverse_hyphen(jdate);
			}
			if (dateformat.equals("yyyy/mm/dd")) {

				control = Functions.InsertString("", "", op, jdate);
				validate = Validate.Validatedate_reverse_slash(jdate);
			}
			if (dateformat.equals("dd/mm/yyyy")) {

				control = Functions.InsertString("", "", op, jdate);
				validate = Validate.Validatedate_slash(jdate);
			}
			if (dateformat.equals("dd-mm-yyyy")) {
				control = Functions.InsertString("", "", op, jdate);
				validate = Validate.Validatedate_hyphen(jdate);
			}

			jdatev = control + " " + validate;

			if (jdatev.equals("true true")) {

				fjoin = new date(jdate);

				validate2 = fjoin.CheckDate();

				if (fjoin.getyear() > fjoin.currentyear()) {
					fjoin = null;
					compare_jyearint = 0;

				} else {

					compare_jyearint = fjoin.compareDates_currentyear(fjoin);
				}

				if ((compare_jyearint == 2) || (compare_jyearint == 3)) {
					validate3 = true;
				} else {
					validate3 = false;
				}

				if ((validate2 == true) && (validate3 == true)) {
					jdatev = control;
					c = fjoin.compareDates(fnac);

					if (c == 2) {

						fjoin = new date(jdate);
					} else {
						fjoin = null;
					}
				} else {
					fjoin = null;
				}
			} else {
				fjoin = null;
			}
			if (c == 2) {
				//fjoin = new date(jdate);
				ysubfnac = fnac.getyear();
				ysubfjoin = fjoin.getyear();
				dsubfnac = fnac.getday();
				dsubfjoin = fjoin.getday();
				msubfnac = fnac.getmonth();
				msubfjoin = fjoin.getmonth();

				y_ok = ysubfjoin - ysubfnac;

				if (y_ok < type_user) {
					fjoin = null;
				} else if ((y_ok >= type_user) && (dsubfjoin >= dsubfnac) && (msubfjoin >= msubfnac)) {

					fjoin = new date(jdate);
				} else if ((y_ok == type_user) && (dsubfjoin < dsubfnac) && (msubfjoin < msubfnac)) { // year equals 16, day less than fnacday, month less than fnac month

					fjoin = null;
				} else if ((y_ok == type_user) && (msubfjoin < msubfnac)) { // y = 16 , d > dnac, m < mnac

					fjoin = null;
				} else if ((y_ok == type_user) && (dsubfjoin < dsubfnac) && (msubfjoin == msubfnac)) {

					fjoin = null;
				}
			}

		}
		return fjoin;
	}
}
