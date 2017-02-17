package exer3_1.Modules.Users.Model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import exer3_1.Classes.*;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Utils.Format;

/**
 * Class used to create, set, and get Clients
 * 
 * @version 5.1, 15/2/2017
 * @author German Rodriguez
 *
 */
public class Client extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3012030717140003063L;
	//// Attributes////
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("username")
	private String username;
	@XStreamAlias("passwd")
	private String passwd;
	@XStreamAlias("points")
	private String points;
	@XStreamAlias("jdate")
	private date jdate;
	@XStreamAlias("purchases")
	private int purchases;
	@XStreamAlias("discounts")
	private String discounts;

	/**
	 * Attribute of the clients
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
	 * @param points
	 *            Max points: 999 points
	 * @param joindate
	 *            Join Date, Must be +18
	 */

	//// Methods////

	//// Constructor////
	public Client(String id, String name, String address, String gender, date birthdate, String email,
			String avatar, String username, String passwd, int purchases, date jdate) {
		super(id, name, address, gender, birthdate);
		this.email = email;
		this.avatar = avatar;
		this.username = username;
		this.passwd = passwd;
		this.jdate = jdate;
		this.purchases = purchases;

	}

	public Client() {
		super();
	}

	public Client(String id) {
		super(id);

	}

	public Client(String email, String a, String b, String c) {
		this.email = email;
	}

	public Client(String username, String a) {
		this.username = username;

	}

	public Client(String id, String username, String email) {
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

	public String getPoints_Purchases() {

		if (this.getPurchases() > 0 && (this.getPurchases() <= 100)) {
			this.points = "50";
		} else if (this.getPurchases() > 100 && (this.getPurchases() <= 200)) {
			this.points = "150";
		} else if (this.getPurchases() > 200) {
			this.points = "200";
		} else {
			this.points = "0";
		}

		return this.points;
	}

	public String get_TotalPoints() {

		float sum_points = 0f;
		float pointsv = 0f;
		String points = "";

		sum_points = this.get_Free_Points();
		pointsv = Float.parseFloat(this.getPoints_Purchases());

		if (this.getAntiquity() >= 5) {
			pointsv = (float) (pointsv + sum_points);
			points = Format.Formatdecimal(pointsv);
		} else if (this.getAntiquity() >= 3) {
			pointsv = (float) (pointsv + sum_points);
			points = Format.Formatdecimal(pointsv);
		} else if (this.getAntiquity() >= 1) {
			pointsv = (float) (pointsv + sum_points);
			points = Format.Formatdecimal(pointsv);
		} else {
			points = "0";
		}

		return points;
	}

	public float get_Free_Points() {
		float sum_points = 0f;

		if (this.getAntiquity() >= 5) {
			sum_points = 50;
		} else if (this.getAntiquity() >= 3) {
			sum_points = 25;
		} else if (this.getAntiquity() >= 1) {
			sum_points = 12.5f;
		} else {
			sum_points = 0f;
		}

		return sum_points;
	}

	public String getDiscounts() {

		System.out.println(this.getPoints_Purchases());
		if (this.getPoints_Purchases().equals("50")) {
			this.discounts = "10%";
		} else if (this.getPoints_Purchases().equals("150")) {
			this.discounts = "20%";
		} else if (this.getPoints_Purchases().equals("200")) {
			this.discounts = "30%";
		} else {
			this.discounts = "0%";
		}

		return this.discounts;
	}

	public int getPurchases() {

		return this.purchases;
	}

	public String getPurchasesString() {

		String purch = "";
		purch = String.valueOf(this.purchases);

		return purch;
	}

	public date getJoinDate() {

		return this.jdate;
	}

	/**
	 *
	 * @param antiquityv
	 *            Contains the antiquity of the admin. Join date substracted
	 *            from the current year.
	 * @return antiquityv returned as an int.
	 * 
	 */
	public int getAntiquity() {

		int antiquityv = 0;

		antiquityv = this.jdate.CalculateAge();

		return antiquityv;
	}

	public boolean equals_username(Object param) {
		return getUsername().equals(((Client) param).getUsername());
	}

	public boolean equals_email(Object param) {
		return getEmail().equals(((Client) param).getEmail());
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

	public void setPoints(String points) {
		this.points = points;
	}

	public void setJoinDate(date jdate) {

		this.jdate = jdate;
	}

	public void setPurchases(int purchases) {

		this.purchases = purchases;
	}

	public int compareTo(User param) { // To sort them by ID
		if (this.getId().compareTo(param.getId()) > 0)
			return 1;
		if (this.getId().compareTo(param.getId()) < 0)
			return -1;
		return 0;
	}

	/**
	 *
	 * @return ch is a chain that contains every data of the user inserted
	 *         before. Join date is get from the method getDate and the free
	 *         points are calculated depending on the user's antiquity.
	 * 
	 */
	//// ToString////
	public String toString() {
		String ch = "";
		String userdir = System.getProperty("user.dir");

		ch = ch + " " + Language_user.getInstance().getProperty("theuser") + " ("
				+ Language_user.getInstance().getProperty("client") + ") "
				+ Language_user.getInstance().getProperty("called") + this.getName() + " "
				+ Language_user.getInstance().getProperty("withtheid") + this.getId();
		ch = ch + "\n " + Language_user.getInstance().getProperty("age") + this.getAge() + " "
				+ Language_user.getInstance().getProperty("yearsold");
		ch = ch + "\n " + Language_user.getInstance().getProperty("birthdate") + this.getBirthdate().getDate();
		ch = ch + "\n " + Language_user.getInstance().getProperty("gender_tostring") + this.getGender();
		ch = ch + "\n " + Language_user.getInstance().getProperty("address") + this.getAddress();
		ch = ch + "\n " + Language_user.getInstance().getProperty("avatar_tostring") + userdir
				+ "/src/exer3_1/Modules/\n Menu/Avatars/" + this.avatar;
		ch = ch + "\n " + Language_user.getInstance().getProperty("email_tostring") + this.email;
		ch = ch + "\n " + Language_user.getInstance().getProperty("username_tostring") + this.username + "\n "
				+ Language_user.getInstance().getProperty("password_tostring") + this.passwd;
		ch = ch + "\n " + Language_user.getInstance().getProperty("purchases") + this.getPurchases();
		ch = ch + "\n " + Language_user.getInstance().getProperty("points_tostring") + this.get_TotalPoints();
		ch = ch + "\n " + Language_user.getInstance().getProperty("joindate_tostring") + this.getJoinDate().getDate();
		ch = ch + "\n " + Language_user.getInstance().getProperty("antiquity_tostring") + this.getAntiquity() + " "
				+ Language_user.getInstance().getProperty("years") + ((this.getAntiquity() == 1) ? "" : "s");
		ch = ch + "\n " + Language_user.getInstance().getProperty("antiquity_freepoints") + this.get_Free_Points() + " "
				+ Language_user.getInstance().getProperty("points");
		ch = ch + "\n " + Language_user.getInstance().getProperty("discounts") + this.getDiscounts();
		ch = ch + "\n " + Language_user.getInstance().getProperty("resolution_tostring")
				+ Settings.getInstance().getResolution();
		return ch;
		// Language_user.getInstance().getProperty("discounts")
	}

}