package exer3_1.Modules.Users.Model.Classes;

import exer3_1.Utils.*;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import exer3_1.Classes.Settings;
import exer3_1.Classes.date;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;

/**
 * Class used to create, set, and get Admins
 * 
 * @version 5.1, 15/2/2017
 * @author German Rodriguez
 *
 */
public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6405761194807944923L;
	//// Attributes////
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("username")
	private String username;
	@XStreamAlias("passwd")
	private String passwd;
	@XStreamAlias("salary")
	private String salary;
	@XStreamAlias("joindate")
	private date joindate;
	@XStreamAlias("format")
	private String format;
	@XStreamAlias("decimal")
	private String decimal;

	/**
	 * Attribute of the admins
	 * 
	 * @param email
	 *            Email **@**.**
	 * @param avatar
	 *            No restrictions.
	 * @param username
	 *            Username (Words and numbers)
	 * @param passwd
	 *            Password (Min length: 6, at least one special character and
	 *            one word)
	 * @param salary
	 *            Max Salary: 10 digits
	 * @param joindate
	 *            Join Date, Must be +16
	 */

	//// Methods////

	//// Constructor////
	public Admin(String id, String name, String address, String gender, date birthdate, String email,
			String avatar, String username, String passwd, date joindate) {
		super(id, name, address, gender, birthdate);
		this.email = email;
		this.avatar = avatar;
		this.username = username;
		this.passwd = passwd;
		this.joindate = joindate;
		this.salary = "1000";

	}

	public Admin() {
		super();
	}

	public Admin(String id) {
		super(id);

	}

	public Admin(String email, String a, String b, String c) {
		this.email = email;
	}

	public Admin(String username, String a) {
		this.username = username;

	}

	public Admin(String id, String username, String email) {
		super(id);
		this.username = username;
		this.email = email;
	}

	//// Get////
	public String getEmail() {

		return this.email;
	}

	public String getAvatar() {
		return this.avatar;
	}

	// If the user selects the "default" avatar, the application automatically
	// will recalculate the avatar for him. male -> icon, female -> icon2, other
	// -> icon3
	public String getAvatar_icon() {
		String icon = "";

		if (this.avatar.equals("Avatar1")) {
			icon = "icon";
		} else if (this.avatar.equals("Avatar2")) {
			icon = "icon2";
		} else if (this.getGender().equals("Male")
				|| ((this.getGender().equals("Hombre")) || ((this.getGender().equals("Home"))))) {
			icon = "icon";
		} else if (this.getGender().equals("Female")
				|| ((this.getGender().equals("Mujer")) || ((this.getGender().equals("Dona"))))) {
			icon = "icon2";
		} else if (this.getGender().equals("Other")
				|| ((this.getGender().equals("Otro")) || ((this.getGender().equals("Altre"))))) {
			icon = "icon3";
		}
		return icon;
	}

	public String getUsername() {

		return this.username;
	}

	public String getPassword() {

		return this.passwd;
	}

	/**
	 *
	 * @param salary
	 *            It contains the salary
	 * @return Salary as a string formated in €
	 * 
	 */
	public String get_BasicSalary() {
		int salary = 0;

		salary = Integer.parseInt(this.salary);

		return Format.Formatcoin(salary);

	}

	public int compareTo(User param) { // To sort them by ID
		if (this.getId().compareTo(param.getId()) > 0)
			return 1;
		if (this.getId().compareTo(param.getId()) < 0)
			return -1;
		return 0;
	}

	public int get_Percent_Salary() {

		int percent = 0;

		if (this.getAntiquity() >= 15) {
			percent = 100;
		} else if (this.getAntiquity() >= 10) {
			percent = 75;
		} else if (this.getAntiquity() >= 5) {
			percent = 50;
		} else {
			percent = 0;

		}

		return percent;
	}

	public String get_Total_Salary() {

		float salary2 = 0f;
		String salaryt = "";

		salary2 = Float.parseFloat(this.salary);

		if (this.getAntiquity() >= 15) {
			salaryt = Format.Formatcoin(salary2 * 4);
		} else if (this.getAntiquity() >= 10) {
			salaryt = Format.Formatcoin(salary2 * 3);
		} else if (this.getAntiquity() >= 5) {
			salaryt = Format.Formatcoin(salary2 * 2);
		} else {
			salaryt = Format.Formatcoin(salary2);
		}

		return salaryt;
	}

	public String get_BasicSalarywithoutformat() {

		return this.salary;
	}

	public date getJoinDate() {

		return this.joindate;
	}

	/**
	 *
	 * @param antiquityv
	 *            Contains the antiquity of the admin. Join date substracted
	 *            from the current year.
	 * @return antiquityv returned as an int.
	 * 
	 */

	public String getAntiquityString() {
		int antiquityv = 0;
		String ant = "";

		antiquityv = this.joindate.CalculateAge();
		ant = String.valueOf(antiquityv);

		return ant;
	}

	public int getAntiquity() {
		int antiquityv = 0;

		antiquityv = this.joindate.CalculateAge();

		return antiquityv;
	}

	//// Set////
	public void setEmail(String email) {
		this.email = email;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String passwd) {

		this.passwd = passwd;
	}

	public void setJoinDate(date joindate) {

		this.joindate = joindate;
	}

	public boolean equals_username(Object param) {
		return getUsername().equals(((Admin) param).getUsername());
	}

	public boolean equals_email(Object param) {
		return getEmail().equals(((Admin) param).getEmail());
	}

	/**
	 * @return ch is a chain that contains every data of the user inserted
	 *         before. Join date get from the method getDate. Antiquity percent
	 *         calculated depending on the antiquity
	 */
	//// ToString////
	public String toString() {
		String ch = "";

		String userdir = System.getProperty("user.dir");

		ch = ch + " " + Language_user.getInstance().getProperty("theuser") + " ("
				+ Language_user.getInstance().getProperty("admin") + ") "
				+ Language_user.getInstance().getProperty("called") + this.getName() + " "
				+ Language_user.getInstance().getProperty("withtheid") + this.getId();
		ch = ch + "\n " + Language_user.getInstance().getProperty("age") + this.getAge() + " "
				+ Language_user.getInstance().getProperty("yearsold");
		ch = ch + "\n " + Language_user.getInstance().getProperty("birthdate") + this.getBirthdate().getDate();
		ch = ch + "\n " + Language_user.getInstance().getProperty("gender_tostring") + this.getGender();
		ch = ch + "\n " + Language_user.getInstance().getProperty("address") + this.getAddress();
		ch = ch + "\n " + Language_user.getInstance().getProperty("avatar_tostring") + userdir
				+ "/src/exer3_1/Modules/\n Menu/Avatars/" + this.getAvatar();
		ch = ch + "\n " + Language_user.getInstance().getProperty("email_tostring") + this.email;
		ch = ch + "\n " + Language_user.getInstance().getProperty("username_tostring") + this.username + "\n "
				+ Language_user.getInstance().getProperty("password_tostring") + this.passwd;
		ch = ch + "\n " + Language_user.getInstance().getProperty("salary") + this.get_Total_Salary();
		ch = ch + "\n " + Language_user.getInstance().getProperty("joindate_tostring") + this.getJoinDate().getDate();
		ch = ch + "\n " + Language_user.getInstance().getProperty("antiquity_tostring") + this.getAntiquity() + " "
				+ Language_user.getInstance().getProperty("years") + ((this.getAntiquity() == 1) ? "" : "s");
		ch = ch + "\n " + Language_user.getInstance().getProperty("%antiquity") + this.get_Percent_Salary() + " %";
		ch = ch + "\n " + Language_user.getInstance().getProperty("resolution_tostring")
				+ Settings.getInstance().getResolution();
		return ch;
	}

}
